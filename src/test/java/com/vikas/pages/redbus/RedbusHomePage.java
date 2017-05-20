package com.vikas.pages.redbus;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.vikas.framework.core.BasePage;

public class RedbusHomePage extends BasePage{

	public RedbusHomePage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id="src")
	WebElement txtFrom;
	
	@FindBy(id="dest")
	WebElement txtTo;
	
	@FindBy(id="onward_cal")
	WebElement inputOnwardDate;
	
	@FindBy(id="return_cal")
	WebElement inputReturnDate;
	
	@FindBy(id="search_btn")
	WebElement btnSearch;
	
//	@FindBy(xpath="//*[.='27']")
//	WebElement calendarControl;
	
	public void setFromLocation(String location){
		txtFrom.sendKeys(location);
		wait(1);
		txtFrom.sendKeys(Keys.TAB);
	}
	public void setToLocation(String location){
		txtTo.sendKeys(location);
	}
	public void setReturnDate(String date){
		inputReturnDate.click();
		WebElement dateElement = 	waitForElements(By.xpath("//*[.='"+date+"']")).get(1);
		waitForElementToBeVisible(dateElement);
		dateElement.click();
		
		//removeAttribute(inputReturnDate,"readonly");
		//inputReturnDate.sendKeys(date);
		//TODO : Write a code to select date 
	}
	public void setOnWardDate(String date){
		//removeAttribute(inputOnwardDate,"readonly");
		//inputOnwardDate.sendKeys(date);
		WebElement dateElement = 	waitForElements(By.xpath("//*[.='"+date+"']")).get(0);
		waitForElementToBeVisible(dateElement);
		dateElement.click();
	}
	public void clickSearchButton(){
		btnSearch.click();
	}
	public void search(String from, String to, String onwardDate, String returnDate) {
		
		setFromLocation(from);
		setToLocation(to);
		setOnWardDate(onwardDate);
		setReturnDate(returnDate);
		clickSearchButton();
	}
	
}
