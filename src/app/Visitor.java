package app;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.Trees;
import app.alParser.*;

public class Visitor extends alBaseVisitor<String> {
    private int LblCount;
    private int TmpCount;
    private String previousTmp;
    private String currentTmp;
    private String code;
    private int identation;
    private boolean addTmp = false;
    private boolean auxTmp;

    private HashMap<String, String> opposites;
    private String[] logicalOperators;

    public Visitor() {
        this.LblCount = 0;
        this.TmpCount = 0;
        this.identation = 1;
        this.code = "";
        this.previousTmp = "";
        this.currentTmp = "";
        this.auxTmp  = false;
        this.logicalOperators = new String[]{"&&", "||"};
        loadOpposites();
    }

    private void loadOpposites() {
        this.opposites = new HashMap<String, String>() {{
            put("<", ">=");
            put(">", "<=");
            put("<=", ">");
            put(">=", "<");
            put("==", "!=");
            put("!=", "==");
        }};
    }

    private List<ParseTree> getNodes(ParseTree ctx, int ruleIndex) {
        return new ArrayList<ParseTree>(Trees.findAllRuleNodes(ctx, ruleIndex));
    }

    private List<ParseTree> getComparisons(ParseTree ctx) {
        //there's no &&
        if (Trees.findAllTokenNodes(ctx, alParser.AND).size() == 0){
            //there's no ||
            if (Trees.findAllTokenNodes(ctx, alParser.OR).size() == 0){
                return new ArrayList<ParseTree>(Trees.findAllRuleNodes(ctx, alParser.RULE_comparaciones));
            } else{
                return new ArrayList<ParseTree>(Trees.findAllTokenNodes(ctx, alParser.OR));
            }
        } else{
            return new ArrayList<ParseTree>(Trees.findAllTokenNodes(ctx, alParser.AND));
        }
    }

    @Override
    public String visitAsignacion(AsignacionContext ctx) {
        List<ParseTree> factores = getNodes(ctx, alParser.RULE_factor);
        if (factores.size() <= 2) {
            List<ParseTree> opals = getComparisons(ctx);
            this.code += "\t".repeat(this.identation) + ctx.ID().getText() + " = ";
            add2Factors(factores, opals);
        } else{
            OpalContext opalCtx = ctx.asign().operacion().opal();
            processOpal(opalCtx);
            this.code += "\t".repeat(this.identation) + ctx.ID().getText() + " = t" + (TmpCount - 1) + "\n";
        }
        return null;
    }

    public static String getLastLine(String string) {
        List<String> lines = Arrays.asList(string.split("\n"));
        return lines.subList(Math.max(0, lines.size() - 1), lines.size()).get(0);
    }

    @Override
    public String visitDeclaracion(DeclaracionContext ctx) {
        if (ctx.asignacion() != null) {
            List<ParseTree> factores = getNodes(ctx, alParser.RULE_factor);
            /* if (factores.size() <= 2) {
                List<ParseTree> opals = getComparisons(ctx);
                this.code += "\t".repeat(this.identation) + ctx.asignacion().ID().getText() + " = ";
                add2Factors(factores, opals);
            } else{ */
                OpalContext opalCtx = ctx.asignacion().asign().operacion().opal();
                processOpal(opalCtx);
                String lastLine = getLastLine(code);
                String newVarible = "\n\t".repeat(this.identation) + ctx.asignacion().ID().getText() + " " + lastLine.substring(lastLine.indexOf("="));
                removeLastLine();
                this.code += newVarible;
                //System.out.println(lastLine.substring(lastLine.indexOf("=")));
                //this.code += "\t".repeat(this.identation) + ctx.asignacion().ID().getText() + " = t" + (TmpCount - 1) + "\n";
            /* } */
        }
        return null;
    }
    
    private void removeLastLine(){
        int truncateIndex = this.code.length();
        for (int i = 0; i < 2; i++) {
            truncateIndex = this.code.lastIndexOf('\n', truncateIndex - 1);
        }
        this.code = this.code.substring(0, truncateIndex);
    }
    
