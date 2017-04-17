package net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;

public class UniCastReciever {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			DatagramSocket ds = new DatagramSocket(7777);
			
			byte [] arr = new byte[1024];
			
			DatagramPacket data = new DatagramPacket(arr, arr.length);
			while(true)
			{
				ds.receive(data);
				System.out.println("받음:"+new String(arr));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		class Ucr extends Thread
		{
			
			DataInputStream dis;
			DataOutputStream dos;
			
			public Ucr(Socket socket) {
				// TODO Auto-generated constructor stub
				try {
					this.dis = new DataInputStream(socket.getInputStream());
					this.dos = new DataOutputStream(socket.getOutputStream());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				String name=null;
				try {
					name=dis.readUTF();
					sendToAll("### "+name+" 입장");
					//System.out.println("### "+name+" 입장");
					//System.out.println("### 접속자 수:"+list.size());
					while(dis!=null)
					{
						sendToAll(dis.readUTF());
					}
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}finally{
					sendToAll("### "+name+" 퇴장");
					//System.out.println("### "+name+" 퇴장");
					//System.out.println("### 접속자 수:"+list.size());
				}
			}
			
			void sendToAll(String msg)
			{
				try {
					dos.writeUTF(msg);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}