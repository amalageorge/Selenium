package demoPackage;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import resources.Resources;

public class Assessment2 {

	public static void main(String[] args) throws IOException {
		Resources resource= new Resources();
		System.setProperty("webdriver.chrome.driver",
				resource.getPropertyObject("data.properties").getProperty("ChromeBrowserPath"));
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.itgeared.com/demo/1506-ajax-loading.html");
	    WebDriverWait w = new WebDriverWait(driver,5);
	    driver.findElement(By.xpath("//a[text()='Click to load get data via Ajax!']")).click();
	    w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='results']")));
	    System.out.println(driver.findElement(By.xpath("//div[@id='results']")).getText());
	    driver.close();

	}

}
