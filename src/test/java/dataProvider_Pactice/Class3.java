package dataProvider_Pactice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Class3 {

	@Test
	public void test3()
	{
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.mintra.com");
	}
	
	@Test
	public void test4()
	{
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.letskodeit.com");
	}
}
