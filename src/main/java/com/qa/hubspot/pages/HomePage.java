package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;

public class HomePage extends BasePage {
	
	private WebDriver driver;
	private By adminMan=By.xpath("/html/body/header/nav/a") ;
	
	private By tabAdminManager=By.xpath("//a[contains(text(),'Admin')and contains(text(),'Manager')]") ;
	private By reports=By.xpath("//*[@id=\"navMenu\"]/li[4]/a/text()") ;
	private By alerts=By.xpath("//*[@id=\"navMenu\"]/li[5]/a/text()") ;
	
	public  HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public String getHomePageTitle()
	{
		return driver.getTitle();
	}
	 
	public String getHeaderValue()
	{
		
			return driver.findElement(adminMan).getText();
	
	}
	
	public String getTabAdminManager()
	{
		return driver.findElement(tabAdminManager).getText();
	}
	
	public String alertDisplayed()
	{
			 return driver.findElement(alerts).getText();

	}
	
	

}
