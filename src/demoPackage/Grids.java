package demoPackage;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import resources.Resources;

public class Grids {

	public static void main(String[] args) throws IOException {
		int sum=0;
		Resources resource= new Resources();
		System.setProperty("webdriver.chrome.driver",
				resource.getPropertyObject("data.properties").getProperty("ChromeBrowserPath"));
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.cricbuzz.com/live-cricket-scorecard/23253/eng-vs-pak-3rd-t20i-pakistan-tour-of-england-2020");
		WebElement table=driver.findElement(By.cssSelector("div[class='cb-col cb-col-100 cb-ltst-wgt-hdr']"));
		//List <WebElement> elements=table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms']"));
		int rowCount=table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms']")).size();
		int elementCount=table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).size();
		for(int i=0;i<elementCount-2;i++)
		{
			String value=table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).get(i).getText();
			int valueInteger=Integer.parseInt(value);
			sum=sum+valueInteger;
		}
		System.out.println(sum);
	String extra=driver.findElement(By.xpath("//div[text()='Extras']/following-sibling::div")).getText();
	sum=sum+(Integer.parseInt(extra));
	System.out.println(sum);
	String total=driver.findElement(By.xpath("//div[text()='Total']/following-sibling::div")).getText();
	int actualTotal=Integer.parseInt(total);
	if(sum==actualTotal)
	{
		System.out.println("count matched");
	}
		driver.close();
		

	}

}
