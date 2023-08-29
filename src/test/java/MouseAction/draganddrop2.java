package MouseAction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class draganddrop2 
{
	public static void main(String[] args)throws InterruptedException
	{
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.get("https://demoqa.com/droppable/");
	driver.manage().window().maximize();
	Actions action = new Actions(driver);
	WebElement from = driver.findElement(By.id("draggable"));
	WebElement to = driver.findElement(By.id("droppable"));
	int xOffset1 = from.getLocation().getX();
    int yOffset1 = from.getLocation().getY();
    System.out.println("xoffset1----->"+xOffset1+" yoffset1----->"+yOffset1);
    int xOffset = to.getLocation().getX();
    int yOffset = to.getLocation().getY();
    System.out.println("xOffset----->"+xOffset+" yOffset----->"+yOffset);
    xOffset =(xOffset-xOffset1)+10;
    yOffset =(yOffset-yOffset1)+20;
    action.dragAndDropBy(from, xOffset, yOffset).perform();
    String TextTo = to.getText();
    if(TextTo.equals("Dropped!"))
    {
    	System.out.println("Passs : Source is dropped at the location as expected");
    }
    else
    {
    	System.out.println("Fail : Source count not be dropped at the location as Expected");
    }
	}
}
