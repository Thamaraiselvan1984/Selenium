package robot;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyboardEvent {

	public static void main(String[] args) throws InterruptedException, AWTException {
		WebDriverManager.chromedriver().setup();
    	WebDriver driver = new ChromeDriver();
    	ChromeOptions op = new ChromeOptions();
    	op.addArguments("--disable--Notifications");
    	driver.get("https://www.foundit.in/seeker/registration");
    	driver.manage().window().maximize();
    	driver.findElement(By.className("uploadResume")).click();
    	Thread.sleep(2000);
    	Robot robot = new Robot();
    	StringSelection filepath = new StringSelection("C:\\Users\\Admin\\Downloads\\sus\\Thamaraiselvan.pdf");
    	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath,null);
    	Thread.sleep(2000);
    	robot.keyPress(KeyEvent.VK_CONTROL);
    	robot.keyPress(KeyEvent.VK_V);
    	robot.keyRelease(KeyEvent.VK_V);
    	robot.keyRelease(KeyEvent.VK_CONTROL);
    	robot.keyPress(KeyEvent.VK_ENTER);
    	robot.keyRelease(KeyEvent.VK_ENTER);
    	Thread.sleep(2000);
    	System.out.println("file upload sucessfully by using Robot Class");
    	}
}
