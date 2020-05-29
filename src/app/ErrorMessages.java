package app;

public class ErrorMessages {
    
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    public void ExistentVariable(String name, int line) {
        System.out.println(ANSI_RED + "ERROR Line " + line+ ": The variable '" + name + "' was already declared." + ANSI_RESET);
    }

    public void UnexistentVariable(String name, int line) {
        System.out.println(ANSI_RED + "ERROR Line " + line+ ": The variable '" + name + "' wasn't declared." + ANSI_RESET);
    }

    public void BadSyntax(int line) {
        System.out.println(ANSI_RED + "ERROR Line " + line+ ": Bad syntax." + ANSI_RESET);
    }
}