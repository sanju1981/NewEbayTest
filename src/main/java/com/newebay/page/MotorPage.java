package com.newebay.page;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.newebay.base.NewTestBase;

public class MotorPage extends NewTestBase {
	//Page Factory Object repository
	@FindBy(id="gh-la")
	WebElement motorLogo;
	@FindBy(id="w5-w0-0-CAR_AND_TRUCK-tab")
	WebElement CarandTruck;
	@FindBy(id="w5-w0-CAR_AND_TRUCK_0")
	WebElement clickyear;
	@FindBy(xpath="//select[@class='listbox__control']//option")
	List<WebElement> selectYear;
	
	//Page initialization
	public MotorPage()
	{
		PageFactory.initElements(driver, this);
	}
	//Page factory actions
	public String validateTitle()
	{
		return driver.getTitle();
	}
	public boolean validateLogo()
	{
		return motorLogo.isDisplayed();
	}
	public void clickOncarandTruck(){
		CarandTruck.click();
	}
	public void validateClickYear()
	{
		clickyear.click();
		System.out.println(selectYear.size());
		for(int i=0;i<selectYear.size();i++)
		{
			if(selectYear.get(i).getText().contains("2016"))
			{
				selectYear.get(i).click();
				break;
			}
		}
		
		
	}
	
}
