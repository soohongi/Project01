package practice;
//주민번호를 이용하여 
//생년월일
//만 나이
//다가올 생일 && 올해생일

//다가올 생일파티(토, 일 인경우 전 금요일)
//생일파티 D-day 를 출력하세요

import java.util.Calendar;

public class BirthParty {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String birth;
		int age;
		
		
		String sn = "910408-171212";
		String [] birthArr = sn.split("-");
		
		Calendar today = Calendar.getInstance();
		Calendar birthday = Calendar.getInstance();
		Calendar near_birthday = Calendar.getInstance();
		
		birth = birthArr[0];
		int [] dd = {0,2,4,6};										
		int [] dday = new int[dd.length-1];							

		for(int i =0;i<dd.length-1;i++)								
		{
			for(int k =dd[i];k<dd[i+1];k++)							
			{
				dday[i]*=10;										
				dday[i]+=birth.charAt(k)-'0';
			}
		}
		
		////////////////////////생년월일 계산//////////////////////////
		int [] year_index = {1800, 1900, 1900, 2000, 2000, 1900, 1900, 2000, 2000, 1800};
		int generation = (birthArr[1].charAt(0)-'0');
		for (int i = 0; i < year_index.length; i++) {
			if(generation == i)
				dday[0]+=year_index[i];
		}
		
		birthday.set(Calendar.YEAR, dday[0]);
		birthday.set(Calendar.MONTH, dday[1]);
		birthday.set(Calendar.DATE, dday[2]);
		
		System.out.println(birthday.get(Calendar.YEAR)+"년 "+(birthday.get(Calendar.MONTH))+
				"월 "+birthday.get(Calendar.DATE)+"일 "+"일월화수목금토".charAt(birthday.get(Calendar.DAY_OF_WEEK))+"요일");
		
		//System.out.println(birthday.get(Calendar.YEAR)+" "+birthday.get(Calendar.MONTH)+" "+birthday.get(Calendar.DATE));
		
		System.out.println("생년월일 : "+dday[0]+"년 "+dday[1]+"월 "+dday[2]+"일");
		////////////////////////////////////////////////////////////
		
		///////나이 계산//////
		if(today.get(Calendar.MONTH)+1>=dday[1] && today.get(Calendar.DATE)>dday[2] 
				|| today.get(Calendar.MONTH)+1>dday[1])
			age = today.get(Calendar.YEAR)-dday[0];
		else{
			age = today.get(Calendar.YEAR)-dday[0]-1;
		}System.out.println("나이 : 만"+age+"세");
		////////////////////
		//System.out.println(today.get(Calendar.MONTH)+1);
		////다가올 생일////////
		int bir_year;
		if(today.get(Calendar.MONTH)+1>=dday[1] && today.get(Calendar.DATE)>dday[2] 
				|| today.get(Calendar.MONTH)+1>dday[1])
			bir_year=today.get(Calendar.YEAR)+1;
		else
			bir_year=today.get(Calendar.YEAR);
		System.out.println("다가올 생일 : "+bir_year+"년 "+dday[1]+"월 "+dday[2]+"일");
		/////////////////////
		
		near_birthday.set(Calendar.YEAR, bir_year);
		near_birthday.set(Calendar.MONTH, dday[1]-1);
		near_birthday.set(Calendar.DATE, dday[2]);
		
		/////다가올 생일파티/////
		birthday.set(Calendar.DATE, birthday.get(Calendar.DATE)-1);
		
		//System.out.println(near_birthday.get(Calendar.YEAR)+"년 "+(near_birthday.get(Calendar.MONTH)+1)+
		//		"월 "+(near_birthday.get(Calendar.DATE)-2)+"일 "+"일월화수목금토".charAt(near_birthday.get(Calendar.DAY_OF_WEEK)-1)+"요일");
		char cha;
		cha="일월화수목금토".charAt(near_birthday.get(Calendar.DAY_OF_WEEK));
		
		System.out.println(cha);
		System.out.print("생일파티는 ");
		
		if((near_birthday.get(Calendar.DAY_OF_WEEK)-1) == 1)
		{
			System.out.println(near_birthday.get(Calendar.YEAR)+"년 "+(near_birthday.get(Calendar.MONTH)+1)+
					"월 "+(near_birthday.get(Calendar.DATE)-2)+"일 "+"일월화수목금토".charAt(near_birthday.get(Calendar.DAY_OF_WEEK)-3)+"요일");
		}
		else if((near_birthday.get(Calendar.DAY_OF_WEEK)) == 7)
		{
			System.out.println(near_birthday.get(Calendar.YEAR)+"년 "+(near_birthday.get(Calendar.MONTH)+1)+
					"월 "+(near_birthday.get(Calendar.DATE)-1)+"일 "+"일월화수목금토".charAt(near_birthday.get(Calendar.DAY_OF_WEEK)-2)+"요일");
		}
		else
		{
			System.out.println(near_birthday.get(Calendar.YEAR)+"년 "+(near_birthday.get(Calendar.MONTH)+1)+
					"월 "+near_birthday.get(Calendar.DATE)+"일 "+"일월화수목금토".charAt(near_birthday.get(Calendar.DAY_OF_WEEK)-1)+"요일");
		}
		

	}

}