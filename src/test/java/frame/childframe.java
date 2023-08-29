package frame;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class childframe {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/nestedframes");
		driver.manage().window().maximize();
		
		int size = driver.findElements(By.tagName("iframe")).size();
	    System.out.println("Number of Frames on a Page:" + size);
        
	    WebElement frame1 = driver.findElement(By.id("frame1"));
        driver.switchTo().frame(frame1);
        
        int size1 = driver.findElements(By.tagName("iframe")).size();
        System.out.println("Number of iFrames inside the Frame1:" + size1);
        
        driver.switchTo().frame(0);
        int size2 = driver.findElements(By.tagName("iframe")).size();
        System.out.println("Number of iFrames inside the Frame2:" + size2);
        
        WebElement 	frame1Element = driver.findElement(By.tagName("body"));
        String frame1Text = frame1Element.getText();
        System.out.println("Frame1 is :"+frame1Text);
	}
}
