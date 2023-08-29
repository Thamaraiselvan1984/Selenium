package formelements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

public class radiobutton {
	public static void main(String [] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/radio.html");
		driver.manage().window().maximize();
		WebElement radio1 = driver.findElement(By.id("vfb-7-1"));
		WebElement radio2 = driver.findElement(By.id("vfb-7-2"));
		WebElement radio3 = driver.findElement(By.id("vfb-7-3"));
		radio1.click();
		System.out.println("Radio Button Option1 Selected");
		Thread.sleep(5000);
		radio2.click();
		System.out.println("Radio Button Option2 Selected");
		Thread.sleep(5000);
		radio3.click();
		System.out.println("Radio Button Option3 Selected");
	}

}
