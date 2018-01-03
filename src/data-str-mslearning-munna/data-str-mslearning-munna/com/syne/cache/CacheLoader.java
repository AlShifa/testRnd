package com.syne.cache;
import java.lang.ref.SoftReference;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class CacheLoader {

	protected static Map<Integer, SoftReference<Employee>> cacheMap = new HashMap<Integer, SoftReference<Employee>>();
	private static DAO dao = new DAO();
	static Connection  conn = null;
	static PreparedStatement pstmt=null;
	static {
		// loading data ........
		System.out.println("loading data...making db connection....");
		try {
			 conn = DAO.getConnection();
			 fetchAllRecords(conn);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	//fetch all records 
	static void fetchAllRecords(Connection conn) throws SQLException
	{
		// connect with database and fetch the records from db.
		String sql ="select empid,empname,empaddress from emp";
		pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next())
		{
			String empId= rs.getString("empid")==null?"0":rs.getString("empid");
			int empidInt = Integer.parseInt(empId);
			String empname= rs.getString("empname")==null?"":rs.getString("empname");
			String empaddress= rs.getString("empaddress")==null?"":rs.getString("empaddress");
			Employee emp = new Employee(empidInt, empname, empaddress); 
			cacheMap.put(empidInt, new SoftReference<Employee>(emp));
		}
	}
	//fetch emp records from id 
	static Employee fetchDBRecord(int empid) throws SQLException
	{
		System.out.println("fetching db data.....");
		// connect with database and fetch the records from db.
		String sql ="select empid,empname,empaddress from emp where empid=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, empid);
		ResultSet rs = pstmt.executeQuery();
		Employee emp = null;
		if(rs.next())
		{
			String empId= rs.getString("empid")==null?"0":rs.getString("empid");
			int empidInt = Integer.parseInt(empId);
			String empname= rs.getString("empname")==null?"":rs.getString("empname");
			String empaddress= rs.getString("empaddress")==null?"":rs.getString("empaddress");
			 emp = new Employee(empidInt, empname, empaddress); 
			cacheMap.put(empidInt, new SoftReference<Employee>(emp));
		}
		return emp;
	}	

}
