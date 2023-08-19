package in.co.rays.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.co.rays.bean.UserBean;
import in.co.rays.util.JDBCDataSource;

public class UserModel {

	public Integer nexPk() throws Exception {

		int pk = 0;

//		Class.forName("com.mysql.cj.jdbc.Driver");
//		
//		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays","root","root");
		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement ps = conn.prepareStatement("select  max(id)  from user");

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {

			pk = rs.getInt(1);
		}
		return pk + 1;

	}

	public void add(UserBean bean) throws Exception {

		// Class.forName("com.mysql.cj.jdbc.Driver");
//Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays","root","root");

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement ps = conn.prepareStatement("insert into user values (?,?,?,?,?,?,?)");

		ps.setInt(1, nexPk());
		// ps.setInt(1, bean.getId());
		ps.setString(2, bean.getFirstName());
		ps.setString(3, bean.getLastName());
		ps.setString(4, bean.getLoginId());
		ps.setString(5, bean.getPassword());
		ps.setDate(6, new java.sql.Date(bean.getDob().getTime()));
		ps.setString(7, bean.getAddress());

		int i = ps.executeUpdate();

		System.out.println("data inserted =" + i);

	}

	public UserBean FindByPk(int id) throws Exception {
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays","root","root");

		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("select * from user where id = ?");

		ps.setInt(1, id);

		ResultSet rs = ps.executeQuery();

		UserBean bean = null;

		while (rs.next()) {

			bean = new UserBean();

			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLoginId(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setDob(rs.getDate(6));
			bean.setAddress(rs.getString(7));
		}

		return bean;

	}

	public void update(UserBean bean) throws Exception {

//		Class.forName("com.mysql.cj.jdbc.Driver");
//		
//		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays","root","root");

		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement(
				"update user set First_name= ?,  Last_name=?,Login_Id =?, Password =?, DOB=?,Address = ?  where id = ?");

		ps.setString(1, bean.getFirstName());
		ps.setString(2, bean.getLastName());
		ps.setString(3, bean.getLoginId());
		ps.setString(4, bean.getPassword());
		ps.setDate(5, new java.sql.Date(bean.getDob().getTime()));
		ps.setString(6, bean.getAddress());
		ps.setInt(7, bean.getId());

		int i = ps.executeUpdate();

		System.out.println("data update =" + i);
	}

	public List search(UserBean bean, int pageNo, int pageSize) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

		// Connection conn = JDBCDataSource.getConnection();

		// PreparedStatement ps = conn.prepareStatement("select * from user where 1=1");
		StringBuffer sql = new StringBuffer("select * from user where 1=1 ");

		if (bean != null) {

			if (bean.getDob() != null && bean.getDob().getTime() > 0) {

				sql.append(" and Dob like '" + new java.sql.Date(bean.getDob().getTime()) + "%'");

			}
			if (bean.getId() != 0 && bean.getId() > 0) {

				sql.append(" and id = " + bean.getId());
			}
			if (bean.getFirstName() != null && bean.getFirstName().length() > 0) {
				sql.append(" and First_Name  like '" + bean.getFirstName() + "%'");

			}
			if (bean.getLastName() != null && bean.getLastName().length() > 0) {
				sql.append(" and Last_Name like '" + bean.getLastName() + "%'");

			}

			if (pageSize > 0) {

				pageNo = (pageNo - 1) * pageSize;

				sql.append(" limit " + pageNo + " , " + pageSize);
			}
		}

		System.out.println(sql.toString());

		PreparedStatement ps = conn.prepareStatement(sql.toString());

		ResultSet rs = ps.executeQuery();

		List list = new ArrayList();

		while (rs.next()) {

			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLoginId(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setDob(rs.getDate(6));
			bean.setAddress(rs.getString(7));

			list.add(bean);

		}
		return list;

	}

	public UserBean findByLogin(String loginId) throws Exception {

//		Class.forName("com.mysql.cj.jdbc.Driver");
//		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays","root","root");

		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("select * from user where Login_Id = ?");

		ps.setString(1, loginId);

		ResultSet rs = ps.executeQuery();

		UserBean bean = null;

		while (rs.next()) {

			bean = new UserBean();

			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLoginId(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setDob(rs.getDate(6));
			bean.setAddress(rs.getString(7));
		}

		return bean;

	}

	public UserBean authenticate(String loginId, String password) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

		// Connection conn = JDBCDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("select * from user where Login_Id= ? and Password =?");

		ps.setString(1, loginId);
		ps.setString(2, password);

		ResultSet rs = ps.executeQuery();

		UserBean bean = null;

		while (rs.next()) {

			bean = new UserBean();

			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLoginId(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setDob(rs.getDate(6));
			bean.setAddress(rs.getString(7));
		}

		return bean;

	}
}
