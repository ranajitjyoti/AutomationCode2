package com.qa.hubspot.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;

public class BaseTest   {
	public BasePage basepage;
	public Properties prop;
	public WebDriver driver;
	public HomePage homepage;
	public LoginPage loginpage;
	@BeforeTest
		public void setUp()
	{
		basepage=new BasePage();
		prop=basepage.initialize_Property();
		String browser=prop.getProperty("browser");
		driver=basepage.initializeDriver(browser);
		loginpage= new LoginPage(driver);
		driver.get(prop.getProperty("url"));
	}
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
}
