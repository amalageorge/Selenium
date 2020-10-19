package demoPackage;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import resources.Resources;

public class Screenshot {

	public static void main(String[] args) throws IOException {
		Resources resource= new Resources();
		System.setProperty("webdriver.chrome.driver",
				resource.getPropertyObject("data.properties").getProperty("ChromeBrowserPath"));
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().deleteAllCookies();    //delete all cookies
		//driver.manage().deleteCookieNamed("asdf");   //delete particular cookie
		driver.get("http://qaclickacademy.com/practice.php");
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(resource.getScreenshotDirectory() + "screenshot.png"));
		driver.close();
	}

}
