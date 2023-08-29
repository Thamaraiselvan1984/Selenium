package TestNG.ExtentReports;

import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

public class BaseTest
{ 
	String ScreenshotSubFolderName;
    public static WebDriver driver;
    public static ExtentReports extentReports;
    public static ExtentTest ExtentTest;
    
    @Parameters("browserName")
	@BeforeTest
	public void setup(ITestContext context, @Optional("chrome") String browserName) throws Exception 
	{
		switch(browserName.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();           
			driver = new EdgeDriver();
			break;
		}
		driver.manage().window().maximize();
		Capabilities capabilities  = ((RemoteWebDriver)driver).getCapabilities();
		String device = capabilities.getBrowserName()+" "+capabilities.getVersion().substring(0,capabilities.getVersion().indexOf("."));
		String author = context.getCurrentXmlTest().getParameter("author");
		ExtentTest = extentReports.createTest(context.getName());
		ExtentTest.assignAuthor(author);
		ExtentTest.assignDevice(device);
		}
    
	@AfterTest
	public void teardown() 
	{
    driver.quit();
    }
	
	@BeforeSuite
    public void initialiseExtentReports() {
		
		ExtentSparkReporter sparkReporter_all = new ExtentSparkReporter("AllTests.html");
		ExtentSparkReporter sparkReporter_failed = new ExtentSparkReporter("FailedTests.html");
		sparkReporter_failed.filter().statusFilter().as(new Status[] {Status.FAIL}).apply();
		ExtentSparkReporter sparkReporter_skipandwarning = new ExtentSparkReporter("skipandwarningTests.html");
		sparkReporter_skipandwarning.filter().statusFilter().as(new Status[] {
				Status.SKIP,
				Status.WARNING
		}).apply();
		extentReports = new ExtentReports();
		extentReports.attachReporter(sparkReporter_all);
	}
	
	@AfterMethod
	public void CheckStatus(Method m, ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE) {
		String ScreenshotPath = null;
		ScreenshotPath = captureScreenShot(result.getTestContext().getName()+" "+result.getMethod().getMethodName()+".jpg");
		ExtentTest.addScreenCaptureFromPath(ScreenshotPath);
		ExtentTest.fail(result.getThrowable());
		}
		else if(result.getStatus()==ITestResult.SUCCESS) 
		{
			ExtentTest.pass(m.getName()+"is passed");
			}
		
		ExtentTest.assignCategory(m.getAnnotation(Test.class).groups());
		}
	
    public String captureScreenShot(String fileName)  
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
    	return destFile.getAbsolutePath(); 	
    	}
	
	@AfterSuite
    public void generateExtentReport() throws Exception {
		extentReports.flush();
		Desktop.getDesktop().browse(new File("AllTests.html").toURI());
		Desktop.getDesktop().browse(new File("FailedTests.html").toURI());
		Desktop.getDesktop().browse(new File("skipandwarningTests.html").toURI());
	}
}
