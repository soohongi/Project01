package swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.plaf.BorderUIResource;

public class Hw_0322 extends JFrame{
	
	public Hw_0322() {
		// TODO Auto-generated constructor stub
		
		JPanel total = new JPanel();
		JPanel top = new JPanel();
		JPanel center = new JPanel();
		
		//total.setLayout(new GridLayout(2,1));
		
		top.setBackground(Color.YELLOW);
		//top.setBounds(0, 0, 300, 300);
		//center.setBackground(Color.blue);
		//center.setBounds(0, 100, 300, 300);
		
		int n=10;
		int m=10;
		center.setLayout(new GridLayout(n, m, 0, 0));

		for (int i = 0; i < n*m; i++) {
			center.add(new JButton());
		}

		
		
		add(center);
		add(top, BorderLayout.NORTH);
		
		top.add(total);
		//total.add(center);
		
		setBounds(200,200,300,300);
		setVisible(true);
		//addWindowListener(new FrameClose2());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Hw_0322();

	}
}
