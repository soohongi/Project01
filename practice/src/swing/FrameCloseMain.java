package swing;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;

class FrameClose implements WindowListener					// �̺�Ʈ ������ (�������̽�)
{

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("������ ��");
		
		e.getWindow().dispose();						//�����츦 ������ �ݴ´�.
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("����");
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}



class FrameClose2 extends WindowAdapter
{
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("������ ��222");
		
		e.getWindow().dispose();						//�����츦 ������ �ݴ´�.
	}
	
	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("����");
		
	}
}

public class FrameCloseMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFrame jf = new JFrame();							// jf=> �̺�Ʈ �ҽ�
		jf.setBounds(0,0,300,300);				
		//jf.addWindowListener(new FrameClose());			// jf.addWindowListener => �̺�Ʈ������	
															// new FrameClose() => �̺�Ʈ �ڵ鷯
		jf.addWindowListener(new FrameClose2());
		jf.setVisible(true);
		

	}
}
