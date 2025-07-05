package dataProvider_Pactice;

import org.testng.annotations.DataProvider;

public class DP2 {

	@DataProvider(name = "datap2")
	public Integer[][] senddata1()
	{
		Integer[][] data = new Integer[3][2];
		data[0][0]= 1;
		data[0][1]= 2;
		
		data[1][0] =3;
		data[1][1]= 4;
		
		data[2][0] =5;
		data[2][1]= 6;
		
		return data;
	}
	
}
