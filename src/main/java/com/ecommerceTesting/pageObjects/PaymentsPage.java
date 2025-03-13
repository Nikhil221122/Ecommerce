package com.ecommerceTesting.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentsPage {

	WebDriver driver;

	@FindBy(name = "name_on_card")
	WebElement NameOnCard;

	@FindBy(name = "card_number")
	WebElement cardNumber;

	@FindBy(name = "cvc")
	WebElement cvc;

	@FindBy(name = "expiry_month")
	WebElement expiryMonth;

	@FindBy(name = "expiry_year")
	WebElement expiryYear;

	@FindBy(id = "submit")
	WebElement payAndConfirmBtn;

	JavascriptExecutor js;
	By successMsgAlert = By.id("success_message");

	public PaymentsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterPaymentDetails(String name, String cardNo, String cvv, String expMon, String expYear) {
		NameOnCard.sendKeys(name);
		cardNumber.sendKeys(cardNo);
		cvc.sendKeys(cvv);
		expiryMonth.sendKeys(expMon);
		expiryYear.sendKeys(expYear);
	}

	public OrderPlacedPage clckOnPayAndConfirm() {
		payAndConfirmBtn.click();
		return new OrderPlacedPage(driver);
	}
}
