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

public class Packagelogout  {

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
	@Test(enabled=false)
	public void forgetpassword() throws Exception
	{
		//click on forget password
		driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAButton[2]").click();
		//enter user name
		driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATextField[1]").sendKeys("think3logi");
		//enter mail.
		driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATextField[2]").sendKeys("devrabbit@gmail.com");
		//click on reset
		driver.findElementByName("Reset My Account").click();
		//accept alert
		Alerthandle.Alerthandle(driver);
				
		//back to login page
		driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAButton[1]").click();
		Thread.sleep(2500);
	}
	@Test(priority=1)
	public void launchnotifii()
	{
      System.out.println("app launched");
		
	}
	@Test(priority=3)
	public void login() throws Exception
	{
		//locate username
		driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATextField[1]").clear();
		//enter username
		driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATextField[1]").sendKeys("think3logix_inc");
		//loctae password
		driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIASecureTextField[1]").clear();
		//enterpassword.
		driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIASecureTextField[1]").sendKeys("think3logix_inc");
		//check the version no.
		String str=driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[1]").getText();
		System.out.println(str);
		//click on login button
		driver.findElementByName("Login").click();
		Thread.sleep(500);
	}
	
	@Test(priority=4)

	public void packagelogout() throws Exception
	{
		//Alerthandle.Alerthandle(driver);
		//loctate logpackage out
		driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAButton[7]").click();
		//UIAApplication[1]/UIAWindow[1]/UIAButton[2***] for inside screen
		//select scan mode
		driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAButton[1]").click();
		Thread.sleep(2000);
		//cancel scanning
		driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAButton[2]").click();
		Utility.capturescreenshot(driver, "scan mode");
		//select signout with out package
		driver.findElementByName("Sign Out Selected Packages").click();
		//accept alert
		Alerthandle.Alerthandle(driver);
		//scan another package 
		driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAButton[4]").click();
		//cancel scanning
		driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAButton[2]").click();
		Thread.sleep(2000);
		//back to view mode
		driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAButton[1]").click();
		Thread.sleep(2000);
		//click on mailroom dropdown
		
		driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAButton[2]").click();
		Thread.sleep(2000);
       //select allamialroom
		driver.findElementByName("All Mailrooms").click();
		//sort the mail campus
		//driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[1]").click();
		
    
		//searvch for alex
		driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIASearchBar[1]").sendKeys("jyothy");
		//ccnacel searched name
		driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIASearchBar[1]/UIAButton[1]").click();
		//select the mail stop through check boxes
		driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]/UIAButton[1]").click();
		//hide keyboard
		driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[1]").click();
		//click on continue 
		driver.findElementByName("Continue With Selected Packages").click();
		Thread.sleep(3000);
		//select package status 
		driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAButton[5]").click();
		//UIAApplication[1]/UIAWindow[1]/UIAButton[5]
	
		//select any status form dropdown
		driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[3]/UIAStaticText[1]").click();
		//digital sign 
		
		
		//select staffnotes
		driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATextView[1]").sendKeys("ok got it!");
		Thread.sleep(3000);
		
		//select done logout
		driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAButton[6]").click();
		
		//clcik on back button 
		//driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAButton[1]").click();
		Thread.sleep(3000);
		Utility.capturescreenshot(driver,"packagelogoutalert");
		Alerthandle.Alerthandle(driver);
		//tap to hide keyboard
		driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAImage[6]").click();
		Thread.sleep(2000);
		
		//clcik on back button 
		driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAButton[1]").click();
				Thread.sleep(3000);
				//click on account tools 
		driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAButton[9]").click();
		//logout from account
		driver.findElementByName("Log Out").click();
		Alerthandle.Alerthandle(driver);
		Thread.sleep(1000);
	}
	@AfterClass
	public void teardown()
	{
		driver.closeApp();
	}

}
	
	
