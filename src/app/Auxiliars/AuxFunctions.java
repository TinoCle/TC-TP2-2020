package app.Auxiliars;

import java.util.ArrayList;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.xpath.XPath;
import app.SymbolsTable.*;
import app.alParser.*;

public class AuxFunctions {
    /**
    * Function used to retrieve everything about a function, it fetches its name, parameters, function type,
    * also controlling its definition context, to check if it was declared in the global context and its 
    * prototype in case of existing one
    * @param  ctx  context where the function is beign defined
    */
    public static Function processFunction (Definicion_funcionContext ctx) {
        SymbolTable symbolTable = SymbolTable.getInstance();
        ErrorReporter error = ErrorReporter.getInstance();
        String type = ctx.tipodato().getText();
        String name = ctx.ID().getText();
        Function function = new Function(type, name);
        ArrayList<ID> params = new ArrayList<>();
        if (ctx.param_definicion() != null) {
            symbolTable.addParamContext();
            params = getParams(ctx.param_definicion(), params);
            for (ID id : params) {
                if (symbolTable.checkVariableDeclared(id))
                    error.existentVariable(ctx.getStart().getLine(), id.getName());
                symbolTable.insertParam(id);
            }
            symbolTable.removeContext();
        }
        function.setParams(params);
        if (symbolTable.getContext() == 1) {
            Function prototype = symbolTable.getFunctionPrototype(function);
            if (prototype != null && !function.equals(prototype)) {
                error.conflictingTypes(ctx.getStart().getLine(), function.getName());
            }
        }
        return function;
    }

    /**
     * Checks the function prototype definition whether the function was already declared  or it's not in the global context
     * @param function
     * @param ctx
     * @return true or false to allow function prototype creation
     */
    public static boolean checkFunction(Function function, Declaracion_funcionContext ctx) {
        SymbolTable symbolTable = SymbolTable.getInstance();
        ErrorReporter error = ErrorReporter.getInstance();
        if (symbolTable.getFunctionPrototype(function) != null) {
            error.existentFunction(ctx.getStart().getLine(), function.getName());
            return false;
        } else if (symbolTable.getContext() != 1) { //if not global context
            error.functionNotDeclaredInGlobalContext(ctx.getStart().getLine());
            return false;
        } else if (symbolTable.checkVariableDeclared(function)) {
            error.existentVariable(ctx.getStart().getLine(), function.getName());
            return false;
        }
        return true;
    }
    
    /**
     * Goes through all children of "Definicion Context" or "Declaracion Context" to retrieve all its parameters along with its 
     * corresponding type and name recursively, checking its parent context to realize whether it's in a prototype definition 
     * context or a function declaration context
     * @param ctx A ParserRuleContext to allow both param_definicion and param_declaracion to be used on the same method
     * @param param A ArrayList to be used to store all parameters found in the function definition
     * @return Returns an ArrayList containing all Function Parameters
     */
    public static ArrayList<ID> getParams(ParserRuleContext ctx, ArrayList<ID> param) {
        if(ctx instanceof Param_declaracionContext) {
            Param_declaracionContext ctx2 = (Param_declaracionContext) ctx;
            if (ctx2.param_declaracion() != null) {
                ID id = new Variable();
                id.setName(ctx2.ID() != null ? ctx2.ID().getText() : "");
                id.setType(ctx2.tipodato().getText());
                param.add(id);
                return getParams(ctx2.param_declaracion(), param);
            } else{
                ID id = new Variable();
                id.setName(ctx2.ID() != null ? ctx2.ID().getText() : "");
                id.setType(ctx2.tipodato().getText());
                param.add(id);
                return param;
            }
        } else { 
            Param_definicionContext ctx2 = (Param_definicionContext) ctx;
            if (ctx2.param_definicion() != null) {
                ID id = new Variable();
                id.setName(ctx2.ID().getText());
                id.setType(ctx2.tipodato().getText());
                id.setValue("1");
                param.add(id);
                return getParams(ctx2.param_definicion(), param);
            } else{
                ID id = new Variable();
                id.setName(ctx2.ID().getText());
                id.setType(ctx2.tipodato().getText());
                id.setValue("1");
                param.add(id);
                return param;
            }
        }
    }

