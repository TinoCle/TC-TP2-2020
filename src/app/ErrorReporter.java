package app;
public class ErrorReporter {
    
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    private static ErrorReporter instance = null;

    public static ErrorReporter getInstance() {
        if (instance == null) {
            instance = new ErrorReporter();
        }
        return instance;
    }

    public void existentVariable(int line, String name) {
        System.out.println(ANSI_RED + "ERROR\tLine " + line+ ": The variable '" + name + "' was already declared in this context." + ANSI_RESET);
    }

    public void existentFunction(int line, String name) {
        System.out.println(ANSI_RED + "ERROR\tLine " + line+ ": Function prototype '" + name + "' already declared." + ANSI_RESET);
    }

    public void conflictingTypes(int line, String name){
        System.out.println(ANSI_RED + "ERROR\tLine " + line+ ": Conflicting types for '" + name + "'" + ANSI_RESET);
    }

    public void callingNotFunction(int line, String name){
        System.out.println(ANSI_RED + "ERROR\tLine " + line+ ": Called object '" + name + "' is not a function or function pointer" + ANSI_RESET);
    }

    public void tooFewArguments(int line, String name){
        System.out.println(ANSI_RED + "ERROR\tLine " + line+ ": Too few arguments to function '" + name + "'" + ANSI_RESET);
    }

    public void tooManyArguments(int line, String name){
        System.out.println(ANSI_RED + "ERROR\tLine " + line+ ": Too many arguments to function '" + name + "'" + ANSI_RESET);
    }

    public void implicitDeclaration(int line, String name) {
        System.out.println(ANSI_YELLOW + "WARNING\tLine " + line+ ": Implicit declaration of function '" + name + "'" + ANSI_RESET);
    }

    public void unexistentVariable(int line, String name) {
        System.out.println(ANSI_RED + "ERROR\tLine " + line+ ": The variable '" + name + "' wasn't declared." + ANSI_RESET);
    }

    public void variableType(int line) {
        System.out.println(ANSI_YELLOW + "WARNING\tLine " + line+ ": Variable type missmatching." + ANSI_RESET);
    }

    public void missingAssignment(int line){
        System.out.println(ANSI_RED + "ERROR\tLine " + line+ ": Expected declaration or statement at end of input" + ANSI_RESET);
    }

    public void usingUninitializedVariable(int line, String name) {
        System.out.println(ANSI_YELLOW + "WARNING\tLine " + line+ ": The variable '" + name + "' is being used uninitialized." + ANSI_RESET);
    }

    public void functionNotDeclaredInGlobalContext(int line){
        System.out.println(ANSI_RED + "ERROR\tLine " + line+ ": The function prototype must be in the glogal context" + ANSI_RESET);
    }

}