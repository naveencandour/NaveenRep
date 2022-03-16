package org.test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.*;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public  class BaseClass {
	static WebDriver driver;
	static Select select;
	

	public static  void taskesScreenShot(String text) throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File s = screenshot.getScreenshotAs(OutputType.FILE);
		File d = new File("C:\\Users\\Toshiba\\eclipse-workspace1\\Framework\\ScreenShoot\\"+text+"");
		FileUtils.copyDirectory(s, d);
	}
	
	

	public static void getChromeBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

	}

	public static void getFirefoxBrowser() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();

	}

	public static void getEdgeBrowser() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();

	}

	public static void getSafariBrowser() {
		WebDriverManager.safaridriver().setup();
		driver = new SafariDriver();

	}

	public static void getIntenetExpBrowser() {
		WebDriverManager.iedriver().setup();
		driver = new InternetExplorerDriver();

	}

	public static void get(String url) {

		driver.get(url);
	}

	public static WebElement findElementById(String attribute) {

		WebElement element = driver.findElement(By.id(attribute));
		return element;
	}

	public static void sendKeys(WebElement element, String data) {

		element.sendKeys(data);
	}

	public static void click(WebElement element) {

		element.click();
	}

	public static void maximize() {

		driver.manage().window().maximize();

	}

	public static void simpleAlert() {
	Alert alert = driver.switchTo().alert();

		alert.accept();

	}

	public static void confirmAlert() {
	Alert alert = driver.switchTo().alert();
		alert.dismiss();

	}

	public static String promptAlert(String data) {
	Alert alert = driver.switchTo().alert();
		alert.sendKeys(data);
		String text = alert.getText();
		System.out.println(text);
		alert.dismiss();
		return text;
	}

	public static String getText(WebElement element) {
		String text = element.getText();
		return text;
	}

	public static String getAttribute(WebElement element) {
		String text = element.getAttribute("value");
		return text;
	}

	public static void colseAllWindow() {
		driver.quit();
	}

	public static void colseCurrentWindow() {
		driver.quit();
	}

	public static String getTitle() {
		String title = driver.getTitle();
		return title;
	}

	public static String getCurrentUrl() {
		String title = driver.getCurrentUrl();
		return title;
	}

	public static void selectByText(WebElement element, String text) {
		select = new Select(element);
		select.selectByVisibleText(text);
	}

	public static void selectByValue(WebElement element, String text) {
		select = new Select(element);
		select.selectByValue(text);
	}

	public static void selectByIndex(WebElement element, int value) {
		select = new Select(element);
		select.selectByIndex(value);
	}

	public static boolean isMultiple(WebElement element) {
		select = new Select(element);
		boolean multiple = select.isMultiple();
		return multiple;
	}

	public static WebElement findElementByName(String attribute) {
		WebElement element = driver.findElement(By.name(attribute));
		return element;

	}

	public static WebElement findElementByClassName(String attribute) {
		WebElement element = driver.findElement(By.className(attribute));
		return element;

	}

	public static WebElement findElementByXpath(String attribute) {
		WebElement element = driver.findElement(By.xpath(attribute));
		return element;

	}

	public static void clickByJs(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click()", element);
	}

	public static void javaSetAttribute(String text, WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].setAttribute('value','" + text + "')", element);

	}

	public static Object javaGetAttribute(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		Object object = executor.executeScript("arguments[0].getAttribute('value')", element);
		return object;

	}

	public static void javaScrollDown(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true)", element);
	}

	public static void javaScrollUp(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(false)", element);
	}

	public static void righClick(WebElement element) {
		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();

	}

	public static void doubleClick(WebElement element) {
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();

	}

	public static void mouseOver(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();

	}

	public static void dragAndDrop(WebElement element, WebElement element1) {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(element, element1).perform();

	}

	public static List<WebElement> locateByElementsId(String id) {
		List<WebElement> elements = driver.findElements(By.id(id));
		return elements;

	}

	public static WebElement locateByTagName(String tagName) {
		WebElement element = driver.findElement(By.tagName(tagName));
		return element;
	}

	public static List<WebElement> locateByElementsName(String name) {
		List<WebElement> elements = driver.findElements(By.name(name));
		return elements;

	}

	public static List<WebElement> locateByElementsXpath(String name) {
		List<WebElement> elements = driver.findElements(By.xpath(name));
		return elements;

	}

	public static List<WebElement> locateByElementsTagName(String name) {
		List<WebElement> elements = driver.findElements(By.tagName(name));
		return elements;

	}

	public static void actionsSendKeys(WebElement element, String data) {
		Actions actions = new Actions(driver);
		actions.sendKeys(element, data);
	}

	public static void actionsSendKeysAllcaps(WebElement element, String data) {
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.SHIFT).sendKeys(element, data).keyUp(Keys.SHIFT);
	}

	public static void screenShot(String path) throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File s = screenshot.getScreenshotAs(OutputType.FILE);
		File d = new File(path);
		FileUtils.copyFile(s, d);
	}

	public static void deSelectByIndex(WebElement element, int index) {
		select = new Select(element);
		select.deselectByIndex(index);

	}

	public static void deSelectByText(WebElement element, String text) {
		select = new Select(element);
		select.deselectByVisibleText(text);

	}

	public static void deSelectByValue(WebElement element, String text) {
		select = new Select(element);
		select.deselectByValue(text);

	}

	public static void deSelectAll(WebElement element) {
		select = new Select(element);
		select.deselectAll();

	}

	public static String printOptions() {
		String text = null;
		List<WebElement> options = select.getOptions();
		for (WebElement webElement : options) {

			text = webElement.getText();
			System.out.println(text);

		}
		return text;
	}

	public static List<WebElement> getOptions() {

		List<WebElement> options = select.getOptions();
		return options;
	}

	public static String getAllSelectedOptio() {
		String text = null;
		List<WebElement> selectedOptions = select.getAllSelectedOptions();
		for (WebElement webElement : selectedOptions) {
			text = webElement.getText();
			System.out.println(text);
		}
		return text;
	}

	public static String getFirstSelect() {
		WebElement element = select.getFirstSelectedOption();
		String text = element.getText();
		return text;
	}

	public static void switchFrameByIdOrName(String nameOrId) {
		driver.switchTo().frame(nameOrId);

	}

	public static void switchFrameByWeblement(WebElement element) {
		driver.switchTo().frame(element);

	}

	public static void switchFrameByIndex(int index) {
		driver.switchTo().frame(index);

	}

	public static void defaultFrame() {
		driver.switchTo().defaultContent();
	}

	public static void switchToParentFrame() {
		driver.switchTo().parentFrame();
	}

	public static void windowsByIdOrTitleOrUrl(String nameOrHandle) {
		driver.switchTo().window(nameOrHandle);

	}

	public static void navigateTo(String url) {
		driver.navigate().to(url);
	}

	public static void navigateToForward() {
		driver.navigate().forward();
		;
	}

	public static void navigateToBackward() {
		driver.navigate().back();
	}

	public static void navigateToRefresh() {
		driver.navigate().refresh();
	}

	public static String getData( String sheetName, int rownum, int cellnum) throws IOException {
		String value = null;
		File file = new File("C:\\Users\\Toshiba\\eclipse-workspace1\\Framework\\Excel\\Task3.xlsx");
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
				value = d.toBigInteger().toString();

			}
			break;

		}
		return value;
	}

	public static void updateData( String sheetName, int rownum, int cellnum, String olddata, String newdata)
			throws IOException {
		File file = new File("C:\\Users\\Toshiba\\eclipse-workspace1\\Framework\\Excel\\Task3.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		String string = cell.getStringCellValue();
		if (string.equals(olddata)) {
			cell.setCellValue(newdata);

		}
		FileOutputStream output = new FileOutputStream(file);
		workbook.write(output);

	}

	public static void writeData( String sheetName, int rownum, int cellnum, String data) throws IOException {
		File file = new File("C:\\Users\\Toshiba\\eclipse-workspace1\\Framework\\Excel\\Task3.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rownum);
		Cell cell = row.createCell(cellnum);
		cell.setCellValue(data);

		FileOutputStream output = new FileOutputStream(file);
		workbook.write(output);

	}

	public static void writeRowData( String sheetName, int rownum, int cellnum, String data) throws IOException {
		File file = new File("C:\\Users\\Toshiba\\eclipse-workspace1\\Framework\\Excel\\Task3.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.createRow(rownum);
		Cell cell = row.createCell(cellnum);
		cell.setCellValue(data);

		FileOutputStream output = new FileOutputStream(file);
		workbook.write(output);

	}

	public static void createNewSheet(String path, String sheetName, int rownum, int cellnum, String data) throws IOException {
		File file = new File(path);
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet(sheetName);
		Row row = sheet.createRow(rownum);
		Cell cell = row.createCell(cellnum);
		cell.setCellValue(data);

		FileOutputStream output = new FileOutputStream(file);
		workbook.write(output);

	}

	public static void robotTab(int num) throws AWTException {
		Robot robot = new Robot();
		for (int i = 0; i < num; i++) {
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);

		}
	}

	public static void webTwoTable(String data) {
		List<WebElement> tRow = driver.findElements(By.tagName("tr"));
		for (int i = 0; i < tRow.size(); i++) {
			WebElement tData = tRow.get(i);
			List<WebElement> tDatas = tData.findElements(By.tagName("td"));
			for (int j = 0; j < tDatas.size(); j++) {
				WebElement element = tDatas.get(i);
				String text = element.getText();
				if (text.equals(data)) {
					System.out.println(text);

				}

			}

		}

	}

	public static void implicitWaitMS(int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.MILLISECONDS);
	}

	public static void implicitWaitSecond(int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	public static void implicitWaitMin(int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.MINUTES);
	}

}
