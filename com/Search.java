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
import library.Alerthandle;
import library.Utility;

public class Search {
	AppiumDriver driver;
	@BeforeClass
	public void setUp() throws Exception
	{
		//create class to DesiredCapabilities
		DesiredCapabilities capabilities=new DesiredCapabilities();
		//give .app url
		//File appurl=new File("/Users/Logic/Desktop/ipas/notifii1.6/Notifii.ipa");
		File appurl=new File("/Users/Logic/Desktop/ipas/notifii_global/Notifii.ipa");
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
		driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATextField[1]").sendKeys("aptdemo");
		//loctae password
		driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIASecureTextField[1]").clear();
		//enterpassword.
		driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIASecureTextField[1]").sendKeys("aptdemo");
		//check the version no.
		String str=driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[1]").getText();
		System.out.println(str);
		//click on login button
		driver.findElementByName("Login").click();
		Thread.sleep(8000);
	}
	@Test(priority=3)
	public void search() throws Exception
	{
		//click on search icon
		driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAButton[8]").click();
		//locate search field to search residents 
		driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATextField[1]").clear();
		//Utility.capturescreenshot(driver,"searched list of residents");
		//enter any name of resident
		driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATextField[1]").sendKeys("john paul");
		Utility.capturescreenshot(driver,"searched list of residents");
		//click on search butttom
		driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAButton[1]").click();
		//sort the unit no.
		driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAButton[2]").click();
		//select name form available results
		driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[4]").click();
		Thread.sleep(2500);
		//back to search page
		driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAButton[1]").click();
		//back to account tools
		driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAButton[12]").click();
		//logout 
		//click on logout button 
        driver.findElementByName("Log Out").click();
        Alerthandle.Alerthandle(driver);
	}
	@AfterClass
	public void teardown()
	 
	{
		driver.closeApp();
	}
	
}
