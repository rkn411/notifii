package com.notifii.com;



	import org.testng.IRetryAnalyzer;
	import org.testng.ITestResult;
import org.testng.Reporter;

	public class Retry implements IRetryAnalyzer{
	private int retryCount = 0;
	private int maxRetryCount = 2;
	public boolean retry(ITestResult result)
	 {

	   if(retryCount < maxRetryCount)
	    { 
		  System.out.println("Retrying test " + result.getName() + " for the " + (retryCount+1) + " time(s).");
		   retryCount++; 
		
		   return true; 
	    } 
	   return false; 
	  } 
	} 

