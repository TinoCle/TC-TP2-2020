package app;

import app.alParser.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.xpath.XPath;

public class Listener extends alBaseListener {

    SymbolTable symbolTable = new SymbolTable();
    ErrorReporter error = ErrorReporter.getInstance();
    HashMap<Integer, String> dataTypes = new HashMap<>();
    alParser parser;

    public Listener(alParser parser) {
        System.out.println("\n");
        dataTypes.put(alLexer.NUMERO, "int");
        dataTypes.put(alLexer.FLOTANTE, "double");
        dataTypes.put(alLexer.LITERAL, "char");
        dataTypes.put(alLexer.ID, "id");
        dataTypes.put(alLexer.PC, "function");
        this.parser = parser;
    }

    @Override
    public void enterBloque(alParser.BloqueContext ctx) {

        if (ctx.getParent() instanceof Definicion_funcionContext) {
            Definicion_funcionContext fnCtx = (Definicion_funcionContext) ctx.getParent();
            if (fnCtx.param_definicion() != null) {
                ArrayList<ID> params = new ArrayList<>();
                params = getParamsDefinition(fnCtx.param_definicion(), params);
                for (ID id : params) {
                    if (this.symbolTable.checkVariableDeclared(id))
                        error.existentVariable(ctx.getStart().getLine(), id.getName());
                    symbolTable.insertID(id);
                }
            }
        } else {
            this.symbolTable.addContext();
        }
    }

    @Override
    public void exitBloque(alParser.BloqueContext ctx) {
        // this.symbolTable.printSymboltable2();
        this.symbolTable.removeContext();
    }

    @Override
    public void exitDeclaracion(alParser.DeclaracionContext ctx) {
        ID id;
        if (ctx.asignacion() == null) { // just declaration, asignation also inserts the ID into symbolTable
            id = new Variable(ctx.tipodato().getText(), ctx.ID().getText());
            if (!this.symbolTable.checkVariableDeclared(id)) { // new variable
                symbolTable.insertID(id);
            } else {
                error.existentVariable(ctx.getStop().getLine(), id.getName());
            }
        }
    }

    @Override
    public void exitAsignacion(AsignacionContext ctx) {
        this.checkAsignacion(ctx);
    }

    private void checkAsignacion(AsignacionContext ctx) {
        ID leftID = symbolTable.findVariable(ctx.ID().getText());
        int line = ctx.getStart().getLine();
        if (ctx.getParent() instanceof DeclaracionContext){ // comming from 'declaracion', build leftID
            String leftIdName = ctx.ID().getText();
            String leftIdType = ((DeclaracionContext) ctx.getParent()).tipodato().getText();
            leftID = new Variable(leftIdType, leftIdName);
            if (!this.symbolTable.checkVariableDeclared(leftID)) { // new variable
                symbolTable.insertID(leftID);
            } else {
                error.existentVariable(ctx.getStop().getLine(), leftID.getName());
            }
        }
        ArrayList<FactorContext> factores = getFactor(ctx);
        if (leftID == null) { // left ID doesn't exists
            error.unexistentVariable(line, ctx.ID().getText());
            return;
        }
        if (factores == null){
            error.missingAssignment(line);
            return;
        }
        System.out.println(leftID.getName());
        for (FactorContext factor : factores) {
            if (factor.ID() != null && !factor.ID().getText().equals(leftID.getName())){
                ID rightID = this.symbolTable.findVariable(factor.ID().getText());
                if (rightID != null) { // right ID exists
                    if (!rightID.isInitialized()) { // right ID is uninitialized
                        error.usingUninitializedVariable(line, rightID.getName());
                    }
                    if (leftID.getType().equals(rightID.getType())) { // variables with same type
                        leftID.setValue(rightID.getValue());
                        this.symbolTable.updateId(leftID);
                    } else {
                        error.variableType(line);
                    }
                } else {
                    error.unexistentVariable(line, ctx.getStop().getText());
                }
            } else if (factor.funcion() != null) {
                String functionName = factor.funcion().getText();
                Function function = (Function) symbolTable.findVariable(functionName);
                if (function != null){
                    if (!leftID.getType().equals(function.getType())) {
                        error.variableType(line);
                    }
                }
            } else if (factor.NUMERO() != null || factor.FLOTANTE() != null){
                if (!(leftID.getType().equals("int") || leftID.getType().equals("double"))){
                    error.variableType(line);
                }
            } else if (factor.LITERAL() != null){
                if (!leftID.getType().equals("char")){
                    error.variableType(line);
                }
            }
            else { // set value
                leftID.setValue(ctx.getStop().getText());
                symbolTable.updateId(leftID);
            }        
        }
        
    }


    private ArrayList<FactorContext> getFactor(ParseTree parseTree) {
        ArrayList<FactorContext> factores = new ArrayList<FactorContext>();
        for (ParseTree ctx : XPath.findAll(parseTree, "//factor", parser)) {
            factores.add((FactorContext) ctx);
        }
        return factores;
    }


