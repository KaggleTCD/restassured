package com.restassured;

import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;

public class BaseRestAssuredClass {
	
	@BeforeClass
	public void setUp() {
		
		RestAssured.authentication = RestAssured.preemptive().basic("ToolsQA", "TestPassword");
	}

}
