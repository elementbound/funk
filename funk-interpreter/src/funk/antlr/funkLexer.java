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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, WS=7, NUMBER=8, STRING=9, 
		BOOLEAN=10, ID=11, BINOP=12, COMMENT=13;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "WS", "NUMBER", "STRING", 
		"BOOLEAN", "ID", "BINOP", "COMMENT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'.'", "'('", "')'", "'='", "','", "';'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, "WS", "NUMBER", "STRING", "BOOLEAN", 
		"ID", "BINOP", "COMMENT"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\17d\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6"+
		"\3\7\3\7\3\b\3\b\3\b\3\b\3\t\6\t/\n\t\r\t\16\t\60\3\n\3\n\7\n\65\n\n\f"+
		"\n\16\n8\13\n\3\n\3\n\3\n\7\n=\n\n\f\n\16\n@\13\n\3\n\5\nC\n\n\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13N\n\13\3\f\3\f\7\fR\n\f\f\f"+
		"\16\fU\13\f\3\r\3\r\3\16\3\16\3\16\3\16\7\16]\n\16\f\16\16\16`\13\16\3"+
		"\16\3\16\3\16\3^\2\17\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27"+
		"\r\31\16\33\17\3\2\t\5\2\13\f\17\17\"\"\3\2\62;\3\2))\3\2$$\5\2C\\aac"+
		"|\5\2\62;C\\c|\5\2,-//\61\61j\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t"+
		"\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2"+
		"\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\3\35\3\2\2\2\5"+
		"\37\3\2\2\2\7!\3\2\2\2\t#\3\2\2\2\13%\3\2\2\2\r\'\3\2\2\2\17)\3\2\2\2"+
		"\21.\3\2\2\2\23B\3\2\2\2\25M\3\2\2\2\27O\3\2\2\2\31V\3\2\2\2\33X\3\2\2"+
		"\2\35\36\7\60\2\2\36\4\3\2\2\2\37 \7*\2\2 \6\3\2\2\2!\"\7+\2\2\"\b\3\2"+
		"\2\2#$\7?\2\2$\n\3\2\2\2%&\7.\2\2&\f\3\2\2\2\'(\7=\2\2(\16\3\2\2\2)*\t"+
		"\2\2\2*+\3\2\2\2+,\b\b\2\2,\20\3\2\2\2-/\t\3\2\2.-\3\2\2\2/\60\3\2\2\2"+
		"\60.\3\2\2\2\60\61\3\2\2\2\61\22\3\2\2\2\62\66\7)\2\2\63\65\n\4\2\2\64"+
		"\63\3\2\2\2\658\3\2\2\2\66\64\3\2\2\2\66\67\3\2\2\2\679\3\2\2\28\66\3"+
		"\2\2\29C\7)\2\2:>\7$\2\2;=\n\5\2\2<;\3\2\2\2=@\3\2\2\2><\3\2\2\2>?\3\2"+
		"\2\2?A\3\2\2\2@>\3\2\2\2AC\7$\2\2B\62\3\2\2\2B:\3\2\2\2C\24\3\2\2\2DE"+
		"\7V\2\2EF\7t\2\2FG\7w\2\2GN\7g\2\2HI\7H\2\2IJ\7c\2\2JK\7n\2\2KL\7u\2\2"+
		"LN\7g\2\2MD\3\2\2\2MH\3\2\2\2N\26\3\2\2\2OS\t\6\2\2PR\t\7\2\2QP\3\2\2"+
		"\2RU\3\2\2\2SQ\3\2\2\2ST\3\2\2\2T\30\3\2\2\2US\3\2\2\2VW\t\b\2\2W\32\3"+
		"\2\2\2XY\7\61\2\2YZ\7,\2\2Z^\3\2\2\2[]\13\2\2\2\\[\3\2\2\2]`\3\2\2\2^"+
		"_\3\2\2\2^\\\3\2\2\2_a\3\2\2\2`^\3\2\2\2ab\7,\2\2bc\7\61\2\2c\34\3\2\2"+
		"\2\n\2\60\66>BMS^\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}