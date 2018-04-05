import java.io.OutputStream;
import java.net.Socket;

public class Client {

	public static void main(String[] args) throws Exception {

		Socket s = new Socket("127.0.0.1", 7001);
		OutputStream os = s.getOutputStream();
		os.write("Pinging".getBytes());

	}

}
