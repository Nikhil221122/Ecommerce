package com.ecommerceTesting.baseClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.*;

import com.ecommerceTesting.pageObjects.LandingPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
    public WebDriver driver;
    public LandingPage landingPage;
    public String uniqueEmail = "Nikhil" + System.currentTimeMillis() + "@example.com";
    Properties prop;
    public WebDriver initializeDriver() throws IOException {
        prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
                + "\\src\\main\\java\\com\\ecommercetesting\\resources\\GlobalData.properties");
        prop.load(fis);

        String browserName = prop.getProperty("browser");
         
        if (browserName.contains("chrome")) {
		    WebDriverManager.chromedriver().setup();
		    ChromeOptions options = new ChromeOptions();
//		    options.addArguments("--window-size=1920,1080"); 
		    
		    driver = new ChromeDriver(options);
		} else if (browserName.equalsIgnoreCase("edge")) {
		    EdgeOptions options = new EdgeOptions();
		    driver = new EdgeDriver(options);
		} 

        if (driver != null) {
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        }
        return driver;
    }

    @BeforeMethod
    public void setup() throws IOException {
       driver =  initializeDriver();
        driver.get(prop.getProperty("appURL"));
        landingPage = new LandingPage(driver);
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();;
        }
    }
}
