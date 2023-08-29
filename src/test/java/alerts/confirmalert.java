package alerts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

public class confirmalert {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\selenium\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--disable--notifications");
        driver.get("https://demoqa.com/alerts");
        driver.manage().window().maximize();
        WebElement element = driver.findElement(By.xpath("//*[@id=\"confirmButton\"]"));
        element.click();
        Thread.sleep(2000);
        Alert confirmalert = driver.switchTo().alert();
        String AlertText = confirmalert.getText();
        System.out.println("Alert Text is:  "+ AlertText);
        confirmalert.accept();
	}
}
