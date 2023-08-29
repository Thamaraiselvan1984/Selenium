package TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Parameters;

public class annotation {
  @Test(priority =2)
  public void Testcase1() {
	  System.out.println("This is a second priority test case");
  }
  
  @Test(priority =1)
  public void Testcase2() 
  {
	   System.out.println("This is the first priority test case");
	}
  	
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("this will execute before every method");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("This will execute after every method");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("this will execute before the class");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("this will execute after the class");
  }
  

  @BeforeTest
  public void beforeTest() {
	  System.out.println("this will execute before the test");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("this will execute after the test");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("This will execute before the Test Suite");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("This will execute after the Test Suite");
  }

}
