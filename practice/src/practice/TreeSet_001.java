package practice;

import java.util.*;

public class TreeSet_001 {
	public static void main(String[] args) {
		TreeSet set = new TreeSet();
		int[] aaa = { 12, 7, 687, 98, 54, 26, 77, 234, 12, 7, 26, 90 };
		for (int i = 0; i < aaa.length; i++) {
			set.add(new Integer(aaa[i]));
		}
		int target = 50;
		System.out.println(set);
		System.out.println(set.headSet(target));
		System.out.println(set.tailSet(target));
	}
}
