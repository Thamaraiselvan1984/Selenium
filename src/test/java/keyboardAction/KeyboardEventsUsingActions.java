package keyboardAction;

import static org.junit.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyboardEventsUsingActions {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/text-box");
		driver.manage().window().maximize();
		
		Actions action = new Actions(driver);
		WebElement fullname =  driver.findElement(By.id("userName"));
		fullname.sendKeys("THAMARAI SELVAN");
		WebElement email = driver.findElement(By.id("userEmail"));
		email.sendKeys("selvan.84@gmail.com");
		WebElement CurrentAddress = driver.findElement(By.id("currentAddress"));
		CurrentAddress.sendKeys("chennai");
		
		action.keyDown(Keys.CONTROL);
		action.sendKeys("a");
		action.keyUp(Keys.CONTROL);
		action.build().perform();
		
		
		action.keyDown(Keys.CONTROL);
		action.sendKeys("c");
		action.keyUp(Keys.CONTROL);
		action.build().perform();
		
		action.sendKeys(Keys.TAB);
		action.build().perform();
		
		action.keyDown(Keys.CONTROL);
		action.sendKeys("V");
		action.keyUp(Keys.CONTROL);
		action.build().perform();
		
		WebElement permanentAddress=driver.findElement(By.id("permanentAddress"));
		assertEquals(CurrentAddress.getAttribute("value"),permanentAddress.getAttribute("value"));
		}
}
