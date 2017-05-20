package com.vikas.framework.core;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.google.common.io.Files;

public class BaseTestSuite {

	protected WebDriver driver;

	@AfterMethod
	protected void closeBrowser() {
		driver.close();
	}

	@BeforeMethod
	protected void initBrowser() {
		driver = WebDriverManager.getInstance();
		
	}
	protected void openUrl(String url){
		driver.get(url);
	}
	protected void captureSnap(String fileName) {
		
		TakesScreenshot takesSnap = (TakesScreenshot) driver;
		File snap = takesSnap.getScreenshotAs(OutputType.FILE);
		System.out.println("Snapshot stored at: "+snap.getAbsolutePath());
		File destination = new File("snaps/"+fileName);
		try {
			Files.move(snap, destination);
			System.out.println("Snapshot moved to : "+destination.getAbsolutePath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
