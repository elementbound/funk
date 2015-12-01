import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;

public class SmathEvaluator extends smathBaseVisitor<Double> {
	private Map<String, Double> variableTable = new HashMap<String, Double>();
	
	public PrintStream dbgStream = System.out; 
	
	@Override 
	public Double visit(ParseTree tree) {
		dbgStream.printf("Visiting tree: %s\n", tree.getText());
		
		return super.visit(tree);
	}
	
	@Override
	public Double visitChildren(RuleNode node){
		dbgStream.printf("Eval node: %s\n", node.getText());
		
		return visitChildren(node);
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
		
		dbgStream.printf("Saved variable %s = %f\n", id, val);
		
		return val;
	}
	
	@Override 
	public Double visitBinaryOp(smathParser.BinaryOpContext ctx) {
		smathParser.ExprContext lhs = ctx.expr(0);
		smathParser.ExprContext rhs = ctx.expr(1);
		
		String op = ctx.OP().getText();
		
		if(op.equals('+'))
			return visit(lhs) + visit(rhs);
		else if(op.equals('-'))
			return visit(lhs) - visit(rhs);
		else if(op.equals('*'))
			return visit(lhs) * visit(rhs);
		else if(op.equals('/'))
			return visit(lhs) / visit(rhs);
		
		return 0.0;
	}
	
	//=======================================================================================//
	
	public double eval(String line) {
		dbgStream.printf("Eval line: %s\n", line);
		
		ANTLRInputStream stream = new ANTLRInputStream(line);
		smathLexer lexer = new smathLexer(stream);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		
		smathParser parser = new smathParser(tokens);
		return this.visit(parser.expr());
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SmathEvaluator evaluator = new SmathEvaluator();
		evaluator.variableTable.put("pi", 3.1415926535897932384626433832795);
		
		while(sc.hasNextLine()) {
			System.out.println(evaluator.eval(sc.nextLine()));
		}
		
		sc.close();
	}
}
