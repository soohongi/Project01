package swing;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Exam_01 extends JFrame{

	ArrayList<JPanel> cardMap = new ArrayList<>();
	JPanel cardPP = new JPanel();
	CardLayout card = new CardLayout();
	JLabel test = new JLabel();
	
	class BtnAction implements ActionListener
	{
		int num;
		
		public BtnAction(int num) {
			this.num = num;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			card.show(cardPP, num+"");
		}
	}
	
	
	
	public Exam_01() {
		// TODO Auto-generated constructor stub
		setBounds(300, 0, 600, 600);
		JPanel qqPP = new JPanel();
		
		test.setBounds(0,0,200,200);
		test.setOpaque(true);
		add(test);
		cardMap.add(new JPanel());
		cardMap.add(new JPanel());
		cardMap.add(new JPanel());
		cardMap.add(new JPanel());
		cardMap.add(new JPanel());
		
		Color [] cc = {
				Color.pink, Color.YELLOW, Color.cyan,
				Color.ORANGE, Color.LIGHT_GRAY
		};
		
		
		
		add(qqPP,"North");
		
		
		cardPP.setLayout(card);
		
		
		add(cardPP,"Center");
		
		
		
		qqPP.setLayout(new FlowLayout(FlowLayout.RIGHT,20,20));
		
		ArrayList<JButton> btns = new ArrayList<>();
		
		for (int i = 0; i < cardMap.size(); i++) {
			btns.add(new JButton(i+1+""));
			qqPP.add(btns.get(i));
			cardMap.get(i).setBackground(cc[i]);
			
			cardPP.add(cardMap.get(i),i+"");
			btns.get(i).addActionListener(new BtnAction(i));
		}
		
		card.show(cardPP, "0");
		
		
		
		setVisible(true);
		setResizable(false);
		addWindowListener(new FrameClose2());
	}
	
	
	void qqinit()
	{
		
	}
	
	class SingleQQ
	{
		JPanel nowPP;
		String qq, ans;
		int type;
		JTextField ju  = new JTextField();
		
		
		ArrayList<String> arr = new ArrayList<>();
		public SingleQQ(JPanel nowPP, String qq, String ans) {
			// TODO Auto-generated constructor stub
			this.nowPP = nowPP;
			this.qq = qq;
			this.ans = ans;
			type = 2;
		}
		
		public SingleQQ(JPanel nowPP, String qq, int ans, String ans1, String ans2, String ans3, String ans4) {
			// TODO Auto-generated constructor stub
			this(nowPP,qq, ans+"");
			arr.add(ans1);
			arr.add(ans2);
			arr.add(ans3);
			arr.add(ans4);
			type = 5;
		}
		
		
		void paint()
		{
			
			nowPP.setLayout(new GridLayout(type,1));
			nowPP.add(new JLabel(qq));
			
			if(type ==2)
			{
				//nowPP.add();
			}else{
				for (String str : arr)
				{
					
					
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Exam_01();
	}

}
