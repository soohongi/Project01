package practice;

import java.util.Iterator;
import java.util.LinkedHashMap;

import javax.swing.JOptionPane;

class MulTimer_02 extends Thread								// 타이머 클래스 ==> 스레드 이용하여 시간이 흐른다!!
{
	MulExam_02Data md;											// 데이터 선언 ==> 시험 결과 시간 경과를 저장
	
	@Override
	public void run() {											// 쓰레드 런!
		// TODO Auto-generated method stub
		for (int i =40; i >0; i--) {							// 시간을 for문으로
			try {												// 예외처리
				
				sleep(500);									// 흐르는 시간 속도 조절				
				if(md.chk) break;								//??? 무엇을 위한 check인가???
				System.out.println(i);							// 흐르는 시간 출력!!
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();							//??? 예외처리 된 녀석들을 받는다???
				//System.out.println(e.getMessage());
			}
			
		}
		
		md.chk=true;											//??? ==> 시간이 지나면 문제가 더이상 나오지 않는다. 
		System.out.println("시험 종료");							// 시험이 종료되었을때 출력
		md.print();												// 시험 종료 후 결과 출력!!	
	}
}

class MulExam_02 extends Thread									// 시험 문제 클래스 ==> 시간 클래스와 가치 움직인다.
{
	MulExam_02Data md;											// 데이터 선언 ==> 시험 결과 시간 경과를 저장

	@Override
	public void run() {											// 쓰레드 런!!
		
		//Iterator<String> it = md.map.keySet().iterator();		// Iterator이용=> KeySet이용=> key값을 불러온다.
		
		Iterator<String> it_k = md.kor_quest_answer.keySet().iterator();
		Iterator<String> it_e = md.eng_quest_answer.keySet().iterator();
		Iterator<String> it_m = md.mat_quest_answer.keySet().iterator();
		
		
		// TODO Auto-generated method stub
		md.cnt=0;												// 카운트
		
		
		while(it_k.hasNext())										// 전체 이용
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
			System.out.println("입력값:"+input);
		}
		
		while(it_e.hasNext())										// 전체 이용
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
			}				// 입력했을때 입력값 출력
		}
		
		while(it_m.hasNext())										// 전체 이용
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
			}			// 입력했을때 입력값 출력
		}
	}
}
class MulExam_02Data												// 시험 데이터 클래스  ==> 시험 결과, 시간 경과를 저장
{
	//LinkedHashMap< String, String> map = new LinkedHashMap<>();		// LinkedHashMap 생성 ==> 시험 문제 & 답
	
	LinkedHashMap< String, String> kor_quest_answer = new LinkedHashMap<>();
	LinkedHashMap< String, String> eng_quest_answer = new LinkedHashMap<>();
	LinkedHashMap< String, String> mat_quest_answer = new LinkedHashMap<>();
	

	LinkedHashMap< String, String> ok = new LinkedHashMap<>();		// LinkedHashMap 생성 ==> 
	LinkedHashMap< String, String> nono = new LinkedHashMap<>();	// LinkedHashMap 생성
	boolean chk = false;											// chk 생성 => false로 초기화
	int cnt;														// cnt 생성
	
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
		timeover();													// timeover 메소드 실행
		
		System.out.println("정답>>>>");								// 
		printModule(ok);											// ok map 출력
		System.out.println("오답>>>>");
		printModule(nono);											// nono map 출력
	}
	
	void timeover()													// timeover 메소드
	{
		Iterator<String> it = kor_quest_answer.keySet().iterator();				// Iterator it에  map의  key값 대입
		
		for (int i = 0; i <cnt; i++) {								// cnt만큼 for문 돌린다. ==>
			it.next();												// next를 사용하면 실제 있는 값이 뽑혀나간다.
		}
		
		while(it.hasNext())											// 혹시 5개로 값을 다 빼낸 상태라면 값이 전부 없어 while문이ㅏ 돌지 않는다.
		{
			String key = it.next();									// key값을 String key에 담는다.
			nono.put(cnt+". "+key, "시간초과("+kor_quest_answer.get(key)+")");		// nono에  cnt와 key 값 , 시간초과 문자열과 답을 대입한다.
			cnt++;
		}
		
	}
	
	void printModule(LinkedHashMap< String,String> map)				// printModule 메소드 매개변수로 map을 받는다. 
	{
		Iterator it = map.entrySet().iterator();					// entrSet => key, value 값을 모두 뽑아준다. 
		
		while(it.hasNext())											// 개체가 존재한다면 참!
		{
			System.out.println(it.next());							// 개체값을 뽑아주면서 출력한다.
		}
	}
}

public class H2_0317_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		MulTimer_02 mm = new MulTimer_02();
		MulExam_02 me = new MulExam_02();
		
		MulExam_02Data md = new MulExam_02Data();
		
		md.kor_quest_answer.put("국어1", "1");
		md.kor_quest_answer.put("국어2", "2");
		md.kor_quest_answer.put("국어3", "3");
		md.kor_quest_answer.put("국어4", "4");
		md.kor_quest_answer.put("국어5", "5");
		md.eng_quest_answer.put("영어1", "6");
		md.eng_quest_answer.put("영어2", "7");
		md.eng_quest_answer.put("영어3", "8");
		md.eng_quest_answer.put("영어4", "9");
		md.eng_quest_answer.put("영어5", "10");
		md.mat_quest_answer.put("수학1", "11");
		md.mat_quest_answer.put("수학2", "12");
		md.mat_quest_answer.put("수학3", "13");
		md.mat_quest_answer.put("수학4", "14");
		md.mat_quest_answer.put("수학5", "15");
		
		mm.md = md;
		me.md = md;
		
		mm.start();
		me.start();
	}

}
