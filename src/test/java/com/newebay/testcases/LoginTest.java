package com.newebay.testcases;
/*
 * Author is sanjit kumar
 */

//import java.util.ArrayList;
//import java.util.Iterator;

//import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import com.newebay.base.NewTestBase;
import com.newebay.page.HomePage;
import com.newebay.page.LoginPage;
import com.newebay.util.CustomListner;

@Listeners(CustomListner.class)
public class LoginTest extends NewTestBase {
	LoginPage loginpage;
	HomePage homepage;
	
	//Logger log = Logger.getLogger(LoginTest.class);
	
	public LoginTest()
	{
		super();
	}
	@BeforeMethod
	public void setUp()
	{
		intialization();
		//log.info("lunching chrome");
		loginpage = new LoginPage(); 
	}
	@Test(priority=1)
	public void verifyTitle()
	{
		//log.info("*******Start title test********");
		String Title=loginpage.validatePageTitle();
		System.out.println(Title);
		//log.info("login page title");
		
	}
	@Test(priority=2)
	public void verifyLogo()
	{
		boolean logocheck = loginpage.validateLogo();
		Assert.assertTrue(logocheck);
	}
	
	@Test(priority=3)
	public void clickOnLogin(String firstName,String lastName)
	{
		homepage=loginpage.signINLogin(prop.getProperty("username"), prop.getProperty("password"));
		//homepage = loginpage.signINLogin(firstName, lastName);
	}
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
	

}
