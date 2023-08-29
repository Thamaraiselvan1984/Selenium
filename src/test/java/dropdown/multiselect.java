package dropdown;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.File;
import java.util.List;

public class multiselect {
	public static void main(String[] args) {
	   WebDriverManager.chromedriver().setup();
       WebDriver driver = new ChromeDriver();
       ChromeOptions opt = new ChromeOptions();
       opt.addExtensions(new File("C:\\Users\\Admin\\eclipse-workspace\\SeleniumJava\\Ads Blocker\\CRX FILE\\AdBlocker.crx"));
       driver.get("https://demoqa.com/select-menu");
       driver.manage().window().maximize();
       Select select = new Select(driver.findElement(By.id("cars")));
       System.out.println("The Drop down Options are -");
       List<WebElement> options = select.getOptions();
       for(WebElement option: options)
    	   System.out.println(option.getText());
       if(select.isMultiple())
       {
    	   System.out.println("Select option Audi by Text");
    	   select.selectByVisibleText("Audi");
    	   System.out.println("Select option Volvo by Text");
    	   select.selectByVisibleText("Volvo");
    	   System.out.println("DeSelect option Audi by Text");
           select.deselectByVisibleText("Audi");
           System.out.println("select option Opel by Text");
           select.selectByVisibleText("Opel");
           System.out.println("The selected values in the dropdown options are -");
           List<WebElement> selectedOptions = select.getAllSelectedOptions();
           for(WebElement selectedOption: selectedOptions)
               System.out.println(selectedOption.getText());
       }  
	}
}
