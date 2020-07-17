package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.testlisteners.TestAllureListener;
import com.qa.hubspot.utils.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Epic("Epic - 101 : design login page features")
@Feature("US - 201: design login page title, sign up link and login form modules...")
@Listeners(TestAllureListener.class)
public class LoginPageTest extends BaseTest{
	
	// TestNG----unit testing framework, used by developer.
	
	// used to do validation/ assertion on pages.
	
	
//	BasePage basePage;
//	Properties prop;
//	WebDriver driver;
//	LoginPage loginPage;
//	
//	//@BeforeTest
//	@BeforeMethod
//	public void setUp() {
//		basePage= new BasePage();
//		prop= basePage.init_prop();
//		 driver=basePage.init_driver(prop);
//		 loginPage= new LoginPage(driver);
//	}
	
	@Description("verify sign up link on login page...")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority=1)
	
	public void verifySignUpLinkTest() {
		Assert.assertEquals(loginPage.isSignUpLinkExits(), true);		
	}
	@Description("verify login page title login page...")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority=2)
	public void verifyLoginPageTitleTest() {
		String title=loginPage.getLoginPageTitle();
		System.out.println("Login page title is "+ title);
		Assert.assertEquals(title, Constants.Login_Page_Title);
	}
	@Description("verify user is able to login page...")
	@Severity(SeverityLevel.BLOCKER)
	@Test(priority=3)
	public void verifyLoginTest() {
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
//	//@AfterTest
//	@AfterMethod
//	public void tearDown() {
//		driver.quit();
//	}


}
