package Pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Admin_AddUser {
	WebDriver driver;
	WebDriverWait wait;
	@BeforeMethod
	public void openBrowser()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
	}
	@Test
	public void AddUser() throws IOException
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).sendKeys("Admin");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password"))).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		//Admin button
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul/li[1]/a/span"))).click();
		//Add button
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/div[2]/div[1]/button"))).click();
		//Fist field
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='oxd-select-text-input'])[1]"))).click();
		driver.findElement(By.xpath("(//div[@role='listbox']//child::div)[2]")).click();
		//Second field
		driver.findElement(By.xpath("//input[@placeholder='Type for hints...']")).sendKeys("Sushobhan");
		WebElement firstOption = wait.until(ExpectedConditions.visibilityOfElementLocated(
			    By.xpath("(//div[@role='listbox']//span)[1]")));
		firstOption.click();
		
		//Third field
		WebElement status = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='oxd-select-text--after'])[2]")));
		status.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@role='listbox']//span)[1]"))).click();
		
		//Username field
		String path = "E:\\Java\\Sushobhan_Project1_OrangeHRM\\src\\test\\resources\\Admin_userdata.properties";
		FileInputStream file = new FileInputStream(path);
		Properties pr = new Properties();
		pr.load(file);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/div[2]/input"))).sendKeys(pr.getProperty("Username"));
		
		//password field
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/input[@type='password']"))).sendKeys(pr.getProperty("pass"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div/input[@type='password'])[2]"))).sendKeys(pr.getProperty("pass"));
		
		//submit button
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']"))).click();
	}
}
