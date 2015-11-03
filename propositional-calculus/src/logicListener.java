// Generated from logic.g4 by ANTLR 4.5.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link logicParser}.
 */
public interface logicListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link logicParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(logicParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link logicParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(logicParser.ExprContext ctx);
}