package com.ecommerceTesting.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtility {
	static ExtentReports extent;
	static ExtentTest test;
	public static ExtentReports initializeReport() {
		
		ExtentSparkReporter sparkreporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/Reports/TestReport.html");
		sparkreporter.config().setDocumentTitle("Automation Test Report");
		sparkreporter.config().setReportName("Test Execution Report");
		sparkreporter.config().setTimelineEnabled(true);
		extent = new ExtentReports();
		extent.attachReporter(sparkreporter);
		return extent;
	}
	
 
	public static void flushReport() {
		if(extent !=null) {
			extent.flush();
		}
	}
	
}
