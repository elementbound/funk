// Generated from funk.g4 by ANTLR 4.5.1
package funk.antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link funkParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface funkVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code MemberCall}
	 * labeled alternative in {@link funkParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemberCall(funkParser.MemberCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UnaryOp}
	 * labeled alternative in {@link funkParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryOp(funkParser.UnaryOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BooleanLiteral}
	 * labeled alternative in {@link funkParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanLiteral(funkParser.BooleanLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Constructor}
	 * labeled alternative in {@link funkParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructor(funkParser.ConstructorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IndexAccess}
	 * labeled alternative in {@link funkParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexAccess(funkParser.IndexAccessContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StringLiteral}
	 * labeled alternative in {@link funkParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringLiteral(funkParser.StringLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MemberAccess}
	 * labeled alternative in {@link funkParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemberAccess(funkParser.MemberAccessContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IndexAssign}
	 * labeled alternative in {@link funkParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexAssign(funkParser.IndexAssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Assign}
	 * labeled alternative in {@link funkParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(funkParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MemberAssign}
	 * labeled alternative in {@link funkParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemberAssign(funkParser.MemberAssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ID}
	 * labeled alternative in {@link funkParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitID(funkParser.IDContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EnclosedExpr}
	 * labeled alternative in {@link funkParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnclosedExpr(funkParser.EnclosedExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NumberLiteral}
	 * labeled alternative in {@link funkParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberLiteral(funkParser.NumberLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BinaryOp}
	 * labeled alternative in {@link funkParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryOp(funkParser.BinaryOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link funkParser#args}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgs(funkParser.ArgsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SingleStatement}
	 * labeled alternative in {@link funkParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleStatement(funkParser.SingleStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ReturnStatement}
	 * labeled alternative in {@link funkParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(funkParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IfStatement}
	 * labeled alternative in {@link funkParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(funkParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ForStatement}
	 * labeled alternative in {@link funkParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatement(funkParser.ForStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BlockStatement}
	 * labeled alternative in {@link funkParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStatement(funkParser.BlockStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AggregateDeclaration}
	 * labeled alternative in {@link funkParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAggregateDeclaration(funkParser.AggregateDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SingleFuncDecl}
	 * labeled alternative in {@link funkParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleFuncDecl(funkParser.SingleFuncDeclContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MultiFuncDecl}
	 * labeled alternative in {@link funkParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiFuncDecl(funkParser.MultiFuncDeclContext ctx);
	/**
	 * Visit a parse tree produced by the {@code GenFuncDecl}
	 * labeled alternative in {@link funkParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGenFuncDecl(funkParser.GenFuncDeclContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Comment}
	 * labeled alternative in {@link funkParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComment(funkParser.CommentContext ctx);
	/**
	 * Visit a parse tree produced by {@link funkParser#ifThenElse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfThenElse(funkParser.IfThenElseContext ctx);
	/**
	 * Visit a parse tree produced by {@link funkParser#forLoop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForLoop(funkParser.ForLoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link funkParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(funkParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link funkParser#aggregateDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAggregateDecl(funkParser.AggregateDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link funkParser#argsProto}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgsProto(funkParser.ArgsProtoContext ctx);
	/**
	 * Visit a parse tree produced by {@link funkParser#typesProto}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypesProto(funkParser.TypesProtoContext ctx);
	/**
	 * Visit a parse tree produced by {@link funkParser#singleTypeFunctionDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleTypeFunctionDecl(funkParser.SingleTypeFunctionDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link funkParser#multipleTypeFunctionDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultipleTypeFunctionDecl(funkParser.MultipleTypeFunctionDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link funkParser#genericTypeFunctionDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGenericTypeFunctionDecl(funkParser.GenericTypeFunctionDeclContext ctx);
}