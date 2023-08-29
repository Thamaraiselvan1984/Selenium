package formelements;

import java.util.HashMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebElement;

public class filedownload {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\selenium\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
    	chromePrefs.put("profile.default_content_settings.popups", 0);
    	String downloadfilepath = System.getProperty("user.dir");
    	chromePrefs.put("download.default_directory", downloadfilepath);
    	options.setExperimentalOption("prefs", chromePrefs);
    	WebDriver driver = new ChromeDriver(options);
    	driver.manage().window().maximize();
    	driver.get("C:/Users/Admin/Downloads/Data/download.zip");
    	driver.findElement(By.linkText("download.zip")).click();
    	System.out.println("file downloaded successfully");

	}

}
