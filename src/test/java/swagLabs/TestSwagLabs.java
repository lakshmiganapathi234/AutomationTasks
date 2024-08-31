package swagLabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSwagLabs {
	
	WebDriver driver;
	
	@Test(dataProvider = "LoginData",dataProviderClass = ExcelDataProvider.class)
	void standard_user(String username,String password,String msg) {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("login-button")).click();
		
		try {
			WebElement logo = driver.findElement(By.xpath("//div[@class='app_logo']"));
			boolean res = logo.isDisplayed();
			Assert.assertTrue(res);
		} catch (Exception e) {
			System.out.println("Not logged in");
			String error_msg = driver.findElement(By.xpath("//h3[@data-test='']")).getText();
			boolean res1 = error_msg.equals(msg);
			Assert.assertTrue(res1);
		}
		
	}

}
