package practice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

class TTStud // 학생정보찍어내는 클래스
{
   String name, res; // 이름,합/불
   LinkedHashMap jum = new LinkedHashMap(), /*점수*/ kind = new LinkedHashMap(); /*출력방식*/
   int sum, avg, rank, num; // 합계,평균,등수,번호
   
   TTStud(String ban, int num,String name, int kor,int eng, int mat, int lol) //남자정보
   {
      this(ban, num, name, kor, eng, mat);
      jum.put("롤",lol); // 점수LinkHashMap에 과목명과 점수를 넣어준다
      kind.put("성", "남자"); // 출력방식 LinkHashMap에 성과 남자를 넣어준다 (이후에 key값 성으로 남자,여자구분)
      cal(); // 여자 ==> 화장품,신분증,쿠폰,악세사리
   }
   
   TTStud(String ban,int num, String name, int kor,int eng, int mat) //여자정보
   {
      this.num = num;
      this.name = name;
      jum.put("국어",kor);
      jum.put("영어",eng);
      jum.put("수학",mat); // 점수LinkHashMap에 과목명과 점수를 넣어준다
      kind.put("반", ban); // 출력방식 LinkHashMap에 반과 반이름을 넣어준다 (이후에 key값 방으로 어떤반인지 구분)
      kind.put("성", "여자"); // 출력방식 LinkHashMap에 성과 남자를 넣어준다 (이후에 key값 성으로 남자,여자구분)
      cal();
   }
   
   void cal()
   {
      sum =0; // 합계 초기화 
      
      Collection vv = jum.values(); // 한명학생의 점수의 있는 값을 collection 형태의 변수 vv에 담아준다.
      
      for (Object oo : vv) { // 한명의 점수들의 합을 구한다.
         sum += (int)(oo); 
      }
      
      avg = sum/jum.size(); // 평균을 구한다.
       
      res = "불합격"; // res 기본값 불함격
      if(avg>=70) res="합격"; // 70 점 이상이면 res 는합격
   }

   @Override
   public String toString() {
      return  kind.get("반") + "\t" + name + "\t" + num + "\t" + kind.get("성") + "\t" + jum
            + "\t" + sum + "\t" + avg + "\t" + rank;
   }
   
   
}

class TTStCom_01 implements Comparator{
   Object kind;

   public TTStCom_01(Object kind) {
      super();
      this.kind = kind; // 메인에서 kind값을 전달 (성 or 반)
   }

   @Override
   public int compare(Object o1, Object o2) {
      // TODO Auto-generated method stub
      HashMap str = new HashMap<>(); // HashMap을 선언및생성 
      str.put("반", "개나리, 소나리, 닭나리, 말마리"); // 생성한 HashMap에 반과 성의 정보들을 넣어준다.
      str.put("성", "남자, 여자");
      
      int res=1; //res 값을 1로 초기화 
      
      if(kind instanceof String) // 들어온 값이 String 으로 변환이 가능하다면
      {
         
         res = ((String)str.get(kind)).indexOf(((String)o1))- // 입력받은 값(반,성)을 key값으로 가지고와서 indexof로 value값 추출
         //1.위에서 만든 str의 key값으로 value를 가지고와서 몇번째인지 숫자로 리턴
               ((String)str.get(kind)).indexOf(((String)o2)); // 입력받은 값(반,성)을 key값으로 가지고와서 indexof로 value값 추출
         // 비교한 값을 res값에 대입
         //System.out.println(o1+":"+o2);
      }else{ // 들어온값이 String이 아니라면
         TTStud me = (TTStud)o1;
         TTStud you = (TTStud)o2;
         System.out.println(o1+":"+o2);
         res = you.avg-me.avg; // 너의 평균 - 나의 평균 => 나의 평균이 크면 왼쪽 , 나의 평균이 작으면 오른쪽
         if(res==0) res = me.num - you.num; // 만약 평균이 같다면 반번호로 비교
      }
      
      return res;
   }
}

public class TreeMap_001 {

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      List input = new ArrayList();
      // 리스트 input에 학생정보들을 넣어준다.(클래스를 생성해 정보들이 가공되어 진 값들)
      input.add(new TTStud("소나리",2,"윤지섭",88,89,87,74 ));
      input.add(new TTStud("개나리",3,"김경호",78,87,65,54 ));
      input.add(new TTStud("소나리",1,"주민제", 43,32,21 ));
      input.add(new TTStud("말마리",2,"선한비",34,56,78 ));
      input.add(new TTStud("개나리",2,"송정윤", 89,90,98));
      input.add(new TTStud("말마리",2,"정수홍", 87,76,65,54));
      input.add(new TTStud("개나리",5,"박현진",89,90,98));
      input.add(new TTStud("소나리",2,"정연욱", 12,23,34,45));
      
      System.out.println("List input : "+input); // 리스트에 있는값들을 알기위해 출력해봄
      System.out.println();
      
      String kind = "반"; // kind 값을 지정해줌 ("성" or "반")
      
      TreeMap total = new TreeMap(new TTStCom_01(kind)); // TreeMap 선언 및 생성 (생성할때 Comparator 클레스 생성)
      // total TreeMap 정렬시 TTStCom_01를 통해 정렬을 함
      
      for(Object oo : input) // 학생수만큼 돌린다 (oo : 학생의 정보들)
      {
         TTStud ts = (TTStud)oo; // TTStud 형태의 ts에 학생의 정보들을 넣는다.
         
         TreeSet nowSS; //   TreeSet 선언
         
         if(total.containsKey(ts.kind.get(kind))) // TreeMap.containsKey()??????여자,남자??
            nowSS = (TreeSet)total.get(ts.kind.get(kind)); // nowSS에 
         else{
            
            nowSS = new TreeSet(new TTStCom_01(0)); // nowSS 새롭게 생성 (생성할때 Comparator 클레스 생성)
                                          // total TreeMap 정렬시 TTStCom_01를 통해 정렬을 함
            total.put(ts.kind.get(kind),nowSS); // Total(TreeMap)에 key : 가지고온 성별 , value : 위에서 생성한 TreeSet 
         }   // total 에 넣음과 동시에 성별(반)비교해서 정렬
         
         nowSS.add(ts); // TreeSet 에 학생의 정보들은 넣어줌
         // nowSS에 넣음과 동시에 평균을 비교해서 큰 순서대로 정렬
      }
      
      
      Iterator it = total.keySet().iterator(); // total의 key값을 it 에 넣는다.
      
      while(it.hasNext()) // 키값이 있을때까지 돌린다.
      {
         Object key = it.next(); //key 에 it(total의 key값)
         
         System.out.println(key+">>>>>>"); // key값 출력(성별)
         Iterator sit = ((TreeSet)total.get(key)).iterator(); // total의 key값으로 value 값을 sit에 넣는다.
         
         while(sit.hasNext()) // 가져온 정보들만큼
         {
            System.out.println(sit.next()); // 출력
         }
         
      }
      
      
   }

}