    @Override public void exitDeclaracion_funcion(alParser.Declaracion_funcionContext ctx) {
        ArrayList<ID> params = new ArrayList<>();
        boolean ok = true;
        Function function = new Function();
        String type = ctx.tipodato().getText();
        String name = ctx.ID().getText();
        function.setType(type);
        function.setName(name);

        if (this.symbolTable.getFunctionPrototype(function) != null){
            error.existentFunction(ctx.getStart().getLine(), function.getName());
            ok = false;
        } else if (this.symbolTable.getContext() != 1){ //if not global context
            error.functionNotDeclaredInGlobalContext(ctx.getStart().getLine());
            ok = false;
        } else if (this.symbolTable.checkVariableDeclared(function)){
            error.existentVariable(ctx.getStart().getLine(), function.getName());
            ok = false;
        }

        if (ok){
            if (ctx.param_declaracion() != null) {
                this.symbolTable.addContext();
                params = getParamsDeclaration(ctx.param_declaracion(), params);
                for (ID id : params) {
                    if (!id.getName().equals(""))
                        if (this.symbolTable.checkVariableDeclared(id))
                            error.existentVariable(ctx.getStart().getLine(), id.getName());
                    symbolTable.insertID(id);
                }
                this.symbolTable.removeContext();
            }
            function.setParams(params);
            symbolTable.insertID(function);
        }
    }

    private ArrayList<ID> getParamsDeclaration(Param_declaracionContext ctx, ArrayList<ID> param){
        if (ctx.param_declaracion() != null) {
            ID id = new Variable();
            id.setName(ctx.ID() != null ? ctx.ID().getText() : "");
            id.setType(ctx.tipodato().getText());
            param.add(id);
            return getParamsDeclaration(ctx.param_declaracion(), param);
        } else{
            ID id = new Variable();
            id.setName(ctx.ID() != null ? ctx.ID().getText() : "");
            id.setType(ctx.tipodato().getText());
            param.add(id);
            return param;
        }
    }

    //First I create a function context, so i can set variables in the same place
    @Override public void enterDefinicion_funcion(alParser.Definicion_funcionContext ctx) {
        System.out.println("ENTRANDO EN DEFINICION DE FUNCION");
        symbolTable.addContext();
    }
    
    //And then I create the Function setting its type, parameters and name
    @Override public void exitDefinicion_funcion(alParser.Definicion_funcionContext ctx) {
        Function function = new Function();
        ArrayList<ID> params = new ArrayList<>();
        String type = ctx.tipodato().getText();
        String name = ctx.ID().getText();
        function.setType(type);
        function.setName(name);
        if (ctx.param_definicion() != null)
            params = getParamsDefinition(ctx.param_definicion(), params);
     
        function.setParams(params);
        if (this.symbolTable.getContext() == 1){
            Function prototype = this.symbolTable.getFunctionPrototype(function);
            if (prototype != null && !function.equals(prototype)){
                error.conflictingTypes(ctx.getStart().getLine(), function.getName());
            }
        }
        //System.out.println("Definicion Funcion Contexto:" + this.symbolTable.getContext());
        symbolTable.insertID(function);
    }

    private ArrayList<ID> getParamsDefinition(Param_definicionContext ctx, ArrayList<ID> param){
        if (ctx.param_definicion() != null) {
            ID id = new Variable();
            id.setName(ctx.ID().getText());
            id.setType(ctx.tipodato().getText());
            id.setValue("1");
            param.add(id);
            return getParamsDefinition(ctx.param_definicion(), param);
        } else{
            ID id = new Variable();
            id.setName(ctx.ID().getText());
            id.setType(ctx.tipodato().getText());
            id.setValue("1");
            param.add(id);
            return param;
        }
    }

    @Override public void exitFuncion(alParser.FuncionContext ctx) {
        String functionName = ctx.ID().getText();
        int paramCount;
        if (ctx.parametros() != null){
            paramCount = getParametersCount(ctx.parametros(), 0);
        } else {
            paramCount = 0;
        }
        ID function = this.symbolTable.findVariable(functionName);
        if (function == null){
            error.implicitDeclaration(ctx.getStart().getLine(), functionName);
            return;
        }
        else if (!(function instanceof Function)){
            error.callingNotFunction(ctx.getStart().getLine(), functionName);
        } else if (paramCount < ((Function) function).getParams().size()){
            error.tooFewArguments(ctx.getStart().getLine(), functionName);
        } else if (paramCount > ((Function) function).getParams().size()){
            error.tooManyArguments(ctx.getStart().getLine(), functionName);
        }
        function.setUsed(true);
    }

    private int getParametersCount(ParametrosContext ctx, int count){
        if (ctx.parametros() == null){
            return ++count;
        }else{
            return getParametersCount(ctx.parametros(), ++count);
        }
    }

    @Override public void exitProg(alParser.ProgContext ctx) {
        //symbolTable.printSymboltable();
        this.symbolTable.removeContext();
    }

}