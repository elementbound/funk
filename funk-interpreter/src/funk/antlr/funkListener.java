// Generated from funk.g4 by ANTLR 4.5.1
package funk.antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link funkParser}.
 */
public interface funkListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link funkParser#comment}.
	 * @param ctx the parse tree
	 */
	void enterComment(funkParser.CommentContext ctx);
	/**
	 * Exit a parse tree produced by {@link funkParser#comment}.
	 * @param ctx the parse tree
	 */
	void exitComment(funkParser.CommentContext ctx);
	/**
	 * Enter a parse tree produced by {@link funkParser#id}.
	 * @param ctx the parse tree
	 */
	void enterId(funkParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by {@link funkParser#id}.
	 * @param ctx the parse tree
	 */
	void exitId(funkParser.IdContext ctx);
	/**
	 * Enter a parse tree produced by {@link funkParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(funkParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link funkParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(funkParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link funkParser#object}.
	 * @param ctx the parse tree
	 */
	void enterObject(funkParser.ObjectContext ctx);
	/**
	 * Exit a parse tree produced by {@link funkParser#object}.
	 * @param ctx the parse tree
	 */
	void exitObject(funkParser.ObjectContext ctx);
	/**
	 * Enter a parse tree produced by {@link funkParser#memberCall}.
	 * @param ctx the parse tree
	 */
	void enterMemberCall(funkParser.MemberCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link funkParser#memberCall}.
	 * @param ctx the parse tree
	 */
	void exitMemberCall(funkParser.MemberCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link funkParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssign(funkParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link funkParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssign(funkParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link funkParser#closedExpr}.
	 * @param ctx the parse tree
	 */
	void enterClosedExpr(funkParser.ClosedExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link funkParser#closedExpr}.
	 * @param ctx the parse tree
	 */
	void exitClosedExpr(funkParser.ClosedExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link funkParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(funkParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link funkParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(funkParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link funkParser#args}.
	 * @param ctx the parse tree
	 */
	void enterArgs(funkParser.ArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link funkParser#args}.
	 * @param ctx the parse tree
	 */
	void exitArgs(funkParser.ArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link funkParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(funkParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link funkParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(funkParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link funkParser#ifThenElse}.
	 * @param ctx the parse tree
	 */
	void enterIfThenElse(funkParser.IfThenElseContext ctx);
	/**
	 * Exit a parse tree produced by {@link funkParser#ifThenElse}.
	 * @param ctx the parse tree
	 */
	void exitIfThenElse(funkParser.IfThenElseContext ctx);
	/**
	 * Enter a parse tree produced by {@link funkParser#forLoop}.
	 * @param ctx the parse tree
	 */
	void enterForLoop(funkParser.ForLoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link funkParser#forLoop}.
	 * @param ctx the parse tree
	 */
	void exitForLoop(funkParser.ForLoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link funkParser#scope}.
	 * @param ctx the parse tree
	 */
	void enterScope(funkParser.ScopeContext ctx);
	/**
	 * Exit a parse tree produced by {@link funkParser#scope}.
	 * @param ctx the parse tree
	 */
	void exitScope(funkParser.ScopeContext ctx);
}