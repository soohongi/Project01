package practice;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class swing_p {
	
	JFrame jf = new JFrame();
	JLabel test = new JLabel();
	
	public swing_p() {
		// TODO Auto-generated constructor stub

		jf.setBounds(100, 100, 800, 600);
		jf.setLayout(null);
		
		JLabel idLB = new  JLabel("�̸� : ");
		idLB.setBounds(50, 20, 50,50);
		jf.add(idLB);
		
		JTextField id = new JTextField("  �� �� �� �� ");
		id.setBounds(90, 30, 100, 50);
		id.setSize(80, 30);
		jf.add(id);
		
		
		
		ImageIcon img = new ImageIcon("fff/123.png");
		
		Image ori = img.getImage();
		
		ImageIcon img2 = new ImageIcon(ori);
		JButton b2 = new JButton(img2);
		b2.setBounds(530, 13, 230, 200);
		b2.addActionListener(new bt());
		//b2.setEnabled(true);
		
		
		jf.add(b2);
		
		
		JLabel phone = new  JLabel("����ó : ");
		phone.setBounds(37, 60, 50,50);
		jf.add(phone);
		
		JTextField phonenb = new JTextField("010-7777-7777");
		phonenb.setBounds(90, 70, 180, 30);
		//phonenb.setSize(80, 30);
		jf.add(phonenb);
		

		JLabel genLB = new  JLabel("����:");
		genLB.setBounds(300, 60, 50,50);
		jf.add(genLB);
		
		JRadioButton gen1 = new JRadioButton("����",true);
		JRadioButton gen2 = new JRadioButton("����");
		
		gen1.setBounds(330, 60, 60,50);
		gen2.setBounds(390, 60, 60,50);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(gen1);
		bg.add(gen2);
		jf.add(gen1);
		jf.add(gen2);
		

		
		JLabel juso = new  JLabel("�ּ� : ");
		juso.setBounds(46, 120, 50,50);
		jf.add(juso);
		
		JTextField juso_txt = new JTextField("����Ư���� ������ ���ﵿ ");
		juso_txt.setBounds(90, 130, 200, 30);
		//juso_txt.setSize(200, 80);
		jf.add(juso_txt);

		JLabel emailLB = new  JLabel("email :");
		emailLB.setBounds(40, 170, 50,50);
		jf.add(emailLB);
		
		
		JTextField mail_txt = new JTextField("Rilakkuma");
		mail_txt.setBounds(90, 180, 200, 30);
		//juso_txt.setSize(200, 80);
		jf.add(mail_txt);
		
		
		JLabel email_ = new  JLabel("@");
		email_.setBounds(293, 170, 50,50);
		jf.add(email_);

		String [] emailArr = {
				"naver.com","daum.com","gmail.com","�����Է�"
		};
		JComboBox email = new JComboBox<>(emailArr);
		email.setBounds(310, 180, 200,30);
		jf.add(email);
		
		JLabel frLB = new  JLabel("���� ���� :");
		frLB.setBounds(35, 230, 100,50);
		jf.add(frLB);
		
		String [][] rowData={
				{"����1","1111-1111","35", "��"},
				{"����2","2222-2222","30", "��"},
				{"����3","2222-2222","15", "��"},
				};
		String []columnNames={"�̸�","��ȭ","����","����"};
		
		JTable fr = new JTable(rowData, columnNames);
		
		JPanel jp = new JPanel();
		jp.setBounds(35, 280, 700, 73);
		jp.setLayout(new BorderLayout());
		jp.add(new JScrollPane(fr));
		jf.add(jp);

		JLabel frLB1 = new  JLabel("�ڰ��� :");
		frLB1.setBounds(35, 370, 100,50);
		jf.add(frLB1);
		
		String [][] rowData1={
				{"����ó�����","���󿡼�","����"},
				{"1�� ����","�̰͵� ���󿡼�","����"},
				{"�߱��߱�","�̰� ���濡��","����"},
				};
		String []columnNames1={"�ڰ��� ��","�߱�ó", "�����"};
		
		JTable fr1 = new JTable(rowData1, columnNames1);
		
		JPanel jp1 = new JPanel();
		jp1.setBounds(35, 420, 700, 73);
		jp1.setLayout(new BorderLayout());
		jp1.add(new JScrollPane(fr1));
		jf.add(jp1);

		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		test.setBounds(0,0,200,200);
		test.setBackground(Color.black);
		test.setOpaque(true);
		jf.add(test);
	}
	
	class bt implements ActionListener
	{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			
			jf.removeAll();
			
			System.out.println("123123");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new swing_p();
		

	}

}
