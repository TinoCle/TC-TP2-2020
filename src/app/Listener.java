package app;

import app.alParser.AsignacionContext;
import java.util.HashMap;

// import org.antlr.v4.runtime.ParserRuleContext;
// import org.antlr.v4.runtime.tree.ErrorNode;
// import org.antlr.v4.runtime.tree.TerminalNode;

public class Listener extends alBaseListener{ 

    SymbolTable symbolTable = new SymbolTable();
    ErrorMessages error = new ErrorMessages();
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
        if (this.symbolTable.checkVariableDeclared(id.getName())){
            error.existentVariable(id.getName(), ctx.getStop().getLine());
        }else{
            // System.out.println("getStop getType: " + ctx.getStop().getType());
            // System.out.println("\n" + id.toString());
            symbolTable.insertID(ctx.ID().getText(), id);    
        }
        if (id.isInitialized() && !checkDataType(id.getType(), ctx.getStop().getType(), ctx.getStop().getText())) {
            error.variableType(ctx.getStop().getLine());
        }
    }

    @Override
    public void exitAsignacion(AsignacionContext ctx) {
        String idName = ctx.ID().getText();
        ID id = symbolTable.findVariable(idName);
        if (id == null){
            error.unexistentVariable(idName, ctx.getStop().getLine());
        } else{
            boolean initialized = checkDataType(id.getType(), ctx.getStop().getType(), ctx.getStop().getText());
            if (!initialized){
                error.variableType(ctx.getStop().getLine());
            } else{
                this.symbolTable.setInitialized(id.getName(), initialized);
            }
        }
    }


    private boolean checkDataType(String variableType, int dataType, String name){
        if (dataTypes.get(dataType) == "id"){
            ID id = symbolTable.findVariable(name);
            // System.out.println("Asigning " + id.getType() + " to a " + variableType + " variable.");
            return id.getType().equals(variableType);
        }
        // System.out.println("Asigning " + dataTypes.get(dataType) + " to a " + variableType + " variable.");
        return dataTypes.get(dataType).equals(variableType);
    }
    

}