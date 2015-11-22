package funk;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;

import funk.antlr.funkLexer;
import funk.antlr.funkParser;
import funk.antlr.funkParser.AssignContext;
import funk.antlr.funkParser.IdContext;
import funk.antlr.funkParser.LiteralContext;
import funk.antlr.funkParser.MemberCallContext;
import jdk.nashorn.internal.ir.Assignment;

public class Interpreter {
	//Változók
	//Függvények
	
	public void execute(String code) {
		//Stringbõl fát építeni
		CharStream stream = new ANTLRInputStream(code);
		funkLexer lexer = new funkLexer(stream);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		
		funkParser parser = new funkParser(tokens);
		
		//Minden csomópontot kiértékelni:
		try{
			while(true) 
				eval(parser.statement());
		}
		catch(RecognitionException re) {
			//Silently stop
		}
		catch(Exception e) {
			e.printStackTrace(System.out);
		}
	}
	
	private Object eval(ParseTree node) {
		//Kideríteni hogy milyen szabályból jött: 
		//Ha id: 
		if(node instanceof IdContext) {
			//Megkeresni a változók közt az ID nevût és visszaadni
		}
		//Ha literal: 
		else if(node instanceof LiteralContext) {
			//Megnézni hogy milyen típusú és visszaadni a megfelelõ funk.Object-et
		}
		//Ha memberCall: 
		else if(node instanceof MemberCallContext) {
			//Kikeresni a függvények közt a megfelelõ függvényt
			//Kimásolni az arg-okat
			//Kiértékelni az arg-okat és az így kapott funk.Object-eket listába tenni
			//Átadni a listát a kikeresett függvénynek és visszaadni amit ad
		}
		//Ha ID '=' expr: 
		else if(node instanceof AssignContext) {
			//Kiértékelni expr-t
			//A kapott Object-et eltenni ID nevû változóként
			//A kapott Object-et visszaadni
		}
		else {
		//Ha expr '+' expr: 
			//Kiszedni a két expr-t
			//Mindkettõt kiértékelni
			//A két kapott Object-et összeadni Object.add-al
			//A kapott Object-et visszaadni
		}

		return new Object();
	}
}

class Utils {
	//Ide mehetnek majd az olyan utility függvények mint amik múltkor történtek
	//Pl. extractNodes, extractTokens, ilyesmik
	
	public static int classifyNode(ParseTree node) {
		ParserRuleContext ctx = (ParserRuleContext)node.getPayload();

		return 0;
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
}