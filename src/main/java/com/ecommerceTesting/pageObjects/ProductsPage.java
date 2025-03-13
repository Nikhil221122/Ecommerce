package com.ecommerceTesting.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage{

	WebDriver driver;
	ProductDetailsPage productDetailsPage;
	ProductSearchPage productSearchPage;
	CartPage cartPage;

	@FindBy(css = ".product-image-wrapper")
	List<WebElement> products;

	@FindBy(id = "search_product")
	WebElement searchBox;

	@FindBy(id = "submit_search")
	WebElement searchBtn;

	@FindBy(xpath = "//button[text()=\"Continue Shopping\"]")
	WebElement continueBtn;

	@FindBy(css = ".modal-body a")
	WebElement ViewCartBtn;

	By viewProductBtn = By.xpath(".//a[contains(text(),'View Product')]");
	By addToCartBtn = By.xpath(".//a[contains(text(),'Add to cart')]");

	public ProductsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getProductByName(String productName) {
		return products.stream().filter(s -> s.findElement(By.tagName("p")).getText().equals(productName)).findFirst()
				.orElse(null);
		
	}

	public boolean verifyProcutDisplayed() {
		if (products.isEmpty()) {
			return false;
		}
		return true;
	}

	public ProductDetailsPage viewProduct(String productName) {
		WebElement prodName = getProductByName(productName);
		prodName.findElement(viewProductBtn).click();
		productDetailsPage = new ProductDetailsPage(driver);
		return productDetailsPage;

	}

	public ProductSearchPage productSearch(String productName) {
		searchBox.sendKeys(productName);
		searchBtn.click();

		productSearchPage = new ProductSearchPage(driver);
		return productSearchPage;
	}

	public void addToCart(String productName) {
		WebElement prodName = getProductByName(productName);
		prodName.findElement(addToCartBtn).click();
	}

	public void clickOnContinueBtn() {
		continueBtn.click();
	}

	public CartPage clickOnViewCartBtn() {
		ViewCartBtn.click();
		cartPage = new CartPage(driver);
		return cartPage;
	}

}
