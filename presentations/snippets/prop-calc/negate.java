public static String negate(String str) {
	StringBuilder strb = new StringBuilder();
	return strb.append("( ! ").append(str).append(") ").toString(); 
}

// vs. 

public static void negateNode(ParseTree node, PrintStream out) {
	out.print("( ! ");
	
	//De mi van ha én mást akarok csinálni? 
	atomizeNegationsOnNode(node, out);
	
	out.print(") ");
}
