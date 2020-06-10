// Generated from /home/gonzalo/Técnicas de Compilación/TC-TP2-2020/src/app/al.g4 by ANTLR 4.7.1

    package app;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class alParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, PA=8, PC=9, CA=10, 
		CC=11, LA=12, LC=13, PYC=14, COMA=15, INT=16, DOUBLE=17, CHAR=18, VOID=19, 
		EQ=20, DO=21, WHILE=22, FOR=23, IF=24, ELIF=25, ELSE=26, MENOR=27, MAYOR=28, 
		MENORIG=29, MAYORIG=30, IGUAL=31, AND=32, OR=33, DIFF=34, NOT=35, RETURN=36, 
		ID=37, NUMERO=38, FLOTANTE=39, LITERAL=40, WS=41, OTRO=42;
	public static final int
		RULE_prog = 0, RULE_instrucciones = 1, RULE_bloque = 2, RULE_balance = 3, 
		RULE_instruccion = 4, RULE_declaracion_funcion = 5, RULE_retornar = 6, 
		RULE_param_declaracion = 7, RULE_definicion_funcion = 8, RULE_param_definicion = 9, 
		RULE_funcion = 10, RULE_parametros = 11, RULE_tipodato = 12, RULE_declaracion = 13, 
		RULE_asign = 14, RULE_asignacion = 15, RULE_condicional = 16, RULE_iteracion = 17, 
		RULE_operacion = 18, RULE_expresion = 19, RULE_exp = 20, RULE_termino = 21, 
		RULE_term = 22, RULE_factor = 23, RULE_prefix = 24, RULE_igualdad = 25, 
		RULE_comparaciones = 26, RULE_conjuncion = 27, RULE_disyuncion = 28, RULE_opal = 29;
	public static final String[] ruleNames = {
		"prog", "instrucciones", "bloque", "balance", "instruccion", "declaracion_funcion", 
		"retornar", "param_declaracion", "definicion_funcion", "param_definicion", 
		"funcion", "parametros", "tipodato", "declaracion", "asign", "asignacion", 
		"condicional", "iteracion", "operacion", "expresion", "exp", "termino", 
		"term", "factor", "prefix", "igualdad", "comparaciones", "conjuncion", 
		"disyuncion", "opal"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'+'", "'-'", "'*'", "'/'", "'%'", "'++'", "'--'", "'('", "')'", 
		"'['", "']'", "'{'", "'}'", "';'", "','", "'int'", "'double'", "'char'", 
		"'void'", "'='", "'do'", "'while'", "'for'", "'if'", "'else if'", "'else'", 
		"'<'", "'>'", "'<='", "'>='", "'=='", "'&&'", "'||'", "'!='", "'!'", "'return'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, "PA", "PC", "CA", "CC", 
		"LA", "LC", "PYC", "COMA", "INT", "DOUBLE", "CHAR", "VOID", "EQ", "DO", 
		"WHILE", "FOR", "IF", "ELIF", "ELSE", "MENOR", "MAYOR", "MENORIG", "MAYORIG", 
		"IGUAL", "AND", "OR", "DIFF", "NOT", "RETURN", "ID", "NUMERO", "FLOTANTE", 
		"LITERAL", "WS", "OTRO"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "al.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public alParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext {
		public InstruccionesContext instrucciones() {
			return getRuleContext(InstruccionesContext.class,0);
		}
		public TerminalNode EOF() { return getToken(alParser.EOF, 0); }
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			instrucciones();
			setState(61);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InstruccionesContext extends ParserRuleContext {
		public InstruccionContext instruccion() {
			return getRuleContext(InstruccionContext.class,0);
		}
		public InstruccionesContext instrucciones() {
			return getRuleContext(InstruccionesContext.class,0);
		}
		public InstruccionesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instrucciones; }
	}

	public final InstruccionesContext instrucciones() throws RecognitionException {
		InstruccionesContext _localctx = new InstruccionesContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_instrucciones);
		try {
			setState(67);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LA:
			case INT:
			case DOUBLE:
			case CHAR:
			case VOID:
			case DO:
			case WHILE:
			case FOR:
			case IF:
			case RETURN:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(63);
				instruccion();
				setState(64);
				instrucciones();
				}
				break;
			case EOF:
			case LC:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BloqueContext extends ParserRuleContext {
		public TerminalNode LA() { return getToken(alParser.LA, 0); }
		public InstruccionesContext instrucciones() {
			return getRuleContext(InstruccionesContext.class,0);
		}
		public TerminalNode LC() { return getToken(alParser.LC, 0); }
		public BloqueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloque; }
	}

	public final BloqueContext bloque() throws RecognitionException {
		BloqueContext _localctx = new BloqueContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_bloque);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			match(LA);
			setState(70);
			instrucciones();
			setState(71);
			match(LC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BalanceContext extends ParserRuleContext {
		public TerminalNode PA() { return getToken(alParser.PA, 0); }
		public List<BalanceContext> balance() {
			return getRuleContexts(BalanceContext.class);
		}
		public BalanceContext balance(int i) {
			return getRuleContext(BalanceContext.class,i);
		}
		public TerminalNode PC() { return getToken(alParser.PC, 0); }
		public TerminalNode LA() { return getToken(alParser.LA, 0); }
		public TerminalNode LC() { return getToken(alParser.LC, 0); }
		public TerminalNode CA() { return getToken(alParser.CA, 0); }
		public TerminalNode CC() { return getToken(alParser.CC, 0); }
		public BalanceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_balance; }
	}

	public final BalanceContext balance() throws RecognitionException {
		BalanceContext _localctx = new BalanceContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_balance);
		try {
			setState(89);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PA:
				enterOuterAlt(_localctx, 1);
				{
				setState(73);
				match(PA);
				setState(74);
				balance();
				setState(75);
				match(PC);
				setState(76);
				balance();
				}
				break;
			case LA:
				enterOuterAlt(_localctx, 2);
				{
				setState(78);
				match(LA);
				setState(79);
				balance();
				setState(80);
				match(LC);
				setState(81);
				balance();
				}
				break;
			case CA:
				enterOuterAlt(_localctx, 3);
				{
				setState(83);
				match(CA);
				setState(84);
				balance();
				setState(85);
				match(CC);
				setState(86);
				balance();
				}
				break;
			case PC:
			case CC:
			case LC:
				enterOuterAlt(_localctx, 4);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InstruccionContext extends ParserRuleContext {
		public DeclaracionContext declaracion() {
			return getRuleContext(DeclaracionContext.class,0);
		}
		public TerminalNode PYC() { return getToken(alParser.PYC, 0); }
		public AsignacionContext asignacion() {
			return getRuleContext(AsignacionContext.class,0);
		}
		public Declaracion_funcionContext declaracion_funcion() {
			return getRuleContext(Declaracion_funcionContext.class,0);
		}
		public Definicion_funcionContext definicion_funcion() {
			return getRuleContext(Definicion_funcionContext.class,0);
		}
		public FuncionContext funcion() {
			return getRuleContext(FuncionContext.class,0);
		}
		public CondicionalContext condicional() {
			return getRuleContext(CondicionalContext.class,0);
		}
		public IteracionContext iteracion() {
			return getRuleContext(IteracionContext.class,0);
		}
		public BloqueContext bloque() {
			return getRuleContext(BloqueContext.class,0);
		}
		public RetornarContext retornar() {
			return getRuleContext(RetornarContext.class,0);
		}
		public InstruccionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruccion; }
	}

	public final InstruccionContext instruccion() throws RecognitionException {
		InstruccionContext _localctx = new InstruccionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_instruccion);
		try {
			setState(110);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(91);
				declaracion();
				setState(92);
				match(PYC);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(94);
				asignacion();
				setState(95);
				match(PYC);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(97);
				declaracion_funcion();
				setState(98);
				match(PYC);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(100);
				definicion_funcion();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(101);
				funcion();
				setState(102);
				match(PYC);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(104);
				condicional();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(105);
				iteracion();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(106);
				bloque();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(107);
				retornar();
				setState(108);
				match(PYC);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Declaracion_funcionContext extends ParserRuleContext {
		public TipodatoContext tipodato() {
			return getRuleContext(TipodatoContext.class,0);
		}
		public TerminalNode ID() { return getToken(alParser.ID, 0); }
		public TerminalNode PA() { return getToken(alParser.PA, 0); }
		public TerminalNode PC() { return getToken(alParser.PC, 0); }
		public Param_declaracionContext param_declaracion() {
			return getRuleContext(Param_declaracionContext.class,0);
		}
		public Declaracion_funcionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracion_funcion; }
	}

	public final Declaracion_funcionContext declaracion_funcion() throws RecognitionException {
		Declaracion_funcionContext _localctx = new Declaracion_funcionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_declaracion_funcion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			tipodato();
			setState(113);
			match(ID);
			setState(114);
			match(PA);
			setState(116);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << DOUBLE) | (1L << CHAR) | (1L << VOID))) != 0)) {
				{
				setState(115);
				param_declaracion();
				}
			}

			setState(118);
			match(PC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RetornarContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(alParser.RETURN, 0); }
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public RetornarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_retornar; }
	}

	public final RetornarContext retornar() throws RecognitionException {
		RetornarContext _localctx = new RetornarContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_retornar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			match(RETURN);
			setState(121);
			factor();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Param_declaracionContext extends ParserRuleContext {
		public TipodatoContext tipodato() {
			return getRuleContext(TipodatoContext.class,0);
		}
		public TerminalNode ID() { return getToken(alParser.ID, 0); }
		public TerminalNode COMA() { return getToken(alParser.COMA, 0); }
		public Param_declaracionContext param_declaracion() {
			return getRuleContext(Param_declaracionContext.class,0);
		}
		public Param_declaracionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param_declaracion; }
	}

	public final Param_declaracionContext param_declaracion() throws RecognitionException {
		Param_declaracionContext _localctx = new Param_declaracionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_param_declaracion);
		try {
			setState(136);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(123);
				tipodato();
				setState(126);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case ID:
					{
					setState(124);
					match(ID);
					}
					break;
				case PC:
					{
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(128);
				tipodato();
				setState(131);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case ID:
					{
					setState(129);
					match(ID);
					}
					break;
				case COMA:
					{
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(133);
				match(COMA);
				setState(134);
				param_declaracion();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Definicion_funcionContext extends ParserRuleContext {
		public TipodatoContext tipodato() {
			return getRuleContext(TipodatoContext.class,0);
		}
		public TerminalNode ID() { return getToken(alParser.ID, 0); }
		public TerminalNode PA() { return getToken(alParser.PA, 0); }
		public TerminalNode PC() { return getToken(alParser.PC, 0); }
		public BloqueContext bloque() {
			return getRuleContext(BloqueContext.class,0);
		}
		public Param_definicionContext param_definicion() {
			return getRuleContext(Param_definicionContext.class,0);
		}
		public Definicion_funcionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definicion_funcion; }
	}

	public final Definicion_funcionContext definicion_funcion() throws RecognitionException {
		Definicion_funcionContext _localctx = new Definicion_funcionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_definicion_funcion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			tipodato();
			setState(139);
			match(ID);
			setState(140);
			match(PA);
			setState(142);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << DOUBLE) | (1L << CHAR) | (1L << VOID))) != 0)) {
				{
				setState(141);
				param_definicion();
				}
			}

			setState(144);
			match(PC);
			setState(145);
			bloque();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Param_definicionContext extends ParserRuleContext {
		public TipodatoContext tipodato() {
			return getRuleContext(TipodatoContext.class,0);
		}
		public TerminalNode ID() { return getToken(alParser.ID, 0); }
		public TerminalNode COMA() { return getToken(alParser.COMA, 0); }
		public Param_definicionContext param_definicion() {
			return getRuleContext(Param_definicionContext.class,0);
		}
		public Param_definicionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param_definicion; }
	}

	public final Param_definicionContext param_definicion() throws RecognitionException {
		Param_definicionContext _localctx = new Param_definicionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_param_definicion);
		try {
			setState(155);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(147);
				tipodato();
				setState(148);
				match(ID);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(150);
				tipodato();
				setState(151);
				match(ID);
				setState(152);
				match(COMA);
				setState(153);
				param_definicion();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncionContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(alParser.ID, 0); }
		public TerminalNode PA() { return getToken(alParser.PA, 0); }
		public ParametrosContext parametros() {
			return getRuleContext(ParametrosContext.class,0);
		}
		public TerminalNode PC() { return getToken(alParser.PC, 0); }
		public FuncionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcion; }
	}

	public final FuncionContext funcion() throws RecognitionException {
		FuncionContext _localctx = new FuncionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_funcion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			match(ID);
			setState(158);
			match(PA);
			setState(159);
			parametros();
			setState(160);
			match(PC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParametrosContext extends ParserRuleContext {
		public OperacionContext operacion() {
			return getRuleContext(OperacionContext.class,0);
		}
		public TerminalNode COMA() { return getToken(alParser.COMA, 0); }
		public ParametrosContext parametros() {
			return getRuleContext(ParametrosContext.class,0);
		}
		public ParametrosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametros; }
	}

	public final ParametrosContext parametros() throws RecognitionException {
		ParametrosContext _localctx = new ParametrosContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_parametros);
		try {
			setState(168);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(162);
				operacion();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(163);
				operacion();
				setState(164);
				match(COMA);
				setState(165);
				parametros();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TipodatoContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(alParser.INT, 0); }
		public TerminalNode CHAR() { return getToken(alParser.CHAR, 0); }
		public TerminalNode DOUBLE() { return getToken(alParser.DOUBLE, 0); }
		public TerminalNode VOID() { return getToken(alParser.VOID, 0); }
		public TipodatoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipodato; }
	}

	public final TipodatoContext tipodato() throws RecognitionException {
		TipodatoContext _localctx = new TipodatoContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_tipodato);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << DOUBLE) | (1L << CHAR) | (1L << VOID))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclaracionContext extends ParserRuleContext {
		public TipodatoContext tipodato() {
			return getRuleContext(TipodatoContext.class,0);
		}
		public TerminalNode ID() { return getToken(alParser.ID, 0); }
		public AsignacionContext asignacion() {
			return getRuleContext(AsignacionContext.class,0);
		}
		public DeclaracionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracion; }
	}

	public final DeclaracionContext declaracion() throws RecognitionException {
		DeclaracionContext _localctx = new DeclaracionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_declaracion);
		try {
			setState(178);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(172);
				tipodato();
				setState(173);
				match(ID);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(175);
				tipodato();
				setState(176);
				asignacion();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AsignContext extends ParserRuleContext {
		public TerminalNode EQ() { return getToken(alParser.EQ, 0); }
		public OperacionContext operacion() {
			return getRuleContext(OperacionContext.class,0);
		}
		public AsignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_asign; }
	}

	public final AsignContext asign() throws RecognitionException {
		AsignContext _localctx = new AsignContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_asign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			match(EQ);
			setState(181);
			operacion();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AsignacionContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(alParser.ID, 0); }
		public AsignContext asign() {
			return getRuleContext(AsignContext.class,0);
		}
		public AsignacionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_asignacion; }
	}

	public final AsignacionContext asignacion() throws RecognitionException {
		AsignacionContext _localctx = new AsignacionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_asignacion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			match(ID);
			setState(184);
			asign();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CondicionalContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(alParser.IF, 0); }
		public List<TerminalNode> PA() { return getTokens(alParser.PA); }
		public TerminalNode PA(int i) {
			return getToken(alParser.PA, i);
		}
		public List<OperacionContext> operacion() {
			return getRuleContexts(OperacionContext.class);
		}
		public OperacionContext operacion(int i) {
			return getRuleContext(OperacionContext.class,i);
		}
		public List<TerminalNode> PC() { return getTokens(alParser.PC); }
		public TerminalNode PC(int i) {
			return getToken(alParser.PC, i);
		}
		public List<InstruccionContext> instruccion() {
			return getRuleContexts(InstruccionContext.class);
		}
		public InstruccionContext instruccion(int i) {
			return getRuleContext(InstruccionContext.class,i);
		}
		public List<TerminalNode> ELIF() { return getTokens(alParser.ELIF); }
		public TerminalNode ELIF(int i) {
			return getToken(alParser.ELIF, i);
		}
		public TerminalNode ELSE() { return getToken(alParser.ELSE, 0); }
		public CondicionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condicional; }
	}

	public final CondicionalContext condicional() throws RecognitionException {
		CondicionalContext _localctx = new CondicionalContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_condicional);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			match(IF);
			setState(187);
			match(PA);
			setState(188);
			operacion();
			setState(189);
			match(PC);
			setState(190);
			instruccion();
			setState(199);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(191);
					match(ELIF);
					setState(192);
					match(PA);
					setState(193);
					operacion();
					setState(194);
					match(PC);
					setState(195);
					instruccion();
					}
					} 
				}
				setState(201);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
			setState(204);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(202);
				match(ELSE);
				setState(203);
				instruccion();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IteracionContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(alParser.FOR, 0); }
		public TerminalNode PA() { return getToken(alParser.PA, 0); }
		public List<TerminalNode> PYC() { return getTokens(alParser.PYC); }
		public TerminalNode PYC(int i) {
			return getToken(alParser.PYC, i);
		}
		public TerminalNode PC() { return getToken(alParser.PC, 0); }
		public InstruccionContext instruccion() {
			return getRuleContext(InstruccionContext.class,0);
		}
		public List<AsignacionContext> asignacion() {
			return getRuleContexts(AsignacionContext.class);
		}
		public AsignacionContext asignacion(int i) {
			return getRuleContext(AsignacionContext.class,i);
		}
		public DeclaracionContext declaracion() {
			return getRuleContext(DeclaracionContext.class,0);
		}
		public List<OperacionContext> operacion() {
			return getRuleContexts(OperacionContext.class);
		}
		public OperacionContext operacion(int i) {
			return getRuleContext(OperacionContext.class,i);
		}
		public TerminalNode WHILE() { return getToken(alParser.WHILE, 0); }
		public TerminalNode DO() { return getToken(alParser.DO, 0); }
		public IteracionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iteracion; }
	}

	public final IteracionContext iteracion() throws RecognitionException {
		IteracionContext _localctx = new IteracionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_iteracion);
		try {
			setState(243);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FOR:
				enterOuterAlt(_localctx, 1);
				{
				setState(206);
				match(FOR);
				setState(207);
				match(PA);
				setState(211);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case ID:
					{
					setState(208);
					asignacion();
					}
					break;
				case INT:
				case DOUBLE:
				case CHAR:
				case VOID:
					{
					setState(209);
					declaracion();
					}
					break;
				case PYC:
					{
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(213);
				match(PYC);
				setState(216);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__0:
				case T__1:
				case T__5:
				case T__6:
				case PA:
				case NOT:
				case ID:
				case NUMERO:
				case FLOTANTE:
				case LITERAL:
					{
					setState(214);
					operacion();
					}
					break;
				case PYC:
					{
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(218);
				match(PYC);
				setState(222);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
				case 1:
					{
					setState(219);
					asignacion();
					}
					break;
				case 2:
					{
					setState(220);
					operacion();
					}
					break;
				case 3:
					{
					}
					break;
				}
				setState(224);
				match(PC);
				setState(225);
				instruccion();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 2);
				{
				setState(226);
				match(WHILE);
				setState(227);
				match(PA);
				setState(228);
				operacion();
				setState(229);
				match(PC);
				setState(230);
				instruccion();
				}
				break;
			case DO:
				enterOuterAlt(_localctx, 3);
				{
				setState(232);
				match(DO);
				setState(233);
				instruccion();
				setState(234);
				match(WHILE);
				setState(235);
				match(PA);
				setState(238);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__0:
				case T__1:
				case T__5:
				case T__6:
				case PA:
				case NOT:
				case ID:
				case NUMERO:
				case FLOTANTE:
				case LITERAL:
					{
					setState(236);
					operacion();
					}
					break;
				case PC:
					{
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(240);
				match(PC);
				setState(241);
				match(PYC);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OperacionContext extends ParserRuleContext {
		public OpalContext opal() {
			return getRuleContext(OpalContext.class,0);
		}
		public OperacionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operacion; }
	}

	public final OperacionContext operacion() throws RecognitionException {
		OperacionContext _localctx = new OperacionContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_operacion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(245);
			opal();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpresionContext extends ParserRuleContext {
		public TerminoContext termino() {
			return getRuleContext(TerminoContext.class,0);
		}
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public ExpresionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expresion; }
	}

	public final ExpresionContext expresion() throws RecognitionException {
		ExpresionContext _localctx = new ExpresionContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_expresion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(247);
			termino();
			setState(248);
			exp();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpContext extends ParserRuleContext {
		public TerminoContext termino() {
			return getRuleContext(TerminoContext.class,0);
		}
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
	}

	public final ExpContext exp() throws RecognitionException {
		ExpContext _localctx = new ExpContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_exp);
		try {
			setState(259);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(250);
				match(T__0);
				setState(251);
				termino();
				setState(252);
				exp();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(254);
				match(T__1);
				setState(255);
				termino();
				setState(256);
				exp();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TerminoContext extends ParserRuleContext {
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TerminoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termino; }
	}

	public final TerminoContext termino() throws RecognitionException {
		TerminoContext _localctx = new TerminoContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_termino);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(261);
			factor();
			setState(262);
			term();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TermContext extends ParserRuleContext {
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_term);
		try {
			setState(277);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(264);
				match(T__2);
				setState(265);
				factor();
				setState(266);
				term();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(268);
				match(T__3);
				setState(269);
				factor();
				setState(270);
				term();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(272);
				match(T__4);
				setState(273);
				factor();
				setState(274);
				term();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FactorContext extends ParserRuleContext {
		public PrefixContext prefix() {
			return getRuleContext(PrefixContext.class,0);
		}
		public TerminalNode PA() { return getToken(alParser.PA, 0); }
		public OpalContext opal() {
			return getRuleContext(OpalContext.class,0);
		}
		public TerminalNode PC() { return getToken(alParser.PC, 0); }
		public TerminalNode NUMERO() { return getToken(alParser.NUMERO, 0); }
		public TerminalNode ID() { return getToken(alParser.ID, 0); }
		public TerminalNode FLOTANTE() { return getToken(alParser.FLOTANTE, 0); }
		public FuncionContext funcion() {
			return getRuleContext(FuncionContext.class,0);
		}
		public TerminalNode LITERAL() { return getToken(alParser.LITERAL, 0); }
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_factor);
		try {
			setState(299);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(279);
				prefix();
				setState(280);
				match(PA);
				setState(281);
				opal();
				setState(282);
				match(PC);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(284);
				prefix();
				setState(285);
				match(NUMERO);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(287);
				prefix();
				setState(288);
				match(ID);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(290);
				prefix();
				setState(291);
				match(FLOTANTE);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(293);
				prefix();
				setState(294);
				funcion();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(296);
				prefix();
				setState(297);
				match(LITERAL);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrefixContext extends ParserRuleContext {
		public TerminalNode NOT() { return getToken(alParser.NOT, 0); }
		public PrefixContext prefix() {
			return getRuleContext(PrefixContext.class,0);
		}
		public PrefixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prefix; }
	}

	public final PrefixContext prefix() throws RecognitionException {
		PrefixContext _localctx = new PrefixContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_prefix);
		try {
			setState(308);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				enterOuterAlt(_localctx, 1);
				{
				setState(301);
				match(T__5);
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 2);
				{
				setState(302);
				match(T__6);
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 3);
				{
				setState(303);
				match(T__0);
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 4);
				{
				setState(304);
				match(T__1);
				}
				break;
			case NOT:
				enterOuterAlt(_localctx, 5);
				{
				setState(305);
				match(NOT);
				setState(306);
				prefix();
				}
				break;
			case PA:
			case ID:
			case NUMERO:
			case FLOTANTE:
			case LITERAL:
				enterOuterAlt(_localctx, 6);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IgualdadContext extends ParserRuleContext {
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public IgualdadContext igualdad() {
			return getRuleContext(IgualdadContext.class,0);
		}
		public ComparacionesContext comparaciones() {
			return getRuleContext(ComparacionesContext.class,0);
		}
		public IgualdadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_igualdad; }
	}

	public final IgualdadContext igualdad() throws RecognitionException {
		return igualdad(0);
	}

	private IgualdadContext igualdad(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		IgualdadContext _localctx = new IgualdadContext(_ctx, _parentState);
		IgualdadContext _prevctx = _localctx;
		int _startState = 50;
		enterRecursionRule(_localctx, 50, RULE_igualdad, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(311);
			expresion();
			}
			_ctx.stop = _input.LT(-1);
			setState(319);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new IgualdadContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_igualdad);
					setState(313);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(314);
					comparaciones();
					setState(315);
					expresion();
					}
					} 
				}
				setState(321);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ComparacionesContext extends ParserRuleContext {
		public TerminalNode IGUAL() { return getToken(alParser.IGUAL, 0); }
		public TerminalNode DIFF() { return getToken(alParser.DIFF, 0); }
		public TerminalNode MENOR() { return getToken(alParser.MENOR, 0); }
		public TerminalNode MAYOR() { return getToken(alParser.MAYOR, 0); }
		public TerminalNode MENORIG() { return getToken(alParser.MENORIG, 0); }
		public TerminalNode MAYORIG() { return getToken(alParser.MAYORIG, 0); }
		public ComparacionesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparaciones; }
	}

	public final ComparacionesContext comparaciones() throws RecognitionException {
		ComparacionesContext _localctx = new ComparacionesContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_comparaciones);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(322);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MENOR) | (1L << MAYOR) | (1L << MENORIG) | (1L << MAYORIG) | (1L << IGUAL) | (1L << DIFF))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConjuncionContext extends ParserRuleContext {
		public IgualdadContext igualdad() {
			return getRuleContext(IgualdadContext.class,0);
		}
		public ConjuncionContext conjuncion() {
			return getRuleContext(ConjuncionContext.class,0);
		}
		public TerminalNode AND() { return getToken(alParser.AND, 0); }
		public ConjuncionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conjuncion; }
	}

	public final ConjuncionContext conjuncion() throws RecognitionException {
		return conjuncion(0);
	}

	private ConjuncionContext conjuncion(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ConjuncionContext _localctx = new ConjuncionContext(_ctx, _parentState);
		ConjuncionContext _prevctx = _localctx;
		int _startState = 54;
		enterRecursionRule(_localctx, 54, RULE_conjuncion, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(325);
			igualdad(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(332);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ConjuncionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_conjuncion);
					setState(327);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(328);
					match(AND);
					setState(329);
					igualdad(0);
					}
					} 
				}
				setState(334);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class DisyuncionContext extends ParserRuleContext {
		public ConjuncionContext conjuncion() {
			return getRuleContext(ConjuncionContext.class,0);
		}
		public DisyuncionContext disyuncion() {
			return getRuleContext(DisyuncionContext.class,0);
		}
		public TerminalNode OR() { return getToken(alParser.OR, 0); }
		public DisyuncionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_disyuncion; }
	}

	public final DisyuncionContext disyuncion() throws RecognitionException {
		return disyuncion(0);
	}

	private DisyuncionContext disyuncion(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		DisyuncionContext _localctx = new DisyuncionContext(_ctx, _parentState);
		DisyuncionContext _prevctx = _localctx;
		int _startState = 56;
		enterRecursionRule(_localctx, 56, RULE_disyuncion, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(336);
			conjuncion(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(343);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new DisyuncionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_disyuncion);
					setState(338);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(339);
					match(OR);
					setState(340);
					conjuncion(0);
					}
					} 
				}
				setState(345);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class OpalContext extends ParserRuleContext {
		public DisyuncionContext disyuncion() {
			return getRuleContext(DisyuncionContext.class,0);
		}
		public OpalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opal; }
	}

	public final OpalContext opal() throws RecognitionException {
		OpalContext _localctx = new OpalContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_opal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(346);
			disyuncion(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 25:
			return igualdad_sempred((IgualdadContext)_localctx, predIndex);
		case 27:
			return conjuncion_sempred((ConjuncionContext)_localctx, predIndex);
		case 28:
			return disyuncion_sempred((DisyuncionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean igualdad_sempred(IgualdadContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean conjuncion_sempred(ConjuncionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean disyuncion_sempred(DisyuncionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3,\u015f\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\3\2\3\2\3"+
		"\2\3\3\3\3\3\3\3\3\5\3F\n\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5\\\n\5\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6q\n\6\3\7\3"+
		"\7\3\7\3\7\5\7w\n\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\5\t\u0081\n\t\3\t"+
		"\3\t\3\t\5\t\u0086\n\t\3\t\3\t\3\t\5\t\u008b\n\t\3\n\3\n\3\n\3\n\5\n\u0091"+
		"\n\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u009e\n"+
		"\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00ab\n\r\3\16\3\16"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00b5\n\17\3\20\3\20\3\20\3\21\3\21"+
		"\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\7\22\u00c8"+
		"\n\22\f\22\16\22\u00cb\13\22\3\22\3\22\5\22\u00cf\n\22\3\23\3\23\3\23"+
		"\3\23\3\23\5\23\u00d6\n\23\3\23\3\23\3\23\5\23\u00db\n\23\3\23\3\23\3"+
		"\23\3\23\5\23\u00e1\n\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\5\23\u00f1\n\23\3\23\3\23\3\23\5\23\u00f6\n"+
		"\23\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3"+
		"\26\5\26\u0106\n\26\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u0118\n\30\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\5\31\u012e\n\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u0137\n"+
		"\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\7\33\u0140\n\33\f\33\16\33\u0143"+
		"\13\33\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\7\35\u014d\n\35\f\35\16"+
		"\35\u0150\13\35\3\36\3\36\3\36\3\36\3\36\3\36\7\36\u0158\n\36\f\36\16"+
		"\36\u015b\13\36\3\37\3\37\3\37\2\5\648: \2\4\6\b\n\f\16\20\22\24\26\30"+
		"\32\34\36 \"$&(*,.\60\62\64\668:<\2\4\3\2\22\25\4\2\35!$$\2\u0171\2>\3"+
		"\2\2\2\4E\3\2\2\2\6G\3\2\2\2\b[\3\2\2\2\np\3\2\2\2\fr\3\2\2\2\16z\3\2"+
		"\2\2\20\u008a\3\2\2\2\22\u008c\3\2\2\2\24\u009d\3\2\2\2\26\u009f\3\2\2"+
		"\2\30\u00aa\3\2\2\2\32\u00ac\3\2\2\2\34\u00b4\3\2\2\2\36\u00b6\3\2\2\2"+
		" \u00b9\3\2\2\2\"\u00bc\3\2\2\2$\u00f5\3\2\2\2&\u00f7\3\2\2\2(\u00f9\3"+
		"\2\2\2*\u0105\3\2\2\2,\u0107\3\2\2\2.\u0117\3\2\2\2\60\u012d\3\2\2\2\62"+
		"\u0136\3\2\2\2\64\u0138\3\2\2\2\66\u0144\3\2\2\28\u0146\3\2\2\2:\u0151"+
		"\3\2\2\2<\u015c\3\2\2\2>?\5\4\3\2?@\7\2\2\3@\3\3\2\2\2AB\5\n\6\2BC\5\4"+
		"\3\2CF\3\2\2\2DF\3\2\2\2EA\3\2\2\2ED\3\2\2\2F\5\3\2\2\2GH\7\16\2\2HI\5"+
		"\4\3\2IJ\7\17\2\2J\7\3\2\2\2KL\7\n\2\2LM\5\b\5\2MN\7\13\2\2NO\5\b\5\2"+
		"O\\\3\2\2\2PQ\7\16\2\2QR\5\b\5\2RS\7\17\2\2ST\5\b\5\2T\\\3\2\2\2UV\7\f"+
		"\2\2VW\5\b\5\2WX\7\r\2\2XY\5\b\5\2Y\\\3\2\2\2Z\\\3\2\2\2[K\3\2\2\2[P\3"+
		"\2\2\2[U\3\2\2\2[Z\3\2\2\2\\\t\3\2\2\2]^\5\34\17\2^_\7\20\2\2_q\3\2\2"+
		"\2`a\5 \21\2ab\7\20\2\2bq\3\2\2\2cd\5\f\7\2de\7\20\2\2eq\3\2\2\2fq\5\22"+
		"\n\2gh\5\26\f\2hi\7\20\2\2iq\3\2\2\2jq\5\"\22\2kq\5$\23\2lq\5\6\4\2mn"+
		"\5\16\b\2no\7\20\2\2oq\3\2\2\2p]\3\2\2\2p`\3\2\2\2pc\3\2\2\2pf\3\2\2\2"+
		"pg\3\2\2\2pj\3\2\2\2pk\3\2\2\2pl\3\2\2\2pm\3\2\2\2q\13\3\2\2\2rs\5\32"+
		"\16\2st\7\'\2\2tv\7\n\2\2uw\5\20\t\2vu\3\2\2\2vw\3\2\2\2wx\3\2\2\2xy\7"+
		"\13\2\2y\r\3\2\2\2z{\7&\2\2{|\5\60\31\2|\17\3\2\2\2}\u0080\5\32\16\2~"+
		"\u0081\7\'\2\2\177\u0081\3\2\2\2\u0080~\3\2\2\2\u0080\177\3\2\2\2\u0081"+
		"\u008b\3\2\2\2\u0082\u0085\5\32\16\2\u0083\u0086\7\'\2\2\u0084\u0086\3"+
		"\2\2\2\u0085\u0083\3\2\2\2\u0085\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087"+
		"\u0088\7\21\2\2\u0088\u0089\5\20\t\2\u0089\u008b\3\2\2\2\u008a}\3\2\2"+
		"\2\u008a\u0082\3\2\2\2\u008b\21\3\2\2\2\u008c\u008d\5\32\16\2\u008d\u008e"+
		"\7\'\2\2\u008e\u0090\7\n\2\2\u008f\u0091\5\24\13\2\u0090\u008f\3\2\2\2"+
		"\u0090\u0091\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0093\7\13\2\2\u0093\u0094"+
		"\5\6\4\2\u0094\23\3\2\2\2\u0095\u0096\5\32\16\2\u0096\u0097\7\'\2\2\u0097"+
		"\u009e\3\2\2\2\u0098\u0099\5\32\16\2\u0099\u009a\7\'\2\2\u009a\u009b\7"+
		"\21\2\2\u009b\u009c\5\24\13\2\u009c\u009e\3\2\2\2\u009d\u0095\3\2\2\2"+
		"\u009d\u0098\3\2\2\2\u009e\25\3\2\2\2\u009f\u00a0\7\'\2\2\u00a0\u00a1"+
		"\7\n\2\2\u00a1\u00a2\5\30\r\2\u00a2\u00a3\7\13\2\2\u00a3\27\3\2\2\2\u00a4"+
		"\u00ab\5&\24\2\u00a5\u00a6\5&\24\2\u00a6\u00a7\7\21\2\2\u00a7\u00a8\5"+
		"\30\r\2\u00a8\u00ab\3\2\2\2\u00a9\u00ab\3\2\2\2\u00aa\u00a4\3\2\2\2\u00aa"+
		"\u00a5\3\2\2\2\u00aa\u00a9\3\2\2\2\u00ab\31\3\2\2\2\u00ac\u00ad\t\2\2"+
		"\2\u00ad\33\3\2\2\2\u00ae\u00af\5\32\16\2\u00af\u00b0\7\'\2\2\u00b0\u00b5"+
		"\3\2\2\2\u00b1\u00b2\5\32\16\2\u00b2\u00b3\5 \21\2\u00b3\u00b5\3\2\2\2"+
		"\u00b4\u00ae\3\2\2\2\u00b4\u00b1\3\2\2\2\u00b5\35\3\2\2\2\u00b6\u00b7"+
		"\7\26\2\2\u00b7\u00b8\5&\24\2\u00b8\37\3\2\2\2\u00b9\u00ba\7\'\2\2\u00ba"+
		"\u00bb\5\36\20\2\u00bb!\3\2\2\2\u00bc\u00bd\7\32\2\2\u00bd\u00be\7\n\2"+
		"\2\u00be\u00bf\5&\24\2\u00bf\u00c0\7\13\2\2\u00c0\u00c9\5\n\6\2\u00c1"+
		"\u00c2\7\33\2\2\u00c2\u00c3\7\n\2\2\u00c3\u00c4\5&\24\2\u00c4\u00c5\7"+
		"\13\2\2\u00c5\u00c6\5\n\6\2\u00c6\u00c8\3\2\2\2\u00c7\u00c1\3\2\2\2\u00c8"+
		"\u00cb\3\2\2\2\u00c9\u00c7\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00ce\3\2"+
		"\2\2\u00cb\u00c9\3\2\2\2\u00cc\u00cd\7\34\2\2\u00cd\u00cf\5\n\6\2\u00ce"+
		"\u00cc\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf#\3\2\2\2\u00d0\u00d1\7\31\2\2"+
		"\u00d1\u00d5\7\n\2\2\u00d2\u00d6\5 \21\2\u00d3\u00d6\5\34\17\2\u00d4\u00d6"+
		"\3\2\2\2\u00d5\u00d2\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d5\u00d4\3\2\2\2\u00d6"+
		"\u00d7\3\2\2\2\u00d7\u00da\7\20\2\2\u00d8\u00db\5&\24\2\u00d9\u00db\3"+
		"\2\2\2\u00da\u00d8\3\2\2\2\u00da\u00d9\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc"+
		"\u00e0\7\20\2\2\u00dd\u00e1\5 \21\2\u00de\u00e1\5&\24\2\u00df\u00e1\3"+
		"\2\2\2\u00e0\u00dd\3\2\2\2\u00e0\u00de\3\2\2\2\u00e0\u00df\3\2\2\2\u00e1"+
		"\u00e2\3\2\2\2\u00e2\u00e3\7\13\2\2\u00e3\u00f6\5\n\6\2\u00e4\u00e5\7"+
		"\30\2\2\u00e5\u00e6\7\n\2\2\u00e6\u00e7\5&\24\2\u00e7\u00e8\7\13\2\2\u00e8"+
		"\u00e9\5\n\6\2\u00e9\u00f6\3\2\2\2\u00ea\u00eb\7\27\2\2\u00eb\u00ec\5"+
		"\n\6\2\u00ec\u00ed\7\30\2\2\u00ed\u00f0\7\n\2\2\u00ee\u00f1\5&\24\2\u00ef"+
		"\u00f1\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f0\u00ef\3\2\2\2\u00f1\u00f2\3\2"+
		"\2\2\u00f2\u00f3\7\13\2\2\u00f3\u00f4\7\20\2\2\u00f4\u00f6\3\2\2\2\u00f5"+
		"\u00d0\3\2\2\2\u00f5\u00e4\3\2\2\2\u00f5\u00ea\3\2\2\2\u00f6%\3\2\2\2"+
		"\u00f7\u00f8\5<\37\2\u00f8\'\3\2\2\2\u00f9\u00fa\5,\27\2\u00fa\u00fb\5"+
		"*\26\2\u00fb)\3\2\2\2\u00fc\u00fd\7\3\2\2\u00fd\u00fe\5,\27\2\u00fe\u00ff"+
		"\5*\26\2\u00ff\u0106\3\2\2\2\u0100\u0101\7\4\2\2\u0101\u0102\5,\27\2\u0102"+
		"\u0103\5*\26\2\u0103\u0106\3\2\2\2\u0104\u0106\3\2\2\2\u0105\u00fc\3\2"+
		"\2\2\u0105\u0100\3\2\2\2\u0105\u0104\3\2\2\2\u0106+\3\2\2\2\u0107\u0108"+
		"\5\60\31\2\u0108\u0109\5.\30\2\u0109-\3\2\2\2\u010a\u010b\7\5\2\2\u010b"+
		"\u010c\5\60\31\2\u010c\u010d\5.\30\2\u010d\u0118\3\2\2\2\u010e\u010f\7"+
		"\6\2\2\u010f\u0110\5\60\31\2\u0110\u0111\5.\30\2\u0111\u0118\3\2\2\2\u0112"+
		"\u0113\7\7\2\2\u0113\u0114\5\60\31\2\u0114\u0115\5.\30\2\u0115\u0118\3"+
		"\2\2\2\u0116\u0118\3\2\2\2\u0117\u010a\3\2\2\2\u0117\u010e\3\2\2\2\u0117"+
		"\u0112\3\2\2\2\u0117\u0116\3\2\2\2\u0118/\3\2\2\2\u0119\u011a\5\62\32"+
		"\2\u011a\u011b\7\n\2\2\u011b\u011c\5<\37\2\u011c\u011d\7\13\2\2\u011d"+
		"\u012e\3\2\2\2\u011e\u011f\5\62\32\2\u011f\u0120\7(\2\2\u0120\u012e\3"+
		"\2\2\2\u0121\u0122\5\62\32\2\u0122\u0123\7\'\2\2\u0123\u012e\3\2\2\2\u0124"+
		"\u0125\5\62\32\2\u0125\u0126\7)\2\2\u0126\u012e\3\2\2\2\u0127\u0128\5"+
		"\62\32\2\u0128\u0129\5\26\f\2\u0129\u012e\3\2\2\2\u012a\u012b\5\62\32"+
		"\2\u012b\u012c\7*\2\2\u012c\u012e\3\2\2\2\u012d\u0119\3\2\2\2\u012d\u011e"+
		"\3\2\2\2\u012d\u0121\3\2\2\2\u012d\u0124\3\2\2\2\u012d\u0127\3\2\2\2\u012d"+
		"\u012a\3\2\2\2\u012e\61\3\2\2\2\u012f\u0137\7\b\2\2\u0130\u0137\7\t\2"+
		"\2\u0131\u0137\7\3\2\2\u0132\u0137\7\4\2\2\u0133\u0134\7%\2\2\u0134\u0137"+
		"\5\62\32\2\u0135\u0137\3\2\2\2\u0136\u012f\3\2\2\2\u0136\u0130\3\2\2\2"+
		"\u0136\u0131\3\2\2\2\u0136\u0132\3\2\2\2\u0136\u0133\3\2\2\2\u0136\u0135"+
		"\3\2\2\2\u0137\63\3\2\2\2\u0138\u0139\b\33\1\2\u0139\u013a\5(\25\2\u013a"+
		"\u0141\3\2\2\2\u013b\u013c\f\3\2\2\u013c\u013d\5\66\34\2\u013d\u013e\5"+
		"(\25\2\u013e\u0140\3\2\2\2\u013f\u013b\3\2\2\2\u0140\u0143\3\2\2\2\u0141"+
		"\u013f\3\2\2\2\u0141\u0142\3\2\2\2\u0142\65\3\2\2\2\u0143\u0141\3\2\2"+
		"\2\u0144\u0145\t\3\2\2\u0145\67\3\2\2\2\u0146\u0147\b\35\1\2\u0147\u0148"+
		"\5\64\33\2\u0148\u014e\3\2\2\2\u0149\u014a\f\3\2\2\u014a\u014b\7\"\2\2"+
		"\u014b\u014d\5\64\33\2\u014c\u0149\3\2\2\2\u014d\u0150\3\2\2\2\u014e\u014c"+
		"\3\2\2\2\u014e\u014f\3\2\2\2\u014f9\3\2\2\2\u0150\u014e\3\2\2\2\u0151"+
		"\u0152\b\36\1\2\u0152\u0153\58\35\2\u0153\u0159\3\2\2\2\u0154\u0155\f"+
		"\3\2\2\u0155\u0156\7#\2\2\u0156\u0158\58\35\2\u0157\u0154\3\2\2\2\u0158"+
		"\u015b\3\2\2\2\u0159\u0157\3\2\2\2\u0159\u015a\3\2\2\2\u015a;\3\2\2\2"+
		"\u015b\u0159\3\2\2\2\u015c\u015d\5:\36\2\u015d=\3\2\2\2\33E[pv\u0080\u0085"+
		"\u008a\u0090\u009d\u00aa\u00b4\u00c9\u00ce\u00d5\u00da\u00e0\u00f0\u00f5"+
		"\u0105\u0117\u012d\u0136\u0141\u014e\u0159";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}