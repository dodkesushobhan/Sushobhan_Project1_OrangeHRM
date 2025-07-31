package Pages_2;

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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class My_Info_page {

	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void openBrowser() throws IOException
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		//login
		String path = "E:\\Java\\Sushobhan_Project1_OrangeHRM\\src\\test\\resources\\Admin_userdata.properties";
		Properties pr = new Properties();
		FileInputStream file = new FileInputStream(path);
		pr.load(file);
		
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement user = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
		user.sendKeys(pr.getProperty("Username"));
		WebElement pass = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		pass.sendKeys(pr.getProperty("pass"));
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//nav/div[2]/ul/li[6]/a/span"))).click();
		
	}
	
	@Test(priority=1)
	public void Contact_Details() throws InterruptedException
	{
		//click on contact details
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/div/div/div[2]/div[2]/a"))).click();
		
		// enter address
		Thread.sleep(2000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[contains(@class,'oxd-input')])[2]"))).sendKeys("Main road,");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[contains(@class,'oxd-input')])[4]"))).sendKeys("Latur ");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[contains(@class,'oxd-input')])[5]"))).sendKeys("Maharashtra ");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[contains(@class,'oxd-input')])[6]"))).sendKeys("413520");
		//country dropdown
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/div/div[2]/div/div/div[2]/i"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='listbox']//span[text()='India']"))).click();
		//mobile number
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[contains(@class,'oxd-input')])[8]"))).sendKeys("9689604160");
		

		driver.findElement(By.xpath("//div/button[text()=' Save ']")).click();
		Thread.sleep(5000);
		
	}
	
	@Test(priority=2)
	public void Assigned_Emergency_Contacts()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='orangehrm-tabs-item' and text()='Emergency Contacts']"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/div[2]/div/div/button[1]/i[1]"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@class='oxd-input--active'])[2]"))).sendKeys("Hello");
		
	}
	
	@Test(priority=3)
	public void Assign_Membership()
	{
		// membership 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/div/div/div[2]/div[10]/a"))).click();
		// Add membership
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[contains(@class, 'oxd-button--text')])[1]"))).click();
		// fields
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='oxd-select-text--after'])[1]"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='listbox']//span[text()='British Computer Society (BCS)']"))).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='oxd-select-text--after'])[2]"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='listbox']//span[text()='Individual']"))).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form/div/div/div[3]/div/div[2]/input"))).sendKeys("200");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='oxd-select-text--after'])[3]"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='listbox']//span[text()='Indian Rupee']"))).click();
		
		driver.findElement(By.xpath("(//i[@class='oxd-icon bi-calendar oxd-date-input-icon'])[1]")).click();
		driver.findElement(By.xpath("//div[@class='oxd-calendar-date' and text()='15']")).click();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		

		
	}
	
	@Test(priority=3)
	public void Upload_Profile_Photo()
	{
		
	}
}
