package com.vikas.framework.core;

public class Config {

	
	
	public static final Browser SELECTED_BROWSER = getBrowser();
	public static final String FIREFOX_DRIVER_PATH = "C:\\Users\\vikas\\selenium_drivers\\geckodriver.exe";
	public static final String CHROME_DRIVER_PATH = "E:\chrome driverr";
	public static final String SAFARI_DRIVER_PATH =  "";
	public static final String IE_DRIVER_PATH =  "C:\\Users\\vikas\\selenium_drivers\\iedriverserver.exe";
	public static final String EDGE_DRIVER_PATH =  "C:\\Users\\vikas\\selenium_drivers\\MicrosoftWebDriver.exe";
	private static Browser getBrowser() {
		String browserStr = System.getProperty("browser");
		if(browserStr==null){
			System.out.println("No browser supplied, using default browser CHROME");
			browserStr="CHROME";
		}
		else{
			System.out.println("Received browser: "+browserStr);
		}
		return Browser.valueOf(browserStr);
	}
}
