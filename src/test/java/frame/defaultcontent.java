package frame;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class defaultcontent {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/nestedframes");
		driver.manage().window().maximize();
		
		WebElement pageHeadingElement =  driver.findElement(By.xpath("//div[@class='main-header']"));
		String pageHeading=pageHeadingElement.getText();
		System.out.println("Page Heading is :" +pageHeading);
		
		WebElement frame1=driver.findElement(By.id("frame1"));
		driver.switchTo().frame(frame1);
        WebElement frame1Element= driver.findElement(By.tagName("body"));
        String frame1text=frame1Element.getText();
        System.out.println("frame1 is :" +frame1text);
        
        driver.switchTo().frame(0);
        WebElement frame2Element= driver.findElement(By.tagName("p"));
        String frame2Text = frame2Element.getText();
        System.out.println("Frame2 is :"+frame2Text);
        
        driver.switchTo().defaultContent();
        
        WebElement mainpageText=driver.findElement(By.xpath("//*[@id='framesWrapper']/div[1]"));
        System.out.println(mainpageText.getText());
   }
}
