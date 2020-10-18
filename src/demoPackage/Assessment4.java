package demoPackage;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assessment4 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Ammu\\Downloads\\chromedriver_win32\\ChromeDriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com");
		driver.findElement(By.xpath("//a[text()='Multiple Windows']")).click();
		driver.findElement(By.xpath("//a[text()='Click Here']")).click();
		Set<String> ids= driver.getWindowHandles();
		Iterator<String> it= ids.iterator();
		String paretntId=it.next();
		String childId= it.next();
		driver.switchTo().window(childId);
		System.out.println(driver.findElement(By.xpath("//div/h3")).getText());
		
		driver.switchTo().window(paretntId);
		System.out.println(driver.findElement(By.xpath("//div[@id='content']/div/h3")).getText());
		
		
	}

}
