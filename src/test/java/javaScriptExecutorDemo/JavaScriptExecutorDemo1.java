package javaScriptExecutorDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutorDemo1 {

	public static void main(String args[])
	{
		System.setProperty("webdriver.chrome.driver", "/GridDemo/Node1/chromedriver-win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");
		driver.manage().window().maximize();
		
//		WebDriver driver = new ChromeDriver();
		driver.get("https://www.letskodeit.com/practice");
		driver.manage().window().maximize();
		
												
		
	}
}
