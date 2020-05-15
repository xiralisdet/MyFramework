package com.testngframework;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.testngframework.pageObjects.LandingPage;
import com.testngframework.resources.base;


public class ValidateTitle extends base{
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initilize() throws IOException
	{
	driver=initilizeDriver();
	log.info("driver is initilized");
	driver.get(prop.getProperty("url"));
	log.info("navigate to home page");
	}
	
	@Test
	public void basePageNavigation() throws IOException
	{
	//driver.manage().window().maximize();
		LandingPage landing=new LandingPage(driver);
		String actual=landing.getTitle().getText();
		Assert.assertEquals(actual, "FEATURED COURSES");
		log.info("sucessfully valitated test titles");
		
	}
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
	

		
}

