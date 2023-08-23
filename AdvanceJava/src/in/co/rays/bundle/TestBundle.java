package in.co.rays.bundle;

import java.util.ResourceBundle;

public class TestBundle {

	public static void main(String[] args) throws Exception {

		ResourceBundle rb = ResourceBundle.getBundle("in.co.rays.bundle.app_hi");

		System.out.println(rb.getString("Greeting"));
//		System.out.println(rb.getString("url"));
//		System.out.println(rb.getString("user"));
//		System.out.println(rb.getString("password"));
//		String s = rb.getString("Initial");
//		System.out.println(Integer.parseInt(s));

	}

}
