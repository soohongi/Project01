package swing;

import java.awt.Color;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class ImageOpen_01 extends JFrame{

	public ImageOpen_01() {
		// TODO Auto-generated constructor stub

		JFrame jf1 = new JFrame();
		JLabel top_lb = new JLabel();
		JButton jb1 = new JButton("FileDialog");
		setLayout(null);

		add(top_lb);
		add(jb1);

		jb1.addActionListener(new ActionListener() {
			int imgw = 0;
			int imgh = 0;
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				String str="";
				
				FileDialog fd = new FileDialog(jf1, "파일열기", FileDialog.LOAD);
					fd.setLocation(10, 100);
					fd.setDirectory("C:\\Users\\DELL\\Desktop");
					fd.setVisible(true);
					
					str+=fd.getDirectory();
					str+=fd.getFile();
				
				if (!Pattern.matches(".*\\.(jpg|png|gif|bmp)", str.toLowerCase())) 
				{
					System.out.println("실패!!");
				}
				else
				{
					ImageIcon icon = new ImageIcon(str);
					top_lb.setIcon(icon);
					
					imgw = icon.getIconWidth();
					imgh = icon.getIconHeight();
	
					top_lb.setBounds(18, 20, imgw, imgh);
					jb1.setBounds(100, 700, 600, 50);
					
					add(top_lb);
	
					setBounds(50, 50, imgw+50, imgh+130);
					jb1.setBounds(20, imgh+30, imgw, 50);				
				}				
			}
		});

		top_lb.setVisible(true);
		jb1.setVisible(true);
		
		
		jb1.setBounds(100, 700, 600, 50);
		setBounds(200, 200, 800, 800);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 new ImageOpen_01();
	}
}
