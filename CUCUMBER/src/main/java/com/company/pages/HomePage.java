package com.company.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.company.testbase.TestBase;
import com.company.util.Util;

public class HomePage  extends TestBase{
	
	@FindBy(xpath="//*[@class='menu']/ul/child::li[1]")
	private WebElement homepagemenu;
	
	@FindBy(id="form_first_name_7")
	private WebElement name;
	
	@FindBy(id="form_email_7")
	private WebElement email;
	
	@FindBy(xpath="//*[@data-automation-id='subscribe-submit-button']")
	private WebElement getXpathCheatSheet;
	
	@FindBy(xpath="//*[@class='post-header']/*[@class='post-title']")
	private WebElement ConfirmRoboPage;


	Util Util;

	WebDriver driver;
	
	public HomePage(WebDriver driver){
		this.driver=driver;
		
		PageFactory.initElements(this.driver, this);
		
		 Util=new Util(this.driver);
	}
	
	public HomePage NavigateToHomepage() 
	{
		homepagemenu.click();
		return new HomePage(driver);
	}

	public void cheatSheetContact()
	{
		name.sendKeys("test");
		email.sendKeys("test@gmail.com");
		getXpathCheatSheet.click();
		
	}
	public boolean TitleVisible() 
	
	{
		Util.expliciwait().until(ExpectedConditions.visibilityOf(ConfirmRoboPage));
		
		return ConfirmRoboPage.isDisplayed();
	}
	public String TitlePrinting() 
	{
		return ConfirmRoboPage.getText();
	}
}
