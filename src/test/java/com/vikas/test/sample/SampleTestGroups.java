package com.vikas.test.sample;

import org.testng.annotations.Test;

public class SampleTestGroups {

	final static String SMOKE_GROUP="smoke";
	final static String REGRESSION_GROUP="regression";
	@Test(groups=SMOKE_GROUP)
	public void test1(){
		System.out.println("Test case 1 from group : Smoke ");
	}
	@Test(groups=REGRESSION_GROUP, enabled=false)
	public void test2(){
		System.out.println("Test case 2 from group : Regression ");
	}
	@Test(groups={REGRESSION_GROUP,SMOKE_GROUP})
	public void test3(){
		System.out.println("Test case 3 from group : Regression,Smoke ");
	}
	@Test(groups=REGRESSION_GROUP)
	public void test4(){
		System.out.println("Test case 4 from group : Regression ");
	}
	@Test(groups=SMOKE_GROUP)
	public void test5(){
		System.out.println("Test case 5 from group : Smoke ");
	}
	
	@Test(expectedExceptions={RuntimeException.class},invocationCount=2,timeOut=2)
	public void test6(){
		System.out.println("Test 6 executed");
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		throw new RuntimeException("message");
	}
}
