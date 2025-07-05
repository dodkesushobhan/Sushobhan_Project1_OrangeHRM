package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Program1 {
	@Test
	public void Method1() {
		// ID Locator
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dodke sushobhan j\\Downloads\\chromedriver-win64\\chromedriver-win64\\Chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//login webside
		driver.get("https://www.saucedemo.com/");
		WebElement username, password , loginbutton;
		username = driver.findElement(By.id("user-name"));
		password = driver.findElement(By.id("password"));
		loginbutton = driver.findElement(By.id("login-button"));
		username.sendKeys("standard_user");
		password.sendKeys("secret_sauce");
		loginbutton.click();
		
		//Add product to cart
		WebElement addtocart;
		addtocart = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
		addtocart.click();
		
//ClassName locator
		
		//open cart
		driver.findElement(By.className("shopping_cart_link")).click();
		//Checkout
		driver.findElement(By.id("checkout")).click();
/*//tag name locator
		List<WebElement> inputtags = driver.findElements(By.tagName("input"));
		System.out.println(inputtags.size());*/
		
		WebElement firstname , lastname, postcode;
		firstname = driver.findElement(By.id("first-name"));
		lastname = driver.findElement(By.id("last-name"));
		postcode = driver.findElement(By.id("postal-code"));
		
		firstname.sendKeys("sushobhan");
		lastname.sendKeys("dodke");
		postcode.sendKeys("413520");
		
		//continue shopping and finish
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("finish")).click();
		
		WebElement finalmsg;
		finalmsg = driver.findElement(By.tagName("h2"));
		System.out.println(finalmsg.getText());
		
		
		
		
		
	}

}
