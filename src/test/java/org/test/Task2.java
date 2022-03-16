package org.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Task2 {
	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.automationtesting.in/Register.html");
		
		File file = new File("C:\\Users\\Toshiba\\eclipse-workspace1\\Framework\\Excel\\List2.xlsx");
		
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("DropDown");
		WebElement dDnSkill = driver.findElement(By.id("Skills"));
		Select select = new Select(dDnSkill);
		
		List<WebElement> options = select.getOptions();
		//List<String> l = new ArrayList<String>();
		System.out.println(options.size());
		for (int i = 0; i < options.size(); i++) {
			
			WebElement element = options.get(i);
			String text = element.getText();
			for (int j = 0; j < options.size(); j++) {
				Row row = sheet.createRow(i);
				
				Cell cell = row.createCell(0);
				
				cell.setCellValue(text);
				
			}
			//l.add(text);
			System.out.println(text);
		}
//		for (int j = 0; j <l.size(); j++) {
//			
//			Row row = sheet.createRow(j);
//			Cell cell = row.createCell(0);
//			
//			cell.setCellValue(l.get(j));
//			
//		}
		FileOutputStream output = new FileOutputStream(file);
		workbook.write(output);
		
	}

}
