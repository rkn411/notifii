package com.notifii.com;


	
	import io.appium.java_client.AppiumDriver;
	import io.appium.java_client.android.AndroidDriver;

	import java.net.URL;
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
	import org.openqa.selenium.remote.CapabilityType;
	import org.openqa.selenium.remote.DesiredCapabilities;
	import org.openqa.selenium.remote.RemoteWebDriver;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Parameters;
	import org.testng.annotations.Test;

	public class AppiumGrid {
		DesiredCapabilities caps = new DesiredCapabilities();
		AppiumDriver d;
		String URL;

		@Parameters({"udid","bundleid",""})
		@BeforeTest
		public void setupCapabilities(String Device_ID,String packname,String actname) throws Exception {

			if (Device_ID.equalsIgnoreCase("")) {
				setcapabilities(packname,actname,Device_ID);
			}

			else if (Device_ID.equalsIgnoreCase("")) {
				setcapabilities(packname,actname,Device_ID);
				
				
			}
			d = new AndroidDriver(new URL("http://127.0.0.1:4444/wd/hub"), caps);
			d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}

		public void setcapabilities(String apppackage, String appActivity,String device) 
		{
			caps.setCapability("deviceName", device);
			caps.setCapability("automationName", "Appium");
			caps.setCapability("platformName", "iOS");
			caps.setCapability("BundleId", "");
			caps.setCapability("platformVerison", "9.3.1");
			caps.setCapability("udid", device);
		}

		@Test
		public void testAppiumGrid() throws Exception {
			System.out.println("executing test 1");
			
			Thread.sleep(10000);
			
		}
		/*@Test
		public void selendroidAppTest_1() throws Exception{

			System.out.println("executing test 2");
			
			Thread.sleep(1000);
			
		}*/

	}




