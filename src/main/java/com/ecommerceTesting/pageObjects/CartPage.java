package com.ecommerceTesting.pageObjects;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecommerceTesting.utility.WaitUtil;

public class CartPage{

	WebDriver driver;
	CheckoutPage checkOutPage;
	LandingPage landingPage;
	SignupPage signupPage;
	@FindBy(css = ".cart_description")
	List<WebElement> products;

	@FindBy(xpath = "//a[text()=\"Proceed To Checkout\"]")
	WebElement checkOutBtn;

	@FindBy(css = "#cart_info_table")
	List<WebElement> cartItems;

	@FindBy(css = ".modal-content")
	WebElement loginPopUp;

	@FindBy(xpath = "//div[@class='modal-body']//a")
	WebElement loginBtn;

	By checkout = By.xpath("//a[text()='Proceed To Checkout']");
	public CartPage(WebDriver driver) {
		this.driver = driver;
		landingPage = new LandingPage(driver);
		signupPage = new SignupPage(driver);
		PageFactory.initElements(driver, this);
	}

	public List<WebElement> extractProduct(String product1, String product2) {
		WebElement prod1 = products.stream().filter(s -> s.findElement(By.tagName("h4")).getText().equals(product1))
				.findFirst().orElse(null);
		WebElement prod2 = products.stream().filter(s -> s.findElement(By.tagName("h4")).getText().equals(product2))
				.findFirst().orElse(null);

		return Arrays.asList(prod1, prod2);
	}

	public boolean verifyProductAddedInCart(String product1, String product2) {
		List<WebElement> productsInCart = extractProduct(product1, product2);
		return productsInCart.get(0).isDisplayed() && productsInCart.get(1).isDisplayed();
	}

	public CheckoutPage clickOnCheckOut() {
		
		WaitUtil.waitForElementToBeClickable(driver, checkout);
		checkOutBtn.click();

		if (isLoginPopupDisplayed()) {
			handleLoginPopup();
			checkOutBtn.click();
		}
		checkOutPage = new CheckoutPage(driver);
		return checkOutPage;
	}

	private void handleLoginPopup() {
		loginBtn.click();
		signupPage.login("bhosale@bhosale.com", "12345678");
		landingPage.clickOnCart();
	}

	private boolean isLoginPopupDisplayed() {

		return loginPopUp.isDisplayed();
	}

}
