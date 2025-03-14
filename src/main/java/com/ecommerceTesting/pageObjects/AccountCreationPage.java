package com.ecommerceTesting.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.ecommerceTesting.utility.WaitUtil;

public class AccountCreationPage {
	WebDriver driver;
	AccountConfirmationPage accountconfirmationpage;
	
	@FindBy(id = "id_gender1")
	private WebElement genderMaleRadioButton;

	@FindBy(id = "password")
	private WebElement passwordInput;

	@FindBy(id = "days")
	private WebElement dayDropdown;

	@FindBy(id = "months")
	private WebElement monthDropdown;

	@FindBy(id = "years")
	private WebElement yearDropdown;

	@FindBy(id = "newsletter")
	private WebElement newsletterCheckbox;

	@FindBy(id = "optin")
	private WebElement offersCheckbox;

	@FindBy(id = "first_name")
	private WebElement firstNameInput;

	@FindBy(id = "last_name")
	private WebElement lastNameInput;

	@FindBy(id = "address1")
	private WebElement address1Input;

	@FindBy(id = "country")
	private WebElement countryDropdown;

	@FindBy(id = "state")
	private WebElement stateInput;

	@FindBy(id = "city")
	private WebElement cityInput;

	@FindBy(id = "zipcode")
	private WebElement zipcodeInput;

	@FindBy(id = "mobile_number")
	private WebElement mobileNumberInput;

	@FindBy(xpath = "//button[text()='Create Account']")
	private WebElement createAccountButton;

	// Constructor
	public AccountCreationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void fillAccountDetails(String password, String day, String month, String year, String firstName,
			String lastName, String address, String state, String city, String zipcode, String mobileNumber) {
// Gender Selection
		WaitUtil.waitForElementToBeVisible(driver,genderMaleRadioButton );
		genderMaleRadioButton.click();

// Password
		passwordInput.sendKeys(password);

// Date of Birth
		Select daySelect = new Select(dayDropdown);
		daySelect.selectByValue(day); // e.g., "22"

		Select monthSelect = new Select(monthDropdown);
		monthSelect.selectByVisibleText(month); // e.g., "November"

		Select yearSelect = new Select(yearDropdown);
		yearSelect.selectByValue(year); // e.g., "2000"

// Checkboxes for Newsletter and Offers
		newsletterCheckbox.click();
		offersCheckbox.click();

// Address Details
		firstNameInput.sendKeys(firstName);
		lastNameInput.sendKeys(lastName);
		address1Input.sendKeys(address);

// Country Selection (Fixed to India)
		Select countrySelect = new Select(countryDropdown);
		countrySelect.selectByVisibleText("India");

		stateInput.sendKeys(state);
		cityInput.sendKeys(city);
		zipcodeInput.sendKeys(zipcode);
		mobileNumberInput.sendKeys(mobileNumber);
	}

	public AccountConfirmationPage clickCreateAccount() {
		createAccountButton.click();
		accountconfirmationpage = new AccountConfirmationPage(driver);
		return accountconfirmationpage;
	}

}
