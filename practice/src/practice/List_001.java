package practice;

import java.util.*;

public class List_001 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList l_1 = new ArrayList();
		List l_2 = new ArrayList();
																			// List l_3 = new List() { };
		l_1.add(new Integer(5));											// object단위로 처리
		l_1.add(new Integer(7));											// Integer() 숫자만 넣도록 한다.
		l_1.add(new Integer(4));
		l_1.add(new Integer(5));
		l_1.add(new Integer(3));
		l_1.add(new Integer(7));
		l_1.add(new Integer(2));

		
		ArrayList l_4 = new ArrayList(l_1.subList(1, 4)); 		// 일부만 추출하여 새로 생성 (1,2,3의 자리의 값을 배껴서 가져온다.)
		
		List l_5 = l_1.subList(1, 4); 				// 일부만 추출함 l_1과 같은 주소를 사용 내용이 같이 바뀜(1,2,3의 자리의 값을 배껴서 가져온다.)
		l_4.add(new Integer(0));					// l-4 list의 끝에 공간 추가 후 '0'을 대입한다.
		l_1.set(2, new Integer(11));				// l_1 list의 2번째 자리에 '11'이란 데이터를 넣는다.
		System.out.println(l_1.get(4));				// get을 이용하여 '4'번째 값을 가져와 출력한다.
		System.out.println(l_1);					// l_1 전체 출력 
		System.out.println(l_4);					// l_4 전체 출력
		Collections.sort(l_1); 						// 정렬---> 같은 자료형을 기준으로 오름차순 정렬을 해 준다.
		
		System.out.println(l_1);					// l_1 전체 출력 
		Collections.sort(l_4);						// l_4 전체 오름차순 정렬 

		l_1.remove(2);								// l_1의 의 2번째 삭제 
		System.out.println("================");
		System.out.println(l_1);					// l_1 전체 출력 
		System.out.println(l_4);					// l_4 전체 출력
		l_1.retainAll(l_4);							// l_1과 l_4의 값의 교집합을 l-1에 남겨놓고 나머지를 제거한다. 
		
		System.out.println("!@#!@#");				// l_4에 있는 항목만 제외하고 나머지 삭제
		System.out.println(l_4);					// l_4 전체 출력
		System.out.println(l_1);					// l_1 전체 출력 
		print(l_1, l_4); 							

		for (int i = (l_4.size()-1); i >= 0; i--) 	// 뒤에서부터 빼기 위해서
		{											// l_4.size() --> 리스트의 개체 갯수
			if (l_1.contains(l_4.get(i))) 			// l_1.contains(요소)--요소가 리스트에 존재하는가
			{
				l_4.remove(i);						// l_4의 i번째 값을 제거
			}
		}
		print(l_1, l_4);

	}
	
	static void print(ArrayList l_1, ArrayList l_2) {
		System.out.println("================");
		System.out.println(l_1);
		System.out.println(l_2);
	}
}
