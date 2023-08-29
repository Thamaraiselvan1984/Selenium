package TestNG;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.*;

public class BrowserSelection {
	
	static WebDriver driver;

	public static WebDriver usingChrome()
	{
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\selenium\\chromedriver_win32\\chromedriver.exe"); 
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	return driver;
	}  
}
