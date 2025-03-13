package com.ecommerceTesting.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ecommerceTesting.baseClass.BaseClass;
import com.ecommerceTesting.pageObjects.SignupPage;
import com.ecommerceTesting.utility.JsonUtil;
import com.ecommerceTesting.listeners.RetryAnalyzer;
public class LoginTest extends BaseClass {
	SignupPage signuppage;

	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data = JsonUtil.getJsonDataToLogin();
		return new Object[][] { { data.get(0) }, { data.get(1) } };
	}

	@Test(priority = 1, dataProvider = "getData",retryAnalyzer = RetryAnalyzer.class)
	public void testValidLogin(HashMap<String, String> input) {
		signuppage = landingPage.clickSignupLogin();
		Assert.assertTrue(signuppage.isLoginToAccountVisible());
		signuppage.login(input.get("username"), input.get("password"));
		Assert.assertTrue(landingPage.isUserLoggedIn());
	}

	@Test(priority = 2)
	public void testInvalidLogin() {
		signuppage= landingPage.clickSignupLogin();
		signuppage.login("n21h8@nikhil.com", "Password123");
		Assert.assertEquals(signuppage.loginErrormsgIsDisplayed(), "Your email or password is incorrect!");
	}

	@Test(priority = 3, enabled = false)
	public void testDeleteUser() {
		signuppage = landingPage.clickSignupLogin();
		signuppage.login("bhosale@bhosale", "12345678");
		landingPage.clickOnDelete();
	}
	
	@Test(priority = 4)
	public void logOutUser() {
		signuppage = landingPage.clickSignupLogin();
		signuppage.login("bhosale@bhosale.com", "12345678");
		landingPage.clickOnLogoutbtn();
		Assert.assertTrue(signuppage.isUserLoggedOut());
		
	}
	

}
