package practice;

import java.util.*;

public class List_001 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList l_1 = new ArrayList();
		List l_2 = new ArrayList();
																			// List l_3 = new List() { };
		l_1.add(new Integer(5));											// object������ ó��
		l_1.add(new Integer(7));											// Integer() ���ڸ� �ֵ��� �Ѵ�.
		l_1.add(new Integer(4));
		l_1.add(new Integer(5));
		l_1.add(new Integer(3));
		l_1.add(new Integer(7));
		l_1.add(new Integer(2));

		
		ArrayList l_4 = new ArrayList(l_1.subList(1, 4)); 		// �Ϻθ� �����Ͽ� ���� ���� (1,2,3�� �ڸ��� ���� �貸�� �����´�.)
		
		List l_5 = l_1.subList(1, 4); 				// �Ϻθ� ������ l_1�� ���� �ּҸ� ��� ������ ���� �ٲ�(1,2,3�� �ڸ��� ���� �貸�� �����´�.)
		l_4.add(new Integer(0));					// l-4 list�� ���� ���� �߰� �� '0'�� �����Ѵ�.
		l_1.set(2, new Integer(11));				// l_1 list�� 2��° �ڸ��� '11'�̶� �����͸� �ִ´�.
		System.out.println(l_1.get(4));				// get�� �̿��Ͽ� '4'��° ���� ������ ����Ѵ�.
		System.out.println(l_1);					// l_1 ��ü ��� 
		System.out.println(l_4);					// l_4 ��ü ���
		Collections.sort(l_1); 						// ����---> ���� �ڷ����� �������� �������� ������ �� �ش�.
		
		System.out.println(l_1);					// l_1 ��ü ��� 
		Collections.sort(l_4);						// l_4 ��ü �������� ���� 

		l_1.remove(2);								// l_1�� �� 2��° ���� 
		System.out.println("================");
		System.out.println(l_1);					// l_1 ��ü ��� 
		System.out.println(l_4);					// l_4 ��ü ���
		l_1.retainAll(l_4);							// l_1�� l_4�� ���� �������� l-1�� ���ܳ��� �������� �����Ѵ�. 
		
		System.out.println("!@#!@#");				// l_4�� �ִ� �׸� �����ϰ� ������ ����
		System.out.println(l_4);					// l_4 ��ü ���
		System.out.println(l_1);					// l_1 ��ü ��� 
		print(l_1, l_4); 							

		for (int i = (l_4.size()-1); i >= 0; i--) 	// �ڿ������� ���� ���ؼ�
		{											// l_4.size() --> ����Ʈ�� ��ü ����
			if (l_1.contains(l_4.get(i))) 			// l_1.contains(���)--��Ұ� ����Ʈ�� �����ϴ°�
			{
				l_4.remove(i);						// l_4�� i��° ���� ����
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
