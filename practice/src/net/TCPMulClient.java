package net;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class TCPMulCliSender extends Thread{
	DataOutputStream dos;
	String name;
	
	TCPMulClient tmc;
	
	public TCPMulCliSender(Socket socket, TCPMulClient tmc) {
		// TODO Auto-generated constructor stub
		this.tmc = tmc;
		
		try {
			dos = new DataOutputStream(socket.getOutputStream());
			name = "[조아따"/*+socket.getLocalAddress()*/+"] ";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//try {
			//dos.writeUTF(name);
			//Scanner sc = new Scanner(System.in);
			/*while(dos!=null)
			{
				dos.writeUTF(name+sc.nextLine());
			}*/
		
		
			tmc.send.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					try {
						dos.writeUTF(name + tmc.send.getText());
						tmc.receive.append(tmc.send.getText()+"\n");
						tmc.send.setText("");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			
			
			tmc.s_Button.addActionListener(new ActionListener() {
			
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					try {
						//dos.writeUTF(name);
						dos.writeUTF(name + tmc.send.getText());
						tmc.receive.append(tmc.send.getText()+"\n");
						tmc.send.setText("");
						
					} catch (IOException ee) {
						// TODO Auto-generated catch block
						ee.printStackTrace();
					}
				}
			});
	
		/*} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
}

class TCPMulCliReceiver extends Thread
{
	DataInputStream dis;
	//TCPMulServer tms;
	TCPMulClient tmc;
	
	public TCPMulCliReceiver(Socket socket, TCPMulClient tmc) {
		// TODO Auto-generated constructor stub
		
		this.tmc = tmc;
		
		
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
				//System.out.println(dis.readUTF());
				tmc.receive.append(dis.readUTF()+"\n");
				tmc.receive.setCaretPosition(tmc.receive.getDocument().getLength());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

public class TCPMulClient extends JFrame{
	
	JTextArea receive = new JTextArea();
	JTextField send = new JTextField();
	JButton s_Button = new JButton("보 내 기");
	JScrollPane vs;
	Font ff = new Font("Serif", Font.BOLD, 20);
	
	public TCPMulClient() {
		// TODO Auto-generated constructor stub
		setTitle("서버_채팅창");
		setBounds(100, 15, 418, 670);
		setLayout(null);
		
		receive.setBackground(Color.yellow);
		receive.setFont(ff);
		receive.setForeground(Color.BLACK);
		receive.setOpaque(true);
		receive.setEditable(false);
		
		send.setLayout(new BorderLayout());
		send.setBounds(10, 520, 300, 100);
		send.setBackground(Color.cyan);

		s_Button.setBounds(313, 520, 80, 100);

		vs = new JScrollPane(receive);

		vs.setBounds(10, 10, 383, 500);
		//add(receive);
		add(vs);
		add("South", send);
		add(s_Button);

		receive.setFocusable(false);
		send.setFocusable(true);
		
		setVisible(true);		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//TCPMulServer tms = new TCPMulServer();
		TCPMulClient tmc = new TCPMulClient();
		
		tmc.setTitle("클라이언트_채팅창");
		tmc.setBounds(500, 15, 418, 670);
		
		try {
			Socket socket = new Socket("192.168.0.29",7777);
		
			System.out.println("서버연결 성공");
			
			new TCPMulCliSender(socket, tmc).start();
			new TCPMulCliReceiver(socket,tmc).start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
