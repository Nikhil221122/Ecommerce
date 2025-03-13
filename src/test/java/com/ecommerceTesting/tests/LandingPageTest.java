package com.ecommerceTesting.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecommerceTesting.baseClass.BaseClass;

public class LandingPageTest extends BaseClass {

	
	@Test(invocationCount=1)
	public void testHomePageVisible() {
		Assert.assertTrue(landingPage.isHomePageVisible());
	}
	
	
	@Test
	public void testSubscription() {
		Assert.assertTrue(landingPage.checkSubscription("nikhil@nikhil.com"));
	}
}
