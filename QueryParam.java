package com.restassured;

import org.apache.http.params.CoreConnectionPNames;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class QueryParam {
	
	@Test
	public void test()
	{
		
		
		  RequestSpecification request = RestAssured.given(); Response response =
		  request.queryParam("username", "abc") .queryParam("password", "abc")
		  .get("url"); String responseBody = response.getBody().asString(); JsonPath
		  jsonPath = response.jsonPath();
		 
		
		
		
		RestAssuredConfig config = RestAssured.config()
		        .httpClient(HttpClientConfig.httpClientConfig()
		                .setParam(CoreConnectionPNames.CONNECTION_TIMEOUT, 1000)
		                .setParam(CoreConnectionPNames.SO_TIMEOUT, 1000));

		RestAssured.given().config(config).post("http://localhost:8884");
	}
}
