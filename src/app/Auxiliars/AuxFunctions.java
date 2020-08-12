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
     * processFunction obtiene toda la informacion acerca de una funcion, obtiene su nombre, sus parametros, tipo de dato de retorno,
     * tambien controlando su contexto de definicion, para comprobar si fue declarada en el contexto global y comparandola con su
     * prototipo en el caso de existir uno
     * @param ctx contexto donde la funcion esta siendo usada
     * @return
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
     * checkFunction comprueba la definicion del prototipo de la funcion, comprobando si ya fue declarada o si no se encuentra
     * en el contexto global
     * @param function
     * @param ctx
     * @return
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
     * getParams recorre todos los nodos hijos de "Definicion Context" o "Declaracion Context", con el objetivo de obtener de
     * forma recursiva todos sus parametros junto con su correspondiente tipo y nombre, comprobando tambien su contexto padre para
     * averiguar si se encuentra en un contexto de definicion de funcion o de definicion de prototipo de funcion
     * @param ctx param_definicion o param_declaracion context sobre el cual obtener todos sus parametros
     * @param param ArrayList usado para obtener todos los parametros de forma recursiva
     * @return Lista de parametros de la funcion
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
     * setValue setea el valor de una variable actualizando a su vez su estado de uso en la tabla de simbolos
     * @param leftID Variable siendo inicializada
     * @param factor Factor que esta siendo asignado a la variable
     * @return ID nuevo inicializado
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
     * compareTypes recibe un String indicando el tipo de dato de la variable y un Factor (ID, Funcion, Numero, Caracter).
     * Y compara si el tipo de dato del Factor es compatible con el tipo de dato de la variable
     * En el caso de un ID o una Funcion, tambien comprueba si estos fueron inicializados y definidos
     * @param idType Tipo de dato de la Variable
     * @param factor Potencial candidato a ser usado para setear el valor de la variable
     * @return Booleano indicando si los tipos de datos son compatibles (True) o no (False)
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
     * getFactors obtiene todos los factores siendo usados en una operacion, yendo hacia abajo en el arbol, buscando todos los nodos
     * 'factor' usando XPath
     * @param parseTree contexto donde los factores estan siendo usados
     * @param parser Parser original, necesario para el uso de XPath
     * @return Lista con todos los factores de la operación
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
     * findFunctionCtx parte de un Return Context para ir arriba en el árbol para buscar el contexto de definición de su función
     * con el objetivo de obtener el tipo de dato de retorno de la funcion.
     * Si no se encuentra un Contexto de Definición, se retorna null, indicando que la setencia return se encuentra fuera
     * de un contexto de función
     * @param parseTree Contexto Return
     * @return El contexto de definición de función o null en caso de no ser encontrado
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
     * hasExit busca en un Contexto Definicion de función una sentencia return usando XPath
     * @param parseTree Contexto Definicion
     * @param parser Parser original, necesario para el uso de XPath 
     * @return Booleano indicando la presencia o no de returns
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