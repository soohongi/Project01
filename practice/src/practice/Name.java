package practice;

import java.util.Scanner;
import java.util.regex.Pattern;

////ȸ�� ���� ��ȿ�� �˻縦 �ǽ��ϼ���
/*
1. ���̵� : ���� ���� ����
2. ��� , ���Ȯ�� 
3. �̸���  -  ���̵�:����,����   @  ������ : ���� ��
4. ��ȭ��ȣ - ���� :  ###-####-####,   ##(#)-###-####
5. �̸� (�ѱ۸� ����)
6. �ֹι�ȣ 
7. ���� ÷��-->����,����.�̹��� Ȯ����
�̹���(jpg, jpeg, bmp, png, gif)  --  ��ҹ��� ���о���
8. �����ȣ �˻� - ������ (�ʼ��˻�)
����ó���� ó���� ��
*/
public class Name {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		Pattern pp;
		String input;
		String input2;

		while(true)
		{
			try
			{
			/*	System.out.print("���̵� �Է� :");
				input = sc.nextLine();
				if(!Pattern.matches("[0-9a-zA-Z]*", input))
			        throw new Exception("���̵� ���Ŀ���");
			    
			    System.out.print("��й�ȣ �Է� :");
			    input = sc.nextLine();
				if(!Pattern.matches(".*", input))
			        throw new Exception("��й�ȣ");
			    
			    System.out.print("��й�ȣ Ȯ�� :");
			    input2 = sc.nextLine();
			    if(!input2.equals(input))
			    	throw new Exception("��й�ȣ�� �ٸ��ϴ�.");
			    
			    System.out.print("�̸��� �Է� :");
			    input = sc.nextLine();
			    if(!Pattern.matches("[0-9a-zA-Z]{1,}@[0-9a-zA-Z]{1,}[.][0-9a-zA-Z]{1,}", input))
			        throw new Exception("�̸��� ���Ŀ���");
			    
			    
			    
			    System.out.print("��ȭ��ȣ �Է� :");
			    input = sc.nextLine();
				if(!Pattern.matches("[0-9]{2,3}-[0-9]{3,4}-[0-9]{4}", input))
			        throw new Exception("��ȭ��ȣ ���Ŀ���");
			    
			    
			    System.out.print("�̸� �Է� : ");
			    input = sc.nextLine();
				if(!Pattern.matches("[��-�R]{2,4}", input))
			        throw new Exception("�̸� ���Ŀ���");
			    
			    System.out.print("�ֹι�ȣ �Է� :");
			    input = sc.nextLine();
				if(!Pattern.matches("[0-9]{6}-[0-9]{7}", input))
			        throw new Exception("�ֹι�ȣ ���Ŀ���");
			    
			      */  
		        
			    System.out.print("���� ÷�� :");
			    input = sc.nextLine();
				if(!Pattern.matches("[0-9a-zA-Z]*[.](jpg|jpeg|bmp|png|gif|JPG|JPEG|BMP|PNG|GIF)", input))
			        throw new Exception("���� ���Ŀ���");
			        
			    break;
	
			}
			catch (Exception e) 
			{
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
		}
		System.out.println("�α���!");
		
	}

}