    public void findRuleNodes(ParseTree t, int index, List<ParseTree> nodes) {
        if (t instanceof ParserRuleContext) {
            ParserRuleContext ctx = (ParserRuleContext) t;
            if (ctx.getRuleIndex() == index) {
                nodes.add(t);
            }
        }
        // check children
        for (int i = 0; i < t.getChildCount(); i++) {
            if (!(t.getChild(i) instanceof OpalContext)) {
                findRuleNodes(t.getChild(i), index, nodes);
            }
        }
    }

    private List<ParseTree> separateOR(ParseTree t){
        List<ParseTree> nodes = new ArrayList<ParseTree>();   
        List<ParseTree> aux = getNodes(t, alParser.RULE_disyuncion);
        List<ParseTree> opals = getNodes(t, alParser.RULE_factor); // factors enclosed in parentheses, such as ((1+2)+3)
        int count = 0;
        for (int i = 0; i < opals.size(); i++) {
            if (((FactorContext) opals.get(i)).PA() != null){
                count++;
            }
        }
        // need to get the amount of params used, cause they're included
        int params = Trees.findAllRuleNodes(t, alParser.RULE_parametros).size();
        params = aux.size() == params ? 0 : params;
        for (int i = 0; i < aux.size() - params - count; i++) {
            if (aux.get(i).getChild(0) instanceof DisyuncionContext){
                nodes.add(((DisyuncionContext) aux.get(i)).conjuncion());
            } else{
                nodes.add(aux.get(i));
            }
        }
        Collections.reverse(nodes);
        return nodes;
    }

    private List<ParseTree> separateAND(ParseTree t){
        List<ParseTree> nodes = new ArrayList<ParseTree>();
        List<ParseTree> aux = getNodes(t, alParser.RULE_conjuncion);
        List<ParseTree> opals = getNodes(t, alParser.RULE_factor); // factors enclosed in parentheses, such as ((1+2)+3)
        int count = 0;
        for (int i = 0; i < opals.size(); i++) {
            if (((FactorContext) opals.get(i)).PA() != null){
                count++;
            }
        }
        int params = Trees.findAllRuleNodes(t, alParser.RULE_parametros).size();
        params = aux.size() == params ? 0 : params;
        for (int i = 0; i < aux.size() - params - count; i++) {
            if (aux.get(i).getChild(i) instanceof ConjuncionContext){
                nodes.add(((ConjuncionContext) aux.get(i)).igualdad());
            } else{
                nodes.add(aux.get(i));
            }
        }
        Collections.reverse(nodes);
        return nodes;
    }

    private List<ParseTree> separateComparisons(ParseTree t){
        List<ParseTree> nodes = new ArrayList<ParseTree>();
        List<ParseTree> aux = getNodes(t, alParser.RULE_igualdad);
        List<ParseTree> opals = getNodes(t, alParser.RULE_factor); // factors enclosed in parentheses, such as ((1+2)+3)
        int count = 0;
        for (int i = 0; i < opals.size(); i++) {
            if (((FactorContext) opals.get(i)).PA() != null){
                count++;
                count += getNodes(opals.get(i), alParser.RULE_comparaciones).size();
            }
        }
        int params = Trees.findAllRuleNodes(t, alParser.RULE_parametros).size();
        params = aux.size() == params ? 0 : params;
        for (int i = 0; i < aux.size() - params - count; i++) {
            if (aux.get(i).getChild(0) instanceof IgualdadContext){
                nodes.add(((IgualdadContext) aux.get(i)).expresion());
            } else{
                nodes.add(aux.get(i));
            }
        }
        Collections.reverse(nodes);
        return nodes;
    }

    // TREAT ||, first we need to separate operations by ||
    private void processOpal(OpalContext ctx) {
        String operator = "||";
        List<ParseTree> terminos = separateOR(ctx);
        String temp;
        for (int i = 0; i < terminos.size(); i++) {
            temp = currentTmp;
            divideAND(terminos.get(i));
            previousTmp = temp;
            if (i > 0) {
                concatTemps(operator);
            }
        }
    }

