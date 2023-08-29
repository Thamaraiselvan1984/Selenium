package MouseAction;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Alert;

public class draganddrop {
	public static void main(String[] args) throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/droppable/");
		driver.manage().window().maximize();
		Actions action = new Actions(driver);
		WebElement from = driver.findElement(By.id("draggable"));
		WebElement to = driver.findElement(By.id("droppable"));
		action.dragAndDrop(from, to).perform();
		Thread.sleep(1000);
		String TextTo = to.getText();
		if(TextTo.equals("Dropped!"))
		{
		System.out.println("PASS: Source is dropped to target as Expected");
		}
		else
		System.out.println("FAIL: Source could not be dropped as Expected");
	}
}
