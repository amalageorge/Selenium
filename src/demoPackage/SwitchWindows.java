package demoPackage;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import resources.Resources;

public class SwitchWindows {

	public static void main(String[] args) throws IOException {
		Resources resource= new Resources();
		System.setProperty("webdriver.chrome.driver",
				resource.getPropertyObject("data.properties").getProperty("ChromeBrowserPath"));
		WebDriver driver= new ChromeDriver();
		driver.get("https://accounts.google.com/signup");
		driver.findElement(By.xpath("(//a[@target='_blank'])[1]")).click();
		//System.out.println(driver.getTitle());
		Set<String> ids= driver.getWindowHandles();
		Iterator<String> it= ids.iterator();
		String paretntId=it.next();
		String childId= it.next();
		driver.switchTo().window(childId);
		System.out.println(driver.getTitle());
		driver.switchTo().window(paretntId);
		System.out.println(driver.getTitle());
		driver.quit();
	}

}
