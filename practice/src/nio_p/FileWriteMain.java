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
		
		FileChannel fcw = FileChannel.open(path, StandardOpenOption.CREATE, StandardOpenOption.WRITE);	// 채널은 버퍼를 반드시 필요로 한다.
		
		String data = " 케로케로케로";
		
		Charset charset = Charset.defaultCharset();								// 캐릭터마다 설정을 다르게 잡을 수 있다.
		ByteBuffer buf  = charset.encode(data);
		

		fcw.write(buf);
		
		System.out.println("데이터 량 : "+ fcw.write(buf));
		
		fcw.close();
	}

}
