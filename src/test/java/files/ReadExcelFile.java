package files;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {

	public static void main(String[] args) throws IOException {
		
		File file = new File("C:\\Users\\Admin\\eclipse-workspace\\SeleniumJava\\data\\testing.xlsx");
		FileInputStream readFile = new FileInputStream(file);

		//creating workbook
		XSSFWorkbook workbook = new XSSFWorkbook(readFile);
		
		//creating sheet
		XSSFSheet sheet = workbook.getSheet("SampleSheet");
		
		//object of rows
		
		Row row;
		Cell cell;
		
		Iterator<Row> rowItertor = sheet.rowIterator();
		
		while(rowItertor.hasNext()) {
			row= rowItertor.next();
			
			Iterator<Cell> cellIterator = row.cellIterator();
			while(cellIterator.hasNext()) {
				cell=cellIterator.next();
				
				DataFormatter formatter = new DataFormatter();
				String text = formatter.formatCellValue(cell);
				System.out.println(text);
			}
			
		}
		
	}
}
