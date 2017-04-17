package swing;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;

class FrameClose implements WindowListener					// 이벤트 리스너 (인터페이스)
{

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("닫히는 중");
		
		e.getWindow().dispose();						//윈도우를 실제로 닫는다.
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("닫힘");
		
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
		System.out.println("닫히는 중222");
		
		e.getWindow().dispose();						//윈도우를 실제로 닫는다.
	}
	
	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("닫힘");
		
	}
}

public class FrameCloseMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFrame jf = new JFrame();							// jf=> 이벤트 소스
		jf.setBounds(0,0,300,300);				
		//jf.addWindowListener(new FrameClose());			// jf.addWindowListener => 이벤트리스너	
															// new FrameClose() => 이벤트 핸들러
		jf.addWindowListener(new FrameClose2());
		jf.setVisible(true);
		

	}
}
