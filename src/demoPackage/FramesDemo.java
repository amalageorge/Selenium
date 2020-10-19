package demoPackage;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import resources.Resources;

public class FramesDemo {

	public static void main(String[] args) throws InterruptedException, IOException {
		Resources resource= new Resources();
		System.setProperty("webdriver.chrome.driver",
				resource.getPropertyObject("data.properties").getProperty("ChromeBrowserPath"));
		WebDriver driver= new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		//driver.switchTo().frame(0);
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));
		WebElement e1=driver.findElement(By.cssSelector("div#draggable"));
		WebElement e2= driver.findElement(By.cssSelector("div[id='droppable']"));
		driver.findElement(By.id("draggable")).click();
		Actions a= new Actions(driver);
		a.dragAndDrop(e1, e2).build().perform();
		driver.switchTo().defaultContent();
		
		driver.close();
	}

	
}
