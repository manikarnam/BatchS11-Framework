package com.vikas.framework.utils;



import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.google.common.io.Files;

/**
 * This is the TestNG listener which listens test result and created
 *         HTML Report
 * @author vikasthange  
 */
public class IExtentReporter implements IReporter {
	private ExtentReports extent;
	ExtentHtmlReporter htmlReporter;

	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		String reportFolder = outputDirectory + File.separator + "html";
		String reportFile = reportFolder + File.separator + "index.html";
		System.out.println("Report path:"+reportFile);
		String snapsFolder = reportFolder + File.separator + "snaps";
		try {
			if (new File(reportFolder).exists())
				FileUtils.deleteDirectory(new File(reportFolder));
			java.nio.file.Files.createDirectory(Paths.get(reportFolder));
			java.nio.file.Files.createDirectory(Paths.get(snapsFolder));
		} catch (IOException e) {

			e.printStackTrace();
		}
		htmlReporter = new ExtentHtmlReporter(reportFile);
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		/** Add system info **/
		extent.setSystemInfo("Username:  ", System.getProperty("user.name"));
		try {
			extent.setSystemInfo("Execution Machine :  ", InetAddress.getLocalHost().getHostName());
		} catch (UnknownHostException e) {
			//DO Nothing
		}
		extent.setSystemInfo("JVM Version: ", System.getProperty("java.version"));
		extent.setSystemInfo("User Directory:  ", System.getProperty("user.dir"));
		
		for (ISuite suite : suites) {
			Map<String, ISuiteResult> result = suite.getResults();
			for (ISuiteResult r : result.values()) {
				ITestContext context = r.getTestContext();
				buildTestNodes(context.getPassedTests(), Status.PASS, snapsFolder);
				buildTestNodes(context.getFailedTests(), Status.FAIL, snapsFolder);
				buildTestNodes(context.getSkippedTests(), Status.SKIP, snapsFolder);
			}
		}

		extent.flush();
	}
	/**
	 * Method to add test cases result in test report
	 * @param tests
	 * @param status
	 * @param snapsFolder
	 */
	private void buildTestNodes(IResultMap tests, Status status, String snapsFolder) {
		ExtentTest test;

		if (tests.size() > 0) {
			for (ITestResult result : tests.getAllResults()) {
				test = extent.createTest(result.getMethod().getMethodName());
				test.getModel().setStartTime(getTime(result.getStartMillis()));
				test.getModel().setEndTime(getTime(result.getEndMillis()));
				test.assignCategory(result.getTestContext().getName());
				test.log(Status.INFO, "Class Name:  " + result.getTestClass().getName());
				for (Object temp : result.getParameters()) {
					if (temp != null) {
						test.log(Status.INFO, "Data Used:  " + temp);
						test.getModel().setName(test.getModel().getName() + "  (" + temp + ")");
					}
				}
				@SuppressWarnings("unchecked")
				List<File> listSnaps = (List<File>) result.getAttribute(ScreenshotUtils.REPORT_SNAP_KEY);
				if (listSnaps != null) {
					for (File snap : listSnaps) {
						try {
							File dest = new File(snapsFolder + File.separator + snap.getName());
							Files.copy(snap, dest);
							test.addScreenCaptureFromPath(
									new File(dest.getParent()).getName() + File.separator + dest.getName());
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
				String message = "Test " + status.toString().toLowerCase() + "ed";

				if (result.getThrowable() != null) {
					message = result.getThrowable().getMessage();
				}

				test.log(status, message);
				if (result.getThrowable() != null) {
					test.log(status, result.getThrowable());
				}
			}
		}
	}
	/**
	 * Method to convert milliseconds in date
	 * @param millis Milliseconds to convert
	 * @return returns date object
	 */
	private Date getTime(long millis) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		return calendar.getTime();
	}

}
