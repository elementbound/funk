// Generated from funk.g4 by ANTLR 4.5.1
package funk.antlr;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class funkLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, WS=13, NUMBER=14, STRING=15, BOOLEAN=16, 
		ID=17, OP=18, COMMENT=19;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "WS", "NUMBER", "STRING", "BOOLEAN", "ID", "OP", 
		"COMMENT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "')'", "'!'", "'.'", "'='", "','", "';'", "'if'", "'else'", 
		"'for'", "'{'", "'}'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, "WS", "NUMBER", "STRING", "BOOLEAN", "ID", "OP", "COMMENT"
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


	public funkLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "funk.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\25\u0088\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7"+
		"\3\7\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3"+
		"\f\3\r\3\r\3\16\3\16\3\16\3\16\3\17\6\17M\n\17\r\17\16\17N\3\20\3\20\7"+
		"\20S\n\20\f\20\16\20V\13\20\3\20\3\20\3\20\7\20[\n\20\f\20\16\20^\13\20"+
		"\3\20\5\20a\n\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21l\n"+
		"\21\3\22\3\22\7\22p\n\22\f\22\16\22s\13\22\3\23\3\23\3\23\3\23\3\23\3"+
		"\23\5\23{\n\23\3\24\3\24\3\24\3\24\7\24\u0081\n\24\f\24\16\24\u0084\13"+
		"\24\3\24\3\24\3\24\3\u0082\2\25\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23"+
		"\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25\3\2\n\5\2\13\f"+
		"\17\17\"\"\3\2\62;\3\2))\3\2$$\5\2C\\aac|\5\2\62;C\\c|\5\2,-//\61\61\4"+
		"\2>>@@\u0091\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2"+
		"\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2"+
		"\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2"+
		"\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\3)\3\2\2\2\5+\3\2\2\2\7-\3\2\2"+
		"\2\t/\3\2\2\2\13\61\3\2\2\2\r\63\3\2\2\2\17\65\3\2\2\2\21\67\3\2\2\2\23"+
		":\3\2\2\2\25?\3\2\2\2\27C\3\2\2\2\31E\3\2\2\2\33G\3\2\2\2\35L\3\2\2\2"+
		"\37`\3\2\2\2!k\3\2\2\2#m\3\2\2\2%z\3\2\2\2\'|\3\2\2\2)*\7*\2\2*\4\3\2"+
		"\2\2+,\7+\2\2,\6\3\2\2\2-.\7#\2\2.\b\3\2\2\2/\60\7\60\2\2\60\n\3\2\2\2"+
		"\61\62\7?\2\2\62\f\3\2\2\2\63\64\7.\2\2\64\16\3\2\2\2\65\66\7=\2\2\66"+
		"\20\3\2\2\2\678\7k\2\289\7h\2\29\22\3\2\2\2:;\7g\2\2;<\7n\2\2<=\7u\2\2"+
		"=>\7g\2\2>\24\3\2\2\2?@\7h\2\2@A\7q\2\2AB\7t\2\2B\26\3\2\2\2CD\7}\2\2"+
		"D\30\3\2\2\2EF\7\177\2\2F\32\3\2\2\2GH\t\2\2\2HI\3\2\2\2IJ\b\16\2\2J\34"+
		"\3\2\2\2KM\t\3\2\2LK\3\2\2\2MN\3\2\2\2NL\3\2\2\2NO\3\2\2\2O\36\3\2\2\2"+
		"PT\7)\2\2QS\n\4\2\2RQ\3\2\2\2SV\3\2\2\2TR\3\2\2\2TU\3\2\2\2UW\3\2\2\2"+
		"VT\3\2\2\2Wa\7)\2\2X\\\7$\2\2Y[\n\5\2\2ZY\3\2\2\2[^\3\2\2\2\\Z\3\2\2\2"+
		"\\]\3\2\2\2]_\3\2\2\2^\\\3\2\2\2_a\7$\2\2`P\3\2\2\2`X\3\2\2\2a \3\2\2"+
		"\2bc\7V\2\2cd\7t\2\2de\7w\2\2el\7g\2\2fg\7H\2\2gh\7c\2\2hi\7n\2\2ij\7"+
		"u\2\2jl\7g\2\2kb\3\2\2\2kf\3\2\2\2l\"\3\2\2\2mq\t\6\2\2np\t\7\2\2on\3"+
		"\2\2\2ps\3\2\2\2qo\3\2\2\2qr\3\2\2\2r$\3\2\2\2sq\3\2\2\2t{\t\b\2\2uv\7"+
		"?\2\2v{\7?\2\2wx\7#\2\2x{\7?\2\2y{\t\t\2\2zt\3\2\2\2zu\3\2\2\2zw\3\2\2"+
		"\2zy\3\2\2\2{&\3\2\2\2|}\7\61\2\2}~\7,\2\2~\u0082\3\2\2\2\177\u0081\13"+
		"\2\2\2\u0080\177\3\2\2\2\u0081\u0084\3\2\2\2\u0082\u0083\3\2\2\2\u0082"+
		"\u0080\3\2\2\2\u0083\u0085\3\2\2\2\u0084\u0082\3\2\2\2\u0085\u0086\7,"+
		"\2\2\u0086\u0087\7\61\2\2\u0087(\3\2\2\2\13\2NT\\`kqz\u0082\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}