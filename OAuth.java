package com.restassured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class OAuth {
	
	@Test
	public void postTweet() {
		
		//consumerKey -Key of the consumer.For example Login id
		//consumerSecret - Password of the consumer
		//accessToken - Access rights or privileges of the consumer to extract the specific data of the user
		//secretToken - Password of the accessToken
		Response response = RestAssured.given()
		.auth()
		.oauth("consumerKey", "consumerSecret", "accessToken", "secretToken")
		.post("url");
		System.out.println(response.getStatusCode());
		String reponseJsonPath = response.getBody().jsonPath().prettify();
		JsonPath jsonPath = response.jsonPath();
		String element = jsonPath.get("element to be searched in the Json");
		
	}

}
