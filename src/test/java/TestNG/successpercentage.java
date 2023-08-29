package TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;
import java.util.Properties;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.lang.reflect.Method;

public class successpercentage {
	int count=1;
	
  @Test(invocationCount = 50, successPercentage=50, invocationTimeOut = 1000, threadPoolSize = 3)
  public void testng1() {
	  if(count==2)
	  {
		  assertTrue(true);
	  }
	  count++;
      Method methodName = new Object(){}.getClass().getEnclosingMethod();
      System.out.println("Method name is :" +methodName); 
		 }
}