package TestNG;


import org.testng.annotations.Ignore;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.internal.Utils;

import Listeners.IListenerclass;


@Listeners(IListenerclass.class)
public class NewTest {
  
  
  @Test(priority =1)
  public void firsttest() {
	  	System.out.println("This is NewTest - first test");
  }
 
  @Test(groups= "regression")
  public void secondtest() {
	  	System.out.println("This is NewTest - second  test");
}
 
  @Test(groups= "smoke")
  public void thirdtest() {
	  	System.out.println("This is NewTest - third  test");
  }
 
  @Test(timeOut=1000)
  public void fourthtest() throws InterruptedException {
	  Thread.sleep(3000);
		  	System.out.println("This is NewTest - Forth  test");
  
}
  
 }