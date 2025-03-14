package com.ecommerceTesting.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecommerceTesting.utility.ScrollUtility;
import com.ecommerceTesting.utility.WaitUtil;

public class LandingPage {
	WebDriver driver;
	SignupPage signuppage;
	ContactUsPage contactUsPage;
	ProductsPage productsPage;
	CartPage cartPage;
	@FindBy(xpath = "//a[contains(text(),'Home')]")
	WebElement homeBtn;

	@FindBy(xpath = "//a[@href='/login']")
	WebElement signupLoginBtn;

	@FindBy(xpath = "//a[contains(text(),'Delete Account')]")
	WebElement deleteBtn;

	@FindBy(xpath = "//li/a[contains(text(), 'Logged in as')]")
	WebElement loggedInMessage;

	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	WebElement logoutBtn;

	@FindBy(xpath = "//a[@href='/contact_us']")
	WebElement ContactUsButton;
	
	@FindBy(xpath = "//a[@href='/products']")
	WebElement  productsBtn;
	 
	@FindBy(xpath = "//li/a[@href='/view_cart']")
	WebElement cartBtn; 
	
	@FindBy(css = ".single-widget h2")
	WebElement  subscriptionTxt;
	
	@FindBy(css = "#susbscribe_email")
	WebElement  subEmail; 
	
	@FindBy(css = "#subscribe")
	WebElement  subBtn;
	
	@FindBy(css=".alert-success.alert")
	WebElement subSuccessTxt;
	
	
	@FindBy(css=".carousel-inner")
	WebElement carousel;
	
	By subSuccessAlert = By.cssSelector(".alert-success.alert");
	By signUpLogin = By.xpath("//a[@href='/login']");
	public LandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}	

	public SignupPage clickSignupLogin() {
		WaitUtil.waitForElementToBeVisible(driver, signupLoginBtn);
		signupLoginBtn.click();
		signuppage = new SignupPage(driver);
		return signuppage;
	}

	public void clickOnLogoutbtn() {
		WaitUtil.waitForElementToBeVisible(driver, logoutBtn);
		logoutBtn.click();
	}

	public ContactUsPage clickOnContactUs() {
		
		WaitUtil.waitForElementToBeVisible(driver, ContactUsButton);
		ContactUsButton.click();
		contactUsPage = new ContactUsPage(driver);
		return contactUsPage;
	}
	
	public CartPage clickOnCart() {
		WaitUtil.waitForElementToBeVisible(driver, cartBtn);
		cartBtn.click();
		cartPage = new CartPage(driver);
		return cartPage;
	}

	public boolean isHomePageVisible() {
		return carousel.isDisplayed();
	}

	public boolean isUserLoggedIn() {

		return loggedInMessage.isDisplayed();
	}

	public void clickOnDelete() {
		deleteBtn.click();
	}
	
	public ProductsPage clickOnProducts() {
		WaitUtil.waitForElementToBeVisible(driver, productsBtn);
		productsBtn.click();
		productsPage = new ProductsPage(driver);
		return productsPage;
	}
	
	public boolean checkSubscription(String email) {
		ScrollUtility.scrollToElement(driver, subscriptionTxt);
		subscriptionTxt.isDisplayed();
		subEmail.sendKeys(email);
		subBtn.click();
		WaitUtil.waitForElementToBeVisible(driver, subSuccessTxt);
		return subSuccessTxt.isDisplayed();
	}
	
	

}
