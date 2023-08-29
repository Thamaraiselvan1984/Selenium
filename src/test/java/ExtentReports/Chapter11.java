package ExtentReports;

import java.awt.Desktop;
import java.io.File;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


// Creating Multiple report

public class Chapter11 
{
	public static void main(String[] args) throws Exception {
		ExtentReports extentReports = new ExtentReports();		
		ExtentSparkReporter sparkReporter_all = new ExtentSparkReporter("AllTests.html");
		
		ExtentSparkReporter sparkReporter_failed = new ExtentSparkReporter("FailedTests.html");
		sparkReporter_failed.filter().statusFilter().as(new Status[] {Status.FAIL}).apply();
		
		ExtentSparkReporter sparkReporter_skipandwarning = new ExtentSparkReporter("skipandwarningTests.html");
		sparkReporter_skipandwarning.filter().statusFilter().as(new Status[] {
				Status.SKIP,
				Status.WARNING
		}).apply();
			extentReports.attachReporter(sparkReporter_all,sparkReporter_failed,sparkReporter_skipandwarning);
		 
	     
		 extentReports
		.createTest("Test 1")
		.assignAuthor("THAMARAISELVAN")
		.assignCategory("smoke")
		.assignDevice("chrome")
		.pass("The Test is passed");
		
		 extentReports
		.createTest("Test 2")
		.assignAuthor("THAMARAISELVAN")
		.assignCategory("Regression")
		.assignDevice("FireFox")
		.fail("The Test is failed");
		
		 extentReports
			.createTest("Test 3")
			.assignAuthor("THAMARAISELVAN")
			.assignDevice("edge")
			.assignCategory("Regression")
			.skip("skipped");
		 
	        Throwable t = new RuntimeException("This is a custom exception");	
			extentReports
			.createTest("Exception test4")
			.fail(t);
		 
	   extentReports
			.createTest("Test 5", "Test Desc")
			.assignAuthor("THAMARAISELVAN","SUBHA")
			.assignDevice(new String[]{"chrome","edge"})
			.assignCategory(new String[] {"Regression","smoke", "sanity"})
			.pass("The Test is passed");
			
		extentReports.flush();
		Desktop.getDesktop().browse(new File("AllTests.html").toURI());
		Desktop.getDesktop().browse(new File("FailedTests.html").toURI());
		Desktop.getDesktop().browse(new File("skipandwarningTests.html").toURI());
		
    }
}