    // TREAT &&, then we separate by &&
    private void divideAND(ParseTree ctx) {
        String operator = "&&";
        List<ParseTree> terminos = separateAND(ctx);
        String temp;
        for (int i = 0; i < terminos.size(); i++) {
            temp = currentTmp;
            divideComparisons(terminos.get(i));
            previousTmp = temp;
            if (i > 0) {
                concatTemps(operator);
            }
        }
    }

    //TREAT ==, !=, <, >, <=, >=
    private void divideComparisons(ParseTree ctx) {
        List<ParseTree> terminos = separateComparisons(ctx);
        String temp;
        for (int i = 0; i < terminos.size(); i++) {
            temp = currentTmp;
            processTerms(terminos.get(i));
            previousTmp = temp;
            if (i > 0) {
                String operator = terminos.get(i).getParent().getChild(1).getText();
                concatTemps(operator);
            }
        }
    }

    private void processTerms(ParseTree ctx) {
        List<ParseTree> ruleTerms = new ArrayList<ParseTree>();
        findRuleNodes(ctx, alParser.RULE_termino, ruleTerms);
        List<ParseTree> terms = new ArrayList<ParseTree>(ruleTerms);
        String temp;
        for (int i = 0; i < terms.size(); i++) {
            List<ParseTree> factors = new ArrayList<ParseTree>();
            findRuleNodes(terms.get(i), alParser.RULE_factor, factors);
            if (factors.size() > 1) {
                temp = currentTmp;
                processFactors(factors);
                previousTmp = temp;
                currentTmp = "t" + (TmpCount - 1);
            } else {
                previousTmp = currentTmp;
                if (((TerminoContext) terms.get(i)).factor().opal() != null) {
                    temp = currentTmp;
                    processOpal(((TerminoContext) terms.get(i)).factor().opal());
                    previousTmp = temp;
                } else if (((TerminoContext) terms.get(i)).factor().funcion() != null){
                    temp = currentTmp;
                    addTmp = true;
                    visitFuncion(((TerminoContext) terms.get(i)).factor().funcion());
                    addTmp = false;
                    previousTmp = temp;
                    currentTmp = "t" + (TmpCount - 1);
                } else {
                    currentTmp = factors.get(0).getText();
                }
            }
            if(i > 0){ 
                concatTemps(terms.get(i).getParent().getChild(0).getText());
            }
        }
    }

    private void concatTemps(String operation) {
        this.code += "\t".repeat(this.identation);
        this.code += String.format("t%d = %s %s %s \n", TmpCount, previousTmp, operation, currentTmp);
        currentTmp = "t" + TmpCount;
        TmpCount++;
    }

    private void processFactors(List<ParseTree> factors) {
        String temp;
        for(int i=0; i < factors.size(); i++) {
            if(((FactorContext)factors.get(i)).opal() != null) {
                temp = currentTmp;
                processOpal(((FactorContext) factors.get(i)).opal());
                previousTmp = temp;
            }  else if (((FactorContext) factors.get(i)).funcion() != null){
                temp = currentTmp;
                addTmp = true;
                visitFuncion(((FactorContext) factors.get(i)).funcion());
                addTmp = false;
                previousTmp = temp;
                currentTmp = "t" + (TmpCount - 1);
            } else {
                previousTmp = currentTmp;
                currentTmp = factors.get(i).getText();
            }
            if (i > 0){
                concatTemps(factors.get(i).getParent().getChild(0).getText());
            }
        }
    }

