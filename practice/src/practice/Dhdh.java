package practice;

class ParCarDh
{
	String carKind, carName; 
	int safety, speed,fuel;
}
 
class FactoryDh extends ParCarDh
{
	
  	FactoryDh car(String carKind, String carName, int speed, int safety, int fuel)
  	{
  		this.carKind=carKind;
  		this.carName=carName;
  		this.speed=speed;
  		this.safety=safety;
  		this.fuel=fuel;
  		
  		return this;
  	}
  	
  	void print(FactoryDh [] ft)
  	{
  		String str= carKind+ "\t"+ carName+ "\t"+ speed+ "\t"+ safety+ "\t"+ fuel+ "\t";
		System.out.println(str);
  	}
}

public class Dhdh {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FactoryDh []ft= {  
				new FactoryDh().car("������ī","����Ƽ",45,76,97),
				new FactoryDh().car("������ī", "������", 65, 74, 98),	
				new FactoryDh().car("������ī", "������", 65, 76, 87),
				new FactoryDh().car("Ʈ��", "Ʈ��Ű", 54, 43, 43),
				new FactoryDh().car("Ʈ��", "Ʈ����", 32, 43, 32),
				new FactoryDh().car("Ʈ��", "Ʈ����", 96, 98, 76),
				new FactoryDh().car("����ũ", "����Ű", 76, 87, 76),
				new FactoryDh().car("����ũ", "������", 37, 37, 76),
				new FactoryDh().car("����ũ", "����Ʈ", 1, 75, 7)
		              };

		for(FactoryDh arr: ft)
			arr.print(ft);
	}
}