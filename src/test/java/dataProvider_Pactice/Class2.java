package dataProvider_Pactice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Class2 {

	@Test
	public void test1()
	{
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.flipcard.com");
	}
	
	@Test
	public void test2()
	{
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");
	}
}
