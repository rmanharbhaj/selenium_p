package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.BaseClass;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginTest extends BaseClass{
	
	LoginPage lp;
	HomePage hp;

	public LoginTest() throws IOException{
		super();
	}

	@BeforeMethod
	public void setUp() throws IOException {
		init();
		lp = new LoginPage();
	}
	

	@Test(priority = 1)
	public void loginTitleTest() {
		String loginTitle=lp.validateLoginPageTitle();
		System.out.println(loginTitle);
		Assert.assertEquals(loginTitle, "Cogmento CRM");
	}
	
	
	@Test(priority = 2)
	public void loginTest() throws IOException {
		hp=lp.enterUserPass(p.getProperty("user_name"), p.getProperty("pass_word"));
	}
	
	@AfterMethod
	public void tersDown() {
		driver.quit();
	}
	
	
}
