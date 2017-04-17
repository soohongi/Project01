package practice;

import java.util.Iterator;
import java.util.LinkedHashMap;
import javax.swing.JOptionPane;


class Timer_01 extends Thread
{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		for (int i = 15; i >0; i--) {							// �ð��� for������
			try {												// ����ó��
				
				sleep(500);										// �帣�� �ð� �ӵ� ����				
																//??? ������ ���� check�ΰ�???
				System.out.println(i);							// �帣�� �ð� ���!!
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();							//??? ����ó�� �� �༮���� �޴´�???
				
			}
		}
		
		System.out.println("���� ����~!!!");
	}
}

class Test_0317 extends Thread									// ���� ���� Ŭ���� ==> �ð� Ŭ������ ��ġ �����δ�.
{
	Hw_0317_Data dt;
	
	public Test_0317(Hw_0317_Data dt) {
		super();
		this.dt = dt;
	}

	@Override
	public void run() {											// ������ ��!!
		
		Iterator<String> it_k = dt.kor_quest_answer.keySet().iterator();
		Iterator<String> it_e = dt.eng_quest_answer.keySet().iterator();
		Iterator<String> it_m = dt.mat_quest_answer.keySet().iterator();
		
		
		while(it_k.hasNext())										// ��ü �̿�
		{			
			String key = it_k.next();								// key�� ���� ������ �޴´�.
			String input = JOptionPane.showInputDialog(key);

			System.out.println("�Է°�:"+input);					// �Է������� �Է°� ���
		}
		
		while(it_e.hasNext())										// ��ü �̿�
		{			
			String key = it_e.next();								// key�� ���� ������ �޴´�.
			String input = JOptionPane.showInputDialog(key);

			System.out.println("�Է°�:"+input);					// �Է������� �Է°� ���
		}
		
		while(it_m.hasNext())										// ��ü �̿�
		{			
			String key = it_m.next();								// key�� ���� ������ �޴´�.
			String input = JOptionPane.showInputDialog(key);

			System.out.println("�Է°�:"+input);					// �Է������� �Է°� ���
		}
	}
}


class Hw_0317_Data
{
	LinkedHashMap< String, String> kor_quest_answer = new LinkedHashMap<>();
	LinkedHashMap< String, String> eng_quest_answer = new LinkedHashMap<>();
	LinkedHashMap< String, String> mat_quest_answer = new LinkedHashMap<>();
	
	LinkedHashMap< String, String> ok = new LinkedHashMap<>();		// LinkedHashMap ���� ==> 
	LinkedHashMap< String, String> nono = new LinkedHashMap<>();
	
	int cnt =0;
	
	void solve_k(String key, String input)
	{
		if(kor_quest_answer.get(key).equals(input))								// map�� ���� input�� �� 
			ok.put(cnt+". "+key, kor_quest_answer.get(key));						// ���ٸ� ok map�� key�� cnt�� key���� �ְ� ���� value���� �ִ´�.
		else
			nono.put(cnt+". "+key, input+"("+kor_quest_answer.get(key)+")");		// �ٸ��ٸ� nono map�� cnt�� key���� �ְ� input���� ���� value���� �ִ´�.
		cnt++;
	}

}


public class Hw_0317 {

	public static void main(String [] arg) {
		
		Timer_01 t01 =new Timer_01();

		t01.start();
		
		////////////////////////////////////////
		Hw_0317_Data dt = new Hw_0317_Data();		
		dt.kor_quest_answer.put("11", "1");
		dt.kor_quest_answer.put("22", "2");
		dt.kor_quest_answer.put("33", "3");
		dt.kor_quest_answer.put("44", "4");
		dt.kor_quest_answer.put("55", "5");
		dt.eng_quest_answer.put("66", "6");
		dt.eng_quest_answer.put("77", "7");
		dt.eng_quest_answer.put("88", "8");
		dt.eng_quest_answer.put("99", "9");
		dt.eng_quest_answer.put("100", "10");
		dt.mat_quest_answer.put("110", "11");
		dt.mat_quest_answer.put("120", "12");
		dt.mat_quest_answer.put("130", "13");
		dt.mat_quest_answer.put("140", "14");
		dt.mat_quest_answer.put("150", "15");
		
		Test_0317 tt = new Test_0317(dt);
		
		tt.start();
		
		
	}

}