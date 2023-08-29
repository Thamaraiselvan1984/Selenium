package ExtentReports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

// ADDING LOGS TO THE TESTS

public class Chapter4 
{	
	    public static void main(String[] args) throws Exception {
		ExtentReports extentreports = new ExtentReports();
		File file = new File("report.html");
		ExtentSparkReporter sparkreporter = new ExtentSparkReporter("report.html");
		extentreports.attachReporter(sparkreporter);
		
		extentreports
		.createTest("Test 1")
		.log(Status.INFO, "info1")
		.log(Status.INFO, "info2")
		.log(Status.PASS, "pass")
		.log(Status.WARNING, "warning")
		.log(Status.SKIP, "skip")
		.log(Status.FAIL, "Fail");
			
		extentreports.flush();
		Desktop.getDesktop().browse(new File("report.html").toURI());
	}

}
