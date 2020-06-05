package app;

import app.alParser.AsignacionContext;
import app.alParser.Param_declaracionContext;
import app.alParser.Param_definicionContext;

import java.util.ArrayList;
import java.util.HashMap;

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
        //this.symbolTable.addContext();
    }

    @Override public void exitBloque(alParser.BloqueContext ctx) {
        this.symbolTable.removeContext();
    }
    
    @Override public void exitDeclaracion(alParser.DeclaracionContext ctx) {
        ID id;
        if (ctx.asignacion() == null) { // just declaration, asignation also inserts the ID into symbolTable
            id = new ID(ctx.tipodato().getText(), ctx.ID().getText());
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
            leftID = new ID(ctx.getParent().getStart().getText(), leftIdName);
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
            leftID.setValue(Integer.parseInt(ctx.getStop().getText()));
            symbolTable.updateId(leftID);
        }
    }

    //TODO: insert function in current and check if it's the global context, if not show error
    @Override public void exitDeclaracion_funcion(alParser.Declaracion_funcionContext ctx) {
        ArrayList<ID> params = new ArrayList<>();
        Function function = new Function();
        String type = ctx.tipodato().getText();
        String name = ctx.ID().getText();
        function.setType(type);
        function.setName(name);
        if (ctx.param_declaracion() != null)
            params = getParamsDeclaration(ctx.param_declaracion(), params);
        function.setParams(params);
        System.out.println(function);
        //symbolTable.insertID(function);
    }

    private ArrayList<ID> getParamsDeclaration(Param_declaracionContext ctx, ArrayList<ID> param){
        if (ctx.param_declaracion() != null) {
            ID id = new ID();
            if (ctx.ID() != null)
                id.setName(ctx.ID().getText());
            else
                id.setName("");
            id.setType(ctx.tipodato().getText());
            param.add(id);
            return getParamsDeclaration(ctx.param_declaracion(), param);
        } else{
            ID id = new ID();
            if (ctx.ID() != null)
                id.setName(ctx.ID().getText());
            else
                id.setName("");
            id.setType(ctx.tipodato().getText());
            param.add(id);
            return param;
        }
    }

    //First I create a function context, so i can set variables in the same place
    @Override public void enterDefinicion_funcion(alParser.Definicion_funcionContext ctx) { 
        symbolTable.addContext();
    }

    //Then I have to add the parameters to the function context created previously
    @Override public void exitParam_definicion(alParser.Param_definicionContext ctx) { 
        if (ctx != null){
            ArrayList<ID> params = new ArrayList<>();
            params = getParamsDefinition(ctx, params);
            for (ID id : params) {
                symbolTable.insertID(id);
            }
        }
    }
    
    //And finally I create the Function setting its type, parameters and name
    @Override public void exitDefinicion_funcion(alParser.Definicion_funcionContext ctx) {
        Function function = new Function();
        ArrayList<ID> params = new ArrayList<>();
        String name = ctx.ID().getText();
        String type = ctx.tipodato().getText();
        function.setType(type);
        function.setName(name);
        //symbolTable.findVariable(name)
        if (ctx.param_definicion() != null)
            params = getParamsDefinition(ctx.param_definicion(), params);
        function.setParams(params);
        for (ID id : params) {
            symbolTable.insertID(id);
        }
        System.out.println(function);
        //symbolTable.insertID(function);
    }

    private ArrayList<ID> getParamsDefinition(Param_definicionContext ctx, ArrayList<ID> param){
        if (ctx.param_definicion() != null) {
            ID id = new ID();
            id.setName(ctx.ID().getText());
            id.setType(ctx.tipodato().getText());
            id.setValue(1);
            param.add(id);
            return getParamsDefinition(ctx.param_definicion(), param);
        } else{
            ID id = new ID();
            id.setName(ctx.ID().getText());
            id.setType(ctx.tipodato().getText());
            id.setValue(1);
            param.add(id);
            return param;
        }
    }

}