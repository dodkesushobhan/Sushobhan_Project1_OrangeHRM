package dataProvider_Pactice;

import org.testng.annotations.DataProvider;

public class DP {

		@DataProvider(name = "DP1")
		public Object[][] getdata1()
		{
			Object[][] data = new Object[4][2];
			data[0][0] = "Virat";
			data[0][1] = 23;
			
			data[1][0] = "Rohit";
			data[1][1] = 25;
			
			data[2][0] = "Shubham";
			data[2][1] = 19;
			
			data[3][0] = "Jedeja";
			data[3][1] = 28;
			return data;
		}
}
