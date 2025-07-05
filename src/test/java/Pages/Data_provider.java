package Pages;

import org.testng.annotations.DataProvider;

public class Data_provider {

	@DataProvider(name = "DP")
	public Object[][] LoginData()
	{
		Object[][] data = new Object[1][2];
		data[0][0] = "Admin";
		data[0][1] = "admin123";
		
		//data[1][0] = "Admin123";
		//data[1][1] = "admin123456";
		return data;
	}
}
