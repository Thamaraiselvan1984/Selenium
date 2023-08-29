package robot;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;

public class MouseEvent {

	public static void main(String[] args) throws AWTException, InterruptedException {
		WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://spreadsheetpage.com/index.php/file/C35/P10/");
        driver.manage().window().maximize();
        Robot robot = new Robot();
        Dimension i = driver.manage().window().getSize();
        System.out.println("Dimension x and y ;" + i.getWidth()+" "+i.getHeight());
        int x = (i.getWidth()/4)+20;
        int y = (i.getHeight()/10)+50;
        robot.mouseMove(x, y);
        
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        System.out.println("Browse button clicked");
        Thread.sleep(2000);
        
        robot.keyPress(KeyEvent.VK_ENTER);
        System.out.println("Closed the windows popup");
        Thread.sleep(1000);
       }

}
