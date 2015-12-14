package funk.lang.types;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import funk.lang.StandardErrors;


import funk.lang.Object; 

public class Collection extends Object {
	//A Collection tulajdonk�ppen egy Map, csak meg van adva hogy milyen sorrendben tartja a kulcs-�rt�k p�rjait
	//Els�re �gy ahogy belepakolod Funk-b�l, azt�n lehet rendezgetni meg ilyesmi
	Map<Object,Object> collection = new TreeMap<Object,Object>();
	int iterator=0;
	//A Collection tart mag�ban egy mutat�t is, iter�lgat�shoz. L�sd a p�ld�ban a for loopot r�. 
	//Val�sz�n�leg csak el�g egy index hogy h�nyadik kulcs-�rt�k p�rn�l tart. 
	//Ha k�zben m�dosul a t�mb, nem baj ha a mutat� fura helyekre mutat, ezt megoldani a user dolga. 
	
	@Override
	public boolean asBoolean() {
		if(!collection.isEmpty())
			return true;
		
		return false;
	}

	@Override
	public java.lang.String asString() {
		// { Collection | kulcs: �rt�k, kulcs: �rt�k, ... }
		// Ha van kedved, �rd meg az isArray-t, �s ha array akkor csak sorolja fel az �rt�keket
		return "{ Collection }";
	}
	
	public void put(Object key, Object value) {
		// Elteszi key-hez value-t 
		collection.put(key, value);
	}
	
	public void add(Object key, Object value) {
		// Ugyanazt csin�lja mint assignEmptyIndex
	}
	
	public Object get(Object key) {
		
		return collection.get(key); 
	}
	
	public List<Object> keys() {
		// Visszaadja a kulcsokat
		List<Object> returnList= new ArrayList<Object>();
		
		for(Map.Entry<Object,Object> entry : collection.entrySet())
			returnList.add(entry.getKey());
			
		return returnList;
	}
	
	public List<Object> values() {
		// Visszaadja az �rt�keket
		List<Object> returnList= new ArrayList<Object>();
		
		for(Map.Entry<Object,Object> entry : collection.entrySet())
			returnList.add(entry.getValue());
		
		return returnList; 
	}
	
	public int size() { 
		// Visszaadja hogy h�ny kulcs-�rt�k p�ros van a Collection-ben 
		return collection.size();
	}
	
	public boolean has(Object key) {
		// True ha van ilyen kulcs
		return collection.containsKey(key); 
	}
	
	public boolean hasValue(Object value) {
		//True ha van ilyen �rt�k
		return collection.containsValue(value); 
	}
	
	public void rewind() {
		// Vissza�ll�tja a mutat�t null�ra 
		iterator=0;
	}
	
	public boolean pastEnd() {
		// True-t ad ha m�r v�gigiter�ltunk a kollekci�n �s most �pp egyel az utols� kulcs-�rt�k p�r ut�n vagyunk. 
		// Olyan mint C++-ban az end() f�ggv�ny az utols� ut�ni elemre ad iter�tort 
		if(iterator>collection.size()-1)
			return true;
		
		return false; 
	}
	
	public void next() {
		// Egyel od�bb rakja a mutat�t 
		iterator++;
	}
	
	public Object key() {
		// Visszaadja a kulcsot a mutat� alatt
		Object key = (Object) collection.keySet().toArray()[iterator];

		return key;
	}
	
	public Object value() {
		// Visszaadja az �rt�ket a mutat� alatt
		Object key = (Object) collection.keySet().toArray()[iterator];
		Object value=collection.get(key);
		
		return value; 
	}
	
	@Override 
	public Object accessIndex(Object index) {
		// Kulcshoz tartoz� �rt�k, vagy UnknownIndex error ha nincs ilyen kulcs. 
		// Az UnknownIndex-et �rd bele StandardErrors-ba, mint a t�bbi error. 
		// Kapjon egy self �s egy index mez�t. 
		if(!has(index))
			return StandardErrors.UnknownIndexError(index, this);
		
		return collection.get(index);
	}

	@Override 
	public Object assignIndex(Object index, Object value) {
		//Csak sim�n elteszi index-hez value-t 
		collection.put(index, value);
		
		return value;// I dk
	}
	
