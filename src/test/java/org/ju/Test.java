package org.ju;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.test.BaseClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test {
	 static WebDriver driver;
	@BeforeClass
	public static void browser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://adactinhotelapp.com/");
		driver.manage().window().maximize();
	}
	@Before
	
	public void tasksScreen() throws Exception {
		BaseClass baseClass = new BaseClass();
		BaseClass.taskesScreenShot("login");
	}
	
	
	
	@org.junit.Test
	public void login() {
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		WebElement txtLogin = driver.findElement(By.id("username"));
		txtLogin.sendKeys("naveengokul28");
		
		WebElement txtpass = driver.findElement(By.id("password"));
		txtpass.sendKeys("naveen01@A");
		
		WebElement btnlogin = driver.findElement(By.id("login"));
		btnlogin.click();
	}
	
	@After
	public void takes2() throws Exception {
	BaseClass.taskesScreenShot("homepage");
	
		
	}
	
	@AfterClass
	public static void close() {
		driver.quit();
	}
	

}
