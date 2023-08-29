package com.qa.Testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.qa.TestRailManager.TestRailManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class basetest {
	
	public static WebDriver driver;
	
	public static String testCaseID;
	
	@Parameters({"url", "browser"})
	@BeforeTest
	public void setup(String url, String browserName) {
		System.out.println("Launching Browser:" + browserName);
		if(browserName.equalsIgnoreCase("chrome"))
		{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		}
		else
		{
		System.out.println("Please pass the correct Browser Name..."+ browserName);
		}
	driver.get(url);
	driver.manage().window().maximize();
	}
		
	@AfterTest
	public void teardown() {
		driver.quit();
	}
	
	
	@AfterMethod
	public void addTestResultstoTestRail(ITestResult result){
		
		if(result.getStatus() == ITestResult.SUCCESS)
		{
			
			TestRailManager.addResultsforTestCase(testCaseID, TestRailManager.TEST_CASE_PASS_STATUS, "");
		}
		else if(result.getStatus()==ITestResult.FAILURE)
		{	
			TestRailManager.addResultsforTestCase(testCaseID, TestRailManager.TEST_CASE_FAIL_STATUS, "Test got failed..."+ result.getTestName() + ":FAILED");
			
		}
	}
}
