package app;

import java.util.LinkedList;

public class ErrorReporter {
    
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    private static ErrorReporter instance = null;
    public boolean codeWithErrors = false;

    public static ErrorReporter getInstance() {
        if (instance == null) {
            instance = new ErrorReporter();
        }
        return instance;
    }

    public void existentVariable(int line, String name) {
        codeWithErrors = true;
        System.out.println(ANSI_RED + "ERROR\tLine " + line+ ": The variable '" + name + "' was already declared in this context." + ANSI_RESET);
    }

    public void existentFunction(int line, String name) {
        codeWithErrors = true;
        System.out.println(ANSI_RED + "ERROR\tLine " + line+ ": Function prototype '" + name + "' already declared." + ANSI_RESET);
    }

    public void conflictingTypes(int line, String name){
        codeWithErrors = true;
        System.out.println(ANSI_RED + "ERROR\tLine " + line+ ": Conflicting types for '" + name + "'" + ANSI_RESET);
    }

    public void callingNotFunction(int line, String name){
        codeWithErrors = true;
        System.out.println(ANSI_RED + "ERROR\tLine " + line+ ": Called object '" + name + "' is not a function or function pointer" + ANSI_RESET);
    }

    public void tooFewArguments(int line, String name){
        codeWithErrors = true;
        System.out.println(ANSI_RED + "ERROR\tLine " + line+ ": Too few arguments to function '" + name + "'" + ANSI_RESET);
    }

    public void tooManyArguments(int line, String name){
        codeWithErrors = true;
        System.out.println(ANSI_RED + "ERROR\tLine " + line+ ": Too many arguments to function '" + name + "'" + ANSI_RESET);
    }

    public void implicitDeclaration(int line, String name) {
        System.out.println(ANSI_YELLOW + "WARNING\tLine " + line+ ": Implicit declaration of function '" + name + "'" + ANSI_RESET);
    }

    public void unexistentVariable(int line, String name) {
        codeWithErrors = true;
        System.out.println(ANSI_RED + "ERROR\tLine " + line+ ": The variable '" + name + "' wasn't declared." + ANSI_RESET);
    }

    public void variableType(int line) {
        System.out.println(ANSI_YELLOW + "WARNING\tLine " + line+ ": Variable type missmatching." + ANSI_RESET);
    }

    public void missingAssignment(int line){
        codeWithErrors = true;
        System.out.println(ANSI_RED + "ERROR\tLine " + line+ ": Expected declaration or statement at end of input" + ANSI_RESET);
    }

    
    public void usingUninitializedVariable(int line, String name) {
        System.out.println(ANSI_YELLOW + "WARNING\tLine " + line+ ": The variable '" + name + "' is being used uninitialized." + ANSI_RESET);
    }
    
    public void functionNotDeclaredInGlobalContext(int line){
        codeWithErrors = true;
        System.out.println(ANSI_RED + "ERROR\tLine " + line+ ": The function prototype must be in the glogal context" + ANSI_RESET);
    }
    
    public void returnOutsideFunction(int line){
        codeWithErrors = true;
        System.out.println(ANSI_RED + "SyntaxError\tLine " + line+ ": ‘return’ outside function" + ANSI_RESET);
    }

    public void returnValueVoid(int line){
        System.out.println(ANSI_YELLOW + "WARNING\tLine " + line+ ": ‘return’ with a value, in function returning void" + ANSI_RESET);
    }

    public void returnNoValueNonVoid(int line){
        System.out.println(ANSI_YELLOW + "WARNING\tLine " + line+ ": ‘return’ with no value, in function returning non-void" + ANSI_RESET);
    }

    public void missingReturn(int line){
        System.out.println(ANSI_YELLOW + "WARNING\tLine " + line+ ": missing ‘return’ in function" + ANSI_RESET);
    }

    public void missmatchingReturnType(int line){
        System.out.println(ANSI_YELLOW + "WARNING\tLine " + line+ ": missmatching type ‘return’ in function" + ANSI_RESET);
    }

    public void unusedVariables(LinkedList<ID> unused, int context) {
        for (ID id : unused) {
            String error = ANSI_YELLOW + "WARNING\tThe ";
            System.out.println();
            if (id instanceof Variable) {
                error += "variable " + id.getName() + " wasn't used in context " + context + "." + ANSI_RESET;;
            } else {
                error += "function " + id.getName() + " wasn't used." + ANSI_RESET;;
            }
            System.out.println(error);
        }
    }

}