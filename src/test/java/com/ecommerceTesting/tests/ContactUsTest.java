package com.ecommerceTesting.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecommerceTesting.baseClass.BaseClass;
import com.ecommerceTesting.pageObjects.ContactUsPage;

public class ContactUsTest extends BaseClass {
	ContactUsPage contactUsPage;
	String expectedUrl = "https://www.automationexercise.com/";
	
	String Subject = "Regarding Automation Testing";
	String message = "This is the first line.\nThis is the second line.\nThis is the third line.";
	String filepath= System.getProperty("user.dir")+"\\src\\main\\java\\ecommercetesting\\Resources\\demo.txt";
	
	 @Test
	 public void testContactUs() {
		 contactUsPage =  landingPage.clickOnContactUs();
		 contactUsPage.enterDetails("Nikhil", "123@123.com", Subject, message, filepath);
		 contactUsPage.clickSubmit();
		 Assert.assertEquals(contactUsPage.successMsg(), "Success! Your details have been submitted successfully.");
		 contactUsPage.clickOnHome();
		 Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
	 }
}
