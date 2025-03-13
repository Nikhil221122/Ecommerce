package com.ecommerceTesting.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ProductSearchPage {
	WebDriver driver;

	
	public ProductSearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean isSearchedProductVisible(String productName) {
		String dynamicPath = "//p[text()='" + productName + "']";
		WebElement prodName = driver.findElement(By.xpath(dynamicPath)); 
		
		return prodName.isDisplayed();
	}

}
