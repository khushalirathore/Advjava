package in.co.rays.emp;


	import java.sql.Date;

	public class Empbean {
		
		private int Id;
		private String First_Name ;
		private String Last_name ;
		private Date Birth_day;
		private int Salary;
		private int Super_Id;
		private int Branch_Id;
		public int getId() {
			return Id;
		}
		public void setId(int id) {
			Id = id;
		}
		public String getFirst_Name() {
			return First_Name;
		}
		public void setFirst_Name(String first_Name) {
			First_Name = first_Name;
		}
		public String getLast_name() {
			return Last_name;
		}
		public void setLast_name(String last_name) {
			Last_name = last_name;
		}
		public Date getBirth_day() {
			return Birth_day;
		}
		public void setBirth_day(Date birth_day) {
			Birth_day = birth_day;
		}
		public int getSalary() {
			return Salary;
		}
		public void setSalary(int salary) {
			Salary = salary;
		}
		public int getSuper_Id() {
			return Super_Id;
		}
		public void setSuper_Id(int super_Id) {
			Super_Id = super_Id;
		}
		public int getBranch_Id() {
			return Branch_Id;
		}
		public void setBranch_Id(int branch_Id) {
			Branch_Id = branch_Id;
		}
	}
		
		
		
		
		