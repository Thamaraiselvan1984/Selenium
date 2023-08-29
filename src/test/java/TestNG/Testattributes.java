package TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testattributes 
{
        @Test(timeOut=5000)
	    public void Testmethod1() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Downloads\\selenium\\chromedriver_win32\\chromedriver.exe");
    	WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.quit();
        }	
	}
