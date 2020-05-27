// Generated from /home/agustin/Desktop/Facultad/Técnicas de Compilación/Proyectos/TP2/src/app/al.g4 by ANTLR 4.7.1

    package app;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link alParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface alVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link alParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(alParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link alParser#instrucciones}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstrucciones(alParser.InstruccionesContext ctx);
	/**
	 * Visit a parse tree produced by {@link alParser#bloque}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBloque(alParser.BloqueContext ctx);
	/**
	 * Visit a parse tree produced by {@link alParser#balance}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBalance(alParser.BalanceContext ctx);
	/**
	 * Visit a parse tree produced by {@link alParser#instruccion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstruccion(alParser.InstruccionContext ctx);
	/**
	 * Visit a parse tree produced by {@link alParser#declaracion_funcion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracion_funcion(alParser.Declaracion_funcionContext ctx);
	/**
	 * Visit a parse tree produced by {@link alParser#param_declaracion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam_declaracion(alParser.Param_declaracionContext ctx);
	/**
	 * Visit a parse tree produced by {@link alParser#param_definicion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam_definicion(alParser.Param_definicionContext ctx);
	/**
	 * Visit a parse tree produced by {@link alParser#funcion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncion(alParser.FuncionContext ctx);
	/**
	 * Visit a parse tree produced by {@link alParser#parametros}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParametros(alParser.ParametrosContext ctx);
	/**
	 * Visit a parse tree produced by {@link alParser#tipodato}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipodato(alParser.TipodatoContext ctx);
	/**
	 * Visit a parse tree produced by {@link alParser#declaracion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracion(alParser.DeclaracionContext ctx);
	/**
	 * Visit a parse tree produced by {@link alParser#asign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsign(alParser.AsignContext ctx);
	/**
	 * Visit a parse tree produced by {@link alParser#asignacion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsignacion(alParser.AsignacionContext ctx);
	/**
	 * Visit a parse tree produced by {@link alParser#condicional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondicional(alParser.CondicionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link alParser#iteracion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIteracion(alParser.IteracionContext ctx);
	/**
	 * Visit a parse tree produced by {@link alParser#operacion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperacion(alParser.OperacionContext ctx);
	/**
	 * Visit a parse tree produced by {@link alParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpresion(alParser.ExpresionContext ctx);
	/**
	 * Visit a parse tree produced by {@link alParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp(alParser.ExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link alParser#termino}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTermino(alParser.TerminoContext ctx);
	/**
	 * Visit a parse tree produced by {@link alParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(alParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link alParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(alParser.FactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link alParser#prefix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefix(alParser.PrefixContext ctx);
	/**
	 * Visit a parse tree produced by {@link alParser#igualdad}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIgualdad(alParser.IgualdadContext ctx);
	/**
	 * Visit a parse tree produced by {@link alParser#comparaciones}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparaciones(alParser.ComparacionesContext ctx);
	/**
	 * Visit a parse tree produced by {@link alParser#conjuncion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConjuncion(alParser.ConjuncionContext ctx);
	/**
	 * Visit a parse tree produced by {@link alParser#disyuncion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDisyuncion(alParser.DisyuncionContext ctx);
	/**
	 * Visit a parse tree produced by {@link alParser#opal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpal(alParser.OpalContext ctx);
}