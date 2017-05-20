package com.vikas.test.sample;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleDependentTest {

	@Test(dependsOnMethods={"testCase2","testCase3"},alwaysRun=true,description="This is test case 1 description")
	public void testCase1(){
		System.out.println("Test 1 executed");
	}
	@Test(description="This is test case 2 description")
	public void testCase2(){
		System.out.println("Test 2 executed");
		Assert.fail("Failing test case");
	}
	@Test(description="This is test case 3 description")
	void testCase3(){
		System.out.println("Test 3 executed");
	}
}
