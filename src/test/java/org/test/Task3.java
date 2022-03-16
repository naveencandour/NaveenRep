package org.test;

import org.openqa.selenium.WebElement;

public class Task3 {
	public static void main(String[] args) throws Exception {
		BaseClass.getChromeBrowser();
		BaseClass.get("http://adactinhotelapp.com/");
		
		WebElement txtUser = BaseClass.findElementById("username");
		String user = BaseClass.getData( "Datas", 1, 0);
		BaseClass.sendKeys(txtUser, user);
		
		WebElement txtPass = BaseClass.findElementById("password");
		String pass = BaseClass.getData( "Datas", 1, 1);
		BaseClass.sendKeys(txtPass, pass);
		
		WebElement btnLogin = BaseClass.findElementById("login");
		BaseClass.click(btnLogin);
		
		WebElement dDnLocation = BaseClass.findElementById("location");
		String loc = BaseClass.getData( "Datas", 1, 2);
		BaseClass.selectByText(dDnLocation, loc);
		
		WebElement dDnHotels = BaseClass.findElementById("hotels");
		String hot = BaseClass.getData( "Datas", 1, 3);
		BaseClass.selectByText(dDnHotels, hot);
		
		WebElement dDnRoomType = BaseClass.findElementById("room_type");
		String type = BaseClass.getData( "Datas", 1, 4);
		BaseClass.selectByText(dDnRoomType, type);
		
		WebElement dDnRoomNo = BaseClass.findElementById("room_nos");
		String no = BaseClass.getData( "Datas", 1, 5);
		BaseClass.selectByText(dDnRoomNo, no);
		
		WebElement checkInDate = BaseClass.findElementById("datepick_in");
		String indate = BaseClass.getData( "Datas", 1, 6);
		BaseClass.javaSetAttribute(indate, checkInDate);
		
		WebElement checkOutDate = BaseClass.findElementById("datepick_out");
		String outDate = BaseClass.getData( "Datas", 1, 7);
		BaseClass.javaSetAttribute(outDate, checkOutDate);
		
		WebElement adultNo = BaseClass.findElementById("adult_room");
		String aNo = BaseClass.getData( "Datas", 1, 8);
		BaseClass.selectByText(adultNo, aNo);
		
		WebElement childNo = BaseClass.findElementById("child_room");
		String cNo = BaseClass.getData( "Datas", 1, 9);
		BaseClass.selectByText(childNo, cNo);
		
		WebElement clkSearch = BaseClass.findElementById("Submit");
		BaseClass.click(clkSearch);
		
		WebElement btnRad = BaseClass.findElementById("radiobutton_0");
		BaseClass.click(btnRad);
		
		WebElement btnContinue = BaseClass.findElementById("continue");
		BaseClass.click(btnContinue);
		
		WebElement txtFirstName = BaseClass.findElementById("first_name");
		String fName = BaseClass.getData( "Datas", 1,10);
		BaseClass.sendKeys(txtFirstName, fName);
		WebElement txtLastName = BaseClass.findElementById("last_name");
		String lName = BaseClass.getData( "Datas", 1,11);
		BaseClass.sendKeys(txtLastName, lName);
		
		WebElement txtAddress = BaseClass.findElementById("address");
		String add = BaseClass.getData( "Datas", 1,12);
		BaseClass.sendKeys(txtAddress, add);
		
		WebElement txtcc = BaseClass.findElementById("cc_num");
		String cc = BaseClass.getData( "Datas", 1,13);
		BaseClass.sendKeys(txtcc, cc);
		
		WebElement ccType = BaseClass.findElementById("cc_type");
		String ccT = BaseClass.getData( "Datas", 1, 14);
		BaseClass.selectByText(ccType, ccT);
		
		WebElement expMonth = BaseClass.findElementById("cc_exp_month");
		String expm = BaseClass.getData( "Datas", 1, 15);
		BaseClass.selectByText(expMonth, expm);
		
		WebElement expYear = BaseClass.findElementByXpath("//select[@id='cc_exp_year']");
		String expy = BaseClass.getData( "Datas", 1, 16);
		BaseClass.selectByText(expYear, expy);
		
		WebElement txtccv = BaseClass.findElementById("cc_cvv");
		String ccv = BaseClass.getData( "Datas", 1,17);
		BaseClass.sendKeys(txtccv, ccv);
		
		WebElement btnBookNow = BaseClass.findElementById("book_now");
		BaseClass.click(btnBookNow);
		
		BaseClass.implicitWaitSecond(5);
		WebElement orderId = BaseClass.findElementById("order_no");
		String attribute = BaseClass.getAttribute(orderId);
		
		BaseClass.writeData("Datas", 1, 18, attribute);
		
	}

}
