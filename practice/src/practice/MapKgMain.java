package practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeMap;
/*//map을 이용하여 반 성적을 출력하세요
//key : 반_번호  value : 성명, 국어, 영어, 수학 점수를 입력, 처리하는 클래스(생성자로 입력할 것)
//출력물 : 

개나리반
번호, 성명, 국어, 영어, 수학, 총점, 평균


/// 반 순서 - 개나리, 소나리, 닭나리, 말마리
//반, 과목별 총점, 평균 출력
//반별 번호순서대로 출력 할 것
*/
class Student{
   String name,ban;
   int num,avg,sum=0;
   int kor,eng,mat;
   int [] jum;
   
   public Student(String name, String ban, int num,int kor,int eng,int mat) {
      super();
      this.name = name;
      this.ban = ban;
      this.num = num;
      this.kor = kor;
      this.eng = eng;
      this.mat = mat;
      
      this.jum = new int[]{kor,eng,mat};
   }
   
   void cal(){
      for(int jj: jum){
         this.sum+=jj;
      }
      this.avg=sum/jum.length;
   }

@Override
public String toString() {
	return "Student [name=" + name + ", ban=" + ban + ", num=" + num + ", avg=" + avg + ", sum=" + sum + ", kor=" + kor
			+ ", eng=" + eng + ", mat=" + mat + "]";
}
   
   
}

/*class Turn implements Comparator{

   @Override
   public int compare(Object o1, Object o2) {
      // TODO Auto-generated method stub
      String str="개나리, 소나리, 닭나리, 말마리";
      
      return str.indexOf(((String)o1))-
				str.indexOf(((String)o2));
   }
}*/

public class MapKgMain {

   public static void main(String[] args) {
      // TODO Auto-generated method stub
	   
	   Student[] stu={
               new Student("AAA","개나리",1,99,99,99),
               new Student("BBB","소나리",2,67,70,65),
               new Student("CCC","개나리",2,90,92,93),
               new Student("DDD","닭나리",1,65,62,58),
               new Student("EEE","소나리",3,81,36,79),
               new Student("FFF","말마리",1,89,91,92),
               new Student("GGG","소나리",1,51,69,71),
               new Student("HHH","닭나리",2,12,21,33),
               new Student("III","말마리",2,22,22,22)
         };
	   
	  TreeMap ban = new TreeMap();
	  
      for (Student st: stu) 
      {
         TreeMap nowPP;
         
         if(ban.containsKey(st.ban)){
            nowPP = (TreeMap)ban.get(st.ban);
         }
         else{
            nowPP=new TreeMap(/*new Turn()*/);
         }

         ban.put(st.ban, nowPP);
        
         Student [] sst = new Student[0];
         
         if(nowPP.containsKey(st.num))
         {
        	 Student [] buf = new Student[sst.length+1];
        	 
        	 for (int i = 0; i < sst.length; i++) {
 				buf[i] = sst[i];
        	 }
        	 
        	 buf[sst.length] = new Student(st.name, st.ban, st.num, st.kor, st.eng, st.mat);
        	 sst = buf;	
         }
         
         nowPP.put(st.num, sst);
         
         
         for (int i = 0; i < sst.length; i++) {
        	 System.out.println(sst[i].toString());
		}
         
         
         Iterator it = ban.keySet().iterator();
         
         while(it.hasNext())
         {
            Object key = it.next();
            System.out.println(key+">>>");
            
            TreeMap ppp = (TreeMap)ban.get(key);
            
            Iterator pit = ppp.keySet().iterator();
            
            while(pit.hasNext())
            {
               Object kkey = pit.next();
               System.out.println("\t"+kkey+":"+(ppp.get(kkey)));
            }   
            
         } 
      }

   }

}