package waits;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class implicitwait {

	public static void main(String[] args) {
		   WebDriverManager.chromiumdriver().setup();
	       WebDriver driver = new ChromeDriver();	
	       String eTitle = "Demo Guru99 Page";
	       String aTitle = "";
	       driver.get("http://demo.guru99.com/test/guru99home/");
	       driver.manage().window().maximize();
	       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	       aTitle = driver.getTitle();
	       if (aTitle.equals(eTitle))
	       {
	    	   System.out.println("TEST PASSED");
	       }
	       else
	       {
	    	   System.out.println("Test Failed");
	       }
	    }
}