package sampleForReadExcel;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SampleExcelClass {

	public Object[][] readExcel() throws IOException{
		XSSFWorkbook workBook = new XSSFWorkbook("./Data/new.xlsx");
		XSSFSheet sheet1 = workBook.getSheetAt(0);
		int lastRowNum = sheet1.getLastRowNum();
		int lastCellNum = sheet1.getRow(0).getLastCellNum();
		Object[][] sampleData = new Object[lastRowNum][lastCellNum];
		
		for (int i = 1; i <=lastRowNum; i++) {
			XSSFRow row = sheet1.getRow(i);//i tells index of row
			for (int j = 0; j < lastCellNum; j++) {
				XSSFCell cell = row.getCell(j);//j tells the index of cell
				String cellvalues = cell.getStringCellValue();
				sampleData[i-1][j]= cellvalues;
			}
		}
		workBook.close();
		return sampleData;
	}
}
