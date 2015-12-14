// Generated from funk.g4 by ANTLR 4.5.1
package funk.antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class funkParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, WS=21, NUMBER=22, CORPORAL=23, STRING=24, 
		BOOLEAN=25, ID=26, OP=27, COMMENT=28, LOCAL=29;
	public static final int
		RULE_expr = 0, RULE_args = 1, RULE_statement = 2, RULE_ifThenElse = 3, 
		RULE_forLoop = 4, RULE_block = 5, RULE_aggregateDecl = 6, RULE_argsProto = 7, 
		RULE_typesProto = 8, RULE_singleTypeFunctionDecl = 9, RULE_multipleTypeFunctionDecl = 10, 
		RULE_genericTypeFunctionDecl = 11;
	public static final String[] ruleNames = {
		"expr", "args", "statement", "ifThenElse", "forLoop", "block", "aggregateDecl", 
		"argsProto", "typesProto", "singleTypeFunctionDecl", "multipleTypeFunctionDecl", 
		"genericTypeFunctionDecl"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "')'", "'!'", "'.'", "'['", "']'", "'='", "','", "';'", "'return'", 
		"'if'", "'else'", "'for'", "'{'", "'}'", "'aggregate'", "':'", "'|'", 
		"'function'", "'?'", null, null, null, null, null, null, null, null, "'$'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, "WS", "NUMBER", 
		"CORPORAL", "STRING", "BOOLEAN", "ID", "OP", "COMMENT", "LOCAL"
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
	public String getGrammarFileName() { return "funk.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


		@Override
		public void notifyErrorListeners(Token offendingToken, String msg, RecognitionException ex)
		{
			if(ex != null)
				throw ex; 
			else 
				throw new RecognitionException(msg, null, _input, _ctx);
		}

	public funkParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class MemberCallContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode ID() { return getToken(funkParser.ID, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public MemberCallContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof funkListener ) ((funkListener)listener).enterMemberCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof funkListener ) ((funkListener)listener).exitMemberCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof funkVisitor ) return ((funkVisitor<? extends T>)visitor).visitMemberCall(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnaryOpContext extends ExprContext {
		public TerminalNode OP() { return getToken(funkParser.OP, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public UnaryOpContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof funkListener ) ((funkListener)listener).enterUnaryOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof funkListener ) ((funkListener)listener).exitUnaryOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof funkVisitor ) return ((funkVisitor<? extends T>)visitor).visitUnaryOp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BooleanLiteralContext extends ExprContext {
		public TerminalNode BOOLEAN() { return getToken(funkParser.BOOLEAN, 0); }
		public BooleanLiteralContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof funkListener ) ((funkListener)listener).enterBooleanLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof funkListener ) ((funkListener)listener).exitBooleanLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof funkVisitor ) return ((funkVisitor<? extends T>)visitor).visitBooleanLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConstructorContext extends ExprContext {
		public TerminalNode ID() { return getToken(funkParser.ID, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public ConstructorContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof funkListener ) ((funkListener)listener).enterConstructor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof funkListener ) ((funkListener)listener).exitConstructor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof funkVisitor ) return ((funkVisitor<? extends T>)visitor).visitConstructor(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IndexAccessContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public IndexAccessContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof funkListener ) ((funkListener)listener).enterIndexAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof funkListener ) ((funkListener)listener).exitIndexAccess(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof funkVisitor ) return ((funkVisitor<? extends T>)visitor).visitIndexAccess(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringLiteralContext extends ExprContext {
		public TerminalNode STRING() { return getToken(funkParser.STRING, 0); }
		public StringLiteralContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof funkListener ) ((funkListener)listener).enterStringLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof funkListener ) ((funkListener)listener).exitStringLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof funkVisitor ) return ((funkVisitor<? extends T>)visitor).visitStringLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MemberAccessContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode ID() { return getToken(funkParser.ID, 0); }
		public MemberAccessContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof funkListener ) ((funkListener)listener).enterMemberAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof funkListener ) ((funkListener)listener).exitMemberAccess(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof funkVisitor ) return ((funkVisitor<? extends T>)visitor).visitMemberAccess(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IndexAssignContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public IndexAssignContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof funkListener ) ((funkListener)listener).enterIndexAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof funkListener ) ((funkListener)listener).exitIndexAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof funkVisitor ) return ((funkVisitor<? extends T>)visitor).visitIndexAssign(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignContext extends ExprContext {
		public TerminalNode ID() { return getToken(funkParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode LOCAL() { return getToken(funkParser.LOCAL, 0); }
		public AssignContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof funkListener ) ((funkListener)listener).enterAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof funkListener ) ((funkListener)listener).exitAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof funkVisitor ) return ((funkVisitor<? extends T>)visitor).visitAssign(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MemberAssignContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode ID() { return getToken(funkParser.ID, 0); }
		public MemberAssignContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof funkListener ) ((funkListener)listener).enterMemberAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof funkListener ) ((funkListener)listener).exitMemberAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof funkVisitor ) return ((funkVisitor<? extends T>)visitor).visitMemberAssign(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CorporalLiteralContext extends ExprContext {
		public TerminalNode CORPORAL() { return getToken(funkParser.CORPORAL, 0); }
		public CorporalLiteralContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof funkListener ) ((funkListener)listener).enterCorporalLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof funkListener ) ((funkListener)listener).exitCorporalLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof funkVisitor ) return ((funkVisitor<? extends T>)visitor).visitCorporalLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IDContext extends ExprContext {
		public TerminalNode ID() { return getToken(funkParser.ID, 0); }
		public IDContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof funkListener ) ((funkListener)listener).enterID(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof funkListener ) ((funkListener)listener).exitID(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof funkVisitor ) return ((funkVisitor<? extends T>)visitor).visitID(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EnclosedExprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public EnclosedExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof funkListener ) ((funkListener)listener).enterEnclosedExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof funkListener ) ((funkListener)listener).exitEnclosedExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof funkVisitor ) return ((funkVisitor<? extends T>)visitor).visitEnclosedExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumberLiteralContext extends ExprContext {
		public TerminalNode NUMBER() { return getToken(funkParser.NUMBER, 0); }
		public NumberLiteralContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof funkListener ) ((funkListener)listener).enterNumberLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof funkListener ) ((funkListener)listener).exitNumberLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof funkVisitor ) return ((funkVisitor<? extends T>)visitor).visitNumberLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BinaryOpContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OP() { return getToken(funkParser.OP, 0); }
		public BinaryOpContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof funkListener ) ((funkListener)listener).enterBinaryOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof funkListener ) ((funkListener)listener).exitBinaryOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof funkVisitor ) return ((funkVisitor<? extends T>)visitor).visitBinaryOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 0;
		enterRecursionRule(_localctx, 0, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				_localctx = new UnaryOpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(25);
				match(OP);
				setState(26);
				expr(6);
				}
				break;
			case 2:
				{
				_localctx = new AssignContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(28);
				_la = _input.LA(1);
				if (_la==LOCAL) {
					{
					setState(27);
					match(LOCAL);
					}
				}

				setState(30);
				match(ID);
				setState(31);
				match(T__6);
				setState(32);
				expr(2);
				}
				break;
			case 3:
				{
				_localctx = new EnclosedExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(33);
				match(T__0);
				setState(34);
				expr(0);
				setState(35);
				match(T__1);
				}
				break;
			case 4:
				{
				_localctx = new BooleanLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(37);
				match(BOOLEAN);
				}
				break;
			case 5:
				{
				_localctx = new NumberLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(38);
				match(NUMBER);
				}
				break;
			case 6:
				{
				_localctx = new CorporalLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(39);
				match(CORPORAL);
				}
				break;
			case 7:
				{
				_localctx = new StringLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(40);
				match(STRING);
				}
				break;
			case 8:
				{
				_localctx = new ConstructorContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(41);
				match(T__2);
				setState(42);
				match(T__3);
				setState(43);
				match(ID);
				setState(44);
				match(T__0);
				setState(45);
				args();
				setState(46);
				match(T__1);
				}
				break;
			case 9:
				{
				_localctx = new IDContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(48);
				match(ID);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(84);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(82);
					switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryOpContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(51);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(52);
						match(OP);
						setState(53);
						expr(6);
						}
						break;
					case 2:
						{
						_localctx = new IndexAssignContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(54);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(55);
						match(T__4);
						setState(57);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << NUMBER) | (1L << CORPORAL) | (1L << STRING) | (1L << BOOLEAN) | (1L << ID) | (1L << OP) | (1L << LOCAL))) != 0)) {
							{
							setState(56);
							expr(0);
							}
						}

						setState(59);
						match(T__5);
						setState(60);
						match(T__6);
						setState(61);
						expr(5);
						}
						break;
					case 3:
						{
						_localctx = new MemberAssignContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(62);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(63);
						match(T__3);
						setState(64);
						match(ID);
						setState(65);
						match(T__6);
						setState(66);
						expr(4);
						}
						break;
					case 4:
						{
						_localctx = new MemberCallContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(67);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(68);
						match(T__3);
						setState(69);
						match(ID);
						setState(70);
						match(T__0);
						setState(71);
						args();
						setState(72);
						match(T__1);
						}
						break;
					case 5:
						{
						_localctx = new MemberAccessContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(74);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(75);
						match(T__3);
						setState(76);
						match(ID);
						}
						break;
					case 6:
						{
						_localctx = new IndexAccessContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(77);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(78);
						match(T__4);
						setState(79);
						expr(0);
						setState(80);
						match(T__5);
						}
						break;
					}
					} 
				}
				setState(86);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
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

	public static class ArgsContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof funkListener ) ((funkListener)listener).enterArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof funkListener ) ((funkListener)listener).exitArgs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof funkVisitor ) return ((funkVisitor<? extends T>)visitor).visitArgs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_args);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << NUMBER) | (1L << CORPORAL) | (1L << STRING) | (1L << BOOLEAN) | (1L << ID) | (1L << OP) | (1L << LOCAL))) != 0)) {
				{
				setState(92);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(87);
						expr(0);
						setState(88);
						match(T__7);
						}
						} 
					}
					setState(94);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
				}
				setState(95);
				expr(0);
				}
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

	public static class StatementContext extends ParserRuleContext {
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IfStatementContext extends StatementContext {
		public IfThenElseContext ifThenElse() {
			return getRuleContext(IfThenElseContext.class,0);
		}
		public IfStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof funkListener ) ((funkListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof funkListener ) ((funkListener)listener).exitIfStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof funkVisitor ) return ((funkVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CommentContext extends StatementContext {
		public TerminalNode COMMENT() { return getToken(funkParser.COMMENT, 0); }
		public CommentContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof funkListener ) ((funkListener)listener).enterComment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof funkListener ) ((funkListener)listener).exitComment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof funkVisitor ) return ((funkVisitor<? extends T>)visitor).visitComment(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AggregateDeclarationContext extends StatementContext {
		public AggregateDeclContext aggregateDecl() {
			return getRuleContext(AggregateDeclContext.class,0);
		}
		public AggregateDeclarationContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof funkListener ) ((funkListener)listener).enterAggregateDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof funkListener ) ((funkListener)listener).exitAggregateDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof funkVisitor ) return ((funkVisitor<? extends T>)visitor).visitAggregateDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MultiFuncDeclContext extends StatementContext {
		public MultipleTypeFunctionDeclContext multipleTypeFunctionDecl() {
			return getRuleContext(MultipleTypeFunctionDeclContext.class,0);
		}
		public MultiFuncDeclContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof funkListener ) ((funkListener)listener).enterMultiFuncDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof funkListener ) ((funkListener)listener).exitMultiFuncDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof funkVisitor ) return ((funkVisitor<? extends T>)visitor).visitMultiFuncDecl(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SingleStatementContext extends StatementContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public SingleStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof funkListener ) ((funkListener)listener).enterSingleStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof funkListener ) ((funkListener)listener).exitSingleStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof funkVisitor ) return ((funkVisitor<? extends T>)visitor).visitSingleStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ReturnStatementContext extends StatementContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ReturnStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof funkListener ) ((funkListener)listener).enterReturnStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof funkListener ) ((funkListener)listener).exitReturnStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof funkVisitor ) return ((funkVisitor<? extends T>)visitor).visitReturnStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SingleFuncDeclContext extends StatementContext {
		public SingleTypeFunctionDeclContext singleTypeFunctionDecl() {
			return getRuleContext(SingleTypeFunctionDeclContext.class,0);
		}
		public SingleFuncDeclContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof funkListener ) ((funkListener)listener).enterSingleFuncDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof funkListener ) ((funkListener)listener).exitSingleFuncDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof funkVisitor ) return ((funkVisitor<? extends T>)visitor).visitSingleFuncDecl(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BlockStatementContext extends StatementContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public BlockStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof funkListener ) ((funkListener)listener).enterBlockStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof funkListener ) ((funkListener)listener).exitBlockStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof funkVisitor ) return ((funkVisitor<? extends T>)visitor).visitBlockStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ForStatementContext extends StatementContext {
		public ForLoopContext forLoop() {
			return getRuleContext(ForLoopContext.class,0);
		}
		public ForStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof funkListener ) ((funkListener)listener).enterForStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof funkListener ) ((funkListener)listener).exitForStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof funkVisitor ) return ((funkVisitor<? extends T>)visitor).visitForStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GenFuncDeclContext extends StatementContext {
		public GenericTypeFunctionDeclContext genericTypeFunctionDecl() {
			return getRuleContext(GenericTypeFunctionDeclContext.class,0);
		}
		public GenFuncDeclContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof funkListener ) ((funkListener)listener).enterGenFuncDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof funkListener ) ((funkListener)listener).exitGenFuncDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof funkVisitor ) return ((funkVisitor<? extends T>)visitor).visitGenFuncDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statement);
		try {
			setState(113);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				_localctx = new SingleStatementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(98);
				expr(0);
				setState(99);
				match(T__8);
				}
				break;
			case 2:
				_localctx = new ReturnStatementContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(101);
				match(T__9);
				setState(102);
				expr(0);
				setState(103);
				match(T__8);
				}
				break;
			case 3:
				_localctx = new IfStatementContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(105);
				ifThenElse();
				}
				break;
			case 4:
				_localctx = new ForStatementContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(106);
				forLoop();
				}
				break;
			case 5:
				_localctx = new BlockStatementContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(107);
				block();
				}
				break;
			case 6:
				_localctx = new AggregateDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(108);
				aggregateDecl();
				}
				break;
			case 7:
				_localctx = new SingleFuncDeclContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(109);
				singleTypeFunctionDecl();
				}
				break;
			case 8:
				_localctx = new MultiFuncDeclContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(110);
				multipleTypeFunctionDecl();
				}
				break;
			case 9:
				_localctx = new GenFuncDeclContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(111);
				genericTypeFunctionDecl();
				}
				break;
			case 10:
				_localctx = new CommentContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(112);
				match(COMMENT);
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

	public static class IfThenElseContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public IfThenElseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifThenElse; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof funkListener ) ((funkListener)listener).enterIfThenElse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof funkListener ) ((funkListener)listener).exitIfThenElse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof funkVisitor ) return ((funkVisitor<? extends T>)visitor).visitIfThenElse(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfThenElseContext ifThenElse() throws RecognitionException {
		IfThenElseContext _localctx = new IfThenElseContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_ifThenElse);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			match(T__10);
			setState(116);
			match(T__0);
			setState(117);
			expr(0);
			setState(118);
			match(T__1);
			setState(119);
			statement();
			setState(122);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(120);
				match(T__11);
				setState(121);
				statement();
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

	public static class ForLoopContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ForLoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forLoop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof funkListener ) ((funkListener)listener).enterForLoop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof funkListener ) ((funkListener)listener).exitForLoop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof funkVisitor ) return ((funkVisitor<? extends T>)visitor).visitForLoop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForLoopContext forLoop() throws RecognitionException {
		ForLoopContext _localctx = new ForLoopContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_forLoop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			match(T__12);
			setState(125);
			match(T__0);
			setState(126);
			expr(0);
			setState(127);
			match(T__8);
			setState(128);
			expr(0);
			setState(129);
			match(T__8);
			setState(130);
			expr(0);
			setState(131);
			match(T__1);
			setState(132);
			statement();
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

	public static class BlockContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof funkListener ) ((funkListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof funkListener ) ((funkListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof funkVisitor ) return ((funkVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			match(T__13);
			setState(136); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(135);
				statement();
				}
				}
				setState(138); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__9) | (1L << T__10) | (1L << T__12) | (1L << T__13) | (1L << T__15) | (1L << T__18) | (1L << NUMBER) | (1L << CORPORAL) | (1L << STRING) | (1L << BOOLEAN) | (1L << ID) | (1L << OP) | (1L << COMMENT) | (1L << LOCAL))) != 0) );
			setState(140);
			match(T__14);
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

	public static class AggregateDeclContext extends ParserRuleContext {
		public Token baseType;
		public List<TerminalNode> ID() { return getTokens(funkParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(funkParser.ID, i);
		}
		public AggregateDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aggregateDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof funkListener ) ((funkListener)listener).enterAggregateDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof funkListener ) ((funkListener)listener).exitAggregateDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof funkVisitor ) return ((funkVisitor<? extends T>)visitor).visitAggregateDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AggregateDeclContext aggregateDecl() throws RecognitionException {
		AggregateDeclContext _localctx = new AggregateDeclContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_aggregateDecl);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			match(T__15);
			setState(143);
			match(ID);
			setState(146);
			_la = _input.LA(1);
			if (_la==T__16) {
				{
				setState(144);
				match(T__16);
				setState(145);
				((AggregateDeclContext)_localctx).baseType = match(ID);
				}
			}

			setState(148);
			match(T__13);
			{
			setState(153);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(149);
					match(ID);
					setState(150);
					match(T__7);
					}
					} 
				}
				setState(155);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
			setState(156);
			match(ID);
			}
			setState(158);
			match(T__14);
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

	public static class ArgsProtoContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(funkParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(funkParser.ID, i);
		}
		public ArgsProtoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argsProto; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof funkListener ) ((funkListener)listener).enterArgsProto(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof funkListener ) ((funkListener)listener).exitArgsProto(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof funkVisitor ) return ((funkVisitor<? extends T>)visitor).visitArgsProto(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgsProtoContext argsProto() throws RecognitionException {
		ArgsProtoContext _localctx = new ArgsProtoContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_argsProto);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(164);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(160);
						match(ID);
						setState(161);
						match(T__7);
						}
						} 
					}
					setState(166);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
				}
				setState(167);
				match(ID);
				}
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

	public static class TypesProtoContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(funkParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(funkParser.ID, i);
		}
		public TypesProtoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typesProto; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof funkListener ) ((funkListener)listener).enterTypesProto(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof funkListener ) ((funkListener)listener).exitTypesProto(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof funkVisitor ) return ((funkVisitor<? extends T>)visitor).visitTypesProto(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypesProtoContext typesProto() throws RecognitionException {
		TypesProtoContext _localctx = new TypesProtoContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_typesProto);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(170);
					match(ID);
					setState(171);
					match(T__17);
					}
					} 
				}
				setState(176);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			}
			setState(177);
			match(ID);
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

	public static class SingleTypeFunctionDeclContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(funkParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(funkParser.ID, i);
		}
		public ArgsProtoContext argsProto() {
			return getRuleContext(ArgsProtoContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public SingleTypeFunctionDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleTypeFunctionDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof funkListener ) ((funkListener)listener).enterSingleTypeFunctionDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof funkListener ) ((funkListener)listener).exitSingleTypeFunctionDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof funkVisitor ) return ((funkVisitor<? extends T>)visitor).visitSingleTypeFunctionDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SingleTypeFunctionDeclContext singleTypeFunctionDecl() throws RecognitionException {
		SingleTypeFunctionDeclContext _localctx = new SingleTypeFunctionDeclContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_singleTypeFunctionDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			match(T__18);
			setState(180);
			match(ID);
			setState(181);
			match(T__3);
			setState(182);
			match(ID);
			setState(183);
			match(T__0);
			setState(184);
			argsProto();
			setState(185);
			match(T__1);
			setState(186);
			statement();
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

	public static class MultipleTypeFunctionDeclContext extends ParserRuleContext {
		public TypesProtoContext typesProto() {
			return getRuleContext(TypesProtoContext.class,0);
		}
		public TerminalNode ID() { return getToken(funkParser.ID, 0); }
		public ArgsProtoContext argsProto() {
			return getRuleContext(ArgsProtoContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public MultipleTypeFunctionDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multipleTypeFunctionDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof funkListener ) ((funkListener)listener).enterMultipleTypeFunctionDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof funkListener ) ((funkListener)listener).exitMultipleTypeFunctionDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof funkVisitor ) return ((funkVisitor<? extends T>)visitor).visitMultipleTypeFunctionDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultipleTypeFunctionDeclContext multipleTypeFunctionDecl() throws RecognitionException {
		MultipleTypeFunctionDeclContext _localctx = new MultipleTypeFunctionDeclContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_multipleTypeFunctionDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			match(T__18);
			setState(189);
			match(T__0);
			setState(190);
			typesProto();
			setState(191);
			match(T__1);
			setState(192);
			match(T__3);
			setState(193);
			match(ID);
			setState(194);
			match(T__0);
			setState(195);
			argsProto();
			setState(196);
			match(T__1);
			setState(197);
			statement();
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

	public static class GenericTypeFunctionDeclContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(funkParser.ID, 0); }
		public ArgsProtoContext argsProto() {
			return getRuleContext(ArgsProtoContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public GenericTypeFunctionDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_genericTypeFunctionDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof funkListener ) ((funkListener)listener).enterGenericTypeFunctionDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof funkListener ) ((funkListener)listener).exitGenericTypeFunctionDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof funkVisitor ) return ((funkVisitor<? extends T>)visitor).visitGenericTypeFunctionDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GenericTypeFunctionDeclContext genericTypeFunctionDecl() throws RecognitionException {
		GenericTypeFunctionDeclContext _localctx = new GenericTypeFunctionDeclContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_genericTypeFunctionDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
			match(T__18);
			setState(200);
			match(T__19);
			setState(201);
			match(T__3);
			setState(202);
			match(ID);
			setState(203);
			match(T__0);
			setState(204);
			argsProto();
			setState(205);
			match(T__1);
			setState(206);
			statement();
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
		case 0:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 5);
		case 1:
			return precpred(_ctx, 4);
		case 2:
			return precpred(_ctx, 3);
		case 3:
			return precpred(_ctx, 9);
		case 4:
			return precpred(_ctx, 8);
		case 5:
			return precpred(_ctx, 7);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\37\u00d3\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\3\2\3\2\3\2\3\2\5\2\37\n\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2\64\n\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\5\2<\n\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\7\2U\n\2\f\2\16\2"+
		"X\13\2\3\3\3\3\3\3\7\3]\n\3\f\3\16\3`\13\3\3\3\5\3c\n\3\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4t\n\4\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\5\5}\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3"+
		"\7\6\7\u008b\n\7\r\7\16\7\u008c\3\7\3\7\3\b\3\b\3\b\3\b\5\b\u0095\n\b"+
		"\3\b\3\b\3\b\7\b\u009a\n\b\f\b\16\b\u009d\13\b\3\b\3\b\3\b\3\b\3\t\3\t"+
		"\7\t\u00a5\n\t\f\t\16\t\u00a8\13\t\3\t\5\t\u00ab\n\t\3\n\3\n\7\n\u00af"+
		"\n\n\f\n\16\n\u00b2\13\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\2\3\2\16\2\4\6\b\n\f\16\20\22\24\26\30\2\2\u00e8"+
		"\2\63\3\2\2\2\4b\3\2\2\2\6s\3\2\2\2\bu\3\2\2\2\n~\3\2\2\2\f\u0088\3\2"+
		"\2\2\16\u0090\3\2\2\2\20\u00aa\3\2\2\2\22\u00b0\3\2\2\2\24\u00b5\3\2\2"+
		"\2\26\u00be\3\2\2\2\30\u00c9\3\2\2\2\32\33\b\2\1\2\33\34\7\35\2\2\34\64"+
		"\5\2\2\b\35\37\7\37\2\2\36\35\3\2\2\2\36\37\3\2\2\2\37 \3\2\2\2 !\7\34"+
		"\2\2!\"\7\t\2\2\"\64\5\2\2\4#$\7\3\2\2$%\5\2\2\2%&\7\4\2\2&\64\3\2\2\2"+
		"\'\64\7\33\2\2(\64\7\30\2\2)\64\7\31\2\2*\64\7\32\2\2+,\7\5\2\2,-\7\6"+
		"\2\2-.\7\34\2\2./\7\3\2\2/\60\5\4\3\2\60\61\7\4\2\2\61\64\3\2\2\2\62\64"+
		"\7\34\2\2\63\32\3\2\2\2\63\36\3\2\2\2\63#\3\2\2\2\63\'\3\2\2\2\63(\3\2"+
		"\2\2\63)\3\2\2\2\63*\3\2\2\2\63+\3\2\2\2\63\62\3\2\2\2\64V\3\2\2\2\65"+
		"\66\f\7\2\2\66\67\7\35\2\2\67U\5\2\2\b89\f\6\2\29;\7\7\2\2:<\5\2\2\2;"+
		":\3\2\2\2;<\3\2\2\2<=\3\2\2\2=>\7\b\2\2>?\7\t\2\2?U\5\2\2\7@A\f\5\2\2"+
		"AB\7\6\2\2BC\7\34\2\2CD\7\t\2\2DU\5\2\2\6EF\f\13\2\2FG\7\6\2\2GH\7\34"+
		"\2\2HI\7\3\2\2IJ\5\4\3\2JK\7\4\2\2KU\3\2\2\2LM\f\n\2\2MN\7\6\2\2NU\7\34"+
		"\2\2OP\f\t\2\2PQ\7\7\2\2QR\5\2\2\2RS\7\b\2\2SU\3\2\2\2T\65\3\2\2\2T8\3"+
		"\2\2\2T@\3\2\2\2TE\3\2\2\2TL\3\2\2\2TO\3\2\2\2UX\3\2\2\2VT\3\2\2\2VW\3"+
		"\2\2\2W\3\3\2\2\2XV\3\2\2\2YZ\5\2\2\2Z[\7\n\2\2[]\3\2\2\2\\Y\3\2\2\2]"+
		"`\3\2\2\2^\\\3\2\2\2^_\3\2\2\2_a\3\2\2\2`^\3\2\2\2ac\5\2\2\2b^\3\2\2\2"+
		"bc\3\2\2\2c\5\3\2\2\2de\5\2\2\2ef\7\13\2\2ft\3\2\2\2gh\7\f\2\2hi\5\2\2"+
		"\2ij\7\13\2\2jt\3\2\2\2kt\5\b\5\2lt\5\n\6\2mt\5\f\7\2nt\5\16\b\2ot\5\24"+
		"\13\2pt\5\26\f\2qt\5\30\r\2rt\7\36\2\2sd\3\2\2\2sg\3\2\2\2sk\3\2\2\2s"+
		"l\3\2\2\2sm\3\2\2\2sn\3\2\2\2so\3\2\2\2sp\3\2\2\2sq\3\2\2\2sr\3\2\2\2"+
		"t\7\3\2\2\2uv\7\r\2\2vw\7\3\2\2wx\5\2\2\2xy\7\4\2\2y|\5\6\4\2z{\7\16\2"+
		"\2{}\5\6\4\2|z\3\2\2\2|}\3\2\2\2}\t\3\2\2\2~\177\7\17\2\2\177\u0080\7"+
		"\3\2\2\u0080\u0081\5\2\2\2\u0081\u0082\7\13\2\2\u0082\u0083\5\2\2\2\u0083"+
		"\u0084\7\13\2\2\u0084\u0085\5\2\2\2\u0085\u0086\7\4\2\2\u0086\u0087\5"+
		"\6\4\2\u0087\13\3\2\2\2\u0088\u008a\7\20\2\2\u0089\u008b\5\6\4\2\u008a"+
		"\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008a\3\2\2\2\u008c\u008d\3\2"+
		"\2\2\u008d\u008e\3\2\2\2\u008e\u008f\7\21\2\2\u008f\r\3\2\2\2\u0090\u0091"+
		"\7\22\2\2\u0091\u0094\7\34\2\2\u0092\u0093\7\23\2\2\u0093\u0095\7\34\2"+
		"\2\u0094\u0092\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u009b"+
		"\7\20\2\2\u0097\u0098\7\34\2\2\u0098\u009a\7\n\2\2\u0099\u0097\3\2\2\2"+
		"\u009a\u009d\3\2\2\2\u009b\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009e"+
		"\3\2\2\2\u009d\u009b\3\2\2\2\u009e\u009f\7\34\2\2\u009f\u00a0\3\2\2\2"+
		"\u00a0\u00a1\7\21\2\2\u00a1\17\3\2\2\2\u00a2\u00a3\7\34\2\2\u00a3\u00a5"+
		"\7\n\2\2\u00a4\u00a2\3\2\2\2\u00a5\u00a8\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a6"+
		"\u00a7\3\2\2\2\u00a7\u00a9\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a9\u00ab\7\34"+
		"\2\2\u00aa\u00a6\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\21\3\2\2\2\u00ac\u00ad"+
		"\7\34\2\2\u00ad\u00af\7\24\2\2\u00ae\u00ac\3\2\2\2\u00af\u00b2\3\2\2\2"+
		"\u00b0\u00ae\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b3\3\2\2\2\u00b2\u00b0"+
		"\3\2\2\2\u00b3\u00b4\7\34\2\2\u00b4\23\3\2\2\2\u00b5\u00b6\7\25\2\2\u00b6"+
		"\u00b7\7\34\2\2\u00b7\u00b8\7\6\2\2\u00b8\u00b9\7\34\2\2\u00b9\u00ba\7"+
		"\3\2\2\u00ba\u00bb\5\20\t\2\u00bb\u00bc\7\4\2\2\u00bc\u00bd\5\6\4\2\u00bd"+
		"\25\3\2\2\2\u00be\u00bf\7\25\2\2\u00bf\u00c0\7\3\2\2\u00c0\u00c1\5\22"+
		"\n\2\u00c1\u00c2\7\4\2\2\u00c2\u00c3\7\6\2\2\u00c3\u00c4\7\34\2\2\u00c4"+
		"\u00c5\7\3\2\2\u00c5\u00c6\5\20\t\2\u00c6\u00c7\7\4\2\2\u00c7\u00c8\5"+
		"\6\4\2\u00c8\27\3\2\2\2\u00c9\u00ca\7\25\2\2\u00ca\u00cb\7\26\2\2\u00cb"+
		"\u00cc\7\6\2\2\u00cc\u00cd\7\34\2\2\u00cd\u00ce\7\3\2\2\u00ce\u00cf\5"+
		"\20\t\2\u00cf\u00d0\7\4\2\2\u00d0\u00d1\5\6\4\2\u00d1\31\3\2\2\2\21\36"+
		"\63;TV^bs|\u008c\u0094\u009b\u00a6\u00aa\u00b0";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}