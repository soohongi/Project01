package swing;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.text.StyledEditorKit.ForegroundAction;

public class KeyEventMain extends JFrame{

	class KeyKeyListen extends KeyAdapter
	{
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			//System.out.println(KeyEvent.VK_W);
			//System.out.println(e.getKeyCode());
			
			switch(e.getKeyCode())
			{
				case KeyEvent.VK_S:
					sp*=2;
					if(sp>20) sp = 20;
					break;
				case KeyEvent.VK_D:
					sp/=2;
					if(sp==0) sp = 1;
					break;
				case KeyEvent.VK_UP:
					System.out.println("^");
					y-=sp;
					
					if(y<0) y=0;
					break;
				case KeyEvent.VK_DOWN:
					System.out.println("V");
					y+=sp;
					if(y>530) y=530;
					break;
				case KeyEvent.VK_LEFT:
					System.out.println("<");
					x-=sp;
					if(x<0) x=0;
					break;
				case KeyEvent.VK_RIGHT:
					System.out.println(">");
					x+=sp;
					if(x>550) x=550;
					break;
			}
	
			choo.setLocation(x, y);
		}
		
	}
	
	
	class EnermyMove extends Thread 
	{
		int x;
		int y;
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			for (int i = 0; i < 10000; i++) {
				this.x=((int)Math.random()*i);
				this.y=((int)Math.random()*i);
				//System.out.println(x+"        "+y);
			}
			//enermy.setLocation(x, y);
		}
	}

	JLabel choo = new JLabel("¡Ú");
	JLabel enermy = new JLabel("¤±");
	
	int sp = 5;
	int x=0, y=0;
	public KeyEventMain() {
		// TODO Auto-generated constructor stub
		setBounds(350, 300, 600, 600);
		setLayout(null);
		
		choo.setBounds(0, 0, 50, 50);
		add(choo);
		
		enermy.setBounds(200,200,80,80);
		add(enermy);

		setVisible(true);
		setResizable(false);
		addWindowListener(new FrameClose2());
		addKeyListener(new KeyKeyListen());
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		new KeyEventMain();
		
		
	}

}
