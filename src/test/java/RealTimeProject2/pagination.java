package RealTimeProject2;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;


public class pagination {
    
	@Test
	public void paginationUsingForLoop() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://datatables.net/examples/advanced_init/dt_events.html");
        Thread.sleep(2000); 
        int paginationsize = driver.findElements(By.tagName("span")).size();
        List<String> names = new ArrayList<String>();
        
        for(int i=1; i<=paginationsize; i++)
        {
        	String paginationSelector = "span a:nth-child("+i+")";
        	driver.findElement(By.cssSelector(paginationSelector)).click();
        	
        	List<WebElement> namesElements = driver.findElements(By.cssSelector("#example>tbody>tr>td:nth-child(1)"));
        	
        	for (WebElement namesElement : namesElements) 
        	{
        		names.add(namesElement.getText());
        	}
        }		
        for(String name : names)
        {
        	System.out.println(name);
        
        }
				int totalname = names.size();
				System.out.println("Total number of Names:"+ totalname);
				String displayCount = driver.findElement(By.id("example_info")).getText().split(" ")[5];
				System.out.println("Total number of Displayed Names count:" + displayCount);
				Assert.assertEquals(displayCount, String.valueOf(totalname));
				Thread.sleep(3000);
				driver.quit();
			}
}
