package windowhandler;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandlerDemo {

	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Downloads\\selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/browser-windows");
		driver.manage().window().maximize();
		String parent=driver.getWindowHandle();
	    Set<String>s=driver.getWindowHandles();
	    Iterator<String> I1= s.iterator();
	    while(I1.hasNext())
	    {
	    	String child_window = I1.next();
	    	if(!parent.equals(child_window))
	    	{
	    		driver.switchTo().window(child_window);
	    		System.out.println(driver.switchTo().window(child_window).getTitle());		
	    		driver.close();
	    }
	    }
	    driver.switchTo().window(parent);
		}

	}


