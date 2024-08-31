package task4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ShoppingCart {
	
	WebDriver driver;
	
	@Test
	void test() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		
		Thread.sleep(2000);
		//Adding Products Cart
		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
		driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
		driver.findElement(By.id("shopping_cart_container")).click();
		
		Thread.sleep(2000);
		//Removing Products
		driver.findElement(By.id("remove-sauce-labs-backpack")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.id("checkout")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.id("first-name")).sendKeys("LAKSHMI GANAPATHI");
		driver.findElement(By.id("last-name")).sendKeys("KAVURU");
		driver.findElement(By.id("postal-code")).sendKeys("534247");
		driver.findElement(By.id("continue")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.id("finish")).click();
	}

}
