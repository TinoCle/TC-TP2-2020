package app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.Trees;
import app.alParser.*;

public class Visitor extends alBaseVisitor<String> {
    private int LblCount;
    private int TmpCount;
    private String code;
    private String previousTemp;
    private String currentTemp;

    private HashMap<String, String> opposites;
    private String[] logicalOperators;

    public Visitor() {
        this.LblCount = 0;
        this.TmpCount = 0;
        this.code = "";
        this.previousTemp = "";
        this.currentTemp = "";

        this.logicalOperators = new String[]{"&&", "||"};
        this.opposites = new HashMap<String, String>();
        loadOpposites();
    }

    private void loadOpposites() {
        this.opposites.put("<", ">=");
        this.opposites.put(">", "<=");
        this.opposites.put("<=", ">");
        this.opposites.put(">=", "<");
        this.opposites.put("==", "!=");
        this.opposites.put("!=", "==");
    }

    private List<ParseTree> getRuleNodes(ParseTree ctx, int ruleIndex) {
        return new ArrayList<ParseTree>(Trees.findAllRuleNodes(ctx, ruleIndex));
    }

    @Override
    public String visitAsignacion(AsignacionContext ctx) {
        List<ParseTree> factores = getRuleNodes(ctx, alParser.RULE_factor);
        if (factores.size() <= 2) {
            this.code += "\t" + ctx.ID().getText() + " = " + get2Factors(factores);
        } else{
            OpalContext opalCtx = ctx.asign().operacion().opal();
            processConjuncion(opalCtx);
            this.code += "\t" + ctx.ID().getText() + " = t" + (TmpCount - 1) + "\n";
        }
        return null;
    }

    @Override
    public String visitDeclaracion(DeclaracionContext ctx) {
        if (ctx.asignacion() != null) {
            List<ParseTree> factores = getRuleNodes(ctx, alParser.RULE_factor);
            if (factores.size() <= 2) {
                this.code += "\t" + ctx.asignacion().ID().getText() + " = " + get2Factors(factores);
            } else{
                OpalContext opalCtx = ctx.asignacion().asign().operacion().opal();
                processConjuncion(opalCtx);
                this.code += "\t" + ctx.asignacion().ID().getText() + " = t" + (TmpCount - 1) + "\n";
            }
        }
        return null;
    }
    
    private void processConjuncion(OpalContext ctx) {
        List<ParseTree> conjunciones = new ArrayList<ParseTree>();
        findRuleNodes(ctx, alParser.RULE_disyuncion, conjunciones);
        String temp;
        for (int i = 0; i < conjunciones.size(); i++) {
            temp = currentTemp;
            processComparacion((DisyuncionContext) conjunciones.get(i));
            previousTemp = temp;
            if (i > 0) {
                String operator = conjunciones.get(i).getParent().getChild(0).getText();
                concatTemps(operator);
            }
        }
    }

    private void processComparacion(DisyuncionContext ctx) {
        List<ParseTree> conmparaciones = new ArrayList<ParseTree>();
        findRuleNodes(ctx, alParser.RULE_igualdad, conmparaciones);
        String temp;
        for (int i = 0; i < conmparaciones.size(); i++) {
            temp = currentTemp;
            processExpresion((IgualdadContext) conmparaciones.get(i));
            previousTemp = temp;
            if (i > 0) {
                concatTemps(conmparaciones.get(i).getParent().getChild(0).getText());
            }
        }
    }

    private void processExpresion(IgualdadContext ctx) {
        List<ParseTree> expresiones = new ArrayList<ParseTree>();
        findRuleNodes(ctx, alParser.RULE_expresion, expresiones);
        String temp;
        for (int i = 0; i < expresiones.size(); i++) {
            temp = currentTemp;
            processTerms((ExpresionContext) expresiones.get(i));
            previousTemp = temp;
            if (i > 0) {
                concatTemps(expresiones.get(i).getParent().getChild(0).getText());
            }
        }
    }

    private void processTerms(ExpresionContext ctx) {
        List<ParseTree> ruleTerms = new ArrayList<ParseTree>();
        findRuleNodes(ctx, alParser.RULE_termino, ruleTerms);
        String temp;        

        List<ParseTree> terms = new ArrayList<ParseTree>(ruleTerms);
        for (int i = 0; i < terms.size(); i++) {
            // Lista de factores de ese termino 'i' 9 * 8 / 2 -> [9,8,2]
            List<ParseTree> factors = new ArrayList<ParseTree>();
            findRuleNodes(terms.get(i), alParser.RULE_factor, factors);
            // Si tiene mas de un factor -> 9 * 8 / 2
            if (factors.size() > 1) {
                temp = currentTemp;
                generateTempsInTerm(factors); // Genero los temporales
                previousTemp = temp; // almaceno en un auxiliar el temporal actual
                currentTemp = "t" + (TmpCount - 1);
            } else {
                previousTemp = currentTemp; // almaceno en un auxiliar el temporal actual
                if (((TerminoContext) terms.get(i)).factor().opal() != null) {
                    temp = currentTemp;
                    processConjuncion(((TerminoContext) terms.get(i)).factor().opal());
                    previousTemp = temp;
                } else {
                    currentTemp = factors.get(0).getText(); // el actual es el primero de la lista 9 -> 9 + 1
                }
            }
            if(i > 0) { 
                concatTemps(terms.get(i).getParent().getChild(0).getText());
            }
        }
    }

