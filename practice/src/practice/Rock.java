package practice;

import java.util.Scanner;

public class Rock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int input=0;
		
		while(input !=4)
		{
			System.out.println("+++++++가위 바위 보+++++++");
			System.out.println("1.가위       2.바위        3.보     4.종료");
			input=sc.nextInt();
			
			int com = (int)(Math.random()*3)+1;
			
			if(input == 1)
			{
				if(com == 1)
					System.out.println("비김");
				else if(com == 2)
					System.out.println("패배");
				else
					System.out.println("승리!");
			}
			else if(input == 2)
			{
				if(com == 1)
					System.out.println("승리");
				else if(com == 2)
					System.out.println("비김");
				else
					System.out.println("패배");
			}
			else if(input ==3)
			{
				if(com == 1)
					System.out.println("패배");
				else if(com == 2)
					System.out.println("승리");
				else
					System.out.println("비김");
				
			}
		}
		
		System.out.println("종료되었습니다.");
	}
}