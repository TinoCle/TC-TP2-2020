package app;

import app.alParser.AsignacionContext;
import java.util.HashMap;

// import org.antlr.v4.runtime.ParserRuleContext;
// import org.antlr.v4.runtime.tree.ErrorNode;
// import org.antlr.v4.runtime.tree.TerminalNode;

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
        ID id = new ID(ctx.tipodato().getText(), ctx.ID().getText(), ctx.asign() != null);
        if (!this.symbolTable.checkVariableDeclared(id.getName())) { // unexistent variable?
            symbolTable.insertID(ctx.ID().getText(), id);
        } else {
            error.existentVariable(id.getName(), ctx.getStop().getLine());
        }
        if (id.isInitialized() && !checkDataType(id.getType(), ctx.getStop().getType(), ctx.getStop().getText(), ctx.getStop().getLine())) { // types missmatch?
            error.variableType(ctx.getStop().getLine());
        }
    }

    @Override
    public void exitAsignacion(AsignacionContext ctx) {
        String idName = ctx.ID().getText();
        ID id = symbolTable.findVariable(idName);
        if (id != null){ // variable exists?
            if (checkDataType(id.getType(), ctx.getStop().getType(), ctx.getStop().getText(), ctx.getStop().getLine())){ // types match?
                this.symbolTable.setInitialized(id.getName(), true);
            } else {
                error.variableType(ctx.getStop().getLine());
            }
        } else {
            error.unexistentVariable(idName, ctx.getStop().getLine());
        }
    }


    private boolean checkDataType(String variableType, int dataType, String name, Integer line) {
        if (dataTypes.get(dataType).equals("id")) {
            ID id = symbolTable.findVariable(name);
            if (id != null) { // second variable exists?
                if (!id.isInitialized()) { // second variable uninitialized?
                    error.usingUnasignedVariable(line, name);
                }
                return id.getType().equals(variableType);
            } else {
                error.unexistentVariable(name, line);
                return true; // no type missmatching
            }
            // System.out.println("Asigning " + id.getType() + " to a " + variableType + " variable.");
        }
        // System.out.println("Asigning " + dataTypes.get(dataType) + " to a " + variableType + " variable.");
        return dataTypes.get(dataType).equals(variableType);
    }

}