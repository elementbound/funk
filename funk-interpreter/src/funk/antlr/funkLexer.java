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
		T__9=10, T__10=11, WS=12, NUMBER=13, STRING=14, BOOLEAN=15, ID=16, BINOP=17, 
		COMMENT=18;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "WS", "NUMBER", "STRING", "BOOLEAN", "ID", "BINOP", "COMMENT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'.'", "'('", "')'", "'='", "','", "';'", "'if'", "'else'", "'for'", 
		"'{'", "'}'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		"WS", "NUMBER", "STRING", "BOOLEAN", "ID", "BINOP", "COMMENT"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\24\u0087\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3"+
		"\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3"+
		"\r\3\r\3\16\5\16I\n\16\3\16\6\16L\n\16\r\16\16\16M\3\17\3\17\7\17R\n\17"+
		"\f\17\16\17U\13\17\3\17\3\17\3\17\7\17Z\n\17\f\17\16\17]\13\17\3\17\5"+
		"\17`\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20k\n\20\3\21"+
		"\3\21\7\21o\n\21\f\21\16\21r\13\21\3\22\3\22\3\22\3\22\3\22\3\22\5\22"+
		"z\n\22\3\23\3\23\3\23\3\23\7\23\u0080\n\23\f\23\16\23\u0083\13\23\3\23"+
		"\3\23\3\23\3\u0081\2\24\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f"+
		"\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\3\2\n\5\2\13\f\17\17\"\"\3\2"+
		"\62;\3\2))\3\2$$\5\2C\\aac|\5\2\62;C\\c|\5\2,-//\61\61\4\2>>@@\u0091\2"+
		"\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2"+
		"\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2"+
		"\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2"+
		"\2\2%\3\2\2\2\3\'\3\2\2\2\5)\3\2\2\2\7+\3\2\2\2\t-\3\2\2\2\13/\3\2\2\2"+
		"\r\61\3\2\2\2\17\63\3\2\2\2\21\66\3\2\2\2\23;\3\2\2\2\25?\3\2\2\2\27A"+
		"\3\2\2\2\31C\3\2\2\2\33H\3\2\2\2\35_\3\2\2\2\37j\3\2\2\2!l\3\2\2\2#y\3"+
		"\2\2\2%{\3\2\2\2\'(\7\60\2\2(\4\3\2\2\2)*\7*\2\2*\6\3\2\2\2+,\7+\2\2,"+
		"\b\3\2\2\2-.\7?\2\2.\n\3\2\2\2/\60\7.\2\2\60\f\3\2\2\2\61\62\7=\2\2\62"+
		"\16\3\2\2\2\63\64\7k\2\2\64\65\7h\2\2\65\20\3\2\2\2\66\67\7g\2\2\678\7"+
		"n\2\289\7u\2\29:\7g\2\2:\22\3\2\2\2;<\7h\2\2<=\7q\2\2=>\7t\2\2>\24\3\2"+
		"\2\2?@\7}\2\2@\26\3\2\2\2AB\7\177\2\2B\30\3\2\2\2CD\t\2\2\2DE\3\2\2\2"+
		"EF\b\r\2\2F\32\3\2\2\2GI\7/\2\2HG\3\2\2\2HI\3\2\2\2IK\3\2\2\2JL\t\3\2"+
		"\2KJ\3\2\2\2LM\3\2\2\2MK\3\2\2\2MN\3\2\2\2N\34\3\2\2\2OS\7)\2\2PR\n\4"+
		"\2\2QP\3\2\2\2RU\3\2\2\2SQ\3\2\2\2ST\3\2\2\2TV\3\2\2\2US\3\2\2\2V`\7)"+
		"\2\2W[\7$\2\2XZ\n\5\2\2YX\3\2\2\2Z]\3\2\2\2[Y\3\2\2\2[\\\3\2\2\2\\^\3"+
		"\2\2\2][\3\2\2\2^`\7$\2\2_O\3\2\2\2_W\3\2\2\2`\36\3\2\2\2ab\7V\2\2bc\7"+
		"t\2\2cd\7w\2\2dk\7g\2\2ef\7H\2\2fg\7c\2\2gh\7n\2\2hi\7u\2\2ik\7g\2\2j"+
		"a\3\2\2\2je\3\2\2\2k \3\2\2\2lp\t\6\2\2mo\t\7\2\2nm\3\2\2\2or\3\2\2\2"+
		"pn\3\2\2\2pq\3\2\2\2q\"\3\2\2\2rp\3\2\2\2sz\t\b\2\2tu\7?\2\2uz\7?\2\2"+
		"vw\7#\2\2wz\7?\2\2xz\t\t\2\2ys\3\2\2\2yt\3\2\2\2yv\3\2\2\2yx\3\2\2\2z"+
		"$\3\2\2\2{|\7\61\2\2|}\7,\2\2}\u0081\3\2\2\2~\u0080\13\2\2\2\177~\3\2"+
		"\2\2\u0080\u0083\3\2\2\2\u0081\u0082\3\2\2\2\u0081\177\3\2\2\2\u0082\u0084"+
		"\3\2\2\2\u0083\u0081\3\2\2\2\u0084\u0085\7,\2\2\u0085\u0086\7\61\2\2\u0086"+
		"&\3\2\2\2\f\2HMS[_jpy\u0081\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}