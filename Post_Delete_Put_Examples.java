package com.restassured;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Post_Delete_Put_Examples {
	
	@Test
	public void test1() {
		
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type","application/json");
		JSONObject json = new JSONObject();
		json.put("id", "234");
		json.put("title", "My life");
		json.put("author", "Abhishek");
		request.body(json.toJSONString());
		Response reponse = request.post("http://localhost:3000/posts");
		Assert.assertEquals(reponse.getStatusCode(), 201);
	}
	

}
