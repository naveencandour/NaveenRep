package org.test;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Taskfb {
	public static void main(String[] args) throws Exception {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		
		WebElement txtUser = driver.findElement(By.id("twotabsearchtextbox"));
		txtUser.sendKeys("iphone 12",Keys.ENTER);
		
		WebElement element = driver.findElement(By.xpath("(//span[text()='Apple iPhone 12 (128GB) - Blue'])[3]"));
		element.click();
			
		String parent = driver.getWindowHandle();
		Set<String> set = driver.getWindowHandles();
		for (String string : set) {
			
			if (!string.equals(parent)) {
				
				driver.switchTo().window(string);
				
				Thread.sleep(8000);
//				driver.close();     
				driver.quit();
				
			}
			
		}
					
		
	}

}
