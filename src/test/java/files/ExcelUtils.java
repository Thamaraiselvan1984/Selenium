package files;

import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	public static void main(String[] args)
	{
		getRowCount();
		getcelldata();
	}
	
	public static void getcelldata() {
		try 
		{
		String excelpath = "./data/testdata.xlsx";
		
		XSSFWorkbook workbook = new XSSFWorkbook(excelpath);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		DataFormatter formatter = new DataFormatter();
		Object value = formatter.formatCellValue(sheet.getRow(1).getCell(1));
		System.out.println(value);
		
		}
		catch (Exception e)
		{
		System.out.println(e.getMessage());
		System.out.println(e.getCause());
		e.printStackTrace();
	
		}
	}
		
		public static void getRowCount() 
		{
			try 
			{
			String excelpath = "./data/testdata.xlsx";
			XSSFWorkbook workbook = new XSSFWorkbook(excelpath);
			XSSFSheet sheet = workbook.getSheet("Sheet1");
			
			int rowCount = sheet.getPhysicalNumberOfRows();
			System.out.println("No of Rows:"+rowCount);
				
			} 
			catch (Exception e)
			{
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
			}
		}
}
