
//Class test framwork
package com.vikas.framework.core;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	protected WebDriver driver;
	protected WebDriverWait wait;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 60);
	}

	public void removeAttribute(WebElement elem, String attributeName) {
		executeJavascript("arguments[0].removeAttribute(\"" + attributeName + "\")", elem);
	}

	public void executeJavascript(String jsToExecute) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript(jsToExecute);
	}

	public void executeJavascript(String jsToExecute, WebElement e) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript(jsToExecute, e);
	}

	public List<WebElement> waitForElements(By locator) {
		return wait.until(ExpectedConditions.numberOfElementsToBe(locator, 2));
	}

	public WebElement waitForElementToBeVisible(WebElement elem) {
		return wait.until(ExpectedConditions.visibilityOf(elem));
	}
	
	public static void wait(int sec) {
		try {
			TimeUnit.SECONDS.sleep(sec);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void doMouseOver(WebElement element){
		
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}

	public String getCurrentPageTitle(){
		return driver.getTitle();
	}
}
