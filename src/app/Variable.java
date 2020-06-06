package app;

public class Variable extends ID {
    
    public Variable(String dataType, String token) {
        super(dataType, token);
    }

    public Variable (){
        super();
    }

    @Override
    public String toString() {
        return "\n=== Variable ===\nName:\t" + getName() + "\nType:\t" + getType() + "\nValue:\t" + getValue();
    }

}