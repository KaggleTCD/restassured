package com.restassured;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Post_Delete_Put_Examples3 {
	
	@Test
	public void test1() {
		
		RequestSpecification request = RestAssured.given();
		Response reponse = request.delete("http://localhost:3000/posts/234");
		Assert.assertEquals(reponse.getStatusCode(), 200);
	}
	

}
