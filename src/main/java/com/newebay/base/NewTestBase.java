package com.newebay.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;






public class NewTestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static ExtentReports extent;
	public static ExtentTest extentTest;
	
	public NewTestBase() 
	{
		try
		{
			prop = new Properties();
			FileInputStream fip = new FileInputStream("C:/Users/rajam/workspace/NewEbayTest/src/main/java/com/newebay/config/config.properties");
			prop.load(fip);
		}catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		
	}
	
	public void intialization()
	{
		String browsername=prop.getProperty("browser");
		if(browsername.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C://Users//rajam//Downloads//chromedriver//chromedriver.exe");
			driver = new ChromeDriver();
		}else if(browsername.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C://Users//rajam//Downloads//geckodriver-v0.19.0-win64//geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
	
		
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	
	}

	public void failed()
	{
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try{
			FileUtils.copyFile(srcFile, new File("C:/Users/rajam/workspace/NewEbayTest/screenshot/testFailue.png"));
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}
	
	
	public static void setExtent()
	{
		extent = new ExtentReports("C:/Users/rajam/workspace/NewEbayTest/test-output/test-output/ExtentReport.html", true);
		extent.addSystemInfo("User Name", "rajam");
	}
	public static void endReports()
	{
		extent.flush();
		extent.close();
	}
	public static void resultExtent(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			extentTest.log(LogStatus.FAIL, "Test case Failed is"+result.getName());//to add name in extent report
			extentTest.log(LogStatus.FAIL, "Test case Failed is"+result.getThrowable());//to add error in extent report
			//String screenpath=LoginTest.getScreenshot(driver, result.getName());
			//extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenpath));//to add screenshot in extent report
		}else if(result.getStatus()==ITestResult.SKIP){
			extentTest.log(LogStatus.SKIP, "Test case Skip is"+result.getName());
		}else if(result.getStatus()==ITestResult.SUCCESS){
			extentTest.log(LogStatus.PASS, "Test case Passed is"+result.getName());
		}
		extent.endTest(extentTest);
		
	}
	

}
