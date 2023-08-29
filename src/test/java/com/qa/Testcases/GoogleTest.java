package com.qa.Testcases;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class GoogleTest extends basetest {
	
	@Test(priority = 1)
	public void titleTest() 
	{	
		testCaseID = "8";
		String title = driver.getTitle();
		System.out.println("page title:" + title);
		Assert.assertEquals(title, "Google");
		}
	
	@Test
	public void isSearchExist() {
		testCaseID = "9";
		boolean flag = driver.findElement(By.name("q")).isDisplayed();
		Assert.assertTrue(flag);
	}
	
}