    @Override
    public String visitIteracion(IteracionContext ctx) {
        this.identation++;
        LblCount++;
        int firstLbl = this.LblCount;
        if (ctx.FOR() != null) { // FOR LOOP
            if (ctx.getChild(2) instanceof DeclaracionContext) {
                visitDeclaracion((DeclaracionContext) ctx.getChild(2));
            } else if (ctx.getChild(2) instanceof AsignacionContext) {
                visitAsignacion((AsignacionContext) ctx.getChild(2));
            }
            String operation = ctx.getChild(4).getText();
            code += String.format("L%s:", LblCount);
            this.code += "\t".repeat(this.identation);
            this.code += String.format("if %s goto L%s\n", getOpossiteOperation(operation), ++LblCount);
            visitChildren(ctx.instruccion().bloque());
            code += "\t".repeat(this.identation) + ctx.getChild(6).getText() + "\n";
            this.code += "\t".repeat(this.identation);
            code += String.format("goto L%s", firstLbl);
            code += String.format("\nL%s:", LblCount);
        } else if (ctx.getChild(0).getText().equals("while")) { // WHILE LOOP
            String operation = ctx.operacion().get(0).getText();
            code += String.format("\nL%s:", LblCount);
            this.code += "\t".repeat(this.identation);
            this.code += String.format("if %s goto L%s\n", getOpossiteOperation(operation), ++LblCount);
            visitChildren(ctx.instruccion().bloque());
            this.code += "\t".repeat(this.identation);
            code += String.format("goto L%s", firstLbl);
            code += String.format("\nL%s:", LblCount);
        } else{ // DO WHILE LOOP
            code += String.format("\nL%s:", LblCount);
            visitChildren(ctx.instruccion().bloque());
            String operation = ctx.operacion().get(0).getText();
            this.code += "\t".repeat(this.identation);
            this.code += String.format("if %s goto L%s\n", getOpossiteOperation(operation), LblCount);
        }
        this.identation--;
        return null;
    }

    /**
     * getOppossiteOperation devuelve la operacion booleana opuesta dada una operacion booleana original
     * Por ejemplo: dada la operacion x == y, el metodo retornara x != y
     * @param operation operacion sobre la cual obtener su opuesto
     * @return operacion booleana opuesta
     */
    private String getOpossiteOperation(String operation) {
        StringBuilder newOperation = new StringBuilder();
            for (int i = 0; i < operation.length(); i++) {     
                if (i+2 <= operation.length()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(operation.charAt(i));
                    sb.append(operation.charAt(i+1));
                    String op = sb.toString();
                    if (this.opposites.containsKey(op)) {
                        newOperation.append(" ");
                        newOperation.append(this.opposites.get(op));
                        newOperation.append(" ");
                        i++;
                    } else if (this.opposites.containsKey(String.valueOf(operation.charAt(i)))) {
                        newOperation.append(" ");
                        newOperation.append(this.opposites.get(String.valueOf(operation.charAt(i))));
                        newOperation.append(" ");
                    } else if (Arrays.asList(this.logicalOperators).contains(op)) {
                        newOperation.append(" ");
                        newOperation.append(op);
                        newOperation.append(" ");
                        i++;
                    } else {
                        newOperation.append(operation.charAt(i));
                    }
                } else{ //Last character
                    newOperation.append(operation.charAt(i));
                }       
            }
        return newOperation.toString();
    }
    
    @Override
    public String visitCondicional(CondicionalContext ctx) {
        LblCount++;
        String operation = ctx.operacion().get(0).getText();
        this.code += "\t".repeat(this.identation);
        this.code += String.format("if %s goto L%s\n", getOpossiteOperation(operation), LblCount);
        int aux = LblCount;
        int aux2 = 0;
       /*  int auxLbl1 = LblCount;
        int auxLbl2 = ++LblCount; */
        visitChildren(ctx.instruccion().get(0).bloque());
        if (ctx.ELIF() != null) { // If there's at least 1 else if block we iterate over all possible else if blocks
            for (int i = 0; i < ctx.ELIF().size(); i++) {
                operation = ctx.operacion().get(i+1).getText();
                this.code += "\t".repeat(this.identation);
                this.code += String.format("if %s goto L%s\n", getOpossiteOperation(operation), ++LblCount);
                visitChildren(ctx.instruccion().get(i+1).bloque());
                this.code += String.format("\nELSE IF L%s\n", LblCount);
            }
        }
        if (ctx.ELSE() != null) { // If there's an else block
            this.code += "\t".repeat(this.identation);
            this.code += String.format("goto L%s\n", ++LblCount);
            this.code += String.format("ELSE L%s\n", aux);
            aux = LblCount;
            visitChildren(ctx.instruccion().get(ctx.instruccion().size()-1).bloque());
        }
        this.code += String.format("IF L%s\n", aux);
        return null;
    }

