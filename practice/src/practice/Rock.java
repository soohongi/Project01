package practice;

import java.util.Scanner;

public class Rock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int input=0;
		
		while(input !=4)
		{
			System.out.println("+++++++���� ���� ��+++++++");
			System.out.println("1.����       2.����        3.��     4.����");
			input=sc.nextInt();
			
			int com = (int)(Math.random()*3)+1;
			
			if(input == 1)
			{
				if(com == 1)
					System.out.println("���");
				else if(com == 2)
					System.out.println("�й�");
				else
					System.out.println("�¸�!");
			}
			else if(input == 2)
			{
				if(com == 1)
					System.out.println("�¸�");
				else if(com == 2)
					System.out.println("���");
				else
					System.out.println("�й�");
			}
			else if(input ==3)
			{
				if(com == 1)
					System.out.println("�й�");
				else if(com == 2)
					System.out.println("�¸�");
				else
					System.out.println("���");
				
			}
		}
		
		System.out.println("����Ǿ����ϴ�.");
	}
}