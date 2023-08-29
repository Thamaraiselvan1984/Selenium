package Brokenlinks;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLink {

	@Test
	public void brokenLinkTest() throws IOException {
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.amazon.com");
		driver.manage().window().maximize();
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		System.out.println("Number of Links are :" + links.size());
		
		for(WebElement link : links)
		{
			String URL = link.getAttribute("href");
			GetLinkStatus.verifyLink(URL);
		}
		
		System.out.println("Number of broken links:");
		GetLinkStatus.getInvalidLinkCount();
	}
}
