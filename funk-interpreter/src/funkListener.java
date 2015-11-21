// Generated from funk.g4 by ANTLR 4.5.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link funkParser}.
 */
public interface funkListener extends ParseTreeListener {
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
}