package practice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

class Cal_01
{
	public Cal_01(Calendar cday, int mm, int dd) {
		// TODO Auto-generated constructor stub
		cday.set(cday.get(Calendar.YEAR),mm, 1);
		
		for (int i = 1; i < cday.get(Calendar.DAY_OF_WEEK); i++) {
			System.out.print("     ");
		}
		for (int i = 1; i <= cday.getActualMaximum(Calendar.DATE); i++) {

			cday.set(Calendar.DATE, i);
			String prefix = "", surfix = "";

			if (dd == cday.get(Calendar.DATE)) {
				prefix += "[";
				surfix += "]";
			} else {
				prefix += " ";
				surfix += " ";
			}

			if (i < 10)
				prefix += " ";
			surfix += " ";
			System.out.print(prefix + i + surfix);
			
			if (cday.get(Calendar.DAY_OF_WEEK) == 7)
				System.out.println();
		}
		System.out.println("\n");
	}
}
public class Hw_0316_01 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Cal_01 cl;
		int now_year, now_month, now_date;
		String birth_year;
		Calendar cday = Calendar.getInstance();
		
		now_year = cday.get(Calendar.YEAR);							//now_year = 2017
		now_month = cday.get(Calendar.MONTH);						//now_month = 2
		now_date = cday.get(Calendar.DATE);
		
		String jumin = "910408-1234567";
		
		String [] sp = jumin.split("-");
		String [] year_index = {"18", "19", "19", "20", "20", "19", "19", "20", "20", "18"};
		int num = sp[1].charAt(0)-'0';
		birth_year = year_index[num];
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date birth = sdf.parse(birth_year+sp[0]);
		cday.setTime(birth);
		
		int mm = cday.get(Calendar.MONTH);
		int dd = cday.get(Calendar.DATE);

		System.out.println("========   "+cday.get(Calendar.YEAR) + "년      " + (mm + 1) + "월     =========");
		cl = new Cal_01(cday, mm, dd);
		
		cday.setTime(birth);
		now_year = now_year - cday.get(Calendar.YEAR);
		cday.add(Calendar.YEAR, now_year);
		if(now_month>=mm)
		{
			if(now_date>dd)
				cday.add(Calendar.YEAR, 1);
		}
		
		if(cday.get(Calendar.DAY_OF_WEEK) == 7)
		{	
			cday.add(Calendar.DATE, -1);
			dd=cday.get(Calendar.DATE);
		}	
		else if(cday.get(Calendar.DAY_OF_WEEK) == 1)
		{
			cday.add(Calendar.DATE, -2);
			dd=cday.get(Calendar.DATE);
		}
		System.out.println("===생일파티(주말 제외)===");
		System.out.println("========   "+cday.get(Calendar.YEAR) + "년      " + (mm + 1) + "월     =========");
		cl = new Cal_01(cday, mm, dd);
	}
}