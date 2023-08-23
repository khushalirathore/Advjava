package in.co.rays.emp;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import in.co.rays.test.TestDelete;

public class TestEmp {
	
	public static void main(String[] args) throws Exception {
		
		testAdd();
		//TestDelete();
		//testUpdate();
		
	}

	private static void testUpdate() throws Exception {
		EmpModel model = new EmpModel();
				Empbean bean = model.FindByPk(1); 
				
				if (bean!= null) {
					System.out.println("User exist and updated ");
				}else {
					System.out.println("user nor exist");
				}
		
	}

	private static void TestDelete() throws Exception {
		
		EmpModel m = new EmpModel();
		
		m.delete(2);
		
		
	}

	private static void testAdd() throws Exception {
		
		
		
		String d = "2002-11-01";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date utilDate = sdf.parse(d);
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

		
		Empbean bean = new Empbean();
		
		bean.setId(2);
		bean.setFirst_Name("khushali");
		bean.setLast_name("rathore");
		bean.setBirth_day(sqlDate);
		bean.setSalary(10000);
		bean.setSuper_Id(11);
		bean.setBranch_Id(111);
		
		EmpModel model = new EmpModel();
		
		model.add(bean);

		
	}
	
	

	
	
	
}
