package Pages;
// 3. Login page with new credentials which is created using PIM and Admin
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

public class Login_Page {

	WebDriver driver;
	WebDriverWait wait;
	@BeforeMethod
	public void openBrowser()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
	}
	@Test
	public void login() throws IOException, InterruptedException
	{
		String path = "E:\\Java\\Sushobhan_Project1_OrangeHRM\\src\\test\\resources\\Admin_userdata.properties";
		Properties pr = new Properties();
		FileInputStream file = new FileInputStream(path);
		pr.load(file);
		
		WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(10));
		WebElement user = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
		user.sendKeys(pr.getProperty("Username"));
		WebElement pass = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		pass.sendKeys(pr.getProperty("pass"));
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(5000);
		//driver.quit();
	}
}
