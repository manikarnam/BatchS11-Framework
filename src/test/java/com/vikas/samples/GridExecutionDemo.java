package com.vikas.samples;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.tools.ant.taskdefs.XSLTProcess.TraceConfiguration;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vikas.framework.core.Browser;

public class GridExecutionDemo {

	/**
	 * Test case to validate google search is working 
	 * @param testNumber It is a number to identify test execution 
	 * @param browser Which browser to run tests
	 * @throws MalformedURLException 
	 * @author vikas 
	 * @since v1.0
	 */
	@Test(dataProvider = "multipleTests")
	public void testOnRemmoteChromeBrowser(int testNumber, Browser browser) throws MalformedURLException {
		// System.setProperty("webdriver.chrome.driver","C:\\Users\\vikas\\selenium_drivers\\chromedriver.exe");
		// WebDriver driver = new ChromeDriver();
		System.out.println("Starting test :" + testNumber);
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setBrowserName(browser.toString().toLowerCase());
		caps.setPlatform(Platform.WIN8);
		// OR caps.setCapability("browserName", "chrome");
		URL hubUrl = new URL("http://192.168.0.128:4444/wd/hub");

		WebDriver driver = new RemoteWebDriver(hubUrl, caps);
		driver.get("http://google.com");
		driver.findElement(By.name("q")).sendKeys("Vikas Thange Selenium");

		driver.quit();
	}

	@DataProvider(parallel = true)
	public Object[][] multipleTests() {
		return new Object[][] { { 1, Browser.FIREFOX }, { 2, Browser.CHROME } };
	}
}
