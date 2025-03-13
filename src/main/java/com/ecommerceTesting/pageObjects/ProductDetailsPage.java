package com.ecommerceTesting.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage {
	WebDriver driver;
	String Category;

	@FindBy(css = ".product-information h2")
	WebElement productName;

	@FindBy(xpath = "//p[contains(text(),'Category:')]")
	WebElement category;

	@FindBy(css = ".product-information span:nth-child(1)")
	WebElement price;

	@FindBy(xpath = "//b[contains(text(),'Availability:')]")
	WebElement availability;

	@FindBy(xpath = "//b[contains(text(),'Condition:')]")
	WebElement condition;

	@FindBy(xpath = "//b[contains(text(),'Brand')]")
	WebElement brand;

	public ProductDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String isProductDetailsPageDisplayed() {
		return driver.getCurrentUrl();
	}

	public boolean areDetailsVisible() {
		boolean isProductVisible = productName.isDisplayed();
		boolean isCategoryVisible = category.isDisplayed();
		boolean isAvailabilityVisible = availability.isDisplayed();
		boolean isConditionVisible = condition.isDisplayed();
		boolean isBrandVisible = brand.isDisplayed();

		return isProductVisible && isCategoryVisible && isAvailabilityVisible && isConditionVisible && isBrandVisible;

	}

}
