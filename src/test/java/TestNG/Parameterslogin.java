package TestNG;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Parameterslogin {
    WebDriver driver;
    @Parameters("browserName")
	@BeforeTest
	public  void  InitialBrower(String browserName)
    {
		switch(browserName.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver();
			break;
		case "safari":
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
			break;
		}
		driver.manage().window().maximize();
}
    @Parameters("url")
    @Test
    public void Launchapp(String url) {
    	driver.get(url);
    }

    @Parameters({"userName", "password"})
    @Test
    
    public void EnterloginDetails(String userName, String password) throws InterruptedException {
    	driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
	    driver.findElement(By.id("ap_email")).sendKeys(userName);
	    driver.findElement(By.id("continue")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.id("ap_password")).sendKeys(password);
	    driver.findElement(By.className("a-button-inner")).click();
	    } 
    
    @Test
    public void customerservice() 
    {
    driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[3]")).click();
    }
    
    @AfterSuite
    public void teardown() {
    	driver.quit();
    }
}

       
    
    
    
    

