package ExtentReports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;
import com.aventstack.extentreports.reporter.configuration.Theme;

// Theme Configuration change

public class Chapter8 {

	public static void main(String[] args) throws Exception {
		ExtentReports extentReports = new ExtentReports();
		File file = new File("report.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
		ExtentSparkReporterConfig config = sparkReporter.config();
	    //config.setTheme(Theme.STANDARD);
	    //config.setReportName("Report Name");
		//config.setDocumentTitle("Doc Title");
		//config.setTimeStampFormat("MMMM dd, yyyy HH:mm:ss");
		//config.setCss(".badge-primary{background-color:#da0b2b}");
     	//config.setJs("document.getElementsByClassName('logo')[0].style.display='none';");
		
	     //sparkReporter.loadJSONConfig(new File("C:\\Users\\Admin\\eclipse-workspace\\SeleniumJava\\src\\test\\resources\\configfiles\\extent-reports-config.json"));
	
	     sparkReporter.loadXMLConfig(new File("C:\\Users\\Admin\\eclipse-workspace\\SeleniumJava\\src\\test\\resources\\configfiles\\extentreportsconfig.xml"));
		
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
