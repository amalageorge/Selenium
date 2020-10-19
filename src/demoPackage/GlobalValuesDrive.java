package demoPackage;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import resources.Resources;

public class GlobalValuesDrive {

	public static void main(String[] args) throws IOException {
		Resources resource = new Resources();
		Properties prop = resource.getPropertyObject("data.properties");

		System.out.println(resource.getPropertyObject("data.properties").getProperty("Browser"));

		System.out.println(resource.getPropertyObject("data.properties").getProperty("url"));
		prop.setProperty("Browser", "ie");

		FileOutputStream fos = new FileOutputStream(
				System.getProperty("user.dir") + "\\src\\resources\\data.properties");
		prop.store(fos, null);
	}

}
