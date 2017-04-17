package io;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.InputStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Hw_0328_Socket extends JFrame {

	JLabel big = new JLabel();
	JLabel ip_lb = new JLabel(" I P ");
	JLabel port_lb = new JLabel(" P O R T ");
	JTextField ip = new JTextField();
	JTextField port = new JTextField();
	JButton res = new JButton("확     인");

	class BtnAction implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			String ipadress = ip.getText();
			int portNum = (Integer.parseInt(port.getText()));
			
			System.out.println(ipadress);
			System.out.println(portNum);

			try {
				// Socket socket = new Socket("192.168.1.33", 7777);
				Socket socket = new Socket(ipadress, portNum);

				InputStream is = socket.getInputStream();
				DataInputStream dis = new DataInputStream(is);

				big.setText(dis.readUTF());

				dis.close();
				is.close();
				socket.close();
			} 
			
			catch (Exception ee) {
				// TODO Auto-generated catch block
				ee.printStackTrace();
			}
		}
	}
	
	public Hw_0328_Socket() {
		// TODO Auto-generated constructor stub

	setTitle("재미난 숙제");
	setBounds(100,100,720,810);
	setLayout(null);
	
	big.setBounds(50, 20, 600, 550);
	big.setBackground(Color.YELLOW);
	big.setOpaque(true);
	
	ip_lb.setBounds(70, 590, 50, 50);
	ip.setBounds(100, 590, 500, 50);
	ip.setBackground(Color.CYAN);
	
	port_lb.setBounds(45, 650, 50, 50);
	port.setBounds(100, 650, 500, 50);
	port.setBackground(Color.pink);

	res.setBounds(450, 710, 150, 50);
	
	add(big);
	add(ip_lb);
	add(ip);
	add(port_lb);
	add(port);
	add(res);
	
	res.addActionListener(new BtnAction());
	
	setVisible(true);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new Hw_0328_Socket();
	}	
}