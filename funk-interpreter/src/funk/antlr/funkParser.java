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
		T__17=18, WS=19, NUMBER=20, STRING=21, BOOLEAN=22, ID=23, OP=24, COMMENT=25, 
		LOCAL=26;
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
			setState(48);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				_localctx = new UnaryOpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(25);
				match(OP);
				setState(26);
				expr(5);
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
				match(T__4);
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
				_localctx = new StringLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(39);
				match(STRING);
				}
				break;
			case 7:
				{
				_localctx = new ConstructorContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(40);
				match(T__2);
				setState(41);
				match(T__3);
				setState(42);
				match(ID);
				setState(43);
				match(T__0);
				setState(44);
				args();
				setState(45);
				match(T__1);
				}
				break;
			case 8:
				{
				_localctx = new IDContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(47);
				match(ID);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(70);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(68);
					switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryOpContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(50);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(51);
						match(OP);
						setState(52);
						expr(5);
						}
						break;
					case 2:
						{
						_localctx = new MemberAssignContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(53);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(54);
						match(T__3);
						setState(55);
						match(ID);
						setState(56);
						match(T__4);
						setState(57);
						expr(4);
						}
						break;
					case 3:
						{
						_localctx = new MemberCallContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(58);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(59);
						match(T__3);
						setState(60);
						match(ID);
						setState(61);
						match(T__0);
						setState(62);
						args();
						setState(63);
						match(T__1);
						}
						break;
					case 4:
						{
						_localctx = new MemberAccessContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(65);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(66);
						match(T__3);
						setState(67);
						match(ID);
						}
						break;
					}
					} 
				}
				setState(72);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
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
			setState(82);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << NUMBER) | (1L << STRING) | (1L << BOOLEAN) | (1L << ID) | (1L << OP) | (1L << LOCAL))) != 0)) {
				{
				setState(78);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(73);
						expr(0);
						setState(74);
						match(T__5);
						}
						} 
					}
					setState(80);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				}
				setState(81);
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
			setState(99);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				_localctx = new SingleStatementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(84);
				expr(0);
				setState(85);
				match(T__6);
				}
				break;
			case 2:
				_localctx = new ReturnStatementContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(87);
				match(T__7);
				setState(88);
				expr(0);
				setState(89);
				match(T__6);
				}
				break;
			case 3:
				_localctx = new IfStatementContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(91);
				ifThenElse();
				}
				break;
			case 4:
				_localctx = new ForStatementContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(92);
				forLoop();
				}
				break;
			case 5:
				_localctx = new BlockStatementContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(93);
				block();
				}
				break;
			case 6:
				_localctx = new AggregateDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(94);
				aggregateDecl();
				}
				break;
			case 7:
				_localctx = new SingleFuncDeclContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(95);
				singleTypeFunctionDecl();
				}
				break;
			case 8:
				_localctx = new MultiFuncDeclContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(96);
				multipleTypeFunctionDecl();
				}
				break;
			case 9:
				_localctx = new GenFuncDeclContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(97);
				genericTypeFunctionDecl();
				}
				break;
			case 10:
				_localctx = new CommentContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(98);
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
			setState(101);
			match(T__8);
			setState(102);
			match(T__0);
			setState(103);
			expr(0);
			setState(104);
			match(T__1);
			setState(105);
			statement();
			setState(108);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(106);
				match(T__9);
				setState(107);
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
			setState(110);
			match(T__10);
			setState(111);
			match(T__0);
			setState(112);
			expr(0);
			setState(113);
			match(T__6);
			setState(114);
			expr(0);
			setState(115);
			match(T__6);
			setState(116);
			expr(0);
			setState(117);
			match(T__1);
			setState(118);
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
			setState(120);
			match(T__11);
			setState(122); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(121);
				statement();
				}
				}
				setState(124); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__7) | (1L << T__8) | (1L << T__10) | (1L << T__11) | (1L << T__13) | (1L << T__16) | (1L << NUMBER) | (1L << STRING) | (1L << BOOLEAN) | (1L << ID) | (1L << OP) | (1L << COMMENT) | (1L << LOCAL))) != 0) );
			setState(126);
			match(T__12);
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
			setState(128);
			match(T__13);
			setState(129);
			match(ID);
			setState(132);
			_la = _input.LA(1);
			if (_la==T__14) {
				{
				setState(130);
				match(T__14);
				setState(131);
				((AggregateDeclContext)_localctx).baseType = match(ID);
				}
			}

			setState(134);
			match(T__11);
			{
			setState(139);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(135);
					match(ID);
					setState(136);
					match(T__5);
					}
					} 
				}
				setState(141);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			setState(142);
			match(ID);
			}
			setState(144);
			match(T__12);
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
			setState(154);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(150);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(146);
						match(ID);
						setState(147);
						match(T__5);
						}
						} 
					}
					setState(152);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
				}
				setState(153);
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
			setState(160);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(156);
					match(ID);
					setState(157);
					match(T__15);
					}
					} 
				}
				setState(162);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			}
			setState(163);
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
			setState(165);
			match(T__16);
			setState(166);
			match(ID);
			setState(167);
			match(T__3);
			setState(168);
			match(ID);
			setState(169);
			match(T__0);
			setState(170);
			argsProto();
			setState(171);
			match(T__1);
			setState(172);
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
			setState(174);
			match(T__16);
			setState(175);
			match(T__0);
			setState(176);
			typesProto();
			setState(177);
			match(T__1);
			setState(178);
			match(T__3);
			setState(179);
			match(ID);
			setState(180);
			match(T__0);
			setState(181);
			argsProto();
			setState(182);
			match(T__1);
			setState(183);
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
			setState(185);
			match(T__16);
			setState(186);
			match(T__17);
			setState(187);
			match(T__3);
			setState(188);
			match(ID);
			setState(189);
			match(T__0);
			setState(190);
			argsProto();
			setState(191);
			match(T__1);
			setState(192);
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
			return precpred(_ctx, 4);
		case 1:
			return precpred(_ctx, 3);
		case 2:
			return precpred(_ctx, 7);
		case 3:
			return precpred(_ctx, 6);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\34\u00c5\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\3\2\3\2\3\2\3\2\5\2\37\n\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2\63\n\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\7\2G"+
		"\n\2\f\2\16\2J\13\2\3\3\3\3\3\3\7\3O\n\3\f\3\16\3R\13\3\3\3\5\3U\n\3\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4f\n\4\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5o\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\7\3\7\6\7}\n\7\r\7\16\7~\3\7\3\7\3\b\3\b\3\b\3\b\5\b\u0087\n"+
		"\b\3\b\3\b\3\b\7\b\u008c\n\b\f\b\16\b\u008f\13\b\3\b\3\b\3\b\3\b\3\t\3"+
		"\t\7\t\u0097\n\t\f\t\16\t\u009a\13\t\3\t\5\t\u009d\n\t\3\n\3\n\7\n\u00a1"+
		"\n\n\f\n\16\n\u00a4\13\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\2\3\2\16\2\4\6\b\n\f\16\20\22\24\26\30\2\2\u00d6"+
		"\2\62\3\2\2\2\4T\3\2\2\2\6e\3\2\2\2\bg\3\2\2\2\np\3\2\2\2\fz\3\2\2\2\16"+
		"\u0082\3\2\2\2\20\u009c\3\2\2\2\22\u00a2\3\2\2\2\24\u00a7\3\2\2\2\26\u00b0"+
		"\3\2\2\2\30\u00bb\3\2\2\2\32\33\b\2\1\2\33\34\7\32\2\2\34\63\5\2\2\7\35"+
		"\37\7\34\2\2\36\35\3\2\2\2\36\37\3\2\2\2\37 \3\2\2\2 !\7\31\2\2!\"\7\7"+
		"\2\2\"\63\5\2\2\4#$\7\3\2\2$%\5\2\2\2%&\7\4\2\2&\63\3\2\2\2\'\63\7\30"+
		"\2\2(\63\7\26\2\2)\63\7\27\2\2*+\7\5\2\2+,\7\6\2\2,-\7\31\2\2-.\7\3\2"+
		"\2./\5\4\3\2/\60\7\4\2\2\60\63\3\2\2\2\61\63\7\31\2\2\62\32\3\2\2\2\62"+
		"\36\3\2\2\2\62#\3\2\2\2\62\'\3\2\2\2\62(\3\2\2\2\62)\3\2\2\2\62*\3\2\2"+
		"\2\62\61\3\2\2\2\63H\3\2\2\2\64\65\f\6\2\2\65\66\7\32\2\2\66G\5\2\2\7"+
		"\678\f\5\2\289\7\6\2\29:\7\31\2\2:;\7\7\2\2;G\5\2\2\6<=\f\t\2\2=>\7\6"+
		"\2\2>?\7\31\2\2?@\7\3\2\2@A\5\4\3\2AB\7\4\2\2BG\3\2\2\2CD\f\b\2\2DE\7"+
		"\6\2\2EG\7\31\2\2F\64\3\2\2\2F\67\3\2\2\2F<\3\2\2\2FC\3\2\2\2GJ\3\2\2"+
		"\2HF\3\2\2\2HI\3\2\2\2I\3\3\2\2\2JH\3\2\2\2KL\5\2\2\2LM\7\b\2\2MO\3\2"+
		"\2\2NK\3\2\2\2OR\3\2\2\2PN\3\2\2\2PQ\3\2\2\2QS\3\2\2\2RP\3\2\2\2SU\5\2"+
		"\2\2TP\3\2\2\2TU\3\2\2\2U\5\3\2\2\2VW\5\2\2\2WX\7\t\2\2Xf\3\2\2\2YZ\7"+
		"\n\2\2Z[\5\2\2\2[\\\7\t\2\2\\f\3\2\2\2]f\5\b\5\2^f\5\n\6\2_f\5\f\7\2`"+
		"f\5\16\b\2af\5\24\13\2bf\5\26\f\2cf\5\30\r\2df\7\33\2\2eV\3\2\2\2eY\3"+
		"\2\2\2e]\3\2\2\2e^\3\2\2\2e_\3\2\2\2e`\3\2\2\2ea\3\2\2\2eb\3\2\2\2ec\3"+
		"\2\2\2ed\3\2\2\2f\7\3\2\2\2gh\7\13\2\2hi\7\3\2\2ij\5\2\2\2jk\7\4\2\2k"+
		"n\5\6\4\2lm\7\f\2\2mo\5\6\4\2nl\3\2\2\2no\3\2\2\2o\t\3\2\2\2pq\7\r\2\2"+
		"qr\7\3\2\2rs\5\2\2\2st\7\t\2\2tu\5\2\2\2uv\7\t\2\2vw\5\2\2\2wx\7\4\2\2"+
		"xy\5\6\4\2y\13\3\2\2\2z|\7\16\2\2{}\5\6\4\2|{\3\2\2\2}~\3\2\2\2~|\3\2"+
		"\2\2~\177\3\2\2\2\177\u0080\3\2\2\2\u0080\u0081\7\17\2\2\u0081\r\3\2\2"+
		"\2\u0082\u0083\7\20\2\2\u0083\u0086\7\31\2\2\u0084\u0085\7\21\2\2\u0085"+
		"\u0087\7\31\2\2\u0086\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0088\3"+
		"\2\2\2\u0088\u008d\7\16\2\2\u0089\u008a\7\31\2\2\u008a\u008c\7\b\2\2\u008b"+
		"\u0089\3\2\2\2\u008c\u008f\3\2\2\2\u008d\u008b\3\2\2\2\u008d\u008e\3\2"+
		"\2\2\u008e\u0090\3\2\2\2\u008f\u008d\3\2\2\2\u0090\u0091\7\31\2\2\u0091"+
		"\u0092\3\2\2\2\u0092\u0093\7\17\2\2\u0093\17\3\2\2\2\u0094\u0095\7\31"+
		"\2\2\u0095\u0097\7\b\2\2\u0096\u0094\3\2\2\2\u0097\u009a\3\2\2\2\u0098"+
		"\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u009b\3\2\2\2\u009a\u0098\3\2"+
		"\2\2\u009b\u009d\7\31\2\2\u009c\u0098\3\2\2\2\u009c\u009d\3\2\2\2\u009d"+
		"\21\3\2\2\2\u009e\u009f\7\31\2\2\u009f\u00a1\7\22\2\2\u00a0\u009e\3\2"+
		"\2\2\u00a1\u00a4\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3"+
		"\u00a5\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a5\u00a6\7\31\2\2\u00a6\23\3\2\2"+
		"\2\u00a7\u00a8\7\23\2\2\u00a8\u00a9\7\31\2\2\u00a9\u00aa\7\6\2\2\u00aa"+
		"\u00ab\7\31\2\2\u00ab\u00ac\7\3\2\2\u00ac\u00ad\5\20\t\2\u00ad\u00ae\7"+
		"\4\2\2\u00ae\u00af\5\6\4\2\u00af\25\3\2\2\2\u00b0\u00b1\7\23\2\2\u00b1"+
		"\u00b2\7\3\2\2\u00b2\u00b3\5\22\n\2\u00b3\u00b4\7\4\2\2\u00b4\u00b5\7"+
		"\6\2\2\u00b5\u00b6\7\31\2\2\u00b6\u00b7\7\3\2\2\u00b7\u00b8\5\20\t\2\u00b8"+
		"\u00b9\7\4\2\2\u00b9\u00ba\5\6\4\2\u00ba\27\3\2\2\2\u00bb\u00bc\7\23\2"+
		"\2\u00bc\u00bd\7\24\2\2\u00bd\u00be\7\6\2\2\u00be\u00bf\7\31\2\2\u00bf"+
		"\u00c0\7\3\2\2\u00c0\u00c1\5\20\t\2\u00c1\u00c2\7\4\2\2\u00c2\u00c3\5"+
		"\6\4\2\u00c3\31\3\2\2\2\20\36\62FHPTen~\u0086\u008d\u0098\u009c\u00a2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}