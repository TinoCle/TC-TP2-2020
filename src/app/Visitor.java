package app;

import java.util.ArrayList;
import java.util.Collection;
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

    public Visitor(){
        this.LblCount = 0;
        this.TmpCount = 0;
        this.code = "";
        this.previousTemp = "";
        this.currentTemp = "";
    }

    @Override
    public String visit(ParseTree tree) {
        return super.visit(tree);
    }

    private List<ParseTree> getRuleNodes(ParseTree ctx, int ruleIndex){
        return new ArrayList<ParseTree>(Trees.findAllRuleNodes(ctx, ruleIndex));
    }

    //Visit all children
    public void visitChildren(RuleContext ctx) {
        for (int hijo = 0; hijo < ctx.getChildCount(); hijo++) {
            visit(ctx.getChild(hijo));
        }
    }

    @Override
    public String visitAsignacion(AsignacionContext ctx) {
        List<ParseTree> factores = getRuleNodes(ctx, alParser.RULE_factor);
        if (factores.size() <= 2){
            this.code += ctx.ID().getText() + " = " + get2Factors(factores);
        } else{
            OpalContext opalCtx = ctx.asign().operacion().opal();
            processConjuncion(opalCtx);
            code += ctx.ID().getText() + " = t" + (TmpCount - 1) + "\n";
        }
        return null;
    }

    @Override
    public String visitDeclaracion(DeclaracionContext ctx) {
        if (ctx.asignacion() != null) {
            List<ParseTree> factores = getRuleNodes(ctx, alParser.RULE_factor);
            if (factores.size() <= 2){
                this.code += ctx.asignacion().ID().getText() + " = " + get2Factors(factores);
            } else{
                OpalContext opalCtx = ctx.asignacion().asign().operacion().opal();
                processConjuncion(opalCtx);
                code += ctx.asignacion().ID().getText() + " = t" + (TmpCount - 1) + "\n";
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

    private void processComparacion(DisyuncionContext ctx){
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
            if(i > 0){ 
                concatTemps(terms.get(i).getParent().getChild(0).getText());
            }
        }
    }

    private void generateTempsInTerm(Collection<ParseTree> factors) {
        List<ParseTree> factorsLocal = new ArrayList<ParseTree>(factors);
        String temp;
        for(int i=0; i < factorsLocal.size(); i++){
            if(((FactorContext)factorsLocal.get(i)).opal() != null){
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

    private String get2Factors(List<ParseTree> terms){
        String code = "";
        for (ParseTree parseTree : terms) {
            FactorContext Fctx = ((FactorContext)parseTree);
            if (Fctx.getParent().getParent() instanceof alParser.ExpContext){ // if there's a + or -
                ExpContext exp = (ExpContext) Fctx.getParent().getParent();
                String operator = exp.getChild(0).getText();
                String factor = exp.getChild(1).getText();
                code += operator + " " +  factor + "\n";
            } else if (Fctx.getParent() instanceof alParser.TermContext){ //if there's a * or /
                TermContext term = (TermContext) Fctx.getParent();
                String operator = term.getChild(0).getText();
                String factor = term.getChild(1).getText();
                code += operator + " " + factor + "\n";
            } else { //it's the first factor, so there's nothing on its left
                String factor = Fctx.getText();
                code += factor;
                if (terms.size() == 1){ //last one
                    code += "\n";
                }
            }
        }
        return code;
    }
    
    private void concatTemps(String operation) {
        this.code += String.format("t%d = %s %s %s \n", TmpCount, previousTemp, operation, currentTemp);
        currentTemp = "t" + TmpCount;
        TmpCount++;
    }

    @Override
    public String visitIteracion(IteracionContext ctx) {
        if (ctx.FOR() != null){
            System.out.println("MODO GARLOPA");
        }
        if (ctx.WHILE() != null){
            
        }
        return null;
    }

    public void printCode(){
        System.out.println("\n=== INTERMEDIATE CODE ===");
        System.out.println(this.code);
    }

}