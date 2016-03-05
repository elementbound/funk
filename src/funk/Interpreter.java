package funk;

import java.io.PrintStream;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import funk.antlr.funkBaseVisitor;
import funk.antlr.funkLexer;
import funk.antlr.funkParser;
import funk.antlr.funkParser.ArgsContext;
import funk.antlr.funkParser.ConstructorContext;
import funk.antlr.funkParser.ExprContext;
import funk.antlr.funkParser.StatementContext;
import funk.lang.ICastRule;
import funk.lang.IFunction;
import funk.lang.ILibrary;
import funk.lang.Object;
import funk.lang.StandardErrors;
import funk.lang.cast.BooleanToNumber;
import funk.lang.func.Pow;
import funk.lang.func.Print;
import funk.lang.func.Println;
import funk.lang.func.Reverse;
import funk.lang.func.Substr;
import funk.lang.func.TypeMatch;
import funk.lang.func.TypeString;
import funk.lang.func.UserFunc;
import funk.lang.types.Aggregate;
import funk.lang.types.Boolean;
import funk.lang.types.Collection;
import funk.lang.types.Error;
import funk.lang.types.Generic;
import funk.lang.types.Number; 

public class Interpreter extends funkBaseVisitor<Object> {
	public boolean local=false;
	
	//Valtozok
	public List<SymbolTable> variableTable= new ArrayList<SymbolTable>();
	
	//Fuggvenyek
	public List<Entry<String, IFunction>> functionTable = new ArrayList<>();
	
	//�tv�lt�si szab�lyok
	public List<ICastRule<?,?>> castRules = new ArrayList<>();
	
	//Ismert t�pusok
	public Map<String, Object> typeTable = new HashMap<>();
	
	//T�pusok k�zti �r�kl�d�s 
	//Minden t�pushoz hozz�rendeli a sz�l�j�t 
	public Map<String, String> inheritanceTable = new HashMap<>();
	
	//Debug stream
	public PrintStream dbgStream = new PrintStream(new NullOutputStream());
	
	//Erro stream 
	public PrintStream errorStream = new PrintStream(System.out);
	
	private static Object defaultResult = new Error("void");
	private Object queuedReturn = null; 
	
	public Interpreter(){
		registerFunction("reverse", new Reverse());
		registerFunction("substr", new Substr(1));
		registerFunction("substr", new Substr(2));
		registerFunction("pow", new Pow());
		
		registerFunction("print", new Print());
		registerFunction("println", new Println());
		
		registerFunction("typeString", new TypeString());
		registerFunction("typeMatch", new TypeMatch());
		
		this.enterScope(); //variableTable.push(new SymbolTable());
		
		registerType("?", Generic.instance); 
		registerType("Boolean", new Boolean());
		registerType("Number", new Number()); 
		registerType("String", new funk.lang.types.String());
		registerType("Error", new Error("void")); 
		registerType("Collection", new Collection());
		
		castRules.add(new BooleanToNumber());
		
		this.loadLibrary(new funk.lib.lang.MathLibrary());
		this.loadLibrary(new funk.lib.lang.CollectionLibrary());
		this.loadLibrary(new funk.lib.lang.RuntimeLibrary());
		this.loadLibrary(new funk.lib.Random.Library());
		
		this.dumpFunctions(dbgStream);
	}
	
	public void loadLibrary(ILibrary lib) {
		lib.inject(this);
	}
	
	//=========================================================================================
	//Functions 

	public void registerFunction(String name, IFunction func) {
		functionTable.add(new SimpleEntry<>(name, func));
	}
	
	public void dumpFunctions(PrintStream out) {
		out.println("Known functions: ");
		
		for(Entry<String, IFunction> p : functionTable) {
			String name = p.getKey();
			IFunction func = p.getValue();
			
			out.printf("\t %s . %s ( %d )\n", func.expectedSelfType().typeString(), name, func.expectedArgumentCount());
		}
	}
	
