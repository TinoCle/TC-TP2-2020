package app.SymbolsTable;

public class Variable extends ID {
    
    public Variable(String dataType, String token) {
        super(dataType, token);
    }

    public Variable (){
        super();
    }

    @Override
    public String toString() {
        String variable = getType() + " " + getName() + " = " + getValue();
        if (isUsed()) {
            variable += " (used)";
        } else {
            variable += " (unused)";
        }
        return variable;
    }

}