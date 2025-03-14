package com.ecommerceTesting.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecommerceTesting.utility.WaitUtil;

public class SignupPage {

	WebDriver driver;
	AccountCreationPage accountcreationpage;
	@FindBy(css = ".signup-form h2")
	WebElement newUserSignupLocator;

	@FindBy(xpath = "//div[@class=\"login-form\"]/h2")
	WebElement LoginToYourAccountLocator;

	@FindBy(css = "div[class=\"signup-form\"] input[name=\"name\"]")
	WebElement nameInput;

	@FindBy(css = "div[class=\"signup-form\"] input[name=\"email\"]")
	WebElement emailInput;

	@FindBy(css = "div[class=\"login-form\"] input[name=\"email\"]")
	WebElement enterEmail;

	@FindBy(css = "div[class=\"login-form\"] input[name=\"password\"]")
	WebElement enterPassword;

	@FindBy(xpath = "//button[text()=\"Signup\"]")
	WebElement signupButton;

	@FindBy(xpath = "//button[text()=\"Login\"]")
	WebElement loginButton;

	@FindBy(xpath = "//div[@class=\"signup-form\"]/form/p")
	WebElement emailExistsError;

	@FindBy(xpath = "//div[@class='login-form']/form/p")
	WebElement invalidCredentialsMsg;


	public SignupPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean isNewUserSignupVisible() {
		return newUserSignupLocator.isDisplayed();
	}

	public void enterNameAndEmail(String Uname, String email) {
		nameInput.sendKeys(Uname);
		emailInput.sendKeys(email);
		
	}

	public AccountCreationPage clickSignupButton() {
	
		signupButton.click();
		accountcreationpage = new AccountCreationPage(driver);
		return accountcreationpage;

	}

	public String getErrorMessage() {
		return emailExistsError.getText();
	}

	public boolean isLoginToAccountVisible() {
		return LoginToYourAccountLocator.isDisplayed();
	}

	public void login(String username, String password) {
		enterEmail.sendKeys(username);
		enterPassword.sendKeys(password);
		loginButton.click();
	}

	public String loginErrormsgIsDisplayed() {
		WaitUtil.waitForElementToBeVisible(driver, invalidCredentialsMsg);
		return invalidCredentialsMsg.getText();
	}
	
	public boolean isUserLoggedOut() {
	    return loginButton.isDisplayed();
	}
}
