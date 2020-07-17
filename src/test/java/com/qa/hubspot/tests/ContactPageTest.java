package com.qa.hubspot.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.pages.ContactPage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ExcelUtil;

public class ContactPageTest extends BaseTest{
	
	HomePage homePage;
	ContactPage contactPage;
	
	
	@BeforeClass
	public void contactPagesetUp() {
		homePage=loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		contactPage=homePage.goToContactPage();
				
	}
	
	@Test(priority=1)
	public void verifyContactPageTitle() {
		Assert.assertEquals(contactPage.getContactPageTitle(),Constants.Contact_page_Title);
	}
	@DataProvider
	public Object[][] getContactsTestData() {
		Object data[][]=ExcelUtil.getTestData(Constants.Contacts_sheet_name);
	return data;
	}
	@Test(priority=2, dataProvider="getContactsTestData")
	public void verifyCreateContactFormTest(String emailId,String firstname,String lastname, String jobtitle) {
		contactPage.fillCreateContactForm(emailId, firstname,lastname,jobtitle);
				
	}
	
	@Test(priority=3)
	public void verifyCorrectContactNameTest() {
		List<String> contactName=contactPage.clickEachNameOfContact();
		System.out.println("new contacts name: "+ contactName);
		
		
	}
	

//	@Test(priority=3)
//	public void verifyCorrectContactNameTest() {
//		String contactName=contactPage.checkCorrectname();
//		System.out.println("new contact name is: "+ contactName);
//		Assert.assertEquals(contactName, prop.getProperty("newcontactname"));		
//		
//	}
//	@Test(priority=4)
//	public void clickBackContactNavigationButtonTest() {
//		contactPage.backToListContactPage();
//	}











}
