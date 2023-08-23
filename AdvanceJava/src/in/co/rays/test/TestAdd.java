package in.co.rays.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestAdd {
	
	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays","root","root");
	
		Statement stmt = conn.createStatement();
		int i = stmt.executeUpdate("insert into marksheet values(100,'abc',201,52,33,45)");
		
		
		System.out.println("Data insert"+i);
		
		
	}

}
