package com.vikas.mobile.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.vikas.framework.core.BaseTestSuite;
import com.vikas.framework.core.WebDriverManager;
import com.vikas.myntra.pages.LoginPage;
import com.vikas.myntra.pages.MyntraHomeScreen;

public class AndroidABPAppTests extends BaseTestSuite {
	

	@BeforeTest
	public void initBrowser() {
		driver = WebDriverManager.getInstance();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test
	public void testAppLaunch(){
		System.out.println(driver.getPageSource());
		captureSnap("app1.png");
		driver.findElement(By.xpath("//*[@text='ABP Live (English)']")).click();
		System.out.println(driver.getPageSource());
		captureSnap("app2.png");
		String actualText = driver.findElement(By.id("com.winit.starnews.hin:id/abpNewsTitleTextView")).getText();
		captureSnap("app3.png");
		System.out.println("Actual Title: "+actualText);
		Assert.assertEquals(actualText, "ABP Live","Screen title after tapping ABP english failed");
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
}
