package com.vikas.mydriefcase;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.vikas.framework.core.BaseTestSuite;
import com.vikas.mydriefcase.pages.LoginPage;
import com.vikas.mydriefcase.pages.RegisterationPage;

public class RegistrationFormTest extends BaseTestSuite {

	@Test
	public void testRegistrationForm(){
		openUrl("https://my.driefcase.com/pages/user/login.aspx");
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		RegisterationPage regPage = loginPage.openRegistrationPage();
		regPage.fillRegistrationForm("vikas","thange","v@t.com","password","pune","411017","1234567890","21-Apr-1988","Male");
		
	}
	@Test(testName="mySampleTest")
	public void testScreenshotCapture(){
		openUrl("http://192.168.0.254/cgi-bin/login");
		captureSnap("1.png");
		driver.findElement(By.name("username")).sendKeys("Vikas");
		captureSnap("2.png");
		Assert.fail("Failing test case intentionally");
	}
	@AfterMethod
	public void afterMethod(ITestResult testResult){
		if( testResult.getStatus() == ITestResult.SUCCESS){
			System.out.println("Test passed");
		}
		if( testResult.getStatus() == ITestResult.FAILURE){
			System.out.println("Test Failed");
			captureSnap(testResult.getMethod().getMethodName()+".png");
			System.out.println("Snap captured as test was failed. snap name: "+testResult.getMethod().getMethodName()+".png");
		}
	}
}
