package com.qa.hubspot.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.qa.hubspot.pages.LoginPage;

public class BaseTest {

	public BasePage basePage;
	public Properties prop;
	public WebDriver driver;
	public LoginPage loginPage;
	
	
		@BeforeTest
		//@BeforeMethod
		public void setUp() {
			basePage= new BasePage();
			prop= basePage.init_prop();
			 driver=basePage.init_driver(prop);
			 loginPage= new LoginPage(driver);
		}
	
	
		@AfterTest
	//@AfterMethod
		public void tearDown() {
			driver.quit();
		}
	
	
	
	
}
