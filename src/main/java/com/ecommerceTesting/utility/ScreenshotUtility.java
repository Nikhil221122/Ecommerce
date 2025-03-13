package com.ecommerceTesting.utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtility {

	
	public static String getScreenshot(WebDriver driver, String testName) throws IOException {
		String screenshotPath=System.getProperty("user.dir") + "/screenshots/" + testName + ".png";
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(src,new File(screenshotPath));
		return screenshotPath;
	}
}
