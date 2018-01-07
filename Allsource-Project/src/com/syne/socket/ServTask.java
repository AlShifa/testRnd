package com.syne.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.concurrent.Callable;

public class ServTask implements Callable<String> {// Runnable{//

	Socket clientSocket = null;

	public ServTask(Socket clientSocket) {
		this.clientSocket = clientSocket;
	}

	public String call()throws Exception
	// public void run()
	{
		String temp = "";
		String inputLine = "";
		InputStreamReader ips;
		try {			
			ips = new InputStreamReader(clientSocket.getInputStream());
			BufferedReader in = new BufferedReader(ips);
			while ((inputLine = in.readLine()) != null) {
				temp = temp + inputLine;
			}
			System.out.println("read temp 22222222222"+temp);
			// in.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception();
		}
		return temp;

	}

}
