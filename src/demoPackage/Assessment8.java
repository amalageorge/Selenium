package demoPackage;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import resources.Resources;

public class Assessment8 {

	public static void main(String[] args) throws InterruptedException, IOException {
		Resources resource= new Resources();
		System.setProperty("webdriver.chrome.driver",
				resource.getPropertyObject("data.properties").getProperty("ChromeBrowserPath"));
		WebDriver driver= new ChromeDriver();
		driver.get("http://qaclickacademy.com/practice.php");
		driver.findElement(By.id("autocomplete")).sendKeys("Uni");
		Thread.sleep(3000);
		JavascriptExecutor js= (JavascriptExecutor)driver;
		String s="return document.getElementById(\"autocomplete\").value";
		String value=(String)js.executeScript(s);
		System.out.println(value);
		while(!value.equalsIgnoreCase("United Kingdom (UK)"))
		{
			driver.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys(Keys.DOWN);
			value=(String)js.executeScript(s);
			System.out.println(value);
		}
		driver.findElement(By.id("autocomplete")).sendKeys(Keys.ENTER);
		driver.close();
		
	}

}
