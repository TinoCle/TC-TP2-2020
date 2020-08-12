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
    private boolean addTmp;

    private HashMap<String, String> opposites;
    private String[] logicalOperators;

    public Visitor() {
        this.LblCount = 0;
        this.TmpCount = 0;
        this.code = "";
        this.previousTmp = "";
        this.currentTmp = "";
        this.logicalOperators = new String[]{"&&", "||"};
        this.addTmp = false;
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

    /**
     * getNodes obtiene todos los nodos del árbol que coincidan con la regla enviada como parametro
     * @param ctx Árbol sobre el cual buscar la regla gramatical
     * @param ruleIndex Regla a buscar
     * @return Lista de todos los nodos coincidentes con la regla pasada por parámetro
     */
    private List<ParseTree> getNodes(ParseTree ctx, int ruleIndex) {
        return new ArrayList<ParseTree>(Trees.findAllRuleNodes(ctx, ruleIndex));
    }

    @Override
    public String visitAsignacion(AsignacionContext ctx) {
        List<ParseTree> factor = getNodes(ctx, alParser.RULE_factor);
        if (factor.size() == 1){
            this.code +=  ctx.ID().getText() + " = " + factor.get(0).getText() + "\n";
        } else{
            OpalContext opalCtx = ctx.asign().operacion().opal();
            processOpal(opalCtx);
            this.code = this.code.replace("t" + (TmpCount - 1), ctx.ID().getText());
            TmpCount--;
        }
        return null;
    }

    @Override
    public String visitDeclaracion(DeclaracionContext ctx) {
        if (ctx.asignacion() != null) {
            List<ParseTree> factor = getNodes(ctx, alParser.RULE_factor);
            if (factor.size() == 1){
                this.code +=  ctx.asignacion().ID().getText() + " = " + factor.get(0).getText() + "\n";
            } else{
                OpalContext opalCtx = ctx.asignacion().asign().operacion().opal();
                processOpal(opalCtx);
                this.code = this.code.replace("t" + (TmpCount - 1), ctx.asignacion().ID().getText());
                TmpCount--;
            }
        }
        return null;
    }

    /**
     * separateOR toma un Contexto de Opal para dividir a la operacion en ||, por ejemplo:
     * si la operacion es: 1 + 2 == 3 || 3 - 2 == 1, el metodo retornara una lista que contiene: [1+2==3, 3-2==1]
     * @param t Contexto de operación aritmetico lógica
     * @return lista de los terminos divididor por ||
     */
    private List<ParseTree> separateOR(ParseTree t){
        List<ParseTree> nodes = new ArrayList<ParseTree>();   
        List<ParseTree> aux = getNodes(t, alParser.RULE_disyuncion);
        List<ParseTree> opals = getNodes(t, alParser.RULE_factor); // factores encerrados en parentesis, como ((1+2)+3)
        int count = 0;
        for (int i = 0; i < opals.size(); i++) {
            if (((FactorContext) opals.get(i)).PA() != null){
                count++;
            }
        }
        // Necesito obtener la cantidad de parametros porque se incluyen como otros terminos
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

    /**
     * separateAND toma un Contexto de Opal para dividir a la operacion segun los &&, por ejemplo:
     * si la operacion es: 1 + 2 == 3 && 3 - 2 == 1, el metodo retornara una lista que contiene: [1+2==3, 3-2==1]
     * @param t Contexto de Conjuncion
     * @return Lista con todos los terminos divididos por &&
     */
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

    /**
     * separateComparisons divide a los factores según los operadores booleanos presentes, por ejemplo si la operacion es:
     * 1 + 3 == 2, el metodo retorna una lista igual a: [1+3, 2]
     * @param t Contexto a tratar
     * @return  lista con todos los factores separados por operación booleana
     */
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

    /**
     * processOpal toma un Opal Context para dividir la operación según los operadores lógicos OR
     * @param ctx Contexto Opal
     */
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

    /**
     * divideAND toma un Conjunción Context para dividir la operación según los operadores lógicos AND
     * @param ctx
     */
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

    /**
     * divideComparisons toma un contexto y divide a la operación por los operadores aritméticos presentes (==, !=, <, >, <=, >=)
     * @param ctx
     */
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

    /**
     * processTerms procesa todos los términos en el contexto, analizando si dentro del término hay factores para procesarlos
     * previamente
     * @param ctx
     */
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

    /**
     * concatTemps concatena los temporales con una operación de por medio, tomando el temporal anterior
     * y el temporal actual
     * @param operation
     */
    private void concatTemps(String operation) {
        this.code += String.format("t%d = %s %s %s \n", TmpCount, previousTmp, operation, currentTmp);
        currentTmp = "t" + TmpCount;
        TmpCount++;
    }

    /**
     * processFactors toma una lista de factores y realiza las operaciones presentes
     * @param factors
     */
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
            this.code += String.format("if %s goto L%s\n", getOpossiteOperation(operation), ++LblCount);
            visitChildren(ctx.instruccion().bloque());
            code +=  ctx.getChild(6).getText() + "\n";
            code += String.format("goto L%s", firstLbl);
            code += String.format("\nL%s:", LblCount);
        } else if (ctx.getChild(0).getText().equals("while")) { // WHILE LOOP
            String operation = ctx.operacion().get(0).getText();
            code += String.format("\nL%s:", LblCount);
            this.code += String.format("if %s goto L%s\n", getOpossiteOperation(operation), ++LblCount);
            visitChildren(ctx.instruccion().bloque());
            code += String.format("goto L%s", firstLbl);
            code += String.format("\nL%s:", LblCount);
        } else{ // DO WHILE LOOP
            code += String.format("\nL%s:", LblCount);
            visitChildren(ctx.instruccion().bloque());
            String operation = ctx.operacion().get(0).getText();
            this.code += String.format("if %s goto L%s\n", getOpossiteOperation(operation), LblCount);
        }
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
                        newOperation.append(this.opposites.get(op));
                        i++;
                    } else if (this.opposites.containsKey(String.valueOf(operation.charAt(i)))) {
                        newOperation.append(this.opposites.get(String.valueOf(operation.charAt(i))));
                    } else if (Arrays.asList(this.logicalOperators).contains(op)) {
                        newOperation.append(op);
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
    
    /**
     * findRuleNodes busca todos los nodos que coincidan con la regla pasada por parametro, clasificando y 
     * limpiando nodos residuales no pertenecientes a la regla
     * @param t     Arbol sobre el cual buscar las reglas
     * @param index Regla a buscar
     * @param nodes Lista en la cual almacenar los nodos
     */
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

    /**
     * getLastLine toma un String para retornar la última línea
     * @param string String sobre el cual obtener su última línea
     * @return Devuelve la última línea del String
     */
    public String getLastLine(String string) {
        List<String> lines = Arrays.asList(string.split("\n"));
        return new ArrayList<>(lines.subList(Math.max(0, lines.size() - 1), lines.size())).get(0);
    }

    @Override
    public String visitCondicional(CondicionalContext ctx) {
        LblCount++;
        processOpal(ctx.operacion().get(0).opal());
        String auxString = getLastLine(this.code);
        String operation = auxString.substring(auxString.indexOf("=")+2);
        this.code = this.code.replace(auxString, String.format("if %s goto L%s", getOpossiteOperation(operation), LblCount));
        TmpCount--;
        int lblGo = LblCount;
        int aux1 = LblCount;
        visitChildren(ctx.instruccion().get(0).bloque());
        if (ctx.ELIF().size() > 0) { // If there's at least 1 else if block we iterate over all possible else if blocks
            if (ctx.ELSE() == null){
                lblGo = LblCount + ctx.ELIF().size();
                this.code += String.format("goto L%s\n", lblGo);
            } else{
                lblGo = LblCount + ctx.ELIF().size() + 1;
                this.code += String.format("goto L%s\n", lblGo);
            }
            for (int i = 0; i < ctx.ELIF().size(); i++) {
                processOpal(ctx.operacion().get(i+1).opal());
                auxString = getLastLine(this.code);
                operation = auxString.substring(auxString.indexOf("=")+2);
                this.code = this.code.replace(auxString, String.format("L%s if %s goto L%s", aux1, getOpossiteOperation(operation), ++LblCount));
                TmpCount--;
                aux1 = LblCount;
                visitChildren(ctx.instruccion().get(i+1).bloque());
                if (i != ctx.ELIF().size()-1 && ctx.ELSE() == null){
                    this.code += String.format("goto L%s\n", lblGo);
                }
            }
            if (ctx.ELSE() == null){
                this.code += String.format("L%s\n", LblCount);
            }
        }
        if (ctx.ELSE() != null) { // If there's an else block
            int elseAux = 0;
            if (ctx.ELIF().size() == 0){
                this.code += String.format("goto L%s\n", ++LblCount);
                elseAux = LblCount;
            }
            this.code += String.format("L%s\n", aux1);
            aux1 = LblCount;
            visitChildren(ctx.instruccion().get(ctx.instruccion().size()-1).bloque());
            if (ctx.ELIF().size() == 0){
                this.code += String.format("L%s\n", elseAux);
            } else{
                this.code += String.format("L%s\n", lblGo);
            }
        }
        if (ctx.ELIF().size() == 0 && ctx.ELSE() == null){
            this.code += String.format("L%s\n", aux1);
        }
        return null;
    }

    @Override
    public String visitDefinicion_funcion(Definicion_funcionContext ctx) {
        this.code += ctx.ID().getText() + ":\n";
        this.code += "BeginFunc\n";
        String parameter;
        List<ParseTree> params = getNodes(ctx, alParser.RULE_param_definicion);
        for (int i = 0; i < params.size(); i++) {
            parameter = ((Param_definicionContext)params.get(i)).ID().getText();
            this.code += "PopParam " + parameter + "\n";
        }
        visitChildren(ctx.bloque());
        this.code += "EndFunc\n";
        return null;
    }

    @Override
    public String visitRetornar(RetornarContext ctx) {
        processOpal(ctx.operacion().opal());
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
            this.code += param + "\n";
        }
        if (this.addTmp){
            this.code += "t" + this.TmpCount + " = CALL " + ctx.ID() + "\n";
            TmpCount++;
        } else{
            this.code += "CALL " + ctx.ID() + "\n";
        }
        return null;
    }

    /**
     * printCode guarda el código de tres direcciones en un archivo txt
     */
    public void printCode() {
        System.out.println("\n=== THREE ADDRESS CODE ===");
        System.out.println(this.code);
        this.printCodeToFile();
    }

    /**
     * printCodeToFile guarda el código de tres direcciones en un archivo txt en el root del proyecto
     */
    private void printCodeToFile() {
        try {
            PrintWriter out = new PrintWriter("intermediateCode.txt");
            out.println(this.code);
            out.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error saving intermediate code file: " + e.getMessage());
        }
    }

}