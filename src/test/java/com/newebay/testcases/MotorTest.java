package com.newebay.testcases;

//import org.apache.log4j.Logger;
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

public class MotorTest extends NewTestBase {
	
	LoginPage login;
	HomePage homepage;
	MotorPage motorpage;
	//Logger log = Logger.getLogger(MotorTest.class);
	
	public MotorTest(){
		super();
	}
	@BeforeMethod
	public void setUp()
	{
		intialization();
		login=new LoginPage();
		homepage=login.signINLogin(prop.getProperty("username"), prop.getProperty("password"));
		motorpage=homepage.clickOnMotor();		
	}
	@Test(priority=1)
	public void verifyTitleMotor()
	{
		String Title = motorpage.validateTitle();
		System.out.println(Title);
		//log.info("Verifying title");
		
		
	}
	@Test(priority=2)
	public void verifyLogoMotor()
	{
		boolean logocheck = motorpage.validateLogo();
	//	log.info("Verifying LOGO motor");
		Assert.assertTrue(logocheck);
	}
	@Test(priority=3)
	public void verifyClickOnCar()
	{
		//log.info("clicking on motor link");
		motorpage.clickOncarandTruck();
		
	}
	@Test(priority=4)
	public void verifySelectYear()
	{
		motorpage.validateClickYear();
		String year = new Select(driver.findElement(By.name("Year"))).getFirstSelectedOption().getText();
		//log.info("veryfying select year");
		Assert.assertEquals(year, "2016");
	}
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}

}
