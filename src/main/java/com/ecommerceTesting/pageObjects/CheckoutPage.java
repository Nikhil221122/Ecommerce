package com.ecommerceTesting.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage{

	WebDriver driver;

	@FindBy(css = "tr td:nth-child(5) p")
	List<WebElement> Prices;

	@FindBy(css = "tr td:nth-child(4) p")
	WebElement totalAmount;

	@FindBy(css = ".check_out")
	WebElement placeOrderBtn;

	public double getTotalProductPrice() {
		double totalPrice = 0.0;

		for (WebElement priceElement : Prices) {

			String priceText = priceElement.getText();
			String cleanPrice = priceText.replace("Rs. ", "").trim();

			try {
				double price = Double.parseDouble(cleanPrice);
				totalPrice += price;
			} catch (NumberFormatException e) {
				System.out.println("Invalid price format: " + cleanPrice);
			}
		}

		return totalPrice;
	}

	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public double getTotalAmount() {

		return Double.parseDouble(totalAmount.getText().replace("Rs. ", "").trim());
	}

	public PaymentsPage clickOnPlaceOrder() {
		placeOrderBtn.click();
		return new PaymentsPage(driver);
	}

}
