package com.notifii.com;
import static org.testng.Assert.assertEquals;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

	import com.relevantcodes.extentreports.ExtentReports;
	import com.relevantcodes.extentreports.ExtentTest;
	import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;

	public class ExtentLogin {
		AppiumDriver driver;
		ExtentReports extent;
		ExtentTest test;
		@BeforeClass
		public void setUp() throws Exception
		{
			//create class to DesiredCapabilities
			DesiredCapabilities capabilities=new DesiredCapabilities();
			//give .app url
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
			driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
			// new instance
			extent = new ExtentReports("/Users/Logic/Desktop/reports/notiffi1.6CustomReport.html",true);
		}
		@Test
		public void launchapp() throws Exception
		{
			// starting test
			 test= extent.startTest("Verify user is able to launch and login app", "");
			// step log
			test.log(LogStatus.INFO, "app launched");
			// ending test
			extent.endTest(test);
			

		}
		@Test
		public void testLogin() throws Exception
		{
			// starting test
			test= extent.startTest("Verify user is able to login", "");
			//locate username
			driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATextField[1]").sendKeys("edudemo");
			test.log(LogStatus.INFO, "User name entered");
			Thread.sleep(4000);
			//Enter password
			driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIASecureTextField[1]").sendKeys("staging");
			test.log(LogStatus.INFO, "Password entered");
			//loctate logpackage out
			driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAButton[7]").click();
			test.log(LogStatus.INFO, "log package out");
			//scroll down kist 
			JavascriptExecutor js = (JavascriptExecutor) driver;
			HashMap<String, String> scrollObject = new HashMap<String, String>();
			scrollObject.put("direction", "down");
			js.executeScript("mobile: scroll", scrollObject);
			//click on mailroom dropdown
			driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAButton[2]").click();
			test.log(LogStatus.INFO, "drop down selected");
	       //select allamialroom
			driver.findElementByName("All Mailrooms").click();
			test.log(LogStatus.INFO, "all mailrooms");
			//click on account tools
			driver.findElementByName("accout tools normal").click();
			test.log(LogStatus.INFO, "page to be account tools");
			Thread.sleep(4000);
			//check view recipient
			driver.findElementByName("View Recipient List").click();
			test.log(LogStatus.INFO,"view receipient");
			//return to accounttools
			//driver.find
			//click on singout
			//driver.findElementByName("Log Out").click();
			//test.log(LogStatus.INFO, "logout button clicked");
			
			Thread.sleep(4000);
			// ending test
			extent.endTest(test);
		
			
		}
	
		@AfterClass
		public void tearDown()
		{
			//Close app
			driver.closeApp();
			// writing everything to document
			extent.flush();
		}


	}




