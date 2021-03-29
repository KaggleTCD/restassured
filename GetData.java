package com.restassured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class GetData {
	
	//Get the latest dependency else it throws JAXB exception
	@Test
	public void testResponseCode() {
		
		Response resp = RestAssured.get("http://api.currencylayer.com/live?access_key=dea8fc54ff2d5714dad4eb7e83f37f6a");
		int code = resp.getStatusCode();
		System.out.println(code);
		Assert.assertEquals(code, 200);
	}
	
	@Test
	public void testResponseData() {
		
		Response resp = RestAssured.get("http://api.currencylayer.com/live?access_key=dea8fc54ff2d5714dad4eb7e83f37f6a");
		ResponseBody body = resp.getBody();
		System.out.println(body.asPrettyString());
		System.out.println("----------------------------");
		System.out.println(resp.jsonPath().get("quotes.USDAED"));
		Object object = resp.jsonPath().get("quotes");
		System.out.println(object);
	}

}
