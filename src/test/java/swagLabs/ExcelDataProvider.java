package swagLabs;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelDataProvider {
	
	@DataProvider(name = "LoginData")
	public String[][] method() throws IOException {
		File excel_file = new File("C:\\Users\\RAVI KONNE\\Desktop\\LoginTest.xlsx");
		FileInputStream fis = new FileInputStream(excel_file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		int Rows_count = sheet.getPhysicalNumberOfRows();
		int Columns_count = sheet.getRow(0).getLastCellNum();
		String data[][] = new String[Rows_count-1][Columns_count];
		for (int i = 0; i < Rows_count-1; i++) {
			for (int j = 0; j < Columns_count; j++) {
				DataFormatter df = new DataFormatter();
				data[i][j] = df.formatCellValue(sheet.getRow(i+1).getCell(j));
			}  
			  
		}
		workbook.close();
		fis.close();
		return data;
		        
	}

}
