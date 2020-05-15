package com.testngframework.resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {

	 public WebDriver driver;
	 public Properties prop;
	public WebDriver initilizeDriver() throws IOException
	{
		 prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\xiral\\work-spaceali\\testngframework\\src\\main\\java\\com\\testngframework\\resources\\data.properties");
		prop.load(fis);
		String browserName=prop.getProperty("browser");
		System.out.println(browserName);
		if(browserName.equals("chrome"))
{
	System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");
	driver=new ChromeDriver();
}
else
{
	System.setProperty("webdriver.fireFox.driver", "C:\\webdriver\\geckodriver.exe");
	driver=new FirefoxDriver();
}

	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	return driver;	
	}
	public String getScreenSHotPath(String testCaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String destinationFile=System.getProperty("user.dir") + "\\reports\\" + testCaseName +" .png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
		
		
	}

}
