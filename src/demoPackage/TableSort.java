package demoPackage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import resources.Resources;

public class TableSort {

	public static void main(String[] args) throws IOException {
		Resources resource= new Resources();
		System.setProperty("webdriver.chrome.driver",
				resource.getPropertyObject("data.properties").getProperty("ChromeBrowserPath"));
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.cssSelector("tr th:nth-child(2)")).click();
		//driver.findElement(By.cssSelector("tr th:nth-child(2)")).click();
		List<WebElement> veg=driver.findElements(By.cssSelector("tr td:nth-child(2)"));
		ArrayList<String> originalList= new ArrayList<String>();
		for(int i=0; i<veg.size();i++)
		{
			originalList.add(veg.get(i).getText());
		}
		ArrayList<String> copiedList=new ArrayList<String>();
		for(int i=0; i<veg.size();i++)
		{
			copiedList.add(originalList.get(i));
		}
		
		System.out.println(originalList);
		
		Collections.sort(copiedList);
		Collections.reverse(copiedList);//code to descend the list
		System.out.println(copiedList);
		Assert.assertFalse(originalList.equals(copiedList));
		
		driver.close();
	}

}
