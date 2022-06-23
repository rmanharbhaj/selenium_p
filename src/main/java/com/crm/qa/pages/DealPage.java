package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.BaseClass;

public class DealPage extends BaseClass{

	@FindBy(xpath = "//i[@class='money icon']")
	WebElement dealHeader;
	
	@FindBy(xpath = "//button[contains(text(),'Create')]")
	WebElement creatDeal;
	
	@FindBy(xpath = "//input[@name='title']")
	WebElement titleName;
	
	@FindBy(xpath="//div[@name='company']")
	WebElement companyName;
	
	@FindBy(xpath = "//input[@name='amount']")
	WebElement amountPrice;
	
	@FindBy(xpath = "//button[@class='ui linkedin button']")
	WebElement saveButton;
	
	public DealPage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	public void createDeal(String title,String company,String amount) {
		titleName.sendKeys(title);
		companyName.sendKeys(company);
		amountPrice.sendKeys(amount);
		saveButton.click();
		
	}

}
