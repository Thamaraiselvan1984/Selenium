package MouseAction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Rightclickdemo {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications");
		driver.get("https://demoqa.com/buttons");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		Actions actions = new Actions(driver);
		WebElement dbclick = driver.findElement(By.id("doubleClickBtn"));
		actions.doubleClick(dbclick).build().perform();
		System.out.println("double click alert accepted");
		Thread.sleep(2000);
		WebElement rtclick = driver.findElement(By.xpath("//*[@id=\"rightClickBtn\"]"));
		actions.contextClick(rtclick).perform();
		System.out.println("Right click alert accepted");
		Thread.sleep(2000);
		}
}
