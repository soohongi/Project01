package practice;

import java.util.Iterator;
import java.util.LinkedHashMap;

import javax.swing.JOptionPane;

class MulTimer extends Thread
{
   MulExamData md;
   @Override
   public void run() {
      // TODO Auto-generated method stub
      for (int i = 60; i >=0; i--) {
         try {
            
            sleep(100);
            if(md.chk)
               break;
            
            System.out.println(i);
            
            if( 0 == i )
            {
            	throw new InterruptedException("시간 초과");
            }
         } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            //e.printStackTrace();
            System.out.println(e.getMessage());
         }
         
      }
      md.chk=true;
      
      System.out.println("시험 종료");
   }
}

class MulExam extends Thread
{
   LinkedHashMap<String, String> map;
   LinkedHashMap<Integer, String> cal=new LinkedHashMap();
   MulExamData md;
   public MulExam(LinkedHashMap<String, String> map) {
      super();
      this.map = map;
   }

   int cnt=1;

   
   @Override
   public void run() {
      
      Iterator<String> it = map.keySet().iterator();
      // TODO Auto-generated method stub
      while(it.hasNext())
      {
         String key = it.next();
         if(md.chk) break;
         String input = JOptionPane.showInputDialog(key);
         if(md.chk) break;
         System.out.println("입력값:"+input);
         cal.put(cnt, input);
         cnt++;
         
      }
      md.chk=true;
      md.chk(cal);
   }
}
class MulExamData
{
   
   LinkedHashMap<String, String> map;
   
   boolean chk = false;
   public MulExamData(LinkedHashMap<String, String> map) {
      super();
      this.map = map;
   }   
   
   void chk(LinkedHashMap<Integer, String> m){
      Iterator me= map.keySet().iterator();
      
      int cnt=1;
      while(me.hasNext()){
         String key=(String)me.next();
         if(map.get(key).equals(m.get(cnt))){
            System.out.println(cnt+"번 정답" +" "+"입력값: "+m.get(cnt)+"   정답: "+map.get(key));
         }
         else{
            System.out.println(cnt+"번 오답" +" "+"입력값: "+m.get(cnt)+"   정답: "+map.get(key));
         }
         cnt++;
      }
   }
   
   
   
   
}

public class ExamMain {

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      LinkedHashMap< String,String>map = new LinkedHashMap<>();
      map.put("2+3", "5");
      map.put("4*5", "20");
      map.put("8-5", "3");
      map.put("15/3", "5");
      map.put("9%4", "1");
      MulTimer mm = new MulTimer();
      MulExam me = new MulExam(map);
      
      MulExamData md = new MulExamData(map);
      mm.md = md;
      me.md = md;
      mm.start();
      me.start();
      
   }

}