    private void generateTempsInTerm(Collection<ParseTree> factors) {
        List<ParseTree> factorsLocal = new ArrayList<ParseTree>(factors);
        String temp;
        for(int i=0; i < factorsLocal.size(); i++) {
            if(((FactorContext)factorsLocal.get(i)).opal() != null) {
                temp = currentTemp;
                processConjuncion(((FactorContext) factorsLocal.get(i)).opal());
                previousTemp = temp;
                // currentTemp = "t" + (countTmp - 1);
            } else {
                // sino guardar el valor
                previousTemp = currentTemp;
                currentTemp = factorsLocal.get(i).getText();
            }
            if (i > 0) {
                concatTemps(factorsLocal.get(i).getParent().getChild(0).getText());
            }
        }
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

    private String get2Factors(List<ParseTree> terms) {
        String code = "";
        for (ParseTree parseTree : terms) {
            FactorContext Fctx = ((FactorContext)parseTree);
            if (Fctx.getParent().getParent() instanceof alParser.ExpContext) { // if there's a + or a -
                ExpContext exp = (ExpContext) Fctx.getParent().getParent();
                String operator = exp.getChild(0).getText();
                String factor = exp.getChild(1).getText();
                code += operator + " " +  factor + "\n";
            } else if (Fctx.getParent() instanceof alParser.TermContext) { //if there's a * or a /
                TermContext term = (TermContext) Fctx.getParent();
                String operator = term.getChild(0).getText();
                String factor = term.getChild(1).getText();
                code += operator + " " + factor + "\n";
            } else { //it's the first factor, so there's nothing on its left
                String factor = Fctx.getText();
                code += factor + " ";
                if (terms.size() == 1) { //last one
                    code += "\n";
                }
            }
        }
        return code;
    }
    
    private void concatTemps(String operation) {
        this.code += String.format("\tt%d = %s %s %s \n", TmpCount, previousTemp, operation, currentTemp);
        currentTemp = "t" + TmpCount;
        TmpCount++;
    }

    @Override
    public String visitIteracion(IteracionContext ctx) {
        /* List<ParseTree> operators = getRuleNodes((OperacionContext) ctx.getChild(4), alParser.RULE_comparaciones);
        List<ParseTree> factores = getRuleNodes((OperacionContext) ctx.getChild(4), alParser.RULE_factor);
        List<ParseTree>  = getRuleNodes((OperacionContext) ctx.getChild(4), alParser.RULE_factor); */
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
            this.code += String.format("\tif %s goto L%s\n", getOpossiteOperation(operation), ++LblCount);
            visitChildren(ctx.instruccion().bloque());
            code += "\t" + ctx.getChild(6).getText() + "\n";
            code += String.format("\tgoto L%s", firstLbl);
            code += String.format("\nL%s:", LblCount);
        } else if (ctx.getChild(0).getText().equals("while")) { // WHILE LOOP
            String operation = ctx.operacion().get(0).getText();
            code += String.format("\nL%s:", LblCount);
            this.code += String.format("\tif %s goto L%s\n", getOpossiteOperation(operation), ++LblCount);
            visitChildren(ctx.instruccion().bloque());            
            code += String.format("\tgoto L%s", firstLbl);
            code += String.format("\nL%s:", LblCount);
        } else{ // DO WHILE LOOP
            code += String.format("\nL%s:", LblCount);
            visitChildren(ctx.instruccion().bloque());
            String operation = ctx.operacion().get(0).getText();
            this.code += String.format("\tif %s goto L%s\n", getOpossiteOperation(operation), LblCount);
        }
        return null;
    }

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
        List<ParseTree> factores = getRuleNodes(ctx, alParser.RULE_comparaciones);
        for (int i = 0; i < factores.size(); i++) {
            System.out.println("Operator:" + factores.get(i).getText());
        }
    }
    
    @Override
    public String visitCondicional(CondicionalContext ctx) {
        String operation = ctx.operacion().get(0).getText();
        this.code += String.format("\tif %s goto L%s\n", getOpossiteOperation(operation), ++LblCount);
        visitChildren(ctx.instruccion().get(0).bloque());
        this.code += String.format("\nL%s", LblCount);
        if (ctx.ELIF() != null) { // If there's at least 1 else if block we iterate over all possible else if blocks
            for (int i = 0; i < ctx.ELIF().size(); i++) {
                operation = ctx.operacion().get(i+1).getText();
                this.code += String.format("\tif %s goto L%s\n", getOpossiteOperation(operation), ++LblCount);
                visitChildren(ctx.instruccion().get(i+1).bloque());
                this.code += String.format("\nL%s", LblCount);
            }
        }
        if (ctx.ELSE() != null) { // If there's an else block
            visitChildren(ctx.instruccion().get(ctx.instruccion().size()-1).bloque());
        }
        return null;
    }

    @Override
    public String visitDefinicion_funcion(Definicion_funcionContext ctx) {
        this.code += ctx.ID().getText() + ":\n";
        this.code += "\tBeginFunc\n";
        visitChildren(ctx.bloque());
        this.code += "\tEndFunc\n";
        return null;
    }

    @Override
    public String visitRetornar(RetornarContext ctx) {
        processConjuncion(ctx.operacion().opal());
        this.code += String.format("\treturn %s\n", currentTemp);
        return null;
    }

    @Override
    public String visitFuncion(FuncionContext ctx) {
        ArrayList<String> params = new ArrayList<String>();
        if (ctx.parametros() != null) {
            List<ParseTree> operaciones = new ArrayList<ParseTree>();
            findRuleNodes(ctx.parametros(), alParser.RULE_operacion, operaciones);
            for (ParseTree operacion : operaciones) {
                processConjuncion(((OperacionContext)operacion).opal());
                params.add("pushParam " + currentTemp);
            }
        }
        for (String param : params) {
            this.code += "\t" + param + "\n";
        }
        this.code += "\tCALL " + ctx.ID() + "\n";
        return null;
    }

    public void printCode() {
        System.out.println("\n=== INTERMEDIATE CODE ===");
        System.out.println(this.code);
    }

}