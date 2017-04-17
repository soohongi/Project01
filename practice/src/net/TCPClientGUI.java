package net;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Arrays;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TCPClientGUI extends JFrame implements ActionListener{

	JTextField ipFF = new JTextField("192.168.1.4");
	JTextField portFF = new JTextField("7777");
	JLabel res = new JLabel();
	public TCPClientGUI() {
		// TODO Auto-generated constructor stub
		setBounds(1600, 0, 300, 200);
		setLayout(new GridLayout(4, 1));
		add(ipFF);
		add(portFF);
		JButton btn = new JButton("접속");
		add(btn);
		add(res);
		
		setVisible(true);
		
		btn.addActionListener(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new TCPClientGUI();
		
	}
	@Override
	public void actionPerformed(ActionEvent ee) {
		// TODO Auto-generated method stub
		try {
			
			if(!Pattern.matches("[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}", ipFF.getText()))
			{
				
				throw new Exception("ip 확!!!");
			}
			if(!Pattern.matches("[0-9]{4,5}", portFF.getText()))
			{
				
				throw new Exception("port 확!!!");
			}
			//Socket socket = new Socket("192.168.1.33", 7777);
			Socket socket = new Socket(ipFF.getText(), 
					Integer.parseInt(portFF.getText()));
			
			InputStream is = socket.getInputStream();
			ObjectInputStream dis = new ObjectInputStream(is);
			
			switch(dis.readInt())
			{
				case 0:
					res.setText(dis.readUTF());
					break;
				case 1:
					
					FileOutputStream fos = new FileOutputStream("ttt/"+dis.readUTF());
					
					byte [] buf=(byte [])dis.readObject();
					System.out.println(buf.length);
					fos.write(buf);
					fos.close();
					break;
			}
			
			dis.close();
			is.close();
			socket.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			res.setText(e.getMessage());
		}
	}

}
