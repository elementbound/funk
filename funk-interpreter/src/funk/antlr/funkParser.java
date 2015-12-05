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
		T__9=10, T__10=11, T__11=12, T__12=13, WS=14, NUMBER=15, STRING=16, BOOLEAN=17, 
		ID=18, OP=19, COMMENT=20;
	public static final int
		RULE_expr = 0, RULE_args = 1, RULE_statement = 2, RULE_ifThenElse = 3, 
		RULE_forLoop = 4, RULE_block = 5, RULE_aggregateDecl = 6;
	public static final String[] ruleNames = {
		"expr", "args", "statement", "ifThenElse", "forLoop", "block", "aggregateDecl"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "')'", "'!'", "'.'", "'='", "','", "';'", "'if'", "'else'", 
		"'for'", "'{'", "'}'", "'aggregate'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, "WS", "NUMBER", "STRING", "BOOLEAN", "ID", "OP", "COMMENT"
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
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				{
				_localctx = new UnaryOpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(15);
				match(OP);
				setState(16);
				expr(3);
				}
				break;
			case 2:
				{
				_localctx = new AssignContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(17);
				match(ID);
				setState(18);
				match(T__4);
				setState(19);
				expr(1);
				}
				break;
			case 3:
				{
				_localctx = new EnclosedExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(20);
				match(T__0);
				setState(21);
				expr(0);
				setState(22);
				match(T__1);
				}
				break;
			case 4:
				{
				_localctx = new IDContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(24);
				match(ID);
				}
				break;
			case 5:
				{
				_localctx = new BooleanLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(25);
				match(BOOLEAN);
				}
				break;
			case 6:
				{
				_localctx = new NumberLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(26);
				match(NUMBER);
				}
				break;
			case 7:
				{
				_localctx = new StringLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(27);
				match(STRING);
				}
				break;
			case 8:
				{
				_localctx = new ConstructorContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(28);
				match(T__2);
				setState(29);
				match(T__3);
				setState(30);
				match(ID);
				setState(31);
				match(T__0);
				setState(32);
				args();
				setState(33);
				match(T__1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(49);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(47);
					switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryOpContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(37);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(38);
						match(OP);
						setState(39);
						expr(3);
						}
						break;
					case 2:
						{
						_localctx = new MemberCallContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(40);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
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
					}
					} 
				}
				setState(51);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
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
			setState(61);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << NUMBER) | (1L << STRING) | (1L << BOOLEAN) | (1L << ID) | (1L << OP))) != 0)) {
				{
				setState(57);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(52);
						expr(0);
						setState(53);
						match(T__5);
						}
						} 
					}
					setState(59);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
				}
				setState(60);
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

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statement);
		try {
			setState(71);
			switch (_input.LA(1)) {
			case T__0:
			case T__2:
			case NUMBER:
			case STRING:
			case BOOLEAN:
			case ID:
			case OP:
				_localctx = new SingleStatementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(63);
				expr(0);
				setState(64);
				match(T__6);
				}
				break;
			case T__7:
				_localctx = new IfStatementContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(66);
				ifThenElse();
				}
				break;
			case T__9:
				_localctx = new ForStatementContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(67);
				forLoop();
				}
				break;
			case T__10:
				_localctx = new BlockStatementContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(68);
				block();
				}
				break;
			case T__12:
				_localctx = new AggregateDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(69);
				aggregateDecl();
				}
				break;
			case COMMENT:
				_localctx = new CommentContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(70);
				match(COMMENT);
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
			setState(73);
			match(T__7);
			setState(74);
			match(T__0);
			setState(75);
			expr(0);
			setState(76);
			match(T__1);
			setState(77);
			statement();
			setState(80);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(78);
				match(T__8);
				setState(79);
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
			setState(82);
			match(T__9);
			setState(83);
			match(T__0);
			setState(84);
			expr(0);
			setState(85);
			match(T__6);
			setState(86);
			expr(0);
			setState(87);
			match(T__6);
			setState(88);
			expr(0);
			setState(89);
			match(T__1);
			setState(90);
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
			setState(92);
			match(T__10);
			setState(94); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(93);
				statement();
				}
				}
				setState(96); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << T__12) | (1L << NUMBER) | (1L << STRING) | (1L << BOOLEAN) | (1L << ID) | (1L << OP) | (1L << COMMENT))) != 0) );
			setState(98);
			match(T__11);
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
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			match(T__12);
			setState(101);
			match(ID);
			setState(102);
			match(T__10);
			{
			setState(107);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(103);
					match(ID);
					setState(104);
					match(T__5);
					}
					} 
				}
				setState(109);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			setState(110);
			match(ID);
			}
			setState(112);
			match(T__11);
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
			return precpred(_ctx, 2);
		case 1:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\26u\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2&\n\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\7\2\62\n\2\f\2\16\2\65\13\2\3\3\3"+
		"\3\3\3\7\3:\n\3\f\3\16\3=\13\3\3\3\5\3@\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\5\4J\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5S\n\5\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\6\7a\n\7\r\7\16\7b\3\7\3\7\3\b\3\b\3\b"+
		"\3\b\3\b\7\bl\n\b\f\b\16\bo\13\b\3\b\3\b\3\b\3\b\3\b\2\3\2\t\2\4\6\b\n"+
		"\f\16\2\2\u0080\2%\3\2\2\2\4?\3\2\2\2\6I\3\2\2\2\bK\3\2\2\2\nT\3\2\2\2"+
		"\f^\3\2\2\2\16f\3\2\2\2\20\21\b\2\1\2\21\22\7\25\2\2\22&\5\2\2\5\23\24"+
		"\7\24\2\2\24\25\7\7\2\2\25&\5\2\2\3\26\27\7\3\2\2\27\30\5\2\2\2\30\31"+
		"\7\4\2\2\31&\3\2\2\2\32&\7\24\2\2\33&\7\23\2\2\34&\7\21\2\2\35&\7\22\2"+
		"\2\36\37\7\5\2\2\37 \7\6\2\2 !\7\24\2\2!\"\7\3\2\2\"#\5\4\3\2#$\7\4\2"+
		"\2$&\3\2\2\2%\20\3\2\2\2%\23\3\2\2\2%\26\3\2\2\2%\32\3\2\2\2%\33\3\2\2"+
		"\2%\34\3\2\2\2%\35\3\2\2\2%\36\3\2\2\2&\63\3\2\2\2\'(\f\4\2\2()\7\25\2"+
		"\2)\62\5\2\2\5*+\f\6\2\2+,\7\6\2\2,-\7\24\2\2-.\7\3\2\2./\5\4\3\2/\60"+
		"\7\4\2\2\60\62\3\2\2\2\61\'\3\2\2\2\61*\3\2\2\2\62\65\3\2\2\2\63\61\3"+
		"\2\2\2\63\64\3\2\2\2\64\3\3\2\2\2\65\63\3\2\2\2\66\67\5\2\2\2\678\7\b"+
		"\2\28:\3\2\2\29\66\3\2\2\2:=\3\2\2\2;9\3\2\2\2;<\3\2\2\2<>\3\2\2\2=;\3"+
		"\2\2\2>@\5\2\2\2?;\3\2\2\2?@\3\2\2\2@\5\3\2\2\2AB\5\2\2\2BC\7\t\2\2CJ"+
		"\3\2\2\2DJ\5\b\5\2EJ\5\n\6\2FJ\5\f\7\2GJ\5\16\b\2HJ\7\26\2\2IA\3\2\2\2"+
		"ID\3\2\2\2IE\3\2\2\2IF\3\2\2\2IG\3\2\2\2IH\3\2\2\2J\7\3\2\2\2KL\7\n\2"+
		"\2LM\7\3\2\2MN\5\2\2\2NO\7\4\2\2OR\5\6\4\2PQ\7\13\2\2QS\5\6\4\2RP\3\2"+
		"\2\2RS\3\2\2\2S\t\3\2\2\2TU\7\f\2\2UV\7\3\2\2VW\5\2\2\2WX\7\t\2\2XY\5"+
		"\2\2\2YZ\7\t\2\2Z[\5\2\2\2[\\\7\4\2\2\\]\5\6\4\2]\13\3\2\2\2^`\7\r\2\2"+
		"_a\5\6\4\2`_\3\2\2\2ab\3\2\2\2b`\3\2\2\2bc\3\2\2\2cd\3\2\2\2de\7\16\2"+
		"\2e\r\3\2\2\2fg\7\17\2\2gh\7\24\2\2hm\7\r\2\2ij\7\24\2\2jl\7\b\2\2ki\3"+
		"\2\2\2lo\3\2\2\2mk\3\2\2\2mn\3\2\2\2np\3\2\2\2om\3\2\2\2pq\7\24\2\2qr"+
		"\3\2\2\2rs\7\16\2\2s\17\3\2\2\2\13%\61\63;?IRbm";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}