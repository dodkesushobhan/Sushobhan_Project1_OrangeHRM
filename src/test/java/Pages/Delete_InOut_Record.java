package Pages;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Delete_InOut_Record {
	WebDriver driver, wait;
	@BeforeMethod
	public void openBrowser()
	{
		//System.setProperty("WebDriver.chrome.driver", "C:\\\\Users\\\\Dodke sushobhan j\\\\Downloads\\\\chromedriver-win64\\\\chromedriver-win64\\\\Chromedriver.exe");
		WebDriverManager.chromedriver().setup(); 
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
	}

	@Test(dataProvider="DP" , dataProviderClass= Data_provider.class)
	public void DRecord(String username , String password) throws IOException, InterruptedException
	{
		int num;
		 
		//login 
		WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(10));
		WebElement user = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
		user.sendKeys(username);
		WebElement pass = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		pass.sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		WebElement time = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Time']")));
		time.click();
		
		// Attendance and record
		WebElement attendance = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Attendance']")));
		attendance.click();
		driver.findElement(By.xpath("//a[text()='My Records']")).click();
		

			//WebElement recordsHeading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='orangehrm-horizontal-padding orangehrm-vertical-padding'] span[class='oxd-text oxd-text--span']")));
		
			// Text which include record count
			WebElement recordsHeading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[2]/div[1]/span[1]")));
			String recordsText = recordsHeading.getText();
			System.out.println("Text: " + recordsText); 
			// remove all string 
			String count = recordsText.replaceAll("[^0-9]", "");
			
			// Check for empty count string
			if(count != "")
			{	
			System.out.println("Number of records: " + count);
			num = Integer.parseInt(count);
			}
			else
			{
				num = 0;
			}
			
			try {
				if(num >=1)
				{
					//Delete record
					
					WebElement checkbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[1]/div/label/span")));
					checkbox.click();
					driver.findElement(By.xpath("//div/div[2]/div[2]/div/div/button")).click();
					driver.findElement(By.xpath("//div/div[3]/button[2]")).click();
				}
				else
				{
					System.out.println("No record found......");
				}
			}
			catch(Exception ex)
			{
				System.out.println(ex);
			}
			
			//After Exection need to capture screenshot
			Thread.sleep(10000);
			File sc = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String path = "E:\\Git repo\\Screeshot_using_selenium\\DeletedRecord_" + System.currentTimeMillis()+ ".jpg";
			File destination = new File(path);
			FileHandler.copy(sc, destination);
					
		
	}
}
