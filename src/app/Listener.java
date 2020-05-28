package app;

// import org.antlr.v4.runtime.ParserRuleContext;
// import org.antlr.v4.runtime.tree.ErrorNode;
// import org.antlr.v4.runtime.tree.TerminalNode;

public class Listener extends alBaseListener{ 

    SymbolTable symbolTable = new SymbolTable();

    @Override public void enterBloque(alParser.BloqueContext ctx) {
        this.symbolTable.addContext();       
    }

    @Override public void exitBloque(alParser.BloqueContext ctx) {
        this.symbolTable.removeContext();       
    }
    
    @Override public void enterDeclaracion(alParser.DeclaracionContext ctx) { }

    @Override public void exitDeclaracion(alParser.DeclaracionContext ctx) {
        ID id = new ID(ctx.tipodato().getText(), ctx.ID().getText(), !(ctx.asign() == null));
        System.out.println("\n" + id.toString());
        symbolTable.insertID(ctx.ID().getText(), id);
    }
    

}