package udtmulchat;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Chat_Frame extends JFrame{
	
	Font ff = new Font("Serif", Font.ITALIC, 15);
	Font fff = new Font("Serif", Font.BOLD, 25);
	JRadioButton rb_sg = new JRadioButton("싱글 채팅", true);
	JRadioButton rb_bc = new JRadioButton("브로드캐스트");
	ButtonGroup rb = new ButtonGroup();
	
	JButton bt_dial = new JButton("파일 첨부");
	
	JLabel ip_lb = new JLabel(" I P ");
	JLabel port_lb = new JLabel(" P O R T ");
	JTextField ip = new JTextField();
	JTextField port = new JTextField();
	
	JButton ip_port_check = new JButton("확     인");

	JTextArea chat_main = new JTextArea();
	JScrollPane main_scr = new JScrollPane(chat_main);
	JTextField chat_input = new JTextField();
	JButton bt_input = new JButton("보  내  기");
	

	public Chat_Frame() {
		// TODO Auto-generated constructor stub
	setTitle("프레임");
	setBounds(20, 20, 480, 810);
	setLayout(null);
	
	/*rb_sg.setBounds(40, 20, 90, 50);
	rb_sg.setFont(ff);
	rb_bc.setBounds(150, 20, 120, 50);
	rb_bc.setFont(ff);

	rb.add(rb_sg);
	rb.add(rb_bc);
	
	add(rb_sg);
	add(rb_bc);*/
	
	bt_dial.setBounds(340, 30, 120, 30);
	add(bt_dial);
	
	/*ip_lb.setBounds(5, 60, 20, 50);
	add(ip_lb);
	
	ip.setBounds(30, 70, 150, 30);
	add(ip);
	
	port_lb.setBounds(200, 60, 50, 50);
	add(port_lb);
	
	port.setBounds(250,70, 70, 30);
	add(port);*/
	
	/*ip_port_check.setBounds(340, 70, 120, 30);
	add(ip_port_check);*/

	main_scr.setBounds(5, 120, 450, 560);
	chat_main.setBackground(Color.YELLOW);
	chat_main.setFont(fff);
	add(main_scr);
	
	chat_input.setBounds(5, 685, 360, 80);
	chat_input.setFont(fff);
	chat_input.setBackground(Color.CYAN);

	
	bt_input.setBounds(365, 685, 90, 80);
	
	add(bt_input);
	add(chat_input);
	
	setVisible(true);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	}

	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Chat_Frame();
	}*/

}
