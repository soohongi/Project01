package practice;
////생년월일
/// 성별
/// 국적
/// 나이(한국 나이)
/// 다가올생일
/// D-Day (생일까지)
public class Social_Number {

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		String birth, sx, nation;
		int nyear = 2017, nmonth =3, nday=7;		//현재 날짜 
		int age, bir_year, d_day;
		
		String sn = "120211-3346799";
		
		String [] birthArr = sn.split("-");
		
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
		System.out.println("생년월일 : "+dday[0]+"년 "+dday[1]+"월 "+dday[2]+"일");

		////////성별 구별///////
		int sxCal = (birthArr[1].charAt(0)-'0')%2;
		if(sxCal == 0)
			sx="여성";
		else
			sx="남성";
		System.out.println("성별 : " +sx);

		////////국적 계산//////
		int foreigner = (birthArr[1].charAt(0)-'0');
		if(foreigner>4 && foreigner<9)
			nation = "외국인";
		else
			nation = "내국인";
		System.out.println("국적 : " +nation);

		///////나이 계산//////
		age= 2017-dday[0]+1;
		System.out.println("나이 : "+age+"세");
		////////////////////
		
		//////다가올 생일//////
		if(dday[1]<=nmonth)
			bir_year=nyear+1;
		else
			bir_year=nyear;
		System.out.println("다가올 생일 : "+bir_year+"년 "+dday[1]+"월 "+dday[2]+"일");

		//////d-day계산/////////
		int [] mon_index = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		d_day=mon_index[nmonth]-nday;

		if(dday[1]<=nmonth)
		{
			for (int i = nmonth+1 ; i < mon_index.length; i++) {
				d_day += mon_index[i];
			}
			for (int i = 0; i < dday[1]; i++) {
				d_day+=mon_index[i];
			}
		}
		else
		{
			for (int i = nmonth+1 ; i < dday[1]; i++) {
				d_day+=mon_index[i];
			}
		}
		d_day+=dday[2];
		
		System.out.println("생일까지 D-day :" +d_day+"일");
	}
}