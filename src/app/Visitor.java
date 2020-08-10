package app;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.antlr.runtime.tree.Tree;
import org.antlr.runtime.tree.TreeFilter;
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
    private int identation = 0;
    private boolean addTmp = false;

    private HashMap<String, String> opposites;
    private String[] logicalOperators;

    public Visitor() {
        this.LblCount = 0;
        this.TmpCount = 0;
        this.code = "";
        this.previousTmp = "";
        this.currentTmp = "";
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

    @Override
    public String visitDeclaracion(DeclaracionContext ctx) {
        if (ctx.asignacion() != null) {
            List<ParseTree> factores = getNodes(ctx, alParser.RULE_factor);
            if (factores.size() <= 2) {
                List<ParseTree> opals = getComparisons(ctx);
                this.code += "\t".repeat(this.identation) + ctx.asignacion().ID().getText() + " = ";
                add2Factors(factores, opals);
            } else{
                OpalContext opalCtx = ctx.asignacion().asign().operacion().opal();
                processOpal(opalCtx);
                this.code += "\t".repeat(this.identation) + ctx.asignacion().ID().getText() + " = t" + (TmpCount - 1) + "\n";
            }
        }
        return null;
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
        // need to get the amount of params used, cause they're included
        int params = Trees.findAllRuleNodes(t, alParser.RULE_parametros).size();
        params = aux.size() == params ? 0 : params;
        for (int i = 0; i < aux.size() - params; i++) { // we have to do this backwards, don't ask
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
        int params = Trees.findAllRuleNodes(t, alParser.RULE_parametros).size();
        params = aux.size() == params ? 0 : params;
        for (int i = 0; i < aux.size() - params; i++) {
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
        List<ParseTree> aux = getNodes(t, alParser.RULE_expresion);
        int params = Trees.findAllRuleNodes(t, alParser.RULE_parametros).size();
        params = aux.size() == params ? 0 : params;
        for (int i = 0; i < aux.size() - params; i++) {
            nodes.add(aux.get(i));
        }
        return nodes;
    }

    // TREAT ||, first we need to separate operations by ||
    private void processOpal(OpalContext ctx) {
        String operator = "||";
        List<ParseTree> terminos = separateOR(ctx);
        String temp;
        /* for (int i = 0; i < terminos.size(); i++) {
            System.out.println(terminos.get(i).getText());
        } */
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
        /* System.out.println("divideAND:" + terminos.size());
        for (int i = 0; i < terminos.size(); i++) {
            System.out.println(terminos.get(i).getText());
        } */
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
        /* System.out.println("divideComparisons:" + terminos.size());
        for (int i = 0; i < terminos.size(); i++) {
            System.out.println(terminos.get(i).getText());
        } */
        for (int i = 0; i < terminos.size(); i++) {
            temp = currentTmp;
            processTerms((ExpresionContext) terminos.get(i));
            previousTmp = temp;
            if (i > 0) {
                String operator = terminos.get(i).getParent().getChild(1).getText();
                concatTemps(operator);
            }
        }
    }

    private void processTerms(ExpresionContext ctx) {
        List<ParseTree> ruleTerms = new ArrayList<ParseTree>();
        findRuleNodes(ctx, alParser.RULE_termino, ruleTerms);
        // lista de terminos: 1 + 2 + 3 + 4;
        List<ParseTree> terms = new ArrayList<ParseTree>(ruleTerms);
        String temp;
        
        /* int cont = 0;
        boolean minus = false;
        boolean prevMinus = false;
        boolean prevFactors = false; */
        for (int i = 0; i < terms.size(); i++) {
            // Lista de factores en el termino 'i' 9 * 8 / 2 -> [9,8,2]
            List<ParseTree> factors = new ArrayList<ParseTree>();
            findRuleNodes(terms.get(i), alParser.RULE_factor, factors);
            if (factors.size() > 1) { // Si tiene mas de un factor -> 9 * 8 / 2
                temp = currentTmp;
                generateTempsInTerm(factors); // Genero los temporales
                previousTmp = temp; // almaceno en un auxiliar el temporal actual
                currentTmp = "t" + (TmpCount - 1);
                /* prevFactors = true; */
            } else {
                previousTmp = currentTmp; // almaceno en un auxiliar el temporal actual
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
                    currentTmp = factors.get(0).getText(); // el actual es el primero de la lista 9 -> 9 + 1
                }
            }

            if(i > 0){ 
                concatTemps(terms.get(i).getParent().getChild(0).getText());
            }
          /*   previousTmp = currentTmp; // almaceno en un auxiliar el temporal actual
            String currentTerm = terms.get(i).getText();
            String operation = terms.get(i).getParent().getChild(0).getText();
            if (operation.equals("-")){
                minus = true;
            } else{
                minus = false;
            }

            if (i % 2 != 0){
                cont+=1;
                if (prevFactors){
                    concatTempTerm(operation, currentTerm);
                    prevFactors = false;
                }
                else{
                    if (!prevMinus && !minus){
                        concatTerms(operation, terms.get(i-1).getText(), currentTerm);
                    } else if (!minus && i > 1){
                        concatTempTerm(operation, currentTerm);
                    } else if (minus && i > 1){
                        concatTempTerm(operation, currentTerm);
                    } else if (i == 1){
                        concatTerms(operation, terms.get(i-1).getText(), currentTerm);
                    }
                    if (((cont % 2 == 0 ) || (i == terms.size()-1)) && (!prevMinus)){
                        concatTemps(operation);
                    }
                }
            } else if ((i == terms.size()-1) && i > 1){ // si es el ultimo termino
                concatTempTerm(operation, currentTerm);
            } else if (i > 1 && minus){
                concatTempTerm(operation, currentTerm);
                prevMinus = true;
            } else {
                prevMinus = false;
            } */
        }
    }

    private void concatTempTerm(String operation, String term){
        this.code += "\t".repeat(this.identation);
        this.code += String.format("t%d = %s %s %s \n", TmpCount, previousTmp, operation, term);
        currentTmp = "t" + TmpCount;
        TmpCount++;
    }

    private void concatTerms(String operation, String previousTerm, String term){
        this.code += "\t".repeat(this.identation);
        this.code += String.format("t%d = %s %s %s \n", TmpCount, previousTerm, operation, term);
        currentTmp = "t" + TmpCount;
        TmpCount++;
    }

    private void concatTemps(String operation) {
        this.code += "\t".repeat(this.identation);
        this.code += String.format("t%d = %s %s %s \n", TmpCount, previousTmp, operation, currentTmp);
        currentTmp = "t" + TmpCount;
        TmpCount++;
    }

    private void generateTempsInTerm(List<ParseTree> factors) {
        String temp;
        int cont = 0;
        for(int i=0; i < factors.size(); i++) {
            System.out.println(factors.get(i).getText());
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
            }
            String currentFactor = factors.get(i).getText();
            String operation = factors.get(i).getParent().getChild(0).getText();
            if (i % 2 != 0){
                cont+=1;
                concatTerms(operation, factors.get(i-1).getText(), currentFactor);
                if ((cont % 2 == 0 ) && (i == factors.size()-1)){
                    concatTemps(factors.get(i-1).getParent().getChild(0).getText());
                }
            } else if ((i == factors.size()-1) && i > 1){ // si es el ultimo factor
                concatTempTerm(operation, currentFactor);
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
     * getOppossiteOperation returns the oppossite boolean operation given an original boolean operation
     * ex: given the comparisson x == y, getOppossiteOperation will return x != y
     * @param operation operation to find out opossite version
     * @return operation's opossite operation
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


    private void getComparacion(OperacionContext ctx) {
        //System.out.println("Operator:" + ctx.opal().disyuncion().conjuncion().igualdad().comparaciones().getText());
        List<ParseTree> factores = getNodes(ctx, alParser.RULE_comparaciones);
        for (int i = 0; i < factores.size(); i++) {
            System.out.println("Operator:" + factores.get(i).getText());
        }
    }
    
    @Override
    public String visitCondicional(CondicionalContext ctx) {
        this.identation++;
        String operation = ctx.operacion().get(0).getText();
        this.code += "\t".repeat(this.identation);
        this.code += String.format("if %s goto L%s\n", getOpossiteOperation(operation), ++LblCount);
        visitChildren(ctx.instruccion().get(0).bloque());
        this.code += String.format("\nL%s", LblCount);
        if (ctx.ELIF() != null) { // If there's at least 1 else if block we iterate over all possible else if blocks
            for (int i = 0; i < ctx.ELIF().size(); i++) {
                operation = ctx.operacion().get(i+1).getText();
                this.code += "\t".repeat(this.identation);
                this.code += String.format("if %s goto L%s\n", getOpossiteOperation(operation), ++LblCount);
                visitChildren(ctx.instruccion().get(i+1).bloque());
                this.code += String.format("\nL%s", LblCount);
            }
        }
        if (ctx.ELSE() != null) { // If there's an else block
            visitChildren(ctx.instruccion().get(ctx.instruccion().size()-1).bloque());
        }
        this.identation--;
        return null;
    }

    @Override
    public String visitDefinicion_funcion(Definicion_funcionContext ctx) {
        this.identation++;
        this.code += ctx.ID().getText() + ":\n";
        this.code += "\t".repeat(this.identation);
        this.code += "BeginFunc\n";
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