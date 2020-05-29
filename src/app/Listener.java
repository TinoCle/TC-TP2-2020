package app;

import app.alParser.AsignacionContext;

// import org.antlr.v4.runtime.ParserRuleContext;
// import org.antlr.v4.runtime.tree.ErrorNode;
// import org.antlr.v4.runtime.tree.TerminalNode;

public class Listener extends alBaseListener{ 

    SymbolTable symbolTable = new SymbolTable();
    ErrorMessages error = new ErrorMessages();

    public Listener() {
        System.out.println("\n");
    }

    @Override public void enterBloque(alParser.BloqueContext ctx) {
        this.symbolTable.addContext();       
    }

    @Override public void exitBloque(alParser.BloqueContext ctx) {
        this.symbolTable.removeContext();       
    }
    
    @Override public void exitDeclaracion(alParser.DeclaracionContext ctx) {
        ID id = new ID(ctx.tipodato().getText(), ctx.ID().getText(), !(ctx.asign() == null));
        if (this.symbolTable.checkVariableDeclared(id.getName())){
            error.ExistentVariable(id.getName(), ctx.getStop().getLine());
        }else{
            // System.out.println("getStop getType: " + ctx.getStop().getType());
            // System.out.println("\n" + id.toString());
            symbolTable.insertID(ctx.ID().getText(), id);    
        }
    }

    @Override
    public void exitAsignacion(AsignacionContext ctx) {
        String idName = ctx.ID().getText();
        if (!symbolTable.checkVariable(idName)){
            error.UnexistentVariable(idName, ctx.getStop().getLine());
        } else{
            ID id = symbolTable.getId(idName);
            
            boolean initialized = checkDataType(id.getDataType(), ctx.getStop().getType());
            if (!initialized){
                error.BadSyntax(ctx.getStop().getLine());
            }
            else{
                this.symbolTable.setInitialized(id.getName(), initialized);
            }
        }
    }


    private boolean checkDataType(String variableType, int dataType){
        if (alLexer.NUMERO == dataType && variableType.equals("int")){
            return true;
        }
        else{
            return false;
        }
    }
    

}