package com.notifii.com;


	
	import java.io.File;
	import java.net.URL;
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Action;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.remote.DesiredCapabilities;
	import org.openqa.selenium.remote.RemoteWebDriver;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.Test;

	import io.appium.java_client.AppiumDriver;
	import io.appium.java_client.SwipeElementDirection;
	import io.appium.java_client.ios.IOSDriver;
	import library.Alerthandle;
	import library.Utility;

	public class Launchnotifii {
	AppiumDriver driver;
		
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
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		} 
		@Test(priority=2)
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
			//Alerthandle.Alerthandle(driver);
			//Utility.capturescreenshot(driver,"login successfull");
			
		}
		@Test(priority=3)
		public void packagelogin() throws Exception
		{
			//locate package in
			driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAButton[2]").click();
			/*//locate receipient name 
			driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[1]").clear();
			//enter any name
			driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[1]").sendKeys("alex");
			//enter receipent name
			driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]").click();
			//click on camera to scan item
			driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[1]").click();
			//take scan mode sceernshot
			Utility.capturescreenshot(driver,"scan mode cancel");
			//cancel camera 
			driver.findElementByName("Cancel").click();
			//enter tracking no. as
			driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[2]").sendKeys("14356234");
			//select mail room dropdown
			driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[2]").click();
			//take mailroom list screenshot
					Utility.capturescreenshot(driver,"mail room list");
			//select mail room name 
			driver.findElementByName("Central Receiving").click();
			//select serive type
			driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[3]").click();
			//select service type name
			driver.findElementByName("Priority Mail Express").click();
			//select package condition
			driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[4]").click();
			//select condition of package
			driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]").click();
			//enter po no.
			driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[6]").sendKeys("789654123");
			//emter sender name
			driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[7]").sendKeys("johnpaul");
			//selct package type
			driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[5]").click();
			//selct type of pacjkage
			driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[4]").click();
			//select shelf location
			driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[9]").sendKeys("dont know");
			//tap othr area to hide keyboard
			driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAImage[1]").click();
			//check the check boxes
			driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[6]").click();
			//check one more check box
			driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[7]").click();
			//tap othr area to hide keyboard
			driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAImage[1]").click();
			
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
			//selct carrier
			driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[11]").click();
			//select carrier name
			driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[2]").click();
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
			//locate succes message and get text
			String Str=driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[3]").getText();
			System.out.println(Str);
			//click on ok button
			driver.findElementByName("OK").click();
			Thread.sleep(2500);
			Utility.capturescreenshot(driver,"Sucess");
			Alerthandle.Alerthandle(driver);
			Thread.sleep(2500);*/
		}
		@Test(priority=5)
		public void packagelogout() throws Exception
		{
			//Alerthandle.Alerthandle(driver);
			//loctate logpackage out
			driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAButton[3]").click();
			//select scan mode
			driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAButton[1]").click();
			Thread.sleep(3000);
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
			//sort the campus address
			driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAStaticText[1]").click();
			
	    
			//searvch for alex
			driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIASearchBar[1]").sendKeys("alex");
			//select the campus through check boxes
			driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]/UIAButton[1]").click();
			//hide keyboard
			driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[1]").click();
			//click on continue 
			driver.findElementByName("Continue With Selected Packages").click();
			//select package status 
			driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAButton[5]").click();
			//UIAApplication[1]/UIAWindow[1]/UIAButton[5]
			Thread.sleep(3000);
			//select any status form dropdown
			//driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[7]/UIAStaticText[1]").click();
			//digital sign 
			WebElement element = driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAImage[6]");

		    Actions builder = new Actions(driver);
		    Action drawAction = builder.moveToElement(element,135,15) //start points x axis and y axis. 
		              .click()
		              .moveByOffset(200, 60) // 2nd points (x1,y1)
		              .click()
		              .moveByOffset(100, 70)// 3rd points (x2,y2)
		              .doubleClick()
		              .build();
		    drawAction.	perform();
			
			//select staffnotes
			driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATextView[1]").sendKeys("ok got it!");
			
			//select done logout
			driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAImage[12]").click();
			
			//clcik on back button 
			//driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAButton[1]").click();
			Thread.sleep(3000);
			Utility.capturescreenshot(driver,"packagelogoutalert");
			Alerthandle.Alerthandle(driver);
			//clcik on back button 
			driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAButton[1]").click();
					Thread.sleep(3000);
			
		}
		@AfterClass
		public void teardown()
		{
			driver.closeApp();
		}

	}



