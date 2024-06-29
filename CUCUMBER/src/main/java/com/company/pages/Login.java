package com.company.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.company.testbase.TestBase;
import com.company.util.Util;

public class Login extends TestBase {
	Util Util;
	WebDriver driver;
	@FindBy(id="username")
	private WebElement username;
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="submit")
	private WebElement submit;
	
	@FindBy(xpath="//*[@class='post-header']/h1")
	private WebElement LoginSuccessMessage;
	
	public Login(WebDriver driver)
	{
		this.driver=driver;
		System.out.println(" >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> loginpage driver is "+ this.driver);
		PageFactory.initElements(this.driver, this);
		 Util=new Util(this.driver);
	}
	
	public WebElement GetUserName() {
		return username;
	}
	
	public WebElement Getpassword() {
		return password;
	}
	
	public WebElement GetSubmitButton() {
		return submit;
	}

	public void Loginfunction() 
	
	{
		Util.expliciwait().until(ExpectedConditions.visibilityOf(username));
		username.sendKeys(prop.getProperty("username"));
		password.sendKeys(prop.getProperty("pwd"));
		submit.click();
		
		
		
	}
	public void LoginSuccessTextVerification(String successmsessage) {
		Assert.assertTrue(LoginSuccessMessage.getText().equalsIgnoreCase(successmsessage), "Success message not shown properly");
		
	}

}
