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
import com.qa.hubspot.pages.MeetingsLiveChat;
import com.qa.hubspot.utils.Constants;

public class MeetingsChatPageTest extends BaseTest {

//WebDriver driver;
//BasePage basePage;
//Properties prop;
//LoginPage loginPage;
HomePage homePage;
MeetingsLiveChat meetingsLiveChat;


//@BeforeTest
//@BeforeMethod
@BeforeClass
public void meetingChatPageSetUp(){
	
//	basePage=new BasePage();
//	prop=basePage.init_prop();
//	driver=basePage.init_driver(prop);
//	loginPage=new LoginPage(driver);
	homePage=loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	meetingsLiveChat=homePage.doClickMettingChatTool();
	
	
	
	
}
@Test(dependsOnMethods= {"verifyGetTitleOFChatPageHeaderTest"}, enabled=false)
public void verifyGetTitleOFChatPageTest() {
	System.out.println(Thread.currentThread().getId());
	String title=meetingsLiveChat.getTitleOfLiveChatPage();
	System.out.println("Tilte of the Chat page is:"+title);
	Assert.assertEquals(title, Constants.Meeting_Page_Chat_Title);
}
@Test
public void verifyGetTitleOFChatPageHeaderTest() {
	System.out.println(Thread.currentThread().getId());
	String header=meetingsLiveChat.getHeaderOfChatPage();
	System.out.println("header of the Chat page is:"+header);
	Assert.assertEquals(header, Constants.Meeting_page_Chat_Header);
}



////@AfterTest
//@AfterMethod
//public void tearDown() {
//	driver.quit();
//	
//	
//}





}
