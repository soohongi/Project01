package net;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class TCPSingleSender extends Thread{
	
	DataOutputStream dos;
	String name;
	TCPSingleServer sv;

	public TCPSingleSender(Socket socket, TCPSingleServer sv) {
		// TODO Auto-generated constructor stub
		this.sv=sv;
		
		try {
			dos = new DataOutputStream(socket.getOutputStream());
			name = "["+socket.getLocalAddress()+"]";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//Scanner sc = new Scanner(System.in);
		
		//while (dos != null) {
			sv.s_Button.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					try {

						dos.writeUTF(name + sv.send.getText());
						sv.receive.append(sv.send.getText()+"\n");
						sv.send.setText("");
						
					} catch (IOException ee) {
						// TODO Auto-generated catch block
						ee.printStackTrace();
					}
				}
			});
		//}
	}
}


public class TCPSingleServer extends JFrame{
	JTextArea receive = new JTextArea();
	JTextField send = new JTextField();
	JButton s_Button = new JButton("보 내 기");
	JScrollPane vs;
	Font ff = new Font("Serif", Font.BOLD, 20);

	public TCPSingleServer() {
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

		TCPSingleServer sv = new TCPSingleServer();

		try {
			ServerSocket server= new ServerSocket(7777);
			System.out.println("서버준비 완료");
			Socket client = server.accept();
			
			new TCPSingleSender(client, sv).start();
			new TCPSingleReceiver(client, sv).start();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}