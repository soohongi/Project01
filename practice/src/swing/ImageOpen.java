package swing;

import java.awt.FileDialog;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.Buffer;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.*;


public class ImageOpen extends JFrame{
	
	public ImageOpen() {
		// TODO Auto-generated constructor stub
		String str="";

		JFrame f4 = new JFrame("FileDialog");
		f4.setBounds(500, 200, 10, 10);
		f4.setLayout(null);
		f4.setVisible(true);
		
		FileDialog fd = new FileDialog(f4, "파일열기", FileDialog.LOAD);
		fd.setLocation(2000, 100);
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
		JLabel jl  = new JLabel(icon);
		
		int imgw = icon.getIconWidth();
		int imgh = icon.getIconHeight();
		
		add(jl);
		
		
		System.out.println(imgw);
		System.out.println(imgh);
		
		setBounds(0, 0, imgw, imgh);
		setVisible(true);
		}
	}
	
	
	public void print(Graphics g)
	{
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ImageOpen();
	}
		
		

}
