package com.neotech.api.lesson04;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

// API class Lesson 4, Part 2 (15:00)

public class GET_AllClasses {
	
	public static void main(String[] args) {
		
		// we define the method - GET
		// we define the URI
		// we set any params, header, auth, body...
		
		// SEND
		
		// validate response code
		// validate elements on payload
		
		// set the base uri
		RestAssured.baseURI = "https://neo-api.azurewebsites.net";
		// "baseURI" is static. Check with hover the mouth to "RestAssured" with Command key 
		
		System.out.println(RestAssured.baseURI);
		System.out.println("--------------------");
		
		// Build the request - this is where I can specify params, auth, headers
		RequestSpecification request = RestAssured.given();
		
		Response response = request.when().get("/api/services/app/Class/GetAll");
		
		System.out.println(response.statusCode());
		System.out.println(response.getStatusCode());
		System.out.println("---------------------");
		
		// Get Headers
		System.out.println(response.headers());
		System.out.println("---------------------");
		
		// Get a particular header
		String contentType = response.header("Content-Type"); 
		System.out.println(contentType);
		System.out.println("---------------------");
		
		// we can also create a headers object and work with it
		// Headers headers = response.headers();
		
		ResponseBody body = response.getBody();
		System.out.println(body.asString());
		System.out.println("---------------------");
		
		System.out.println(body.asPrettyString());
		System.out.println("---------------------");
		
		// we can also print the response directly.
		response.prettyPrint();
		
		// You can use Jason formatter (https://jsonformatter.org/) to look better with colors. 
		// but somehow the console data is different from Sabah's one so it failed.
	}
	

}
