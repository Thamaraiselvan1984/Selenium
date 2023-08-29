package screenshot;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class screenshotfullpage {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		ChromeOptions opt = new ChromeOptions();
		opt.setExperimentalOption("excludeswitches", Arrays.asList("disable-popup-blocking"));
		driver.get("https://demoqa.com");
		driver.manage().window().maximize();
		Thread.sleep(4000);
		Screenshot s = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		ImageIO.write(s.getImage(),"PNG",new File("C:\\Users\\Admin\\Downloads\\screenshot\\fullpagescreenshot.png"));
	}

}
