package funk;

public class Interpreter {
	//Változók
	//Függvények
	
	public void execute(String code) {
		//Stringbõl fát építeni
		
		//Minden csomópontot kiértékelni:
			//eval(node)
	}
	
	private Object eval(/* ParserTree node */) {
		//Kideríteni hogy milyen szabályból jött: 
		//Ha id: 
			//Megkeresni a változók közt az ID nevût és visszaadni
		
		//Ha literal: 
			//Megnézni hogy milyen típusú és visszaadni a megfelelõ funk.Object-et
		
		//Ha memberCall: 
			//Kikeresni a függvények közt a megfelelõ függvényt
			//Kimásolni az arg-okat
			//Kiértékelni az arg-okat és az így kapott funk.Object-eket listába tenni
			//Átadni a listát a kikeresett függvénynek és visszaadni amit ad
		
		//Ha expr '+' expr: 
			//Kiszedni a két expr-t
			//Mindkettõt kiértékelni
			//A két kapott Object-et összeadni Object.add-al
			//A kapott Object-et visszaadni
		
		//Ha ID '=' expr: 
			//Kiértékelni expr-t
			//A kapott Object-et eltenni ID nevû változóként
			//A kapott Object-et visszaadni

		return new Object();
	}
}

class Utils {
	//Ide mehetnek majd az olyan utility függvények mint amik múltkor történtek
	//Pl. extractNodes, extractTokens, ilyesmik
}