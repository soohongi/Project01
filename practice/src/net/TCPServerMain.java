package net;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;


public class TCPServerMain {

	static String getTime()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("[hh:mm:ss]");
		return sdf.format(new Date());
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			ServerSocket server = new ServerSocket(7777);
			System.out.println("서버준비");
			
			while(true)
			{
				Socket client = server.accept();
				
				System.out.println(getTime()+client.getInetAddress());
				
				OutputStream os = client.getOutputStream();
				ObjectOutputStream dos = new ObjectOutputStream(os);
				
				File ff = new File("fff/1.jpg");
				
				FileInputStream fis = new FileInputStream(ff);
				byte [] buf = new byte[(int)ff.length()];
				
				fis.read(buf);
				
				fis.close();
				
				
				int kind = 1;
				dos.writeInt(kind); //0.msg //1.file
				
				switch(kind)
				{
					case 0:
						dos.writeUTF("스윙으로 서버 IP 설정 하고 서버로 받은 메세지를 화면에 출력하세요 윤성문은 파일도 전송받으세요");
						break;
					case 1:
						dos.writeUTF(ff.getName());
						//Thread.sleep(10);
						dos.writeObject(buf);
						break;
					
				}
				
				
				dos.close();
				os.close();
				client.close();
				
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
