package keyboardAction;

import static org.junit.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ContiguousKeyboardAction {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/text-box");
		driver.manage().window().maximize();
		Actions action = new Actions(driver);
		
		WebElement fullName = driver.findElement(By.id("userName"));
		fullName.sendKeys("Mr.Peter Haynes");
		WebElement email = driver.findElement(By.id("userEmail"));
		email.sendKeys("selvan.84@gmail.com");
		WebElement CurrentAddress = driver.findElement(By.id("currentAddress"));
		CurrentAddress.sendKeys("chennai");
		
		action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
        action.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();
        action.sendKeys(Keys.TAB).build().perform();
        action.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();
        
		WebElement permanentAddress=driver.findElement(By.id("permanentAddress"));
		assertEquals(CurrentAddress.getAttribute("value"),permanentAddress.getAttribute("value"));
		
	}

}
