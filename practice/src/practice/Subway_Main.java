package practice;
////////////////////////////////////////////////////////////////////////////////////////////////////////

import java.util.ArrayList;

/*지하철 노선도를 구현하세요
지하철 역

역번호, 역 이름, 각 소요시간
검색 : 시작역 , 도착 역 ===> 이중으로 검색시 선택 가능토록 할 것 
결과 : 어디역부터 어디역 까지 , 역 갯수, 소요시간
평일 / 주말 나누어 연산토록 할 것 ========>환승역 해볼테면 해봐!!!ㅋㅋ*/

class Station
{
	String name;
	int num, time;
	static int tot_time;
	
	public Station(String name, int num, int time) {
		super();
		this.name = name;
		this.num = num;
		this.time = time;
	}
}

class Subway
{
	Station now;
	Station end;
	boolean chk=false;
	int cnt, s_tot_time, e_tot_time, t_station;
	ArrayList station_list = new ArrayList();
	
	void init(String name, int time)
	{
		station_list.add(0,(new Station(name, station_list.size()+1, time)));
		t_station = station_list.size();
	}
	
	void search(String s_name, String e_name)
	{
		
		s_tot_time=0;
		e_tot_time=0;
		for (int i = 0; i < station_list.size() ; i++) {
			s_tot_time+=((Station)station_list.get(i)).time;
			if(((Station)(station_list.get(i))).name == s_name)
			{
				now=((Station)station_list.get(i));
				//chk=true;
				break;
			}
		}
		
		end_search(e_name);
	}
	
	void end_search(String e_name)
	{
		

		for (int i = 0; i < station_list.size() ; i++) {
			e_tot_time+=((Station)station_list.get(i)).time;
			if(((Station)(station_list.get(i))).name == e_name)
			{
				end=((Station)station_list.get(i));
				//hk=true;
				break;
			}
			
		}
		
		cnt_station();
	}
	
	void cnt_station()
	{
		cnt = now.num-end.num;
		if(cnt<0)
			cnt*=-1;
		print();
	}
	
	
	void print()
	{
		
		/*if(!chk)
		{
			System.out.println("역 이름이 없습니다. 다시 확인해보세요!!");
		}
		if(chk)*/
		
			System.out.println("출발역 :"+now.name+"역");
			System.out.println("도착역 :"+end.name+"역");
			System.out.println("남은 정거장의 수 : "+cnt);
			System.out.println(s_tot_time-e_tot_time+"분 남았습니다.");
			System.out.println();
		
		
		
	}
}




public class Subway_Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Subway sw = new Subway();
		
		sw.init("강변", 3);
		sw.init("잠실나루", 2);
		sw.init("잠실", 3);
		sw.init("잠실새내", 5);
		sw.init("종합운동장", 4);
		sw.init("삼성", 3);
		sw.init("선릉", 1);
		sw.init("역삼", 2);
		sw.init("강남", 4);
		
		
		sw.search("강변", "잠실나루");
		sw.search("잠실", "선릉");
		
		
		

	}

}