package io;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
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
			System.out.println("�����غ�");
			
			while(true)
			{
				Socket client = server.accept();
				
				System.out.println(getTime()+client.getInetAddress());
				
				OutputStream os = client.getOutputStream();
				DataOutputStream dos = new DataOutputStream(os);
				
				File ff = new File("fff/bsy.jpg");
				
				FileInputStream fis = new FileInputStream(ff);
				byte [] buf = new byte[(int)ff.length()];
				
				fis.read(buf);
				
				fis.close();
				
				
				int kind = 1;
				dos.writeInt(kind); //0.msg //1.file
				
				switch(kind)
				{
					case 0:
						dos.writeUTF("�������� ���� IP ���� �ϰ� ������ ���� �޼����� ȭ�鿡 ����ϼ��� �������� ���ϵ� ���۹�������");
						break;
					case 1:
						dos.writeUTF(ff.getName());
						dos.writeUTF(new String(buf));
						break;
					
				}
				
				
				dos.close();
				os.close();
				client.close();
				
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