    @Override
    public String visitDefinicion_funcion(Definicion_funcionContext ctx) {
        this.code += "\t".repeat(this.identation);
        this.code += ctx.ID().getText() + ":\n";
        this.identation++;
        this.code += "\t".repeat(this.identation);
        this.code += "BeginFunc\n";
        String parameter;
        List<ParseTree> params = getNodes(ctx, alParser.RULE_param_definicion);
        for (int i = 0; i < params.size(); i++) {
            parameter = ((Param_definicionContext)params.get(i)).ID().getText();
            this.code += "\t".repeat(this.identation);
            this.code += "PopParam " + parameter + "\n";
        }
        visitChildren(ctx.bloque());
        this.code += "\t".repeat(this.identation);
        this.code += "EndFunc\n";
        this.identation--;
        return null;
    }

    @Override
    public String visitRetornar(RetornarContext ctx) {
        processOpal(ctx.operacion().opal());
        this.code += "\t".repeat(this.identation);
        this.code += String.format("return %s\n", currentTmp);
        return null;
    }

    @Override
    public String visitFuncion(FuncionContext ctx) {
        ArrayList<String> params = new ArrayList<String>();
        if (ctx.parametros() != null) {
            List<ParseTree> operaciones = new ArrayList<ParseTree>();
            findRuleNodes(ctx.parametros(), alParser.RULE_operacion, operaciones);
            for (ParseTree operacion : operaciones) {
                processOpal(((OperacionContext)operacion).opal());
                params.add("pushParam " + currentTmp);
            }
        }
        for (String param : params) {
            this.code += "\t".repeat(this.identation) + param + "\n";
        }
        this.code += "\t".repeat(this.identation);
        if (this.addTmp){
            this.code += "t" + this.TmpCount + " = CALL " + ctx.ID() + "\n";
            TmpCount++;
        } else{
            this.code += "CALL " + ctx.ID() + "\n";
        }
        return null;
    }

    private void printCodeToFile() {
        try {
            PrintWriter out = new PrintWriter("intermediateCode.txt");
            out.println(this.code);
            out.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error saving intermediate code file: " + e.getMessage());
        }
    }

    public void printCode() {
        System.out.println("\n=== THREE ADDRESS CODE ===");
        System.out.println(this.code);
        this.printCodeToFile();
    }

    /**
     * add2Factors toma 2 factores provenientes de una asignacion o declaracion de variable 
     * @param factores
     * @param opals
     */
    private void add2Factors(List<ParseTree> factores, List<ParseTree> opals) {
        for (int i = 0; i < factores.size(); i++) {
            FactorContext Fctx = ((FactorContext)factores.get(i));
            if (i == 0){
                String factor = Fctx.getText();
                this.code += factor + " ";
            } else if (Fctx.getParent().getParent() instanceof alParser.ExpContext) { // if there's a + or a -
                ExpContext exp = (ExpContext) Fctx.getParent().getParent();
                String operator = exp.getChild(0).getText();
                this.code += operator + " ";
                if (Fctx.funcion() != null){
                    visitFuncion(Fctx.funcion());
                } else{
                    String factor = exp.getChild(1).getText();
                    this.code += factor;
                }
            } else if (Fctx.getParent() instanceof alParser.TermContext) { //if there's a * or a /
                TermContext term = (TermContext) Fctx.getParent();
                String operator = term.getChild(0).getText();
                this.code += operator + " ";
                if (Fctx.funcion() != null){
                    visitFuncion(Fctx.funcion());
                } else{
                    String factor = term.getChild(1).getText();
                    this.code += factor;
                }
            } else if (i > 0 && opals.size() > 0){ //if there's a comparison or an && or ||
                this.code += opals.get(0).getText() + " ";
                if (Fctx.funcion() != null){
                    visitFuncion(Fctx.funcion());
                } else{
                    this.code += Fctx.getText();
                }
            }
        }
        this.code += "\n";
    }

}