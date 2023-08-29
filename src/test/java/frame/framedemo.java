package frame;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import java.util.*;

public class framedemo {

	public static void main(String[] args) {
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.get("https://demoqa.com/frames");
		driver.manage().window().maximize();
		driver.switchTo().frame("frame1");
		WebElement frame1Heading = driver.findElement(By.id("sampleHeading"));
        String frame1Text=frame1Heading.getText();
        System.out.println("The Text of frame1 heading is: "+frame1Text);		
	}
}
