package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Program2CssSelector {
	@Test(dataProvider="DP" , dataProviderClass=Data_provider.class)
	public void Method2(String Username , String Password) throws InterruptedException
	{
		int emp = 3;
		//open browser
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dodke sushobhan j\\Downloads\\chromedriver-win64\\chromedriver-win64\\Chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		//Thread.sleep(3000);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		//Login
		WebElement user= wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='Username']")));
		user.sendKeys(Username);
		driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys(Password);
		driver.findElement(By.cssSelector("button[type='submit'")).click();
		
		//Click on Time
		WebElement time = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Time")));
		time.click();
		//Click on Attendance and punch In/out
		WebElement jobElement = wait.until(ExpectedConditions.elementToBeClickable(
			    By.xpath("//li[2]/span")
			));
		jobElement.click();
		driver.findElement(By.xpath("//ul/li[2]/a[contains(text(),'Punch In/Out')]")).click();
		
		for(int i = 1;i<=emp;i++)
		{
			//Punch in
			WebElement in = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/form/div[3]/button")));
			in.click();
			
			//Punch out
			Thread.sleep(10000);
			driver.findElement(By.xpath("//form/div[3]/button")).click();
			Thread.sleep(20000);
		}
		
		
		// open date and time
		//driver.findElement(By.xpath("//div/div[2]/div/div/i")).click();
		/*
		WebElement Acal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/input[1]")));
		Acal.click();
		Acal.sendKeys(Keys.CONTROL + "a");
		Acal.sendKeys(Keys.DELETE);
		Acal.sendKeys("2025-06-07");
		*/
		/*
		WebElement calender = wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/form/div[1]/div/div[1]/div/div[2]/div/div/input"))));
		calender.click();
		calender.sendKeys(Keys.CONTROL + "a");
		calender.sendKeys(Keys.DELETE);
		calender.sendKeys("2025-05-07");
		*/
			
		
	}
}
