// Generated from smath.g4 by ANTLR 4.5.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link smathParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface smathVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code UnaryOp}
	 * labeled alternative in {@link smathParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryOp(smathParser.UnaryOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Literal}
	 * labeled alternative in {@link smathParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(smathParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Assign}
	 * labeled alternative in {@link smathParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(smathParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ID}
	 * labeled alternative in {@link smathParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitID(smathParser.IDContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EnclosedExpr}
	 * labeled alternative in {@link smathParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnclosedExpr(smathParser.EnclosedExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BinaryOp}
	 * labeled alternative in {@link smathParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryOp(smathParser.BinaryOpContext ctx);
}