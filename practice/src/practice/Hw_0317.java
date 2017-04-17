package practice;

import java.util.Iterator;
import java.util.LinkedHashMap;
import javax.swing.JOptionPane;


class Timer_01 extends Thread
{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		for (int i = 15; i >0; i--) {							// 시간을 for문으로
			try {												// 예외처리
				
				sleep(500);										// 흐르는 시간 속도 조절				
																//??? 무엇을 위한 check인가???
				System.out.println(i);							// 흐르는 시간 출력!!
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();							//??? 예외처리 된 녀석들을 받는다???
				
			}
		}
		
		System.out.println("시험 종료~!!!");
	}
}

class Test_0317 extends Thread									// 시험 문제 클래스 ==> 시간 클래스와 가치 움직인다.
{
	Hw_0317_Data dt;
	
	public Test_0317(Hw_0317_Data dt) {
		super();
		this.dt = dt;
	}

	@Override
	public void run() {											// 쓰레드 런!!
		
		Iterator<String> it_k = dt.kor_quest_answer.keySet().iterator();
		Iterator<String> it_e = dt.eng_quest_answer.keySet().iterator();
		Iterator<String> it_m = dt.mat_quest_answer.keySet().iterator();
		
		
		while(it_k.hasNext())										// 전체 이용
		{			
			String key = it_k.next();								// key에 다음 값들을 받는다.
			String input = JOptionPane.showInputDialog(key);

			System.out.println("입력값:"+input);					// 입력했을때 입력값 출력
		}
		
		while(it_e.hasNext())										// 전체 이용
		{			
			String key = it_e.next();								// key에 다음 값들을 받는다.
			String input = JOptionPane.showInputDialog(key);

			System.out.println("입력값:"+input);					// 입력했을때 입력값 출력
		}
		
		while(it_m.hasNext())										// 전체 이용
		{			
			String key = it_m.next();								// key에 다음 값들을 받는다.
			String input = JOptionPane.showInputDialog(key);

			System.out.println("입력값:"+input);					// 입력했을때 입력값 출력
		}
	}
}


class Hw_0317_Data
{
	LinkedHashMap< String, String> kor_quest_answer = new LinkedHashMap<>();
	LinkedHashMap< String, String> eng_quest_answer = new LinkedHashMap<>();
	LinkedHashMap< String, String> mat_quest_answer = new LinkedHashMap<>();
	
	LinkedHashMap< String, String> ok = new LinkedHashMap<>();		// LinkedHashMap 생성 ==> 
	LinkedHashMap< String, String> nono = new LinkedHashMap<>();
	
	int cnt =0;
	
	void solve_k(String key, String input)
	{
		if(kor_quest_answer.get(key).equals(input))								// map의 값과 input값 비교 
			ok.put(cnt+". "+key, kor_quest_answer.get(key));						// 같다면 ok map의 key에 cnt와 key값을 넣고 답을 value값에 넣는다.
		else
			nono.put(cnt+". "+key, input+"("+kor_quest_answer.get(key)+")");		// 다르다면 nono map에 cnt와 key값을 넣고 input값과 답을 value값에 넣는다.
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