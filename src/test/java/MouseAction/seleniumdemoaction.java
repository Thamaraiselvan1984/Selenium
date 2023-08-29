package MouseAction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class seleniumdemoaction 
{
	public static void main(String[] args)throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
	    WebDriver driver = new ChromeDriver();
	    driver.get("https://www.amazon.in");
	    driver.manage().window().maximize();
	    Thread.sleep(4000);
	    Actions act = new Actions(driver);
		WebElement all = driver.findElement(By.xpath("//*[@id=\"nav-hamburger-menu\"]"));
		act.click(all).build().perform();
		Thread.sleep(1000);
		WebElement firetv = driver.findElement(By.xpath("//*[@id=\"hmenu-content\"]/ul[1]/li[12]/a"));
		act.click(firetv).build().perform();
		Thread.sleep(1000);
        WebElement ftvstick = driver.findElement(By.xpath("//*[@id=\"hmenu-content\"]/ul[6]/li[4]/a"));
        ftvstick.click();
        Thread.sleep(1000);        
	}
}
