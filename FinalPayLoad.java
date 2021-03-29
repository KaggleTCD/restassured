package com.restassured.cookiebasedauthentication;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FinalPayLoad {

	public static void main(String[] args) {
		
		IssueType issue = new IssueType("Task");
		Projects projects = new Projects("REST");
		Payload payload = new Payload("Task", "Task", issue, projects);
		Fields fields = new Fields(payload);
		ObjectMapper objMap = new ObjectMapper();
		try {
			String myData = objMap.writerWithDefaultPrettyPrinter().writeValueAsString(fields);
			System.out.println(myData);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
