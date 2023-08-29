package base;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Properties;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class basetest {

	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static FileReader fr;
	public static String ScreenshotSubFolderName;
	
	@BeforeTest(alwaysRun=true)
    public void setup() throws IOException, InterruptedException {
    	if(driver==null) 
        {
    	FileReader fr = new FileReader("C:\\Users\\Admin\\eclipse-workspace\\SeleniumJava\\src\\test\\resources\\configfiles\\config.properties");
    	prop.load(fr);
    	}
    	if(prop.getProperty("browser").equalsIgnoreCase("chrome"))
        {    	
    	WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(prop.getProperty("testurl"));
		driver.manage().window().maximize();
		}
    else if(prop.getProperty("browser").equalsIgnoreCase("edge"))
    {
    	WebDriverManager.edgedriver().setup();
    	driver = new EdgeDriver();
    	driver.get(prop.getProperty("testurl"));
    	driver.manage().window().maximize();
    	}
    }
	@AfterTest(alwaysRun=true)
    public void teadDown() throws IOException {
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

