package swing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Hw_0324 extends JFrame implements MouseMotionListener{
	
	int color;
	class BtnAction_01 implements ActionListener
	{
		int num;

		public BtnAction_01(int num) {
			super();
			this.num = num;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			color = num;
		}
	}
	
	public Hw_0324() {
		// TODO Auto-generated constructor stub
		//System.out.println("생성자");
		JLabel jl = new JLabel();
		
		
		setBounds(600, 0, 1200, 600);
		setVisible(true);
		setLayout(null);
		
		icons = new JPanel();
		icons.setLayout(new GridLayout(1,cc.length));
		icons.setBounds(0, 480, 600, 100);
		
		add(icons);
		setResizable(false);
		
		img = createImage(600, 500);///---2
		gimg = img.getGraphics();   ///---3
		
		addWindowListener(new FrameClose2());
		addMouseMotionListener(this);
	}
	
	int x =0, y=0;
	boolean	chk = false,imgchk = false;
	String str="*";
	
	Image img = null;
	Graphics gimg = null;
	JPanel icons;
	
	Color [] cc = {
		Color.red, Color.orange, Color.YELLOW,
		Color.GREEN, Color.BLUE, Color.MAGENTA,
		Color.PINK, Color.gray, Color.WHITE, Color.black
	};
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		//super.paint(g); //배경다시그리기
		System.out.println("paint");
		
		init(g);
		g.drawImage(img, 0, 0, this);
		g.drawString("마우스를 움직여 보세요", 50,50);
	
	}
	
	void init(Graphics g)
	{
		if(!chk)
		{
			chk = true;
			g.setColor(Color.YELLOW);
			g.fillRect(0, 0, 600, 600);
		
			for (int i = 0; i < cc.length; i++) {
				JButton btn = new JButton();
				btn.setBackground(cc[i]);
				icons.add(btn);
				btn.addActionListener(new BtnAction_01(i));
			}
		}
		
		if(!imgchk && img!=null)
		{
			imgchk=true;
			gimg.setColor(Color.white);
			gimg.fillRect(0, 0, 600, 500);
			gimg.setColor(Color.BLACK);
		}
		
	}

	@Override
	public void update(Graphics g) {
		// TODO Auto-generated method stub
		//super.update(g);
		paint(g);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Hw_0324();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
		
		
		if(e.getModifiersEx()==MouseEvent.BUTTON1_DOWN_MASK)
		{
			gimg.setColor(cc[color]);
			//gimg.drawString(str, x,y);
			gimg.drawLine(x, y, e.getX(), e.getY());
			
		}else if(e.getModifiersEx()==MouseEvent.BUTTON3_DOWN_MASK)
		{
			gimg.setColor(Color.white);
			gimg.fillOval(x-50, y-50, 100,100);
		}

		repaint();
		x = e.getX();
		y = e.getY();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		x = e.getX();
		y = e.getY();
	}

}
