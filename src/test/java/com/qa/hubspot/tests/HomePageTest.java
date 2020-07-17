package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.utils.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
@Epic("Epic - 102 : design Home  page features")
@Feature("US - 201: design Home page title, heade and account names modules...")
public class HomePageTest extends BaseTest{
	
	// TestNG----unit testing framework, used by developer.
	
		// used to do validation/ assertion on pages.
		
		
//		BasePage basePage;
//		Properties prop;
//		WebDriver driver;
//		LoginPage loginPage;
		HomePage homePage;
		
		//@BeforeTest
		@BeforeClass
		public void homePageSetUp() {
//			basePage= new BasePage();
//			prop= basePage.init_prop();
//			 driver=basePage.init_driver(prop);
//			 loginPage= new LoginPage(driver);
			homePage= loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
			 
		}
		
		@Description("verify HomePage title test on the home page")
		@Severity(SeverityLevel.MINOR)
		@Test(priority=2)
		public void verifyHomePageTitleTest() {
		String title=homePage.getHomePageTitle();
			System.out.println("Home page title is: "+title);
			Assert.assertEquals(title, Constants.Home_page_Title);
		}
		@Description("verify header Test on the home page")
		@Severity(SeverityLevel.MINOR)
		@Test(priority=1)
		public void verifyHomePageHeaderTest() {
			String header=homePage.getHomePageHeader();
			System.out.println("home page header is: "+header);
			Assert.assertEquals(header, Constants.Home_Page_Header);
			
			
		}
		@Description("verify logged in user on home page")
		@Severity(SeverityLevel.NORMAL)
		@Test(priority=3)
		public void verifyLoggedInUserTest() {
			String accountName=homePage.getLoggedInAccountName();
			System.out.println("home page user accout name is: "+accountName);
			Assert.assertEquals(accountName, prop.getProperty("accountname"));
			
		}
		
		@Test(priority=4)
		public void verifyMeetingsToolsTest() {
			homePage.doClickMettingTools();
		}
		
		
		//@AfterTest
//		@AfterMethod
//		public void tearDown() {
//			driver.quit();
//		}
		
		
		
		
		
		
		
		
		
		
}
