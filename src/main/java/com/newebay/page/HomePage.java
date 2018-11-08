package com.newebay.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;







import com.newebay.base.NewTestBase;

public class HomePage extends NewTestBase {
	//PageFactory - ObjectReposetry
	@FindBy(id="gh-la")
	WebElement homeLogo;
	@FindBy(xpath="//li[@class='hl-cat-nav__js-tab']//a[text()='Motors']")
	WebElement MotorLink;
	@FindBy(id="gh-cat")
	WebElement Category;
	@FindBy(id="gh-ac")
	WebElement searchList;
	@FindBy(xpath="//ul[@id='ui-id-1']//li")
	List<WebElement> searchListItem;
	@FindBy(xpath="//a[text()='Trending on eBay']")
	WebElement tranding;
	
	
	//PageFactory Initialization
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	//Page factory Actions
	public String validateHomeTitle()
	{
		return driver.getTitle();
	}
	public boolean validateHomeLogo()
	{
		return homeLogo.isDisplayed();
	}
	public MotorPage clickOnMotor()
	{
		MotorLink.click();
		return new MotorPage();
	}
	public void ValidateCategory()
	{
		Category.click();
		List<WebElement> ItemList = driver.findElements(By.xpath("//select[@id='gh-cat']//option"));
		
		for(int i=0;i<ItemList.size();i++)
		{
			
			if(ItemList.get(i).getText().equals("Music"))
			{
				ItemList.get(i).click();
				break;
			}
		} 
		
	}
	
	public void ValidateSearchList() throws InterruptedException
	{
		searchList.sendKeys("Laptop");
		Thread.sleep(2000);
		searchListItem.size();
		for(int i =0;i<searchListItem.size();i++)
		{
			if(searchListItem.get(i).getText().contains("laptop"))
			{
				searchListItem.get(i).click();
				break;
			}
		}
	}
	public void validateScroll()
	{
		WebElement element = tranding;
		JavascriptExecutor JS = (JavascriptExecutor) driver;
		JS.executeScript("arguments[0].scrollIntoView();", element);
		element.click();
		
	}
	
}
