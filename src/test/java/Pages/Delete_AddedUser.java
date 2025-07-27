package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Delete_AddedUser {

	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeMethod
	public void open()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
	}
	
	@Test
	public void mainMethod() throws InterruptedException
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).sendKeys("Admin");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password"))).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/ul/li[1]/a/span[text()='Admin']"))).click();
		Thread.sleep(2000);
		/*
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		*/
		driver.findElement(By.xpath("//div[1]/div[1]/div[1]/label[1]/span[1]/i[1]")).click();
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/button[1]")).click();
		driver.findElement(By.xpath("//div/div[3]/button[2]")).click();
		Thread.sleep(5000);
		driver.quit();
	}
}
