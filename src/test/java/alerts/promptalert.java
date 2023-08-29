package alerts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;

public class promptalert {

	public static void main(String[] args) throws InterruptedException 
	{
	WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    ChromeOptions opt = new ChromeOptions();
    opt.addArguments("--disable--notifications");
    driver.get("https://demoqa.com/alerts");
    driver.manage().window().maximize();
    Actions action = new Actions(driver);
    WebElement element = driver.findElement(By.id("promtButton"));
    action.moveToElement(element).build().perform();
    element.click();
    Alert promptalert = driver.switchTo().alert();
    String alertText = promptalert.getText();
    System.out.println ("Alert text is " + alertText);
    promptalert.sendKeys("THAMS");
    promptalert.accept();
    }
}
