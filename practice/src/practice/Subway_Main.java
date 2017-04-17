package practice;
////////////////////////////////////////////////////////////////////////////////////////////////////////

import java.util.ArrayList;

/*����ö �뼱���� �����ϼ���
����ö ��

����ȣ, �� �̸�, �� �ҿ�ð�
�˻� : ���ۿ� , ���� �� ===> �������� �˻��� ���� ������� �� �� 
��� : ��𿪺��� ��� ���� , �� ����, �ҿ�ð�
���� / �ָ� ������ ������� �� �� ========>ȯ�¿� �غ��׸� �غ�!!!����*/

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
			System.out.println("�� �̸��� �����ϴ�. �ٽ� Ȯ���غ�����!!");
		}
		if(chk)*/
		
			System.out.println("��߿� :"+now.name+"��");
			System.out.println("������ :"+end.name+"��");
			System.out.println("���� �������� �� : "+cnt);
			System.out.println(s_tot_time-e_tot_time+"�� ���ҽ��ϴ�.");
			System.out.println();
		
		
		
	}
}




public class Subway_Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Subway sw = new Subway();
		
		sw.init("����", 3);
		sw.init("��ǳ���", 2);
		sw.init("���", 3);
		sw.init("��ǻ���", 5);
		sw.init("���տ��", 4);
		sw.init("�Ｚ", 3);
		sw.init("����", 1);
		sw.init("����", 2);
		sw.init("����", 4);
		
		
		sw.search("����", "��ǳ���");
		sw.search("���", "����");
		
		
		

	}

}