package set_p_01;

import java.util.*;

public class Set_01_Main {
	public static void main(String[] args) {
		TreeSet set = new TreeSet();
		int[] aaa = { 12, 7, 687, 98, 54, 50, 26, 77, 234, 12, 7, 26, 90 };
		for (int i = 0; i < aaa.length; i++) {
			set.add(aaa[i]);
		}
		
		int target = 50;
		
		System.out.println(set);
		System.out.println(set.headSet(target));
		System.out.println(set.tailSet(target));
	}
}
