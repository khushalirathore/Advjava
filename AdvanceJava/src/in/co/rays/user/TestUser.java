package in.co.rays.user;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

public class TestUser {

	public static void main(String[] args) throws Exception {
		 testAdd();
		//testSearch();
		// testUpdate();

	}

	private static void testSearch() throws Exception {

		String dob = "2001-05-16";

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	
	UserBean bean = new UserBean();
		//bean.setDob(sdf.parse(dob));
		//bean.setId(3);
		// bean.setFirstName("khushh");
		// bean.setLastName("patidar");
		
		

		UserModel model = new UserModel();

		List list = model.search(bean,1,4);

		Iterator it = list.iterator();

		while (it.hasNext()) {

			bean = (UserBean) it.next();

			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getLoginId());
			System.out.print("\t" + bean.getPassword());
			System.out.print("\t" + bean.getDob());
			System.out.println("\t" + bean.getAddress());

		}

	}

	private static void testUpdate() throws Exception {

		UserModel model = new UserModel();
		UserBean bean = model.FindByPk(1);

		if (bean != null) {

			bean.setFirstName("jatin");

			model.update(bean);

			System.out.println("user Exist && update");

		} else {
			System.out.println("User nor Wxist");
		}

	}

	private static void testAdd() throws Exception {

		UserBean bean = new UserBean();
		String dob = "2005-12-20";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");

		bean.setId(8);
		bean.setFirstName("hemendra");
		bean.setLastName("rathore");
		bean.setLoginId("hemu@gamil.com");
		bean.setPassword("hemu1432");
		bean.setDob(sdf.parse(dob));
		bean.setAddress("bangali");

		UserModel model = new UserModel();
		model.add(bean);

	}

}
