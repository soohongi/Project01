package practice;
//��, �ﰢ��, �簢��
//5���� ���� ���
//���
//��ĳ�� 0:�Է¼��� 1:��ü��� 2:������ ���

import java.util.Scanner;

class ShapeDhdh
{
	String kind, name;
	int x,y,area;
	int rank, sort;
	double pi=3.14;
	
	ShapeDhdh [] sp;
	
	void rankCal(ShapeDhdh [] sp)
	{
		this.sp = sp;
		
		for(int i=0; i<sp.length; i++)
		{
			sp[i].rank=1;
			
			for(int j=0; j<sp.length; j++)
			{
				if(sp[i].area < sp[j].area)
				{
					sp[i].rank++;
				}
			}
		}
		print();
		
	}
	
	

	void print()
	{
		for (int i = 0; i < sp.length; i++) {
			String str= sp[i].kind+ "\t"+ sp[i].name+ "\t"+ sp[i].area+ "\t"+ sp[i].rank+ "\t";
			System.out.println(str);
		}
	}
}

class SaDhmDh extends ShapeDhdh
{
	
	SaDhmDh(String kind, String name, int x, int y)
	{
	    this.kind=kind;
	    this.name=name;
	    this.x=x;
	    this.y=y;

		area=x*y/2;
		//print();
	}
	
	
}

class SaDh extends ShapeDhdh
{
	
	SaDh(String kind, String name, int x, int y)
	{
		this.kind=kind;
		this.name=name;
		this.x=x;
		this.y=y;
		
		area=x*y;
	//	print();
	}
	

}

class WonDh extends ShapeDhdh
{
	
	WonDh(String kind, String name, int x)
	{
		this.kind=kind;
		this.name=name;
		this.x=x;
		
		area=(int)(x*x*pi);
		//print();
		
	}
	
	
}

public class Dhdhdhdh {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("0.�Է¼���" +"\t"+ "1.��ü�������" +"\t"+ "2.�������������" +"\t");
		System.out.println("���ڸ� �Է��ϼ���"+"\t");
	    int a=sc.nextInt();
		
		ShapeDhdh[] sp = {
				new SaDhmDh("�ﰢ��","������",3,3),
				new SaDhmDh("�ﰢ��","������",4,4),
				new SaDhmDh("�ﰢ��","�����",5,5),
				new SaDh("�簢��","������",9,9),
				new SaDh("�簢��","������",8,8),
				new SaDh("�簢��","�����",7,7),
				new WonDh("��","������",10),
				new WonDh("��","������",30),
				new WonDh("��","������",20)
		             };
		
		ShapeDhdh shp = new ShapeDhdh();
		
		shp.rankCal(sp);
		
	
	}

}