package practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;


class Studcom
{
   String name;
   int sum,avg,ban,kyo,sx;
   int [] jum;
   String [] index = {"남자", "여자"};
   
   
   Studcom(String name, int ban, int kor,int eng,int mat, int kyo)
   {
      this.name=name;
      this.ban=ban;
      jum = new int []{kor,eng,mat};
      this.sx = 0;
      
      cal();
   }
   
   Studcom(String name, int ban, int kor,int eng,int mat)
   {
      this.name=name;
      this.ban=ban;
      jum = new int []{kor,eng,mat};
      this.sx = 1;
      
      cal();
   }
   
   void cal()
   {
      sum=0;
      for(int jj : jum)
         sum += jj;
      
      avg = sum/jum.length;
         
   }

   @Override
   public String toString() {
   
      return "Studcom [ban=" + ban + ", gender="+ index[sx] +", name=" + name + ", jum=" + Arrays.toString(jum) +
            ", sum=" + sum + ", avg=" + avg + "] ";
   }
}

class Res
{
	
	
}

class Treecom implements Comparator
{
	int kind;
	
   public Treecom(int kind) {
		super();
		this.kind = kind;
	}

@Override
   public int compare(Object o1, Object o2) {
      // TODO Auto-generated method stub
      
      Studcom me = (Studcom) o1;
      Studcom you = (Studcom) o2;
      int res = 0;
      
      
      
     if(kind == 0)
     {
	        if((res = me.name.compareTo(you.name))==0) 
	        res=1;
     }
     
     else if(kind == 1)
     {
    	 if(0 == (res = you.avg - me.avg))
         {
            if((res = me.name.compareTo(you.name))==0) 
            res=1;
            
         }
     }
     
     else if(kind == 2)
     {
		if (0 == (res = me.ban - you.ban)) 
		{
			if (0 == (res = you.avg - me.avg)) 
			{
				if ((res = me.name.compareTo(you.name)) == 0)
					res = 1;
				}
			}
     }
     
     else if(kind == 3)
     {
    	if (0 == (res = me.sx - you.sx)) 
 		{
 			if (0 == (res = you.avg - me.avg)) 
 			{
 				if ((res = me.name.compareTo(you.name)) == 0)
 					res = 1;
 				}
 			}
     }
     
     else if(kind == 4)
     {
		if (0 == (res = me.ban - you.ban)) 
		{
			if (0 == (res = me.sx - you.sx)) 
			{
				if (0 == (res = you.avg - me.avg)) 
				{
					if ((res = me.name.compareTo(you.name)) == 0)
						res = 1;
				}
			}
		}
     }

      return res;
   }
   
}



public class Hw_0313 {

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      
		Scanner sc = new Scanner(System.in);
		int kind;
		System.out.println("0.입력 순서 \t1.전체 랭크 \t2.반 별랭크 \t3.성 별랭크 \t4.반&성 별랭크");
		System.out.print("입력하시오. : ");
		kind = sc.nextInt();

		TreeSet set = new TreeSet(new Treecom(kind));

		set.add(new Studcom("AAA", 1, 78, 98, 56, 81));
		set.add(new Studcom("BBB", 2, 90, 78, 86));
		set.add(new Studcom("CCC", 2, 58, 48, 67, 42));
		set.add(new Studcom("DDD", 1, 68, 78, 96, 31));
		set.add(new Studcom("EEE", 2, 88, 48, 96));
		set.add(new Studcom("FFF", 1, 68, 78, 95));
		set.add(new Studcom("GGG", 2, 88, 48, 96));
		set.add(new Studcom("HHH", 1, 75, 88, 72));
		set.add(new Studcom("HHI", 1, 75, 88, 72));

		Iterator it = set.iterator();

		while (it.hasNext())
			System.out.println(it.next());

   }

}