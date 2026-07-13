package com.ecommerceTesting.baseClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.devtools.NetworkInterceptor; // <-- Added
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.http.HttpResponse; // <-- Added
import org.openqa.selenium.remote.http.Route; // <-- Added
import org.testng.annotations.*;

import com.ecommerceTesting.pageObjects.LandingPage;
//import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriver driver;
	public LandingPage landingPage;
	public String uniqueEmail = "Nikhil" + System.currentTimeMillis() + "@example.com";
	Properties prop;
	private NetworkInterceptor interceptor; // Keep a reference to gracefully close it
	URI uri = URI.create("http://192.168.0.197:4444");

	public WebDriver initializeDriver() throws IOException, InterruptedException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "\\src\\main\\java\\com\\ecommercetesting\\resources\\GlobalData.properties");
		prop.load(fis);

		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
//            WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();

			options.addArguments("--headless");
			options.addArguments("--disable-popup-blocking");
			options.addArguments("--disable-notifications");
			options.addArguments("--disable-features=OptimizationGuideDaemon,OptimizationHints");
			
//			driver = new RemoteWebDriver(uri.toURL(),options);
			driver = new ChromeDriver(options);

			// --- ABSOLUTE AD-BLOCKING VIA HTTP LAYER INTERCEPTOR ---
			// This catches and destroys ad requests regardless of Chrome version matching.
			interceptor = new NetworkInterceptor(driver,
					Route.matching(req -> req.getUri().contains("googleads") || req.getUri().contains("doubleclick")
							|| req.getUri().contains("adscore") || req.getUri().contains("pagead")
							|| req.getUri().contains("adnxs") || req.getUri().contains("amazon-adsystem")
							|| req.getUri().contains("/ads/") // Blocks generic URL endpoints containing relative ad
																// folders
					).to(() -> req -> new HttpResponse().setStatus(404)
							.setContent(() -> new java.io.ByteArrayInputStream(new byte[0]))));

		} else if (browserName.equalsIgnoreCase("edge")) {
			EdgeOptions options = new EdgeOptions();
			driver = new RemoteWebDriver(uri.toURL(),options);
		}

		if (driver != null) {
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		return driver;
	}

	public WebDriver getDriver() {

		return driver;
	}
//	@Parameters("browser")
	@BeforeMethod
	public void setup() throws IOException, InterruptedException {
		driver = initializeDriver();
		driver.get(prop.getProperty("appURL"));
		landingPage = new LandingPage(driver);
	}

	@AfterMethod
	public void teardown() {
		// Clean up the network interceptor session along with the driver
//		if (interceptor != null) {
//			interceptor.close();
//		}
		if (driver != null) {
			driver.quit();
		}
	}
}