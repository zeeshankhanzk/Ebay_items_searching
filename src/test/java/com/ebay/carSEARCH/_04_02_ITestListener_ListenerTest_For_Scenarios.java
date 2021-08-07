package com.ebay.carSEARCH;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class _04_02_ITestListener_ListenerTest_For_Scenarios implements ITestListener {

		public void onFinish(ITestContext Result) {					
	        
	    }		

	    public void onStart(ITestContext Result) {					
	        		
	    }		

	    public void onTestFailedButWithinSuccessPercentage(ITestResult Result) {					
	        		
	    }		

	 // When Test case get failed, this method is called and take screenshot		
	    public void onTestFailure(ITestResult Result) 					
	    {		
	    System.out.println("The name of the testcase failed is :"+Result.getName());
	    
	   /* if(Result.getStatus() == 2) {
		for (int retrycount = 0; retrycount < 2; retrycount++) {
				System.out.println("Retrying failed test name " + Result.getName() + " for the " + (retrycount + 1) + " time(s).");
							
			}
			
	    }*/
	    //String timestamp = new SimpleDateFormat("dd_MM_yyyy__hh_mm_ss").format(new Date());
	    Date date = new Date();
	    String timestamp = date.toString().replace(":", "_").replace(" ", "_");
	    
	    File screenshot = ((TakesScreenshot) _04_01_ITestListener_Test_Cases_Having_Scenarios.driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot, new File(".//screenshots//TestCase_"+ Result.getName()+"_"+ timestamp +".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    }			

	 // When Test case get Skipped, this method is called.		
	    		
	    public void onTestSkipped(ITestResult Result)					
	    {		
	    System.out.println("The name of the testcase Skipped is :"+Result.getName());					
	    }		

	 // When Test case get Started, this method is called.		
	    		
	    public void onTestStart(ITestResult Result)					
	    {		
	    System.out.println(Result.getName()+" test case started");					
	    }		

	    // When Test case get passed, this method is called.		
	    		
	    public void onTestSuccess(ITestResult Result)					
	    {		
	    System.out.println("The name of the testcase passed is :"+Result.getName());					
	    }		
}
