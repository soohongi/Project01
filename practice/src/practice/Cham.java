package practice;
import java.util.*;
public class Cham {

 /**
  * @param args
  */
 public static void main(String[] args) {
  // TODO Auto-generated method stub
  System.out.println(Math.PI);
  System.out.println(Math.ceil(34.46));//�ø�
  System.out.println(Math.floor(34.76));//����
  System.out.println(Math.round(34.46));//�ݿø�
  System.out.println(Math.abs(34.46));//���밪
  System.out.println(Math.max(20, 30));//ū��
  System.out.println(Math.min(20, 30));//������
  System.out.println(Math.pow(2,3));//����
  System.out.println(Math.sqrt(2));//������
  System.out.println(Math.random());//����
  //0< ���� <1
  
  System.out.println((int)(Math.random()*46)+5);//����
  
  System.out.println("������ ����");
 Scanner sc = new Scanner(System.in);
  int input=0; 
  while(input!=3)
  {
   System.out.println("1:����, 2:������ 3:����");
   System.out.print("�Է�:");
   input=sc.nextInt();
   int com = (int)(Math.random()*2)+1;
   if(com==input)
    System.out.println("��");
   else
    System.out.println("��");
   
  }
  System.out.print("��������");
 }

}

