package nio_p;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import javax.xml.stream.events.Characters;

public class FileWriteMain {

	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Path path  = Paths.get("fff/nio.txt");
		
		FileChannel fcw = FileChannel.open(path, StandardOpenOption.CREATE, StandardOpenOption.WRITE);	// ä���� ���۸� �ݵ�� �ʿ�� �Ѵ�.
		
		String data = " �ɷ��ɷ��ɷ�";
		
		Charset charset = Charset.defaultCharset();								// ĳ���͸��� ������ �ٸ��� ���� �� �ִ�.
		ByteBuffer buf  = charset.encode(data);
		

		fcw.write(buf);
		
		System.out.println("������ �� : "+ fcw.write(buf));
		
		fcw.close();
	}

}
