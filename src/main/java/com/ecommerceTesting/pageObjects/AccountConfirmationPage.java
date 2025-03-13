package com.ecommerceTesting.pageObjects;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountConfirmationPage{

	
	@FindBy(xpath="//h2[@class='title text-center']/b")
	WebElement accountCreatedMessage;
	
	@FindBy(xpath="//a[text()=\"Continue\"]")
	WebElement continuebtn;

	public WebDriver driver;
	
	public AccountConfirmationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean isAccountCreatedVisible() {
	    try {
	        
	        return accountCreatedMessage.isDisplayed();
	    } catch (NoSuchElementException e) {
	        return false;
	    }
	}
	
	public void clickOnContinue() {
		continuebtn.click();
	}

}
