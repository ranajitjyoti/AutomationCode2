package com.qa.hubspot.tests;

import org.jsoup.select.Evaluator.ContainsData;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.util.Constants;

public class LoginPageTest extends BaseTest  {
	@Test(priority=1)
	public void verifyLoginPageTitleTest()
	{
		String title=loginpage.getLoginPageTitle();
		System.out.println("Login page title is "+title);
		Assert.assertEquals(title,Constants.LOGIN_PAGE_TITLE);
	}
	
	@Test (priority =2)
	public void verifyForgetpasswordLink()
	{
		String Forgot_Option=loginpage.ifForgotPassExist();
		System.out.println("text written in forgot password option : "+Forgot_Option);
		Assert.assertEquals(Forgot_Option,Constants.FORGOT_OPTION );
		
	}
	@Test(priority=3)
	public void loginTest()
	{
		loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	

}
