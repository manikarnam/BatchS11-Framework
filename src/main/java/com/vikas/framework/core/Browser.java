package com.vikas.framework.core;

public enum Browser {

	FIREFOX("webdriver.gecko.driver",Config.FIREFOX_DRIVER_PATH),
	CHROME("webdriver.chrome.driver",Config.CHROME_DRIVER_PATH),
	SAFARI("webdriver.safari.driver",Config.SAFARI_DRIVER_PATH),
	IE("webdriver.ie.driver",Config.IE_DRIVER_PATH),
	EDGE("webdriver.edge.driver",Config.EDGE_DRIVER_PATH),
	ANDROID_NATIVE("","");
	
	String driverPath;
	String propName;
	Browser(String propname,String driver_path) {
		this.driverPath = driver_path;
		this.propName = propname;
	}
	public String getProName() {
		return propName;
	}
	
	public String getDriverPath() {
		return driverPath;
	}
}
