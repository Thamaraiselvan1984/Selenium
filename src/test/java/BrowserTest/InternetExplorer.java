package BrowserTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class InternetExplorer 
{
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.ie.driver", "C:\\Users\\Admin\\Downloads\\selenium\\IEDriverServer_x64_4.8.1\\IEDriverServer.exe");
		WebDriver driver = new InternetExplorerDriver();
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
	}
}
