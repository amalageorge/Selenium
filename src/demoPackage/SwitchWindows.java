package demoPackage;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchWindows {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Ammu\\Downloads\\chromedriver_win32\\ChromeDriver.exe");
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
		driver.close();
	}

}
