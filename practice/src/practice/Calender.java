package practice;

import java.util.Calendar;

public class Calender {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Calendar today = Calendar.getInstance();
		int now = today.get(Calendar.DATE);
		//today.set(Calendar.DATE, 1);
		
		//System.out.println("\t\t"+(today.get(Calendar.MONTH)+1)+"월");
		/*today.set(Calendar.MONTH, 0);
		System.out.println("\t\t"+(today.get(Calendar.MONTH)+1)+"월");
		today.set(Calendar.MONTH, 1);
		System.out.println("\t\t"+(today.get(Calendar.MONTH)+1)+"월");
		today.set(Calendar.MONTH, 2);
		System.out.println("\t\t"+(today.get(Calendar.MONTH)+1)+"월");
		today.set(Calendar.MONTH, 3);
		System.out.println("\t\t"+(today.get(Calendar.MONTH)+1)+"월");
		today.set(Calendar.MONTH, 4);
		System.out.println("\t\t"+(today.get(Calendar.MONTH)+1)+"월");
		today.set(Calendar.MONTH, 5);
		System.out.println("\t\t"+(today.get(Calendar.MONTH)+1)+"월");
		today.set(Calendar.MONTH, 6);
		System.out.println("\t\t"+(today.get(Calendar.MONTH)+1)+"월");
		
		*/
		
		
		for (int c = 0; c < 12; c++) {
			
			today.set(Calendar.MONTH, c);
			System.out.println("\t\t"+(today.get(Calendar.MONTH))+"월");
		
				for (int i = 1; i <today.get(Calendar.DAY_OF_WEEK); i++) {
					System.out.print("     ");
				}
	
				for (int i = 1; i <=today.getActualMaximum(Calendar.DATE); i++) {
					
					today.set(Calendar.DATE, i);
					String prefix = "", surfix="";
		
					if(now==i){
						prefix +="["; 
						surfix +="]";
					}else{
						prefix +=" "; 
						surfix +=" ";
					}
					
					if(i<10) prefix +=" ";
					surfix+=" ";
					
					System.out.print(prefix +i+surfix);
					
					if(today.get(Calendar.DAY_OF_WEEK)==7)
						System.out.println();
					
				}
		
		
		System.out.println("\n\n");
		}
		
		
	}
}

