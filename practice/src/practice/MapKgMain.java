package practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeMap;
/*//map�� �̿��Ͽ� �� ������ ����ϼ���
//key : ��_��ȣ  value : ����, ����, ����, ���� ������ �Է�, ó���ϴ� Ŭ����(�����ڷ� �Է��� ��)
//��¹� : 

��������
��ȣ, ����, ����, ����, ����, ����, ���


/// �� ���� - ������, �ҳ���, �߳���, ������
//��, ���� ����, ��� ���
//�ݺ� ��ȣ������� ��� �� ��
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
      String str="������, �ҳ���, �߳���, ������";
      
      return str.indexOf(((String)o1))-
				str.indexOf(((String)o2));
   }
}*/

public class MapKgMain {

   public static void main(String[] args) {
      // TODO Auto-generated method stub
	   
	   Student[] stu={
               new Student("AAA","������",1,99,99,99),
               new Student("BBB","�ҳ���",2,67,70,65),
               new Student("CCC","������",2,90,92,93),
               new Student("DDD","�߳���",1,65,62,58),
               new Student("EEE","�ҳ���",3,81,36,79),
               new Student("FFF","������",1,89,91,92),
               new Student("GGG","�ҳ���",1,51,69,71),
               new Student("HHH","�߳���",2,12,21,33),
               new Student("III","������",2,22,22,22)
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