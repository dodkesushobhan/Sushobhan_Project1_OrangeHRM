package dataProvider_Pactice;

import org.testng.annotations.Test;

public class NewTest {
  @Test(dataProvider="datap2" ,dataProviderClass=DP2.class)
  public void test2(int name , int surname) {
	  System.out.println(name + " " + surname);
  }
}