	public boolean hasFunction(String name, Object selfType, int argCount) {
		for(Entry<String, IFunction> e : functionTable) {
			String n = e.getKey();
			IFunction f = e.getValue();
			
			if(!n.equals(name))
				continue; 
			
			if(!f.expectedSelfType().typesMatch(selfType))
				continue; 
			
			if(f.expectedArgumentCount() != argCount)
				continue;
			
			return true;
		}
		
		return false;
	}
	
	private IFunction getFunction(String name, Object selfType, int argCount) {
		for(Entry<String, IFunction> e : functionTable) {
			String n = e.getKey();
			IFunction f = e.getValue();
			
			if(!n.equals(name))
				continue; 
			
			if(!f.expectedSelfType().typesMatch(selfType))
				continue; 
			
			if(f.expectedArgumentCount() != argCount)
				continue;
			
			return f;
		}
		
		return null;
	}
	
	public IFunction lookupFunction(String name, Object selfType, int argCount) {
		IFunction result; 
		
		//First, try a lookup to the exact type, or parent
		for(String type = selfType.typeString(); type != null; type = getTypeParent(type)) {
			result = this.getFunction(name, this.getType(type), argCount);
			if(result != null)
				return result; 
		}
		
		//If it fails, try to find a generic function
		result = this.getFunction(name, this.getType("?"), argCount);
		if(result != null)
			return result;
		
		//If everything fails, return null
		return null;
	}
	
	public List<String> listFunctionNames() {
		List<String> result = new ArrayList<>();
		
		for(Entry<String, IFunction> e : functionTable)
			result.add(e.getKey());
		
		return result;
	}
	
	public boolean hasReturn() {
		return queuedReturn != null;
	}
	
	public Object returnValue() {
		Object res = queuedReturn;
		queuedReturn = null;
		
		return res; 
	}
	
	//=========================================================================================
	//Types 
	
	public void registerType(String name, Object type) {
		typeTable.put(name, type);
	}
	
	public void registerInheritance(String child, String parent) {
		inheritanceTable.put(child, parent);
	}
	
	public Object getType(String typeName) {
		return typeTable.get(typeName);
	}
	
	public String getTypeParent(String typeName) {
		return inheritanceTable.get(typeName);
	}
	
	public Object getTypeInstance(String typeName) {
		Object type = getType(typeName); 
		if(type == null)
			return StandardErrors.UnknownType(typeName);
		else
			try {
				return type.construct();
			} catch (InstantiationException | IllegalAccessException e) {
				return StandardErrors.FailedInstantiation(typeName);
			}
	}
	
	public List<String> listTypeNames() {
		return new ArrayList<>(typeTable.keySet());
	}
	
	//=========================================================================================
	//Variables
	
	Map<String,Object> getAllTable(){
		Map<String, Object> temp= new HashMap<>();
		
		for(SymbolTable table: variableTable)
			temp.putAll(table.table);

		return temp;
	}
	
	public boolean hasVariable(String key){
		Map<String, Object> temp= getAllTable();
		
		return temp.containsKey(key);
	}
	
	public Object getVariable(String key) {
		Map<String, Object> temp= getAllTable();
		
		return temp.get(key);
	}
	
	public void setLocalVariable(String key, Object val){
		variableTable.get(variableTable.size()-1).set(key, val);
	}
	
	public void setExistingVariable(String key, Object val) {
		for(int i=0;i<variableTable.size();i++)
			if(variableTable.get(i).exists(key)){
				variableTable.get(i).set(key, val);
				return ;	
			}
		
		setLocalVariable(key, val);
	}
	
	public void enterScope() {
		variableTable.add(new SymbolTable());
	}
	
	public boolean exitScope() {
		if(variableTable.size() != 1) {
			variableTable.remove(variableTable.size()-1);
			return true;
		}
		else 
			return false; 
	}
	
	public List<String> listVariableNames() {
		return new ArrayList<>(getAllTable().keySet());
	}
	
	public void dumpVariables(PrintStream out) {
		for(Entry<String, Object> p : getAllTable().entrySet()) 
			out.printf("%s: %s;\n", p.getKey(), p.getValue().toString());
	}
	
