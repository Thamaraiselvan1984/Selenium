package waits;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import dev.failsafe.Timeout;

public class fluentwait {

	public static void main(String[] args) throws InterruptedException
	{
		   System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\selenium\\chromedriver_win32\\chromedriver.exe");
	       final WebDriver driver = new ChromeDriver();
	       driver.get("https://www.google.com");
	       driver.manage().window().maximize();
	       driver.findElement(By.name("q")).sendKeys("selenium");
	       Thread.sleep(2000);
	       driver.findElement(By.name("btnK")).click();
	       
	       Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).
           withTimeout(Duration.ofSeconds(30))
           .pollingEvery(Duration.ofSeconds(2))
           .ignoring(NoSuchElementException.class);
	       
	       WebElement element = (WebElement) wait.until(new Function<WebDriver, WebElement>()
	       {
	         public WebElement apply(WebDriver arg0) {
	    		WebElement linkelement = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div/div[1]/a/h3"));
	    		   if(linkelement.isEnabled())
	    		   {
	    			   System.out.println("Element is Found");
	    		   }
	    		   return linkelement;
	    	   }
	       });
		element.click();
	}
	}


