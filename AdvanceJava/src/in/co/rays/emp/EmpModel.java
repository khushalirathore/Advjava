package in.co.rays.emp;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.co.rays.util.JDBCDataSource;

public class EmpModel {
	
	public void add(Empbean bean )throws Exception  {
		
		Connection conn = JDBCDataSource.getConnection();
		
		PreparedStatement ps =  conn.prepareStatement("insert into emp values(?,?,?,?,?,?,?)");
		
		ps.setInt(1, bean.getId());
		ps.setString(2, bean.getFirst_Name());
		ps.setString(3,bean.getLast_name());
		ps.setDate(6, new java.sql.Date(bean.getBirth_day().getTime()));
		ps.setInt(5, bean.getSalary());
		ps.setInt(6, bean.getSuper_Id());
		ps.setInt(7, bean.getBranch_Id());
		
	int i =	ps.executeUpdate();
	
	System.out.println("data insertes = " + i );
		
		
	}

	
	public void delete(int id) throws Exception {
		
		Connection conn = JDBCDataSource.getConnection();
		
		PreparedStatement ps = conn.prepareStatement("delete  from emp where id = ?");
		
		ps.setInt(1, id);
		
		int i = ps.executeUpdate();
		
		System.out.println("Data Deleted" + i);
	}
	public void update(Empbean bean)throws Exception {
		
		Connection conn =  JDBCDataSource.getConnection();
		
		PreparedStatement ps = conn.prepareStatement("update emp set  fiest_name = ?, last_name = ?,  birth_dat = ?,salary  =?,super_id =?, branch_id=? where id = ?");
		ps.setString(1, bean.getFirst_Name());
		ps.setString(2, bean.getLast_name());
		ps.setDate(3,new java.sql.Date(bean.getBirth_day().getTime()));
		ps.setInt(4, bean.getSalary());
		ps.setInt(5, bean.getSuper_Id());
		ps.setInt(6, bean.getSuper_Id());
		ps.setInt(7, bean.getId());
		
		int i = ps.executeUpdate();
		
		System.out.println("data Updated =" + i );
		
	}
	 
	public Empbean FindByPk(int id) throws Exception{
		
		Connection conn = JDBCDataSource.getConnection();
		
		PreparedStatement ps = conn.prepareStatement("select * from emp where id =  ?");
		
	       ps.setInt(1, id);
			
           ResultSet rs = ps.executeQuery();
           
           Empbean bean = null;
           
           while (rs.next()) { 
				
           	bean = new Empbean();
           	
           	bean.setId(rs.getInt(1));
           	bean.setFirst_Name(rs.getString(2));
           	bean.setLast_name(rs.getString(3));
           	bean.setBirth_day(rs.getDate(4));
           	bean.setSalary(rs.getInt(5));
           	bean.setSuper_Id(rs.getInt(6));
           	bean.setBranch_Id(rs.getInt(7));
           	
		
	}
		return bean;
		
	}
	
	
	public List search(Empbean bean ) throws Exception {
		
		Connection conn = JDBCDataSource.getConnection();
		
	
		StringBuffer sql = new StringBuffer("select * from emp where 1=1");
		
		if (bean!=null) {
			
			if (bean.getFirst_Name()!=null && bean.getFirst_Name().length()>0) {
				sql.append(" and First_name like " + bean.getFirst_Name());
					
			}
			
			System.out.println(sql.toString());
			
	PreparedStatement ps = conn.prepareStatement(sql.toString());
	    ResultSet rs =	ps.executeQuery();
	    
	      List list = new ArrayList();
	      
	      bean.setId(rs.getInt(1));
	      
	    
			
		}
		
		
		
		return null;
		
	}
	
	
	
}