	//=========================================================================================
	// Cast
	
	public Object cast(Object from, Class<?> to) {
		if(to.equals(from.getClass()))
			return from; 
		
		if(to.equals(Boolean.class))
			return new Boolean(from.asBoolean());

		if(to.equals(funk.lang.types.String.class))
			return new funk.lang.types.String(from.asString());
		
		for(ICastRule<?,?> rule : castRules) 
			if(rule.from().equals(from.getClass()) && rule.to().equals(to))
				return (Object) rule.cast(from);
		
		return StandardErrors.IllegalCast(from, to);
	}
	
	//=========================================================================================
	
	public void execute(String code) throws RecognitionException {
		//Stringbol fat epiteni
		CharStream stream = new ANTLRInputStream(code);
		funkLexer lexer = new funkLexer(stream);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		
		funkParser parser = new funkParser(tokens);
		
		//Minden utasitast kiertekelni:
		try {
			for(ParseTree node = parser.statement(); 
					!node.getText().startsWith("<EOF>") && !node.getText().trim().equals("");
					node = parser.statement()) {
				Object result = visit(node);
				if(queuedReturn != null) 
					break;
				
				dbgStream.printf("Visiting %s\n", node.getText());
				dbgStream.printf("Return: %s\n", result.toString());
			}
		}
		catch(RecognitionException e) {
			if(e.getOffendingToken().getText().equals("<EOF>"))
				return; 
			
			StringBuilder strb = new StringBuilder();
			strb.append("Got token ").append(e.getOffendingToken().getText()).append(";\n");
			strb.append("Expected: ");

			for(int t : e.getExpectedTokens().toList()) {
				strb.append('\n').append(funkParser.VOCABULARY.getDisplayName(t));
			}
			
			errorStream.println(strb);
			errorStream.printf("Node text: \"%s\"\n", e.getCtx().getText().trim());
			errorStream.printf("Error at %s\n", e.getCtx().getSourceInterval());
			
			e.printStackTrace(); 
			//Silently continue
		}
		catch(Exception ex) { 
			ex.printStackTrace(errorStream);
		}
	}
	
	//=========================================================================================
	//Visitor methods
	
	@Override 
	public Object defaultResult() {
		return defaultResult;
	}
	
	@Override 
	public Object aggregateResult(Object aggregate, Object next) {
		if(aggregate == defaultResult) {
			//dbgStream.printf("Aggregating null and %s; returning %s\n", next, next);
			return next;
		}
		else {
			//dbgStream.printf("Aggregating %s and null; returning %s\n", aggregate, aggregate);
			return aggregate;
		}
	}
	
	@Override
	public Object visitChildren(RuleNode node) {
		dbgStream.printf("Visiting node: %s\n", node.getText());
		dbgStream.printf("Rule: %s\n", funkParser.ruleNames[node.getRuleContext().getRuleIndex()]);
		dbgStream.printf("Context type: %s\n\n", node.getRuleContext().getClass().getName());
		
		if(queuedReturn != null) 
			return queuedReturn;
		
		Object result = super.visitChildren(node);
		
		if(result instanceof Error) 
			((Error)result).prettyPrint(errorStream);
		
		return result;
	}
	
	@Override 
	public Object visitEnclosedExpr(funkParser.EnclosedExprContext ctx) {
		dbgStream.printf("Enclosed expr: %s\n", ctx.getText());
		return visit(ctx.expr());
	}
	
	@Override 
	public Object visitID(funkParser.IDContext ctx) {
		String id = ctx.ID().getText();
		
		dbgStream.printf("id: %s\n", id);
		
		if(!this.hasVariable(id))
			return StandardErrors.UnknownVariable(id); 
		
		return getVariable(id);
	}
	
	@Override 
	public Object visitNumberLiteral(funkParser.NumberLiteralContext ctx) {
		dbgStream.printf("Number literal: %s\n", ctx.getText());
		
		return new Number(Double.parseDouble(ctx.NUMBER().getText()));
	}
	
