package com.qa.Testcases;

import org.openqa.selenium.By;

import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenCartTest extends basetest{
	
	@Test
	public void logoTest() {
		
		testCaseID = "10";
		System.out.println("open cart - logo test");
		boolean flag = driver.findElement(By.cssSelector("img[title='naveenopencart']")).isDisplayed();
		Assert.assertEquals(flag, true);
	}
	
	
	@Test
	public void forgotpasswordlink() {
		testCaseID = "11";
		System.out.println("open cart - forgot password test");
		Assert.assertTrue(driver.findElement(By.linkText("Forgotten Password")).isDisplayed());
	}
}
