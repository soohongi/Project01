package practice;

//mp3 노래듣기를 구현하세요
//1. 노래 정보 :  트랙번호, 노래제목, 가수
//2. 노래 리스트 -->next 에 넣기
//3. 구현내용 다음곡, 이전곡, 트랙번호
//////////////////////////////////////////////////////////////////////
//검색기능을 구현하세요
//1. 제목으로 검색
//2. 현재 트랙 이후부터 검색
//3. 제목, 가수를 구분하여 검색 
import java.util.Stack;

class Music_01{																// class Music_01 선언
	String title, singer;													// String title, singer 선언
	int tr;																	// int tr 선언
	public Music_01(int tr, String title, String singer) {					// Music_01 생성자 사용해서 데이터 입력 (초기화)
		super();															
		this.tr = tr;														
		this.title = title;
		this.singer = singer;
	}
	@Override
	public String toString() {												//toString을 이용하여 출력한다.
		return tr + ". " + title + " (" + singer + ")";
	}	
}

class MP3_01	
{
	Music_01 now=null;														// Music_01 class의 객체에 null값을 넣어 초기화 한다.
	
	Stack back = new Stack();												// Stack back 선언, 생성
	Stack next = new Stack();												// Stack next 선언, 생성
	int tot = 0;															// tot 초기화 ==>
	
	void input(String title, String singer)
	{
		/*for (int i = 0; i<next.size() ; i++) {
			((Music_01)next.get(i)).tr=next.size()-i;
		}*/
		
		
		next.add(0,new Music_01(next.size()+1,title, singer));				// Vector의 add를 이용하여 값을 0번째에 전부 집어넣기 때문에 각 데이터 값이 0번째에
																			// 들어갈 떄마다 원래 0번째에 있던 값을 밀어내서 들어가게 된다.
		tot = next.size();													// 전체 곡의 개수를 next.size()대입하여 구한다.
	}
	
	boolean nextModule()													// boolean형 nextModule()메소드
	{
		boolean res = false;												// boolean형 res를 선언 flase로 초기화
		
		if(!next.isEmpty())													// if문 ==> next스택에서 비었는지를 확인(.isEmpty)
		{
			if(now!=null)													// if문 ==> now가 비었는지를 확인
				back.push(now);												// back스택에  now에 있는 값을 push해서 넣는다.
																	////////// now의 값을 빼서 back에 넣는 건지 확인!!                 ///////////////
			now = (Music_01)next.pop();										// now에 next의 값을 pop(꺼낸다)하여 대입한다.
				
			res = true;														// res값을 true로 초기화
		}
		
		return res;															// res를 return한다.
	}
	
	boolean backModule()													// boolean형 backModule 메소드
	{
		boolean res = false;												// boolean형 res를 선언  flase 초기화
		
		if(!back.isEmpty())													// if문 ==> back 스택에서 비었는지를 확인(.isEmpty)
		{																	
			if(now!=null)													// if문 ==> now가 비었는지를 확인
				next.push(now);												// next스택에 now에 있는 값을  push해서 넣는다.
																	////////// now의 값을 빼서 back에 넣는 건지 확인!!                 ///////////////
			now = (Music_01)back.pop();										// now에 next의 값을 pop(꺼낸다)하여 대입한다.
			
			res = true;														// res값을 true로 초기화
		}
		
		return res;															// res를 return한다.
	}
	
	void goNext()															//goNext메소드
	{
		System.out.println("goNext()>>>>>>>");								//출력
		if(nextModule())													//if문 ==> nextModule이 참일때
			print();														//출력
		else																//if문이 flase일때
			System.out.println("재생할 곡이 없습니다.");							//출력
		
		
	}
	
	void goBack()															//goNext메소드
	{
		System.out.println("goBack()>>>>>>>");								//출력
		if(backModule())													//if문 ==> nextModule이 참일때
			print();														//출력
		else																//if문이 flase일때
			System.out.println("뒤로갈 곡이 없습니다.");							//출력
		
	}
	

