package practice;

import java.util.Iterator;

import java.util.LinkedHashMap;

import javax.swing.JOptionPane;

class Timer extends Thread

{

	ThreadData td;

	public Timer(ThreadData td) {

		super();

		this.td = td;

	}

	@Override

	public void run() {

		// TODO Auto-generated method stub

		System.out.println("���� ���� ����!");

		for (int i = 20; i >= 0; i--) {

			try {

				sleep(1000);

				System.out.println(i);

				if (td.korchk)

					break;

			} catch (InterruptedException e) {

				// TODO Auto-generated catch block

				e.printStackTrace();

			}

		}

		td.korchk = true;

		System.out.println("���� ����");

		run2();

	}

	public void run2() {

		// TODO Auto-generated method stub

		System.out.println("���� ���� ����!");

		for (int i = 20; i >= 0; i--) {

			try {

				sleep(1000);

				System.out.println(i);

				if (td.engchk)

					break;

			} catch (InterruptedException e) {

				// TODO Auto-generated catch block

				e.printStackTrace();

			}

		}

		td.engchk = true;

		System.out.println("���� ����");

		run3();

	}

	public void run3() {

		// TODO Auto-generated method stub

		System.out.println("���� ���� ����!");

		for (int i = 20; i >= 0; i--) {

			try {

				sleep(1000);

				System.out.println(i);

				if (td.matchk)

					break;

			} catch (InterruptedException e) {

				// TODO Auto-generated catch block

				e.printStackTrace();

			}

		}

		td.matchk = true;

		System.out.println("���� ����");

		System.out.println("��ü��������");

		td.chk = true;

	}

}

class Stud_02 extends Thread

{

	ThreadData td;

	LinkedHashMap<String, String> map = new LinkedHashMap<>();
	LinkedHashMap<String, String> map2 = new LinkedHashMap<>();
	LinkedHashMap<String, String> map3 = new LinkedHashMap<>();

	int korcnt, engcnt, matcnt;
	public Stud_02(ThreadData td) {

		super();

		this.td = td;

		map.put("����1","1");
		map.put("����2","1");
		map.put("����3","1");
		map.put("����4","1");
		map.put("����5","1");

		map2.put("����1", "2");
		map2.put("����2", "2");
		map2.put("����3", "2");
		map2.put("����4", "2");
		map2.put("����5", "2");

		map3.put("����1", "3");
		map3.put("����1", "3");
		map3.put("����1", "3");
		map3.put("����1", "3");
		map3.put("����1", "3");


	}

	@Override

	public void run() {

		korcnt = 0;
		engcnt = 0;
		matcnt = 0;

		Iterator<String> it = map.keySet().iterator();
		Iterator<String> it2 = map2.keySet().iterator();
		Iterator<String> it3 = map3.keySet().iterator();

		while (it.hasNext())
		{

			String key = it.next();
			String answer = JOptionPane.showInputDialog(key);
			if (td.korchk)
				break;
			if (map.get(key).equals(answer))
				korcnt++;
			if (!map.get(key).equals(answer) && !answer.equals("pass")) {
				aaa: while (true) {
					answer = JOptionPane.showInputDialog(key);
					if (map.get(key).equals(answer))
					{
						korcnt++;
						break aaa;
					}

					else if (answer.equals("pass"))
						break aaa;
					else
						continue;
				}

			}

		}

		td.korchk = true;

		while (it2.hasNext())

		{

			String key = it2.next();

			String answer = JOptionPane.showInputDialog(key);

			if (td.engchk)

				break;

			if (map2.get(key).equals(answer))

				korcnt++;

			if (!map2.get(key).equals(answer) && !answer.equals("pass")) {

				a: while (true) {

					answer = JOptionPane.showInputDialog(key);

					if (map2.get(key).equals(answer))

					{

						engcnt++;
						break a;

					}

					else if (answer.equals("p"))

						break a;

					else
						continue;

				}

			}

		}

		td.engchk = true;

		while (it3.hasNext())

		{

			String key = it3.next();
			String answer = JOptionPane.showInputDialog(key);
			if (td.matchk)
				break;
			if (map3.get(key).equals(answer))
				korcnt++;
			if (!map3.get(key).equals(answer) && !answer.equals("p")) {
				a: while (true) {
					answer = JOptionPane.showInputDialog(key);
					if (map3.get(key).equals(answer))

					{
						matcnt++;
						break a;
					}

					else if (answer.equals("p"))

						break a;
					else
						continue;
				}
			}
		}
		td.matchk = true;

		try {
			sleep(1000);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		System.out.println("�����������:" + korcnt);
		System.out.println("�����������:" + engcnt);
		System.out.println("���и�������:" + matcnt);
		System.out.println("�Ѱ���:" + (korcnt + engcnt + matcnt));
	}
}

class ThreadData

{
	boolean chk = false;
	boolean korchk = false;
	boolean engchk = false;
	boolean matchk = false;
}

public class Hw_0317_02 {

	public static void main(String[] args) {

		// TODO Auto-generated method stub

		ThreadData td = new ThreadData();
		Timer ti = new Timer(td);
		Stud_02 st = new Stud_02(td);
		
		ti.start();
		st.start();

	}
}