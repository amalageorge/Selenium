package demoPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class spicejet {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ammu\\Downloads\\chromedriver_win32\\ChromeDriver.exe");
		WebDriver driver =  new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		Thread.sleep(3000);
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		 driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='BLR']")).click();
		Thread.sleep(2000);
		 driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
		 Thread.sleep(3000);
		  Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount'")).isSelected());
		  //System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount'")).isSelected());
		  driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount'")).click();//check box //System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount'")).isSelected());
		  Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount'")).isSelected()); Thread.sleep(3000);
		  //count the number of check boxes
		  System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).size());
		  Thread.sleep(3000);
		  System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		 // System.out.println(driver.findElement(By.id("ctl00_mainContent_view_date2")).isEnabled());
		 driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		// System.out.println(driver.findElement(By.id("ctl00_mainContent_view_date2")).isEnabled());
		 System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		
		 if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1"))
		 {
			 System.out.println("is enabled");
			 Assert.assertTrue(true);
		 }
		 else
		 {
			 Assert.assertTrue(false);
		 }
		  
		 
		 
		driver.close();

	}

}
