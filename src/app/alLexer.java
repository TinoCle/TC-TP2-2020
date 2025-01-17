// Generated from /home/gonzalo/Técnicas de Compilación/TC-TP2-2020/src/app/al.g4 by ANTLR 4.8

    package app;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class alLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, PA=8, PC=9, CA=10, 
		CC=11, LA=12, LC=13, PYC=14, COMA=15, INT=16, DOUBLE=17, CHAR=18, VOID=19, 
		EQ=20, DO=21, WHILE=22, FOR=23, IF=24, ELIF=25, ELSE=26, MENOR=27, MAYOR=28, 
		MENORIG=29, MAYORIG=30, IGUAL=31, AND=32, OR=33, DIFF=34, NOT=35, RETURN=36, 
		ID=37, NUMERO=38, FLOTANTE=39, LITERAL=40, WS=41, OTRO=42;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "LETRA", "DIGITO", 
			"PA", "PC", "CA", "CC", "LA", "LC", "PYC", "COMA", "INT", "DOUBLE", "CHAR", 
			"VOID", "EQ", "DO", "WHILE", "FOR", "IF", "ELIF", "ELSE", "MENOR", "MAYOR", 
			"MENORIG", "MAYORIG", "IGUAL", "AND", "OR", "DIFF", "NOT", "RETURN", 
			"ID", "NUMERO", "FLOTANTE", "LITERAL", "WS", "OTRO"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'+'", "'-'", "'*'", "'/'", "'%'", "'++'", "'--'", "'('", "')'", 
			"'['", "']'", "'{'", "'}'", "';'", "','", "'int'", "'double'", "'char'", 
			"'void'", "'='", "'do'", "'while'", "'for'", "'if'", "'else if'", "'else'", 
			"'<'", "'>'", "'<='", "'>='", "'=='", "'&&'", "'||'", "'!='", "'!'", 
			"'return'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, "PA", "PC", "CA", "CC", 
			"LA", "LC", "PYC", "COMA", "INT", "DOUBLE", "CHAR", "VOID", "EQ", "DO", 
			"WHILE", "FOR", "IF", "ELIF", "ELSE", "MENOR", "MAYOR", "MENORIG", "MAYORIG", 
			"IGUAL", "AND", "OR", "DIFF", "NOT", "RETURN", "ID", "NUMERO", "FLOTANTE", 
			"LITERAL", "WS", "OTRO"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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


	public alLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "al.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2,\u00f5\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\b\3\b"+
		"\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20"+
		"\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\27\3\27"+
		"\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\33"+
		"\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35"+
		"\3\35\3\36\3\36\3\37\3\37\3 \3 \3 \3!\3!\3!\3\"\3\"\3\"\3#\3#\3#\3$\3"+
		"$\3$\3%\3%\3%\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3(\3(\5(\u00d5\n(\3(\3"+
		"(\3(\7(\u00da\n(\f(\16(\u00dd\13(\3)\6)\u00e0\n)\r)\16)\u00e1\3*\3*\3"+
		"*\3*\3+\3+\3+\3+\5+\u00ec\n+\3+\3+\3,\3,\3,\3,\3-\3-\2\2.\3\3\5\4\7\5"+
		"\t\6\13\7\r\b\17\t\21\2\23\2\25\n\27\13\31\f\33\r\35\16\37\17!\20#\21"+
		"%\22\'\23)\24+\25-\26/\27\61\30\63\31\65\32\67\339\34;\35=\36?\37A C!"+
		"E\"G#I$K%M&O\'Q(S)U*W+Y,\3\2\5\4\2C\\c|\3\2\62;\4\2\13\f\"\"\2\u00f9\2"+
		"\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2"+
		"\2\2\17\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2"+
		"\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2"+
		"\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2"+
		"\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2"+
		"\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M"+
		"\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2"+
		"\2\2\3[\3\2\2\2\5]\3\2\2\2\7_\3\2\2\2\ta\3\2\2\2\13c\3\2\2\2\re\3\2\2"+
		"\2\17h\3\2\2\2\21k\3\2\2\2\23m\3\2\2\2\25o\3\2\2\2\27q\3\2\2\2\31s\3\2"+
		"\2\2\33u\3\2\2\2\35w\3\2\2\2\37y\3\2\2\2!{\3\2\2\2#}\3\2\2\2%\177\3\2"+
		"\2\2\'\u0083\3\2\2\2)\u008a\3\2\2\2+\u008f\3\2\2\2-\u0094\3\2\2\2/\u0096"+
		"\3\2\2\2\61\u0099\3\2\2\2\63\u009f\3\2\2\2\65\u00a3\3\2\2\2\67\u00a6\3"+
		"\2\2\29\u00ae\3\2\2\2;\u00b3\3\2\2\2=\u00b5\3\2\2\2?\u00b7\3\2\2\2A\u00ba"+
		"\3\2\2\2C\u00bd\3\2\2\2E\u00c0\3\2\2\2G\u00c3\3\2\2\2I\u00c6\3\2\2\2K"+
		"\u00c9\3\2\2\2M\u00cb\3\2\2\2O\u00d4\3\2\2\2Q\u00df\3\2\2\2S\u00e3\3\2"+
		"\2\2U\u00e7\3\2\2\2W\u00ef\3\2\2\2Y\u00f3\3\2\2\2[\\\7-\2\2\\\4\3\2\2"+
		"\2]^\7/\2\2^\6\3\2\2\2_`\7,\2\2`\b\3\2\2\2ab\7\61\2\2b\n\3\2\2\2cd\7\'"+
		"\2\2d\f\3\2\2\2ef\7-\2\2fg\7-\2\2g\16\3\2\2\2hi\7/\2\2ij\7/\2\2j\20\3"+
		"\2\2\2kl\t\2\2\2l\22\3\2\2\2mn\t\3\2\2n\24\3\2\2\2op\7*\2\2p\26\3\2\2"+
		"\2qr\7+\2\2r\30\3\2\2\2st\7]\2\2t\32\3\2\2\2uv\7_\2\2v\34\3\2\2\2wx\7"+
		"}\2\2x\36\3\2\2\2yz\7\177\2\2z \3\2\2\2{|\7=\2\2|\"\3\2\2\2}~\7.\2\2~"+
		"$\3\2\2\2\177\u0080\7k\2\2\u0080\u0081\7p\2\2\u0081\u0082\7v\2\2\u0082"+
		"&\3\2\2\2\u0083\u0084\7f\2\2\u0084\u0085\7q\2\2\u0085\u0086\7w\2\2\u0086"+
		"\u0087\7d\2\2\u0087\u0088\7n\2\2\u0088\u0089\7g\2\2\u0089(\3\2\2\2\u008a"+
		"\u008b\7e\2\2\u008b\u008c\7j\2\2\u008c\u008d\7c\2\2\u008d\u008e\7t\2\2"+
		"\u008e*\3\2\2\2\u008f\u0090\7x\2\2\u0090\u0091\7q\2\2\u0091\u0092\7k\2"+
		"\2\u0092\u0093\7f\2\2\u0093,\3\2\2\2\u0094\u0095\7?\2\2\u0095.\3\2\2\2"+
		"\u0096\u0097\7f\2\2\u0097\u0098\7q\2\2\u0098\60\3\2\2\2\u0099\u009a\7"+
		"y\2\2\u009a\u009b\7j\2\2\u009b\u009c\7k\2\2\u009c\u009d\7n\2\2\u009d\u009e"+
		"\7g\2\2\u009e\62\3\2\2\2\u009f\u00a0\7h\2\2\u00a0\u00a1\7q\2\2\u00a1\u00a2"+
		"\7t\2\2\u00a2\64\3\2\2\2\u00a3\u00a4\7k\2\2\u00a4\u00a5\7h\2\2\u00a5\66"+
		"\3\2\2\2\u00a6\u00a7\7g\2\2\u00a7\u00a8\7n\2\2\u00a8\u00a9\7u\2\2\u00a9"+
		"\u00aa\7g\2\2\u00aa\u00ab\7\"\2\2\u00ab\u00ac\7k\2\2\u00ac\u00ad\7h\2"+
		"\2\u00ad8\3\2\2\2\u00ae\u00af\7g\2\2\u00af\u00b0\7n\2\2\u00b0\u00b1\7"+
		"u\2\2\u00b1\u00b2\7g\2\2\u00b2:\3\2\2\2\u00b3\u00b4\7>\2\2\u00b4<\3\2"+
		"\2\2\u00b5\u00b6\7@\2\2\u00b6>\3\2\2\2\u00b7\u00b8\7>\2\2\u00b8\u00b9"+
		"\7?\2\2\u00b9@\3\2\2\2\u00ba\u00bb\7@\2\2\u00bb\u00bc\7?\2\2\u00bcB\3"+
		"\2\2\2\u00bd\u00be\7?\2\2\u00be\u00bf\7?\2\2\u00bfD\3\2\2\2\u00c0\u00c1"+
		"\7(\2\2\u00c1\u00c2\7(\2\2\u00c2F\3\2\2\2\u00c3\u00c4\7~\2\2\u00c4\u00c5"+
		"\7~\2\2\u00c5H\3\2\2\2\u00c6\u00c7\7#\2\2\u00c7\u00c8\7?\2\2\u00c8J\3"+
		"\2\2\2\u00c9\u00ca\7#\2\2\u00caL\3\2\2\2\u00cb\u00cc\7t\2\2\u00cc\u00cd"+
		"\7g\2\2\u00cd\u00ce\7v\2\2\u00ce\u00cf\7w\2\2\u00cf\u00d0\7t\2\2\u00d0"+
		"\u00d1\7p\2\2\u00d1N\3\2\2\2\u00d2\u00d5\5\21\t\2\u00d3\u00d5\7a\2\2\u00d4"+
		"\u00d2\3\2\2\2\u00d4\u00d3\3\2\2\2\u00d5\u00db\3\2\2\2\u00d6\u00da\5\21"+
		"\t\2\u00d7\u00da\5\23\n\2\u00d8\u00da\7a\2\2\u00d9\u00d6\3\2\2\2\u00d9"+
		"\u00d7\3\2\2\2\u00d9\u00d8\3\2\2\2\u00da\u00dd\3\2\2\2\u00db\u00d9\3\2"+
		"\2\2\u00db\u00dc\3\2\2\2\u00dcP\3\2\2\2\u00dd\u00db\3\2\2\2\u00de\u00e0"+
		"\5\23\n\2\u00df\u00de\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00df\3\2\2\2"+
		"\u00e1\u00e2\3\2\2\2\u00e2R\3\2\2\2\u00e3\u00e4\5Q)\2\u00e4\u00e5\7\60"+
		"\2\2\u00e5\u00e6\5Q)\2\u00e6T\3\2\2\2\u00e7\u00eb\7)\2\2\u00e8\u00ec\5"+
		"\21\t\2\u00e9\u00ec\5\23\n\2\u00ea\u00ec\5Y-\2\u00eb\u00e8\3\2\2\2\u00eb"+
		"\u00e9\3\2\2\2\u00eb\u00ea\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed\u00ee\7)"+
		"\2\2\u00eeV\3\2\2\2\u00ef\u00f0\t\4\2\2\u00f0\u00f1\3\2\2\2\u00f1\u00f2"+
		"\b,\2\2\u00f2X\3\2\2\2\u00f3\u00f4\13\2\2\2\u00f4Z\3\2\2\2\b\2\u00d4\u00d9"+
		"\u00db\u00e1\u00eb\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}