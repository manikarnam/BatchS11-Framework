package com.vikas.samples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.vikas.framework.core.BasePage;
import com.vikas.framework.core.BaseTestSuite;

public class FileUploadTest extends BaseTestSuite{

	@Test
	public void testFileUpload(){
		driver.get("https://online2pdf.com/doc-to-pdf");
		WebElement btnUploadFile = driver.findElement(By.id("input_file0"));
		// DO not click
		btnUploadFile.sendKeys("C:\\Users\\vikas\\Desktop\\This is a sample word file.docx;");
		driver.findElement(By.className("convert_button")).click();
		BasePage.wait(1);
	}
}
