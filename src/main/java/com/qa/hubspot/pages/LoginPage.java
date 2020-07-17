package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ElementUtility;

import io.qameta.allure.Step;

public class LoginPage extends BasePage {
	// step 1 decleare private webdriver so that no one can access it and it does not have any child class
	
	// step 2 global reference to all methods
	private WebDriver driver;
	ElementUtility elutl;
	
	// declare the by locators
	
	By emailId= By.id("username");
	By password= By.id("password");
	By loginButton=By.id("loginBtn");
	By signUpLink= By.linkText("Sign up");
	
	
	
	
	
	// create the constructor of the this class, to initialize the driver 
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		elutl=new ElementUtility(driver);
	}
	

	// create the action on by locators
	@Step("getting login page title...")
	public String getLoginPageTitle() {
	return elutl.doGetPageTitle(10, Constants.Login_Page_Title);
	}
	@Step("getting sing up link presence...")
	public boolean isSignUpLinkExits() {
		//return driver.findElement(signUpLink).isDisplayed();
		return elutl.doIsDisplay(signUpLink);
	}
	@Step("login with username : {0} and password: {1}")
	public HomePage doLogin(String username, String pwd) {
//		driver.findElement(emailId).sendKeys(username);
//		driver.findElement(password).sendKeys(pwd);
//		driver.findElement(loginButton).click();
		elutl.waitForElementToBeVisible(10, emailId);
		elutl.doSendKeys(emailId, username);
		elutl.doSendKeys(password, pwd);
		elutl.doClick(loginButton);
		
		
		return new HomePage(driver);
		
	}
	
	
	
	
	
	
	
	
	
	
}
