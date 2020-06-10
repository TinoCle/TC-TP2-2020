package app;

import java.util.HashMap;
import java.util.LinkedList;

public class SymbolTable { 

    private LinkedList<HashMap<String, ID>> symbolTable;
    private LinkedList<HashMap<String, ID>> historicSymbolTable; // this is used at the end of the program to print all the symbols and contexts

    public SymbolTable() {
        symbolTable = new LinkedList<HashMap<String, ID>>();
        historicSymbolTable = new LinkedList<HashMap<String, ID>>();
        addContext(); // global context
    }

    public void addContext() {
        HashMap<String, ID> context = new HashMap<String, ID>();
        symbolTable.add(context);
        historicSymbolTable.add(context);
    }

    public void removeContext() {
        symbolTable.removeLast();
    }

    public void insertID(ID id) {
        symbolTable.getLast().put(id.getName(), id);
        historicSymbolTable.getLast().put(id.getName(), id);
    }

    public boolean checkVariableDeclared(ID id){
        return this.symbolTable.getLast().containsKey(id.getName());
    }

    public void printSymboltable() {
        int ctx = 1;
        for (HashMap<String, ID> entry : this.historicSymbolTable) {
            System.out.println("Contexto: " + ctx++ + " {");
            for(ID id : entry.values()) {
                System.out.println("    " + id.toString());
            }
            System.out.println("}");
        }
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

    public void setUsed(String name){
        for (HashMap<String, ID> entry : this.symbolTable) {
            for (String key : entry.keySet()) {
                if (key.equals(name)){
                    
                }
            }
        }
    }

    public Function getFunctionPrototype(Function function){
        ID idFound = this.symbolTable.getFirst().get(function.getName());
        if (idFound instanceof Function){
            return (Function) idFound;
        } else{
            return null;
        }
    }

    public void updateId(ID id){
        for (int i = symbolTable.size() - 1; i >= 0; i--) {
            if (symbolTable.get(i).get(id.getName()) != null) {
                symbolTable.get(i).replace(id.getName(), id);
                historicSymbolTable.get(i).replace(id.getName(), id);
                break;
            }
        }     
    }

    public int getContext(){
        return this.symbolTable.size();
    }

}