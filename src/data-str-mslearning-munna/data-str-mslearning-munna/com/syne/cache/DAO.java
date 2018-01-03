package com.syne.cache;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
	private static Connection conn;
	
	static 
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","mysql");
			System.out.println(conn);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException {		
		
	}
	public static Connection getConnection() throws SQLException
	{	
		if(conn==null)
		{
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","mysql");
			return conn;
		}
		else
		{
			return conn;
		}	
		
	}

}
