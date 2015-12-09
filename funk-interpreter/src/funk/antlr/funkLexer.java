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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, WS=19, NUMBER=20, STRING=21, BOOLEAN=22, ID=23, OP=24, COMMENT=25, 
		LOCAL=26;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"T__17", "WS", "NUMBER", "STRING", "BOOLEAN", "ID", "OP", "COMMENT", "LOCAL"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "')'", "'!'", "'.'", "'='", "','", "';'", "'return'", "'if'", 
		"'else'", "'for'", "'{'", "'}'", "'aggregate'", "':'", "'|'", "'function'", 
		"'?'", null, null, null, null, null, null, null, "'$'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, "WS", "NUMBER", "STRING", "BOOLEAN", 
		"ID", "OP", "COMMENT", "LOCAL"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\34\u00b8\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7"+
		"\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3"+
		"\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3"+
		"\22\3\22\3\22\3\22\3\23\3\23\3\24\3\24\3\24\3\24\3\25\6\25{\n\25\r\25"+
		"\16\25|\3\26\3\26\7\26\u0081\n\26\f\26\16\26\u0084\13\26\3\26\3\26\3\26"+
		"\7\26\u0089\n\26\f\26\16\26\u008c\13\26\3\26\5\26\u008f\n\26\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u009a\n\27\3\30\3\30\7\30\u009e"+
		"\n\30\f\30\16\30\u00a1\13\30\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u00a9"+
		"\n\31\3\32\3\32\3\32\3\32\7\32\u00af\n\32\f\32\16\32\u00b2\13\32\3\32"+
		"\3\32\3\32\3\33\3\33\3\u00b0\2\34\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23"+
		"\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31"+
		"\61\32\63\33\65\34\3\2\n\5\2\13\f\17\17\"\"\3\2\62;\3\2))\3\2$$\5\2C\\"+
		"aac|\5\2\62;C\\c|\5\2,-//\61\61\4\2>>@@\u00c1\2\3\3\2\2\2\2\5\3\2\2\2"+
		"\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3"+
		"\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2"+
		"\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2"+
		"\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2"+
		"\2\2\2\65\3\2\2\2\3\67\3\2\2\2\59\3\2\2\2\7;\3\2\2\2\t=\3\2\2\2\13?\3"+
		"\2\2\2\rA\3\2\2\2\17C\3\2\2\2\21E\3\2\2\2\23L\3\2\2\2\25O\3\2\2\2\27T"+
		"\3\2\2\2\31X\3\2\2\2\33Z\3\2\2\2\35\\\3\2\2\2\37f\3\2\2\2!h\3\2\2\2#j"+
		"\3\2\2\2%s\3\2\2\2\'u\3\2\2\2)z\3\2\2\2+\u008e\3\2\2\2-\u0099\3\2\2\2"+
		"/\u009b\3\2\2\2\61\u00a8\3\2\2\2\63\u00aa\3\2\2\2\65\u00b6\3\2\2\2\67"+
		"8\7*\2\28\4\3\2\2\29:\7+\2\2:\6\3\2\2\2;<\7#\2\2<\b\3\2\2\2=>\7\60\2\2"+
		">\n\3\2\2\2?@\7?\2\2@\f\3\2\2\2AB\7.\2\2B\16\3\2\2\2CD\7=\2\2D\20\3\2"+
		"\2\2EF\7t\2\2FG\7g\2\2GH\7v\2\2HI\7w\2\2IJ\7t\2\2JK\7p\2\2K\22\3\2\2\2"+
		"LM\7k\2\2MN\7h\2\2N\24\3\2\2\2OP\7g\2\2PQ\7n\2\2QR\7u\2\2RS\7g\2\2S\26"+
		"\3\2\2\2TU\7h\2\2UV\7q\2\2VW\7t\2\2W\30\3\2\2\2XY\7}\2\2Y\32\3\2\2\2Z"+
		"[\7\177\2\2[\34\3\2\2\2\\]\7c\2\2]^\7i\2\2^_\7i\2\2_`\7t\2\2`a\7g\2\2"+
		"ab\7i\2\2bc\7c\2\2cd\7v\2\2de\7g\2\2e\36\3\2\2\2fg\7<\2\2g \3\2\2\2hi"+
		"\7~\2\2i\"\3\2\2\2jk\7h\2\2kl\7w\2\2lm\7p\2\2mn\7e\2\2no\7v\2\2op\7k\2"+
		"\2pq\7q\2\2qr\7p\2\2r$\3\2\2\2st\7A\2\2t&\3\2\2\2uv\t\2\2\2vw\3\2\2\2"+
		"wx\b\24\2\2x(\3\2\2\2y{\t\3\2\2zy\3\2\2\2{|\3\2\2\2|z\3\2\2\2|}\3\2\2"+
		"\2}*\3\2\2\2~\u0082\7)\2\2\177\u0081\n\4\2\2\u0080\177\3\2\2\2\u0081\u0084"+
		"\3\2\2\2\u0082\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0085\3\2\2\2\u0084"+
		"\u0082\3\2\2\2\u0085\u008f\7)\2\2\u0086\u008a\7$\2\2\u0087\u0089\n\5\2"+
		"\2\u0088\u0087\3\2\2\2\u0089\u008c\3\2\2\2\u008a\u0088\3\2\2\2\u008a\u008b"+
		"\3\2\2\2\u008b\u008d\3\2\2\2\u008c\u008a\3\2\2\2\u008d\u008f\7$\2\2\u008e"+
		"~\3\2\2\2\u008e\u0086\3\2\2\2\u008f,\3\2\2\2\u0090\u0091\7V\2\2\u0091"+
		"\u0092\7t\2\2\u0092\u0093\7w\2\2\u0093\u009a\7g\2\2\u0094\u0095\7H\2\2"+
		"\u0095\u0096\7c\2\2\u0096\u0097\7n\2\2\u0097\u0098\7u\2\2\u0098\u009a"+
		"\7g\2\2\u0099\u0090\3\2\2\2\u0099\u0094\3\2\2\2\u009a.\3\2\2\2\u009b\u009f"+
		"\t\6\2\2\u009c\u009e\t\7\2\2\u009d\u009c\3\2\2\2\u009e\u00a1\3\2\2\2\u009f"+
		"\u009d\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\60\3\2\2\2\u00a1\u009f\3\2\2"+
		"\2\u00a2\u00a9\t\b\2\2\u00a3\u00a4\7?\2\2\u00a4\u00a9\7?\2\2\u00a5\u00a6"+
		"\7#\2\2\u00a6\u00a9\7?\2\2\u00a7\u00a9\t\t\2\2\u00a8\u00a2\3\2\2\2\u00a8"+
		"\u00a3\3\2\2\2\u00a8\u00a5\3\2\2\2\u00a8\u00a7\3\2\2\2\u00a9\62\3\2\2"+
		"\2\u00aa\u00ab\7\61\2\2\u00ab\u00ac\7,\2\2\u00ac\u00b0\3\2\2\2\u00ad\u00af"+
		"\13\2\2\2\u00ae\u00ad\3\2\2\2\u00af\u00b2\3\2\2\2\u00b0\u00b1\3\2\2\2"+
		"\u00b0\u00ae\3\2\2\2\u00b1\u00b3\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b3\u00b4"+
		"\7,\2\2\u00b4\u00b5\7\61\2\2\u00b5\64\3\2\2\2\u00b6\u00b7\7&\2\2\u00b7"+
		"\66\3\2\2\2\13\2|\u0082\u008a\u008e\u0099\u009f\u00a8\u00b0\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}