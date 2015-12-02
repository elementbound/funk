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
		T__9=10, T__10=11, WS=12, NUMBER=13, STRING=14, BOOLEAN=15, ID=16, OP=17, 
		COMMENT=18;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "WS", "NUMBER", "STRING", "BOOLEAN", "ID", "OP", "COMMENT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "')'", "'.'", "'='", "','", "';'", "'if'", "'else'", "'for'", 
		"'{'", "'}'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		"WS", "NUMBER", "STRING", "BOOLEAN", "ID", "OP", "COMMENT"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\24\u0084\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3"+
		"\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3"+
		"\r\3\r\3\16\6\16I\n\16\r\16\16\16J\3\17\3\17\7\17O\n\17\f\17\16\17R\13"+
		"\17\3\17\3\17\3\17\7\17W\n\17\f\17\16\17Z\13\17\3\17\5\17]\n\17\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20h\n\20\3\21\3\21\7\21l\n\21"+
		"\f\21\16\21o\13\21\3\22\3\22\3\22\3\22\3\22\3\22\5\22w\n\22\3\23\3\23"+
		"\3\23\3\23\7\23}\n\23\f\23\16\23\u0080\13\23\3\23\3\23\3\23\3~\2\24\3"+
		"\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37"+
		"\21!\22#\23%\24\3\2\n\5\2\13\f\17\17\"\"\3\2\62;\3\2))\3\2$$\5\2C\\aa"+
		"c|\5\2\62;C\\c|\5\2,-//\61\61\4\2>>@@\u008d\2\3\3\2\2\2\2\5\3\2\2\2\2"+
		"\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2"+
		"\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2"+
		"\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\3\'\3\2\2"+
		"\2\5)\3\2\2\2\7+\3\2\2\2\t-\3\2\2\2\13/\3\2\2\2\r\61\3\2\2\2\17\63\3\2"+
		"\2\2\21\66\3\2\2\2\23;\3\2\2\2\25?\3\2\2\2\27A\3\2\2\2\31C\3\2\2\2\33"+
		"H\3\2\2\2\35\\\3\2\2\2\37g\3\2\2\2!i\3\2\2\2#v\3\2\2\2%x\3\2\2\2\'(\7"+
		"*\2\2(\4\3\2\2\2)*\7+\2\2*\6\3\2\2\2+,\7\60\2\2,\b\3\2\2\2-.\7?\2\2.\n"+
		"\3\2\2\2/\60\7.\2\2\60\f\3\2\2\2\61\62\7=\2\2\62\16\3\2\2\2\63\64\7k\2"+
		"\2\64\65\7h\2\2\65\20\3\2\2\2\66\67\7g\2\2\678\7n\2\289\7u\2\29:\7g\2"+
		"\2:\22\3\2\2\2;<\7h\2\2<=\7q\2\2=>\7t\2\2>\24\3\2\2\2?@\7}\2\2@\26\3\2"+
		"\2\2AB\7\177\2\2B\30\3\2\2\2CD\t\2\2\2DE\3\2\2\2EF\b\r\2\2F\32\3\2\2\2"+
		"GI\t\3\2\2HG\3\2\2\2IJ\3\2\2\2JH\3\2\2\2JK\3\2\2\2K\34\3\2\2\2LP\7)\2"+
		"\2MO\n\4\2\2NM\3\2\2\2OR\3\2\2\2PN\3\2\2\2PQ\3\2\2\2QS\3\2\2\2RP\3\2\2"+
		"\2S]\7)\2\2TX\7$\2\2UW\n\5\2\2VU\3\2\2\2WZ\3\2\2\2XV\3\2\2\2XY\3\2\2\2"+
		"Y[\3\2\2\2ZX\3\2\2\2[]\7$\2\2\\L\3\2\2\2\\T\3\2\2\2]\36\3\2\2\2^_\7V\2"+
		"\2_`\7t\2\2`a\7w\2\2ah\7g\2\2bc\7H\2\2cd\7c\2\2de\7n\2\2ef\7u\2\2fh\7"+
		"g\2\2g^\3\2\2\2gb\3\2\2\2h \3\2\2\2im\t\6\2\2jl\t\7\2\2kj\3\2\2\2lo\3"+
		"\2\2\2mk\3\2\2\2mn\3\2\2\2n\"\3\2\2\2om\3\2\2\2pw\t\b\2\2qr\7?\2\2rw\7"+
		"?\2\2st\7#\2\2tw\7?\2\2uw\t\t\2\2vp\3\2\2\2vq\3\2\2\2vs\3\2\2\2vu\3\2"+
		"\2\2w$\3\2\2\2xy\7\61\2\2yz\7,\2\2z~\3\2\2\2{}\13\2\2\2|{\3\2\2\2}\u0080"+
		"\3\2\2\2~\177\3\2\2\2~|\3\2\2\2\177\u0081\3\2\2\2\u0080~\3\2\2\2\u0081"+
		"\u0082\7,\2\2\u0082\u0083\7\61\2\2\u0083&\3\2\2\2\13\2JPX\\gmv~\3\b\2"+
		"\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}