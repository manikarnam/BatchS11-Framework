package com.vikas.myntra.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.vikas.framework.core.WebDriverManager;
import com.vikas.myntra.pages.LoginPage;
import com.vikas.myntra.pages.MyntraHomeScreen;

public class MyntraHomeScreenTests {
	WebDriver driver;

	@BeforeTest
	public void initBrowser() {
		driver = WebDriverManager.getInstance();
		driver.get("http://myntra.com");
		driver.navigate().refresh();
	}
	@Test
	public void testLogin(){
		MyntraHomeScreen homeScreen = PageFactory.initElements(driver, MyntraHomeScreen.class);
		LoginPage loginPage = homeScreen.openLoginPage();
		Assert.assertTrue(driver.getCurrentUrl().startsWith("https://secure.myntra.com/login"),"Url failed, Login page did not open" );
//		UserHomePage userPage = loginPage.doLogin("", "");
	}	
	@Test(dependsOnMethods={"testLogin"})
	public void testSearch(){
		//TODO: Work on below
//		UserHomePage userPage =  PageFactory(driver,UserHomePage.class);
//		SearchResultPage resultPage = userPage.search("shoes")
		
	}
	
	@AfterTest
	public void cleanUp() {
		driver.close();
		driver.quit();
	}
}
