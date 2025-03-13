package com.ecommerceTesting.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecommerceTesting.baseClass.BaseClass;
import com.ecommerceTesting.pageObjects.ProductDetailsPage;
import com.ecommerceTesting.pageObjects.ProductSearchPage;
import com.ecommerceTesting.pageObjects.ProductsPage;

public class ProductTest extends BaseClass {

	ProductsPage productsPage;
	ProductDetailsPage productDetailsPage;
	ProductSearchPage productSearchPage;
	String Url = "https://www.automationexercise.com/product_details/30";
	String productName = "Premium Polo T-Shirts";

	@Test(enabled = true)
	public void verifyProductDetails() throws InterruptedException {
		productsPage = landingPage.clickOnProducts();
		Assert.assertTrue(productsPage.verifyProcutDisplayed());
		productDetailsPage = productsPage.viewProduct(productName);
		Assert.assertEquals(productDetailsPage.isProductDetailsPageDisplayed(), Url);
		Assert.assertTrue(productDetailsPage.areDetailsVisible());
	}
	@Test(enabled = true)
	public void verifySearchedProduct() {
		productsPage = landingPage.clickOnProducts();
		productSearchPage = productsPage.productSearch(productName);
		productSearchPage.isSearchedProductVisible(productName);

	}
}
