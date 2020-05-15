package com.testngframework.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	public WebDriver driver;
	By signIn=By.cssSelector("i.fa.fa-lock.fa-lg");
	By title=By.xpath("//div[@class=\"text-center\"]/h2");
	By NavBar=By.cssSelector(".nav.navbar-nav.navbar-right>li>a");
	public LandingPage(WebDriver driver2) {
		// TODO Auto-generated constructor stub
		this.driver=driver2;
	}
	public WebElement getLogin()
	{
		return driver.findElement(signIn);
	}
	
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}
	public WebElement getNavigationBar()
	{
		return driver.findElement(NavBar);
	}
}
