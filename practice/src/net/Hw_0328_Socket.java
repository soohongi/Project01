package net;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Hw_0328_Socket extends JFrame {

	JLabel big = new JLabel();
	JLabel ip_lb = new JLabel(" I P ");
	JLabel port_lb = new JLabel(" P O R T ");
	JTextField ip = new JTextField("192.168.1.4");
	JTextField port = new JTextField("7777");
	JButton res = new JButton("확     인");
	
	int imgw = 0;
	int imgh = 0;
	
	String str="";

	class BtnAction implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
				
				String ipadress = ip.getText();
					if(!Pattern.matches("[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}", ipadress))
					{
						throw new Exception("ip 확!!!");
					}
				
					if(!Pattern.matches("[0-9]{4,5}", port.getText()))
					{
						throw new Exception("port 확!!!");
					}
					
				int portNum = (Integer.parseInt(port.getText()));
	
				Socket socket = new Socket(ipadress, portNum);

				//InputStream is = socket.getInputStream();
				//DataInputStream dis = new DataInputStream(is);

				
				InputStream is = socket.getInputStream();
				ObjectInputStream dis = new ObjectInputStream(is);
				
				
				//big.setText(dis.readUTF());
				
				str+="ttt/"+dis.readUTF();
				FileOutputStream fos = new FileOutputStream(str);
				
				
				
				
				
				/*imgw = icon.getIconWidth();
				imgh = icon.getIconHeight();

				big.setBounds(18, 20, imgw, imgh);
				res.setBounds(100, 700, 600, 50);
				
				add(big);

				setBounds(50, 50, imgw+50, imgh+130);
				res.setBounds(20, imgh+30, imgw, 50);*/
				
				
				byte [] buf=(byte [])dis.readObject();
				System.out.println(buf.length);
				fos.write(buf);
				fos.close();
				
				if(Pattern.matches(".*\\.(jpg|png|gif|bmp)", str.toLowerCase())) 
				{
					ImageIcon icon = new ImageIcon(str);
					big.setIcon(icon);
					
					imgw = icon.getIconWidth();
					imgh = icon.getIconHeight();
					
					add(big);
					
					big.setBounds(200, 50, imgw, imgh);
					big.setVisible(true);
				}
				else if(Pattern.matches(".*\\.(txt|doc|ppt)", str.toLowerCase())) 
				{
					//ImageIcon icon = new ImageIcon(str);
					//big.setText(str);
					
					//imgw = icon.getIconWidth();
					//imgh = icon.getIconHeight();
								
					
					// ==>> Label에 텍스트 파일을 열어야한다. 텍스트 출력
					
					
					add(big);
					
					big.setBounds(200, 50, imgw, imgh);
					big.setVisible(true);
				}
				
				

				dis.close();
				is.close();
				socket.close();
			} 
			
			catch (Exception ee) {
				// TODO Auto-generated catch block
				/*ee.printStackTrace();*/
				big.setText(ee.getMessage());
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