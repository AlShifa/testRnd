package com.syne.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conn {
	
	public static void main(String[] args)  {
		try{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/test";
		Connection con = DriverManager.getConnection(url,"root","root");
		System.out.println(con);
		}catch(Exception ex)
		{
			ex.printStackTrace();
			
		}
		
		
	}

}
