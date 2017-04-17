package net;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

class TCPSingleReceiver extends Thread
{
	DataInputStream dis;
	TCPSingleServer sv;
	
	public TCPSingleReceiver(Socket socket, TCPSingleServer sv) {
		// TODO Auto-generated constructor stub
		this.sv=sv;
		
		try {
			
			dis = new DataInputStream(socket.getInputStream());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(dis!=null)
		{
			try {
				sv.receive.append(dis.readUTF()+"\n");
				sv.receive.setCaretPosition(sv.receive.getDocument().getLength());
				//System.out.println(dis.readUTF());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

public class TCPSingleClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TCPSingleServer sv = new TCPSingleServer();
		sv.setTitle("클라이언트_채팅창");
		sv.setBounds(500, 15, 418, 670);
		try {
			//Socket socket = new Socket("192.168.1.4", 7777);
			Socket socket = new Socket("192.168.1.4", 7777);

			System.out.println("서버연결 성공");
			
			new TCPSingleReceiver(socket, sv).start();
			new TCPSingleSender(socket, sv).start();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
