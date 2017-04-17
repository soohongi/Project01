package udtmulchat;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

import javax.swing.JDialog;
import javax.swing.JFrame;

class Bt_dial implements ActionListener
{
	Chat_Frame cf;
	public Bt_dial(Chat_Frame cf) {
		// TODO Auto-generated constructor stub
		this.cf = cf;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		FileDialog jd = new FileDialog(cf, "파일 첨부", FileDialog.LOAD);
		
		jd.setDirectory("C:\\Users\\DELL\\Desktop");
		jd.setVisible(true);
	}
}

public class MultiCastSender extends Thread implements ActionListener{
	
	Chat_Frame cf ;
	String name = "[ 조아따 ]";
	
	public MultiCastSender(Chat_Frame cf) {
		// TODO Auto-generated constructor stub	
		this.cf = cf;
	}	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub

		cf.bt_input.addActionListener(this);
		cf.chat_input.addActionListener(this);
		cf.bt_dial.addActionListener(new Bt_dial(cf));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		try {
			MulticastSocket ms = new MulticastSocket();
			String msg = name + cf.chat_input.getText();
			InetAddress is = InetAddress.getByName("230.0.0.1");
			DatagramPacket ds = new DatagramPacket(msg.getBytes(), msg.getBytes().length, is, 7777);
			ms.send(ds);
			cf.chat_input.setText("");
			
			//ms.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}