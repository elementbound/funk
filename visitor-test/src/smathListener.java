// Generated from smath.g4 by ANTLR 4.5.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link smathParser}.
 */
public interface smathListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code UnaryOp}
	 * labeled alternative in {@link smathParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterUnaryOp(smathParser.UnaryOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UnaryOp}
	 * labeled alternative in {@link smathParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitUnaryOp(smathParser.UnaryOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Literal}
	 * labeled alternative in {@link smathParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(smathParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Literal}
	 * labeled alternative in {@link smathParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(smathParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Assign}
	 * labeled alternative in {@link smathParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAssign(smathParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Assign}
	 * labeled alternative in {@link smathParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAssign(smathParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ID}
	 * labeled alternative in {@link smathParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterID(smathParser.IDContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ID}
	 * labeled alternative in {@link smathParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitID(smathParser.IDContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EnclosedExpr}
	 * labeled alternative in {@link smathParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEnclosedExpr(smathParser.EnclosedExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EnclosedExpr}
	 * labeled alternative in {@link smathParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEnclosedExpr(smathParser.EnclosedExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BinaryOp}
	 * labeled alternative in {@link smathParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBinaryOp(smathParser.BinaryOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BinaryOp}
	 * labeled alternative in {@link smathParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBinaryOp(smathParser.BinaryOpContext ctx);
}