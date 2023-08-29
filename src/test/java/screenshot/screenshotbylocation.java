package screenshot;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class screenshotbylocation {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications");
		driver.get("https://demoqa.com");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		WebElement logo = driver.findElement(By.xpath("//*[@id=\"app\"]/header/a/img"));
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        BufferedImage fullScreen = ImageIO.read(screenshot);
        Point location = logo.getLocation();
        int width = logo.getSize().getWidth();
        int height = logo.getSize().getHeight();
        BufferedImage logoImage = fullScreen.getSubimage(location.getX(),location.getY(),width,height);
        ImageIO.write(logoImage, "png", screenshot);
        FileUtils.copyFile(screenshot, new File("C:\\Users\\Admin\\Downloads\\screenshot\\locationscreenshot.png"));
        }
	}
