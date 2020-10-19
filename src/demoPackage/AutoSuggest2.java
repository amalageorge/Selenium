package demoPackage;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import resources.Resources;

public class AutoSuggest2 {

	public static void main(String[] args) throws InterruptedException, IOException {
		Resources resource= new Resources();
		System.setProperty("webdriver.chrome.driver",
				resource.getPropertyObject("data.properties").getProperty("ChromeBrowserPath"));
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		Thread.sleep(5000);
		//driver.findElement(By.xpath("//div[text()=' Login or Create Account']")).click();
		driver.findElement(By.id("fromCity")).click();
		driver.findElement(By.id("fromCity")).sendKeys("mum");
		driver.findElement(By.id("fromCity")).sendKeys(Keys.ENTER);
		//driver.findElement(By.id("toCity")).click();
		driver.findElement(By.id("toCity")).sendKeys("DEL");
		driver.findElement(By.id("toCity")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.id("toCity")).sendKeys(Keys.ENTER);
		Thread.sleep(7000);
		driver.close();
	}

}
