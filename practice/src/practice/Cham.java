package practice;
import java.util.*;
public class Cham {

 /**
  * @param args
  */
 public static void main(String[] args) {
  // TODO Auto-generated method stub
  System.out.println(Math.PI);
  System.out.println(Math.ceil(34.46));//올림
  System.out.println(Math.floor(34.76));//내림
  System.out.println(Math.round(34.46));//반올림
  System.out.println(Math.abs(34.46));//절대값
  System.out.println(Math.max(20, 30));//큰수
  System.out.println(Math.min(20, 30));//작은수
  System.out.println(Math.pow(2,3));//지수
  System.out.println(Math.sqrt(2));//제곱근
  System.out.println(Math.random());//난수
  //0< 난수 <1
  
  System.out.println((int)(Math.random()*46)+5);//난수
  
  System.out.println("참참참 게임");
 Scanner sc = new Scanner(System.in);
  int input=0; 
  while(input!=3)
  {
   System.out.println("1:왼쪽, 2:오른쪽 3:종료");
   System.out.print("입력:");
   input=sc.nextInt();
   int com = (int)(Math.random()*2)+1;
   if(com==input)
    System.out.println("패");
   else
    System.out.println("승");
   
  }
  System.out.print("게임종료");
 }

}

