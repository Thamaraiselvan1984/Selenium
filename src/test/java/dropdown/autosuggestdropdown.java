package dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class autosuggestdropdown {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
    	ChromeOptions op = new ChromeOptions();
    	op.addArguments("--disable--Notifications");
    	driver.get("https://www.foundit.in/seeker/registration");
    	driver.manage().window().maximize();
    	driver.findElement(By.xpath("//*[@id=\"registerThemeDefault\"]/div/div[4]/div/div/div/form/div[2]/div[6]/div/div[1]/div/div[1]/span")).click();
    	WebElement from = driver.findElement(By.xpath("//*[@id=\"registerThemeDefault\"]/div/div[4]/div/div/div/form/div[2]/div[6]/div/div[1]/div/div[1]/input"));
    	from.sendKeys("Chennai");
    	Thread.sleep(3000);
    	from.sendKeys(Keys.ARROW_DOWN);
    	from.sendKeys(Keys.ENTER);
    	 
	}
}

