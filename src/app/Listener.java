package app;

import app.alParser.AsignacionContext;
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
        this.symbolTable.addContext();
    }

    @Override public void exitBloque(alParser.BloqueContext ctx) {
        this.symbolTable.removeContext();
    }
    
    @Override public void exitDeclaracion(alParser.DeclaracionContext ctx) {
        ID id;
        if (ctx.asignacion() == null) { // just declaration
            id = new ID(ctx.tipodato().getText(), ctx.ID().getText());
        } else {
            id = new ID(ctx.tipodato().getText(), ctx.asignacion().ID().getText());
        }
        if (!this.symbolTable.checkVariableDeclared(id)) { // new variable
            symbolTable.insertID(id);
        } else {
            error.existentVariable(ctx.getStop().getLine(), id.getName());
        }
    }

    @Override
    public void exitAsignacion(AsignacionContext ctx) {
        this.checkAsignacion(ctx);
    }

    private void checkAsignacion(AsignacionContext ctx) {
        ID leftId = symbolTable.findVariable(ctx.ID().getText());
        int type = ctx.getStop().getType();
        int line = ctx.getStop().getLine();
        if (leftId == null) { // left ID doesn't exists
            error.unexistentVariable(line, ctx.ID().getText());
            return;
        }
        if (dataTypes.get(type).equals("id")) { // trying to asign variable
            ID rightId = this.symbolTable.findVariable(ctx.getStop().getText());
            if (rightId != null) { // right ID exists
                if (!rightId.isInitialized()) { // right ID is uninitialized
                    error.usingUninitializedVariable(line, ctx.getStop().getText());
                }
                if (leftId.getType().equals(rightId.getType())) { // variables with same type
                    leftId.setValue(rightId.getValue());
                    this.symbolTable.updateId(leftId);
                } else {
                    error.variableType(line);
                }
            } else {
                error.unexistentVariable(line, ctx.getStop().getText());
            }
        } else if (!dataTypes.get(type).equals(leftId.getType())) { // trying to set some value and missmatching its type
            error.variableType(line);
        } else { //set value
            leftId.setValue(Integer.parseInt(ctx.getStop().getText()));
            symbolTable.updateId(leftId);
        }
    }

}