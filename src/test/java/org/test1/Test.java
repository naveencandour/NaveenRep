package org.test1;

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
import org.test.BaseClass;

public class Test  {
	public static String getData(String path, String sheetName, int rownum, int cellnum) throws IOException {
		String value = null;
		File file = new File(path);
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		CellType type = cell.getCellType();
		switch (type) {
		case STRING:
			value = cell.getStringCellValue();
			break;
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				Date date = cell.getDateCellValue();
				SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
				value = format.format(date);

			} else {
				double numericCellValue = cell.getNumericCellValue();
				BigDecimal d = BigDecimal.valueOf(numericCellValue);
				value = d.toString();

			}
			break;

		}
		return value;
	}
		public static void main(String[] args) throws IOException {
			String data = Test.getData("C:\\Users\\Toshiba\\eclipse-workspace1\\Framework\\Excel\\Task3.xlsx", "Datas", 1, 6);
			
		System.out.println(data);	
		String ccv = Test.getData("C:\\Users\\Toshiba\\eclipse-workspace1\\Framework\\Excel\\Task3.xlsx", "Datas", 1,17);
		System.out.println(ccv);
		}
}
