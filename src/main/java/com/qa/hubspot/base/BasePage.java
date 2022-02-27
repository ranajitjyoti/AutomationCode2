package com.qa.hubspot.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * 
 * @author RanajitJyoti
 *
 */
public class BasePage {
	public WebDriver driver;
	public Properties prop;
	/**
	 * This method is user to initialize a driver 
	 * @param browser
	 * @return WebDriver driVer
	 */
	public WebDriver initializeDriver(String browser)
	{
		System.out.println("Browser value is :"+browser);
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("safari"+browser)) {
			driver=new SafariDriver();
		}
		else
		{
			System.out.println("Please pass the correct browser value : "+browser);
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		//driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		return driver;
	}
	/**
	 * this method is used to load the file from config.properties file
	 * @return Properties
	 */
	public Properties initialize_Property()
	{
		prop=new Properties();
		try {
			FileInputStream ip=new FileInputStream("./src/main/java/com/qa/hubspot/config/config.properties");
			prop.load(ip);
			}
		 catch (FileNotFoundException e) {
				e.printStackTrace();
	}
		 catch (IOException e) {
				e.printStackTrace();
			}
	return prop;
	}

}
