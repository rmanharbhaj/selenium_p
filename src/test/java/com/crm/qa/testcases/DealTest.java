package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.BaseClass;
import com.crm.qa.pages.DealPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utilities.UtilClass;

public class DealTest extends BaseClass {
	LoginPage lp;
	HomePage hp;
	DealPage dp;
	String sheetname="FreeCrmData";

	public DealTest() throws IOException {
		super();
	}
	

	@BeforeMethod
	public void setUp() throws IOException {
		init();
		lp = new LoginPage();
		hp = new HomePage();
		hp=lp.enterUserPass(p.getProperty("user_name"), p.getProperty("pass_word"));
		dp=hp.clickOnDealLink();
	}
	
	@DataProvider(name = "Deal_Data")
	public Object[][] getFreeCrmDataTest() {
		Object data[][]=UtilClass.getTestData(sheetname);
		return data;
	}
	
	@Test(dataProvider = "Deal_Data")
	public void createDealTest(String title,String company,String amount) {
		dp.createDeal(title, company, amount);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
