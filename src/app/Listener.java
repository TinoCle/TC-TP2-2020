package app;

import app.alParser.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.antlr.v4.runtime.misc.Interval;

public class Listener extends alBaseListener{ 

    SymbolTable symbolTable = new SymbolTable();
    ErrorReporter error = ErrorReporter.getInstance();
    HashMap<Integer, String> dataTypes = new HashMap<>();

    public Listener() {
        System.out.println("\n");
        dataTypes.put(alLexer.NUMERO, "int");
        dataTypes.put(alLexer.FLOTANTE, "double");
        dataTypes.put(alLexer.LITERAL, "char");
        dataTypes.put(alLexer.ID, "id");
    }

    @Override public void enterBloque(alParser.BloqueContext ctx) {
        if (ctx.getParent() instanceof Definicion_funcionContext){
            Definicion_funcionContext fnCtx = (Definicion_funcionContext) ctx.getParent();
            if (fnCtx.param_definicion() != null){
                ArrayList<ID> params = new ArrayList<>();
                params = getParamsDefinition(fnCtx.param_definicion(), params);
                for (ID id : params) {
                    if (this.symbolTable.checkVariableDeclared(id))
                        error.existentVariable(ctx.getStart().getLine(), id.getName());
                    symbolTable.insertID(id);
                }
            }
        } else{
            this.symbolTable.addContext();
        }
    }

    @Override public void exitBloque(alParser.BloqueContext ctx) {
        this.symbolTable.removeContext();
    }
    
    @Override public void exitDeclaracion(alParser.DeclaracionContext ctx) {
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

    private String getDeclaredVariableName(String type, String string) {
        String returned = "";
        for (int i = type.length(); i<string.length(); i++) {
            if (string.charAt(i) == '=') {
                break;
            }
            returned += string.charAt(i);
        }
        return returned;
    }

    private void checkAsignacion(AsignacionContext ctx) {
        ID leftID = symbolTable.findVariable(ctx.ID().getText());
        if (ctx.getParent().getStart().getType() != alLexer.ID) { // comming from 'declaracion', build leftID
            String leftIdName = this.getDeclaredVariableName(
                ctx.getParent().getStart().getText(),
                ctx.getParent().getText()
            );
            leftID = new Variable(ctx.getParent().getStart().getText(), leftIdName);
            if (!this.symbolTable.checkVariableDeclared(leftID)) { // new variable
                symbolTable.insertID(leftID);
            } else {
                error.existentVariable(ctx.getStop().getLine(), leftID.getName());
            }
        }
        int type = ctx.getStop().getType();
        int line = ctx.getStop().getLine();
        if (leftID == null) { // left ID doesn't exists
            error.unexistentVariable(line, ctx.ID().getText());
            return;
        }
        if (dataTypes.get(type).equals("id")) { // trying to asign variable
            ID rightID = this.symbolTable.findVariable(ctx.getStop().getText());
            if (rightID != null) { // right ID exists
                if (!rightID.isInitialized()) { // right ID is uninitialized
                    error.usingUninitializedVariable(line, ctx.getStop().getText());
                }
                if (leftID.getType().equals(rightID.getType())) { // variables with same type
                    leftID.setValue(rightID.getValue());
                    System.out.println(leftID.getName() + " = " + leftID.getValue());
                    this.symbolTable.updateId(leftID);
                } else {
                    error.variableType(line);
                }
            } else {
                error.unexistentVariable(line, ctx.getStop().getText());
            }
        } else if (!dataTypes.get(type).equals(leftID.getType())) { // trying to set some value and missmatching its type
            error.variableType(line);
        } else { //set value
            leftID.setValue(ctx.getStop().getText());
            symbolTable.updateId(leftID);
        }
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
            error.functionNotDeclaredGlobalContext(ctx.getStart().getLine());
            ok = false;
        } else if (this.symbolTable.checkVariableDeclared(function)){
            error.existentVariable(ctx.getStart().getLine(), function.getName());
            ok = false;
        }

        if (ok){
            if (ctx.param_declaracion() != null) {
                params = getParamsDeclaration(ctx.param_declaracion(), params);
                for (ID id : params) {
                    if (!id.getName().equals(""))
                        if (this.symbolTable.checkVariableDeclared(id))
                            error.existentVariable(ctx.getStart().getLine(), id.getName());
                    symbolTable.insertID(id);
                }
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
            if (!function.equals(prototype)){
                error.conflictingTypes(ctx.getStart().getLine(), function.getName());
            }
        }
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

}