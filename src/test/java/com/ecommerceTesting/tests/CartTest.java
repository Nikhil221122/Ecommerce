package com.ecommerceTesting.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecommerceTesting.baseClass.BaseClass;
import com.ecommerceTesting.pageObjects.CartPage;
import com.ecommerceTesting.pageObjects.CheckoutPage;
import com.ecommerceTesting.pageObjects.ProductsPage;

public class CartTest extends BaseClass {

	ProductsPage productsPage;
	CartPage cartPage;
	CheckoutPage checkOutPage;
	String product1 = "Colour Blocked Shirt – Sky Blue";
	String product2 = "Stylish Dress";

	@Test(enabled=false)
	public void testAddToCart() {
		productsPage = landingPage.clickOnProducts();
		productsPage.addToCart(product1);
		productsPage.clickOnContinueBtn();
		productsPage.addToCart(product2);
		cartPage = productsPage.clickOnViewCartBtn();
		Assert.assertTrue(cartPage.verifyProductAddedInCart(product1, product2));
	}

	@Test
	public void verifyCart() {
		productsPage = landingPage.clickOnProducts();
		productsPage.addToCart(product1);
		cartPage = productsPage.clickOnViewCartBtn();
		
	}
}
