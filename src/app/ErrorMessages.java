package app;

public class ErrorMessages {
    
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    public void existentVariable(String name, int line) {
        System.out.println(ANSI_RED + "ERROR Line " + line+ ": The variable '" + name + "' was already declared." + ANSI_RESET);
    }

    public void unexistentVariable(String name, int line) {
        System.out.println(ANSI_RED + "ERROR Line " + line+ ": The variable '" + name + "' wasn't declared." + ANSI_RESET);
    }

    public void variableType(int line) {
        System.out.println(ANSI_RED + "ERROR Line " + line+ ": Variable type missmatching." + ANSI_RESET);
    }
}