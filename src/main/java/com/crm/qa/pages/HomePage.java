package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.BaseClass;

public class HomePage extends BaseClass{

	@FindBy(xpath = "//span[@class='user-display']")
	WebElement userDisplay;
	
	@FindBy(xpath="//a[@href='/deals']")
	WebElement dealLink;
	
	public HomePage() throws IOException {
		PageFactory.initElements(driver, this);
    }
	
	public String checkUserDisplay() {
		return userDisplay.getText();
	}
	
	public DealPage clickOnDealLink() throws IOException {
		dealLink.click();
		return new DealPage();
	}

}
