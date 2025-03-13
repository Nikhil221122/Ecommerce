package com.ecommerceTesting.utility;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportUtility {
	static ExtentReports extent;
	static ExtentTest test;
	String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());

	public static ExtentReports initializeReport() {
		
		ExtentSparkReporter sparkreporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/Reports/TestReport.html");
		sparkreporter.config().setDocumentTitle("Automation Test Report");
		sparkreporter.config().setReportName("Test Execution Report");
		sparkreporter.config().setTimelineEnabled(true);
		sparkreporter.config().setTheme(Theme.DARK);
		extent = new ExtentReports();
		extent.attachReporter(sparkreporter);
		
		extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("Java Version", System.getProperty("java.version"));
        extent.setSystemInfo("Tester", "Nikhil Bhosale");
        extent.setSystemInfo("Browser", "Chrome");

		return extent;
	}
	
 
	public static void flushReport() {
		if(extent !=null) {
			extent.flush();
		}
	}
	
}
