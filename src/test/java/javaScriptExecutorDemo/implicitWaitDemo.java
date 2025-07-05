package javaScriptExecutorDemo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class implicitWaitDemo {
	
	public static void main(String args[])
	{
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.google.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		
		driver.findElement(By.name("q")).sendKeys("facebook");

		String txt = driver.findElement(By.xpath("(//span[text()='facebook'])[1]")).getText();
		System.out.println("txt : " + txt);
		driver.findElement(By.xpath("(//div[@class='lnnVSe'])[1]")).click();
		driver.findElement(By.xpath("(//div[1]/a/div[1]/span)[12]")).click();
		
//		driver.quit();
	}
}
