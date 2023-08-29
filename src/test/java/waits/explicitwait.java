package waits;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.webdriver.WebDriverBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class explicitwait {

	public static void main(String[] args) {
		   WebDriverManager.chromedriver().setup();
	       WebDriver driver = new ChromeDriver();
	       driver.get("http://seleniumpractise.blogspot.in/2016/08/how-to-use-explicit-wait-in-selenium.html");
	       driver.manage().window().maximize();
	       try
	       {
	       driver.findElement(By.xpath("//button[text()='Click me to start timer']")).click();
	       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	       WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='WebDriver']")));
	       boolean status = element.isDisplayed();
	       System.out.println("WebDriver is Visible");
	       }
	       catch (Exception e)
	       {
	    	   System.out.println("WebDriver is not Visible");
	       }	       
	}	
}
