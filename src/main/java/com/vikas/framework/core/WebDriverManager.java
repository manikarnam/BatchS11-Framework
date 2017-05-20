package com.vikas.framework.core;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.mongodb.selector.PrimaryServerSelector;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class WebDriverManager {
	public static WebDriver getInstance() {
		return getInstance(Config.SELECTED_BROWSER);
	}

	public static WebDriver getInstance(Browser browser) {
		WebDriver driver = null;
		if (!browser.getProName().isEmpty()) {
			System.setProperty(browser.getProName(), browser.getDriverPath());
		}
		try {
			System.out.println("Starting browser...");

			switch (browser) {
			case CHROME:
				driver = new ChromeDriver();
				break;
			case FIREFOX:
				driver = new FirefoxDriver();
				break;
			case IE:
				driver = new InternetExplorerDriver();
				break;
			case SAFARI:
				throw new RuntimeException("Not Implemented yet...");
			case EDGE:
				driver = new EdgeDriver();
				break;
			case ANDROID_NATIVE:

				URL appiumServerUrl;
				try {
					appiumServerUrl = new URL("http://192.168.0.118:4723/wd/hub");
					DesiredCapabilities caps = new DesiredCapabilities();

					caps.setCapability(MobileCapabilityType.APP, "C:\\Users\\pc\\Desktop\\AbpNewsLive_9.2.3.apk");
					caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Moto");
					// caps.setCapability(MobileCapabilityType.BROWSER_NAME,
					// "chrome");
					caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 999999);

					driver = new AndroidDriver<MobileElement>(appiumServerUrl, caps);
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			default:
				throw new RuntimeException("Unsupported browser parameter :" + browser);
			}
		} catch (Exception e) {
			System.out.println("Launching browser failed.. Error message: " + e.getMessage());
			e.printStackTrace();
			e.printStackTrace(System.out);
		
		}
		System.out.println("Launching browser done");
		return driver;
	}
}
