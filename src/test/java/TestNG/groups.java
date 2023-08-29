package TestNG;


import org.openqa.selenium.interactions.Actions;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.basetest;


public class groups extends basetest
{
	
	@Test(groups="demo1")
    public void checkTitle() throws InterruptedException
  {
      
	  String testTitle = "MakeMyTrip - #1 Travel Website 50% OFF on Hotels, Flights & Holiday";	
	  String originalTitle = driver.getTitle();
	  Assert.assertEquals(originalTitle,testTitle);
	  System.out.println("The title is : " + originalTitle);
	  }
  
  @Test(groups = "demo2")
  public void clickElement() throws InterruptedException
  { 
	  
	  String mainwindow = driver.getWindowHandle();
	  driver.findElement(By.id("webklipper-publisher-widget-container-notification-frame")).click();
	  Set<String> handles = driver.getWindowHandles();
	  for(String handle : handles) {
		  if(!handle.equals(mainwindow)) {
			  driver.switchTo().window(handle);
			  Thread.sleep(2000);
			  driver.close();
		  }
		  driver.switchTo().window(mainwindow);
		  Thread.sleep(2000);
	  }
	  Actions action = new Actions(driver);
	  WebElement element = driver.findElement(By.className("ic_circularclose_grey"));
	  action.moveToElement(element).build().perform();
	  element.click();
	  Thread.sleep(2000);
			}
		}