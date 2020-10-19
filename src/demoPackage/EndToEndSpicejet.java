package demoPackage;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import resources.Resources;

public class EndToEndSpicejet {

	public static void main(String[] args) throws InterruptedException, IOException {
		Resources resource= new Resources();
		System.setProperty("webdriver.chrome.driver",
				resource.getPropertyObject("data.properties").getProperty("ChromeBrowserPath"));
		WebDriver driver =  new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		Thread.sleep(7000);
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='BLR']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
		Thread.sleep(3000);
		  System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
			 // System.out.println(driver.findElement(By.id("ctl00_mainContent_view_date2")).isEnabled());
			 driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
			// System.out.println(driver.findElement(By.id("ctl00_mainContent_view_date2")).isEnabled());
			 System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
			
			 if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1"))
			 {
				 System.out.println("Round way");
				 Assert.assertTrue(true);
			 }
			 else
			 {
				 Assert.assertFalse(false);
			 }
			 driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
			 System.out.println("One way");
			 Thread.sleep(3000);
			 driver.findElement(By.cssSelector("#divpaxinfo")).click();
			 Thread.sleep(3000);
			 Select se = new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Adult")));
			 se.selectByValue("2");
			 Thread.sleep(3000);
			 Select se1 = new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
			 se1.selectByValue("AED");
			 Thread.sleep(6000);
			 driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
			 Thread.sleep(3000);
			 driver.close();

	}

}
