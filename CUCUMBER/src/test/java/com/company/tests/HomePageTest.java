package com.company.tests;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.company.pages.HomePage;
import com.company.pages.Login;
import com.company.testbase.TestBase;

public class HomePageTest extends TestBase {
	Login Login;
	HomePage HomePage;
	  Logger log;
	WebDriver driver;
	public HomePageTest()
	{
		super();
		
	}
	
	@BeforeMethod()
	public void setup() 
	{
		Initialization();
		
		 log=LogManager.getLogger(HomePageTest.class);
		 this.driver=getDriver();
		 Login=new Login( this.driver);
		 Login.Loginfunction();
		 HomePage=new HomePage( this.driver);
		 HomePage.NavigateToHomepage();
		   
           log.info("hometest initialization successfully.");

		 	
	}
		
	
		@Test(priority=1)
	public void VerifycheatSheetEmailSent() throws InterruptedException {
		
		log.info("VerifycheatSheetEmailSent started");
		Thread.sleep(2000);
		HomePage.cheatSheetContact();
		Assert.assertTrue(HomePage.TitleVisible());
		log.info("VerifycheatSheetEmailSent ended");

		
		
	}
	
	@Test(priority=2)
	public void VerifycheatSheetEmailSuccess() throws InterruptedException {
		log.info("VerifycheatSheetEmailSuccess started");

		HomePage.cheatSheetContact();
		Thread.sleep(2000);
		System.out.println(">>>>test git");

		Assert.assertEquals(HomePage.TitlePrinting(), "Confirm you’re not a robot", "Email not sent successfully,text mismatch");	
		log.info("VerifycheatSheetEmailSuccess ended");

		
	}
	@AfterMethod
	public void tearDown() {		
		
		if (driver != null) {
			driver.quit();
            log.info("Driver quit successfully.");
        }		
	}
	
}
