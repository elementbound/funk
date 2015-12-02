import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class SmathEvaluator extends smathBaseVisitor<Double> {
	private Map<String, Double> variableTable = new HashMap<String, Double>();
	
	public PrintStream dbgStream = System.out; 
	
	@Override
	public Double defaultResult() {
		return -1.0;
	}
	
	@Override
	public Double aggregateResult(Double aggregate, Double next) { 
		return next; 
	}
	
	@Override 
	public Double visitLiteral(smathParser.LiteralContext ctx) {
		return Double.parseDouble(ctx.NUMBER().getText());
	}
	
	@Override 
	public Double visitID(smathParser.IDContext ctx) {
		String id = ctx.ID().getText();
		
		if(!variableTable.containsKey(id))
			return 0.0;
		else
			return variableTable.get(id);
	}
	
	@Override 
	public Double visitAssign(smathParser.AssignContext ctx) {
		String id = ctx.ID().getText();
		smathParser.ExprContext expr = ctx.expr();
		
		double val = visit(expr);
		variableTable.put(id, val);
		
		return val;
	}
	
	@Override
	public Double visitUnaryOp(smathParser.UnaryOpContext ctx) {
		smathParser.ExprContext expr = ctx.expr();
		String op = ctx.OP().getText();
		
		if(op.equals("+"))
			return visit(expr);
		else if(op.equals("-"))
			return -visit(expr);
		
		dbgStream.printf("Unknown unary operator: %s\n", op);
		return defaultResult();
	}
	
	@Override 
	public Double visitBinaryOp(smathParser.BinaryOpContext ctx) {
		smathParser.ExprContext lhs = ctx.expr(0);
		smathParser.ExprContext rhs = ctx.expr(1);
		
		String op = ctx.OP().getText();
		
		if(op.equals("+"))
			return visit(lhs) + visit(rhs);
		else if(op.equals("-"))
			return visit(lhs) - visit(rhs);
		else if(op.equals("*"))
			return visit(lhs) * visit(rhs);
		else if(op.equals("/"))
			return visit(lhs) / visit(rhs);
		
		dbgStream.printf("Unknown binary operator: \"%s\"\n", op);
		return defaultResult();
	}
	
	@Override 
	public Double visitEnclosedExpr(smathParser.EnclosedExprContext ctx) {
		return visit(ctx.expr());
	}
	
	//=======================================================================================//
	
	public double eval(String line) {
		CharStream stream = new ANTLRInputStream(line);
		smathLexer lexer = new smathLexer(stream);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		
		smathParser parser = new smathParser(tokens);
		ParseTree tree = parser.expr();

		return visit(tree);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SmathEvaluator evaluator = new SmathEvaluator();
		evaluator.variableTable.put("pi", 3.1415926535897932384626433832795);
		
		while(sc.hasNextLine()) {
			String line = sc.nextLine();
			double result = evaluator.eval(line);
			System.out.println(result);
		}
		
		sc.close();
	}
}
