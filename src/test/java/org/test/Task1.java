package org.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Task1 {
public static void main(String[] args) throws IOException {
		
		File file = new File("C:\\Users\\Toshiba\\eclipse-workspace1\\Framework\\Excel\\TestData.xlsx");
		
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		
		Sheet sheet = workbook.getSheet("Test");
		
		for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
			Row row = sheet.getRow(i);
			
			for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
				
				Cell cell = row.getCell(j);
				CellType type = cell.getCellType();
				
				switch (type) {
				case STRING:
					String stringCellValue = cell.getStringCellValue();
					System.out.println(stringCellValue);
					
					break;
					
				case NUMERIC:
					if (DateUtil.isCellDateFormatted(cell)) {
						Date date = cell.getDateCellValue();
						SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
						String string = format.format(date);
						System.out.println(string);
						
					} else {
						
						double numericCellValue	 = cell.getNumericCellValue();
						BigDecimal d = BigDecimal.valueOf(numericCellValue);
						String Phone = d.toString();
						System.out.println(Phone);

					}
					break;
					
				}
			}
		}
		
	}

}
