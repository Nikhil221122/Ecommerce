package com.ecommerceTesting.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPlacedPage{

	WebDriver driver;

	@FindBy(xpath = "//p[contains(text(), 'order has been confirmed')]")
	WebElement orderPlacedTxt;

	public OrderPlacedPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public String orderPlacedMsg() {
		return orderPlacedTxt.getText();
	}
}
