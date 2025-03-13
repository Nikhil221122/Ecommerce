package com.ecommerceTesting.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecommerceTesting.utility.WaitUtil;

public class ContactUsPage {
	WebDriver driver;

	public ContactUsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "input[name=\"name\"]")
	WebElement Name;
	
	@FindBy(css = "input[name=\"email\"]")
	WebElement Email;
	
	@FindBy(css = "input[name=\"subject\"]")
	WebElement Subject;
	
	@FindBy(css = "textarea[name=\"message\"]")
	WebElement Message;
	
	@FindBy(css = "input[type=\"file\"]")
	WebElement File;
	
	@FindBy(css = "input[type=\"submit\"]")
	WebElement SubmitBtn;
	
	@FindBy(css = "div[class=\"status alert alert-success\"]")
	WebElement  successMsg; 
	
	@FindBy(css = ".btn.btn-success")
	WebElement  homeBtn;
	
	public void enterDetails(String name,String email,String subject,String message,String filepath) {
		Name.sendKeys(name);
		Email.sendKeys(email);
		Subject.sendKeys(subject);
		Message.sendKeys(message);
		File.sendKeys(filepath);
	}
	
	public void clickSubmit() {
		SubmitBtn.click();
		WaitUtil.waitForAlertTobePresent(driver);
		driver.switchTo().alert().accept();
		 
	}
	
	public String successMsg() {
		return successMsg.getText();
	}

	public void clickOnHome() {
		homeBtn.click();
	}
}
