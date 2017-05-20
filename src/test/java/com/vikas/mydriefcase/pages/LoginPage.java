package com.vikas.mydriefcase.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vikas.framework.core.BasePage;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css="[title='Register']")
	WebElement btnRegister;
	
	public RegisterationPage openRegistrationPage(){
		btnRegister.click();
		return PageFactory.initElements(driver, RegisterationPage.class);
	}

	
}
