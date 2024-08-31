package task2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSearch {
	
	WebDriver driver;
	boolean status;
	@Test(dataProvider = "SearchData",dataProviderClass = ExcelDataProvider.class)
	void test(String product) {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		WebElement searchbar = driver.findElement(By.name("q"));
		searchbar.sendKeys(product);
		searchbar.submit();
		
		try {
			status = driver.findElement(By.xpath("//span[@class='BUOuZu']")).getText().contains(product);
			Assert.assertTrue(status);
		} catch (Exception e) {
			System.out.println("No results found");
		}
	driver.close();
	}

}
