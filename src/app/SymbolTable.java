package app;

import java.util.HashMap;
import java.util.LinkedList;

public class SymbolTable { 

    private LinkedList<HashMap<String, ID>> symbolTable;

    public SymbolTable() {
        symbolTable = new LinkedList<HashMap<String, ID>>();
        addContext(); // global context
    }

    public void addContext() {
        HashMap<String, ID> context = new HashMap<String, ID>();
        symbolTable.add(context);
    }

    public void removeContext() {
        symbolTable.removeLast();
    }

    public void insertID(ID id) {
        symbolTable.getLast().put(id.getName(), id);
    }

    public boolean checkVariableDeclared(ID id){
        return this.symbolTable.getLast().containsKey(id.getName());
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

    /* 
    public Function findFunction(String name){
        return this.symbolTable.getLast().get(name);
    } 
    */

    public void updateId(ID id){
        for (int i = symbolTable.size() - 1; i >= 0; i--) {
            if (symbolTable.get(i).get(id.getName()) != null) {
                symbolTable.get(i).replace(id.getName(), id);
                break;
            }
        }     
    }
}