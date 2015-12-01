// Generated from smath.g4 by ANTLR 4.5.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class smathLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, NUMBER=4, ID=5, OP=6, WS=7;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "NUMBER", "ID", "OP", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'='", "'('", "')'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, "NUMBER", "ID", "OP", "WS"
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


	public smathLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "smath.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\t\61\b\1\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3\2\3\3\3\3\3\4\3"+
		"\4\3\5\6\5\31\n\5\r\5\16\5\32\3\5\3\5\6\5\37\n\5\r\5\16\5 \5\5#\n\5\3"+
		"\6\3\6\7\6\'\n\6\f\6\16\6*\13\6\3\7\3\7\3\b\3\b\3\b\3\b\2\2\t\3\3\5\4"+
		"\7\5\t\6\13\7\r\b\17\t\3\2\7\3\2\62;\6\2&&C\\aac|\7\2&&\62;C\\aac|\5\2"+
		",-//\61\61\5\2\13\f\17\17\"\"\64\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2"+
		"\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\3\21\3\2\2\2\5\23\3\2"+
		"\2\2\7\25\3\2\2\2\t\30\3\2\2\2\13$\3\2\2\2\r+\3\2\2\2\17-\3\2\2\2\21\22"+
		"\7?\2\2\22\4\3\2\2\2\23\24\7*\2\2\24\6\3\2\2\2\25\26\7+\2\2\26\b\3\2\2"+
		"\2\27\31\t\2\2\2\30\27\3\2\2\2\31\32\3\2\2\2\32\30\3\2\2\2\32\33\3\2\2"+
		"\2\33\"\3\2\2\2\34\36\7\60\2\2\35\37\t\2\2\2\36\35\3\2\2\2\37 \3\2\2\2"+
		" \36\3\2\2\2 !\3\2\2\2!#\3\2\2\2\"\34\3\2\2\2\"#\3\2\2\2#\n\3\2\2\2$("+
		"\t\3\2\2%\'\t\4\2\2&%\3\2\2\2\'*\3\2\2\2(&\3\2\2\2()\3\2\2\2)\f\3\2\2"+
		"\2*(\3\2\2\2+,\t\5\2\2,\16\3\2\2\2-.\t\6\2\2./\3\2\2\2/\60\b\b\2\2\60"+
		"\20\3\2\2\2\7\2\32 \"(\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}