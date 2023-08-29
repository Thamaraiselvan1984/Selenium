package ExtentReports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


// Implementing Extentreport and adding TESTS and opening reports in browser

public class Chapter3 {
	
	public static void main(String[] args) throws Exception {
		ExtentReports extentreports = new ExtentReports();
		File file = new File("report.html");
		ExtentSparkReporter sparkreporter = new ExtentSparkReporter("report.html");
		extentreports.attachReporter(sparkreporter);
		
		ExtentTest test1 = extentreports.createTest("TEST 1");
		test1.pass("This is passed");
		
		ExtentTest test2 = extentreports.createTest("TEST 2");
		test2.log(Status.FAIL, "This is failed");
		
		extentreports.createTest("TEST 3").skip("This is skipped");
		
		extentreports.flush();
		Desktop.getDesktop().browse(new File("report.html").toURI());
	}

}
