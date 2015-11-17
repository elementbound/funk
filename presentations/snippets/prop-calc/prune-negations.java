public static String pruneNegationsOnNode(ParseTree node) {
	StringBuilder strb = new StringBuilder();
	
	if(node.getPayload() instanceof ParserRuleContext) {
		if(classifyNode(node) == RULE_NEGATION) {
			ParseTree subnode = extractNodes(node).get(0);
			
			if(classifyNode(subnode) == RULE_NEGATION) {
				strb.append(pruneNegationsOnNode(extractNodes(subnode).get(0)));
			}
			else 
				for(int i = 0; i < node.getChildCount(); i++)
					strb.append(pruneNegationsOnNode(node.getChild(i)));
		}
		else {
			for(int i = 0; i < node.getChildCount(); i++)
				strb.append(pruneNegationsOnNode(node.getChild(i)));
		}
	}
	else if(node.getPayload() instanceof Token) {
		Token t = (Token)node.getPayload();
		strb.append(t.getText()).append(' ');
	}
	
	return strb.toString();
}
