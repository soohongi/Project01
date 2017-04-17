package nio_p;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Channel_File_Copy {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Path pathread  = Paths.get("fff/nio.txt");
		
		FileChannel fcread = FileChannel.open(pathread, StandardOpenOption.READ);
		
		String data="";
		
		Charset ch = Charset.defaultCharset();
		ByteBuffer r_buf = ByteBuffer.allocate(1024);
		
		int cnt = 0;
		while(true)
		{
			cnt = fcread.read(r_buf);
			if(cnt == -1)
				break;
			
			r_buf.flip();													
			data += ch.decode(r_buf).toString();								
			r_buf.clear();
		}
		
		fcread.close();
		
		Path pathwrite  = Paths.get("fff/nio001.txt");
		
		FileChannel fcw = FileChannel.open(pathwrite, StandardOpenOption.CREATE, StandardOpenOption.WRITE);	// ���۸� �ݵ�� �ʿ�� �Ѵ�.
		
		String w_data = data;
		
		Charset charset = Charset.defaultCharset();								// ĳ���͸��� ������ �ٸ��� ���� �� �ִ�.
		ByteBuffer w_buf  = charset.encode(w_data);
	
		fcw.write(w_buf);
		
		System.out.println("������ �� : "+ fcw.write(w_buf));
		
		fcw.close();
	}

}
