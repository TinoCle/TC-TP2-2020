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
        addContext();
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
    }

    public boolean checkVariableDeclared(String name){
        return this.symbolTable.getLast().containsKey(name);
    }

    public ID findVariable(String name){
        for (HashMap<String, ID> entry : this.symbolTable) {
            for (String key : entry.keySet()) {
                if (key.equals(name)){
                    return entry.get(key);
                }
            }
        }
        return null;
    }

    public void setInitialized(String name, boolean initialized){
        for (int i = symbolTable.size() - 1; i >= 0; i--) {
            if (symbolTable.get(i).get(name) != null) {
                symbolTable.get(i).get(name).setInitialized(initialized);
                System.out.println("Inicialicé la variable " + name + " del contexto " + i);
                return;
            }
        }     
    }
}