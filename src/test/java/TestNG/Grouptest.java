package TestNG;


import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.internal.Utils;



public class Grouptest {
  
  
  @Test(groups= "demo2")
  public void firsttest() {
	  	System.out.println("This is grouptest - first test");
  }
  
  @Test(groups="demo1")
  public void secondtest() {
	  	System.out.println("This is grouptest - second test");
}
  
  @Test(groups={"regression", "sanity"})
  public void thirdtest() {
	  	System.out.println("This is grouptest - third  test");
  }
  
  @Test
  public void fourthtest() {
		  	System.out.println("This is the Forth  test case");
  
}
}