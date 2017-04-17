package practice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

class Cal
{
	public Cal(Calendar cday) {
		// TODO Auto-generated constructor stub
		int mm = cday.get(Calendar.MONTH);
		int dd = cday.get(Calendar.DATE);
		
		cday.set(cday.get(Calendar.YEAR),mm, 1);
		
		for (int i = 1; i < cday.get(Calendar.DAY_OF_WEEK); i++) {
			System.out.print("     ");
		}

		for (int i = 1; i <= cday.getActualMaximum(Calendar.DATE); i++) {

			cday.set(Calendar.DATE, i);
			String prefix = "", surfix = "";

			if (mm == cday.get(Calendar.MONTH) && dd == cday.get(Calendar.DATE)) {
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
public class Hw_0316 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Date today = new Date();
		int now_year;
		String birth_year;
		Calendar cday = Calendar.getInstance();
		now_year = cday.get(Calendar.YEAR);							//now_year = 2017
		String jumin = "050407-3234567";
		String [] sp = jumin.split("-");
		Cal cl;
		
		String [] year_index = {"18", "19", "19", "20", "20", "19", "19", "20", "20", "18"};
		int num = sp[1].charAt(0)-'0';
		birth_year = year_index[num];
			 
		
		//System.out.println(num);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date birth = sdf.parse(birth_year+sp[0]);
		
		cday.setTime(birth);
		print(cday);
		
		
		int mm = cday.get(Calendar.MONTH);
		int dd = cday.get(Calendar.DATE);

		System.out.println("========   "+cday.get(Calendar.YEAR) + "년      " + (mm + 1) + "월     =========");
		cl = new Cal(cday);
		
		
		/*System.out.println("========   "+cday.get(Calendar.YEAR) + "년      " + (mm + 1) + "월     =========");
		cday.set(cday.get(Calendar.YEAR),mm, 1);
		
		for (int i = 1; i < cday.get(Calendar.DAY_OF_WEEK); i++) {
			System.out.print("     ");
		}

		for (int i = 1; i <= cday.getActualMaximum(Calendar.DATE); i++) {

			cday.set(Calendar.DATE, i);
			String prefix = "", surfix = "";

			if (mm == cday.get(Calendar.MONTH) && dd == cday.get(Calendar.DATE)) {
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
		System.out.println("\n");*/
		
		
		
		cday.setTime(today);
		print(cday);
		now_year = now_year - cday.get(Calendar.YEAR);
		cday.add(Calendar.YEAR, now_year);
		
		if(cday.get(Calendar.DAY_OF_WEEK) == 7)
			cday.add(Calendar.DATE, -1);
		else if(cday.get(Calendar.DAY_OF_WEEK) == 1)
			cday.add(Calendar.DATE, -2);

		System.out.println("올해 생일파티 ======>");
		System.out.println("========   "+cday.get(Calendar.YEAR) + "년      " + (mm + 1) + "월     =========");
		
		cl = new Cal(cday);
		
		/*cday.set(cday.get(Calendar.YEAR),mm, 1);
		
		for (int i = 1; i < cday.get(Calendar.DAY_OF_WEEK); i++) {
			System.out.print("     ");
		}

		for (int i = 1; i <= cday.getActualMaximum(Calendar.DATE); i++) {

			cday.set(Calendar.DATE, i);
			String prefix = "", surfix = "";

			if (mm == cday.get(Calendar.MONTH) && dd == cday.get(Calendar.DATE)) {
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
		System.out.println();
*/
	}
	

	
	public static void  print(Calendar cc)
	{
		String str = cc.get(Calendar.YEAR)+"년 "+
				(cc.get(Calendar.MONTH)+1)+"월 "+
				cc.get(Calendar.DATE)+"일 "+
				"일월화수목금토".charAt(
						cc.get(Calendar.DAY_OF_WEEK)-1)+"요일 오"+
				"전후".charAt(
						cc.get(Calendar.AM_PM))+" "+
				cc.get(Calendar.HOUR)+":"+
				cc.get(Calendar.MINUTE)+":"+
				cc.get(Calendar.SECOND)+"."+
				cc.get(Calendar.MILLISECOND);	
		System.out.println(str);
	}

}
