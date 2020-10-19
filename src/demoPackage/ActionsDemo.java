package demoPackage;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import resources.Resources;

public class ActionsDemo {

	public static void main(String[] args) throws InterruptedException, IOException {
		Resources resource= new Resources();
		System.setProperty("webdriver.chrome.driver",
				resource.getPropertyObject("data.properties").getProperty("ChromeBrowserPath"));
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com");
		driver.manage().window().maximize();
		WebElement move=driver.findElement(By.cssSelector("a[id='nav-link-accountList']"));
		Actions a= new Actions(driver);
		a.moveToElement(driver.findElement(By.cssSelector("a[id='nav-link-accountList']"))).build().perform();
		a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
		a.moveToElement(move).contextClick().build().perform();
		driver.close();

	}

}
