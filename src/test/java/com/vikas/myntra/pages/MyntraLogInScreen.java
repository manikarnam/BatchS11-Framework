package com.vikas.myntra.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.vikas.framework.core.BasePage;

public class MyntraLogInScreen extends BasePage {

	public MyntraLogInScreen(WebDriver driver) {
		super(driver);
		}

	@FindBy(className="login-user-input-email")
	WebElement logInEmail;
	
	@FindBy(className="login-user-input-password")
	WebElement logInPassword;
	
	@FindBy(className="login-login-button")
	WebElement logInBtn;
	
	
	public String setUserName(String logInemail){
		logInEmail.sendKeys(logInemail);
		return logInemail;
	}
	
	public String setPassword(String logIn_Password){
		logInPassword.sendKeys(logIn_Password);
		return logIn_Password;
	}
	
	public void clickOnLogInbtn(){
	    logInBtn.click();	
	}
	
	
	
	
	
	
	
}
