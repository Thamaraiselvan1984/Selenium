package frame;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class dynamicframe {

	public static void main(String[] args) {
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.get("https://demoqa.com/nestedframes");
		driver.manage().window().maximize();
		int size = driver.findElements(By.tagName("iframe")).size();
	    System.out.println("Number of Frames on a Page:" + size);
	    driver.switchTo().frame(0);
	}
}
