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
        return getType() + " " + getName() + " = " + getValue();
    }

}