package demoPackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calendar {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Ammu\\Downloads\\chromedriver_win32\\ChromeDriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.path2usa.com/travel-companions");
		Thread.sleep(8000);
		driver.findElement(By.xpath("//input[@id='travel_date']")).click();
		
		while(!driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).getText().contains("May"))
		{
			driver.findElement(By.cssSelector("[class='datepicker-days'] th[class='next']")).click();
		}
		List<WebElement> dates= driver.findElements(By.className("day"));
		int count=driver.findElements(By.className("day")).size();
		for(int i=0;i<count;i++)
		{
			String date=driver.findElements(By.className("day")).get(i).getText();
			if(date.equalsIgnoreCase("21"))
			{
				driver.findElements(By.className("day")).get(i).click();
				Thread.sleep(10000);
				System.out.println(date);
				break;
			}
		}
		driver.close();

	}

}
