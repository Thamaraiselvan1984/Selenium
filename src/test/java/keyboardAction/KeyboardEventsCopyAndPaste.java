package keyboardAction;

import static org.junit.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyboardEventsCopyAndPaste {

	public static void main(String[] args) throws InterruptedException 
	{	
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/text-box");
		driver.manage().window().maximize();
		WebElement fullname =  driver.findElement(By.id("userName"));
		fullname.sendKeys("THAMARAI SELVAN");
		WebElement email = driver.findElement(By.id("userEmail"));
		email.sendKeys("selvan.84@gmail.com");
		WebElement CurrentAddress = driver.findElement(By.id("currentAddress"));
		CurrentAddress.sendKeys("chennai");
		Thread.sleep(1000);
		CurrentAddress.sendKeys(Keys.CONTROL);
		CurrentAddress.sendKeys(("A"));
		Thread.sleep(1000);
		CurrentAddress.sendKeys(Keys.CONTROL);
		CurrentAddress.sendKeys(("C"));
		CurrentAddress.sendKeys(Keys.TAB);
		WebElement permanentAddress=driver.findElement(By.id("permanentAddress"));
		permanentAddress.sendKeys(Keys.CONTROL);
		permanentAddress.sendKeys(("V"));
		assertEquals(CurrentAddress.getAttribute("value"),permanentAddress.getAttribute("value"));
	}

}
