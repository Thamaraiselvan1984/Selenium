package dropdown;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class standardmultiselect {

	public static void main(String[] args) throws InterruptedException {
		    WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.get("https://demoqa.com/select-menu");
			driver.manage().window().maximize();
			Select select = new Select(driver.findElement(By.id("oldSelectMenu")));
			List<WebElement> lst = select.getOptions();
			System.out.println("select the option by Index 4");
			select.selectByIndex(4);
			System.out.println("Select value is: " + select.getFirstSelectedOption().getText());
			Thread.sleep(3000);
			System.out.println("select the option by Text Megenta");
			select.selectByVisibleText("Magenta");
			System.out.println("select valut is: " + select.getFirstSelectedOption().getText());
			Thread.sleep(3000);
			System.out.println("Select the option by Value 6");
			select.selectByValue("6");
			System.out.println("select value is: " + select.getFirstSelectedOption().getText());

        }    
	}


