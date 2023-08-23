package in.co.rays.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestSelect {
	
	public static void main(String[] args) throws Exception {
		Connection conn = null;
try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays","root","root");
	
	conn.setAutoCommit(false);
	
	Statement stmt = conn.createStatement();
	
int i = stmt.executeUpdate("insert into marksheet values (106,'asd',201,25,78,26)");
 i = stmt.executeUpdate("insert into marksheet values (107,'asd',201,25,78,26)");
 i = stmt.executeUpdate("insert into marksheet values (108,'asd',201,25,78,26)");
 i = stmt.executeUpdate("insert into marksheet values (108,'asd',201,25,78,26)");

//ResultSet rs = stmt.executeQuery ("select * from marksheet where id = 1");

//while (rs.next()) {
	//System.out.println(rs.getInt(1));
//	System.out.println(rs.getString(2));
	//System.out.println(rs.getInt(3));
//	System.out.println(rs.getInt(4));
	//System.out.println(rs.getInt(5));
	//System.out.println(rs.getInt(6));
	
	conn.commit();
	
} catch(Exception e) {
	
	System.out.println("data inserted = " + e);
	
	conn.rollback();
	
}	
}	
	}