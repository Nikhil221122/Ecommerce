package com.ecommerceTesting.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ecommerceTesting.baseClass.BaseClass;
import com.ecommerceTesting.pageObjects.AccountConfirmationPage;
import com.ecommerceTesting.pageObjects.AccountCreationPage;
import com.ecommerceTesting.pageObjects.SignupPage;

public class SignupTest extends BaseClass {
	SignupPage signuppage;
	AccountCreationPage accountcreationpage;
	AccountConfirmationPage accountconfirmationpage;

	@DataProvider(name = "accountCreationData")
	public Object[][] provideTestData() {
		return new Object[][] { { "Password123", "22", "November", "2000", "John", "Doe", "123 Main St", "California",
				"Los Angeles", "90001", "9876543210" } };
	}

	@Test(dataProvider = "accountCreationData", enabled = true)
	public void AccountCreationTest(String password, String day, String month, String year, String firstName,
			String lastName, String address, String state, String city, String zipcode, String mobileNumber) {

		signuppage = landingPage.clickSignupLogin();
		signuppage.enterNameAndEmail("Nikhil", uniqueEmail);

		accountcreationpage = signuppage.clickSignupButton();
		accountcreationpage.fillAccountDetails(password, day, month, year, firstName, lastName, address, state, city,
				zipcode, mobileNumber);

		accountconfirmationpage = accountcreationpage.clickCreateAccount();
		Assert.assertTrue(accountconfirmationpage.isAccountCreatedVisible());
		accountconfirmationpage.clickOnContinue();
		Assert.assertTrue(landingPage.isUserLoggedIn(), "User is not logged in!");

//		landingPage.deleteUser();

	}

	@Test(enabled = true)
	public void verifyHomePage() {
		// Verify HomePage is Visible
		Assert.assertTrue(landingPage.isHomePageVisible());
	}

	@Test(enabled = true)
	public void testSignupWithExistingEmail() {
		signuppage = landingPage.clickSignupLogin();
		signuppage.enterNameAndEmail("Nikhil", "nikhil@example.com");
		signuppage.clickSignupButton();
		Assert.assertEquals(signuppage.getErrorMessage(), "Email Address already exist!");

	}
}
