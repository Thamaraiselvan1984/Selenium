package TestNG;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class assertion
{
@Test
	public static void FACEBOOK() throws InterruptedException {
	System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Downloads\\selenium\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https:www.facebook.com");
	driver.manage().window().maximize();
	driver.findElement(By.id("email")).sendKeys("HYD second", Keys.ENTER);
	Thread.sleep(3000);
	
	//Hard Assertion & Soft Assertion
	
	SoftAssert softAssert = new SoftAssert();
	//Title Assertion 
	String ExpectedTitle = "Log in to Facebook";
	String ActualTitle = driver.getTitle();
	assertEquals(ActualTitle, ExpectedTitle, "Title is mismatched");
    //URL Assertion
	String ExpectedURL = "https:www.facebook.com/";
	String ActualURL = driver.getCurrentUrl();
	softAssert.assertNotEquals(ActualURL, ExpectedURL, "URL is mismatched");
	//Text Assertion
	String ExpectedText = "";
	String ActualText = driver.findElement(By.name("email")).getAttribute("Value");
	softAssert.assertEquals(ActualText, ExpectedText, "Username text is mismatched");
	//Border Assertion
	String ActualBorder = driver.findElement(By.name("email")).getCssValue("border");
    String ExpectedBorder = "1px solid rgb(240, 40, 73)";
    softAssert.assertEquals(ActualBorder, ExpectedBorder, "Username border is mismatched");
    //Error Assertion
    String ActualErrorMessage = driver.findElement(By.xpath("//div[@class='_9ay7']")).getText();
    String ExpectedErrorMessage = "The email address or mobile number you entered isn't connected to an account. Find your account and log in.";
    softAssert.assertEquals(ActualErrorMessage, ExpectedErrorMessage, "Error message is mismatched");
    driver.quit();
    softAssert.assertAll();
   }
}
