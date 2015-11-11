// Generated from logic.g4 by ANTLR 4.5.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class logicParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ATOM=1, OP=2, NEG=3, OPEN=4, CLOSE=5, WS=6;
	public static final int
		RULE_expr = 0, RULE_s = 1;
	public static final String[] ruleNames = {
		"expr", "s"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, "'!'", "'('", "')'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "ATOM", "OP", "NEG", "OPEN", "CLOSE", "WS"
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
	public String getGrammarFileName() { return "logic.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public logicParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ExprContext extends ParserRuleContext {
		public TerminalNode ATOM() { return getToken(logicParser.ATOM, 0); }
		public TerminalNode OPEN() { return getToken(logicParser.OPEN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OP() { return getToken(logicParser.OP, 0); }
		public TerminalNode CLOSE() { return getToken(logicParser.CLOSE, 0); }
		public TerminalNode NEG() { return getToken(logicParser.NEG, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof logicListener ) ((logicListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof logicListener ) ((logicListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof logicVisitor ) return ((logicVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_expr);
		try {
			setState(13);
			switch (_input.LA(1)) {
			case ATOM:
				enterOuterAlt(_localctx, 1);
				{
				setState(4);
				match(ATOM);
				}
				break;
			case OPEN:
				enterOuterAlt(_localctx, 2);
				{
				setState(5);
				match(OPEN);
				setState(6);
				expr();
				setState(7);
				match(OP);
				setState(8);
				expr();
				setState(9);
				match(CLOSE);
				}
				break;
			case NEG:
				enterOuterAlt(_localctx, 3);
				{
				setState(11);
				match(NEG);
				setState(12);
				expr();
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

	public static class SContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode EOF() { return getToken(logicParser.EOF, 0); }
		public SContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_s; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof logicListener ) ((logicListener)listener).enterS(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof logicListener ) ((logicListener)listener).exitS(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof logicVisitor ) return ((logicVisitor<? extends T>)visitor).visitS(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SContext s() throws RecognitionException {
		SContext _localctx = new SContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_s);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(15);
			expr();
			setState(16);
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

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\b\25\4\2\t\2\4\3"+
		"\t\3\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2\20\n\2\3\3\3\3\3\3\3\3\2"+
		"\2\4\2\4\2\2\24\2\17\3\2\2\2\4\21\3\2\2\2\6\20\7\3\2\2\7\b\7\6\2\2\b\t"+
		"\5\2\2\2\t\n\7\4\2\2\n\13\5\2\2\2\13\f\7\7\2\2\f\20\3\2\2\2\r\16\7\5\2"+
		"\2\16\20\5\2\2\2\17\6\3\2\2\2\17\7\3\2\2\2\17\r\3\2\2\2\20\3\3\2\2\2\21"+
		"\22\5\2\2\2\22\23\7\2\2\3\23\5\3\2\2\2\3\17";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}