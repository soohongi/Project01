package practice;

class Car
{
   String name;
   String kind;
   int speed;
   int safety;
   int fule;
   int spec;
   int rank;
   int sort;
   int [] jum;   
   
   /*String car(String kind,String name)
   {
      
   }*/
   void print()
   {
      String  str = "차종:"+this.kind+"\t"+
            "차명:"+this.name+"\t"+
            "속도:"+this.speed+"\t"+
            "안정성:"+this.safety+"\t"+
            "연비:"+this.fule+"\t"+
            "총점:"+spec+"\t"+
            "등수:"+rank;
            
            System.out.println(str);
   }
   
   
}

class Carfactory extends Car
{
   
   
   
   Car carmake (String kind,String name,int speed,int safety,int fule)
   {
      
      this.name = name;
      this.kind = kind;
      this.speed = speed;
      this.safety = safety;
      this.fule = fule;
      jum = new int[]{speed,safety,fule};
      spccal();
      /*print();*/
      return this;
      
   }
   
   void spccal()
   {
      
      
      double[][] rate = {
            {0.3,0.4,0.3},
            {0.2,0.4,0.4},
            {0.6,0.2,0.2}      
      };
      
      spec = 0;
      
      for (int i = 0; i < jum.length; i++) {
            
         
         
          
            if(this.kind.equals("승합차")){
               
            spec += jum[i]*rate[0][i];
            
            }
            
            
            if (this.kind.equals("트럭")){
               spec += jum[i]*rate[1][i];
            }
            
         
            if(this.kind.equals("스포츠"))
            {
               spec += jum[i]*rate[2][i];
            }
         
      }
   }
      
      
   
   
   
   
}

class Rankv
{
   Car[] ca1;

   public Rankv(Car[] ca1) {
      super();
      this.ca1 = ca1;
      rankcal();
      rankprint();
   }
   
   void rankcal()
   {
   
      
         for (int i = 0; i < ca1.length; i++) {
            ca1[i].rank =1;
         for (int j = 0; j < ca1.length; j++) {
            if(ca1[i].spec<ca1[j].spec){
               ca1[i].rank++;
               ca1[i].sort++;
               
            }
            
         }
         
      
   }
  }
   
   void rankprint()
   {
      for (int r = 0; r < ca1.length; r++) {
         for (int i = 0; i < ca1.length; i++) {
            if(r==ca1[i].sort)
            ca1[i].print();
      }
      
         
      }
   }
}
   
public class Khkh {

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      
   
      Carfactory cf = new Carfactory();
      Carfactory cf1 = new Carfactory();
      Carfactory cf2 = new Carfactory();
      Carfactory cf3 = new Carfactory();
      Carfactory cf4 = new Carfactory();
      Carfactory cf5 = new Carfactory();
      Carfactory cf6 = new Carfactory();
      Carfactory cf7 = new Carfactory();
      
      
      
      Car[] ca1 = { 
      cf.carmake("승합차", "아반떄",80,70,90),
      cf1.carmake("트럭", "밴츠",60,90,70),
      cf2.carmake("스포츠","람보르",90,50,50),
      cf3.carmake("트럭", "포터",30,90,50),
      cf4.carmake("스포츠", "포르쉐",100,78,66),
      cf5.carmake("승합차", "k5",70,77,80),
      cf6.carmake("승합차", "k7",80,83,86),
      cf7.carmake("승합차", "k9",90,91,92)
      };
   
      
      Rankv rk = new Rankv(ca1);
      
   }

}