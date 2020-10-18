package demoPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assessment7 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Ammu\\Downloads\\chromedriver_win32\\ChromeDriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("http://qaclickacademy.com/practice.php");
		WebElement table=driver.findElement(By.cssSelector("table[class='table-display']"));
		int rowCount=table.findElements(By.tagName("tr")).size();
		int columnCount= table.findElements(By.cssSelector("tr th")).size();
		System.out.println("Row count="+rowCount);
		System.out.println("Column count="+columnCount);
		WebElement row=driver.findElement(By.cssSelector("table[class='table-display'] tr:nth-child(3)"));
		System.out.println(row.findElement(By.xpath("//td[text()='Rahul Shetty']")).getText());
		System.out.println(row.findElement(By.xpath("//td[text()='Learn SQL in Practical + Database Testing from Scratch']")).getText());
		System.out.println(row.findElement(By.xpath("//td[text()='25']")).getText());
		driver.close();

	}

}
