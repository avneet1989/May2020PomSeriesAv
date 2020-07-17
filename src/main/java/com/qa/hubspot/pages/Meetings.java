package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ElementUtility;

public class Meetings extends BasePage {
	// step 2 global reference to all methods
	private WebDriver driver;
	ElementUtility elutl;
	//1. by Locators
	
	By header=By.cssSelector("h1.private-header__heading.private-header__heading--solo");
	
	
	//2. step constructor
	
	public Meetings(WebDriver driver) {
		this.driver=driver;
		elutl= new ElementUtility(driver);
	}
	
	
	
	//3step create Acctions on By Locators
	
	public String getTitleOfMeetingPage() {
		//return driver.getTitle();
		return elutl.doGetPageTitleWithIsTitle(10, Constants.Meeting_Page_Title);
	}
	public String getMeetingPageHeader() {
//		if(driver.findElement(heaader).isDisplayed())
//		return	driver.findElement(heaader).getText();
		if(elutl.isElementDisplayed(header, 10))
			return elutl.doGetText(header);
		
		return null;
			
	}
	
	

	

}
