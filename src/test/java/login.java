
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.Test;

import base.basetest;

public class login extends basetest
{
	@Test
	public static void LoginTest() throws InterruptedException 
	{	    
	    Thread.sleep(4000);
	    driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
	    driver.findElement(By.id("ap_email")).sendKeys("selvan.84@gmail.com");
	    driver.findElement(By.id("continue")).click();
	    Thread.sleep(4000);
	    driver.findElement(By.id("ap_password")).sendKeys("Thamu@123");
	    driver.findElement(By.className("a-button-inner")).click();
	    System.out.println("amazon logged in sucessfully");
	    
	}
}