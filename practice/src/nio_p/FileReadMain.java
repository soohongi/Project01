package nio_p;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import javax.xml.stream.events.Characters;

public class FileReadMain {

	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Path path  = Paths.get("fff/nio.txt");
		
		FileChannel fcw = FileChannel.open(path, StandardOpenOption.READ);		// ���۸� �ݵ�� �ʿ�� �Ѵ�.
		
		String data = " ";
		
		Charset charset = Charset.defaultCharset();								// ĳ���͸��� ������ �ٸ��� ���� �� �ִ�.
		ByteBuffer buf  = ByteBuffer.allocate(1024);							// �о���϶� ���� �Ҵ��� �� �ش�.
		
		int cnt = 0;
		while(true)
		{
			cnt = fcw.read(buf);
			
			if(cnt == -1)
				break;
			
			buf.flip();															// ó���� ��ġ�� ����. => ó������ �о���ϱ� ������
			data += charset.decode(buf).toString();								
			buf.clear();
			
			
		}
		

		//fcw.write(buf);
		
		System.out.println("������ : "+ data);
		
		fcw.close();
	}

}
