package task3;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class FoamFilling {
	WebDriver driver;
	
	@Test
	void testfoam() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/automation-practice-form");
		
		driver.findElement(By.id("firstName")).sendKeys("Ganapathi");
		driver.findElement(By.id("lastName")).sendKeys("Kavuru");
		driver.findElement(By.id("userEmail")).sendKeys("klganapathi1997@gmail.com");
	    
		List<WebElement> gender =driver.findElements(By.xpath("//div[contains(@class,'custom-radio')]"));
		for (WebElement category : gender) {
			if(category.getText().equalsIgnoreCase("Male")) {
				category.click();
			}
		}
		driver.findElement(By.id("userNumber")).sendKeys("9949012998");
		
		
		
		driver.findElement(By.id("dateOfBirthInput")).click();
		Thread.sleep(1000);
		WebElement	month = driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']"));
		Select selectMonth = new Select(month);
	    selectMonth.selectByVisibleText("March");
	    WebElement	year = driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']"));
		Select selectYear= new Select(year);
		selectYear.selectByVisibleText("1997");
		driver.findElement(By.xpath("//div[@class='react-datepicker__day react-datepicker__day--013']")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.id("subjectsInput")).sendKeys("M");
		Thread.sleep(1000);
		WebElement hiddenDropdown = driver.findElement(By.xpath("//div[text()='Maths']"));
		JavascriptExecutor jse=(JavascriptExecutor )driver;
		jse.executeScript("arguments[0].click();", hiddenDropdown);
	  
		List<WebElement> Hobies = driver.findElements(By.xpath("//div[contains(@class,'custom-checkbox')]"));
		for (WebElement Hobby : Hobies) {
			if(Hobby.getText().equalsIgnoreCase("Reading")) {
				Hobby.click();
			}
		}
		
		driver.findElement(By.id("uploadPicture")).sendKeys("C:\\Users\\RAVI KONNE\\Downloads\\Raviteja.jpg");
		driver.findElement(By.id("currentAddress")).sendKeys("7-68/1,Rayakuduru");
		
		driver.findElement(By.id("state")).click();
		driver.findElement(By.xpath("//div[text()='Uttar Pradesh']")).click();
		
		
		driver.findElement(By.id("city")).click();
		driver.findElement(By.xpath("//div[text()='Lucknow']")).click();
		
		driver.findElement(By.id("submit")).click();
	}

}
