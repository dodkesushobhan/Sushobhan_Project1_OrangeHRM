package day18Gridpractice;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class Amazon {

	@Test
	public void Runedge() throws MalformedURLException
	{
		@SuppressWarnings("deprecation")
		Date dt = new Date(0, 0, 0);
		 System.out.println("date Amazon : " + dt.toString());
		 DesiredCapabilities dc = new DesiredCapabilities();
		 dc.setBrowserName("firefox");
		
		 WebDriver driver = new RemoteWebDriver(new URL("http://192.168.1.196:4444"),dc);
		 driver.manage().window().maximize();
		 driver.get("https://www.amazon.com");
		 System.out.println("Amazon title : "+ driver.getTitle());
		 driver.quit();
	}
}
