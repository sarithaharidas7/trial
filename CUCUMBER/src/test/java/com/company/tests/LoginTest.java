package com.company.tests;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.company.pages.Login;
import com.company.testbase.TestBase;
import com.company.util.Util;

public class LoginTest extends TestBase {
	
	Login Login;
	Util Util;
	Logger log;
	WebDriver driver;
	
	public LoginTest()
	{
		super();
	}
	
	
	@BeforeClass
	public void Initialisation() 
	{
		Initialization() ;
		this.driver=getDriver();
		 Util=new Util(this.driver);

		Login=new Login(this.driver);
		 log= LogManager.getLogger(LoginTest.class);

	}
	
	@DataProvider(name="testdata")
	public  Object[][] readDataFromExcel() throws IOException
	{
		Object[][] data= Util.readExcel();
		return data;
		
	}
	
	@Test(priority=1,dataProvider="testdata")
	public void LoginPageTest(String testCase,
            String createData,
            String type,
            String company,
            String contactType,
            String caller,
            String assignmentGroup,
            String area,
            String configurationItem,
            String category,
            String channel,
            String shortDescription,
            String description,
            String attachment,
            String assignedTo,
            String subCategory,
            String businessService,
            String field1,
            String field2,
            String field3,
            String field4,
            String field5,
            String field6,
            String approvalRequired,
            String incidentID) throws IOException
	{    // Util.readExcel();
	//System.out.println(">>>incidentID "+incidentID+"is assigned to"+assignedTo);
	
		log.info("login test started>>>>>");

		Login.Loginfunction();
		Assert.assertEquals(getDriver().getCurrentUrl(), "https://practicetestautomation.com/logged-in-successfully/");
		System.out.println(">>>login successful");
	    log.debug("Debug message at a strategic point...");

		log.info(" login test completed>>>>>");
	
	}
	
	@AfterClass
	public void tearDown()
	{
		if (driver != null) {
			driver.quit();
            log.info("Driver quit successfully.");
        }
	}
	
}
