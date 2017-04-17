package practice;

interface Resources_Work
{
	void mineral();
	void gas();
}

interface Build_Work
{
	void build(String building);
}

interface SCV_work extends Resources_Work, Build_Work
{	}

class Comend
{
	String name;
	int energy = 500;
	
	public Comend(String name) 
	{
		// TODO Auto-generated constructor stub
		this.name = name;
	}
	
}


class Building_Resources_Data
{
	String name;
	int mineral, gas;
	
	public Building_Resources_Data(String name, int mineral, int gas) {
		super();
		this.name = name;
		this.mineral = mineral;
		this.gas = gas;
	}
}

class ResourcesData
{
	String name;	
	int mineral, gas;
	
	public ResourcesData(String name) {
		super();
		this.name = name;
	}
	
	String tostring()
	{
		return "["+name+"]  mineral: "+mineral+"  gas: "+gas;
	}
}

class SCV implements SCV_work
{
	ResourcesData data;
	ResourcesData totdata;
	
	public SCV(String name, ResourcesData totdata) {
		super();
		data = new ResourcesData(name);
		this.totdata = totdata;
	}

	@Override
	public void mineral() {
		// TODO Auto-generated method stub
		System.out.print(data.name+"�� �̳׶��� ĺ���ϴ�.\t");
		data.mineral+=8;
		totdata.mineral+=8;
		System.out.println("���� �̳׶� : "+ totdata.mineral);
	}

	@Override
	public void gas() {
		// TODO Auto-generated method stub
		System.out.print(data.name+"�� ������ ĺ���ϴ�.\t");
		data.gas+=8;
		totdata.gas+=8;
		System.out.println("���� ���� : "+ totdata.gas);
	}

	@Override
	public void build(String building) {
		// TODO Auto-generated method stub
		boolean chk = false;
		
		Building_Resources_Data [] index ={ 
				new Building_Resources_Data("Ŀ��弾��", 400, 0),
				new Building_Resources_Data("���丮", 200, 100),
				new Building_Resources_Data("��Ÿ��Ʈ", 150, 100)	
		};
		
		for (int i = 0; i < index.length; i++) {
		
			if(index[i].name == building && totdata.mineral >= index[i].mineral && totdata.gas >= index[i].gas)
			{
				totdata.mineral -= index[i].mineral;
				totdata.gas -= index[i].gas;
				System.out.println(data.name+"�� "+building+"�� �������ϴ�.");
				chk = true;
			}
		}
		if (!chk) 
		System.out.println(data.name+"�� "+building+"�� ���� �� �����ϴ�. �ڿ��� �����մϴ�!!");
	}
}

public class Starcraft {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ResourcesData rs = new ResourcesData("���� �ڿ�");
		
		SCV scv1 = new SCV("scv1", rs);
		SCV scv2 = new SCV("scv2", rs);
		SCV scv3 = new SCV("scv3", rs);
		SCV scv4 = new SCV("scv4", rs);

		for (int i = 0; rs.mineral < 1300; i++) {
			scv1.mineral();
			scv2.mineral();
			scv3.mineral();
			scv4.mineral();
		}
		
		for (int i = 0; rs.gas < 200; i++) {
			scv1.gas();
			scv2.gas();
			scv3.gas();
			scv4.gas();
		}
		
		System.out.println(scv1.data.tostring());
		System.out.println(scv2.data.tostring());
		System.out.println(rs.tostring());
		scv1.build("Ŀ��弾��");
		scv1.build("Ŀ��弾��");
		System.out.println(rs.tostring());
		scv2.build("��Ÿ��Ʈ");
		scv3.build("���丮");
		System.out.println(rs.tostring());
		scv4.build("Ŀ��弾��");
	}
}