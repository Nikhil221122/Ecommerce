package com.ecommerceTesting.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ecommerceTesting.baseClass.BaseClass;
import com.ecommerceTesting.pageObjects.CartPage;
import com.ecommerceTesting.pageObjects.CheckoutPage;
import com.ecommerceTesting.pageObjects.OrderPlacedPage;
import com.ecommerceTesting.pageObjects.PaymentsPage;
import com.ecommerceTesting.pageObjects.ProductsPage;
import com.ecommerceTesting.pageObjects.SignupPage;
import com.ecommerceTesting.utility.JsonUtil;

public class CheckOutTest extends BaseClass {
	ProductsPage productsPage;
	CartPage cartPage;
	SignupPage signupPage;
	CheckoutPage checkoutPage;
	PaymentsPage paymentsPage;
	OrderPlacedPage orderPlacedPage;
	String product1 = "Colour Blocked Shirt – Sky Blue";

	@Test(dataProvider="getCardDetails")
	public void testCheckout(HashMap<String, String> input) {
		productsPage = landingPage.clickOnProducts();
		productsPage.addToCart(product1);
		cartPage = productsPage.clickOnViewCartBtn();
		checkoutPage = cartPage.clickOnCheckOut();
		Assert.assertEquals(checkoutPage.getTotalProductPrice(), checkoutPage.getTotalAmount());
		paymentsPage = checkoutPage.clickOnPlaceOrder();
		paymentsPage.enterPaymentDetails(input.get("nameOnCard"), input.get("cardNumber"), input.get("cvc"), input.get("expMonth"), input.get("expYear"));
		orderPlacedPage = paymentsPage.clckOnPayAndConfirm();		
		Assert.assertEquals(orderPlacedPage.orderPlacedMsg(), "Congratulations! Your order has been confirmed!");
		
	}
	
	@DataProvider
	public Object[][] getCardDetails() throws IOException {
		List<HashMap<String, String>> data = JsonUtil.cardDetails();
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}
}
