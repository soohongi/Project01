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
				new FactoryDh().car("스포츠카","스포티",45,76,97),
				new FactoryDh().car("스포츠카", "스포팔", 65, 74, 98),	
				new FactoryDh().car("스포츠카", "스포쿠", 65, 76, 87),
				new FactoryDh().car("트럭", "트러키", 54, 43, 43),
				new FactoryDh().car("트럭", "트러피", 32, 43, 32),
				new FactoryDh().car("트럭", "트러퐁", 96, 98, 76),
				new FactoryDh().car("바이크", "바이키", 76, 87, 76),
				new FactoryDh().car("바이크", "바이포", 37, 37, 76),
				new FactoryDh().car("바이크", "바이트", 1, 75, 7)
		              };

		for(FactoryDh arr: ft)
			arr.print(ft);
	}
}