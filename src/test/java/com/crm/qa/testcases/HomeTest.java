package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.BaseClass;
import com.crm.qa.pages.DealPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;


public class HomeTest extends BaseClass {
	
	LoginPage lp;
	HomePage hp;
	DealPage dp;

	public HomeTest() throws IOException {
		super();
		
	}
	
	@BeforeMethod
	public void setUp() throws IOException {
		init();
		lp = new LoginPage();
		hp = new HomePage();
		hp=lp.enterUserPass(p.getProperty("user_name"), p.getProperty("pass_word"));
	}
	
	@Test
	public void checkUserDisplayTest() {
		String name=hp.checkUserDisplay();
		System.out.println(name);
		Assert.assertEquals(name, "riddhi ghori");
	}
	
	@Test
	public void clickOnDealLinkTest() throws IOException{
		dp=hp.clickOnDealLink();
	}
	
	@AfterMethod
	public void tersDown() {
		driver.quit();
	}

}
