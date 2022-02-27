package com.qa.hubspot.tests;


import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.util.Constants;

public class HomePageTest extends BaseTest {
	@BeforeClass
	public void homePageSetUp()
	{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		homepage=loginpage.doLogin(prop.getProperty("username"),prop.getProperty("password"));		
	}
	@Test(priority=1, enabled=false)
	public void homePageTitleTest()
	{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String title=homepage.getHomePageTitle();
		System.out.println("My Homepage Title is : "+title);
		Assert.assertEquals(title,Constants.PAGE_TITLE);
	}
	@Test (priority=2)
	public void verifyHomePageAdminOptionTest()
	{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		String headerValue=homepage.getHeaderValue();
		System.out.println("HomePage Header is "+headerValue);
		Assert.assertEquals(headerValue,Constants.ADMIN);
				
	}
	@Test (priority=3)
	public void veryfyAdminManaderTabExistsTest()
	{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		String adminManagerTab=homepage.getTabAdminManager();
		System.out.println("Admin Tab  Header is "+adminManagerTab);
		Assert.assertEquals(adminManagerTab,Constants.ADMIN_MANAGER);
				
	}
	

}
