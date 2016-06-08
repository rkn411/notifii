package com.notifii.com;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Autologin {
	WebDriver driver;
	
	@BeforeClass
	public void launchsite()
	{
		//launch browser
		driver =new FirefoxDriver();
		//get url
		driver.get("https://www.zoho.com/people/login.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		
	
	}
	@Test
	public void autologin() throws Exception
	{
		List<WebElement> f=driver.findElements(By.tagName("iframe"));
		System.out.println("No of frames:"+f.size());
		driver.switchTo().frame(0);
		//loctae username
		driver.findElement(By.id("lid")).sendKeys("r.com");
		//loctae password
		driver.findElement(By.id("pwd")).sendKeys("rk");
		//click on submit button
		driver.findElement(By.xpath(".//*[@id='submit_but']")).click();
		Thread.sleep(8000);
		
		//click on check in
		
	}
	@AfterClass
	public void tearDown()
	{
		//Close window
		driver.quit();
	}

}
