// Generated from funk.g4 by ANTLR 4.5.1
package funk.antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link funkParser}.
 */
public interface funkListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code MemberCall}
	 * labeled alternative in {@link funkParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMemberCall(funkParser.MemberCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MemberCall}
	 * labeled alternative in {@link funkParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMemberCall(funkParser.MemberCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UnaryOp}
	 * labeled alternative in {@link funkParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterUnaryOp(funkParser.UnaryOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UnaryOp}
	 * labeled alternative in {@link funkParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitUnaryOp(funkParser.UnaryOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StringLiteral}
	 * labeled alternative in {@link funkParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterStringLiteral(funkParser.StringLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StringLiteral}
	 * labeled alternative in {@link funkParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitStringLiteral(funkParser.StringLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MemberAccess}
	 * labeled alternative in {@link funkParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMemberAccess(funkParser.MemberAccessContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MemberAccess}
	 * labeled alternative in {@link funkParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMemberAccess(funkParser.MemberAccessContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BooleanLiteral}
	 * labeled alternative in {@link funkParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBooleanLiteral(funkParser.BooleanLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BooleanLiteral}
	 * labeled alternative in {@link funkParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBooleanLiteral(funkParser.BooleanLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Constructor}
	 * labeled alternative in {@link funkParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterConstructor(funkParser.ConstructorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Constructor}
	 * labeled alternative in {@link funkParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitConstructor(funkParser.ConstructorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Assign}
	 * labeled alternative in {@link funkParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAssign(funkParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Assign}
	 * labeled alternative in {@link funkParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAssign(funkParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MemberAssign}
	 * labeled alternative in {@link funkParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMemberAssign(funkParser.MemberAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MemberAssign}
	 * labeled alternative in {@link funkParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMemberAssign(funkParser.MemberAssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ID}
	 * labeled alternative in {@link funkParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterID(funkParser.IDContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ID}
	 * labeled alternative in {@link funkParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitID(funkParser.IDContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EnclosedExpr}
	 * labeled alternative in {@link funkParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEnclosedExpr(funkParser.EnclosedExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EnclosedExpr}
	 * labeled alternative in {@link funkParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEnclosedExpr(funkParser.EnclosedExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NumberLiteral}
	 * labeled alternative in {@link funkParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNumberLiteral(funkParser.NumberLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NumberLiteral}
	 * labeled alternative in {@link funkParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNumberLiteral(funkParser.NumberLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BinaryOp}
	 * labeled alternative in {@link funkParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBinaryOp(funkParser.BinaryOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BinaryOp}
	 * labeled alternative in {@link funkParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBinaryOp(funkParser.BinaryOpContext ctx);
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
	 * Enter a parse tree produced by the {@code SingleStatement}
	 * labeled alternative in {@link funkParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterSingleStatement(funkParser.SingleStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SingleStatement}
	 * labeled alternative in {@link funkParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitSingleStatement(funkParser.SingleStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IfStatement}
	 * labeled alternative in {@link funkParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(funkParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IfStatement}
	 * labeled alternative in {@link funkParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(funkParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForStatement}
	 * labeled alternative in {@link funkParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(funkParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForStatement}
	 * labeled alternative in {@link funkParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(funkParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BlockStatement}
	 * labeled alternative in {@link funkParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterBlockStatement(funkParser.BlockStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BlockStatement}
	 * labeled alternative in {@link funkParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitBlockStatement(funkParser.BlockStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AggregateDeclaration}
	 * labeled alternative in {@link funkParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterAggregateDeclaration(funkParser.AggregateDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AggregateDeclaration}
	 * labeled alternative in {@link funkParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitAggregateDeclaration(funkParser.AggregateDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Comment}
	 * labeled alternative in {@link funkParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterComment(funkParser.CommentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Comment}
	 * labeled alternative in {@link funkParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitComment(funkParser.CommentContext ctx);
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
	 * Enter a parse tree produced by {@link funkParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(funkParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link funkParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(funkParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link funkParser#aggregateDecl}.
	 * @param ctx the parse tree
	 */
	void enterAggregateDecl(funkParser.AggregateDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link funkParser#aggregateDecl}.
	 * @param ctx the parse tree
	 */
	void exitAggregateDecl(funkParser.AggregateDeclContext ctx);
}