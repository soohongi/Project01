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
		
		JLabel idLB = new  JLabel("이름 : ");
		idLB.setBounds(50, 20, 50,50);
		jf.add(idLB);
		
		JTextField id = new JTextField("  리 락 쿠 마 ");
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
		
		
		JLabel phone = new  JLabel("연락처 : ");
		phone.setBounds(37, 60, 50,50);
		jf.add(phone);
		
		JTextField phonenb = new JTextField("010-7777-7777");
		phonenb.setBounds(90, 70, 180, 30);
		//phonenb.setSize(80, 30);
		jf.add(phonenb);
		

		JLabel genLB = new  JLabel("성별:");
		genLB.setBounds(300, 60, 50,50);
		jf.add(genLB);
		
		JRadioButton gen1 = new JRadioButton("남자",true);
		JRadioButton gen2 = new JRadioButton("여자");
		
		gen1.setBounds(330, 60, 60,50);
		gen2.setBounds(390, 60, 60,50);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(gen1);
		bg.add(gen2);
		jf.add(gen1);
		jf.add(gen2);
		

		
		JLabel juso = new  JLabel("주소 : ");
		juso.setBounds(46, 120, 50,50);
		jf.add(juso);
		
		JTextField juso_txt = new JTextField("서울특별시 강남구 역삼동 ");
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
				"naver.com","daum.com","gmail.com","직접입력"
		};
		JComboBox email = new JComboBox<>(emailArr);
		email.setBounds(310, 180, 200,30);
		jf.add(email);
		
		JLabel frLB = new  JLabel("가족 관계 :");
		frLB.setBounds(35, 230, 100,50);
		jf.add(frLB);
		
		String [][] rowData={
				{"리락1","1111-1111","35", "부"},
				{"리락2","2222-2222","30", "모"},
				{"리락3","2222-2222","15", "형"},
				};
		String []columnNames={"이름","전화","나이","관계"};
		
		JTable fr = new JTable(rowData, columnNames);
		
		JPanel jp = new JPanel();
		jp.setBounds(35, 280, 700, 73);
		jp.setLayout(new BorderLayout());
		jp.add(new JScrollPane(fr));
		jf.add(jp);

		JLabel frLB1 = new  JLabel("자격증 :");
		frLB1.setBounds(35, 370, 100,50);
		jf.add(frLB1);
		
		String [][] rowData1={
				{"정보처리기사","나라에서","어제"},
				{"1종 보통","이것도 나라에서","오늘"},
				{"뒹굴뒹굴","이건 내방에서","내일"},
				};
		String []columnNames1={"자격증 명","발급처", "취득일"};
		
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
