package net;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Server extends JFrame{
	
	String str="";
	
	class DialButton implements ActionListener
	{
		JFrame jf1 = new JFrame();
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			FileDialog fd = new FileDialog(jf1, "파일열기", FileDialog.LOAD);
				fd.setLocation(10, 100);
				fd.setDirectory("C:\\Users\\DELL\\Desktop");
				fd.setVisible(true);
				
				str+=fd.getDirectory();
				str+=fd.getFile();
		}
	}
	
	class StartButton implements ActionListener
	{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			try {
				ServerSocket ss = new ServerSocket(7777);
				System.out.println("서버가 준비되었습니다.");
				
				while(true)
				{
					Socket sk = ss.accept();
					
					OutputStream os = sk.getOutputStream();
					ObjectOutputStream oos = new ObjectOutputStream(os);
					
					File ff = new File(str);
					
					FileInputStream fis = new FileInputStream(ff);
					byte [] buf = new byte[(int)ff.length()];
					
					fis.read(buf);
					fis.close();
					
					oos.writeUTF(ff.getName());
					//Thread.sleep(10);
					oos.writeObject(buf);
					
					
					oos.close();
					os.close();
					sk.close();
					
				} 
			}catch (IOException ee) {
				// TODO Auto-generated catch block
				ee.printStackTrace();
			}
		}
	}
	
	public Server() {
		// TODO Auto-generated constructor stub
		
		JButton dial = new JButton("FileDialog");
		JButton start = new JButton("실   행");
		
		setBounds(100, 100, 400, 375);
		setLayout(null);

		dial.setBounds(100, 210, 200, 50);
		dial.addActionListener(new DialButton());
		
		start.setBounds(100, 270, 200, 50);
		start.addActionListener(new StartButton());
		
		add(dial);
		add(start);
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new Server();
	
	}

}
