package com.vikas.test.sample;



import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterizedTest {

	@Parameters({"U_NAME","PASS"})
	@Test(groups=SampleTestGroups.SMOKE_GROUP)
	public void testLogin(@Optional("vikas") String username,@Optional("pass123") String password){
		System.out.println("Username: "+username+", Password: "+password);
	}
}