	@Override
	public Object visitStringLiteral(funkParser.StringLiteralContext ctx) {
		dbgStream.printf("String literal: %s\n", ctx.getText());
		
		String str = ctx.STRING().getText();
		str = str.substring(1, str.length()-1);
		
		return new funk.lang.types.String(str);
	}
	
	@Override
	public Object visitConstructor(ConstructorContext ctx) {
		return this.getTypeInstance(ctx.ID().getText());
	}
	
	@Override 
	public Object visitBooleanLiteral(funkParser.BooleanLiteralContext ctx) {
		if(ctx.BOOLEAN().getText().equals("True"))
			return new Boolean(true);
		else if(ctx.BOOLEAN().getText().equals("False"))
			return new Boolean(false);
		else 
			return StandardErrors.WrongLiteral("Boolean", ctx.BOOLEAN().getText());
	}
	
	@Override 
	public Object visitUnaryOp(funkParser.UnaryOpContext ctx) {
		dbgStream.printf("Unary op: %s\n", ctx.getText());
		
		String op = ctx.OP().getText();
		ExprContext expr = ctx.expr();
		
		if(op.equals("+"))
			return visit(expr);
		else if(op.equals("-"))
			return visit(expr).opNegate(); 
		else 
			return StandardErrors.UnknownUnaryOperator(op);
	}
	
	@Override 
	public Object visitBinaryOp(funkParser.BinaryOpContext ctx) {
		dbgStream.printf("Binary op: %s\n", ctx.getText());
		
		//Kiszedni a ket expr-t es az operatort
		ExprContext lhsExpr = ctx.expr(0);
		ExprContext rhsExpr = ctx.expr(1);
		String operator = ctx.OP().getText();
		
		dbgStream.printf("%s %s %s\n", lhsExpr.getText(), operator, rhsExpr.getText());
		
		Object lhs = visit(lhsExpr);
		Object rhs = visit(rhsExpr);

		//Try applying operator with original types
		Object result = this.evalBinaryOp(operator, lhs, rhs);
		if(!(result instanceof Error))
			return result; 
		
		//If that fails, try casting to lhs type 
		rhs = this.cast(rhs, lhs.getClass());
		if(rhs instanceof Error)
			return rhs; 
		
		return this.evalBinaryOp(operator, lhs, rhs);
	}
	
	public Object evalBinaryOp(String operator, Object lhs, Object rhs) {
		if(operator.equals("+")) 
			return lhs.opAdd(rhs);
		else if(operator.equals("-")) 
			return lhs.opSubtract(rhs);
		else if(operator.equals("*")) 
			return lhs.opMultiply(rhs);
		else if(operator.equals("/")) 
			return lhs.opDivide(rhs);
		else if(operator.equals("==")) 
			return lhs.opEquals(rhs);
		else if(operator.equals("!=")) 
			return lhs.opNotEquals(rhs);
		else if(operator.equals("<")) 
			return lhs.opLowerThan(rhs);
		else if(operator.equals(">")) 
			return lhs.opGreaterThan(rhs);
		else
			return StandardErrors.UnknownBinaryOperator(operator);
	}
	
	@Override 
	public Object visitMemberCall(funkParser.MemberCallContext ctx) {
		dbgStream.printf("Member call: %s\n", ctx.getText());
		
		ExprContext selfExpr = ctx.expr();
		String functionName = ctx.ID().getText();
		ArgsContext args = ctx.args();
		
		dbgStream.printf("Function call: %s . %s(...)\n", selfExpr.getText(), functionName);

		Object selfObject = visit(selfExpr);
		List<Object> argObjects = new ArrayList<>();
		for(ExprContext arg : args.expr()) 
			argObjects.add(visit(arg));
		
		IFunction function = lookupFunction(functionName, selfObject, argObjects.size());//getFunction(functionName, argObjects.size());
		if(function == null) 
			return StandardErrors.UnknownFunction(functionName, selfObject, argObjects.size());
		
		//Pass as varargs
		return function.call(this, selfObject, argObjects.toArray(new Object[argObjects.size()]));
	}
	
