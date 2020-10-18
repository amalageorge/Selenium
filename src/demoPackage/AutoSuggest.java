package demoPackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggest {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ammu\\Downloads\\chromedriver_win32\\ChromeDriver.exe");
		WebDriver driver =  new ChromeDriver();
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
