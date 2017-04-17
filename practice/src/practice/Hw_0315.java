package practice;

 

import java.util.ArrayList;

import java.util.Arrays;

import java.util.Collection;

import java.util.Comparator;

import java.util.HashSet;

import java.util.Iterator;

import java.util.List;

import java.util.Set;

import java.util.TreeMap;

import java.util.TreeSet;

 

class Stud

{

    String name, gender;
    int ban;
    int [] jum;
    int sum, avg;

    TreeMap <String, Integer>rank;

    

    public Stud() {

        // TODO Auto-generated constructor stub

        jum=new int[3];

    }

    public Stud(int ban, String gender,String name, int kor, int eng, int mat) {

        super();

        this.ban =ban;

        this.name = name;

        this.gender = gender;

        this.jum = new int[]{kor, eng, mat};

        cal();

    }

    void cal()

    {

        sum = 0;

        for (int i = 0; i < jum.length; i++) {

            sum += jum[i];

        }

        avg = sum/jum.length;

    }

    

    public void print(String kind) {

        String str=  ban + "\t" + gender + "\t" + name + "\t" + Arrays.toString(jum) + "\t"

                + sum + "\t" + avg + "\t" + rank.get(kind) ;

        

        System.out.println(str);

    }

    public void print() {

        String str=  ban + "\t" + gender + "\t" + name + "\t" + Arrays.toString(jum) + "\t"

                + sum + "\t" + avg ;

        

        System.out.println(str);

    }

    

}

 

 

class HomeCom implements Comparator

{

    

    @Override

    public int compare(Object o1, Object o2) {

        // TODO Auto-generated method stub

        

         Stud ori = (Stud) o1;

         Stud com = (Stud) o2;

     

        int res = com.avg - ori.avg;

         

         if(res==0)

         {

             res = ori.name.compareTo(com.name);

         }

        return res;

    }

}

 

class TotalExam

{

    List ori;

    TreeSet<Stud> total = new TreeSet<>(new HomeCom());

    TreeMap<Integer,TreeSet<Stud>> ban = new TreeMap();

    TreeMap<String,TreeSet<Stud>> gen = new TreeMap();

    TreeMap<Integer,TreeMap<String,TreeSet<Stud>>> banGen = new TreeMap();

    

    TreeMap list = new TreeMap<>();

    

    ArrayList gender = new ArrayList<>();

    

    public TotalExam(List ori) {

        super();

        this.ori = ori;

        gender.add("남자");

        gender.add("여자");

        

        list.put("전체",total );

        list.put("반", ban);

        list.put("성별", gen);

        list.put("반성별", banGen);

    }

    

    void cal(String kind)

    {        

        gen.put("남자",new TreeSet(new HomeCom()));

        gen.put("여자",new TreeSet(new HomeCom()));

 

        rank();

        print(kind);

    }

    void addSet(Stud st)

    {

 

        if( !ban.containsKey(st.ban))

        {

            ban.put(st.ban, new TreeSet(new HomeCom()));

            banGen.put(st.ban, new TreeMap());

            banGen.get(st.ban).put("남자",new TreeSet(new HomeCom()));

            banGen.get(st.ban).put("여자",new TreeSet(new HomeCom()));

        }

        

        total.add(st);

        ban.get(st.ban).add(st);

        gen.get(st.gender).add(st);

        banGen.get(st.ban).get(st.gender).add(st);

        

    }

    

    void print(String kind)

    {

        printTT(list.get(kind), kind);    

    }

    

    void printTT(Object tt, String kind)

    {

        if(tt instanceof Collection )

            printModule((Collection)tt, kind);

        

        else

        {

            TreeMap map = (TreeMap)tt;

            

            Iterator keyIt = map.keySet().iterator();

            

            while(keyIt.hasNext())

            {

                Object key = keyIt.next();

                System.out.println("< " +key+" >");

                printTT(map.get(key), kind);

            }            

        }

    }

    

    

    void printModule(Collection oo, String kind)

    {    

        Iterator it = oo.iterator();

    

        Stud sum = new Stud();

        Stud avg = new Stud();

        while(it.hasNext())

        {

            Object abc = it.next();

            

            if(abc instanceof Collection)

            {

                printModule((Collection)abc, kind);

                System.out.println("----------------------------------------------");

            }

            else

            {

                Stud st = (Stud)abc;

                for (int i = 0; i < st.jum.length; i++) {

                    sum.jum[i]+=st.jum[i];

                }

                sum.cal();

                

                st.print(kind);

            }

        }

        

        for (int i = 0; i < sum.jum.length; i++) {

            avg.jum[i] = sum.jum[i]/oo.size();

        }

        avg.cal();

        

        sum.print();

        avg.print();

    }

    void rank()

    {

        

        for (Object oo1 : ori) {

        

            Stud st1 = (Stud)oo1;

            st1.rank = new TreeMap();

            addSet(st1);

            st1.rank.put("전체",1);

            st1.rank.put("반",1);

            st1.rank.put("성별",1);

            st1.rank.put("반성별",1);

            

            

            for (Object oo2 : ori) {

                

                

                Stud st2 = (Stud)oo2;

            

                

                if(st1.avg<st2.avg)

                {

                    st1.rank.put("전체", st1.rank.get("전체")+1);

                    

                    if(st1.ban==st2.ban)

                        st1.rank.put("반", st1.rank.get("반")+1);

                    

                    if(st1.gender==st2.gender)

                    {

                        if(st1.ban==st2.ban)

                            st1.rank.put("반성별", st1.rank.get("반성별")+1);

                        

                        st1.rank.put("성별", st1.rank.get("성별")+1);

                    }                

                }

            }

        }

    }    

}

 

public class Hw_0315 {

 

    public static void main(String[] args) {

        // TODO Auto-generated method stub

        List ori = new ArrayList();

 

         ori.add(new Stud(1, "남자", "우솝", 54, 53, 51));

            ori.add(new Stud(2, "남자", "루피", 87, 84, 86));

            ori.add(new Stud(3, "여자", "나미", 99, 95, 94));

            ori.add(new Stud(1, "남자", "조로", 87, 84, 86));

            ori.add(new Stud(3, "여자", "핸콕", 67, 85, 84));

            ori.add(new Stud(2, "남자", "상디", 99, 88, 91));

            ori.add(new Stud(1, "여자", "로빈", 64, 68, 67));

            ori.add(new Stud(2, "여자", "히나", 62, 88, 77));

            ori.add(new Stud(2, "남자", "쵸파", 77, 55, 44));

            ori.add(new Stud(2, "여자", "보니", 40, 88, 77));

            ori.add(new Stud(1, "남자", "징베", 53, 63, 71));

            ori.add(new Stud(3, "남자", "사보", 79, 44, 63));

            ori.add(new Stud(1, "여자", "비비", 90, 79, 54));

            ori.add(new Stud(3, "남자", "로우", 88, 95, 60));

            ori.add(new Stud(1, "여자", "모네", 67, 65, 44));

            ori.add(new Stud(2, "남자", "코비", 39, 58, 71));

            ori.add(new Stud(3, "여자", "슈가", 64, 58, 86));

            ori.add(new Stud(2, "남자", "에넬", 70, 50, 40));

        

        Iterator it = ori.iterator();

        

        TotalExam te = new TotalExam(ori);

            

        te.cal("반성별");

    }

}