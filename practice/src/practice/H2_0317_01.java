package practice;

import java.util.Iterator;
import java.util.LinkedHashMap;

import javax.swing.JOptionPane;

class MulTimer_02 extends Thread								// Ÿ�̸� Ŭ���� ==> ������ �̿��Ͽ� �ð��� �帥��!!
{
	MulExam_02Data md;											// ������ ���� ==> ���� ��� �ð� ����� ����
	
	@Override
	public void run() {											// ������ ��!
		// TODO Auto-generated method stub
		for (int i =40; i >0; i--) {							// �ð��� for������
			try {												// ����ó��
				
				sleep(500);									// �帣�� �ð� �ӵ� ����				
				if(md.chk) break;								//??? ������ ���� check�ΰ�???
				System.out.println(i);							// �帣�� �ð� ���!!
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();							//??? ����ó�� �� �༮���� �޴´�???
				//System.out.println(e.getMessage());
			}
			
		}
		
		md.chk=true;											//??? ==> �ð��� ������ ������ ���̻� ������ �ʴ´�. 
		System.out.println("���� ����");							// ������ ����Ǿ����� ���
		md.print();												// ���� ���� �� ��� ���!!	
	}
}

class MulExam_02 extends Thread									// ���� ���� Ŭ���� ==> �ð� Ŭ������ ��ġ �����δ�.
{
	MulExam_02Data md;											// ������ ���� ==> ���� ��� �ð� ����� ����

	@Override
	public void run() {											// ������ ��!!
		
		//Iterator<String> it = md.map.keySet().iterator();		// Iterator�̿�=> KeySet�̿�=> key���� �ҷ��´�.
		
		Iterator<String> it_k = md.kor_quest_answer.keySet().iterator();
		Iterator<String> it_e = md.eng_quest_answer.keySet().iterator();
		Iterator<String> it_m = md.mat_quest_answer.keySet().iterator();
		
		
		// TODO Auto-generated method stub
		md.cnt=0;												// ī��Ʈ
		
		
		while(it_k.hasNext())										// ��ü �̿�
		{			
			String input = null;
			while(true)
			{
				String key = it_k.next();
				if(md.chk) break;
				input = JOptionPane.showInputDialog(key);
				if(md.chk) break;
				if (!md.kor_quest_answer.get(key).equals(input) && !input.equals("pass")) {
					aaa: while (true) {
						input = JOptionPane.showInputDialog(key);
						if (md.kor_quest_answer.get(key).equals(input) || input.equals("pass"))
							break aaa;
						else
							continue;
					}
				}
			}
			System.out.println("�Է°�:"+input);
		}
		
		while(it_e.hasNext())										// ��ü �̿�
		{			
			String input = null;
			while(true)
			{
				String key = it_k.next();
				if(md.chk) break;
				input = JOptionPane.showInputDialog(key);
				if(md.chk) break;
				if (!md.eng_quest_answer.get(key).equals(input) && !input.equals("pass")) {
					aaa: while (true) {
						input = JOptionPane.showInputDialog(key);
						if (md.eng_quest_answer.get(key).equals(input) || input.equals("pass"))
							break aaa;
						else
							continue;
					}
				}
			}				// �Է������� �Է°� ���
		}
		
		while(it_m.hasNext())										// ��ü �̿�
		{			
			String input = null;
			while(true)
			{
				String key = it_k.next();
				if(md.chk) break;
				input = JOptionPane.showInputDialog(key);
				if(md.chk) break;
				if (!md.mat_quest_answer.get(key).equals(input) && !input.equals("pass")) {
					aaa: while (true) {
						input = JOptionPane.showInputDialog(key);
						if (md.mat_quest_answer.get(key).equals(input) || input.equals("pass"))
							break aaa;
						else
							continue;
					}
				}
			}			// �Է������� �Է°� ���
		}
	}
}
class MulExam_02Data												// ���� ������ Ŭ����  ==> ���� ���, �ð� ����� ����
{
	//LinkedHashMap< String, String> map = new LinkedHashMap<>();		// LinkedHashMap ���� ==> ���� ���� & ��
	
