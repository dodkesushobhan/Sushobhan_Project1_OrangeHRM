package dataProvider_Pactice;

import org.testng.annotations.Test;

public class class1 {
  @Test(dataProvider="DP1" , dataProviderClass= DP.class)
  public void test1(String name , int age) {
	  System.out.println(name + " = " + age);
  }
}
