package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.regex.Pattern;

//������ ������ ������ ���� �������� ���� ������ �����Ͻÿ�
/// ���� �������� �˻��ϼ���
/// ���� ���ϸ��� ��� �ߺ� ó�� �ϼ���
//�̹��� : bmp, jpg, gif, png 
//���� : txt, doc, hwp, ppt, xls, pptx, xlsx, docx
//��Ÿ : ���� �з� �̿�
//Ȯ������ ��ҹ��� �������� ����

public class io_001 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		File ff = new File("all");
		File[] files = ff.listFiles();
		
		
		//System.out.println(ff.exists());
		
		for (File fs : files) {
			  if ( !new File("all/IMG").exists() )
			  {
                  new File("all/IMG").mkdir();
                  //System.out.println("1");
			  }
			  if ( !new File("all/TXT").exists() )
			  {
				  new File("all/TXT").mkdir();
				  //System.out.println("2");
			  }
			  if ( !new File("all/ETC").exists() )
			  {
				  new File("all/ETC").mkdir();
				  //System.out.println("3");
			  }
  
		}
		
		for (File fs : files) {
			if (Pattern.matches(".*\\.(jpg|png|gif|bmp)", fs.getName().toLowerCase())) {
				try {
					FileInputStream fis = 
							new FileInputStream(fs.getPath());
					
					FileOutputStream fos = 
							new FileOutputStream("all/IMG/" + fs.getName());
					
					byte [] buf = new byte[1024];
					
					int data;
					
					while(fis.available()>0)
					{
						data = fis.read(buf);
						
						fos.write(buf, 0, data);
						
						System.out.println(Arrays.toString(buf));
					}
					
					fos.close();
					fis.close();
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (Pattern.matches(".*\\.(txt|doc|hwp|ppt|xls|pptx|xlsx|docx)", fs.getName().toLowerCase())) {
				try {
					FileInputStream fis = 
							new FileInputStream(fs.getPath());
					
					FileOutputStream fos = 
							new FileOutputStream("all/TXT/" + fs.getName());
					
					byte [] buf = new byte[1024];
					
					int data;
					
					while(fis.available()>0)
					{
						data = fis.read(buf);
						
						fos.write(buf, 0, data);
						
						System.out.println(Arrays.toString(buf));
					}
					
					fos.close();
					fis.close();
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
					 /*if (Pattern.matches(".*\\.(jpg|png|gif|bmp)",fs.getName().toLowerCase()))*/					 
				try {
					FileInputStream fis = 
							new FileInputStream(fs.getPath());
					
					FileOutputStream fos = 
							new FileOutputStream("all/ETC/" + fs.getName());
					
					byte [] buf = new byte[1024];
					
					int data;
					
					while(fis.available()>0)
					{
						data = fis.read(buf);
						
						fos.write(buf, 0, data);
						
						System.out.println(Arrays.toString(buf));
					}
					
					fos.close();
					fis.close();
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
