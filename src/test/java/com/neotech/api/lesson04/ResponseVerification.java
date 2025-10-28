package com.neotech.api.lesson04;

import org.junit.Assert;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

// API Class 4, Part-3

public class ResponseVerification {
	
	@Test
	public void verifyAllClassesRequest()
	{
		RestAssured.baseURI = "https://neo-api.azurewebsites.net";
		
		RequestSpecification request = RestAssured.given();
		
		// any element of the request can be specified in the RequestSpecification object, before we make the call
		request.queryParam("MaxResultCount", 1000);
		
		// make the call
		Response response = request.when().get("/api/services/app/Class/GetAll");
		
		// validate the response
		
		// validate that the status code is 200
		response.then().assertThat().statusCode(200);
		
		// validate using JUnit assertion
		Assert.assertEquals(200, response.statusCode());
		
		// Verify that the Content-Type is application/json...
		response.then().assertThat().header("Content-Type", "application/json; charset=utf-8");
		
		// Using JUnit assertion
		Assert.assertEquals("application/json; charset=utf-8", response.header("Content-Type"));
		
		// Validate that the response contains Cucumber
		String body = response.body().asString();
		Assert.assertTrue("Cucumber NOT Found!", body.contains("Cucumber"));
		
		// oneliner
		// Assert.assertTrue(response.body().asString().contains("Cucumber"));
		
	}

}
