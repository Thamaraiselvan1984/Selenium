package formelements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Alert;
import java.util.concurrent.TimeUnit;

public class fileupload {
    public static void main(String[] args) {
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\selenium\\chromedriver_win32\\chromedriver.exe");
    	WebDriver driver = new ChromeDriver();
    	ChromeOptions op = new ChromeOptions();
    	op.addArguments("--disable--Notifications");
    	driver.get("https://www.foundit.in/seeker/registration");
    	driver.manage().window().maximize();
    	WebElement m = driver.findElement(By.id("file-upload"));
    	m.sendKeys("C:\\Users\\Admin\\Downloads\\sus\\Thamaraiselvan.pdf");
    	System.out.println("File is Uploaded Successfully");
    	    
}
}