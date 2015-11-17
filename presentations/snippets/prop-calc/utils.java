//=========================================================================================
// Node utils 

public static final int RULE_ATOM = 0;
public static final int RULE_NEGATION = 1;
public static final int RULE_BINARY_OP = 2;
public static final int RULE_EXPR = 3;

public static int classifyNode(ParseTree node) {
	ParserRuleContext ctx = (ParserRuleContext)node.getPayload();

	if(ctx.getToken(logicParser.NEG, 0) != null)
		return RULE_NEGATION; 
	else if(ctx.getToken(logicParser.OP,0) != null)
		return RULE_BINARY_OP; 
	else if(ctx.getToken(logicParser.ATOM, 0) != null)
		return RULE_ATOM; 
	else 
		return RULE_EXPR; 
}

public static List<ParseTree> extractNodes(ParseTree node) {
	List<ParseTree> ret = new ArrayList<>();
	
	for(int i = 0; i < node.getChildCount(); i++)
	{
		ParseTree c = node.getChild(i);
		if(c.getPayload() instanceof ParserRuleContext)
			ret.add(c);
	}
	
	return ret; 
}

public static List<Token> extractTokens(ParseTree node) {
	List<Token> ret = new ArrayList<Token>();
	
	for(int i = 0; i < node.getChildCount(); i++)
	{
		ParseTree c = node.getChild(i);
		if(c.getPayload() instanceof Token)
			ret.add((Token)c.getPayload());
	}
	
	return ret; 
}

public static String negate(String str) {
	StringBuilder strb = new StringBuilder();
	return strb.append("( ! ").append(str).append(") ").toString(); 
}
