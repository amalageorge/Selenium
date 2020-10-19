package demoPackage;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import resources.Resources;

public class Assessment6 {

	public static void main(String[] args) throws InterruptedException, IOException {
		Resources resource= new Resources();
		System.setProperty("webdriver.chrome.driver",
				resource.getPropertyObject("data.properties").getProperty("ChromeBrowserPath"));
		WebDriver driver= new ChromeDriver();
		driver.get("http://qaclickacademy.com/practice.php");
		WebElement column=driver.findElement(By.id("checkbox-example"));
		column.findElement(By.id("checkBoxOption2")).click();
		String word=column.findElement(By.id("checkBoxOption2")).getAttribute("value");
		driver.findElement(By.id("checkBoxOption2")).click();
		Select se= new Select(driver.findElement(By.id("dropdown-class-example")));
		se.selectByValue(word);
		driver.findElement(By.id("name")).sendKeys(word);
		driver.findElement(By.id("alertbtn")).click();
		String alertMsg= driver.switchTo().alert().getText();
		if(alertMsg.contains(word))
		{
			System.out.println("verified");
		}
		else
		{
			System.out.println("not verified");
		}
		driver.switchTo().alert().dismiss();
		Thread.sleep(3000);
		driver.close();

	}

}
