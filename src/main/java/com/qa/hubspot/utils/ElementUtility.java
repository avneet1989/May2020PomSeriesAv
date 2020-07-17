package com.qa.hubspot.utils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtility {
	// without main method
	//without webfactory
	// to asses the driver from mail method we create the constructor on this class to give the same driver value(from main class) to this class from webfactory.
	// give the same driver as of the webfactory driver.
	// private webdriver driver private beacus we dont want anyone else to use this webdriver except this class.
	
	
	private WebDriver driver;
	public ElementUtility(WebDriver driver) {
		this.driver=driver;
	}

	
	// to handle the exception we use the try and catch, we initialize this webelement element to null.
	
	public  WebElement getElement(By locator) {
		WebElement element =null;
		try {
			element = driver.findElement(locator);
		}
		catch(Exception e){
			System.out.println("element could not be created"+ locator);
		}
		return element;
		
	}
		
	public void launchUrl(String url) {
		driver.get(url);
	}
	public String getPageTitle() {
		return driver.getTitle();
	}
	public String getPageCurrentUrl() {
		return driver.getCurrentUrl();
	}
	
	public String getPageText(By locator) {
		return getElement(locator).getText();
		
	}
	public  void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}
	
	public  void doClick(By locator) {
		getElement(locator).click();
	}
	
	public String doGetText(By locator) {
		
		return getElement(locator).getText();
	}
	public void doSelectValueByVisibleText(By locator, String value) {
		
		Select select= new Select(getElement(locator));
		select.selectByVisibleText(value);
		
	}
	
	public boolean doIsDisplay(By locator) {
		 return getElement(locator).isDisplayed();
	}
	
	public void doclose() {
		driver.close();
	}
	
public void withoutSelectclassPrint(By locator) {
	
	List<WebElement> listOfDropDown=driver.findElements(locator);
	for(int i=0;i<listOfDropDown.size();i++) {
		String text=listOfDropDown.get(i).getText();
		System.out.println(text);
		
	}

}


public List<String> ArrayListPrint(By locator) {
	List<String> searchList=new ArrayList<String>();
	List<WebElement> arrayList=driver.findElements(locator);
	for(int i=0;i<arrayList.size();i++) {
		String text=arrayList.get(i).getText();
		searchList.add(text);
	}
	return searchList;
}

public void selectValueWithoutSelectDrop( By locator,String value) {
	
	List<WebElement> listOfDropDown=driver.findElements(locator);
	for(int i=0;i<listOfDropDown.size();i++) {
		String text=listOfDropDown.get(i).getText();
		System.out.println(text);
		if(text.equalsIgnoreCase(value)) {
			listOfDropDown.get(i).click();
			break;
		}
	}

}

public void selectMultiChoiceValues(By locator, String...value) {
	
	List<WebElement> firstOptionList=driver.findElements(locator);
	
	
	for(int i=0;i<firstOptionList.size();i++) {
		String text=firstOptionList.get(i).getText();
		
		System.out.println(text);
		for(int k=0;k<value.length;k++) {
			if(text.equals(value[k])) {
				firstOptionList.get(i).click();
				
			}
			
		}
		
		
	}

}

public void selectAllChoiceValues(By locator, String... value) {
	
	List<WebElement> firstOptionList=driver.findElements(locator);
	
	if (! value[0].equalsIgnoreCase("all")) {
		
	
	for(int i=0;i<firstOptionList.size();i++) {
		String text=firstOptionList.get(i).getText();
		System.out.println(text);
		for(int k=0;k<value.length;k++) {
			
		if(text.equals(value[k])) {
		
			firstOptionList.get(i).click();
			break;
		}
		}
	}
	
	}
// select all the values if value[0]== to all
	// we make int all because value all working like array 
	else {
		try {
		for(int all=0;all<firstOptionList.size();all++) {
			firstOptionList.get(all).click();			
			}}
		catch(Exception e){
			//catch the Exception but donnt throw any exception on screen.
		}
		
		// we will get error becuz all other element are hidden or not intractable.
		// so we use the try catch to handle the exception.
		
	}

}



//****************************Action Class Method  mouse action*****************************
public void doActionClick(By locator) {
	Actions ac= new Actions(driver);
	ac.click(getElement(locator)).perform();
}
public void doActionSendKeys(By locator, String value) {
	Actions ac= new Actions(driver);
	ac.sendKeys(getElement(locator), value).perform();
}

