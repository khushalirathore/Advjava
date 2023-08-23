package in.co.rays.util;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public final class JDBCDataSource {
	
	//JDBC Database source object 
	ResourceBundle rb = ResourceBundle.getBundle("in.co.rays.bundle.app");
	private static JDBCDataSource  jds = null;
	//C3P0 database connection pool
	private ComboPooledDataSource ds =null;
	
	//make  defoult consutorprivate 
	private JDBCDataSource() {
		
		try {
			//creat data source
			ds = new ComboPooledDataSource();
			
			//set ds properties 
			ds.setDriverClass(rb.getString("Driver"));
			ds.setJdbcUrl(rb.getString("url"));
			ds.setUser(rb.getString("user"));
			ds.setPassword(rb.getString("password"));
			ds.setInitialPoolSize(5);
			ds.setAcquireIncrement(5);
			ds.setMaxPoolSize(50);
				
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		
	}
	//get singletion class instance 
	
	public static JDBCDataSource getInstance() {
		
		if (jds==null) {
			jds = new JDBCDataSource();
			
		}
		return jds;
		
	}
	//gets connection from dcp
	public static Connection getConnection() {
		try {
			return getInstance().ds.getConnection();
			
		} catch (SQLException e) {
			
			return null;
			
		}
	}
	
	//  close connnection 
	public static  void CloseConnection(Connection conn ,  Statement  stmt, ResultSet rs) {
		
		try {
			if (rs!=null) {
				rs.close();
			}
			if (rs!=null) {
				stmt.close();
			}
			if (rs!= null) {
				conn.close();
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
	//close connectionn 
	public static void CloseConnection(Connection conn , Statement stmt) {
		CloseConnection(conn, stmt , null);
		
	}
	
	
	
	}
	


	