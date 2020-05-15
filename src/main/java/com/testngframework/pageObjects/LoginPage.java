package com.testngframework.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	public WebDriver driver;
	By username=By.id("user_email");
	By password=By.cssSelector("[name='user[password]']");
	By submitbtn=By.xpath("//input[@type='submit']");
	public LoginPage(WebDriver driver2) {
		// TODO Auto-generated constructor stub
		this.driver=driver2;
	}
	public WebElement getName()
	{
		return driver.findElement(username);
	}
	public WebElement getpass()
	{
		return driver.findElement(password);
	}
	public WebElement getSubmitButton()
	{
		return driver.findElement(submitbtn);
	}

}
