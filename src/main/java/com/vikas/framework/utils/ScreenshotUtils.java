package com.vikas.framework.utils;



import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;

/**
 * @author vikasthange
 *
 *         Apr 25, 2017 - 3:10:37 PM
 */
public class ScreenshotUtils {

	public static String REPORT_SNAP_KEY = "report_snap_key";
	
	
	/**
	 * Method to capture snapshot
	 * 
	 * @param snapFileName
	 */
	public static void captureSnap(TakesScreenshot takeSnap) {
		if(takeSnap==null){
			Reporter.log("Driver may not have initilized, skipping capturing snaps..");
		}
		File snap = (takeSnap).getScreenshotAs(OutputType.FILE);

		@SuppressWarnings("unchecked")
		List<File> listSnaps = (List<File>) Reporter.getCurrentTestResult().getAttribute(REPORT_SNAP_KEY);
		if (listSnaps == null) {
			listSnaps = new ArrayList<File>();
		}
		listSnaps.add(snap);
		Reporter.getCurrentTestResult().setAttribute(REPORT_SNAP_KEY, listSnaps);
	}
}
