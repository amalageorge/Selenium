package demoPackage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import resources.Resources;

public class Demo {

	public static void main(String[] args) throws IOException {
		Resources resource= new Resources();
		System.setProperty("webdriver.chrome.driver",
				resource.getPropertyObject("data.properties").getProperty("ChromeBrowserPath"));
		WebDriver driver =  new ChromeDriver();
		driver.get("https://www.facebook.com");
		String s=driver.findElement(By.xpath("//div[contains(@class,'_8ice')]")).getText();
		System.out.println(s);
		driver.findElement(By.id("email")).sendKeys("amalageorgee@gmail.com");
	    driver.findElement(By.name("pass")).sendKeys("123456");
		driver.findElement(By.linkText("Forgotten password?")).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		//driver.findElement(By.cssSelector("#email")).sendKeys("amalageorgee@gmail.com");
		driver.close();
	}

}
