package io;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
////�̸�, ��, ��, �� ���� ����� ���Ͽ� �����Ͻÿ�
		/// ó�� ���� ����, ���, ���
		/// ��� ���Ͽ��� ������ ������ ����Ͻÿ�
		
		/// �л� 5������ ó�� ��� ���� ����Ұ�

class SerChild extends SerData{

	String name;
	int sum;
	public SerChild( String name, int kor, int eng, int mat) {
		super( kor, eng, mat/*, sum*/);
		// TODO Auto-generated constructor stub
		this.name = name;
		
		cal();
		
	}
	
	 void cal()
	 {
		 this.sum+=kor+eng+mat;
	 }
	
	

	private static final long serialVersionUID = 5678L;
	@Override
	public String toString() {
		return "�̸� / ����          " + name + "/\t"+ kor +"\t"+ eng +"\t"+ mat+"\t"+sum;
	}
	
}

public class ObjectStream_001 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			FileOutputStream fos = new FileOutputStream("fff/sd.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			
			/*oos.writeInt(123);
			oos.writeBoolean(true);
			oos.writeDouble(123.456);
			oos.writeUTF("������ �������");*/
			//oos.writeObject(new SerData("��������", 100));
			/*oos.writeObject(new int []{123,456,789});
			oos.writeObject(new ArrayList<>());
			oos.writeObject(new SerData[]{new SerData("��������", 100)});*/
			oos.writeObject(new SerChild("������", 100,100,100));
			oos.writeObject(new SerChild("����õ", 90,90,90));
			oos.writeObject(new SerChild("����ȫ", 80,80,80));
			oos.writeObject(new SerChild("������", 70,70,70));
			oos.writeObject(new SerChild("������", 60,60,60));
			
			
			oos.flush();
			oos.reset();
			
			oos.close();
			fos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
