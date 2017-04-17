package swing;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;

class Calculator extends JFrame
{
	public Calculator() {
		// TODO Auto-generated constructor stub
	
	setBounds(100,100,500,500);
	setLayout(null);
	
	JMenuBar mb = new JMenuBar();
	setJMenuBar(mb);
	
	JMenu main1= new JMenu("���� (V)");
	JMenu main2= new JMenu("���� (E)");
	JMenu main3= new JMenu("���� (H)");
	
	mb.add(main1);
	mb.add(main2);
	mb.add(main3);

	JRadioButtonMenuItem item1_1 = new JRadioButtonMenuItem("�Ϲݿ� (T)", true);
	item1_1.setAccelerator(
			KeyStroke.getKeyStroke(KeyEvent.VK_1,KeyEvent.ALT_MASK)
			);
	JRadioButtonMenuItem item1_2 = new JRadioButtonMenuItem("���п� (S)");
	item1_2.setAccelerator(
			KeyStroke.getKeyStroke(KeyEvent.VK_2,KeyEvent.ALT_MASK)
			);
	JRadioButtonMenuItem item1_3 = new JRadioButtonMenuItem("���α׷��ӿ� (P)");
	item1_3.setAccelerator(
			KeyStroke.getKeyStroke(KeyEvent.VK_3,KeyEvent.ALT_MASK)
			);
	JRadioButtonMenuItem item1_4 = new JRadioButtonMenuItem("���� (A)");
	item1_4.setAccelerator(
			KeyStroke.getKeyStroke(KeyEvent.VK_4,KeyEvent.ALT_MASK)
			);
	
	
	main1.add(item1_1);
	main1.add(item1_2);
	main1.add(item1_3);
	main1.add(item1_4);
	
	
	
	ButtonGroup bg1 = new ButtonGroup();
	bg1.add(item1_1);
	bg1.add(item1_2);
	bg1.add(item1_3);
	bg1.add(item1_4);
	
	main1.addSeparator();
	
	//////////////////////////////////////////////////////
	
	
	JMenuItem item1_5 = new JMenuItem("��� (Y)");
	item1_5.setAccelerator(
			KeyStroke.getKeyStroke(KeyEvent.VK_H,KeyEvent.CTRL_MASK)
			);
	
	JMenuItem item1_6 = new JMenuItem("�ڸ��� ���� ���� (J)..");

	main1.add(item1_5);
	main1.add(item1_6);
	
	main1.addSeparator();
	
	/////////////////////////////////////////////////////

	JRadioButtonMenuItem item1_7 = new JRadioButtonMenuItem("�⺻ (B)", true);
	item1_7.setAccelerator(
			KeyStroke.getKeyStroke(KeyEvent.VK_F2,KeyEvent.CTRL_MASK)
			);
	JRadioButtonMenuItem item1_8 = new JRadioButtonMenuItem("���� ��ȯ (U)");
	item1_8.setAccelerator(
			KeyStroke.getKeyStroke(KeyEvent.VK_U,KeyEvent.CTRL_MASK)
			);
	JRadioButtonMenuItem item1_9 = new JRadioButtonMenuItem("��¥ ��� (D)");
	item1_9.setAccelerator(
			KeyStroke.getKeyStroke(KeyEvent.VK_E,KeyEvent.CTRL_MASK)
			);
	
	
	ButtonGroup bg2 = new ButtonGroup();
	bg2.add(item1_7);
	bg2.add(item1_8);
	bg2.add(item1_9);

	
	main1.add(item1_7);
	main1.add(item1_8);
	main1.add(item1_9);
	
	JMenu item1_10 = new JMenu("��ũ��Ʈ (W)");
	
	JMenuItem item1_10_1 = new JMenuItem("���� �㺸 ���� (M)");
	JMenuItem item1_10_2 = new JMenuItem("�ڵ��� �Ӵ� (V)");
	JMenuItem item1_10_3 = new JMenuItem("���� ��� (mpg)(F)");
	JMenuItem item1_10_4 = new JMenuItem("���� �㺸 ���� (L/100km)(U)");
	
	main1.add(item1_10);
	
	item1_10.add(item1_10_1);
	item1_10.add(item1_10_2);
	item1_10.add(item1_10_3);
	item1_10.add(item1_10_4);
	
	
	
	JMenuItem item2_1 = new JMenuItem("���� (C)");
	item2_1.setAccelerator(
			KeyStroke.getKeyStroke(KeyEvent.VK_C,KeyEvent.CTRL_MASK)
			);
	JMenuItem item2_2 = new JMenuItem("�ٿ��ֱ� (P)");
	item2_2.setAccelerator(
			KeyStroke.getKeyStroke(KeyEvent.VK_V,KeyEvent.CTRL_MASK)
			);
	
	main2.add(item2_1);
	main2.add(item2_2);
	
	main2.addSeparator();
	
	
	JMenu item2_3 = new JMenu("��� (H)");
	
	JMenuItem item2_3_1 = new JMenuItem("��� ���� (T)");
	
	JMenuItem item2_3_2 = new JMenuItem("���� (E)");
	item2_3_2.setAccelerator(
			KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0)
			);
	JMenuItem item2_3_3 = new JMenuItem("���� ��� (N)");
	item2_3_3.setAccelerator(
			KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0)
			);
	JMenuItem item2_3_4 = new JMenuItem("����� (L)");
	item2_3_4.setAccelerator(
			KeyStroke.getKeyStroke(KeyEvent.VK_D, KeyEvent.SHIFT_DOWN_MASK)
			);
	
	main2.add(item2_3);
	
	item2_3.add(item2_3_1);
	item2_3.add(item2_3_2);
	item2_3.add(item2_3_3);
	item2_3.add(item2_3_4);
	
	
	
	JMenuItem item3_1 = new JMenuItem("���� ���� (V)");
	item3_1.setAccelerator(
			KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0)
			);
	
	JMenuItem item3_2 = new JMenuItem("���� ���� (A)");

	main3.add(item3_1);
	main3.addSeparator();
	main3.add(item3_2);

	/////////////////////////////////////////////////
	
	 JLabel lb1 = new JLabel("0", JLabel.RIGHT);
     lb1.setFont(new Font("Arial", Font.BOLD, 30));
     lb1.setBounds(0, 0, 300, 300);
     add(lb1);

     JPanel jp1 =new JPanel();
     jp1.setBounds(20, 20, 450, 100);
     jp1.setLayout(new BorderLayout());
     jp1.setBackground(Color.yellow);
     
     jp1.add(lb1);
     add(jp1);
     
     /////////////////////////////////////////////////
     
     JButton jb5 = new JButton("=");
     jb5.setBounds(384, 338, 86, 92);
     add(jb5);
     
     JButton jb6 = new JButton("0");
     jb6.setBounds(20, 385, 177, 45);
     add(jb6);

     ///////////////////////////////////////////////////
     
     JPanel jp2 =new JPanel();
     jp2.setBounds(20, 150, 450, 280);
     jp2.setBackground(Color.WHITE);
     jp2.setLayout(new GridLayout(6,5,5,2));
     
     jp2.add(new JButton("MC"));
     jp2.add(new JButton("MR"));
     jp2.add(new JButton("MS"));
     jp2.add(new JButton("M+"));
     jp2.add(new JButton("M-"));
     jp2.add(new JButton("�� "));
     jp2.add(new JButton("CE"));
     jp2.add(new JButton("C "));
     jp2.add(new JButton("�� "));
     jp2.add(new JButton("�� "));
     jp2.add(new JButton("7 "));
     jp2.add(new JButton("8 "));
     jp2.add(new JButton("9 "));
     jp2.add(new JButton("/ "));
     jp2.add(new JButton("% "));
     jp2.add(new JButton("4 "));
     jp2.add(new JButton("5 "));
     jp2.add(new JButton("6 "));
     jp2.add(new JButton("* "));
     jp2.add(new JButton("1/x "));
     jp2.add(new JButton("1"));
     jp2.add(new JButton("2"));
     jp2.add(new JButton("3"));
     jp2.add(new JButton("-"));
     jp2.add(new JPanel());
     jp2.add(new JPanel());
     jp2.add(new JPanel());
     jp2.add(new JButton("."));
     jp2.add(new JButton("+"));
     add(jp2);
     
	setVisible(true);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	}
}
public class CalculatorMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Calculator();
	}
}