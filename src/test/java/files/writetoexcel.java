package files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class writetoexcel {

	public static void main(String[] args) throws IOException  {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\selenium\\chromedriver_win32\\chormedriver.exe");
        //create an object of file class to open xls file
		File file = new File("E:\\java selenium\\testing.xlsx");
		//Create an object of FileInputStream class to read excel file
		
		//creating workbook instance that refers to .xls file
		XSSFWorkbook wb = new XSSFWorkbook();
		//creating a sheet object
		XSSFSheet sheet = wb.getSheet("STUDENT_DATA");
		//get all rows in the sheet
		int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
		//creating an object of CHROMEDRIVER
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/automation-practice-form");
		//identify the webelements
		WebElement firstname = driver.findElement(By.id("firstName"));
		WebElement lastname = driver.findElement(By.id("lastName"));
		WebElement Email = driver.findElement(By.id("userEmail"));
		WebElement genderMale = driver.findElement(By.id("gender-radio-1"));
		WebElement mobile = driver.findElement(By.id("userName"));
		WebElement address = driver.findElement(By.id("currentAddress"));
		WebElement submitBtn = driver.findElement(By.id("submit"));
		//iterate all over the row in excel and put data in the form
		for(int i=1; i<=rowCount; i++) {
		firstname.sendKeys(sheet.getRow(i).getCell(0).getStringCellValue());
		lastname.sendKeys(sheet.getRow(i).getCell(1).getStringCellValue());
		Email.sendKeys(sheet.getRow(i).getCell(2).getStringCellValue());
		mobile.sendKeys(sheet.getRow(i).getCell(3).getStringCellValue());
		address.sendKeys(sheet.getRow(i).getCell(4).getStringCellValue());
		//Click on the gender radio button using javascript
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", genderMale);
        //click on  submit button
        submitBtn.click();
        //Verify the Confirmation message
        WebElement confirmationMessage = driver.findElement(By.xpath("//div[text()='Thanks for submitting the form']"));
		//Create a new cell in the row at index 6
        XSSFCell cell = sheet.getRow(i).createCell(6);
        //check if confirmation message is displayed
        if (confirmationMessage.isDisplayed()) {
        	cell.setCellValue("pass");
        }
        else
        	cell.setCellValue("fail");
        
        //write the data in excel sheet
        FileOutputStream outputStream = new FileOutputStream("E:\\java selenium\\testing.xlsx");
        wb.write(outputStream);
        
        //close the confirmation group
        WebElement closebtn = driver.findElement(By.id("closeLargeModal"));
        closebtn.click();
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        
        }
		wb.close();
	    driver.quit();
		}
    }

