package app;

import app.alParser.*;
import app.SymbolsTable.*;
import app.Auxiliars.*;
import java.util.ArrayList;

public class CustomListener extends alBaseListener {
    SymbolTable symbolTable = SymbolTable.getInstance();
    ErrorReporter error = ErrorReporter.getInstance();
    alParser parser;

    public CustomListener(alParser parser) {
        this.parser = parser;
    }

    @Override
    public void enterBloque(alParser.BloqueContext ctx) {
        if (ctx.getParent() instanceof Definicion_funcionContext) {
            Definicion_funcionContext fnCtx = (Definicion_funcionContext) ctx.getParent();
            Function function = AuxFunctions.processFunction(fnCtx);
            this.symbolTable.insertID(function);
            this.symbolTable.addContext();
            if (fnCtx.param_definicion() != null) {
                for (ID id : function.getParams()) {
                    symbolTable.insertID(id);
                }
            }
        } else {
            this.symbolTable.addContext();
        }
    }

    @Override
    public void exitBloque(alParser.BloqueContext ctx) {
        error.unusedVariables(symbolTable.getCurrentContextUnusedVariables(), symbolTable.getHistoricContext());
        this.symbolTable.removeContext();
    }

    @Override
    public void exitDeclaracion(alParser.DeclaracionContext ctx) {
        if (ctx.asignacion() == null) { // just declaration, asignation also inserts the ID into symbolTable
            ID id = new Variable(ctx.tipodato().getText(), ctx.ID().getText());
            if (!this.symbolTable.checkVariableDeclared(id)) { // new variable
                symbolTable.insertID(id);
            } else {
                error.existentVariable(ctx.getStop().getLine(), id.getName());
            }
        }
    }

    @Override
    public void exitAsignacion(AsignacionContext ctx) {
        ID leftID = symbolTable.findVariable(ctx.ID().getText());
        int line = ctx.getStart().getLine();
        if (ctx.getParent() instanceof DeclaracionContext){ // comming from 'declaracion', have to declare a new variable "leftID"
            String leftIdName = ctx.ID().getText();
            String leftIdType = ((DeclaracionContext) ctx.getParent()).tipodato().getText();
            leftID = new Variable(leftIdType, leftIdName);
            if (!this.symbolTable.checkVariableDeclared(leftID)) { // new variable
                symbolTable.insertID(leftID);
            } else {
                error.existentVariable(ctx.getStop().getLine(), leftID.getName());
            }
        }
        ArrayList<FactorContext> factores = AuxFunctions.getFactors(ctx, this.parser);
        if (leftID == null) { // left ID doesn't exists
            error.unexistentVariable(line, ctx.ID().getText());
            return;
        }
        if (factores == null){
            error.missingAssignment(line);
            return;
        }
        for (FactorContext factor : factores) {
            if (!AuxFunctions.compareTypes(leftID.getType(), factor)){
                error.variableType(line);
            } else {
                symbolTable.updateId(AuxFunctions.setValue(leftID, factor));
            }
        }
    }

    //Function Prototype
    @Override public void exitDeclaracion_funcion(alParser.Declaracion_funcionContext ctx) {
        String type = ctx.tipodato().getText();
        String name = ctx.ID().getText();
        Function function = new Function(type, name);
        ArrayList<ID> params = new ArrayList<>();
        if (AuxFunctions.checkFunction(function, ctx)){
            if (ctx.param_declaracion() != null) {
                this.symbolTable.addParamContext();
                params = AuxFunctions.getParams(ctx.param_declaracion(), params);
                for (ID id : params) {
                    if (!id.getName().equals(""))
                        if (this.symbolTable.checkVariableDeclared(id))
                            error.existentVariable(ctx.getStart().getLine(), id.getName());
                    symbolTable.insertParam(id);
                }
                this.symbolTable.removeContext();
            }
            function.setParams(params);
            symbolTable.insertID(function);
        }
    }
    
    //Checking if function has return
    @Override
    public void exitDefinicion_funcion(Definicion_funcionContext ctx) {
        if (!ctx.ID().getText().equals("main")){
            boolean hasReturn = AuxFunctions.hasExit(ctx, parser);
            if (!ctx.tipodato().getText().equals("void") && !hasReturn){
                error.missingReturn(ctx.getStart().getLine());
            }
        }
    }

    //Function Call
    @Override public void exitFuncion(alParser.FuncionContext ctx) {
        String functionName = ctx.ID().getText();
        int paramCount = AuxFunctions.getFactors(ctx.parametros(), this.parser).size();
        ID function = this.symbolTable.findVariable(functionName);
        if (function == null){
            error.implicitDeclaration(ctx.getStart().getLine(), functionName);
            return;
        }
        if (!(function instanceof Function)){
            error.callingNotFunction(ctx.getStart().getLine(), functionName);
        } else if (paramCount < ((Function) function).getParams().size()){
            error.tooFewArguments(ctx.getStart().getLine(), functionName);
        } else if (paramCount > ((Function) function).getParams().size()){
            error.tooManyArguments(ctx.getStart().getLine(), functionName);
        }
        function.setUsed(true);
    }

    //Return Statement
    @Override public void exitRetornar(alParser.RetornarContext ctx) {        
        Definicion_funcionContext fnCtx = AuxFunctions.findFunctionCtx(ctx);
        if (fnCtx == null){
            error.returnOutsideFunction(ctx.getStart().getLine());
        }
        else{ //it's in a function context
            String functionType = fnCtx.tipodato().getText();
            ArrayList<FactorContext> returnFactors = AuxFunctions.getFactors(ctx, this.parser);
            if (functionType.equals("void") && returnFactors != null){ //returning values inside void function
                error.returnValueVoid(ctx.getStart().getLine());
                return;
            } else if (!functionType.equals("void") && returnFactors == null){ //not returning values in non void function
                error.returnNoValueNonVoid(ctx.getStart().getLine());
                return;
            } else {
                for (FactorContext factor : returnFactors) {
                    if (!AuxFunctions.compareTypes(functionType, factor)){
                        error.missmatchingReturnType(ctx.getStart().getLine());
                        return;
                    }
                }
            }
        }
    }
 
    @Override public void exitProg(alParser.ProgContext ctx) {
        error.unusedVariables(symbolTable.getCurrentContextUnusedVariables(), symbolTable.getHistoricContext());
        if (!error.codeWithErrors) { // we print the entire symbol table only if there were no errors
            symbolTable.printSymboltable();
        }
        this.symbolTable.removeContext();
    }
}