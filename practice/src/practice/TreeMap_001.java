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

class TTStud // �л��������� Ŭ����
{
   String name, res; // �̸�,��/��
   LinkedHashMap jum = new LinkedHashMap(), /*����*/ kind = new LinkedHashMap(); /*��¹��*/
   int sum, avg, rank, num; // �հ�,���,���,��ȣ
   
   TTStud(String ban, int num,String name, int kor,int eng, int mat, int lol) //��������
   {
      this(ban, num, name, kor, eng, mat);
      jum.put("��",lol); // ����LinkHashMap�� ������ ������ �־��ش�
      kind.put("��", "����"); // ��¹�� LinkHashMap�� ���� ���ڸ� �־��ش� (���Ŀ� key�� ������ ����,���ڱ���)
      cal(); // ���� ==> ȭ��ǰ,�ź���,����,�Ǽ��縮
   }
   
   TTStud(String ban,int num, String name, int kor,int eng, int mat) //��������
   {
      this.num = num;
      this.name = name;
      jum.put("����",kor);
      jum.put("����",eng);
      jum.put("����",mat); // ����LinkHashMap�� ������ ������ �־��ش�
      kind.put("��", ban); // ��¹�� LinkHashMap�� �ݰ� ���̸��� �־��ش� (���Ŀ� key�� ������ ������� ����)
      kind.put("��", "����"); // ��¹�� LinkHashMap�� ���� ���ڸ� �־��ش� (���Ŀ� key�� ������ ����,���ڱ���)
      cal();
   }
   
   void cal()
   {
      sum =0; // �հ� �ʱ�ȭ 
      
      Collection vv = jum.values(); // �Ѹ��л��� ������ �ִ� ���� collection ������ ���� vv�� ����ش�.
      
      for (Object oo : vv) { // �Ѹ��� �������� ���� ���Ѵ�.
         sum += (int)(oo); 
      }
      
      avg = sum/jum.size(); // ����� ���Ѵ�.
       
      res = "���հ�"; // res �⺻�� ���԰�
      if(avg>=70) res="�հ�"; // 70 �� �̻��̸� res ���հ�
   }

   @Override
   public String toString() {
      return  kind.get("��") + "\t" + name + "\t" + num + "\t" + kind.get("��") + "\t" + jum
            + "\t" + sum + "\t" + avg + "\t" + rank;
   }
   
   
}

class TTStCom_01 implements Comparator{
   Object kind;

   public TTStCom_01(Object kind) {
      super();
      this.kind = kind; // ���ο��� kind���� ���� (�� or ��)
   }

   @Override
   public int compare(Object o1, Object o2) {
      // TODO Auto-generated method stub
      HashMap str = new HashMap<>(); // HashMap�� ����׻��� 
      str.put("��", "������, �ҳ���, �߳���, ������"); // ������ HashMap�� �ݰ� ���� �������� �־��ش�.
      str.put("��", "����, ����");
      
      int res=1; //res ���� 1�� �ʱ�ȭ 
      
      if(kind instanceof String) // ���� ���� String ���� ��ȯ�� �����ϴٸ�
      {
         
         res = ((String)str.get(kind)).indexOf(((String)o1))- // �Է¹��� ��(��,��)�� key������ ������ͼ� indexof�� value�� ����
         //1.������ ���� str�� key������ value�� ������ͼ� ���°���� ���ڷ� ����
               ((String)str.get(kind)).indexOf(((String)o2)); // �Է¹��� ��(��,��)�� key������ ������ͼ� indexof�� value�� ����
         // ���� ���� res���� ����
         //System.out.println(o1+":"+o2);
      }else{ // ���°��� String�� �ƴ϶��
         TTStud me = (TTStud)o1;
         TTStud you = (TTStud)o2;
         System.out.println(o1+":"+o2);
         res = you.avg-me.avg; // ���� ��� - ���� ��� => ���� ����� ũ�� ���� , ���� ����� ������ ������
         if(res==0) res = me.num - you.num; // ���� ����� ���ٸ� �ݹ�ȣ�� ��
      }
      
      return res;
   }
}

public class TreeMap_001 {

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      List input = new ArrayList();
      // ����Ʈ input�� �л��������� �־��ش�.(Ŭ������ ������ �������� �����Ǿ� �� ����)
      input.add(new TTStud("�ҳ���",2,"������",88,89,87,74 ));
      input.add(new TTStud("������",3,"���ȣ",78,87,65,54 ));
      input.add(new TTStud("�ҳ���",1,"�ֹ���", 43,32,21 ));
      input.add(new TTStud("������",2,"���Ѻ�",34,56,78 ));
      input.add(new TTStud("������",2,"������", 89,90,98));
      input.add(new TTStud("������",2,"����ȫ", 87,76,65,54));
      input.add(new TTStud("������",5,"������",89,90,98));
      input.add(new TTStud("�ҳ���",2,"������", 12,23,34,45));
      
      System.out.println("List input : "+input); // ����Ʈ�� �ִ°����� �˱����� ����غ�
      System.out.println();
      
      String kind = "��"; // kind ���� �������� ("��" or "��")
      
      TreeMap total = new TreeMap(new TTStCom_01(kind)); // TreeMap ���� �� ���� (�����Ҷ� Comparator Ŭ���� ����)
      // total TreeMap ���Ľ� TTStCom_01�� ���� ������ ��
      
      for(Object oo : input) // �л�����ŭ ������ (oo : �л��� ������)
      {
         TTStud ts = (TTStud)oo; // TTStud ������ ts�� �л��� �������� �ִ´�.
         
         TreeSet nowSS; //   TreeSet ����
         
         if(total.containsKey(ts.kind.get(kind))) // TreeMap.containsKey()??????����,����??
            nowSS = (TreeSet)total.get(ts.kind.get(kind)); // nowSS�� 
         else{
            
            nowSS = new TreeSet(new TTStCom_01(0)); // nowSS ���Ӱ� ���� (�����Ҷ� Comparator Ŭ���� ����)
                                          // total TreeMap ���Ľ� TTStCom_01�� ���� ������ ��
            total.put(ts.kind.get(kind),nowSS); // Total(TreeMap)�� key : ������� ���� , value : ������ ������ TreeSet 
         }   // total �� ������ ���ÿ� ����(��)���ؼ� ����
         
         nowSS.add(ts); // TreeSet �� �л��� �������� �־���
         // nowSS�� ������ ���ÿ� ����� ���ؼ� ū ������� ����
      }
      
      
      Iterator it = total.keySet().iterator(); // total�� key���� it �� �ִ´�.
      
      while(it.hasNext()) // Ű���� ���������� ������.
      {
         Object key = it.next(); //key �� it(total�� key��)
         
         System.out.println(key+">>>>>>"); // key�� ���(����)
         Iterator sit = ((TreeSet)total.get(key)).iterator(); // total�� key������ value ���� sit�� �ִ´�.
         
         while(sit.hasNext()) // ������ �����鸸ŭ
         {
            System.out.println(sit.next()); // ���
         }
         
      }
      
      
   }

}