package app.SymbolsTable;

import java.util.HashMap;
import java.util.LinkedList;

public class SymbolTable { 

    private LinkedList<HashMap<String, ID>> symbolTable;
    private LinkedList<HashMap<String, ID>> historicSymbolTable; // this is used at the end of the program to print all the symbols and contexts
    private static SymbolTable instance;

    public static SymbolTable getInstance() {
        if (instance == null) {
            instance = new SymbolTable();
        }
        return instance;
    }

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
    
    //Temporal context used to store function paramaters
    public void addParamContext(){
        HashMap<String, ID> context = new HashMap<String, ID>();
        symbolTable.add(context);
    }

    public void removeContext() {
        //this.printSymboltable2();
        symbolTable.removeLast();
    }

    public void insertID(ID id) {
        symbolTable.getLast().put(id.getName(), id);
        int index = symbolTable.size()-1;
        historicSymbolTable.get(index).put(id.getName(), id);
        
    }

    public void insertParam(ID id){
        symbolTable.getLast().put(id.getName(), id);
    }

    public boolean checkVariableDeclared(ID id){
        return this.symbolTable.getLast().containsKey(id.getName());
    }

    public void printSymboltable() {
        int ctx = 1;
        System.out.println("\n=== SYMBOL TABLE ===");
        for (HashMap<String, ID> entry : this.historicSymbolTable) {
            System.out.println("Contexto: " + ctx++ + " {");
            for(ID id : entry.values()) {
                System.out.println("    " + id.toString());
            }
            System.out.println("}");
        }
    }

    public void printSymboltable2() {
        System.out.println("Contexto:"+ this.getContext());
        for (String key : this.symbolTable.getLast().keySet()) {
            System.out.println(key);
        }
    }

    public ID findVariable(String name){
        for (HashMap<String, ID> entry : this.symbolTable) {
            for (ID id : entry.values()) {
                if (id.getName().equals(name)) {
                    id.setUsed(true);
                    return id;
                }
            }
        }
        return null;
    }

    public void setUsed(String name){
        for (HashMap<String, ID> entry : this.symbolTable) {
            for (ID id : entry.values()) {
                if (id.getName().equals(name)) {
                    id.setUsed(true);
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

    public int getHistoricContext() {
        return this.historicSymbolTable.size();
    }

    public LinkedList<ID> getCurrentContextUnusedVariables() {
        LinkedList<ID> unused = new LinkedList<ID>();
        HashMap<String, ID> IDs = this.symbolTable.getLast();
        for(ID id : IDs.values()) {
            if (id instanceof Function && id.getName().equals("main")) { // function main is always used
                continue;
            }
            if (!id.isUsed()) {
                unused.add(id);
            }
        }
        return unused;
    }

}