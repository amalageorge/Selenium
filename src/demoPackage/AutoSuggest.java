package demoPackage;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import resources.Resources;

public class AutoSuggest {

	public static void main(String[] args) throws InterruptedException, IOException {
		Resources resource= new Resources();
		System.setProperty("webdriver.chrome.driver",
				resource.getPropertyObject("data.properties").getProperty("ChromeBrowserPath"));WebDriver driver =  new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("autosuggest")).sendKeys("Ind");
		Thread.sleep(3000);
		List<WebElement> options=driver.findElements(By.xpath("//li[@class='ui-menu-item'] //a"));
		for(WebElement option: options)
		{
			if(option.getText().equalsIgnoreCase("india"))
			{
				option.click();
				break;
			}
		}
		
		
driver.close();
	}

}
