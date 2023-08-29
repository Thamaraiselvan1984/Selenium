package alerts;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class simplealert {

	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/alerts");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"alertButton\"]")).click();
		Thread.sleep(2000);
		Alert simplealert = driver.switchTo().alert();
		String Salert = simplealert.getText();
		System.out.println("The Alert Text is  "+ Salert);
		simplealert.accept();
	}
}
