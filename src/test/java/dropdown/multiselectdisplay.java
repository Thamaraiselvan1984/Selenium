package dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class multiselectdisplay {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/select-menu");
        driver.manage().window().maximize();
        Select select = new Select(driver.findElement(By.className("css-1wa3eu0-placeholder")));
        List<WebElement> option = select.getOptions();
        System.out.println("The dropdown options are :");
        for(WebElement options: option)
        System.out.println(options.getText());
        System.out.println("Select the Option by Text");
        select.selectByVisibleText("Red");
        System.out.println("selected value is:)" + select.getFirstSelectedOption().getText());
    }
}
