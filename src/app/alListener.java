// Generated from /home/gonzalo/Técnicas de Compilación/TC-TP2-2020/src/app/al.g4 by ANTLR 4.7.1

    package app;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link alParser}.
 */
public interface alListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link alParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(alParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link alParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(alParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link alParser#instrucciones}.
	 * @param ctx the parse tree
	 */
	void enterInstrucciones(alParser.InstruccionesContext ctx);
	/**
	 * Exit a parse tree produced by {@link alParser#instrucciones}.
	 * @param ctx the parse tree
	 */
	void exitInstrucciones(alParser.InstruccionesContext ctx);
	/**
	 * Enter a parse tree produced by {@link alParser#bloque}.
	 * @param ctx the parse tree
	 */
	void enterBloque(alParser.BloqueContext ctx);
	/**
	 * Exit a parse tree produced by {@link alParser#bloque}.
	 * @param ctx the parse tree
	 */
	void exitBloque(alParser.BloqueContext ctx);
	/**
	 * Enter a parse tree produced by {@link alParser#balance}.
	 * @param ctx the parse tree
	 */
	void enterBalance(alParser.BalanceContext ctx);
	/**
	 * Exit a parse tree produced by {@link alParser#balance}.
	 * @param ctx the parse tree
	 */
	void exitBalance(alParser.BalanceContext ctx);
	/**
	 * Enter a parse tree produced by {@link alParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void enterInstruccion(alParser.InstruccionContext ctx);
	/**
	 * Exit a parse tree produced by {@link alParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void exitInstruccion(alParser.InstruccionContext ctx);
	/**
	 * Enter a parse tree produced by {@link alParser#declaracion_funcion}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracion_funcion(alParser.Declaracion_funcionContext ctx);
	/**
	 * Exit a parse tree produced by {@link alParser#declaracion_funcion}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracion_funcion(alParser.Declaracion_funcionContext ctx);
	/**
	 * Enter a parse tree produced by {@link alParser#param_declaracion}.
	 * @param ctx the parse tree
	 */
	void enterParam_declaracion(alParser.Param_declaracionContext ctx);
	/**
	 * Exit a parse tree produced by {@link alParser#param_declaracion}.
	 * @param ctx the parse tree
	 */
	void exitParam_declaracion(alParser.Param_declaracionContext ctx);
	/**
	 * Enter a parse tree produced by {@link alParser#definicion_funcion}.
	 * @param ctx the parse tree
	 */
	void enterDefinicion_funcion(alParser.Definicion_funcionContext ctx);
	/**
	 * Exit a parse tree produced by {@link alParser#definicion_funcion}.
	 * @param ctx the parse tree
	 */
	void exitDefinicion_funcion(alParser.Definicion_funcionContext ctx);
	/**
	 * Enter a parse tree produced by {@link alParser#param_definicion}.
	 * @param ctx the parse tree
	 */
	void enterParam_definicion(alParser.Param_definicionContext ctx);
	/**
	 * Exit a parse tree produced by {@link alParser#param_definicion}.
	 * @param ctx the parse tree
	 */
	void exitParam_definicion(alParser.Param_definicionContext ctx);
	/**
	 * Enter a parse tree produced by {@link alParser#funcion}.
	 * @param ctx the parse tree
	 */
	void enterFuncion(alParser.FuncionContext ctx);
	/**
	 * Exit a parse tree produced by {@link alParser#funcion}.
	 * @param ctx the parse tree
	 */
	void exitFuncion(alParser.FuncionContext ctx);
	/**
	 * Enter a parse tree produced by {@link alParser#parametros}.
	 * @param ctx the parse tree
	 */
	void enterParametros(alParser.ParametrosContext ctx);
	/**
	 * Exit a parse tree produced by {@link alParser#parametros}.
	 * @param ctx the parse tree
	 */
	void exitParametros(alParser.ParametrosContext ctx);
	/**
	 * Enter a parse tree produced by {@link alParser#tipodato}.
	 * @param ctx the parse tree
	 */
	void enterTipodato(alParser.TipodatoContext ctx);
	/**
	 * Exit a parse tree produced by {@link alParser#tipodato}.
	 * @param ctx the parse tree
	 */
	void exitTipodato(alParser.TipodatoContext ctx);
	/**
	 * Enter a parse tree produced by {@link alParser#declaracion}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracion(alParser.DeclaracionContext ctx);
	/**
	 * Exit a parse tree produced by {@link alParser#declaracion}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracion(alParser.DeclaracionContext ctx);
	/**
	 * Enter a parse tree produced by {@link alParser#asign}.
	 * @param ctx the parse tree
	 */
	void enterAsign(alParser.AsignContext ctx);
	/**
	 * Exit a parse tree produced by {@link alParser#asign}.
	 * @param ctx the parse tree
	 */
	void exitAsign(alParser.AsignContext ctx);
	/**
	 * Enter a parse tree produced by {@link alParser#asignacion}.
	 * @param ctx the parse tree
	 */
	void enterAsignacion(alParser.AsignacionContext ctx);
	/**
	 * Exit a parse tree produced by {@link alParser#asignacion}.
	 * @param ctx the parse tree
	 */
	void exitAsignacion(alParser.AsignacionContext ctx);
	/**
	 * Enter a parse tree produced by {@link alParser#condicional}.
	 * @param ctx the parse tree
	 */
	void enterCondicional(alParser.CondicionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link alParser#condicional}.
	 * @param ctx the parse tree
	 */
	void exitCondicional(alParser.CondicionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link alParser#iteracion}.
	 * @param ctx the parse tree
	 */
	void enterIteracion(alParser.IteracionContext ctx);
	/**
	 * Exit a parse tree produced by {@link alParser#iteracion}.
	 * @param ctx the parse tree
	 */
	void exitIteracion(alParser.IteracionContext ctx);
	/**
	 * Enter a parse tree produced by {@link alParser#operacion}.
	 * @param ctx the parse tree
	 */
	void enterOperacion(alParser.OperacionContext ctx);
	/**
	 * Exit a parse tree produced by {@link alParser#operacion}.
	 * @param ctx the parse tree
	 */
	void exitOperacion(alParser.OperacionContext ctx);
	/**
	 * Enter a parse tree produced by {@link alParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExpresion(alParser.ExpresionContext ctx);
	/**
	 * Exit a parse tree produced by {@link alParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExpresion(alParser.ExpresionContext ctx);
	/**
	 * Enter a parse tree produced by {@link alParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExp(alParser.ExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link alParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExp(alParser.ExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link alParser#termino}.
	 * @param ctx the parse tree
	 */
	void enterTermino(alParser.TerminoContext ctx);
	/**
	 * Exit a parse tree produced by {@link alParser#termino}.
	 * @param ctx the parse tree
	 */
	void exitTermino(alParser.TerminoContext ctx);
	/**
	 * Enter a parse tree produced by {@link alParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(alParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link alParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(alParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link alParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(alParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link alParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(alParser.FactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link alParser#prefix}.
	 * @param ctx the parse tree
	 */
	void enterPrefix(alParser.PrefixContext ctx);
	/**
	 * Exit a parse tree produced by {@link alParser#prefix}.
	 * @param ctx the parse tree
	 */
	void exitPrefix(alParser.PrefixContext ctx);
	/**
	 * Enter a parse tree produced by {@link alParser#igualdad}.
	 * @param ctx the parse tree
	 */
	void enterIgualdad(alParser.IgualdadContext ctx);
	/**
	 * Exit a parse tree produced by {@link alParser#igualdad}.
	 * @param ctx the parse tree
	 */
	void exitIgualdad(alParser.IgualdadContext ctx);
	/**
	 * Enter a parse tree produced by {@link alParser#comparaciones}.
	 * @param ctx the parse tree
	 */
	void enterComparaciones(alParser.ComparacionesContext ctx);
	/**
	 * Exit a parse tree produced by {@link alParser#comparaciones}.
	 * @param ctx the parse tree
	 */
	void exitComparaciones(alParser.ComparacionesContext ctx);
	/**
	 * Enter a parse tree produced by {@link alParser#conjuncion}.
	 * @param ctx the parse tree
	 */
	void enterConjuncion(alParser.ConjuncionContext ctx);
	/**
	 * Exit a parse tree produced by {@link alParser#conjuncion}.
	 * @param ctx the parse tree
	 */
	void exitConjuncion(alParser.ConjuncionContext ctx);
	/**
	 * Enter a parse tree produced by {@link alParser#disyuncion}.
	 * @param ctx the parse tree
	 */
	void enterDisyuncion(alParser.DisyuncionContext ctx);
	/**
	 * Exit a parse tree produced by {@link alParser#disyuncion}.
	 * @param ctx the parse tree
	 */
	void exitDisyuncion(alParser.DisyuncionContext ctx);
	/**
	 * Enter a parse tree produced by {@link alParser#opal}.
	 * @param ctx the parse tree
	 */
	void enterOpal(alParser.OpalContext ctx);
	/**
	 * Exit a parse tree produced by {@link alParser#opal}.
	 * @param ctx the parse tree
	 */
	void exitOpal(alParser.OpalContext ctx);
}