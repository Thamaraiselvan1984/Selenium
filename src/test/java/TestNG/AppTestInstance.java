package TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;


public class AppTestInstance extends AppTestBase
{
	public WebDriver driver;
	@FindBy(id="email") WebElement username;
    @FindBy(id="pass") WebElement password;
    @FindBy(id="loginbutton") WebElement login;
    
	public void login(WebDriver driver)
	{
		  this.driver = driver;
		  PageFactory.initElements(driver,this);
	}
	
	public void shouldlogin() throws Exception 
	  {
		username.sendKeys("selvan.84@gmail.com");
		password.sendKeys("Thamarai@123");
		login.click();
		
}
}