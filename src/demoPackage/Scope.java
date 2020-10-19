package demoPackage;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import resources.Resources;

public class Scope {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		Resources resource= new Resources();
		System.setProperty("webdriver.chrome.driver",
				resource.getPropertyObject("data.properties").getProperty("ChromeBrowserPath"));
		WebDriver driver= new ChromeDriver();
		driver.get("http://qaclickacademy.com/practice.php");
		System.out.println(driver.findElements(By.tagName("a")).size());//count of links on page
		WebElement footer= driver.findElement(By.id("gf-BIG"));
		System.out.println(footer.findElements(By.tagName("a")).size());//count of links on footer section
		WebElement columnDriver=footer.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(columnDriver.findElements(By.tagName("a")).size());//count of links on first column
		
		//code to click on each links in the first column
		for(int i=1;i<columnDriver.findElements(By.tagName("a")).size();i++)
		{
			String clickOnLink=Keys.chord(Keys.CONTROL,Keys.ENTER);
			columnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLink);
			Thread.sleep(5000);
		}
			Set<String> links= driver.getWindowHandles();
			Iterator<String> it= links.iterator();
			while(it.hasNext())
			{
				driver.switchTo().window(it.next());
				System.out.println(driver.getTitle());
					
			}
			driver.quit();
		
	}
	

}
