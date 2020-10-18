package demoPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ammu\\Downloads\\chromedriver_win32\\ChromeDriver.exe");
		WebDriver driver =  new ChromeDriver();
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
