package demoPackage;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import resources.Resources;

public class Alerts {

	public static void main(String[] args) throws IOException {
		Resources resource= new Resources();
		System.setProperty("webdriver.chrome.driver",
				resource.getPropertyObject("data.properties").getProperty("ChromeBrowserPath"));WebDriver driver =  new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("name")).sendKeys("Amala");
		//driver.findElement(By.id("alertbtn")).click();
		driver.findElement(By.id("confirmbtn")).click();
		String x=driver.switchTo().alert().getText();
		System.out.println(x);
		driver.switchTo().alert().dismiss();
		driver.close();

	}

}
