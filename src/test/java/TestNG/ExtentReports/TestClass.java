package TestNG.ExtentReports;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestClass extends BaseTest
{   
	@Test(priority=1, testName ="TestGoogle", groups= {"smoke","regression"})
    public void TestGoogle() throws Exception
    {
    driver.get("https://www.google.com");
    Thread.sleep(2000);
    String actualtitle = driver.getTitle();
    System.out.println("The actual title is :" + actualtitle);
    Thread.sleep(3000);
    driver.findElement(By.name("q")).sendKeys("Software Testing", Keys.ENTER);
    Thread.sleep(5000);
    String Expectedtitle =  driver.getTitle();
    System.out.println("The expected title is:"+ Expectedtitle);
    Assert.assertNotEquals(actualtitle, Expectedtitle);
    }
    
	@Test(priority=2, testName ="calculateEMI", groups= {"smoke"})
	public  void calculateEMI() throws Exception 
	{
		driver.get("https://emicalculator.net/");
		Thread.sleep(3000);
		Actions actions = new Actions(driver);
		
		WebElement loanSliderCircle = driver.findElement(By.cssSelector("#loanamountslider>span"));
		WebElement interestSliderCircle = driver.findElement(By.cssSelector("#loaninterestslider>span"));
	    WebElement tenureSliderCircle = driver.findElement(By.cssSelector("#loantermslider>span"));

	    actions.dragAndDropBy(loanSliderCircle, 83, 0).build().perform();
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
}
}

