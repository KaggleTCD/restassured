package com.restassured.cookiebasedauthentication;
/*
 * This class uses the serialization concept of
 * Java. Java objects are converted to and from JSON
 * and XML. This helps in sending a payload easily
 * as the whole JSON string has not to be formatted.
 * For JSON jackson library is used and for xml
 * JAXB is used.
 * This whole concept is called POJO in Rest Assured.
 */
public class IssueType {
	
	String name;

	public IssueType(String name) {
		
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
