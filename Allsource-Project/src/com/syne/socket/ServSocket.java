package com.syne.socket;

import java.net.*;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.io.*;



public class ServSocket extends ServSocketSuper {

	ConcurrentHashMap<Socket, String> connhashMap = new ConcurrentHashMap<Socket, String>();

	void service() {

		Socket clientSocket = null;
		try {
			while (true) {

				clientSocket = null;
				clientSocket = serverSocket.accept();				
				listenHandler(clientSocket, connhashMap);
				//clientSocket.close();
				//writeResponseHandler(clientSocket, connhashMap);				
			}
		} catch (Exception e) {
			System.err.println("Accept failed.");
			//serverSocket.close();
			System.exit(1);
		}

	}	
	public static void main(String[] args) throws Exception {
		ServSocket ss = new ServSocket();
		ss.service();
	}

}