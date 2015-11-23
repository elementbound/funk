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
		T__9=10, WS=11, NUMBER=12, STRING=13, BOOLEAN=14, ID=15, BINOP=16, COMMENT=17;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "WS", "NUMBER", "STRING", "BOOLEAN", "ID", "BINOP", "COMMENT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'.'", "'('", "')'", "'='", "','", "';'", "'if'", "'else'", "'{'", 
		"'}'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, "WS", 
		"NUMBER", "STRING", "BOOLEAN", "ID", "BINOP", "COMMENT"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\23~\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3"+
		"\t\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\f\3\r\5\rC\n\r\3\r\6\rF\n\r"+
		"\r\r\16\rG\3\16\3\16\7\16L\n\16\f\16\16\16O\13\16\3\16\3\16\3\16\7\16"+
		"T\n\16\f\16\16\16W\13\16\3\16\5\16Z\n\16\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\5\17e\n\17\3\20\3\20\7\20i\n\20\f\20\16\20l\13\20\3\21"+
		"\3\21\3\21\5\21q\n\21\3\22\3\22\3\22\3\22\7\22w\n\22\f\22\16\22z\13\22"+
		"\3\22\3\22\3\22\3x\2\23\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f"+
		"\27\r\31\16\33\17\35\20\37\21!\22#\23\3\2\t\5\2\13\f\17\17\"\"\3\2\62"+
		";\3\2))\3\2$$\5\2C\\aac|\5\2\62;C\\c|\5\2,-//\61\61\u0086\2\3\3\2\2\2"+
		"\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2"+
		"\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2"+
		"\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\3%\3\2\2"+
		"\2\5\'\3\2\2\2\7)\3\2\2\2\t+\3\2\2\2\13-\3\2\2\2\r/\3\2\2\2\17\61\3\2"+
		"\2\2\21\64\3\2\2\2\239\3\2\2\2\25;\3\2\2\2\27=\3\2\2\2\31B\3\2\2\2\33"+
		"Y\3\2\2\2\35d\3\2\2\2\37f\3\2\2\2!p\3\2\2\2#r\3\2\2\2%&\7\60\2\2&\4\3"+
		"\2\2\2\'(\7*\2\2(\6\3\2\2\2)*\7+\2\2*\b\3\2\2\2+,\7?\2\2,\n\3\2\2\2-."+
		"\7.\2\2.\f\3\2\2\2/\60\7=\2\2\60\16\3\2\2\2\61\62\7k\2\2\62\63\7h\2\2"+
		"\63\20\3\2\2\2\64\65\7g\2\2\65\66\7n\2\2\66\67\7u\2\2\678\7g\2\28\22\3"+
		"\2\2\29:\7}\2\2:\24\3\2\2\2;<\7\177\2\2<\26\3\2\2\2=>\t\2\2\2>?\3\2\2"+
		"\2?@\b\f\2\2@\30\3\2\2\2AC\7/\2\2BA\3\2\2\2BC\3\2\2\2CE\3\2\2\2DF\t\3"+
		"\2\2ED\3\2\2\2FG\3\2\2\2GE\3\2\2\2GH\3\2\2\2H\32\3\2\2\2IM\7)\2\2JL\n"+
		"\4\2\2KJ\3\2\2\2LO\3\2\2\2MK\3\2\2\2MN\3\2\2\2NP\3\2\2\2OM\3\2\2\2PZ\7"+
		")\2\2QU\7$\2\2RT\n\5\2\2SR\3\2\2\2TW\3\2\2\2US\3\2\2\2UV\3\2\2\2VX\3\2"+
		"\2\2WU\3\2\2\2XZ\7$\2\2YI\3\2\2\2YQ\3\2\2\2Z\34\3\2\2\2[\\\7V\2\2\\]\7"+
		"t\2\2]^\7w\2\2^e\7g\2\2_`\7H\2\2`a\7c\2\2ab\7n\2\2bc\7u\2\2ce\7g\2\2d"+
		"[\3\2\2\2d_\3\2\2\2e\36\3\2\2\2fj\t\6\2\2gi\t\7\2\2hg\3\2\2\2il\3\2\2"+
		"\2jh\3\2\2\2jk\3\2\2\2k \3\2\2\2lj\3\2\2\2mq\t\b\2\2no\7?\2\2oq\7?\2\2"+
		"pm\3\2\2\2pn\3\2\2\2q\"\3\2\2\2rs\7\61\2\2st\7,\2\2tx\3\2\2\2uw\13\2\2"+
		"\2vu\3\2\2\2wz\3\2\2\2xy\3\2\2\2xv\3\2\2\2y{\3\2\2\2zx\3\2\2\2{|\7,\2"+
		"\2|}\7\61\2\2}$\3\2\2\2\f\2BGMUYdjpx\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}