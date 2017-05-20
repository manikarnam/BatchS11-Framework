package com.vikas.test.redbus;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vikas.framework.core.BaseTestSuite;
import com.vikas.framework.core.WebDriverManager;
import com.vikas.pages.redbus.RedbusHomePage;

public class SearchBusTests extends BaseTestSuite{

	@BeforeMethod
	public void openUrl(){
		driver.get("http://www.redbus.in");
	}
	@Test
	public void testSearch(){
		//Assert.assertTrue(driver.getCurrentUrl().contains("redbus.in"),"Page url failed");
		//RedbusHomePage redbusHomePage = new RedbusHomePage(driver);
		//PageFactory.initElements(driver, redbusHomePage);
		//redbusHomePage.search("Pune","Goa","20","28");
	}
}
