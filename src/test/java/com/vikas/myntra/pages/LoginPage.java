package com.vikas.myntra.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.vikas.framework.core.BasePage;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(name="email")
	WebElement txtEmail;
	
	
	public void doLogin(String uname,String password){
		txtEmail.sendKeys(uname);
		//TODO: Type password
		// Click on login
		// return UserHomePage Object
	}

}
