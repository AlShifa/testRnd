package com.syne.execu;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

class SingleThreadWebServer {
	public static void main(String[] args) throws IOException {
	ServerSocket socket = new ServerSocket(80);
	//while (true) {
	Socket connection = socket.accept();
	System.out.println(connection);
	connection.close();
	connection=null;
	//handleRequest(connection);
	//}
	}
	}