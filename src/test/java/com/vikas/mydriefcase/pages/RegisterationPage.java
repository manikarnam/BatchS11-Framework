package com.vikas.mydriefcase.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.vikas.framework.core.BasePage;

public class RegisterationPage extends BasePage {

	public RegisterationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(name = "txtFirstName")
	WebElement txtFirstName;

	@FindBy(name = "txtLastName")
	WebElement txtLastName;
	@FindBy(name = "txtEmail")
	WebElement txtEmail;
	@FindBy(name = "txtPassword")
	WebElement txtPassword;
	@FindBy(name = "txtConfirmPassword")
	WebElement txtConfirmPassword;
	@FindBy(name = "txtCity")
	WebElement txtCity;
	@FindBy(name = "txtPincode")
	WebElement txtPin;
	@FindBy(name = "txtMobileNumber")
	WebElement txtMobileNo;
	@FindBy(name = "txtDOB")
	WebElement txtDOB;
	@FindBy(css = "[name='gender'][value='1']")
	WebElement btnGenderMale;

	@FindBy(css = "[name='gender'][value='2']")
	WebElement btnGenderFemale;

	public void fillRegistrationForm(String firstName, String lastName, String email, String pass, String city,
			String pinCode, String mobileNo, String dob, String gender) {
		
		txtFirstName.sendKeys(firstName);
		txtLastName.sendKeys(lastName);
		txtEmail.sendKeys(email);
		txtPassword.sendKeys(pass);
		txtConfirmPassword.sendKeys(pass);
		txtCity.sendKeys(city);
		txtPin.sendKeys(pinCode);
		txtMobileNo.sendKeys(mobileNo);
		// select dob from calendar
		if(gender.trim().equalsIgnoreCase("Male")){
			btnGenderMale.click();
		}
		else{
			btnGenderFemale.click();
		}
	}

	
}
