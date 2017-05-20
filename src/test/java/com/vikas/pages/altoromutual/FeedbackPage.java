package com.vikas.pages.altoromutual;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vikas.framework.core.BasePage;

public class FeedbackPage extends BasePage {

	public FeedbackPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(name="name")
	WebElement txtName;
	
	@FindBy(name="email_addr")
	WebElement txtEmail;
	
	@FindBy(name="subject")
	WebElement txtSubject;
	
	@FindBy(name="comments")
	WebElement txtComments;
	
	@FindBy(name="submit")
	WebElement btnSubmit;
	
	@FindBy(name="reset")
	WebElement btnReset;
	
	public void setFeedbackData(String name,String email, String subject, String comment){
		txtName.sendKeys(name);;
		txtEmail.sendKeys(email);;
		txtSubject.sendKeys(subject);
		txtComments.sendKeys(comment);
		
	}
	public CommentsPage clickSubmitButton(){
		btnSubmit.click();
		return PageFactory.initElements(driver, CommentsPage.class);
	}
	public FeedbackPage clickResetButton(){
		btnReset.click();
		return PageFactory.initElements(driver, FeedbackPage.class);
	}

}
