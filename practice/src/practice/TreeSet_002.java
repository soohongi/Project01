package practice;

import java.util.*;

class descend implements Comparator { 								// ����� ���� ���ı����� �� �� �ִ� �������̽�
	@Override
	public int compare(Object o1, Object o2) {
		// �������� ���Ĺ���� ���� �޼ҵ�
		if (o1 instanceof Comparable && o2 instanceof Comparable) { // ������ ������
																	// ��������
																	// ���(int)

			Comparable oo1 = (Comparable) o1;					// �ڷ��� ��ȯ
			Comparable oo2 = (Comparable) o2;					

			return oo1.compareTo(oo2) * -1;
																// ������ ���� * -1 ====> ������ ����(���� ũ�⿡ ���� ����)
		} else {												// ���Ĺ���� ������ �ʴ� ���

			return -1;											// �Է� �������� ����
		}
	}
}

public class TreeSet_002 {
	public static void main(String[] args) {
		TreeSet set1 = new TreeSet();
		TreeSet set2 = new TreeSet(new descend());
		// ����� ���� ���� Ŭ������ �μ��� ����

		int[] aaa = { 20, 50, 10, 30, 90, 80, 100 };

		for (int i = 0; i < aaa.length; i++) {
			set1.add(new Integer(aaa[i]));
			set2.add(new Integer(aaa[i]));
		}
		System.out.println("������:" + set1);
		System.out.println("������:" + set2);

	}

}
