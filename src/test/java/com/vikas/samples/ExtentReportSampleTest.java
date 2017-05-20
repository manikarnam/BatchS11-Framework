package com.vikas.samples;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.vikas.framework.core.BaseTestSuite;

public class ExtentReportSampleTest extends BaseTestSuite{
	ExtentReports extent ;
	@BeforeTest
	public void startReporting(){
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
	}
	@Test
	public void sampleTest(){
		// initialize the HtmlReporter
		ExtentTest test = extent.createTest("MySampleTest");
		
		test.info("Started test case... ");
		
		test.warning("This is warning.. message ..");
		
		test.debug("Adding debug indo");
		
		test.pass("All sted executed, found match bet exp and actual");
	}
	@Test
	public void sampleTest2(){
		// initialize the HtmlReporter
		ExtentTest test = extent.createTest("MySampleTest TWO");
		
		test.info("Started test case... ");
		
		test.warning("This is warning.. message ..");
		
		test.debug("Adding debug indo");
		
		test.pass("All sted executed, found match bet exp and actual");
	}
	@AfterTest
	public void saveReport(){
		extent.flush();
	}
}
