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
		
		FileChannel fcw = FileChannel.open(path, StandardOpenOption.READ);		// 버퍼를 반드시 필요로 한다.
		
		String data = " ";
		
		Charset charset = Charset.defaultCharset();								// 캐릭터마다 설정을 다르게 잡을 수 있다.
		ByteBuffer buf  = ByteBuffer.allocate(1024);							// 읽어들일때 공간 할당을 해 준다.
		
		int cnt = 0;
		while(true)
		{
			cnt = fcw.read(buf);
			
			if(cnt == -1)
				break;
			
			buf.flip();															// 처음의 위치로 간다. => 처음부터 읽어야하기 때문에
			data += charset.decode(buf).toString();								
			buf.clear();
			
			
		}
		

		//fcw.write(buf);
		
		System.out.println("데이터 : "+ data);
		
		fcw.close();
	}

}
