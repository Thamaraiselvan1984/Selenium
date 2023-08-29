package ExtentReports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.github.bonigarcia.wdm.WebDriverManager;

// System/Environment Configuration information

public class Chapter9 {

	public static void main(String[] args) throws Exception {
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		Capabilities capabilities  = ((RemoteWebDriver)driver).getCapabilities();
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
	
		extentReports.setSystemInfo("os", System.getProperty("os.name"));
		extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
		extentReports.setSystemInfo("Browser", capabilities.getBrowserName()+" "+capabilities.getVersion());
		extentReports.setSystemInfo("url", "https://www.amazon.com");
		extentReports.setSystemInfo("UserName", "selvan.84@gmail.com");
		extentReports.setSystemInfo("Password", "*****");
		
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
			.createTest("Test 2")
			.assignAuthor("THAMARAISELVAN")
			.assignDevice("edge")
			.assignCategory("Regression")
			.pass("The Test is passed");
		 
	   extentReports
			.createTest("Test 4", "Test Desc")
			.assignAuthor("THAMARAISELVAN","SUBHA")
			.assignDevice(new String[]{"chrome","edge"})
			.assignCategory(new String[] {"Regression","smoke", "sanity"})
			.pass("The Test is passed");
		
		extentReports.flush();
		driver.quit();
		Desktop.getDesktop().browse(new File("report.html").toURI());

	}
}
