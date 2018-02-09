package utils;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadExcel {	

	public static String[] readExcel(String headVal) throws InvalidFormatException, IOException{
		
		File src = new File("./data/TC005.xlsx");
		XSSFWorkbook wbook = new XSSFWorkbook(src);
		XSSFSheet sheet = wbook.getSheetAt(0);
		int rowCount = sheet.getLastRowNum();
		int columnCount = sheet.getRow(0).getLastCellNum();
		int headCount = 0;
		String[] data = new String[rowCount];
		for (int i = 0; i < columnCount; i++) {
			String headerValue = sheet.getRow(0).getCell(i).getStringCellValue();
			if (headerValue.equalsIgnoreCase(headVal)) {
				headCount = i;
			}
		}		
		for (int i = 1; i <=rowCount; i++) {			
			data[i-1] =  sheet.getRow(i).getCell(headCount).getStringCellValue();
		}
		return data;		
	}
	
	@Test
	public void  name() throws InvalidFormatException, IOException {
		
		String[] data = readExcel("password");
		for (String string : data) {
			System.out.println(string);
		}
	}
	
	
	
	
}












