package app;

import app.alParser.AsignacionContext;

// import org.antlr.v4.runtime.ParserRuleContext;
// import org.antlr.v4.runtime.tree.ErrorNode;
// import org.antlr.v4.runtime.tree.TerminalNode;

public class Listener extends alBaseListener{ 

    SymbolTable symbolTable = new SymbolTable();
    ErrorMessages error = new ErrorMessages();

    @Override public void enterBloque(alParser.BloqueContext ctx) {
        this.symbolTable.addContext();       
    }

    @Override public void exitBloque(alParser.BloqueContext ctx) {
        this.symbolTable.removeContext();       
    }
    
    @Override public void enterDeclaracion(alParser.DeclaracionContext ctx) { }

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
        String id_name = ctx.ID().getText();
        System.out.println("Asignacion:" + id_name);
        if (!symbolTable.checkVariable(id_name)){
            error.UnexistentVariable(id_name, ctx.getStop().getLine());
        }
        else{
            ID id = symbolTable.getId(id_name);
            
            boolean initialized = checkDataType(id.getDataType(), ctx.getStop().getType());
            if (!initialized){
                error.BadSyntax(ctx.getStop().getLine());
            }
            else{
                this.symbolTable.setInitialized(id.getName(), initialized);
            }
        }
    }


    private boolean checkDataType(String variable_type, int data_type){
        if (alLexer.NUMERO == data_type && variable_type.equals("int")){
            return true;
        }
        else{
            return false;
        }
    }
    

}