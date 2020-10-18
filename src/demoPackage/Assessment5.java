package demoPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assessment5 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Ammu\\Downloads\\chromedriver_win32\\ChromeDriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com");
		driver.findElement(By.xpath("//a[text()='Nested Frames']")).click();
		driver.switchTo().frame("frame-top");
		driver.switchTo().frame("frame-middle");
		System.out.println(driver.findElement(By.xpath("//div[@id='content']")).
		getText());	 
		driver.close();
	}

}
