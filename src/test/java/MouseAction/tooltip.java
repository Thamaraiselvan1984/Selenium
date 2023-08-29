package MouseAction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Interaction;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;

public class tooltip {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Downloads\\selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/");
		driver.manage().window().maximize();
		
		Thread.sleep(3000);
	    Actions actions = new Actions(driver);
		WebElement hover = driver.findElement(By.id("selenium_webdriver"));
		actions.moveToElement(hover).build().perform();
		String tooltipText = hover.getAttribute("data-name");
		System.out.println("toopTipText---->" +tooltipText);
		if(tooltipText.equalsIgnoreCase("Selenium WebDriver"))
		{ 
			System.out.println("Pass : Tooltip matching expected value");
		}
		else
		{
			System.out.println("Fail : Tooltip NOT matching expected value"); 
		}		
	}

}
