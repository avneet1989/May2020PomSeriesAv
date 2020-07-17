package com.qa.hubspot.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ElementUtility;

public class MeetingsLiveChat extends BasePage{
	
	// step 2 global reference to all methods
	private WebDriver driver;
	ElementUtility elutl;
	//1 step
	By header= By.cssSelector("h1.private-header__heading");
	
	
	
	// 2 step constructor
	public MeetingsLiveChat(WebDriver driver) {
		this.driver=driver;
		elutl= new ElementUtility(driver);
	}

	
	
	//3 step action on by locators
	public String getTitleOfLiveChatPage() {
//		return driver.getTitle();
		return elutl.doGetPageTitleWithIsTitle(10, Constants.Meeting_Page_Chat_Title);
	}
	public String getHeaderOfChatPage() {
//		if(driver.findElement(header).isDisplayed())
//			return driver.findElement(header).getText();
		if(elutl.isElementDisplayed(header, 10))
			return elutl.doGetText(header);
		return null;
	}
	
	
	
	
	
}
