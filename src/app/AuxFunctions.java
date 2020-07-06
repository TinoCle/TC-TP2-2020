package app;

import java.util.ArrayList;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.xpath.XPath;

import app.alParser.*;

public class AuxFunctions {
    public static Function processFunction (Definicion_funcionContext ctx){
        SymbolTable symbolTable = SymbolTable.getInstance();
        ErrorReporter error = ErrorReporter.getInstance();
        String type = ctx.tipodato().getText();
        String name = ctx.ID().getText();
        Function function = new Function(type, name);
        ArrayList<ID> params = new ArrayList<>();
        if (ctx.param_definicion() != null){
            symbolTable.addParamContext();
            params = getParams(ctx.param_definicion(), params);
            for (ID id : params) {
                if (symbolTable.checkVariableDeclared(id))
                    error.existentVariable(ctx.getStart().getLine(), id.getName());
                symbolTable.insertParam(id);
            }
            symbolTable.removeContext();
        }
        function.setParams(params);
        if (symbolTable.getContext() == 1){
            Function prototype = symbolTable.getFunctionPrototype(function);
            if (prototype != null && !function.equals(prototype)){
                error.conflictingTypes(ctx.getStart().getLine(), function.getName());
            }
        }
        return function;
    }

    public static boolean checkFunction(Function function, Declaracion_funcionContext ctx){
        SymbolTable symbolTable = SymbolTable.getInstance();
        ErrorReporter error = ErrorReporter.getInstance();
        if (symbolTable.getFunctionPrototype(function) != null){
            error.existentFunction(ctx.getStart().getLine(), function.getName());
            return false;
        } else if (symbolTable.getContext() != 1){ //if not global context
            error.functionNotDeclaredInGlobalContext(ctx.getStart().getLine());
            return false;
        } else if (symbolTable.checkVariableDeclared(function)){
            error.existentVariable(ctx.getStart().getLine(), function.getName());
            return false;
        }
        return true;
    }
    
    public static ArrayList<ID> getParams(ParserRuleContext ctx, ArrayList<ID> param){
        if(ctx instanceof Param_declaracionContext){
            Param_declaracionContext ctx2 = (Param_declaracionContext) ctx;
            if (ctx2.param_declaracion() != null) {
                ID id = new Variable();
                id.setName(ctx2.ID() != null ? ctx2.ID().getText() : "");
                id.setType(ctx2.tipodato().getText());
                param.add(id);
                return getParams(ctx2.param_declaracion(), param);
            } else{
                ID id = new Variable();
                id.setName(ctx2.ID() != null ? ctx2.ID().getText() : "");
                id.setType(ctx2.tipodato().getText());
                param.add(id);
                return param;
            }
        } else { 
            Param_definicionContext ctx2 = (Param_definicionContext) ctx;
            if (ctx2.param_definicion() != null) {
                ID id = new Variable();
                id.setName(ctx2.ID().getText());
                id.setType(ctx2.tipodato().getText());
                id.setValue("1");
                param.add(id);
                return getParams(ctx2.param_definicion(), param);
            } else{
                ID id = new Variable();
                id.setName(ctx2.ID().getText());
                id.setType(ctx2.tipodato().getText());
                id.setValue("1");
                param.add(id);
                return param;
            }
        }
    }

    public static boolean compareTypes (String idType, FactorContext factor){
        SymbolTable symbolTable = SymbolTable.getInstance();
        ErrorReporter error = ErrorReporter.getInstance();
        if (factor.NUMERO() != null && idType.equals("int")){
            return true;
        }
        if (factor.FLOTANTE() != null && idType.equals("double")){
            return true;
        }
        if (factor.LITERAL() != null && idType.equals("char")){
            return true;
        }
        if (factor.funcion() != null){
            String functionName = factor.funcion().ID().getText();
            Function fnCalled = (Function) symbolTable.findVariable(functionName);
            if (fnCalled.getType().equals(idType) && fnCalled != null) {
                return true;
            } else{
                return false;
            }
        }
        if (factor.ID() != null){
            ID id2 = symbolTable.findVariable(factor.ID().getText());
            if (id2 != null) { // right ID exists
                if (idType.equals(id2.getType())) {
                    return true;
                } else {
                    return false;
                }
            } else {
                error.unexistentVariable(factor.getStart().getLine(), factor.getStop().getText());
            }
        }
        return true;
    }

    public static ArrayList<FactorContext> getFactors(ParseTree parseTree, Parser parser) {
        ArrayList<FactorContext> factores = new ArrayList<FactorContext>();
        for (ParseTree ctx : XPath.findAll(parseTree, "//factor", parser)) {
            factores.add((FactorContext) ctx);
        }
        if (factores.size() > 0){
            return factores;
        } else{
            return null;
        }
    }

    public static Definicion_funcionContext findFunctionCtx(ParseTree parseTree){
        if (!(parseTree instanceof Definicion_funcionContext) && parseTree.getParent() != null) {
            return findFunctionCtx (parseTree.getParent());
        } else if (parseTree.getParent() == null){
            return null;
        }
        else{
            return (Definicion_funcionContext) parseTree;
        }
    }

    public static boolean hasExit(ParseTree parseTree, Parser parser) {
        int returnCount = XPath.findAll(parseTree, "//retornar", parser).size();
        System.out.println("Returns:" + returnCount);
        if (returnCount > 0){
            return true;
        }
        else{
            return false;
        }
    }
}