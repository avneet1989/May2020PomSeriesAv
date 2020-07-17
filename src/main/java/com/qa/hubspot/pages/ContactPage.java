package com.qa.hubspot.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ElementUtility;

public class ContactPage extends BasePage {
	
	
	WebDriver driver;
	ElementUtility elutl;
	
	
	//1. elements locators	
	By header=By.cssSelector(".IndexPageRedesignHeader__StyledH1-ljkrr-1.dTXiYC");
	By createContactsPrimary=By.xpath("//span[text()='Create contact']");
	By email=By.xpath("//input[@data-field='email']");
	By firstName= By.xpath("//input[@data-field='firstname']");
	By lastName= By.xpath("//input[@data-field='lastname']");
	By jobTitle=By.xpath("//input[@data-field='jobtitle']");
	By createContactSecondary= By.xpath("(//span[text()='Create contact'])[2]");
	By nameAfterCreate=By.xpath("(//h2[@class='m-bottom-1']//span)[1]");
	By contactsBackLink=By.xpath("(//*[text()='Contacts'])[1]");
	By tableName=By.xpath("//tbody[@class='Tbody-qo3zmn-0 kUrJrb']/tr/td[2]//a");

	
	
	// 2. create controctor of this page and reference at class level also.
	public ContactPage(WebDriver driver) {
		this.driver=driver;
		elutl=new ElementUtility(driver);
	}
	
	// action on locators
	public String getContactPageTitle() {
		return elutl.doGetPageTitleWithIsTitle(10, Constants.Contact_page_Title);
	}
	
	
	
	public void fillCreateContactForm(String emailId, String firstName, String lastName, String jobTitle) {
		elutl.clickWhenReady(5, createContactsPrimary);
		elutl.waitForElementToBeVisible(5, email);
		elutl.doSendKeys(this.email, emailId);
		elutl.doSendKeys(this.firstName, firstName);
		elutl.doSendKeys(this.lastName, lastName);
		//elutl.waitForElementToBeVisible(5, this.jobTitle);
		elutl.doActionSendKeys(this.jobTitle, jobTitle);
		//elutl.doSendKeys(this.jobTitle, jobTitle);
		elutl.doClick(createContactSecondary);
		elutl.clickWhenReady(5, contactsBackLink);
		
	}
	
	
	public List<String> clickEachNameOfContact() {
		List<String> nameList=new ArrayList<String>();
		
		List<WebElement> listOfAll =driver.findElements(tableName);
		for (int i=0;i<listOfAll.size();i++) {
			elutl.waitForElementToBeVisible(3, tableName);
			elutl.doIsDisplay(tableName);
				elutl.doClick(tableName);
				elutl.isElementDisplayed(nameAfterCreate, 2);
				 String text=elutl.doGetText(nameAfterCreate);
				 nameList.add(text);
				 elutl.doClick(contactsBackLink);
				 				 
			}
		
		return nameList;
		
	}
	
	public String checkCorrectname() {
		if(elutl.isElementDisplayed(nameAfterCreate, 2))
		 return elutl.doGetText(nameAfterCreate);
		
		return null;
				
	}
	public void backToListContactPage() {
		elutl.doClick(contactsBackLink);
		
		
		
	}
	
}
