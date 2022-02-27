package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;

public class LoginPage extends BasePage {
	private WebDriver driver;
	//1. By locator is object repository 
	private By userNameField=By.xpath("//input[@name='username']");
	private By passwordField=By.xpath("//input[@name='password']");
	private By submitButton=By.xpath("//input[@id='btnLogin']");
	private By forgotPasswordOption=By.xpath("//div[@id='forgot']/a[@href='#forgotpas']");
	
	// Constructor of page class 
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	// page actions : this is feature & behavior of the page 
	 public String getLoginPageTitle()
	 {
		 try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		 return driver.getTitle();
	 }
	 
	 public String ifForgotPassExist()
	 {
		return driver.findElement(forgotPasswordOption).getText();
	 }
	 
	 public HomePage doLogin(String un, String pass)
	 {
		System.out.println("Login with user name : "+un+" and password :"+pass);
		driver.findElement(userNameField).sendKeys(un);
		driver.findElement(passwordField).sendKeys(pass);
		driver.findElement(submitButton).click();
		return new HomePage(driver);
		
	 }
	

}
