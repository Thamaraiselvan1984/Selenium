package TestNG;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class popupwindow extends AppTestBase {

	@Test
	public void clickElement() throws Exception 
	{
		 driver.get("https://www.makemytrip.com");
		 
         String mainwindow = driver.getWindowHandle();
         System.out.println("parent window " + mainwindow);
         Thread.sleep(10000);     
         driver.findElement(By.id("webklipper-publisher-widget-container-notification-frame")).click();
         Set<String> handles = driver.getWindowHandles();
        
         for (String handle : handles) 
         {
        	 System.out.println(handle);     	 
        	 if(!handle.equals(mainwindow)) {
        		 driver.switchTo().window(handle);
        		 Thread.sleep(2000);
        		 driver.close();
        	 }
        	 driver.switchTo().window(mainwindow);
         }
        
         }
	
	}