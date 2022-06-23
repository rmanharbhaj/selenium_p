package com.crm.qa.pages;


import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.BaseClass;

public class LoginPage extends BaseClass{
	
	@FindBy(name = "email")
	WebElement user;
	
	@FindBy(name = "password")
	WebElement pass;
	
	@FindBy(xpath = "//div[@class='ui fluid large blue submit button']")
	WebElement loginButton;
	
	public LoginPage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public HomePage enterUserPass(String userName , String passWord) throws IOException {
		user.sendKeys(userName);
		pass.sendKeys(passWord);
		loginButton.click();
		return new HomePage();
	}
	
	
	

}
