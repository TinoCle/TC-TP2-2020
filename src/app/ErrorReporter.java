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

    public void unexistentVariable(int line, String name) {
        System.out.println(ANSI_RED + "ERROR\tLine " + line+ ": The variable '" + name + "' wasn't declared." + ANSI_RESET);
    }

    public void variableType(int line) {
        System.out.println(ANSI_RED + "ERROR\tLine " + line+ ": Variable type missmatching." + ANSI_RESET);
    }

    public void usingUninitializedVariable(int line, String name) {
        System.out.println(ANSI_YELLOW + "WARNING\tLine " + line+ ": The variable '" + name + "' is being used uninitialized." + ANSI_RESET);
    }
}