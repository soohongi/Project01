package practice;
//원, 삼각형, 사각형
//5개의 넓이 등수
//상속
//스캐너 0:입력순서 1:전체등수 2:도형별 등수

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
		System.out.println("0.입력순서" +"\t"+ "1.전체등수순서" +"\t"+ "2.도형별등수순서" +"\t");
		System.out.println("숫자를 입력하세요"+"\t");
	    int a=sc.nextInt();
		
		ShapeDhdh[] sp = {
				new SaDhmDh("삼각형","삼일이",3,3),
				new SaDhmDh("삼각형","삼이이",4,4),
				new SaDhmDh("삼각형","삼삼이",5,5),
				new SaDh("사각형","사일이",9,9),
				new SaDh("사각형","사이이",8,8),
				new SaDh("사각형","사삼이",7,7),
				new WonDh("원","원일이",10),
				new WonDh("원","원이이",30),
				new WonDh("원","원삼이",20)
		             };
		
		ShapeDhdh shp = new ShapeDhdh();
		
		shp.rankCal(sp);
		
	
	}

}