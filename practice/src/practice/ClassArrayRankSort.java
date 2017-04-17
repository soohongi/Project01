package practice;

import java.util.Scanner;

class Shape
{
	String name, kind;
	int border;
	int area;
	int [] rank = new int [3];
	int [] sort = new int [3];
	final double pi = 3.14;
	
	void print(int input)
	{
		System.out.println(name+"\t"+border+"\t"+area+"\t"+rank[input]);
	}
	
}

class Circle extends Shape
{
	
	int r;

	public Circle(String name, int r) {
		super();
		this.kind = "��";
		this.name = name;
		this.r = r;
		
		cal();
	}
	
	void cal()
	{
		this.border = (int)(2*pi*r);
		this.area = (int)(pi*r*r);
	}
	
}

class Rec extends Shape
{
	int x,y;

	public Rec(String name, int x, int y) {
		super();
		this.kind = "�簢��";
		this.name = name;
		this.x = x;
		this.y = y;
		
		cal();
	}
	
	void cal()
	{
		this.border = (x+y)*2;
		this.area = x*y;
	}
}

class Tri extends Shape
{
	int x,y,z;

	public Tri(String name, int x, int y, int z) {
		super();
		this.kind = "�ﰢ��";
		this.name = name;
		this.x = x;
		this.y = y;
		this.z = z;
		
		cal();
	}
	
	void cal()
	{
		this.border = x+y+z;
		this.area = (x*y)/2;
	}
}

class Rank
{
	int input;
	Scanner sc = new Scanner(System.in);
	Shape [] sh;

	void arearank(Shape [] sh)
	{
		this.sh = sh;
		System.out.println("0. �Է¼���     1. ��ü����     2. ������ ����");
		System.out.print("�Է��ϼ���. ==> ");
		input = sc.nextInt();
		
		for (int i = 0; i < sh.length; i++) {
			for (int j = 0; j < 3; j++) {
				sh[i].rank[j] = 1;
				
				
				if(sh[i].kind == "�簢��")
				{
					sh[i].sort[2]=5;
				}
				
				if(sh[i].kind == "�ﰢ��")
				{
					sh[i].sort[2]=10;
				}
			}
			
			for (int j = 0; j < sh.length; j++) {
				
				if(sh[i].area<sh[j].area)
				{
					sh[i].rank[0]++;
					
					
					sh[i].rank[1]++;
					sh[i].sort[1]++;
					
					if(sh[i].kind == sh[j].kind)
					{
						sh[i].rank[2]++;
						sh[i].sort[2]++;
					}
				}
			}
		}
		print();
	}
	
	void print()
	{
		System.out.println("���� �̸�\t�ѷ�\t����\t����rank");
		System.out.println("====================================");
		for (int i = 0; i < sh.length; i++) {
			if(input == 0)
			{
				sh[i].print(input);
			}
			else
			{
				
				for (int j = 0; j < sh.length; j++) {
					if(i == sh[j].sort[input])
					{
						sh[j].print(input);
					}
				}
			}
		}
	}
}


public class ClassArrayRankSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Rank rk = new Rank();
		
		Shape [] sh ={
				new Circle("��1", 21),
				new Circle("��2", 6),
				new Circle("��3", 13),
				new Circle("��4", 16),
				new Circle("��5", 36),
				new Rec("�簢1", 21, 21),
				new Rec("�簢2", 12, 21),
				new Rec("�簢3", 16, 36),
				new Rec("�簢4", 22, 41),
				new Rec("�簢5", 19, 32),
				new Tri("�ﰢ1", 25, 11, 11),
				new Tri("�ﰢ2", 20, 36, 20),
				new Tri("�ﰢ3", 31, 19, 13),
				new Tri("�ﰢ4", 22, 21, 30),
				new Tri("�ﰢ5", 33, 23, 31)
		};
		
		rk.arearank(sh);

	}

}
