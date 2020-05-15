package com.testngframework;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.testngframework.pageObjects.LandingPage;
import com.testngframework.resources.base;

import junit.framework.Assert;

public class ValidateNavigationBar extends base{
	public WebDriver driver;
	
	public static Logger log=LogManager.getLogger(base.class.getName());
	
	
	@BeforeTest
	public void initilize() throws IOException
	{
	driver=initilizeDriver();
	driver.get(prop.getProperty("url"));
	}
	@Test
	public void basePageNavigation() throws IOException
	{
	//driver.manage().window().maximize();
		LandingPage landing=new LandingPage(driver);
		boolean actual=landing.getNavigationBar().isDisplayed();
		Assert.assertTrue(actual);
		log.info("Navigation bar is displayed");
		
	}
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
}
	

		


