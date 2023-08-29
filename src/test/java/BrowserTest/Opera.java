package BrowserTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Opera {

	public static void main(String[] args) {
		System.setProperty("webdriver.opera.driver", "C:\\Users\\Admin\\Downloads\\selenium\\opera\\operadriver_win64\\operadriver_win64\\operadriver.exe");
		WebDriver driver = new OperaDriver();
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
	}
}
