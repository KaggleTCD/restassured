package com.restassured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class RestAssuredBasicAuthentication extends BaseRestAssuredClass{
	
	@Test
	public void test1() {
		
		int statusCode = RestAssured.given()
		.get("https://restapi.demoqa.com/authentication/CheckForAuthentication/").getStatusCode();
		System.out.println(statusCode);
	}

}