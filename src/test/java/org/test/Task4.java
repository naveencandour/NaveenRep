package org.test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Task4 {
	static WebDriver driver;
	@BeforeClass
	public static void getChromeBrowser() {
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		driver.get("http://adactinhotelapp.com/");
	}
	@AfterClass
	public static void closeBrowser() {
		driver.quit();
	}
	@Before
	public void beforeLogin() throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File s = screenshot.getScreenshotAs(OutputType.FILE);
		File d = new File("C:\\Users\\Toshiba\\eclipse-workspace1\\Framework\\ScreenShoot\\beforeLogin.png");
		FileUtils.copyFile(s, d);
		}
	@Test
	public void login() {
		WebElement txtLogin = driver.findElement(By.id("username"));
		txtLogin.sendKeys("naveengokul28");
		WebElement txtpass = driver.findElement(By.id("password"));
		txtpass.sendKeys("naveen01@A",Keys.ENTER);
	}
	@After
	public void afterLogin() throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File s = screenshot.getScreenshotAs(OutputType.FILE);
		File d = new File("C:\\Users\\Toshiba\\eclipse-workspace1\\Framework\\ScreenShoot\\afterLogin.png");
		FileUtils.copyFile(s, d);
	}
	

}
