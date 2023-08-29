package files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CreateReadWriteExcel {
      
	   public static void main(String[] args) throws IOException {
		
		   //blank workbook
		   XSSFWorkbook workbook = new XSSFWorkbook();
		   
		   //create sheet
		   XSSFSheet sheetname = workbook.createSheet("STUDENT_DATA");
		
		XSSFRow row = sheetname.createRow(0);
		XSSFCell cell = row.createCell(0);
		row.createCell(0).setCellValue("THAMARAISELVAN");
		row.createCell(1).setCellValue("MANI");
		row.createCell(2).setCellValue("selvan.84@gmail.com");
		row.createCell(3).setCellValue("male");
		row.createCell(4).setCellValue("9941178814");
		row.createCell(5).setCellValue("chennai");
		
		//how to write data in excel using output stream
		File file = new File("E:\\java selenium\\testing.xlsx");
		FileOutputStream outputStream = new FileOutputStream(file);
		workbook.write(outputStream);
		outputStream.close();
		workbook.close();
		System.out.println("This file was written sucessfully");
		}
	}

