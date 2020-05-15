package com.testngframework;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.testngframework.resources.ExtentReporterNG;
import com.testngframework.resources.base;

public class Listeners extends base implements ITestListener{
	ExtentTest test;
	ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();
	ExtentReports extent=ExtentReporterNG.getReportObject();
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		extent.flush();
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.get().fail(result.getThrowable());
		WebDriver driver=null;
		String testMethodName=result.getMethod().getMethodName();
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e ) {
			// TODO Auto-generated catch block
		
		
		}
		try {
			extentTest.get().addScreenCaptureFromPath(getScreenSHotPath(testMethodName, driver),result.getMethod().getMethodName());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		 test= extent.createTest(result.getMethod().getMethodName());
		 extentTest.set(test);
	}

	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		extentTest.get().log(Status.PASS, "Test Passed");
	}

}
