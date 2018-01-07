package com.syne.socket2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket clientSocket = null;
		String inputLine, outputLine;
		try {
		    serverSocket = new ServerSocket(4444);
		    clientSocket = serverSocket.accept();
		    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
		    BufferedReader in = 
		        new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		 // initiate conversation with client
		    KnockKnockProtocol kkp = new KnockKnockProtocol();
		    outputLine = kkp.processInput(null);
		    out.println(outputLine);

		} 
		catch (IOException e) {
		    System.out.println("Could not listen on port: 4444");
		    System.exit(-1);
		}

		
		
	}

}
