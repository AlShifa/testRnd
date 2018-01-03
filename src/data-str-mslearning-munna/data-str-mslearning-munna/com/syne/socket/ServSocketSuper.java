package com.syne.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ConcurrentHashMap;

public class ServSocketSuper {

	private static final ExecutorService exec = Executors.newFixedThreadPool(3);

	protected ServerSocket serverSocket = null;

	public ServSocketSuper() {
		try {
			serverSocket = new ServerSocket(4321);
			System.out.println(serverSocket);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	void listenHandler(Socket clientSocket,	ConcurrentHashMap<Socket, String> hmap) throws Exception {
		try {
			String message = "";
			Future<String> futmessage = null;
			Callable call = new ServTask(clientSocket);
			futmessage = exec.submit(call);			
			hmap.put(clientSocket, futmessage.get());
			System.out.println(futmessage.get());
			//writeResponseHandler(clientSocket, hmap);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception(e);
		}
	}// end listener

	void writeResponseHandler(Socket clientSocket,
			ConcurrentHashMap<Socket, String> hashMap) throws Exception {
		String message = "";
		Future<String> futmessage = null;
		Runnable call = new ServTaskWriteToClients(clientSocket, hashMap);
		exec.execute(call);
	}
}
