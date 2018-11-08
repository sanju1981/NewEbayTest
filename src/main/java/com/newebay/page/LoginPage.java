package com.newebay.page;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.newebay.base.NewTestBase;

public class LoginPage extends NewTestBase {
	
	//PageFactory -Object Repository
	@FindBy(id="userid")
	WebElement emailID;
	@FindBy(id="pass")
	WebElement password;
	@FindBy(id="sgnBt")
	WebElement SignButton;
	@FindBy(id="gh-logo")
	WebElement logo;
	
	//PageFactory intialization
	public LoginPage() {
	
		PageFactory.initElements(driver, this);
	}
	
	//PageFactoryActions
	public String validatePageTitle()
	{
		return driver.getTitle();
	}
	public boolean validateLogo()
	{
		return logo.isDisplayed();
	}
	public HomePage signINLogin(String userName,String pass)
	{
		emailID.sendKeys(userName);
		password.sendKeys(pass);
		SignButton.click();
		return new HomePage();
		
	}
	

}
