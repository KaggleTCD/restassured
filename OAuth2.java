package com.restassured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class OAuth2 {
	
	//For this I went to http://coop.apps.symfonycasts.com/application
	//And created an application
	//It gave me client id,client secret
	//I gave a redirect uri and the permissions through this app.
	//Always we make an app in any application like twitter or facebook
	//That app decides the permissions of what can be done to the
	//user account through the app.
	/*
	 * @Test public void test() {
	 * 
	 * Response response = RestAssured.given() .auth()
	 * .oauth2("c6b8660144124711c6a8a07c04794d7579be8620") // Access token
	 * .post("http://coop.apps.symfonycasts.com/api/1620/toiletseat-down");
	 * 
	 * System.out.println(response.getStatusCode());
	 * System.out.println(response.getBody().asPrettyString()); }
	 */
	
	//The above test was done by getting an access token manually.
	//This test will be done by generating the access token with program.
	@Test
	public void testWithGenratedAccessToken() {
		
		Response response = RestAssured.given()
		.formParam("client_id", "Testoauth2")
		.formParam("client_secret", "ba57fa7d1b01aaf76bd9721dfa2bc9cc")
		.formParam("grant_type", "client_credentials")
		.post("http://coop.apps.symfonycasts.com/token");
		System.out.println(response.jsonPath().prettify());
		System.out.println(response.jsonPath().get("access_token"));
		Response responseData = RestAssured.given() .auth()
		.oauth2((String) response.jsonPath().get("access_token")) // Access token
		.post("http://coop.apps.symfonycasts.com/api/1620/toiletseat-down");
		System.out.println(responseData.getStatusCode());
		System.out.println(responseData.getBody().asPrettyString()); 
		
	}
		
	}


//Output
//{
//    "access_token": "c912c3b834f806fcec6933a71f1a0384a0f96ed1",
//    "expires_in": 86400,
//    "token_type": "Bearer",
//    "scope": "barn-unlock toiletseat-down"
//}
//PASSED: testWithGenratedAccessToken


//Output
//.post("http://coop.apps.symfonycasts.com/api/1620/toiletseat-down");
//200
//{
//    "action": "toiletseat-down",
//    "success": true,
//    "message": "You just put the toilet seat down. You're a wonderful roommate!",
//    "data": null
//}
//PASSED: test

//Output
//.post("http://coop.apps.symfonycasts.com/api/1620/chickens-feed");
//401
//{
//   "error": "insufficient_scope",
//    "error_description": "The request requires higher privileges than provided by the access token"
//}
//PASSED: test
