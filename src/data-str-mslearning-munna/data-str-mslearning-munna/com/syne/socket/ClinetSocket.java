package com.syne.socket;

import java.io.*;
import java.net.*;

public class ClinetSocket extends  ClinetSocketSuper {//implements Runnable {
	
	
	void client() throws Exception
	{	
		
		//Thread th =  new Thread(this,"client");
		//th.start();
		System.out.println(Thread.currentThread().getName());
		sendData();
		String strgetData = getData();		
		System.out.println(strgetData);
		
	}
	
	public static void main(String[] args) throws IOException {
		
		ClinetSocket clientSocket = new ClinetSocket();
		try {			
			clientSocket.client();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}