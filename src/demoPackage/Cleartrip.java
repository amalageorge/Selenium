package demoPackage;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import resources.Resources;

public class Cleartrip {

	public static void main(String[] args) throws IOException {
		Resources resource= new Resources();
		System.setProperty("webdriver.chrome.driver",
				resource.getPropertyObject("data.properties").getProperty("ChromeBrowserPath"));
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.cleartrip.com/");
		Select se1 = new Select(driver.findElement(By.id("Adults")));
		se1.selectByValue("2");
		Select se2 = new Select(driver.findElement(By.id("Childrens")));
		se2.selectByValue("2");
		driver.findElement(By.id("DepartDate")).click();
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();
		driver.findElement(By.id("MoreOptionsLink")).click();
		driver.findElement(By.id("AirlineAutocomplete")).sendKeys("SpiceJet (SG)");
		driver.findElement(By.id("SearchBtn")).click();
		;
		String s = driver.findElement(By.id("homeErrorMessage")).getText();
		System.out.println(s);
		driver.close();
	}

}
