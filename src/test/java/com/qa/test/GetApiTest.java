package com.qa.test;

import org.testng.annotations.BeforeMethod;

import com.qa.base.TestBase;

public class GetApiTest extends TestBase{
	TestBase testbase;
	@BeforeMethod
	public void setup(){
		testbase = new TestBase();
		String apiurl = prop.getProperty("serviceURL");
		
	}
	

}
