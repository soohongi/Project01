package practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

class GChar2 {
	String name;
	String kind;
	String gender;

	int val;
	int level;
	int freq;

	public GChar2(String name, String kind, String gender, int val, int level, int freq) {

		super();
		this.name = name;
		this.kind = kind;
		this.gender = gender;
		this.val = val;
		this.level = level;
		this.freq = freq;

	}

	@Override
	public String toString() {
		return "GChar2 [name=" + name + ", kind=" + kind + ", gender=" + gender + 
				", val=" + val + ", level=" + level	+ ", freq=" + freq + "]";
	}
}

class MyTree45 implements Comparator<GChar2> {
	int kind;
	public MyTree45(int kind) {
		super();
		this.kind = kind;
	}
	@Override
	public int compare(GChar2 o1, GChar2 o2) {
		// TODO Auto-generated method stub
		int res = 1;
		if (kind == 0) {
			res = o2.level - o1.level;
			if (res == 0) {
				res = 1;
			}
		}
		else if (kind == 1) {
			res = o2.freq - o1.freq;
			if (res == 0) {
				res = 1;
			}
		}
		else {
			res = o2.val - o1.val;
			if (res == 0) {
				res = 1;
			}
		}
		return res;
	}
}

public class TreeMap_02 {

	public static void main(String[] args) {

		// TODO Auto-generated method stub

		ArrayList<GChar2> al = new ArrayList();
		Scanner in = new Scanner(System.in);
		System.out.println("0. 레벨순, 1. 빈도순, 2. 가치순");
		int num = in.nextInt();
		al.add(new GChar2("티모, ", "엘프", "남", 10, 30, 30));
		al.add(new GChar2("쓰래쉬", "악당", "남", 20, 40, 80));
		al.add(new GChar2("트페", "엘프", "여", 30, 50, 90));
		al.add(new GChar2("리산드라", "악당", "남", 40, 70, 66));
		al.add(new GChar2("소나", "오크", "여", 50, 80, 40));
		al.add(new GChar2("모르가나", "악당", "여", 60, 30, 65));
		al.add(new GChar2("카르마", "몬스터", "남", 70, 20, 12));
		al.add(new GChar2("퀸", "오크", "여", 80, 60, 54));
		al.add(new GChar2("아리", "악당", "남", 90, 90, 23));
		al.add(new GChar2("카르마", "몬스터", "남", 22, 10, 87));
		al.add(new GChar2("킨드", "오크", "여", 28, 10, 67));
		al.add(new GChar2("블리츠크랭크", "오크", "남", 64, 10, 46));
		al.add(new GChar2("오리아나", "몬스터", "남", 99, 10, 78));
		al.add(new GChar2("코그모", "엘프", "여", 55, 10, 100));
		al.add(new GChar2("임종천", "몬스터", "남", 66, 45, 89));
		al.add(new GChar2("김진향", "엘프", "남", 87, 24, 78));
		al.add(new GChar2("추주헌", "몬스터", "남", 33, 65, 67));
		al.add(new GChar2("민정훈", "오크", "여", 11, 23, 40));
		al.add(new GChar2("김경환", "엘프", "여", 5, 12, 30));

		TreeMap<String, TreeSet> tMap = new TreeMap();

		for (GChar2 gc : al) {
			TreeSet<GChar2> ts;
			if (tMap.containsKey(gc.kind)) {
				ts = tMap.get(gc.kind);
			}
			else {
				ts = new TreeSet(new MyTree45(num));
				tMap.put(gc.kind, ts);
			}
			ts.add(gc);
		}

		Iterator it = tMap.keySet().iterator();
		while (it.hasNext()) {
			String key = (String) it.next();
			System.out.println(key + ">>>");
			Iterator kkey = tMap.get(key).iterator();
			while (kkey.hasNext()) {
				System.out.println(kkey.next());

			}

		}

	}

}