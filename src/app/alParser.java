// Generated from /home/agustin/Desktop/Facultad/Técnicas de Compilación/Proyectos/TC-TP2-2020/src/app/al.g4 by ANTLR 4.7.1

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
		MENORIG=29, MAYORIG=30, IGUAL=31, AND=32, OR=33, DIFF=34, NOT=35, ID=36, 
		NUMERO=37, FLOTANTE=38, LITERAL=39, WS=40, OTRO=41;
	public static final int
		RULE_prog = 0, RULE_instrucciones = 1, RULE_bloque = 2, RULE_balance = 3, 
		RULE_instruccion = 4, RULE_declaracion_funcion = 5, RULE_param_declaracion = 6, 
		RULE_param_definicion = 7, RULE_funcion = 8, RULE_parametros = 9, RULE_tipodato = 10, 
		RULE_declaracion = 11, RULE_asign = 12, RULE_asignacion = 13, RULE_condicional = 14, 
		RULE_iteracion = 15, RULE_operacion = 16, RULE_expresion = 17, RULE_exp = 18, 
		RULE_termino = 19, RULE_term = 20, RULE_factor = 21, RULE_prefix = 22, 
		RULE_igualdad = 23, RULE_comparaciones = 24, RULE_conjuncion = 25, RULE_disyuncion = 26, 
		RULE_opal = 27;
	public static final String[] ruleNames = {
		"prog", "instrucciones", "bloque", "balance", "instruccion", "declaracion_funcion", 
		"param_declaracion", "param_definicion", "funcion", "parametros", "tipodato", 
		"declaracion", "asign", "asignacion", "condicional", "iteracion", "operacion", 
		"expresion", "exp", "termino", "term", "factor", "prefix", "igualdad", 
		"comparaciones", "conjuncion", "disyuncion", "opal"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'+'", "'-'", "'*'", "'/'", "'%'", "'++'", "'--'", "'('", "')'", 
		"'['", "']'", "'{'", "'}'", "';'", "','", "'int'", "'double'", "'char'", 
		"'void'", "'='", "'do'", "'while'", "'for'", "'if'", "'else if'", "'else'", 
		"'<'", "'>'", "'<='", "'>='", "'=='", "'&&'", "'||'", "'!='", "'!'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, "PA", "PC", "CA", "CC", 
		"LA", "LC", "PYC", "COMA", "INT", "DOUBLE", "CHAR", "VOID", "EQ", "DO", 
		"WHILE", "FOR", "IF", "ELIF", "ELSE", "MENOR", "MAYOR", "MENORIG", "MAYORIG", 
		"IGUAL", "AND", "OR", "DIFF", "NOT", "ID", "NUMERO", "FLOTANTE", "LITERAL", 
		"WS", "OTRO"
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof alListener ) ((alListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof alListener ) ((alListener)listener).exitProg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alVisitor ) return ((alVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			instrucciones();
			setState(57);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof alListener ) ((alListener)listener).enterInstrucciones(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof alListener ) ((alListener)listener).exitInstrucciones(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alVisitor ) return ((alVisitor<? extends T>)visitor).visitInstrucciones(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstruccionesContext instrucciones() throws RecognitionException {
		InstruccionesContext _localctx = new InstruccionesContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_instrucciones);
		try {
			setState(63);
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
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(59);
				instruccion();
				setState(60);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof alListener ) ((alListener)listener).enterBloque(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof alListener ) ((alListener)listener).exitBloque(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alVisitor ) return ((alVisitor<? extends T>)visitor).visitBloque(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BloqueContext bloque() throws RecognitionException {
		BloqueContext _localctx = new BloqueContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_bloque);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			match(LA);
			setState(66);
			instrucciones();
			setState(67);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof alListener ) ((alListener)listener).enterBalance(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof alListener ) ((alListener)listener).exitBalance(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alVisitor ) return ((alVisitor<? extends T>)visitor).visitBalance(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BalanceContext balance() throws RecognitionException {
		BalanceContext _localctx = new BalanceContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_balance);
		try {
			setState(85);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PA:
				enterOuterAlt(_localctx, 1);
				{
				setState(69);
				match(PA);
				setState(70);
				balance();
				setState(71);
				match(PC);
				setState(72);
				balance();
				}
				break;
			case LA:
				enterOuterAlt(_localctx, 2);
				{
				setState(74);
				match(LA);
				setState(75);
				balance();
				setState(76);
				match(LC);
				setState(77);
				balance();
				}
				break;
			case CA:
				enterOuterAlt(_localctx, 3);
				{
				setState(79);
				match(CA);
				setState(80);
				balance();
				setState(81);
				match(CC);
				setState(82);
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
		public InstruccionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruccion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof alListener ) ((alListener)listener).enterInstruccion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof alListener ) ((alListener)listener).exitInstruccion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alVisitor ) return ((alVisitor<? extends T>)visitor).visitInstruccion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstruccionContext instruccion() throws RecognitionException {
		InstruccionContext _localctx = new InstruccionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_instruccion);
		try {
			setState(100);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(87);
				declaracion();
				setState(88);
				match(PYC);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(90);
				asignacion();
				setState(91);
				match(PYC);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(93);
				declaracion_funcion();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(94);
				funcion();
				setState(95);
				match(PYC);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(97);
				condicional();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(98);
				iteracion();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(99);
				bloque();
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
		public TerminalNode PYC() { return getToken(alParser.PYC, 0); }
		public Param_declaracionContext param_declaracion() {
			return getRuleContext(Param_declaracionContext.class,0);
		}
		public BloqueContext bloque() {
			return getRuleContext(BloqueContext.class,0);
		}
		public Param_definicionContext param_definicion() {
			return getRuleContext(Param_definicionContext.class,0);
		}
		public Declaracion_funcionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracion_funcion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof alListener ) ((alListener)listener).enterDeclaracion_funcion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof alListener ) ((alListener)listener).exitDeclaracion_funcion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alVisitor ) return ((alVisitor<? extends T>)visitor).visitDeclaracion_funcion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Declaracion_funcionContext declaracion_funcion() throws RecognitionException {
		Declaracion_funcionContext _localctx = new Declaracion_funcionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_declaracion_funcion);
		int _la;
		try {
			setState(120);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(102);
				tipodato();
				setState(103);
				match(ID);
				setState(104);
				match(PA);
				setState(106);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << DOUBLE) | (1L << CHAR) | (1L << VOID))) != 0)) {
					{
					setState(105);
					param_declaracion();
					}
				}

				setState(108);
				match(PC);
				setState(109);
				match(PYC);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(111);
				tipodato();
				setState(112);
				match(ID);
				setState(113);
				match(PA);
				setState(115);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << DOUBLE) | (1L << CHAR) | (1L << VOID))) != 0)) {
					{
					setState(114);
					param_definicion();
					}
				}

				setState(117);
				match(PC);
				setState(118);
				bloque();
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof alListener ) ((alListener)listener).enterParam_declaracion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof alListener ) ((alListener)listener).exitParam_declaracion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alVisitor ) return ((alVisitor<? extends T>)visitor).visitParam_declaracion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Param_declaracionContext param_declaracion() throws RecognitionException {
		Param_declaracionContext _localctx = new Param_declaracionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_param_declaracion);
		try {
			setState(135);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(122);
				tipodato();
				setState(125);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case ID:
					{
					setState(123);
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
				setState(127);
				tipodato();
				setState(130);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case ID:
					{
					setState(128);
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
				setState(132);
				match(COMA);
				setState(133);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof alListener ) ((alListener)listener).enterParam_definicion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof alListener ) ((alListener)listener).exitParam_definicion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alVisitor ) return ((alVisitor<? extends T>)visitor).visitParam_definicion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Param_definicionContext param_definicion() throws RecognitionException {
		Param_definicionContext _localctx = new Param_definicionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_param_definicion);
		try {
			setState(145);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(137);
				tipodato();
				setState(138);
				match(ID);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(140);
				tipodato();
				setState(141);
				match(ID);
				setState(142);
				match(COMA);
				setState(143);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof alListener ) ((alListener)listener).enterFuncion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof alListener ) ((alListener)listener).exitFuncion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alVisitor ) return ((alVisitor<? extends T>)visitor).visitFuncion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncionContext funcion() throws RecognitionException {
		FuncionContext _localctx = new FuncionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_funcion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			match(ID);
			setState(148);
			match(PA);
			setState(149);
			parametros();
			setState(150);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof alListener ) ((alListener)listener).enterParametros(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof alListener ) ((alListener)listener).exitParametros(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alVisitor ) return ((alVisitor<? extends T>)visitor).visitParametros(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParametrosContext parametros() throws RecognitionException {
		ParametrosContext _localctx = new ParametrosContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_parametros);
		try {
			setState(158);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(152);
				operacion();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(153);
				operacion();
				setState(154);
				match(COMA);
				setState(155);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof alListener ) ((alListener)listener).enterTipodato(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof alListener ) ((alListener)listener).exitTipodato(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alVisitor ) return ((alVisitor<? extends T>)visitor).visitTipodato(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TipodatoContext tipodato() throws RecognitionException {
		TipodatoContext _localctx = new TipodatoContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_tipodato);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof alListener ) ((alListener)listener).enterDeclaracion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof alListener ) ((alListener)listener).exitDeclaracion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alVisitor ) return ((alVisitor<? extends T>)visitor).visitDeclaracion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclaracionContext declaracion() throws RecognitionException {
		DeclaracionContext _localctx = new DeclaracionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_declaracion);
		try {
			setState(168);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(162);
				tipodato();
				setState(163);
				match(ID);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(165);
				tipodato();
				setState(166);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof alListener ) ((alListener)listener).enterAsign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof alListener ) ((alListener)listener).exitAsign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alVisitor ) return ((alVisitor<? extends T>)visitor).visitAsign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AsignContext asign() throws RecognitionException {
		AsignContext _localctx = new AsignContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_asign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			match(EQ);
			setState(171);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof alListener ) ((alListener)listener).enterAsignacion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof alListener ) ((alListener)listener).exitAsignacion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alVisitor ) return ((alVisitor<? extends T>)visitor).visitAsignacion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AsignacionContext asignacion() throws RecognitionException {
		AsignacionContext _localctx = new AsignacionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_asignacion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
			match(ID);
			setState(174);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof alListener ) ((alListener)listener).enterCondicional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof alListener ) ((alListener)listener).exitCondicional(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alVisitor ) return ((alVisitor<? extends T>)visitor).visitCondicional(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CondicionalContext condicional() throws RecognitionException {
		CondicionalContext _localctx = new CondicionalContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_condicional);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			match(IF);
			setState(177);
			match(PA);
			setState(178);
			operacion();
			setState(179);
			match(PC);
			setState(180);
			instruccion();
			setState(189);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(181);
					match(ELIF);
					setState(182);
					match(PA);
					setState(183);
					operacion();
					setState(184);
					match(PC);
					setState(185);
					instruccion();
					}
					} 
				}
				setState(191);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			}
			setState(194);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(192);
				match(ELSE);
				setState(193);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof alListener ) ((alListener)listener).enterIteracion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof alListener ) ((alListener)listener).exitIteracion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alVisitor ) return ((alVisitor<? extends T>)visitor).visitIteracion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IteracionContext iteracion() throws RecognitionException {
		IteracionContext _localctx = new IteracionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_iteracion);
		try {
			setState(233);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FOR:
				enterOuterAlt(_localctx, 1);
				{
				setState(196);
				match(FOR);
				setState(197);
				match(PA);
				setState(201);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case ID:
					{
					setState(198);
					asignacion();
					}
					break;
				case INT:
				case DOUBLE:
				case CHAR:
				case VOID:
					{
					setState(199);
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
				setState(203);
				match(PYC);
				setState(206);
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
					setState(204);
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
				setState(208);
				match(PYC);
				setState(212);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
				case 1:
					{
					setState(209);
					asignacion();
					}
					break;
				case 2:
					{
					setState(210);
					operacion();
					}
					break;
				case 3:
					{
					}
					break;
				}
				setState(214);
				match(PC);
				setState(215);
				instruccion();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 2);
				{
				setState(216);
				match(WHILE);
				setState(217);
				match(PA);
				setState(218);
				operacion();
				setState(219);
				match(PC);
				setState(220);
				instruccion();
				}
				break;
			case DO:
				enterOuterAlt(_localctx, 3);
				{
				setState(222);
				match(DO);
				setState(223);
				instruccion();
				setState(224);
				match(WHILE);
				setState(225);
				match(PA);
				setState(228);
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
					setState(226);
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
				setState(230);
				match(PC);
				setState(231);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof alListener ) ((alListener)listener).enterOperacion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof alListener ) ((alListener)listener).exitOperacion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alVisitor ) return ((alVisitor<? extends T>)visitor).visitOperacion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperacionContext operacion() throws RecognitionException {
		OperacionContext _localctx = new OperacionContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_operacion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(235);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof alListener ) ((alListener)listener).enterExpresion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof alListener ) ((alListener)listener).exitExpresion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alVisitor ) return ((alVisitor<? extends T>)visitor).visitExpresion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpresionContext expresion() throws RecognitionException {
		ExpresionContext _localctx = new ExpresionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_expresion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(237);
			termino();
			setState(238);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof alListener ) ((alListener)listener).enterExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof alListener ) ((alListener)listener).exitExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alVisitor ) return ((alVisitor<? extends T>)visitor).visitExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpContext exp() throws RecognitionException {
		ExpContext _localctx = new ExpContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_exp);
		try {
			setState(249);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(240);
				match(T__0);
				setState(241);
				termino();
				setState(242);
				exp();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(244);
				match(T__1);
				setState(245);
				termino();
				setState(246);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof alListener ) ((alListener)listener).enterTermino(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof alListener ) ((alListener)listener).exitTermino(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alVisitor ) return ((alVisitor<? extends T>)visitor).visitTermino(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TerminoContext termino() throws RecognitionException {
		TerminoContext _localctx = new TerminoContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_termino);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(251);
			factor();
			setState(252);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof alListener ) ((alListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof alListener ) ((alListener)listener).exitTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alVisitor ) return ((alVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_term);
		try {
			setState(267);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(254);
				match(T__2);
				setState(255);
				factor();
				setState(256);
				term();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(258);
				match(T__3);
				setState(259);
				factor();
				setState(260);
				term();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(262);
				match(T__4);
				setState(263);
				factor();
				setState(264);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof alListener ) ((alListener)listener).enterFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof alListener ) ((alListener)listener).exitFactor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alVisitor ) return ((alVisitor<? extends T>)visitor).visitFactor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_factor);
		try {
			setState(289);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(269);
				prefix();
				setState(270);
				match(PA);
				setState(271);
				opal();
				setState(272);
				match(PC);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(274);
				prefix();
				setState(275);
				match(NUMERO);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(277);
				prefix();
				setState(278);
				match(ID);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(280);
				prefix();
				setState(281);
				match(FLOTANTE);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(283);
				prefix();
				setState(284);
				funcion();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(286);
				prefix();
				setState(287);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof alListener ) ((alListener)listener).enterPrefix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof alListener ) ((alListener)listener).exitPrefix(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alVisitor ) return ((alVisitor<? extends T>)visitor).visitPrefix(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrefixContext prefix() throws RecognitionException {
		PrefixContext _localctx = new PrefixContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_prefix);
		try {
			setState(298);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				enterOuterAlt(_localctx, 1);
				{
				setState(291);
				match(T__5);
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 2);
				{
				setState(292);
				match(T__6);
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 3);
				{
				setState(293);
				match(T__0);
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 4);
				{
				setState(294);
				match(T__1);
				}
				break;
			case NOT:
				enterOuterAlt(_localctx, 5);
				{
				setState(295);
				match(NOT);
				setState(296);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof alListener ) ((alListener)listener).enterIgualdad(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof alListener ) ((alListener)listener).exitIgualdad(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alVisitor ) return ((alVisitor<? extends T>)visitor).visitIgualdad(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IgualdadContext igualdad() throws RecognitionException {
		return igualdad(0);
	}

	private IgualdadContext igualdad(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		IgualdadContext _localctx = new IgualdadContext(_ctx, _parentState);
		IgualdadContext _prevctx = _localctx;
		int _startState = 46;
		enterRecursionRule(_localctx, 46, RULE_igualdad, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(301);
			expresion();
			}
			_ctx.stop = _input.LT(-1);
			setState(309);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new IgualdadContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_igualdad);
					setState(303);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(304);
					comparaciones();
					setState(305);
					expresion();
					}
					} 
				}
				setState(311);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof alListener ) ((alListener)listener).enterComparaciones(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof alListener ) ((alListener)listener).exitComparaciones(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alVisitor ) return ((alVisitor<? extends T>)visitor).visitComparaciones(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparacionesContext comparaciones() throws RecognitionException {
		ComparacionesContext _localctx = new ComparacionesContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_comparaciones);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(312);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof alListener ) ((alListener)listener).enterConjuncion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof alListener ) ((alListener)listener).exitConjuncion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alVisitor ) return ((alVisitor<? extends T>)visitor).visitConjuncion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConjuncionContext conjuncion() throws RecognitionException {
		return conjuncion(0);
	}

	private ConjuncionContext conjuncion(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ConjuncionContext _localctx = new ConjuncionContext(_ctx, _parentState);
		ConjuncionContext _prevctx = _localctx;
		int _startState = 50;
		enterRecursionRule(_localctx, 50, RULE_conjuncion, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(315);
			igualdad(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(322);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ConjuncionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_conjuncion);
					setState(317);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(318);
					match(AND);
					setState(319);
					igualdad(0);
					}
					} 
				}
				setState(324);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof alListener ) ((alListener)listener).enterDisyuncion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof alListener ) ((alListener)listener).exitDisyuncion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alVisitor ) return ((alVisitor<? extends T>)visitor).visitDisyuncion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DisyuncionContext disyuncion() throws RecognitionException {
		return disyuncion(0);
	}

	private DisyuncionContext disyuncion(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		DisyuncionContext _localctx = new DisyuncionContext(_ctx, _parentState);
		DisyuncionContext _prevctx = _localctx;
		int _startState = 52;
		enterRecursionRule(_localctx, 52, RULE_disyuncion, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(326);
			conjuncion(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(333);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new DisyuncionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_disyuncion);
					setState(328);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(329);
					match(OR);
					setState(330);
					conjuncion(0);
					}
					} 
				}
				setState(335);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof alListener ) ((alListener)listener).enterOpal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof alListener ) ((alListener)listener).exitOpal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alVisitor ) return ((alVisitor<? extends T>)visitor).visitOpal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OpalContext opal() throws RecognitionException {
		OpalContext _localctx = new OpalContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_opal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(336);
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
		case 23:
			return igualdad_sempred((IgualdadContext)_localctx, predIndex);
		case 25:
			return conjuncion_sempred((ConjuncionContext)_localctx, predIndex);
		case 26:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3+\u0155\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\3\2\3\2\3\2\3\3\3\3\3\3\3\3\5"+
		"\3B\n\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\5\5X\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\5\6g\n\6\3\7\3\7\3\7\3\7\5\7m\n\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\5\7v\n\7\3\7\3\7\3\7\5\7{\n\7\3\b\3\b\3\b\5\b\u0080\n\b\3\b\3\b\3\b"+
		"\5\b\u0085\n\b\3\b\3\b\3\b\5\b\u008a\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\5\t\u0094\n\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\5\13"+
		"\u00a1\n\13\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00ab\n\r\3\16\3\16\3"+
		"\16\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3"+
		"\20\7\20\u00be\n\20\f\20\16\20\u00c1\13\20\3\20\3\20\5\20\u00c5\n\20\3"+
		"\21\3\21\3\21\3\21\3\21\5\21\u00cc\n\21\3\21\3\21\3\21\5\21\u00d1\n\21"+
		"\3\21\3\21\3\21\3\21\5\21\u00d7\n\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u00e7\n\21\3\21\3\21\3\21\5\21"+
		"\u00ec\n\21\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\5\24\u00fc\n\24\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u010e\n\26\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\5\27\u0124\n\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u012d"+
		"\n\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\7\31\u0136\n\31\f\31\16\31\u0139"+
		"\13\31\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\7\33\u0143\n\33\f\33\16"+
		"\33\u0146\13\33\3\34\3\34\3\34\3\34\3\34\3\34\7\34\u014e\n\34\f\34\16"+
		"\34\u0151\13\34\3\35\3\35\3\35\2\5\60\64\66\36\2\4\6\b\n\f\16\20\22\24"+
		"\26\30\32\34\36 \"$&(*,.\60\62\64\668\2\4\3\2\22\25\4\2\35!$$\2\u0168"+
		"\2:\3\2\2\2\4A\3\2\2\2\6C\3\2\2\2\bW\3\2\2\2\nf\3\2\2\2\fz\3\2\2\2\16"+
		"\u0089\3\2\2\2\20\u0093\3\2\2\2\22\u0095\3\2\2\2\24\u00a0\3\2\2\2\26\u00a2"+
		"\3\2\2\2\30\u00aa\3\2\2\2\32\u00ac\3\2\2\2\34\u00af\3\2\2\2\36\u00b2\3"+
		"\2\2\2 \u00eb\3\2\2\2\"\u00ed\3\2\2\2$\u00ef\3\2\2\2&\u00fb\3\2\2\2(\u00fd"+
		"\3\2\2\2*\u010d\3\2\2\2,\u0123\3\2\2\2.\u012c\3\2\2\2\60\u012e\3\2\2\2"+
		"\62\u013a\3\2\2\2\64\u013c\3\2\2\2\66\u0147\3\2\2\28\u0152\3\2\2\2:;\5"+
		"\4\3\2;<\7\2\2\3<\3\3\2\2\2=>\5\n\6\2>?\5\4\3\2?B\3\2\2\2@B\3\2\2\2A="+
		"\3\2\2\2A@\3\2\2\2B\5\3\2\2\2CD\7\16\2\2DE\5\4\3\2EF\7\17\2\2F\7\3\2\2"+
		"\2GH\7\n\2\2HI\5\b\5\2IJ\7\13\2\2JK\5\b\5\2KX\3\2\2\2LM\7\16\2\2MN\5\b"+
		"\5\2NO\7\17\2\2OP\5\b\5\2PX\3\2\2\2QR\7\f\2\2RS\5\b\5\2ST\7\r\2\2TU\5"+
		"\b\5\2UX\3\2\2\2VX\3\2\2\2WG\3\2\2\2WL\3\2\2\2WQ\3\2\2\2WV\3\2\2\2X\t"+
		"\3\2\2\2YZ\5\30\r\2Z[\7\20\2\2[g\3\2\2\2\\]\5\34\17\2]^\7\20\2\2^g\3\2"+
		"\2\2_g\5\f\7\2`a\5\22\n\2ab\7\20\2\2bg\3\2\2\2cg\5\36\20\2dg\5 \21\2e"+
		"g\5\6\4\2fY\3\2\2\2f\\\3\2\2\2f_\3\2\2\2f`\3\2\2\2fc\3\2\2\2fd\3\2\2\2"+
		"fe\3\2\2\2g\13\3\2\2\2hi\5\26\f\2ij\7&\2\2jl\7\n\2\2km\5\16\b\2lk\3\2"+
		"\2\2lm\3\2\2\2mn\3\2\2\2no\7\13\2\2op\7\20\2\2p{\3\2\2\2qr\5\26\f\2rs"+
		"\7&\2\2su\7\n\2\2tv\5\20\t\2ut\3\2\2\2uv\3\2\2\2vw\3\2\2\2wx\7\13\2\2"+
		"xy\5\6\4\2y{\3\2\2\2zh\3\2\2\2zq\3\2\2\2{\r\3\2\2\2|\177\5\26\f\2}\u0080"+
		"\7&\2\2~\u0080\3\2\2\2\177}\3\2\2\2\177~\3\2\2\2\u0080\u008a\3\2\2\2\u0081"+
		"\u0084\5\26\f\2\u0082\u0085\7&\2\2\u0083\u0085\3\2\2\2\u0084\u0082\3\2"+
		"\2\2\u0084\u0083\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0087\7\21\2\2\u0087"+
		"\u0088\5\16\b\2\u0088\u008a\3\2\2\2\u0089|\3\2\2\2\u0089\u0081\3\2\2\2"+
		"\u008a\17\3\2\2\2\u008b\u008c\5\26\f\2\u008c\u008d\7&\2\2\u008d\u0094"+
		"\3\2\2\2\u008e\u008f\5\26\f\2\u008f\u0090\7&\2\2\u0090\u0091\7\21\2\2"+
		"\u0091\u0092\5\20\t\2\u0092\u0094\3\2\2\2\u0093\u008b\3\2\2\2\u0093\u008e"+
		"\3\2\2\2\u0094\21\3\2\2\2\u0095\u0096\7&\2\2\u0096\u0097\7\n\2\2\u0097"+
		"\u0098\5\24\13\2\u0098\u0099\7\13\2\2\u0099\23\3\2\2\2\u009a\u00a1\5\""+
		"\22\2\u009b\u009c\5\"\22\2\u009c\u009d\7\21\2\2\u009d\u009e\5\24\13\2"+
		"\u009e\u00a1\3\2\2\2\u009f\u00a1\3\2\2\2\u00a0\u009a\3\2\2\2\u00a0\u009b"+
		"\3\2\2\2\u00a0\u009f\3\2\2\2\u00a1\25\3\2\2\2\u00a2\u00a3\t\2\2\2\u00a3"+
		"\27\3\2\2\2\u00a4\u00a5\5\26\f\2\u00a5\u00a6\7&\2\2\u00a6\u00ab\3\2\2"+
		"\2\u00a7\u00a8\5\26\f\2\u00a8\u00a9\5\34\17\2\u00a9\u00ab\3\2\2\2\u00aa"+
		"\u00a4\3\2\2\2\u00aa\u00a7\3\2\2\2\u00ab\31\3\2\2\2\u00ac\u00ad\7\26\2"+
		"\2\u00ad\u00ae\5\"\22\2\u00ae\33\3\2\2\2\u00af\u00b0\7&\2\2\u00b0\u00b1"+
		"\5\32\16\2\u00b1\35\3\2\2\2\u00b2\u00b3\7\32\2\2\u00b3\u00b4\7\n\2\2\u00b4"+
		"\u00b5\5\"\22\2\u00b5\u00b6\7\13\2\2\u00b6\u00bf\5\n\6\2\u00b7\u00b8\7"+
		"\33\2\2\u00b8\u00b9\7\n\2\2\u00b9\u00ba\5\"\22\2\u00ba\u00bb\7\13\2\2"+
		"\u00bb\u00bc\5\n\6\2\u00bc\u00be\3\2\2\2\u00bd\u00b7\3\2\2\2\u00be\u00c1"+
		"\3\2\2\2\u00bf\u00bd\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00c4\3\2\2\2\u00c1"+
		"\u00bf\3\2\2\2\u00c2\u00c3\7\34\2\2\u00c3\u00c5\5\n\6\2\u00c4\u00c2\3"+
		"\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\37\3\2\2\2\u00c6\u00c7\7\31\2\2\u00c7"+
		"\u00cb\7\n\2\2\u00c8\u00cc\5\34\17\2\u00c9\u00cc\5\30\r\2\u00ca\u00cc"+
		"\3\2\2\2\u00cb\u00c8\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cb\u00ca\3\2\2\2\u00cc"+
		"\u00cd\3\2\2\2\u00cd\u00d0\7\20\2\2\u00ce\u00d1\5\"\22\2\u00cf\u00d1\3"+
		"\2\2\2\u00d0\u00ce\3\2\2\2\u00d0\u00cf\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2"+
		"\u00d6\7\20\2\2\u00d3\u00d7\5\34\17\2\u00d4\u00d7\5\"\22\2\u00d5\u00d7"+
		"\3\2\2\2\u00d6\u00d3\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d6\u00d5\3\2\2\2\u00d7"+
		"\u00d8\3\2\2\2\u00d8\u00d9\7\13\2\2\u00d9\u00ec\5\n\6\2\u00da\u00db\7"+
		"\30\2\2\u00db\u00dc\7\n\2\2\u00dc\u00dd\5\"\22\2\u00dd\u00de\7\13\2\2"+
		"\u00de\u00df\5\n\6\2\u00df\u00ec\3\2\2\2\u00e0\u00e1\7\27\2\2\u00e1\u00e2"+
		"\5\n\6\2\u00e2\u00e3\7\30\2\2\u00e3\u00e6\7\n\2\2\u00e4\u00e7\5\"\22\2"+
		"\u00e5\u00e7\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e6\u00e5\3\2\2\2\u00e7\u00e8"+
		"\3\2\2\2\u00e8\u00e9\7\13\2\2\u00e9\u00ea\7\20\2\2\u00ea\u00ec\3\2\2\2"+
		"\u00eb\u00c6\3\2\2\2\u00eb\u00da\3\2\2\2\u00eb\u00e0\3\2\2\2\u00ec!\3"+
		"\2\2\2\u00ed\u00ee\58\35\2\u00ee#\3\2\2\2\u00ef\u00f0\5(\25\2\u00f0\u00f1"+
		"\5&\24\2\u00f1%\3\2\2\2\u00f2\u00f3\7\3\2\2\u00f3\u00f4\5(\25\2\u00f4"+
		"\u00f5\5&\24\2\u00f5\u00fc\3\2\2\2\u00f6\u00f7\7\4\2\2\u00f7\u00f8\5("+
		"\25\2\u00f8\u00f9\5&\24\2\u00f9\u00fc\3\2\2\2\u00fa\u00fc\3\2\2\2\u00fb"+
		"\u00f2\3\2\2\2\u00fb\u00f6\3\2\2\2\u00fb\u00fa\3\2\2\2\u00fc\'\3\2\2\2"+
		"\u00fd\u00fe\5,\27\2\u00fe\u00ff\5*\26\2\u00ff)\3\2\2\2\u0100\u0101\7"+
		"\5\2\2\u0101\u0102\5,\27\2\u0102\u0103\5*\26\2\u0103\u010e\3\2\2\2\u0104"+
		"\u0105\7\6\2\2\u0105\u0106\5,\27\2\u0106\u0107\5*\26\2\u0107\u010e\3\2"+
		"\2\2\u0108\u0109\7\7\2\2\u0109\u010a\5,\27\2\u010a\u010b\5*\26\2\u010b"+
		"\u010e\3\2\2\2\u010c\u010e\3\2\2\2\u010d\u0100\3\2\2\2\u010d\u0104\3\2"+
		"\2\2\u010d\u0108\3\2\2\2\u010d\u010c\3\2\2\2\u010e+\3\2\2\2\u010f\u0110"+
		"\5.\30\2\u0110\u0111\7\n\2\2\u0111\u0112\58\35\2\u0112\u0113\7\13\2\2"+
		"\u0113\u0124\3\2\2\2\u0114\u0115\5.\30\2\u0115\u0116\7\'\2\2\u0116\u0124"+
		"\3\2\2\2\u0117\u0118\5.\30\2\u0118\u0119\7&\2\2\u0119\u0124\3\2\2\2\u011a"+
		"\u011b\5.\30\2\u011b\u011c\7(\2\2\u011c\u0124\3\2\2\2\u011d\u011e\5.\30"+
		"\2\u011e\u011f\5\22\n\2\u011f\u0124\3\2\2\2\u0120\u0121\5.\30\2\u0121"+
		"\u0122\7)\2\2\u0122\u0124\3\2\2\2\u0123\u010f\3\2\2\2\u0123\u0114\3\2"+
		"\2\2\u0123\u0117\3\2\2\2\u0123\u011a\3\2\2\2\u0123\u011d\3\2\2\2\u0123"+
		"\u0120\3\2\2\2\u0124-\3\2\2\2\u0125\u012d\7\b\2\2\u0126\u012d\7\t\2\2"+
		"\u0127\u012d\7\3\2\2\u0128\u012d\7\4\2\2\u0129\u012a\7%\2\2\u012a\u012d"+
		"\5.\30\2\u012b\u012d\3\2\2\2\u012c\u0125\3\2\2\2\u012c\u0126\3\2\2\2\u012c"+
		"\u0127\3\2\2\2\u012c\u0128\3\2\2\2\u012c\u0129\3\2\2\2\u012c\u012b\3\2"+
		"\2\2\u012d/\3\2\2\2\u012e\u012f\b\31\1\2\u012f\u0130\5$\23\2\u0130\u0137"+
		"\3\2\2\2\u0131\u0132\f\3\2\2\u0132\u0133\5\62\32\2\u0133\u0134\5$\23\2"+
		"\u0134\u0136\3\2\2\2\u0135\u0131\3\2\2\2\u0136\u0139\3\2\2\2\u0137\u0135"+
		"\3\2\2\2\u0137\u0138\3\2\2\2\u0138\61\3\2\2\2\u0139\u0137\3\2\2\2\u013a"+
		"\u013b\t\3\2\2\u013b\63\3\2\2\2\u013c\u013d\b\33\1\2\u013d\u013e\5\60"+
		"\31\2\u013e\u0144\3\2\2\2\u013f\u0140\f\3\2\2\u0140\u0141\7\"\2\2\u0141"+
		"\u0143\5\60\31\2\u0142\u013f\3\2\2\2\u0143\u0146\3\2\2\2\u0144\u0142\3"+
		"\2\2\2\u0144\u0145\3\2\2\2\u0145\65\3\2\2\2\u0146\u0144\3\2\2\2\u0147"+
		"\u0148\b\34\1\2\u0148\u0149\5\64\33\2\u0149\u014f\3\2\2\2\u014a\u014b"+
		"\f\3\2\2\u014b\u014c\7#\2\2\u014c\u014e\5\64\33\2\u014d\u014a\3\2\2\2"+
		"\u014e\u0151\3\2\2\2\u014f\u014d\3\2\2\2\u014f\u0150\3\2\2\2\u0150\67"+
		"\3\2\2\2\u0151\u014f\3\2\2\2\u0152\u0153\5\66\34\2\u01539\3\2\2\2\34A"+
		"Wfluz\177\u0084\u0089\u0093\u00a0\u00aa\u00bf\u00c4\u00cb\u00d0\u00d6"+
		"\u00e6\u00eb\u00fb\u010d\u0123\u012c\u0137\u0144\u014f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}