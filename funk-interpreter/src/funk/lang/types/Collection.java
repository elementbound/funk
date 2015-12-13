package funk.lang.types;

import java.util.List;

import funk.lang.Object; 

public class Collection extends Object {
	//A Collection tulajdonképpen egy Map, csak meg van adva hogy milyen sorrendben tartja a kulcs-érték párjait
	//Elsõre úgy ahogy belepakolod Funk-ból, aztán lehet rendezgetni meg ilyesmi
	
	//A Collection tart magában egy mutatót is, iterálgatáshoz. Lásd a példában a for loopot rá. 
	//Valószínûleg csak elég egy index hogy hányadik kulcs-érték párnál tart. 
	//Ha közben módosul a tömb, nem baj ha a mutató fura helyekre mutat, ezt megoldani a user dolga. 
	
	@Override
	public boolean asBoolean() {
		// Ha üres akkor false, amúgy true
		return false;
	}

	@Override
	public java.lang.String asString() {
		// { Collection | kulcs: érték, kulcs: érték, ... }
		// Ha van kedved, írd meg az isArray-t, és ha array akkor csak sorolja fel az értékeket  
		return "{ Collection }";
	}
	
	public void put(Object key, Object value) {
		// Elteszi key-hez value-t 
	}
	
	public void add(Object key, Object value) {
		// Ugyanazt csinálja mint assignEmptyIndex
	}
	
	public Object get(Object key) {
		// Visszaadja kulcshoz tartozó Object-et, vagy null-t ha nincs 
		return null; 
	}
	
	public List<Object> keys() {
		// Visszaadja a kulcsokat
		return null;
	}
	
	public List<Object> values() {
		// Visszaadja az értékeket
		return null; 
	}
	
	public int size() { 
		// Visszaadja hogy hány kulcs-érték páros van a Collection-ben 
		return 0;
	}
	
	public boolean has(Object key) {
		// True ha van ilyen kulcs
		return false; 
	}
	
	public boolean hasValue(Object value) {
		//True ha van ilyen érték
		return false; 
	}
	
	public void rewind() {
		// Visszaállítja a mutatót nullára 
	}
	
	public boolean pastEnd() {
		// True-t ad ha már végigiteráltunk a kollekción és most épp egyel az utolsó kulcs-érték pár után vagyunk. 
		// Olyan mint C++-ban az end() függvény az utolsó utáni elemre ad iterátort 
		return false; 
	}
	
	public void next() {
		// Egyel odébb rakja a mutatót 
	}
	
	public Object key() {
		// Visszaadja a kulcsot a mutató alatt
		return null;
	}
	
	public Object value() {
		// Visszaadja az értéket a mutató alatt
		return null; 
	}
	
	@Override 
	public Object accessIndex(Object index) {
		// Kulcshoz tartozó érték, vagy UnknownIndex error ha nincs ilyen kulcs. 
		// Az UnknownIndex-et írd bele StandardErrors-ba, mint a többi error. 
		// Kapjon egy self és egy index mezõt. 
		return null;
	}

	@Override 
	public Object assignIndex(Object index, Object value) {
		//Csak simán elteszi index-hez value-t 
		return null;
	}
	
	@Override 
	public Object assignEmptyIndex(Object value) {
		//Ha üres a Collection, adja hozzá Number(0)-s indexszel
		//Ha nem, keresse meg a legnagyobb Number kulcsot, adjon hozzá egyet és azzal a kulccsal tegye el
		//Ha nincs Number kulcs, rakja el Number(0)-val. 
		
		//Visszaadja value-t 
		return null; 
	}
	
	@Override
	public Object opAdd(Object rhs) {
		// Alapjáraton képezze a két halmaz unióját - csináljon egy új Collection-t, pakolja bele this összes elemét, 
		// majd rhs-nek azon elemeit amelyek kulcsa még nem szerepel az eredményben
		
		// Ha van isArray(), akkor ha tömb, másolja le this-t és fûzze rhs-t a végére
		return null;
	}

	@Override
	public Object opSubtract(Object rhs) {
		// Meh. Csak adjon vissza egy IllegalOperation error-t. 
		return null;
	}

	@Override
	public Object opMultiply(Object rhs) {
		// IllegalOperation error
		return null;
	}

	@Override
	public Object opDivide(Object rhs) {
		// IllegalOperation error
		return null;
	}

	@Override
	public Object opNegate() {
		// IllegalOperation error
		return null;
	}

	@Override
	public boolean equals(Object rhs) {
		// Ha minden kulcs-érték pár egyezik, true, amúgy false. 
		return false;
	}

	@Override
	public boolean lowerThan(Object rhs) {
		// Rendezzen hossz szerint vagy csak simán false mert nincs értelmezve. Amelyik szimpi. 
		return false;
	}

	@Override
	public boolean greaterThan(Object rhs) {
		// Rendezzen hossz szerint vagy csak simán false mert nincs értelmezve. Amelyik szimpi. 
		return false;
	}

	public boolean isArray() {
		// Ha odaérsz :D Akkor számít egy Collection tömbnek, ha a kulcsai csakis természetes számok ( nulla beleszámítva )
		// és nincsen köztük kihagyás 
		// Ezt igazából helyben is le lehet ellenõrizni, de azt is csinálhatod h tartasz egy boolean változót, és ha változtatják 
		// a collection-t, állítod a flag-et. Igazából csak assignIndex-nél kell ezt elvégezni, hogy számot pakolnak-e bele, 
		// természetes szám-e, és hogy az új indexszel nincs-e kihagyás. 
		// Szal ha az n kulcs amire assign-ol, az természetes szám, akkor meg kell nézni hogy az nulla, vagy létezik-e az n-1 
		// kulcsra érték. 
		return false; 
	}
}
