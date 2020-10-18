package demoPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ammu\\Downloads\\chromedriver_win32\\ChromeDriver.exe");
		WebDriver driver =  new ChromeDriver();
		driver.get("https://www.facebook.com");
		String s=driver.findElement(By.xpath("//div[contains(@class,'fcb')]")).getText();
		System.out.println(s);
		driver.findElement(By.id("email")).sendKeys("amalageorgee@gmail.com");
	    driver.findElement(By.name("pass")).sendKeys("123456");
		driver.findElement(By.linkText("Forgotten account?")).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		//driver.findElement(By.cssSelector("#email")).sendKeys("amalageorgee@gmail.com");
		driver.close();
	}

}
