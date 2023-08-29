package windowhandler;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Set;

public class switchbackparentwindow {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		ChromeOptions options = new ChromeOptions();
		try {
			driver= new RemoteWebDriver(new URL("http://192.168.61.125:4444"), options);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.get("https://demoqa.com/browser-windows");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("windowButton")).click();
		String mainwindow = driver.getWindowHandle();
		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> i1 =  s1.iterator();
		
		while(i1.hasNext()) {
			String ChildWindow = i1.next();
			if(!mainwindow.equalsIgnoreCase(ChildWindow))
			{
				driver.switchTo().window(ChildWindow);
				WebElement text = driver.findElement(By.id("sampleHeading"));
				System.out.println("Heading of child window is " + text.getText());
				driver.close();
			}
				System.out.println("Child window closed");
		}
		driver.switchTo().window(mainwindow);
			}
     }
