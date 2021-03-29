package com.restassured.cookiebasedauthentication;

import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//This is a class which creates an issue in JIRA.
//But before that the REST client has to authenticate itself
//Therefore the uri which creates an issue is a different one
//to the uri which authenticates. The uri which authenticates
//sends a response back which contains a jession id.
//This jession id is used in every subsequent request to
//authenticate the REST client as the server maintains that
//session and knows that the user is a valid one.
public class CreateIssueJIRA {
	
	@Test
	public void createJSessionId() {
		
		//Construct a JSONObject which would contain the username and password of the user in the JIRA account.
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("username", "ABC");
		jsonObject.put("password", "ABC");
		
		//Make a REST call setting the header type and sending the JSONObject.
		Response response = RestAssured.given()
		.header("Content-Type","application/json")
		.body(jsonObject)
		.post("url of session");
		//Get cookies from the response
		Map<String, String> cookies = response.getCookies();
		//Get the jession id
		String jsessionId = cookies.get("JSESSIONID");
		//POJO can be created instead of typing the full JSON.
		IssueType issue = new IssueType("Task");
		Projects projects = new Projects("REST");
		Payload payload = new Payload("Task", "Task", issue, projects);
		Fields fields = new Fields(payload);
		Response responseOfCreation = RestAssured.given()
		.contentType(ContentType.JSON)
		.cookie("JSESSIONID",jsessionId)
		.body("type the json here")// This is not an efficient way of doing it and the json body can be sent by a POJO.
		//Instead of full JSON the POJO can be passed..body(fields)ss
		.post("url to create an issue");
	}

}