	@Override 
	public Object visitAssign(funkParser.AssignContext ctx) {
		String id = ctx.ID().getText();
		ExprContext expr = ctx.expr();
		
		if(ctx.LOCAL()!=null)
			local=true;
		
		dbgStream.printf("Assignment: %s = %s\n", id, expr.getText());
		
		//Kiertekelni expr-t
		Object result = visit(expr);
		
		//A kapott Object-et eltenni ID neve valtozokent
		if(local)
			setLocalVariable(id, result);
		else 
			setExistingVariable(id, result);
		
		dbgStream.printf("Saved variable: %s = %s\n", id, result);
		
		//A kapott Object-et visszaadni
		dbgStream.printf("Returning from assign: %s\n", result);
		local=false;
		return result; 
	}
	
	@Override 
	public Object visitReturnStatement(funkParser.ReturnStatementContext ctx) {
		queuedReturn = visit(ctx.expr());
		return queuedReturn;
	}
	
	@Override
	public Object visitIfThenElse(funkParser.IfThenElseContext ctx) {
		ExprContext expr = ctx.expr();
		StatementContext thenScope = ctx.statement(0);
		StatementContext elseScope = null;
		if(ctx.statement().size() >= 1)
			elseScope = ctx.statement(1);

		if(elseScope != null)
			dbgStream.printf("if( %s ) then %s else %s\n", expr.getText(), thenScope.getText(), elseScope.getText());
		else
			dbgStream.printf("if( %s ) then %s\n", expr.getText(), thenScope.getText());
		
		if(visit(expr).asBoolean())
			return visit(thenScope);
		else
			if(elseScope != null)
				return visit(elseScope);
			else
				return new Boolean(false);
	}
	
	@Override
	public Object visitForLoop(funkParser.ForLoopContext ctx) {
		ExprContext initNode = ctx.expr(0);
		ExprContext conditionNode = ctx.expr(1);
		ExprContext stepNode = ctx.expr(2);
		StatementContext scopeNode = ctx.statement();
		
		Object result;
		
		result = visit(initNode);
		while(visit(conditionNode).asBoolean()) {
			result = visit(scopeNode);
			visit(stepNode);
		}
		
		return result; 
	}
	
	@Override
	public Object visitBlock(funkParser.BlockContext ctx) {
		dbgStream.printf("Block: %s\n", ctx.getText());
		
		this.enterScope(); //variableTable.push(new SymbolTable());
		
		Object result = new Boolean();
		for(ParseTree n : ctx.statement())
			result = visit(n);
		
		this.exitScope(); //variableTable.pop();
		
		return result; 
	}
	
	@Override 
	public Object visitAggregateDecl(funkParser.AggregateDeclContext ctx) {
		String typeName = ctx.ID(0).getText();
		String baseTypeName = null; 
		Object baseType = null;
		
		int firstFieldId = 1;
		
		if(ctx.baseType != null) {
			baseTypeName = ctx.baseType.getText();
			baseType = this.getType(baseTypeName);
			if(baseType == null)
				return StandardErrors.UnknownType(baseTypeName);
			
			if(!(baseType instanceof Aggregate))
				return StandardErrors.InvalidInheritance(baseTypeName);
			
			firstFieldId = 2;
		}
		
		Aggregate type = new Aggregate(typeName);
		for(int i = firstFieldId; i < ctx.ID().size(); i++)
			type.addField(ctx.ID(i).getText());
		
		if(baseType != null) {
			type.inheritFields((Aggregate) baseType);
			registerInheritance(typeName, baseTypeName);
		}
		
		registerType(typeName, type);
		
		return type;
	}
	
	@Override 
	public Object visitMemberAccess(funkParser.MemberAccessContext ctx) {
		Object self = visit(ctx.expr());
		String id = ctx.ID().getText();
		IFunction functionCandidate = this.lookupFunction(id, self, 0);
		
		if(!(self instanceof Aggregate))
			if(functionCandidate != null)
				return functionCandidate.call(this, self);
			else
				return StandardErrors.IllegalOperation("memberAccess", self);

		Aggregate selfCast = (Aggregate) self;
		
		if(selfCast.hasField(id)) 
			return selfCast.getField(id);
		else if(functionCandidate != null) 
			return functionCandidate.call(this, self);
		else 
			return StandardErrors.UnknownField(id, selfCast);
	}
	
