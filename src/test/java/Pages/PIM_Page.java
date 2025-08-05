package Pages;
// 1. Add Employee in organization
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PIM_Page {
	WebDriver driver;
	WebDriverWait wait ;

	@BeforeMethod
	public void Method1()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
	}
	
	@Test
	public void Add_emp() throws IOException, InterruptedException
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).sendKeys("Admin");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password"))).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/ul/li[2]/a/span"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/nav/ul/li[3]/a"))).click();
		
		//Open properties file
		String path = "E:\\Java\\Sushobhan_Project1_OrangeHRM\\src\\test\\resources\\Add_EmployeeData.properties";
		Properties pr = new Properties();
		FileInputStream FI = new FileInputStream(path);
		pr.load(FI);
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("firstName"))).sendKeys(pr.getProperty("firstname"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("middleName"))).sendKeys(pr.getProperty("middlename"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("lastName"))).sendKeys(pr.getProperty("lastname"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[2]/div[1]/div[1]/div[2]/input[1]"))).sendKeys(Keys.CONTROL + "a" , Keys.DELETE);
		long time = System.currentTimeMillis();
		String timeStr = String.valueOf(time);
		String ID = timeStr.substring(timeStr.length() - 4);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[2]/div[1]/div[1]/div[2]/input[1]"))).sendKeys(ID);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']"))).click();

		//Logout Login After Signup
		
		/*wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/ul/li/span[@class='oxd-userdropdown-tab']/i"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/ul/li/ul/li[4]/a"))).click();
		*/
		Thread.sleep(5000);
		driver.quit();
	}
}
