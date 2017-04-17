package dupchat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


class SingleSender extends Thread
{
	String name;
	Chat_Frame cf;
	String ip;
	int port;
	
	public SingleSender(Chat_Frame cf, String ip, int port) {
		// TODO Auto-generated constructor stub
		this.cf = cf;
		this.ip  = ip;
		this.port = port;
		name = "[조아따]";
	}
	class Send implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
	  
	        	DatagramSocket ds = new DatagramSocket();
				InetAddress addr = InetAddress.getByName(ip);
				
				String buf = name+" "+cf.chat_input.getText();
				
				DatagramPacket data = new DatagramPacket(
						buf.getBytes(), 
						buf.getBytes().length, 
						addr, 
						port
					);
				ds.send(data);
				cf.chat_main.append("\n"+"[나] "+cf.chat_input.getText());
				cf.chat_input.setText("");
	            
				cf.chat_main.setCaretPosition(cf.chat_main.getDocument().getLength());
				cf.chat_input.setFocusable(true);
	        } catch (IOException e1) {
	            // TODO Auto-generated catch block
	            e1.printStackTrace();
	        }
		}
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		cf.chat_input.addActionListener(new Send());
		cf.bt_input.addActionListener(new Send());
	}
}


class SingleReceiver extends Thread
{
	int port;
	Chat_Frame cf;
	
	public SingleReceiver(Chat_Frame cf, int port) {
		this.cf = cf;
		this.port = port;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		try {
			DatagramSocket ds = new DatagramSocket(port);

			while(true)
			{
				byte [] arr = new byte[1024];
				DatagramPacket data = new DatagramPacket(arr, arr.length);
				ds.receive(data);
				cf.chat_main.append("\n"+new String(arr).trim());
				cf.chat_main.setCaretPosition(cf.chat_main.getDocument().getLength());
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

public class SingleChat {

	Chat_Frame cf = new Chat_Frame();
	String ip;
	int port;
	
	public SingleChat() {
		// TODO Auto-generated constructor stub
	
		try {
			//cf.chat_input.setEnabled(true);
			cf.ip_port_check.addActionListener(new ipcheck());
			
			//new SingleSender(cf,ip,port).start();
			//new SingleReceiver(cf,port).start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	class ipcheck implements ActionListener
	{	
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			// TODO Auto-generated method stub
			if(cf.rb_sg.isSelected()){
				ip = cf.ip.getText();
				port = (Integer.parseInt(cf.port.getText()));
			
			}
			else if(cf.rb_bc.isSelected())
			{
				ip = "192.168.0.255";
				port =7777;
			}
			
			new SingleSender(cf,ip,port).start();
			new SingleReceiver(cf,port).start();
		}			
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SingleChat();
		

	}
}
