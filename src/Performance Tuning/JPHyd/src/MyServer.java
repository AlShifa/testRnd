import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class MyServer {
	
	public static void main(String[] args) throws IOException {
		
		ServerSocket ss = new ServerSocket(7001);
		System.out.println("Server started...");
		Socket s = ss.accept();
		System.out.println("After accept");
		InputStream in = s.getInputStream();
		byte[] bytes = new byte[64];
		in.read(bytes);
		System.out.println(new String(bytes));
		
		
		
		
	}

}
