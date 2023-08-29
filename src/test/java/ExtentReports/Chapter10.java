package ExtentReports;

import java.awt.Desktop;
import java.io.File;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;

// Changing the order of the report TAB

public class Chapter10 {

	public static void main(String[] args) throws Exception {
		ExtentReports extentReports = new ExtentReports();
		File file = new File("report.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
		sparkReporter.viewConfigurer().viewOrder().as(new ViewName[]{
				ViewName.DASHBOARD,
				ViewName.TEST,
				ViewName.EXCEPTION,
				ViewName.CATEGORY,
				ViewName.DEVICE,
		}).apply();
			
		extentReports.attachReporter(sparkReporter);
		
		
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
			.pass("The Test is passed");
		 
	   extentReports
			.createTest("Test 4", "Test Desc")
			.assignAuthor("THAMARAISELVAN","SUBHA")
			.assignDevice(new String[]{"chrome", "FireFox", "edge"})
			.assignCategory(new String[] {"Regression","smoke", "sanity"})
			.pass("The Test is passed");
		
		extentReports.flush();
		Desktop.getDesktop().browse(new File("report.html").toURI());

	}

}
