package com.notifii.com;




	import java.io.File;
	import java.net.URL;
	import java.util.List;
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.Alert;
	import org.openqa.selenium.Dimension;
	import org.openqa.selenium.NoSuchElementException;
	import org.openqa.selenium.Point;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.remote.DesiredCapabilities;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.Test;

	import io.appium.java_client.AppiumDriver;
	import io.appium.java_client.MobileElement;
	import io.appium.java_client.SwipeElementDirection;
	import io.appium.java_client.ios.IOSDriver;
	import library.Alerthandle;
	import library.Utility;

	public class Launchapp {
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
		
		@Test(priority=1)
		public void Accounttools() throws Exception
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
			Thread.sleep(500);
			//locate account tools
			driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAButton[9]").click();
			//get the account name
			String str1 =driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[3]").getText();
			System.out.println(str1);
			//verify username
			String str2 =driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[5]").getText();
			System.out.println(str2);
		}
			/*@Test(priority=2)
			public void viewresident() throws Exception
			{
			//verify view resident list 
			driver.findElementByName("View Resident List").click();
			//refresh list of residents
			//driver.findElementByName("Refresh List").click();
			Thread.sleep(2500);
			//Utility.capturescreenshot(driver,"resident list");
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
			
			}*/
			@Test(priority=3)
			public void addresident() throws Exception
			{
			//click on add new recepient
			driver.findElementByName("Add New Resident").click();
			//to hidekeyboard
			driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[1]").click();
			//enter firstname
			driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATextField[1]").sendKeys("john");
			//enter last name
			driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATextField[2]").sendKeys("paul");
			//enter untino.
			driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATextField[3]").sendKeys("123456789");
			//select type of resident
			driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAButton[2]").click();
			//select any option
			driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]").click();
			//select status
			driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAButton[3]").click();
			//select status option
			driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]").click();
			//enter mobile no.
			driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATextField[6]").sendKeys("98701691990");
			//enter ,ail id 
			driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATextField[7]").sendKeys("rkn411@gmail.com");
			//to hidekeyboard
					driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[1]").click();
			//opt notification check boxes
			driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAButton[4]").click();
			//prefer text messgaes 
			driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAButton[5]").click();
			//click on submit button
			driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAButton[6]").click();
			Alerthandle.Alerthandle(driver);
			Utility.capturescreenshot(driver, "new resident added");
			Thread.sleep(3000);
	        //back to main page
			driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAButton[1]").click();
			Thread.sleep(1500);
			driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAButton[1]").click();
			Thread.sleep(1500);
			
			}
			@Test(priority=4)
			public void packagehistory() throws Exception 
			{
			//verify package history
			driver.findElementByName("Package History").click();
			//select show package
			driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAButton[4]").click();
			Thread.sleep(1500);
			//selct package
			driver.findElementByName("Picked up").click();
			/*//selct between dates 
			driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATextField[5]").clear();
			Thread.sleep(1500);
			//enter any date range
			driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATextField[5]").sendKeys("2015/05/04");
			//locate from month
			driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATextField[5]").click();
			Thread.sleep(1500);
			//select august month
			driver.findElementByName("August").click();
			//locate year
			driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATextField[6]").click();
			//select any year from list
			driver.findElementByName("2009").click();
			//select date
			driver.findElementByName("21").click();*/
			//select filter by
			driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAButton[6]").click();
			//select filter
			driver.findElementByName("List only packages that have been picked up").click();
			Thread.sleep(1500);
			//submit update
			driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAButton[7]").click();
			Thread.sleep(2000);
			Alerthandle.Alerthandle(driver);
			Utility.capturescreenshot(driver, "history updated");
			 //back to main page
			driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAButton[1]").click();
			Thread.sleep(1000);
			//sort unit no.
			
			}
			@Test(priority=5)
			public void contactus() throws Exception
			{
				//locate contactus
				driver.findElementByName("Contact Us").click();
				//loctae name 
				driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATextField[1]").sendKeys("reddi");
				//loctae email &enter
				driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATextField[2]").sendKeys("reddikothapalli90@gmail.com");
				//enter phone no.
				driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATextField[3]").sendKeys("3526987");
				//enter any text message'
				driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATextView[1]").sendKeys("i need info regarding nothing");
				
				//tap to hide keyboard 
				driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[1]").click();
				Thread.sleep(1500);
				//click on submit button
				driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAButton[1]").click();
				Thread.sleep(2500);
				Utility.capturescreenshot(driver, "contacted");
				Alerthandle.Alerthandle(driver);
				//click on accounttools to navigate menu screen
				driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAButton[5]").click();
			}
			@Test(priority=6)
			public void updateusername() throws Exception
			{
				//locate update username
				driver.findElementByName("Update Username").click();
				//enter new name
				driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATextField[1]").sendKeys("aptdemo");
				//click on submit 
				driver.findElementByName("Submit").click();
				Thread.sleep(2500);
				Utility.capturescreenshot(driver, "usernameupdateverified");
				Alerthandle.Alerthandle(driver);
						
			}
			@Test(priority=7)
			public void updatepassword() throws Exception
			{
				//locate update username
				driver.findElementByName("Update Password").click();
			//locate new password field
				driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIASecureTextField[1]").sendKeys("devrabbit");
				//locate confirm password
				driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIASecureTextField[2]").sendKeys("devrabbit");
				//click on subit button
				driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAButton[2]").click();
				Thread.sleep(2500);
				Utility.capturescreenshot(driver, "passwordupdateverified");
				Alerthandle.Alerthandle(driver);
				//locate account tools
				driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAButton[9]").click();
						
			}
			@Test(priority=8)
			public void refreshlogut() throws Exception
			{
				//loctae & click on fresh button
				driver.findElementByName("Refresh").click();
				Thread.sleep(6500);
				Alert alert = driver.switchTo ().alert ();
		        //alert is present
		        System.out.println(alert.getText());
		    	
		    	//capture screenshot
				 Utility.capturescreenshot(driver,"refreshed");
				Thread.sleep(1500);
		        alert.accept(); 
		        //click on logout button 
		        driver.findElementByName("Log Out").click();
		        Alerthandle.Alerthandle(driver);
		        Thread.sleep(8000);
				
			}
			@AfterClass
			public void teardown()
			 
			{
				driver.closeApp();
			}
			
			
			
			
			
	}

