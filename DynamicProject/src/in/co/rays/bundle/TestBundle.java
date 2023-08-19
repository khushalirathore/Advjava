package in.co.rays.bundle;

import java.util.Locale;
import java.util.ResourceBundle;

public class TestBundle {
	public static void main(String[] args) throws Exception {

		ResourceBundle rb = ResourceBundle.getBundle("in.co.rays.Bundle.app",new Locale("hi"));

		System.out.println(rb.getString("Greeting"));
//		System.out.println(rb.getString("url"));
//		System.out.println(rb.getString("user"));
//		System.out.println(rb.getString("password"));
//		String s = rb.getString("Initial");
//		System.out.println(Integer.parseInt(s));

	}

}