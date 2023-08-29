package TestNG;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import java.awt.AWTException;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.WebElement;
import base.basetest;

public class datepicker extends basetest
{
	
  @Test()
  public void tripDetails() throws InterruptedException, AWTException 
  {
	        String year = "2023";
            String month = "October";
            String date = "5";
            
            String mainwindow = driver.getWindowHandle();
	        Thread.sleep(5000);
	  	    driver.findElement(By.id("webklipper-publisher-widget-container-notification-frame")).click();
	  	    Set<String> handles = driver.getWindowHandles();
	  	    for(String handle : handles) {
	  		  if(!handle.equals(mainwindow)) {
	  			  driver.switchTo().window(handle);
	  			  Thread.sleep(3000);
	  			  driver.close();
	  			  }
	  	    }
	  		driver.switchTo().window(mainwindow);
	  		Thread.sleep(2000);
            
	        driver.findElement(By.className("ic_circularclose_grey")).click();
	        Thread.sleep(2000);
	        	        
	        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/label/span")).click();
			Thread.sleep(1000);
		    while(true)
		    {
		   	String monthyear = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[1]/div[1]/div")).getText();
		    String splitter[] = monthyear.split(" ");
		    String mon = splitter[0];
		    String yr = splitter[1];
		    if(mon.equals(month)&&yr.equals(year))
		    break;
		    else;
		    driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[1]/span[2]")).click();
		    Thread.sleep(1000);
		    }
 	 
		  List<WebElement> tr = driver.findElements(By.tagName("p"));
		  for(WebElement ele:tr)
		  {
			  String dt=ele.getText();
			  if(dt.equals(date))
			  {
				  ele.click();
				  break;
	             }
			  }
}
}