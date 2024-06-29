package com.company.stepefinitionsimpl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.company.pages.Login;
import com.company.testbase.TestBase;
import com.company.util.Util;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginTestCucumber  extends TestBase 
{
	
	WebDriver driver;
	Util Util;
	Login Login;
	
	@Given("I landed on URL")
	public void I_landed_on_URL()
	{
		Initializationcucu("chrome") ;
		this.driver=getDriver();
		 Util=new Util(this.driver);

		Login=new Login(this.driver);
	} 
	
	@Given("I waited for the page to load completely load")
	public void I_waited_for_the_page_to_load_completely_load()
	{
		Util.expliciwait().until(ExpectedConditions.visibilityOf(Login.GetUserName()));
	}
		
	@When("^I have entered Username (.+) and password (.+)$")
	public void I_have_entered_Username_and_password(String name, String pwd) {
	    Login.GetUserName().sendKeys(name);
	    Login.Getpassword().sendKeys(pwd);
	}
	
	@And("I click on  the submit button")
	public void I_click_on_the_submit_button()
	{
		Login.GetSubmitButton().click();;
	}
	
	@Then("I should redirect to homepage")
	public void I_should_redirect_to_homepage()
	{
		Assert.assertEquals(getDriver().getCurrentUrl(), "https://practicetestautomation.com/logged-in-successfully/");

	}
	@And("I verify the {string} message in screen")
	public void I_verify_the_message_in_screen(String success)
	{
		Login.LoginSuccessTextVerification(success);
	}

}
