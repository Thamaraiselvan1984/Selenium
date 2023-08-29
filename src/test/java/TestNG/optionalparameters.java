package TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


public class optionalparameters {
    @Parameters({"browser","skill"})
	@Test
	public void TestNGOptionalParameter(@Optional("Chrome")String browser, String skill)
       {
    	System.out.println("The Parameter is : "+browser+":"+skill);
  }
}
