package files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcelFile {

	public static void main(String[] args) {
		
		//creating Workbook
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		//creating sheet
		XSSFSheet samplesheet = workbook.createSheet("Samplesheet");
		
		//creating object
		
		Map<String, Object[]> dataset = new TreeMap<String, Object[]>();
		dataset.put("1", new Object[] {"id", "NAME","COMPANY"} );
		dataset.put("2", new Object[] {"1", "James","CTS"} );
		dataset.put("3", new Object[] {"2", "Maria","TCS"} );
		dataset.put("4", new Object[] {"3", "Peter","INFOSYS"} );
		dataset.put("5", new Object[] {"4", "Julia","HP"} );
		dataset.put("6", new Object[] {"5", "Ajay","HCL"} );
		
		//Iterate over the data
		
		Set<String> set = dataset.keySet();
		
		int rownum = 0;
		
		for(String key : set)
		{
			Row row = samplesheet.createRow(rownum++);
			Object[] data = dataset.get(key);
			
			int cellnum = 0;
			
			for(Object value : data)
			{
				Cell cell = row.createCell(cellnum++);
				if(value instanceof String)
					cell.setCellValue((String)value);
				else if
				(value instanceof Integer)
				cell.setCellValue((Integer)value);
			}
		}
		
		//write down file on hard disc
		
		try {
			File file = new File("C:\\Users\\Admin\\eclipse-workspace\\SeleniumJava\\data\\testing.xlsx");
			FileOutputStream writeFile = new FileOutputStream(file);
			try {
				workbook.write(writeFile);
				writeFile.close();
				System.out.println("Sample excel file is being created sucessfully");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
