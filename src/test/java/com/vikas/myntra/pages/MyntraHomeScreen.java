package com.vikas.myntra.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vikas.framework.core.BasePage;

public class MyntraHomeScreen extends BasePage {

	public MyntraHomeScreen(WebDriver driver) {
		super(driver);
	}
	@FindBy(className="desktop-iconUser")
	WebElement iconUserLogin;
	
	@FindBy(css="[data-track='login']")
	WebElement linkLogin;

	public LoginPage openLoginPage(){
		//iconUserLogin.click();
		doMouseOver(iconUserLogin);
		waitForElementToBeVisible(linkLogin).click();
		//linkLogin.click();
		return PageFactory.initElements(driver, LoginPage.class);
		
	}
	
}
