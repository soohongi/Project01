package practice;
////�������
/// ����
/// ����
/// ����(�ѱ� ����)
/// �ٰ��û���
/// D-Day (���ϱ���)
public class Social_Number {

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		String birth, sx, nation;
		int nyear = 2017, nmonth =3, nday=7;		//���� ��¥ 
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
		////////////////////////������� ���//////////////////////////
		int [] year_index = {1800, 1900, 1900, 2000, 2000, 1900, 1900, 2000, 2000, 1800};
		int generation = (birthArr[1].charAt(0)-'0');
		for (int i = 0; i < year_index.length; i++) {
			if(generation == i)
				dday[0]+=year_index[i];
		}
		System.out.println("������� : "+dday[0]+"�� "+dday[1]+"�� "+dday[2]+"��");

		////////���� ����///////
		int sxCal = (birthArr[1].charAt(0)-'0')%2;
		if(sxCal == 0)
			sx="����";
		else
			sx="����";
		System.out.println("���� : " +sx);

		////////���� ���//////
		int foreigner = (birthArr[1].charAt(0)-'0');
		if(foreigner>4 && foreigner<9)
			nation = "�ܱ���";
		else
			nation = "������";
		System.out.println("���� : " +nation);

		///////���� ���//////
		age= 2017-dday[0]+1;
		System.out.println("���� : "+age+"��");
		////////////////////
		
		//////�ٰ��� ����//////
		if(dday[1]<=nmonth)
			bir_year=nyear+1;
		else
			bir_year=nyear;
		System.out.println("�ٰ��� ���� : "+bir_year+"�� "+dday[1]+"�� "+dday[2]+"��");

		//////d-day���/////////
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
		
		System.out.println("���ϱ��� D-day :" +d_day+"��");
	}
}