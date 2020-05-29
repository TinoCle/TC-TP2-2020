package app;

import java.util.HashMap;
import java.util.LinkedList;

// import org.antlr.v4.runtime.ParserRuleContext;
// import org.antlr.v4.runtime.tree.ErrorNode;
// import org.antlr.v4.runtime.tree.TerminalNode;

public class SymbolTable { 

    private LinkedList<HashMap<String, ID>> symbolTable;

    public SymbolTable() {
        symbolTable = new LinkedList<HashMap<String, ID>>();
    }

    public void addContext() {
        HashMap<String, ID> context = new HashMap<String, ID>();
        symbolTable.add(context);
    }

    public void removeContext() {
        symbolTable.removeLast();
    }

    public void insertID(String name, ID id) {
        symbolTable.getLast().put(name, id);
        System.out.println("\nID " + name + " insertado en el contexto " + symbolTable.size());
    }

    public boolean checkVariableDeclared(String name){
        return this.symbolTable.getLast().containsKey(name);
    }

    public boolean checkVariable(String name){
        ID id = this.symbolTable.getLast().get(name);
        if (id == null){
            return false;
        }
        return true;
    }

    public ID getId(String name){
        return this.symbolTable.getLast().get(name);
    }

    public void setInitialized(String name, boolean initialized){
        this.symbolTable.getLast().get(name).setInitialized(initialized);
    }

}