package io;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
////이름, 국, 영, 수 시험 결과를 파일에 저장하시오
		/// 처리 내용 총점, 평균, 등급
		/// 결과 파일에서 내용을 가져와 출력하시오
		
		/// 학생 5명으로 처리 등수 별로 출력할것

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
		return "이름 / 성적          " + name + "/\t"+ kor +"\t"+ eng +"\t"+ mat+"\t"+sum;
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
			oos.writeUTF("윤성문 일찍오자");*/
			//oos.writeObject(new SerData("추주추주", 100));
			/*oos.writeObject(new int []{123,456,789});
			oos.writeObject(new ArrayList<>());
			oos.writeObject(new SerData[]{new SerData("추주추주", 100)});*/
			oos.writeObject(new SerChild("송정윤", 100,100,100));
			oos.writeObject(new SerChild("임종천", 90,90,90));
			oos.writeObject(new SerChild("정수홍", 80,80,80));
			oos.writeObject(new SerChild("윤성문", 70,70,70));
			oos.writeObject(new SerChild("김진향", 60,60,60));
			
			
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
