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
import org.testng.annotations.BeforeMethod;
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
		
	}
	
	@Test(priority=1)
	public void Contact_Details()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//nav/div[2]/ul/li[6]/a/span"))).click();
		
	}
	
	@Test(priority=2)
	public void Assigned_Emergency_Contacts()
	{
		
	}
	
	@Test(priority=3)
	public void Assign_Membership()
	{
		
	}
	
	@Test(priority=3)
	public void Upload_Profile_Photo()
	{
		
	}
}