	@Override 
	public Object assignEmptyIndex(Object value) {
		//Ha �res a Collection, adja hozz� Number(0)-s indexszel
		//Ha nem, keresse meg a legnagyobb Number kulcsot, adjon hozz� egyet �s azzal a kulccsal tegye el
		//Ha nincs Number kulcs, rakja el Number(0)-val. 
	
		Number maxNumber= new Number(0);
		for(Map.Entry<Object,Object> entry : collection.entrySet())
				if(entry.getKey() instanceof Number ){ 
					Number num= (Number )entry.getKey();
					
					if(num.value>maxNumber.value)
						maxNumber=(Number) entry.getKey();
				}
				
		collection.put(maxNumber, value);
		
		//Visszaadja value-t 
		return value; 
	}
	
	@Override
	public Object opAdd(Object rhs) {
		// Alapj�raton k�pezze a k�t halmaz uni�j�t - csin�ljon egy �j Collection-t, pakolja bele this �sszes elem�t, 
		// majd rhs-nek azon elemeit amelyek kulcsa m�g nem szerepel az eredm�nyben
		Collection result = this;
		
		if(rhs instanceof Collection){
			Collection rColl= (Collection) rhs;
			if(rColl.isArray()){
				result=this;
				for(Map.Entry<Object,Object> entry : rColl.collection.entrySet())
					result.add(entry.getKey(), entry.getValue());
			}
			else
				for(Map.Entry<Object,Object> entry : rColl.collection.entrySet()){
					if(result.hasValue(entry.getKey()))
						result.add(entry.getKey(), entry.getValue());
			}
			
		}else 
			return StandardErrors.IllegalOperation("opAdd", this);
		
		// Ha van isArray(), akkor ha t�mb, m�solja le this-t �s f�zze rhs-t a v�g�re
		
		return result;
	}

	@Override
	public Object opSubtract(Object rhs) {
		// Meh. Csak adjon vissza egy IllegalOperation error-t. 
		return StandardErrors.IllegalOperation("opAdd", this);
	}

	@Override
	public Object opMultiply(Object rhs) {
		// IllegalOperation error
		return StandardErrors.IllegalOperation("opAdd", this);
	}

	@Override
	public Object opDivide(Object rhs) {
		// IllegalOperation error
		return StandardErrors.IllegalOperation("opAdd", this);
	}

	@Override
	public Object opNegate() {
		// IllegalOperation error
		return StandardErrors.IllegalOperation("opAdd", this);
	}

	@Override
	public boolean equals(Object rhs) {
		// Ha minden kulcs-�rt�k p�r egyezik, true, am�gy false. 
		if(rhs instanceof Collection){
			Collection rColl= (Collection)rhs;
			//THIS
			for(Map.Entry<Object,Object> entry : rColl.collection.entrySet())
				if(!collection.containsKey(entry.getKey()) || 
						!collection.get(entry.getKey()).equals(entry.getValue()))
					return false;
			
			for(Map.Entry<Object,Object> entry : collection.entrySet())
				if(!rColl.collection.containsKey(entry.getKey()) || 
						!rColl.collection.get(entry.getKey()).equals(entry.getValue()))
					return false;
			
			return true;
		}
			
		return false;
	}

	@Override
	public boolean lowerThan(Object rhs) {
		// Rendezzen hossz szerint vagy csak sim�n false mert nincs �rtelmezve. Amelyik szimpi. 
		if(rhs instanceof Collection){
			Collection rColl=(Collection) rhs;
			if(collection.size()<rColl.collection.size())
				return true;
		}
		
		return false;
	}

	@Override
	public boolean greaterThan(Object rhs) {
		// Rendezzen hossz szerint vagy csak sim�n false mert nincs �rtelmezve. Amelyik szimpi.
		if(rhs instanceof Collection){//azert nem a lowerthant hivom mert lehet egyenlo is
			Collection rColl=(Collection) rhs;
			
			if(collection.size()>rColl.collection.size())
				return true;
		}
		
		return false;
	}

	public boolean isArray() {
		// Ha oda�rsz :D Akkor sz�m�t egy Collection t�mbnek, ha a kulcsai csakis term�szetes sz�mok ( nulla belesz�m�tva )
		// �s nincsen k�zt�k kihagy�s 
		// Ezt igaz�b�l helyben is le lehet ellen�rizni, de azt is csin�lhatod h tartasz egy boolean v�ltoz�t, �s ha v�ltoztatj�k 
		// a collection-t, �ll�tod a flag-et. Igaz�b�l csak assignIndex-n�l kell ezt elv�gezni, hogy sz�mot pakolnak-e bele, 
		// term�szetes sz�m-e, �s hogy az �j indexszel nincs-e kihagy�s. 
		// Szal ha az n kulcs amire assign-ol, az term�szetes sz�m, akkor meg kell n�zni hogy az nulla, vagy l�tezik-e az n-1 
		// kulcsra �rt�k. 
		
		
		return false; 
	}
}
