package practice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;


class Character
{
	String name, kind1;
	int level, value, frequency, sum;
	LinkedHashMap jum = new LinkedHashMap();
	LinkedHashMap kind = new LinkedHashMap();
	
	
	public Character(String kind1, String name, int level, int value, int frequency) {
		super();
		
		kind.put("전체", "전체");
		kind.put("종족", kind1);
		this.name = name;
		this.kind1 = kind1;
		jum.put("level",level);
		jum.put("value",value);
		jum.put("frequency",frequency);
		if(kind1=="합계")
			this.name = "합계";
		
		cal();
	}
	
	void cal()
	{
		sum = 0;
		Collection vv = jum.values();
		
		for (Object oo : vv) {							// 향상된 for문 을 이용하여 Collection vv 전체를 돌려서
			sum += (int)(oo);							// sum 값에 누적한다. 
		}
	}

	@Override
	public String toString() {
		return "Character [kind=" + kind.get("종족") + ", name=" + name + ", level=" + jum.get("level") + ", value=" + jum.get("value") + ", frequency="
				+ jum.get("frequency") + "]";
	}
}

class TTStCom implements Comparator{
	
	Object kind;
	public TTStCom(Object kind) {
		super();
		this.kind = kind;
	}

	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		HashMap str = new HashMap<>();
		str.put("종족", "악당, 엘프, 인간, 오크, 악마, 천사");
		str.put("전체", "전체");
		
		int res=1;
		
		if(kind instanceof String)
		{
			
			res = ((String)str.get(kind)).indexOf(((String)o1))-
			((String)str.get(kind)).indexOf(((String)o2));
			
			
		}else{
			Character me = (Character)o1;
			Character you = (Character)o2;
			
			res = you.sum-me.sum;
			if(res==0) res = me.sum - you.sum;
		}
		
		return res;
	}
}





public class Hw_0315_01 {
	 public static void main(String[] args) {
	        // TODO Auto-generated method stub
		 
		 List data = new ArrayList();
		 
		 data.add(new Character("악당", "AAA", 10, 10, 10));
		 data.add(new Character("악당", "BBB", 20, 20, 20));
		 data.add(new Character("엘프", "CCC", 30, 30, 30));
		 data.add(new Character("엘프", "DDD", 40, 40, 40));
		 data.add(new Character("인간", "EEE", 50, 50, 50));
		 data.add(new Character("인간", "FFF", 60, 60, 60));
		 data.add(new Character("오크", "GGG", 70, 70, 70));
		 data.add(new Character("오크", "HHH", 80, 80, 80));
		 data.add(new Character("천사", "III", 90, 90, 90));
		 data.add(new Character("천사", "JJJ", 100, 100, 100));
		 data.add(new Character("악마", "KKK", 1, 1, 1));
		 //data.add(new Character("악당", "AAA", 10, 10, 10));
		 //data.add(new Character("악당", "AAA", 10, 10, 10));
		 
		 /*for (int i = 0; i < data.size(); i++) {
			 System.out.println(data.get(i).toString());
		 }*/
		 
		 Scanner sc = new Scanner(System.in);
		 
		 String [] kind = {"전체","종족"};
		 
		 for (int i = 0; i < kind.length; i++) {
				System.out.print(i+","+kind[i]+" ");
			}
		 
		 System.out.print("\n입력:");
		 
		 int no = sc.nextInt();
		 
		 String [] arr = kind[no].split(",");
		 
		 
		 
		 
		 TreeMap total = new TreeMap(new TTStCom(arr[0]));
		 
		 
		 for (Object dt : data)
		 {
			 TreeMap nowMap = total;
			 Character ch = (Character)dt;
			 
			 for (int i = 0; i < arr.length-1; i++) {
					if(nowMap.containsKey(ch.kind.get(arr[i])))
						nowMap = (TreeMap)nowMap.get(ch.kind.get(arr[i]));
					else{
						TreeMap bufMap = new TreeMap(new TTStCom(arr[i+1]));
						nowMap.put(ch.kind.get(arr[i]),bufMap);
						
						nowMap = bufMap;
					}
			}
			 
			TreeSet nowSS;
			 
			if(nowMap.containsKey(ch.kind.get(arr[arr.length-1])))
				nowSS = (TreeSet)nowMap.get(ch.kind.get(arr[arr.length-1]));
			else{
				nowSS = new TreeSet(new TTStCom(0));
				nowMap.put(ch.kind.get(arr[arr.length-1]),nowSS);
			}
			 
			nowSS.add(dt);
		 }
			
		mapPrint(total);
	}
	 
	@Override
	public String toString() {
		return "TreeMapExamMain []";
	}
			 
	static void mapPrint(TreeMap map) {
		Iterator it = map.keySet().iterator();
		
		while(it.hasNext())
		{
			
			Character sum = new Character("합계", " ",0,0,0);
			Object key = it.next();
			
			System.out.println(key+">>>>>>");
			
			Object obj = map.get(key);
			if(obj instanceof TreeMap)
				mapPrint((TreeMap)obj);
			else
			{
				Iterator sit = ((TreeSet)map.get(key)).iterator();
				
				while(sit.hasNext())
				{
					Character now = (Character)sit.next();
					
					Iterator jit = now.jum.keySet().iterator();
					while(jit.hasNext())
					{
						Object jkey = jit.next();
						int jjj = (int)sum.jum.get(jkey)+(int)now.jum.get(jkey);
						sum.jum.put(jkey, jjj);
					}
					
					System.out.println(now);
				}
				System.out.println(sum);
			}
			
		}
	
	}
 
}
