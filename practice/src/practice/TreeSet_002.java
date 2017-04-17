package practice;

import java.util.*;

class descend implements Comparator { 								// 사용자 정의 정렬기준을 할 수 있는 인터페이스
	@Override
	public int compare(Object o1, Object o2) {
		// 실질적인 정렬방식을 정할 메소드
		if (o1 instanceof Comparable && o2 instanceof Comparable) { // 정렬이 가능한
																	// 데이터인
																	// 경우(int)

			Comparable oo1 = (Comparable) o1;					// 자료형 변환
			Comparable oo2 = (Comparable) o2;					

			return oo1.compareTo(oo2) * -1;
																// 정방향 정렬 * -1 ====> 역방향 정렬(값의 크기에 의한 정렬)
		} else {												// 정렬방식이 먹히지 않는 경우

			return -1;											// 입력 데이터의 역순
		}
	}
}

public class TreeSet_002 {
	public static void main(String[] args) {
		TreeSet set1 = new TreeSet();
		TreeSet set2 = new TreeSet(new descend());
		// 사용자 정의 정렬 클래스를 인수로 받음

		int[] aaa = { 20, 50, 10, 30, 90, 80, 100 };

		for (int i = 0; i < aaa.length; i++) {
			set1.add(new Integer(aaa[i]));
			set2.add(new Integer(aaa[i]));
		}
		System.out.println("정방향:" + set1);
		System.out.println("역방향:" + set2);

	}

}
