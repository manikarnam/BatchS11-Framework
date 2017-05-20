package com.vikas.test.sample;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
/**
* sample page object java class for page object model
**/
public class ParallelTestsExample {

	
	@BeforeMethod
	public void beforeMethods(){
		System.out.println("Before Test Method");
	}
	
	@AfterMethod
	public void afterMethod(){
		System.out.println("After Test Method");
	}
	
	@Test
	public void test1(){
		System.out.println("Test 1 - started...");
		wait(10);
		System.out.println("Test 1 - ended..");
	}
	@Test
	public void test2(){
		System.out.println("Test 2 - started...");
		wait(10);
		System.out.println("Test 2 - ended..");
	}
	@Test
	public void test3(){
		System.out.println("Test 3 - started...");
		wait(10);
		System.out.println("Test 3 - ended..");
	}
	@Test
	public void test4(){
		System.out.println("Test 4 - started...");
		wait(10);
		System.out.println("Test 4 - ended..");
	}
	@Test
	public void test5(){
		System.out.println("Test 5 - started...");
		wait(10);
		System.out.println("Test 5 - ended..");
	}
	
	private void wait(int sec){
		try {
			Thread.sleep(sec*1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
