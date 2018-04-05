import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;


public class NonBlockingIO {
	
	public static void main(String[] args) throws Exception {
		
		ServerSocketChannel ssc = ServerSocketChannel.open();
		ssc.configureBlocking(false);
		ssc.bind(new InetSocketAddress(7001));
		Selector selector = Selector.open();
		selector.select();
		
		ssc.register(selector, SelectionKey.OP_CONNECT);
		
		
		
		ssc.accept();
		
		
		
	}

}
