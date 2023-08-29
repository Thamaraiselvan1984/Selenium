package ExtentReports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.lang.String;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;

//Screenshot capturing

public class Chapter6 
{
	    static WebDriver driver;
	    public static void main(String[] args) throws Exception {
		ExtentReports extendReports = new ExtentReports();
		File file = new File("reportscreenshot.html");
		ExtentSparkReporter sparkreport = new ExtentSparkReporter("reportscreenshot.html");
		extendReports.attachReporter(sparkreport);
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		String base64Code = CaptureScreenShot();
		String path = CaptureScreenShot("Google.jpg");
		
		extendReports
		.createTest("Screenshot Test1","Attached is the screenshots in Test level")
		.info("This is a Info message")
		.addScreenCaptureFromBase64String(base64Code);
		
		extendReports
		.createTest("Screenshot Test2","Attached is the screenshots in Test level")
		.info("This is a Info message")
		.addScreenCaptureFromBase64String(base64Code, "Google homepage");
		
		extendReports
		.createTest("Screenshot Test3","Attached is the screenshots in Test level")
		.info("This is a Info message")
		.addScreenCaptureFromBase64String(base64Code, "Google homepage1")
		.addScreenCaptureFromBase64String(base64Code, "Google homepage2")
		.addScreenCaptureFromBase64String(base64Code, "Google homepage3")
		.addScreenCaptureFromBase64String(base64Code, "Google homepage4");
		
		
		extendReports
		.createTest("Screenshot Test4","Attached is the screenshots in Test level")
		.info("This is a Info message")
		.addScreenCaptureFromPath(path);
		
		extendReports
		.createTest("Screenshot Test5","Attached is the screenshots in Test level")
		.info("This is a Info message")
		.addScreenCaptureFromPath(path, "Google homepage");
		
		extendReports
		.createTest("Screenshot Test6","Attached is the screenshots in Test level")
		.info("This is a Info message")
		.addScreenCaptureFromPath(path, "Google homepage1")
		.addScreenCaptureFromPath(path, "Google homepage2")
		.addScreenCaptureFromPath(path, "Google homepage3")
		.addScreenCaptureFromPath(path, "Google homepage4")
		.addScreenCaptureFromPath(path, "Google homepage5");
		
		extendReports
		.createTest("Screenshot Test7","Attached is the screenshots in Test level")
		.info("This is a Info message")
		.fail(MediaEntityBuilder.createScreenCaptureFromBase64String(base64Code).build())
		.fail(MediaEntityBuilder.createScreenCaptureFromBase64String(base64Code, "Google homepage").build());
		
		extendReports
		.createTest("Screenshot Test8","Attached is the screenshots in Test level")
		.info("This is a Info message")
		.fail(MediaEntityBuilder.createScreenCaptureFromPath(path).build())
		.fail(MediaEntityBuilder.createScreenCaptureFromPath(path, "Google homepage").build());
		
		extendReports
		.createTest("Screenshot Test9","Attached is the screenshots in Test level")
		.info("This is a Info message")
		.fail("This is a Info message", MediaEntityBuilder.createScreenCaptureFromBase64String(base64Code).build())
		.fail("This is a Info message", MediaEntityBuilder.createScreenCaptureFromBase64String(base64Code, "Google homepage").build());
		
		
		extendReports
		.createTest("Screenshot Test10","Attached is the screenshots in Test level")
		.info("This is a Info message")
		.fail("This is a Info message", MediaEntityBuilder.createScreenCaptureFromPath(path).build())
		.fail("This is a Info message", MediaEntityBuilder.createScreenCaptureFromPath(path, "Google homepage").build());
		
		Throwable t = new Throwable("This is Throwable exception");
		extendReports
		.createTest("Screenshot Test11","Attached is the screenshots in Test level")
		.info("This is a Info message")
		.fail(t, MediaEntityBuilder.createScreenCaptureFromBase64String(base64Code).build())
		.fail(t, MediaEntityBuilder.createScreenCaptureFromBase64String(base64Code, "Google homepage").build());
		
		extendReports
		.createTest("Screenshot Test12","Attached is the screenshots in Test level")
		.info("This is a Info message")
		.fail(t, MediaEntityBuilder.createScreenCaptureFromPath(path).build())
		.fail(t, MediaEntityBuilder.createScreenCaptureFromPath(path, "Google homepage").build());
		
		
		
		extendReports.flush();
		driver.quit();
		Desktop.getDesktop().browse(new File("reportscreenshot.html").toURI());
	}
	
	public static String CaptureScreenShot() 
	{
    TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
	String base64Code = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
    System.out.println("Screenshot saved Sucessfully");
	return base64Code;
	}
	public static String CaptureScreenShot(String fileName) 
	{
    TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
	File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    File destFile = new File("C:\\Users\\Admin\\eclipse-workspace\\SeleniumJava\\src\\test\\resources\\logs\\screenshot"+fileName);
	try {
		FileUtils.copyFile(sourceFile, destFile);
	} catch (IOException e) {
		e.printStackTrace();
	}
	System.out.println("Screenshot saved Sucessfully");
	return destFile.getAbsolutePath();
	}
}