    /**
     * setValue gets a Variable to set its value and at the same time update its state in the symbol table
     * @param leftID Variable which is beign initialized
     * @param factor variable/number/function that is being used to set variable's value
     * @return
     */
    public static ID setValue(ID leftID, FactorContext factor) {
        SymbolTable symbolTable = SymbolTable.getInstance();
        if (factor.NUMERO() != null || factor.FLOTANTE() != null || factor.LITERAL() != null) {
            leftID.setValue(factor.getText());
        }
        if (factor.ID() != null) {
            leftID.setValue(symbolTable.findVariable(factor.ID().getText()).getValue());
        }
        return leftID;
    }

    /**
     * compareTypes gets a String indicating the variable's type and a factor that can be an ID, Function, number, character. 
     * And compares in all cases if the Factor's data type is compatible with the variable's data type. 
     * In case of an ID or a Function, it checks if these were initialized and defined. 
     * If data types are not compatible, returns false.
     * @param idType Variable's datatype
     * @param factor potential candidate to be used to set variable's value
     * @return a boolean indicating whether both dataTypes are compatible or not
     */
    public static boolean compareTypes (String idType, FactorContext factor) {
        SymbolTable symbolTable = SymbolTable.getInstance();
        ErrorReporter error = ErrorReporter.getInstance();
        if (factor.NUMERO() != null && idType.equals("int")) {
            return true;
        }
        if (factor.FLOTANTE() != null && idType.equals("double")) {
            return true;
        }
        if (factor.LITERAL() != null && idType.equals("char")) {
            return true;
        }
        if (factor.funcion() != null) {
            String functionName = factor.funcion().ID().getText();
            Function fnCalled = (Function) symbolTable.findVariable(functionName);
            if (fnCalled.getType().equals(idType) && fnCalled != null) {
                return true;
            } else{
                return false;
            }
        }
        if (factor.ID() != null) {
            ID id2 = symbolTable.findVariable(factor.ID().getText());
            if (id2 != null) { // right ID exists
                if (idType.equals(id2.getType())) {
                    return true;
                } else {
                    return false;
                }
            } else {
                error.unexistentVariable(factor.getStart().getLine(), factor.getStop().getText());
            }
        }
        return true;
    }

    /**
     * getFactors get all factors beign used in an operation, by going down in the tree finding all 'factor' nodes using XPath
     * @param parseTree context where the factors are beign used
     * @return an ArrayList containg all Factors used in the operation
     */
    public static ArrayList<FactorContext> getFactors(ParseTree parseTree, Parser parser) {
        ArrayList<FactorContext> factores = new ArrayList<FactorContext>();
        for (ParseTree ctx : XPath.findAll(parseTree, "//factor", parser)) {
            factores.add((FactorContext) ctx);
        }
        if (factores.size() > 0) {
            return factores;
        } else{
            return null;
        }
    }

    /**
     * findFunctionCtx gets a return context to go up in the tree to find a definition context, to find out the function's return type.
     * If a Function Definition Context is not found, a null value is returned, meaning that we 
     * are putting a return statement outside a function context 
     * @param parseTree return Function Context
     * @return Function definition Context or null if not found
     */
    public static Definicion_funcionContext findFunctionCtx(ParseTree parseTree) {
        if (!(parseTree instanceof Definicion_funcionContext) && parseTree.getParent() != null) {
            return findFunctionCtx (parseTree.getParent());
        } else if (parseTree.getParent() == null) {
            return null;
        }
        else{
            return (Definicion_funcionContext) parseTree;
        }
    }

    /**
     * hasExit gets a Definition Context to find a return statement in the tree by using XPath
     * @param parseTree Definition Context
     * @return a boolean indicating if a function has a return statement
     */
    public static boolean hasExit(ParseTree parseTree, Parser parser) {
        int returnCount = XPath.findAll(parseTree, "//retornar", parser).size();
        if (returnCount > 0) {
            return true;
        }
        else{
            return false;
        }
    }
}