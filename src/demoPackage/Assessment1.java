package demoPackage;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import resources.Resources;

public class Assessment1 {

	public static void main(String[] args) throws IOException {
		Resources resource= new Resources();
		System.setProperty("webdriver.chrome.driver",
				resource.getPropertyObject("data.properties").getProperty("ChromeBrowserPath"));WebDriver driver =  new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		WebElement e1=driver.findElement(By.id("checkBoxOption1"));
		e1.click();
		if(e1.isSelected()==true)
		{
			e1.click();
		}
		List<WebElement> c1=driver.findElements(By.xpath("//input[@type='checkbox']"));
		int count=c1.size();
		System.out.println(count);
		driver.close();
	}

}