	void searchT(String str)
	{
		System.out.println("곡명으로 검색합니당~~~~~~~~~~~~~~~~~~~~!!!!!!!!!!!!!");
		
		if(now == null)
		{
			now=(Music_01)next.peek();
		}

		for (int i = 0; i < back.size() ; i++) {
			if(((Music_01)(back.get(i))).title == str)
			{
				goTr(((Music_01)(back.get(i))).tr);
			}
		}
		
		for (int i = 0; i < next.size() ; i++) {
			if(((Music_01)(next.get(i))).title == str)
			{
				goTr(((Music_01)(next.get(i))).tr);
			}
		}
	}
	
	void singersearchT(String str)
	{
		System.out.println("가수명으로 검색합니당~~~~~~~~~~~~~~~~~~~~!!!!!!!!!!!!!");
		
		if(now == null)
		{
			now=(Music_01)next.peek();
		}

		for (int i = 0; i < back.size() ; i++) {
			if(((Music_01)(back.get(i))).singer == str)
			{
				goTr(((Music_01)(back.get(i))).tr);
			}
		}
		
		for (int i = 0; i < next.size() ; i++) {
			if(((Music_01)(next.get(i))).singer == str)
			{
				goTr(((Music_01)(next.get(i))).tr);
			}
		}
	}
	
	
	
	
	void nextsearchT(String str)
	{
		System.out.println("앞으로의 트랙을 검색합니당~~~~~~~~~~~~~~~~~~~~!!!!!!!!!!!!!");
		
		boolean chk=false;
		if(now == null)
		{
			now=(Music_01)next.peek();
		}

		for (int i = 0; i < next.size() ; i++) {
			if(((Music_01)(next.get(i))).title == str)
			{
				chk = true;
				goTr(((Music_01)(next.get(i))).tr);
			}
		}
		
		if(!chk)
		{
			System.out.println("해당 검색곡이 이후에는  없습니다.");
			System.out.println();
		}
	}
	
	void goTr(int tr)														// go tr메소드 (tr값을 받는다.)
	{
		//System.out.println("goTr("+tr+")>>>>>>>");						// 출력
		
		if(tr>tot || tr<0)													// if문 ==> tr의 범위 체크
		{
			System.out.println("트랙번호 확!");								// 출력
			return;															// 출력
		}
		
		while(true)															// whle문
		{
			if(now.tr>tr)		backModule();								// now의 번호가 검색할려는 번호보다 클때  뒤에서(back) 찾는다.
			else if(now.tr<tr)	nextModule();								// now의 번호가 검색할려는 번호보다 작을때  앞에서(next) 찾는다.
				
			if(now.tr==tr)	break;											// now의 번호가 찾는 번호와 같으면 break;
		}
		
		print();															// 출력
	}
	
	
	void print()															//출력문
	{
		
		System.out.println("재생곡:"+ now);
		System.out.println("뒤로:"+ back);
		System.out.println("앞으로:"+next);
		System.out.println();
	}
}

public class Mp3Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MP3_01 yoyo = new MP3_01();
		yoyo.input("시간을 달려서", "여자친구");
		yoyo.input("운동장을 달려서", "남자친구");
		yoyo.input("연병장을 달려서", "군대친구");
		yoyo.input("강의장을 달려서", "네모친구");
		yoyo.input("신검장을 달려서", "주헌친구");
		yoyo.input("앞자리를 달려서", "성문때려");
		yoyo.input("동사무소를 달려서", "한비결혼");
		yoyo.input("속초를 달려서", "애좀봐줘");
		yoyo.input("스미스를 달려서", "살려줘요");
		yoyo.input("주말을 달려서", "숙제해와");
	
		//yoyo.searchT("강의장을 달려서");
		yoyo.print();
		
		//yoyo.goNext();
		/*yoyo.goNext();
		yoyo.goNext();
		yoyo.goBack();
		yoyo.goBack();
		yoyo.goBack();*/
		
		
		yoyo.searchT("강의장을 달려서");
		yoyo.nextsearchT("동사무소를 달려서");
		yoyo.nextsearchT("강의장을 달려서");
		yoyo.singersearchT("여자친구");
		
		
		
		/*yoyo.goTr(5);
		yoyo.goTr(2);
		yoyo.goTr(11);
		yoyo.goTr(-1);
		yoyo.goTr(2);*/
	}

}
