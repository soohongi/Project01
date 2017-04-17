package practice;


import java.util.*;

class Character_02
{
	String name, kind;
	int level, value, frequency, sum;
	//LinkedHashMap jum = new LinkedHashMap();
	
	
	public Character_02(String kind, int level, String name, int value, int frequency) {
		super();
		this.kind = kind;
		this.level = level;
		this.name = name;
		this.value = value;
		this.frequency = frequency;
	}
}

 class Turn implements Comparator
{
	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		String str ="æ«¥Á, ø§«¡, ¿Œ∞£, ø¿≈©, √µªÁ, æ«∏∂";
		
		//int res = 1;
		
		Comparable me= (Comparable)o1;
		Comparable you= (Comparable)o2;
		
		System.out.println(you.compareTo(me));

		return you.compareTo(me);
		
		//return res;
	}

}


public class Hw_0315_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List data = new ArrayList();
		
		data.add(new Character("æ«∏∂", "KKK", 1, 1, 1));
		data.add(new Character("æ«¥Á", "AAA", 10, 10, 10));
		data.add(new Character("æ«¥Á", "BBB", 20, 20, 20));
		data.add(new Character("ø§«¡", "CCC", 30, 30, 30));
		data.add(new Character("ø§«¡", "DDD", 40, 40, 40));
		data.add(new Character("¿Œ∞£", "EEE", 50, 50, 50));
		data.add(new Character("¿Œ∞£", "FFF", 60, 60, 60));
		data.add(new Character("ø¿≈©", "GGG", 70, 70, 70));
		data.add(new Character("ø¿≈©", "HHH", 80, 80, 80));
		data.add(new Character("√µªÁ", "III", 90, 90, 90));
		data.add(new Character("√µªÁ", "JJJ", 99, 99, 99));
		
		TreeMap tr = new TreeMap(new Turn());
		
		for(Object ob: data) {
			TreeMap tr_1 = tr;
		}
		
		
		
		
		
	}

}
