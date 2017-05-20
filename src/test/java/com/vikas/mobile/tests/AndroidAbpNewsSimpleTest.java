package com.vikas.mobile.tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class AndroidAbpNewsSimpleTest {

	@Test
	public void testAbpEnglishScreenTitle(){
		WebDriver driver;
		try {
			URL appiumServerUrl = new URL("http://192.168.0.118:4723/wd/hub");
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability(MobileCapabilityType.APP, "C:\\Users\\pc\\Desktop\\AbpNewsLive_9.2.3.apk");
			caps.setCapability(MobileCapabilityType.DEVICE_NAME,"Moto");
//			caps.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
			caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 999999);
			driver = new AndroidDriver<MobileElement>(appiumServerUrl,caps);
			
			driver.findElement(By.xpath("//*[@text='ABP Live (English)']")).click();
			//System.out.println(driver.getPageSource());
			String actualText = driver.findElement(By.id("com.winit.starnews.hin:id/abpNewsTitleTextView")).getText();
			System.out.println("Actual Title: "+actualText);
			Assert.assertEquals(actualText, "ABP Live","Screen title after tapping ABP english failed");
			
			driver.quit();
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

