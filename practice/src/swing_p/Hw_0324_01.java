package swing_p;

//gg에   그리고 g에  붙인다

import java.awt.BorderLayout;

import java.awt.Color;

import java.awt.Graphics;

import java.awt.Image;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import java.awt.event.MouseEvent;

import java.awt.event.MouseListener;

import java.awt.event.MouseMotionListener;

import javax.swing.JButton;

import javax.swing.JFrame;

import javax.swing.JLabel;

import javax.swing.JPanel;

import javax.swing.border.Border;

public class Hw_0324_01 extends JFrame {

	int currCC;
	int ab;
	int ab1;
	Graphics gg = null;

	Color[] cc = {
			Color.red,
			new Color(255, 187, 0),
			new Color(255, 255, 0),
			new Color(0, 255, 0),
			new Color(0, 0, 255),
			new Color(5, 0, 153),
			new Color(95, 0, 255),
			new Color(255, 255, 255),
			new Color(0, 0, 0)
	};

	String[] aa = { "기본 ", "선 굵기 10", "선 굵기 20", "선 굵기 30", "직선", "선 별", "펜", "원", "네모" };
	int[] x1 = { 0, 10, 30, 40 };
	int[] y1 = { 0, 10, 30, 40 };

	class WorkArea extends JPanel implements MouseMotionListener, MouseListener
	{

		int x = 0, y = 0, mpx = 0, mpy = 0, mrx = 0, mry = 0;
		int getX = 0, getY = 0;
		Image img = null;

		public WorkArea() {
			// TODO Auto-generated constructor stub

			addMouseMotionListener(this);
			addMouseListener(this);
		}

		@Override

		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			if (e.getModifiersEx() == MouseEvent.BUTTON1_DOWN_MASK)
			{		
				if (ab == 0) {
					gg.setColor(cc[currCC]);
					// gg.drawString("*", x, y);
					gg.drawLine(x, y, e.getX(), e.getY());
				}

				else if (ab <= 3) {
					gg.setColor(cc[currCC]);
					gg.fillOval(x - ab - 10, y - ab - 10, x1[ab], y1[ab]);
					System.out.println(ab);
				}
				else if (ab == 5) {
					gg.setColor(cc[currCC]);
					gg.drawPolygon(
							new int[] { x, x - 5, x + 15, x - 25, x - 45, x - 60, x - 100, x - 80, x - 90, x - 45 },
							new int[] { y, y - 30, y - 60, y - 60, y - 90, y - 60, y - 60, y - 30, y, y - 20 }, 10);
				}

				else if (ab == 6) {
					gg.setColor(cc[currCC]);
					gg.drawLine(x, y, x - 5, y - 5);
					gg.drawLine(x - 1, y - 1, x - 6, y - 6);
					gg.drawLine(x - 2, y - 2, x - 7, y - 7);
					gg.drawLine(x - 3, y - 3, x - 8, y - 8);
					gg.drawLine(x - 4, y - 4, x - 9, y - 9);
					gg.drawLine(x - 5, y - 5, x - 10, y - 10);
				}

			}
			else if (e.getModifiersEx() == MouseEvent.BUTTON3_DOWN_MASK)
			{
				gg.setColor(Color.white);
				gg.fillOval(e.getX() - 50, e.getY() - 50, 100, 100);
			}
			
			x = e.getX();
			y = e.getY();
			repaint();

		}

		@Override

		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub

			x = e.getX();
			y = e.getY();
			repaint();
		}

		@Override

		public void paint(Graphics g) {

			// TODO Auto-generated method stub
			if (img == null)
			{
				img = createImage(470, 400);
				gg = img.getGraphics();
				gg.setColor(Color.white);
				gg.fillRect(0, 0, 470, 400);
			}
			g.drawImage(img, 0, 0, this);
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
		}

		@Override

		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			mpx = e.getX();
			mpy = e.getY();
			repaint();
		}

		@Override

		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			mrx = e.getX();
			mry = e.getY();
			
			if (ab == 7) {
				gg.setColor(cc[currCC]);
				gg.drawOval(mpx, mpy, mrx - mpx, mry - mpy);
			}
			if (ab == 8) {
				gg.setColor(cc[currCC]);
				gg.drawRect(mpx, mpy, mrx - mpx, mry - mpy);
			}
			repaint();
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
		}
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
		}
	}
	
	class ColorActionListen implements ActionListener
	{
		int num;
		public ColorActionListen(int num) {
			super();
			this.num = num;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			currCC = num;
		}
	}

	class LineSize implements ActionListener
	{
		int num2;
		public LineSize(int num2) {
			// TODO Auto-generated constructor stub
			super();
			this.num2 = num2;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			ab = num2;
		}
	}

	public Hw_0324_01() {

		// TODO Auto-generated constructor stub

		currCC = cc.length - 1;

		ab = 0;

		// ab1= -1;

		setBounds(0, 0, 600, 500);
		setLayout(null);
		JPanel ccPan = new JPanel();
		
		ccPan.setLayout(null);
		ccPan.setBounds(0, 400, 600, 100);
		
		for (int i = 0; i < cc.length; i++) {
			
			JButton btn = new JButton();
			btn.setBounds(10 + 50 * i, 0, 50, 50);
			btn.setBackground(cc[i]);
			ccPan.add(btn);
			btn.addActionListener(new ColorActionListen(i));
		}

		ccPan.setBackground(Color.pink);
		add(ccPan);
		JPanel jPan = new JPanel();
		
		jPan.setLayout(null);
		jPan.setBounds(470, 0, 130, 400);
		jPan.setBackground(Color.yellow);
		add(jPan);
		
		for (int i = 0; i < aa.length; i++) {
			JButton jb = new JButton(aa[i]);
			jb.setBounds(5, 5 + 45 * i, 100, 30);
			jPan.add(jb);
			jb.addActionListener(new LineSize(i));
		}

		WorkArea wa = new WorkArea();
		wa.setBounds(0, 0, 600, 400);
		add(wa);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {

		// TODO Auto-generated method stub

		new Hw_0324_01();

	}

}