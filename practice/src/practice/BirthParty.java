package practice;
//�ֹι�ȣ�� �̿��Ͽ� 
//�������
//�� ����
//�ٰ��� ���� && ���ػ���

//�ٰ��� ������Ƽ(��, �� �ΰ�� �� �ݿ���)
//������Ƽ D-day �� ����ϼ���

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
		
		////////////////////////������� ���//////////////////////////
		int [] year_index = {1800, 1900, 1900, 2000, 2000, 1900, 1900, 2000, 2000, 1800};
		int generation = (birthArr[1].charAt(0)-'0');
		for (int i = 0; i < year_index.length; i++) {
			if(generation == i)
				dday[0]+=year_index[i];
		}
		
		birthday.set(Calendar.YEAR, dday[0]);
		birthday.set(Calendar.MONTH, dday[1]);
		birthday.set(Calendar.DATE, dday[2]);
		
		System.out.println(birthday.get(Calendar.YEAR)+"�� "+(birthday.get(Calendar.MONTH))+
				"�� "+birthday.get(Calendar.DATE)+"�� "+"�Ͽ�ȭ�������".charAt(birthday.get(Calendar.DAY_OF_WEEK))+"����");
		
		//System.out.println(birthday.get(Calendar.YEAR)+" "+birthday.get(Calendar.MONTH)+" "+birthday.get(Calendar.DATE));
		
		System.out.println("������� : "+dday[0]+"�� "+dday[1]+"�� "+dday[2]+"��");
		////////////////////////////////////////////////////////////
		
		///////���� ���//////
		if(today.get(Calendar.MONTH)+1>=dday[1] && today.get(Calendar.DATE)>dday[2] 
				|| today.get(Calendar.MONTH)+1>dday[1])
			age = today.get(Calendar.YEAR)-dday[0];
		else{
			age = today.get(Calendar.YEAR)-dday[0]-1;
		}System.out.println("���� : ��"+age+"��");
		////////////////////
		//System.out.println(today.get(Calendar.MONTH)+1);
		////�ٰ��� ����////////
		int bir_year;
		if(today.get(Calendar.MONTH)+1>=dday[1] && today.get(Calendar.DATE)>dday[2] 
				|| today.get(Calendar.MONTH)+1>dday[1])
			bir_year=today.get(Calendar.YEAR)+1;
		else
			bir_year=today.get(Calendar.YEAR);
		System.out.println("�ٰ��� ���� : "+bir_year+"�� "+dday[1]+"�� "+dday[2]+"��");
		/////////////////////
		
		near_birthday.set(Calendar.YEAR, bir_year);
		near_birthday.set(Calendar.MONTH, dday[1]-1);
		near_birthday.set(Calendar.DATE, dday[2]);
		
		/////�ٰ��� ������Ƽ/////
		birthday.set(Calendar.DATE, birthday.get(Calendar.DATE)-1);
		
		//System.out.println(near_birthday.get(Calendar.YEAR)+"�� "+(near_birthday.get(Calendar.MONTH)+1)+
		//		"�� "+(near_birthday.get(Calendar.DATE)-2)+"�� "+"�Ͽ�ȭ�������".charAt(near_birthday.get(Calendar.DAY_OF_WEEK)-1)+"����");
		char cha;
		cha="�Ͽ�ȭ�������".charAt(near_birthday.get(Calendar.DAY_OF_WEEK));
		
		System.out.println(cha);
		System.out.print("������Ƽ�� ");
		
		if((near_birthday.get(Calendar.DAY_OF_WEEK)-1) == 1)
		{
			System.out.println(near_birthday.get(Calendar.YEAR)+"�� "+(near_birthday.get(Calendar.MONTH)+1)+
					"�� "+(near_birthday.get(Calendar.DATE)-2)+"�� "+"�Ͽ�ȭ�������".charAt(near_birthday.get(Calendar.DAY_OF_WEEK)-3)+"����");
		}
		else if((near_birthday.get(Calendar.DAY_OF_WEEK)) == 7)
		{
			System.out.println(near_birthday.get(Calendar.YEAR)+"�� "+(near_birthday.get(Calendar.MONTH)+1)+
					"�� "+(near_birthday.get(Calendar.DATE)-1)+"�� "+"�Ͽ�ȭ�������".charAt(near_birthday.get(Calendar.DAY_OF_WEEK)-2)+"����");
		}
		else
		{
			System.out.println(near_birthday.get(Calendar.YEAR)+"�� "+(near_birthday.get(Calendar.MONTH)+1)+
					"�� "+near_birthday.get(Calendar.DATE)+"�� "+"�Ͽ�ȭ�������".charAt(near_birthday.get(Calendar.DAY_OF_WEEK)-1)+"����");
		}
		

	}

}