package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.pages.Meetings;
import com.qa.hubspot.utils.Constants;

public class MeetingPageTest extends BaseTest {
	// TestNG----unit testing framework, used by developer.
	
			// used to do validation/ assertion on pages.
//	WebDriver driver;
//	Properties prop;
//	BasePage basePage;
//	LoginPage loginPage;
	HomePage homePage;
	Meetings meetings;
	
	
//@BeforeTest
//@BeforeMethod
@BeforeClass
	public void meetingPageSetUp() {	

//	basePage=new BasePage();
//	prop=basePage.init_prop();
//	driver=basePage.init_driver(prop);
//	loginPage=new LoginPage(driver);	
	homePage=loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	//homePage=new HomePage(driver);
	meetings=homePage.doClickMettingTools();
	
	}
	
	@Test(priority=1)
	public void verifyMeetingPageTitleTest() {
		System.out.println(Thread.currentThread().getId());
	String title=meetings.getTitleOfMeetingPage();
	System.out.println("Meeting Page title is: "+title);
	Assert.assertEquals(title, Constants.Meeting_Page_Title);
		
	}
	@Test(priority=2)
	public void verifyMeetingPageHeaderTest() {
		System.out.println(Thread.currentThread().getId());
		String header=meetings.getMeetingPageHeader();
		System.out.println("Meeting Page header is: "+header);
		Assert.assertEquals(header, Constants.Meeting_page_Header);
	}
	
	
//	//@AfterTest
//	@AfterMethod
//	public void tearDown() {
//		driver.quit();
//	}
//	

}
