package com.newebay.testcases;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.newebay.base.NewTestBase;
import com.newebay.page.HomePage;
import com.newebay.page.LoginPage;
import com.newebay.page.MotorPage;

public class HomeTest extends NewTestBase {
	
	LoginPage login;
	HomePage homepage;
	MotorPage motor;
	
	public HomeTest()
	{
		super();
	}
	@BeforeMethod
	public void setUP()
	{
		intialization();
		login= new LoginPage();
		homepage=login.signINLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	@Test(priority=1)
	public void verifyHomeTitle()
	{
		String Title = homepage.validateHomeTitle();
		System.out.println(Title);
	}
	@Test(priority=2)
	public void verifyLogo()
	{
		boolean logoCheck = homepage.validateHomeLogo();
		Assert.assertTrue(logoCheck);
	}
	@Test(priority=6)
	public void verifyClickOnMotor()
	{
		homepage.clickOnMotor();
		
	}
	@Test(priority=3)
	public void validateCategoryList()
	{
		homepage.ValidateCategory();
		String cattitle = new Select (driver.findElement(By.id("gh-cat"))).getFirstSelectedOption().getText();
		Assert.assertEquals(cattitle, "Music");
		
	}
	@Test(priority=4)
	public void verifySearchList() throws InterruptedException
	{
		homepage.ValidateSearchList();
		String searchText = driver.findElement(By.id("gh-ac")).getAttribute("value");
		System.out.println("Search text-->"+searchText);
	}
	@Test(priority=5)
	public void verifyScroll()
	{
		homepage.validateScroll();
	}
	
	@AfterMethod()
	public void tearDown()
	{
		driver.close();
	}

}
