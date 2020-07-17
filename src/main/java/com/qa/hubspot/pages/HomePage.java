package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ElementUtility;

public class HomePage extends BasePage{
	// step 2 global reference to all methods
	private WebDriver driver;
	ElementUtility elutl;
	
	//1. step====By Locators first
	By header=By.cssSelector("h1.private-header__heading.private-header__heading--solo");
	By accountName=By.cssSelector("span.account-name ");
	By mettingsTool=By.cssSelector("div.private-selectable-box__inner.private-selectable-button__inner.private-selectable-button__inner--truncatable");
	By meetingChatTool=By.xpath("(//div[@class='private-selectable-box__inner private-selectable-button__inner private-selectable-button__inner--truncatable'])[2]");
	By contactPageLink=By.cssSelector("a[id*='nav-primary-contacts-branch']");
	By contactOptionLink1=By.cssSelector("a[id*='nav-secondary-contacts']");
	
	//2. step=====create constructor
	
	
	public HomePage(WebDriver driver) {
	this.driver=driver;
	elutl=new ElementUtility(driver);
	}
	
	///3.step====action
	public String getHomePageTitle() {
		//return driver.getTitle();
	return elutl.doGetPageTitleWithIsTitle(10, Constants.Home_page_Title);
	
	}
	
	public String getHomePageHeader() {
//		if(driver.findElement(header).isDisplayed()) 
//			return driver.findElement(header).getText();
		if(elutl.isElementDisplayed(header, 10))
			return elutl.doGetText(header);
		return null;
		
	}
	
	
	
	public String getLoggedInAccountName() {
//		if(driver.findElement(accountName).isDisplayed()) 
//			return driver.findElement(accountName).getText();
		if(elutl.isElementDisplayed(accountName, 10))
			return elutl.doGetText(accountName);
		return null;
		
	}
	
	public Meetings doClickMettingTools() {
		//driver.findElement(mettingsTool).click();
		elutl.doClick(mettingsTool);
		return new Meetings(driver);
	}
	
	public MeetingsLiveChat doClickMettingChatTool() {
		//driver.findElement(meetingChatTool).click();
		elutl.doClick(meetingChatTool);
		return new MeetingsLiveChat(driver);
	}
	
	public ContactPage goToContactPage() {
		clickOnContacts();
		return new ContactPage(driver);
	}
	private void clickOnContacts() {
		elutl.waitForElementPresence(10, contactPageLink);
		elutl.doClick(contactPageLink);
		elutl.clickWhenReady(5, contactOptionLink1);
	}

}
