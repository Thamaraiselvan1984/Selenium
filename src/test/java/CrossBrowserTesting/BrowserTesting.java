package CrossBrowserTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserTesting 
{
	WebDriver driver;
	
@Parameters("browser")
@BeforeTest
public void beforeTest(String browser)
{	
	switch(browser.toLowerCase()) {
	case "chrome":
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		break;
	case "edge":
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		break;
	}
	driver.manage().window().maximize();
}

@Parameters("url")
@Test
public void launchapp(String url)
{
	driver.get(url);
}

@Test 
public void search()
{
	
	driver.findElement(By.name("q")).sendKeys("browser testing", Keys.ENTER);
	
}

@AfterTest
public void afterTest() {
	
	driver.quit();
}
}

	



