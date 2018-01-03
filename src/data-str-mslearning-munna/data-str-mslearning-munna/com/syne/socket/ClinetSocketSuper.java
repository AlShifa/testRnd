package com.syne.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClinetSocketSuper {

	protected Socket clinetSocket = null;
	PrintWriter out = null;
	BufferedReader in = null;
	BufferedReader stdIn = null;
	String test = null;

	public ClinetSocketSuper() {

		InetAddress utopia;
		try {
			utopia = InetAddress.getByName("172.20.222.221");
			clinetSocket = new Socket(utopia, 4321);
		} catch (UnknownHostException e) {			
			e.printStackTrace();
			System.exit(1);
		} catch (IOException e) {			 
			e.printStackTrace();
			System.exit(1);
		}

		// Out may be used to write to server from the client

		
	}

	public String getData() {
		test = "";
		new Thread() {
			public void run() {
				try {
					String fromServer = "";
					String temp = "";
					in = new BufferedReader(new InputStreamReader(clinetSocket
							.getInputStream()));
					while ((fromServer = in.readLine()) != null) {
						if (fromServer.equals("Bye"))
							break;
						temp = fromServer + temp;
					}
					test = temp;
					System.out.println("clientSocket" + temp);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					try {
						in.close();
						// stdIn.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

			}
		}.start();

		return test;
	}

	public void sendData() {
		
		new Thread(){ public void run(){ try {
			stdIn = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(clinetSocket.getOutputStream(), true);
			String data = stdIn.readLine();
			System.out.println(data);
			if (data != null)
				out.println("manazir@" + data);
			// out.close();
			// out.println("manazir@ :" +
			// stdIn.readLine()==null?"":stdIn.readLine());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// out.close();
		}      }}.start();
		
		
		

	}

}
