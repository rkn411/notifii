package com.notifii.com;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.SwipeElementDirection;
import io.appium.java_client.ios.IOSDriver;
import library.Alerthandle;
import library.Utility;

public class Packagelogin {
	AppiumDriver driver;
	@BeforeClass
	public void setUp() throws Exception
	{
		//create class to DesiredCapabilities
		DesiredCapabilities capabilities=new DesiredCapabilities();
		//give .app url
		//File appurl=ne0w File("/Users/Logic/Desktop/ipas/notifii1.6/Notifii.ipa");
		File appurl=new File("/Users/Logic/Desktop/ipas/notifii_global/Notifii.ipa");
		capabilities.setCapability("app",appurl.getAbsolutePath());
		//details of real device.
		capabilities.setCapability("deviceName","LogictreeIpad");
		
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
	
			
	@Test(priority=3)
	public void packagelogin() throws Exception
	{
		//locate package in
		driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAButton[6]").click();
		//locate receipient name 
		driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[1]").clear();
		//enter any name
		driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[1]").sendKeys("john");
		//enter receipent name
		driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[5]").click();
		//click on camera to scan item
		driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[1]").click();
		//take scan mode sceernshot
		Utility.capturescreenshot(driver,"scan mode cancel");
		//cancel camera 
		driver.findElementByName("Cancel").click();
		//enter tracking no. as
		driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[2]").sendKeys("1456234");
		//select carrier dropdown
		driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[3]").click();
		//take carrier list screenshot
				Utility.capturescreenshot(driver,"carrier");
		//select carrier room name 
		driver.findElementByName("DHL").click();
		//select serive type
		driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[4]").click();
		//select service type name
		driver.findElementByName("Priority Mail Express").click();
		//emter sender name
		driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[5]").sendKeys("johnpal");
		//selct package type
		driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[5]").click();
		//selct type of pacjkage
		driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[4]").click();
		//select package condition
		driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[6]").click();
		//select condition of package
		driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]").click();
		//select shelf location
		driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[9]").sendKeys("dont know");
		//enter po no.
		//driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[10]").sendKeys("123654897");
		//tap othr area to hide keyboard
		driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAImage[1]").click();
		//check the check boxes
		driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[7]").click();
		//check one more check box
		driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[8]").click();
		
		//enter custom message
		//driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextView[1]").sendKeys("u got package buddy");
		//tap othr area to hide keyboard
				driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAImage[1]").click();
		//scroll down page
		final SwipeElementDirection DOWN;
		//click on advanced options
		driver.findElementByName("Click here to show advanced options.").click();
		
		//JavascriptExecutor jse = (JavascriptExecutor)driver;
		//jse.executeScript("scroll(0, 300)"); 
		Thread.sleep(2500);
		//select package status
		driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[12]").click();
		//select package status
		driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[2]").click();
		//select send notification
		driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[13]").click();
		//select notification
		driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[2]").click();
		
		//write staff notes
		//driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextView[2]").sendKeys("what is to write");
		//tap othr area to hide keyboard
		//driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAImage[1]").click();
		Thread.sleep(2500);
		//click on package login
		driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[14]").click();
		Thread.sleep(2500);
		//locate success message and get text
		String Str=driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[3]").getText();
		System.out.println(Str);
		//click on ok button
		driver.findElementByName("OK").click();
		Thread.sleep(2500);
		Utility.capturescreenshot(driver,"Sucess");
		Alerthandle.Alerthandle(driver);
		Thread.sleep(2500);
		//click on account tools 
		driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAButton[5]").click();
		Thread.sleep(2500);
		//logout from account 
		driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAButton[8]").click();
		Alerthandle.Alerthandle(driver);
		Thread.sleep(1000);
	}
	@AfterClass
	public void teardown()
	{
		driver.closeApp();
	}
	public static WebDriver getDriver() {
		return null;
	}
}