	LinkedHashMap< String, String> kor_quest_answer = new LinkedHashMap<>();
	LinkedHashMap< String, String> eng_quest_answer = new LinkedHashMap<>();
	LinkedHashMap< String, String> mat_quest_answer = new LinkedHashMap<>();
	

	LinkedHashMap< String, String> ok = new LinkedHashMap<>();		// LinkedHashMap ���� ==> 
	LinkedHashMap< String, String> nono = new LinkedHashMap<>();	// LinkedHashMap ����
	boolean chk = false;											// chk ���� => false�� �ʱ�ȭ
	int cnt;														// cnt ����
	
	void k_solve(String key,String input)								
	{
		if(kor_quest_answer.get(key).equals(input))								
			ok.put(cnt+". "+key, kor_quest_answer.get(key));						
		else
			nono.put(cnt+". "+key, input+"("+kor_quest_answer.get(key)+")");		
		cnt++;														
	}
	
	void e_solve(String key,String input)								
	{
		if(eng_quest_answer.get(key).equals(input))								
			ok.put(cnt+". "+key, eng_quest_answer.get(key));						
		else
			nono.put(cnt+". "+key, input+"("+eng_quest_answer.get(key)+")");		
		cnt++;														
	}
	
	void m_solve(String key,String input)								
	{
		if(mat_quest_answer.get(key).equals(input))								
			ok.put(cnt+". "+key, mat_quest_answer.get(key));						
		else
			nono.put(cnt+". "+key, input+"("+mat_quest_answer.get(key)+")");		
		cnt++;														
	}
	

	void print()													
	{
		timeover();													// timeover �޼ҵ� ����
		
		System.out.println("����>>>>");								// 
		printModule(ok);											// ok map ���
		System.out.println("����>>>>");
		printModule(nono);											// nono map ���
	}
	
	void timeover()													// timeover �޼ҵ�
	{
		Iterator<String> it = kor_quest_answer.keySet().iterator();				// Iterator it��  map��  key�� ����
		
		for (int i = 0; i <cnt; i++) {								// cnt��ŭ for�� ������. ==>
			it.next();												// next�� ����ϸ� ���� �ִ� ���� ����������.
		}
		
		while(it.hasNext())											// Ȥ�� 5���� ���� �� ���� ���¶�� ���� ���� ���� while���̤� ���� �ʴ´�.
		{
			String key = it.next();									// key���� String key�� ��´�.
			nono.put(cnt+". "+key, "�ð��ʰ�("+kor_quest_answer.get(key)+")");		// nono��  cnt�� key �� , �ð��ʰ� ���ڿ��� ���� �����Ѵ�.
			cnt++;
		}
		
	}
	
	void printModule(LinkedHashMap< String,String> map)				// printModule �޼ҵ� �Ű������� map�� �޴´�. 
	{
		Iterator it = map.entrySet().iterator();					// entrSet => key, value ���� ��� �̾��ش�. 
		
		while(it.hasNext())											// ��ü�� �����Ѵٸ� ��!
		{
			System.out.println(it.next());							// ��ü���� �̾��ָ鼭 ����Ѵ�.
		}
	}
}

public class H2_0317_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		MulTimer_02 mm = new MulTimer_02();
		MulExam_02 me = new MulExam_02();
		
		MulExam_02Data md = new MulExam_02Data();
		
		md.kor_quest_answer.put("����1", "1");
		md.kor_quest_answer.put("����2", "2");
		md.kor_quest_answer.put("����3", "3");
		md.kor_quest_answer.put("����4", "4");
		md.kor_quest_answer.put("����5", "5");
		md.eng_quest_answer.put("����1", "6");
		md.eng_quest_answer.put("����2", "7");
		md.eng_quest_answer.put("����3", "8");
		md.eng_quest_answer.put("����4", "9");
		md.eng_quest_answer.put("����5", "10");
		md.mat_quest_answer.put("����1", "11");
		md.mat_quest_answer.put("����2", "12");
		md.mat_quest_answer.put("����3", "13");
		md.mat_quest_answer.put("����4", "14");
		md.mat_quest_answer.put("����5", "15");
		
		mm.md = md;
		me.md = md;
		
		mm.start();
		me.start();
	}

}