public void doActionsRightClick(By locator) {
	
	
	WebElement mouseRightClick=getElement(locator);
	Actions ac=new Actions(driver);
	//or no need make webelement
	//ac.contextClick(getElement(locator)).perform();
	ac.contextClick(mouseRightClick).perform();
	

}

//*************************EXPLICTLY WAIT UTILITY**************

public String doGetPageTitle(int timeout, String title) {
	WebDriverWait wait= new WebDriverWait(driver, timeout);
	wait.until(ExpectedConditions.titleContains(title));
	return driver.getTitle();
}
public String doGetPageTitleWithIsTitle(int timeout, String title) {
	WebDriverWait wait= new WebDriverWait(driver, timeout);
	wait.until(ExpectedConditions.titleIs(title));
	return driver.getTitle();
	
}
public String doGetPageCurrentUrl(int timeout, String urlval ) {
	WebDriverWait wait= new WebDriverWait(driver, timeout);
	wait.until(ExpectedConditions.urlContains(urlval));
	return driver.getCurrentUrl();		
}

public void waitForElementPresence(int timeout, By locator) {
	WebDriverWait wait= new WebDriverWait(driver, timeout);
	wait.until(ExpectedConditions.presenceOfElementLocated(locator));
}
public WebElement waitForElementToBeVisible(int timeout, By locator) {
	WebElement element= getElement(locator);
	WebDriverWait wait= new WebDriverWait(driver, timeout);
	return wait.until(ExpectedConditions.visibilityOf(element));
}

public List<WebElement> VisiblityOfAllElements(int timeout, By locator) {
	
	WebDriverWait wait= new WebDriverWait(driver, timeout);
	return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
}
public WebElement waitForElementToBeClickable(int timeout, By locator) {
	WebDriverWait wait= new WebDriverWait(driver, timeout);
	return wait.until(ExpectedConditions.elementToBeClickable(locator));
		
}
public void clickWhenReady(int timeout, By locator) {
	WebDriverWait wait= new WebDriverWait(driver, timeout);
	WebElement element= wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();
}

//*************wait for alert************

public Alert waitForAlertPresent(int timeout) {
	
	WebDriverWait wait= new WebDriverWait(driver, timeout);
	return wait.until(ExpectedConditions.alertIsPresent());
}

//****************Custom wait***************

public boolean isElementDisplayed(By locator, int timeout) {
	WebElement element=null;
	boolean flag=false;
	for(int i=0;i<timeout;i++) {
	try {
	
		element=driver.findElement(locator);
		flag=element.isDisplayed();
		break;		
	}catch(Exception e) {
	System.out.println("waiting for element to be present on the page--->"+ i +"sec");
	try{
		Thread.sleep(1000);
		
	}catch(InterruptedException e1) {	
	}
	}
	}
	return flag;
}

public WebElement isElementDisplayedAndWork(By locator, int timeout) {
	WebElement element=null;
	boolean flag=false;
	for(int i=0;i<timeout;i++) {
	try {
	
		element=driver.findElement(locator);
		flag=element.isDisplayed();
		break;		
	}catch(Exception e) {
	System.out.println("waiting for element to be present on the page--->"+ i +"sec");
	try{
		Thread.sleep(1000);
		
	}catch(InterruptedException e1) {	
	}
	}
	}
	return element;
}

//********************Fluent Wait*************
public WebElement waitForElementWithFluentWaitConcept(By locator, int timeOut) {
	Wait<WebDriver> wait= new FluentWait<WebDriver>(driver)
							.withTimeout(Duration.ofSeconds(timeOut))
							.pollingEvery(Duration.ofSeconds(2))
							.ignoring(NoSuchElementException.class);
	
	return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
}




//public WebElement waitForElementWithFluentWait(By locator, int timeOut) {
//	Wait<WebDriver> wait= new FluentWait<WebDriver>(driver)
//							.withTimeout(Duration.ofSeconds(timeOut))
//							.pollingEvery(Duration.ofSeconds(2))
//							.ignoring(NoSuchElementException.class);
//	
//	WebElement element=wait.until(new Function<WebDriver, WebElement>(){
//
//		@Override
//		public WebElement apply(WebDriver driver) {
//			
//			return driver.findElement(locator);
//		}
//		
//	});
//	return element;
//	
//	
//}	
	



}










