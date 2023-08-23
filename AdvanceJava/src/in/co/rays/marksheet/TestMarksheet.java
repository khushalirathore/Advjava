package in.co.rays.marksheet;

import java.util.Iterator;
import java.util.List;



public class TestMarksheet {

	public static void main(String[] args) throws Exception {
		//testUpdate();
	//	 testDelete();
		testAdd();
		// testFindByRollNo();
		// testSearch();

	}



	private static void testFindByRollNo() throws Exception {

		marksheetModel model = new marksheetModel();
		MarksheetBean bean = model.findByRollNo(114);

		if (bean != null) {
			System.out.println(bean.getId());
			System.out.println(bean.getName());
			System.out.println(bean.getRollNo());
			System.out.println(bean.getPhysics());
			System.out.println(bean.getChemistry());
			System.out.println(bean.getMaths());

		} else {
			System.out.println("Roll no is not exist.....!!");

		}

	}

	private static void testUpdate() throws Exception {

		MarksheetBean bean = new MarksheetBean();

		bean.setId(16);
		bean.setName("ars"); 
		bean.setRollNo(116);
		bean.setPhysics(61);
		bean.setChemistry(57);
		bean.setMaths(63);

		marksheetModel model = new marksheetModel();

		model.Update(bean);

	}

	private static void testDelete() throws Exception {

		marksheetModel model = new marksheetModel();
		model.delete(18 );

	}

	private static void testAdd() throws Exception {

		MarksheetBean bean = new MarksheetBean();
		marksheetModel model = new marksheetModel();
		//bean.setId(model.nextPk());
		bean.setId(21);
		bean.setName("Ram");
		bean.setRollNo(120);
		bean.setPhysics(56);
		bean.setChemistry(57);
		bean.setMaths(69);

		model.add(bean);

	}

	private static void testSearch() throws Exception {
		MarksheetBean bean = new MarksheetBean();
		
	    bean.setName("d");
	//  bean.setId(5);
		//bean.setRollNo(114);
		

		marksheetModel model = new marksheetModel();
		
		List list = model.search(bean, 1,6);

		Iterator it = list.iterator();

		while (it.hasNext()) {
			bean = (MarksheetBean) it.next();
			System.out.print("\t"+bean.getId());
			System.out.print("\t"+bean.getName());
			System.out.print("\t"+bean.getRollNo());
			System.out.print("\t"+bean.getPhysics());
			System.out.print("\t"+bean.getChemistry());
			System.out.println("\t"+bean.getMaths());
		}
	}
}
