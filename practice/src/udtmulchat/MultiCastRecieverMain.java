package udtmulchat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MultiCastRecieverMain extends Thread{
	
	Chat_Frame cf;
	
	public MultiCastRecieverMain(Chat_Frame cf) {
		// TODO Auto-generated constructor stub
		this.cf = cf;
	}
	
	@Override
	public void run() {
	// TODO Auto-generated method stub
		
		try {
			MulticastSocket ms = new MulticastSocket(7777);
			InetAddress is = InetAddress.getByName("230.0.0.1");
			ms.joinGroup(is);
			
			while(true)
			{
				byte [] arr = new byte[1024];
				DatagramPacket ds = new DatagramPacket(arr, arr.length);
				cf.chat_main.setCaretPosition(cf.chat_main.getText().length());
				ms.receive(ds);
				//System.out.println(new String (arr));
				cf.chat_main.append(new String(arr).trim()+"\n");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}