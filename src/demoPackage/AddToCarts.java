package demoPackage;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import resources.Resources;

public class AddToCarts {

	public static void main(String[] args) throws InterruptedException, IOException { 
		Resources resource= new Resources();
		System.setProperty("webdriver.chrome.driver",
				resource.getPropertyObject("data.properties").getProperty("ChromeBrowserPath"));
		WebDriver driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebDriverWait w= new WebDriverWait(driver,5);
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		String items[]= {"Cucumber", "Brocolli", "Beetroot", "Tomato"};
		Thread.sleep(3000);
		addItems(driver,items);
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("input.promoCode")));
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		
		
		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("promoInfo")));
		System.out.println(driver.findElement(By.className("promoInfo")).getText());
		driver.close();
		
	}
	public static void addItems(WebDriver driver,String items[]) throws InterruptedException
	{
		
		//List al= Arrays.asList(items);
		int j=0;
		List <WebElement> products=driver.findElements(By.cssSelector("h4.product-name"));
		for(int i=0;i<products.size();i++)
		{
			String[] name=products.get(i).getText().split("-");
			String formattedName=name[0].trim();
			List al= Arrays.asList(items);
			if(al.contains(formattedName))
			{
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				
				if(j==items.length) {
					break;
				}
			}
			
		}
		
	}

}
