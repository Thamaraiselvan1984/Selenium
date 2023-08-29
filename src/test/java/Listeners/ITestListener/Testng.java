package Listeners.ITestListener;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;


@Listeners(ListenerTestng.class)
public class Testng {

	WebDriver driver;
	
	private int i = 1;
	
	//success test
	@Test (priority = 4)
	public void CloseBrowser() 
	{
		driver.close();
		Reporter.log("Driver closed after testing");
	}
	
	
	//Fail Test
	@Test (priority = 2)
	public void OpenBrowser() throws InterruptedException 
	{	
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		String ExpectedTitle = "GO Google";
		String OriginalTitle = driver.getTitle();
		Assert.assertEquals(ExpectedTitle, OriginalTitle, "Title of the webpage do not match");
		}
	
	//failing with success
	
	@Test (successPercentage = 60, invocationCount = 3, priority = 1)
	public void AccountTest() {
		if(i<2)
		Assert.assertEquals(i, i);
		i++;
	}
	
	@Test (priority = 3)
	public void skipTest() {
		
		throw new SkipException("Skipping the method test");
	}
	
}
