package RealTimeProject1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;


public class calculateEMIdemo
{
  
	@Test
	public  void calculateEMI() throws Exception 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("https://emicalculator.net/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		Actions actions = new Actions(driver);
		
		WebElement loanSliderCircle = driver.findElement(By.cssSelector("#loanamountslider>span"));
		WebElement interestSliderCircle = driver.findElement(By.cssSelector("#loaninterestslider>span"));
	    WebElement tenureSliderCircle = driver.findElement(By.cssSelector("#loantermslider>span"));

	    actions.dragAndDropBy(loanSliderCircle, 82, 0).build().perform();
	    Thread.sleep(2000);
	    actions.dragAndDropBy(interestSliderCircle, 149, 0).build().perform();
	    Thread.sleep(2000);
	    actions.dragAndDropBy(tenureSliderCircle, -109, 0).build().perform();
	    Thread.sleep(2000);
	    
	    WebElement loanEMIElement = driver.findElement(By.cssSelector("#emiamount>p>span"));
	    String loanEMItext = loanEMIElement.getText();
	    String ExpectedText = "92,439";
	    Assert.assertEquals(loanEMItext, ExpectedText);
	    Thread.sleep(1000);
	    driver.quit();
	    }
}
