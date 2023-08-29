package TestNG;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

public class AppTestBase
{ 
	String ScreenshotSubFolderName;
    public WebDriver driver;
    
	@BeforeTest
	public void setup() throws Exception 
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@AfterTest
	public void teardown() {
		driver.quit();	
}
	
    public void CaptureScreenShot(String fileName)  
    {	
    	
		if(ScreenshotSubFolderName==null) {
    		
    		LocalDateTime myDateObj = LocalDateTime.now();
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");

            ScreenshotSubFolderName = myDateObj.format(myFormatObj);
        }
    	File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destFile = new File("C:\\Users\\Admin\\Downloads\\screenshot\\"+ ScreenshotSubFolderName+"/"+fileName);
    	try {
			FileUtils.copyFile(sourceFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
    	System.out.println("Screenshot saved Sucessfully");
    	}
}
