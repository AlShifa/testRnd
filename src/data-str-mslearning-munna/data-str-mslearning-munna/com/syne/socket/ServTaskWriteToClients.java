package com.syne.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ServTaskWriteToClients implements Runnable {
	
	Socket clientSocket = null;	
	ConcurrentHashMap   hashMap = null;
	
	public ServTaskWriteToClients(Socket clientSocket , ConcurrentHashMap<Socket,String> hashMap2) {	
		this.clientSocket = clientSocket;
		this.hashMap = hashMap2;		
	}
	//public String call()
	public void run() 
	{
		String temp = "";
		Set sethashMap = hashMap.entrySet();
		System.out.println(hashMap);
		Iterator<Set> setIterat = sethashMap.iterator();
		while (setIterat.hasNext()) {			
			Map.Entry mapEntry = (Map.Entry) setIterat.next();
			Socket mapkey = (Socket) mapEntry.getKey();						
			if (clientSocket != null && !mapkey.equals(clientSocket)) {
				String mapValue = (String) mapEntry.getValue();	
				System.out.println("Write Data from client "+clientSocket+": to :"+mapkey + "\n values " +mapValue );
				PrintWriter out;
				try {
					out = new PrintWriter(mapkey.getOutputStream(), true);
					out.println("Hey! . Who are you?");
					out.println(mapValue);
					//out.close();
				} catch (IOException e) {
					e.printStackTrace();
					//throw new Exception(e);
				}

			}
			
		}
		
		
	}

}
