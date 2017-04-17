package io;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class ObjectInput_001 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			FileInputStream fis = 
					
					new FileInputStream("fff/sd.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			
			/*System.out.println(ois.readInt());
			System.out.println(ois.readBoolean());
			System.out.println(ois.readDouble());
			System.out.println(ois.readUTF());*/
			
			System.out.println(ois.readUTF());
			
			System.out.println(ois.readObject());
			System.out.println(ois.readObject());
			System.out.println(ois.readObject());
			System.out.println(ois.readObject());
			System.out.println(ois.readObject());
			
			ois.close();
			fis.close();
			
			////이름, 국, 영, 수 시험 결과를 파일에 저장하시오
			/// 처리 내용 총점, 평균, 등급
			/// 결과 파일에서 내용을 가져와 출력하시오
			
			/// 학생 5명으로 처리 등수 별로 출력할것
			
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
