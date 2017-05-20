package com.vikas.pages.altoromutual;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.vikas.framework.core.BasePage;

public class CommentsPage extends BasePage{

	public CommentsPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(tagName="h1")
	WebElement heading;
	
	public String getHeadingText(){
		return heading.getText();
	}

}
