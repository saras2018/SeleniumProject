package wdMethods;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.testng.annotations.Test;

public class ReadFromExcel  {
	
	
	public Object[][] excel(String filename) throws IOException{
	
		//Go to the CreateLead workbook
		XSSFWorkbook workBook = new XSSFWorkbook("./Data/"+filename+".xlsx");
		
		
		//Go to sheet1
		XSSFSheet sheetAt = workBook.getSheetAt(0);
		
			
		int lastRowNum = sheetAt.getLastRowNum();
		int lastCellNum = sheetAt.getRow(0).getLastCellNum();
		Object[][] dataset = new Object[lastRowNum][lastCellNum];
		
		System.out.print(lastCellNum);
		
		for (int i=1; i<=lastRowNum; i++)
		{   
			//Go to the row
		    XSSFRow row = sheetAt.getRow(i);
		   
			for(int j=0;j<lastCellNum;j++)
			{
				
			//Go to the cell
			XSSFCell cell = row.getCell(j);
			String cellValues = cell.getStringCellValue();
			
			//Print the values
			System.out.println(cellValues);
			
			//Write the cell values in the array
			dataset[i-1][j]= cellValues;
		}
		
		
		
		}
	 workBook.close();
	 return dataset;
	}
	
	
}
	


