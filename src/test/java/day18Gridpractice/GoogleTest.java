package day18Gridpractice;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class GoogleTest {
	@Test
	public void run() throws MalformedURLException
	{
		Date dt = new Date(0);
		 System.out.println("date google : " + dt.toString());
		 DesiredCapabilities dc = new DesiredCapabilities();
		 dc.setBrowserName("edge");
		 WebDriver driver = new RemoteWebDriver(new URL("http://192.168.43.207:4444"),dc);
		 
		 driver.get("https://www.google.com");
		 driver.manage().window().maximize();
		 System.out.println("Google title : "+ driver.getTitle());
		 driver.quit();
	}
}
