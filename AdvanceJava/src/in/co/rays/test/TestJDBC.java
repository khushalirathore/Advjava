package in.co.rays.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import in.co.rays.util.JDBCDataSource;

public class TestJDBC {
	
	
	public static void main(String[] args) throws Exception {
		
		
	//	for (int i = 0; i <=50; i++) {

	//		System.out.println("connection = "+ i);
		
		
		testGet();
		
		//}
	}

	private static void testGet()throws Exception {
		
		Connection conn = JDBCDataSource.getConnection();
		
		PreparedStatement ps = conn.prepareStatement ("select * from marksheet where id =2");
		
	    ResultSet rs   = ps.executeQuery();
	    
	    while (rs.next()) {
	    	
	    	System.out.println(rs.getInt(1));
	    	System.out.println(rs.getString(2));
	    	System.out.println(rs.getInt(3));
	    	System.out.println(rs.getInt(4));
	    	System.out.println(rs.getInt(5));
	    	System.out.println(rs.getInt(6));
	    	

	    	
	    }
		
		
		
		
	}

}