	@Override
	public Object visitMemberAssign(funkParser.MemberAssignContext ctx) {
		Object self = visit(ctx.expr(0));
		String id = ctx.ID().getText();
		IFunction functionCandidate = this.lookupFunction(id, self, 1);
		Object assign = visit(ctx.expr(1));
		
		if(!(self instanceof Aggregate))
			if(functionCandidate != null)
				return functionCandidate.call(this, self, assign);
			else
				return StandardErrors.IllegalOperation("memberAssign", self);
		
		Aggregate selfCast = (Aggregate) self; 
		
		
		
		if(selfCast.hasField(id))
			return selfCast.setField(id, assign);
		else if(functionCandidate != null)
			return functionCandidate.call(this, self, assign);
		else 
			return StandardErrors.UnknownField(id, selfCast);
	}
	
	@Override 
	public Object visitIndexAccess(funkParser.IndexAccessContext ctx) {
		Object self = this.visit(ctx.expr(0));
		Object index = this.visit(ctx.expr(1));
		
		return self.accessIndex(index);
	}
	
	@Override 
	public Object visitIndexAssign(funkParser.IndexAssignContext ctx) {
		Object self = this.visit(ctx.expr(0));

		if(ctx.expr().size() == 2) {
			Object assign = this.visit(ctx.expr(1));
			
			return self.assignEmptyIndex(assign);
		}
		else {
			Object index = this.visit(ctx.expr(1));
			Object assign = this.visit(ctx.expr(2));
			
			return self.assignIndex(index, assign);
		}
	}
	
	@Override 
	public Object visitSingleTypeFunctionDecl(funkParser.SingleTypeFunctionDeclContext ctx) {
		String typeName = ctx.ID(0).getText();
		String functionName = ctx.ID(1).getText();
		List<String> argNames = new ArrayList<>();
		
		if(getType(typeName) == null)
			return StandardErrors.UnknownType(typeName);
		
		for(TerminalNode t : ctx.argsProto().ID())
			argNames.add(t.getText());
		
		registerFunction(functionName, new UserFunc(getType(typeName), argNames, ctx.statement()));
		
		return new Boolean(true);
	}
	
	@Override
	public Object visitMultipleTypeFunctionDecl(funkParser.MultipleTypeFunctionDeclContext ctx) {
		List<String> attachedTypes = new ArrayList<>();
		String functionName = ctx.ID().getText();
		List<String> argNames = new ArrayList<>();
		
		for(TerminalNode t : ctx.typesProto().ID())
			attachedTypes.add(t.getText());
		
		for(TerminalNode t : ctx.argsProto().ID())
			argNames.add(t.getText());
		
		for(String type : attachedTypes) {
			if(getType(type) == null)
				return StandardErrors.UnknownType(type);
			
			registerFunction(functionName, new UserFunc(getType(type), argNames, ctx.statement()));
		}
		
		return new Boolean(true);
	}
	
	@Override 
	public Object visitGenericTypeFunctionDecl(funkParser.GenericTypeFunctionDeclContext ctx) {
		String functionName = ctx.ID().getText();
		List<String> argNames = new ArrayList<>();
		
		for(TerminalNode t : ctx.argsProto().ID())
			argNames.add(t.getText());
		
		registerFunction(functionName, new UserFunc(null, argNames, ctx.statement()));
		
		return new Boolean(true);
	}
	
	@Override
	public Object visitComment(funkParser.CommentContext ctx) {
		//Nincs nagyon dolgunk vele, de mivel mindig vissza kell dobjunk egy Object-et, 
		//visszadobjuk magat a szoveget
		dbgStream.printf("Comment: %s\n", ctx.COMMENT().getText());
		return new funk.lang.types.String(ctx.COMMENT().getText());
	}
}