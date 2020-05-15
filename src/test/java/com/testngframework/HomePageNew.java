package com.testngframework;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.testngframework.pageObjects.LandingPage;
import com.testngframework.pageObjects.LoginPage;
import com.testngframework.resources.base;

public class HomePageNew extends base{
	
	public WebDriver driver;
	public static Logger log1=LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initilize() throws IOException
	{
	driver=initilizeDriver();
	driver.get(prop.getProperty("url"));
	
	}
	
	@Test(dataProvider="getData")
	public void basePageNavigation(String username, String password, String text) throws IOException
	{
	//driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		LandingPage land=new LandingPage(driver);
		land.getLogin().click();
		LoginPage log=new LoginPage(driver);
		log.getName().sendKeys(username);
		log.getpass().sendKeys(password);
		//System.out.println(text);arg0
		log1.info(text);
		log.getSubmitButton().click();
		
		
	}
	
	
	
	@DataProvider
public Object[][] getData()
{
		Object[][] data=new Object[2][3];
		data[0][0]="nonrestricteduser@qw.com";
		data[0][1]="123456";
		data[0][2]="Restricted User";
		
		data[1][0]="restricteduser@qw.com";
		data[1][1]="456789";
		data[1][2]="Non restricted user";
		
		return data;
		
}
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
	

}
