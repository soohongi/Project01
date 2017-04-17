package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Set_001 {

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		Set set = new HashSet();
		Set set2 = new HashSet();
		Object[] arr = { 34, 23, 1, 67, 1, 49, 90, 34, 34, 90, 1, 1, "1", '1', "왜요" };
		// 49 와 '1' 의 값이 같아도 자료형이 틀려 중복되어 둘다 입력 가능
		Object[] arr2 = { 34, 23, 1, 67, 1, 49, 90, 34, 34, 90, 1, 1, "1", (int) '1', "왜요" };
		// '1'을 형변환 하여 49와 같아 중복으로 처리되어 하나만 입력
		for (Object oo : arr) {
			set.add(oo);
		}

		for (Object oo : arr2) {
			set2.add(oo);
		}

		System.out.println("arr:" + Arrays.toString(arr));
		System.out.println("set:" + set);
		System.out.println("arr2:" + Arrays.toString(arr2));
		System.out.println("set2:" + set2);
		System.out.println();
		
		ArrayList lotto = new ArrayList<>();
		HashSet lotto2 = new HashSet();
		
		/*System.out.println("=======================");
		System.out.println((int)(Math.random()*45)+1);*/
		
		
		
		while (true)
		{
			int num = (int) (Math.random() * 45) + 1;
			lotto.add(num);

			if (lotto.size() == 7)
				break;
		}

		while (true)
		{
			int num = (int) (Math.random() * 45) + 1;
			lotto2.add(num);
			if (lotto2.size() == 7)
				break;
		}

		System.out.println("lotto:" + lotto);
		System.out.println("lotto2:" + lotto2);
		for (int i = 0; i < lotto2.size(); i++) {
			// System.out.println(lotto2.get(i));
			// get(원소번호) ==> 사용불가
		}

		System.out.println("향상된 For문----------------");
		for (Object oo : lotto2) {
			System.out.println(oo);
			// 사용가능 : 원소번호로 출력하는 것이 아니기 때문
		}

		System.out.println("Iterator----------------");
		Iterator it = lotto2.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}

		//// 빙고판을 만드세요
		/// 경우의 수 >> 1-> 100
		/// 빙고 판 5 * 5 형태
		/// 같은 수는 중복될 수 없음

	}

}