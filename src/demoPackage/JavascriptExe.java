package demoPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavascriptExe {

	public static void main(String[] args) throws InterruptedException {
		//Enter the letters BENG
		//Verify if we get airport option
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Ammu\\Downloads\\chromedriver_win32\\ChromeDriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.ksrtc.in");
		driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys("Beng");
		driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys(Keys.DOWN);
		//driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys(Keys.DOWN);
		//driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys(Keys.ENTER);
		JavascriptExecutor js= (JavascriptExecutor)driver;
		String s="return document.getElementById(\"fromPlaceName\").value";
		String value=(String)js.executeScript(s);
		System.out.println(value);
		int i=0;
		while(!value.equalsIgnoreCase("BENGALURU INTERNATION AIRPORT"))
		{
			i++;
			driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys(Keys.DOWN);
			value=(String)js.executeScript(s);
			System.out.println(value);
			if(i>10)
			{
				break;
			}
		}
		driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		driver.close();
	}

}
