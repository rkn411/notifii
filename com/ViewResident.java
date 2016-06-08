package com.notifii.com;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import library.Utility;

public class ViewResident {
AppiumDriver driver;

	
	@BeforeClass
	public void setUp() throws Exception
	{
		//create class to DesiredCapabilities
		DesiredCapabilities capabilities=new DesiredCapabilities();
		//give .app url
		//File appurl=new File("/Users/Logic/Desktop/ipas/notifii1.6/Notifii.ipa");
		File appurl=new File("/Users/Logic/Desktop/ipas/notifii1.6/Notifii.ipa");
		capabilities.setCapability("app",appurl.getAbsolutePath());
		//details of real device.
		capabilities.setCapability("deviceName","LogictreeIpad");
		//capabilities.setCapability("deviceName","satheesh's iPad");
		capabilities.setCapability("platformVersion","9.3.1");
		capabilities.setCapability("platformName","iOS");
		capabilities.setCapability("udid","316d3ef3fc61a092af227ef0cc8bba35ce6a088f");
		capabilities.setCapability("autoLaunch",true);
		capabilities.setCapability("autoAcceptAlerts", true);
				//test app bundleid
		capabilities.setCapability("bundleId","com.notifii.notifii");  
		//server ip and port address//
		driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	} 
	@Test(priority=2)
	public void login() throws Exception
	{
		//locate username
		driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATextField[1]").clear();
		//enter username
		driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATextField[1]").sendKeys("think3logix");
		//loctae password
		driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIASecureTextField[1]").clear();
		//enterpassword.
		driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIASecureTextField[1]").sendKeys("think3logix");
		//check the version no.
		String str=driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[1]").getText();
		System.out.println(str);
		//click on login button
		driver.findElementByName("Login").click();
		Thread.sleep(8000);
	}
	
	@Test
	public void viewresident() throws Exception
	{
	//verify view resident list 
	driver.findElementByName("View Resident List").click();
	//refresh list of residents
	//driver.findElementByName("Refresh List").click();
	Thread.sleep(3500);
	Utility.capturescreenshot(driver,"resident list");
	//back to main
	driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAButton[1]").click();	
	Thread.sleep(2500);
	//sort the resident names
	//driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAButton[4]").click();
		//locate search ffiled
	driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIASearchBar[1]").click();
	// search any name in list 
	driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIASearchBar[1]").clear();
	Thread.sleep(1500);
	
	driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIASearchBar[1]").sendKeys("john thomas");
	Thread.sleep(2500);
	//click on searched name
	driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIAScrollView[1]/UIATableCell[1]").click();
	Thread.sleep(800);	
	//caputre screenshot
	Utility.capturescreenshot(driver, "resident profile");
	//get first name verifyu is for john
	String str =driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[3]").getText();
	System.out.println(str);
	//verify unit no.
	String str1 =driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[8]").getText();
	System.out.println(str1);
	//edit profile
	driver.findElementByName("Edit Profile").click();
	Utility.capturescreenshot(driver, "profile edit");
	//back to main
	driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAButton[1]").click();	
	//back to main
	driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAButton[1]").click();	
	driver.swipe(113, 808,113,479,2000);
		Thread.sleep(4000);
		driver.swipe(113, 808,113,479,2000);
		Thread.sleep(8000);
	
	}
	@AfterClass
	public void teardown()
	 
	{
		driver.closeApp();
	}
	
	
	

}
