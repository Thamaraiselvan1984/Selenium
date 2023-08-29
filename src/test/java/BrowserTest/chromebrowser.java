package BrowserTest;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import java.time.Duration;


public class chromebrowser {
  @Test
  public void firsttest() {
      WebDriverManager.chromedriver().setup();
	  WebDriver driver = new ChromeDriver();
      String baseUrl = "https://www.toolsqa.com/";
      driver.get(baseUrl);
	  driver.manage().window().maximize();
	  System.out.println("Launching google chrome browser");
	  String testTitle = "Tools QA";
	  String originalTitle = driver.getTitle();
	  Assert.assertEquals(originalTitle,testTitle);
  }
	
@BeforeMethod
  public void beforeMethod() {
	  System.out.println("Starting Test on Chrome Browser");	  
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("Finished Test on Chrome Browser");
  }
}
