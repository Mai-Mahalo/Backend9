package com.neotech.api.lesson04;

import static org.junit.Assert.assertThat;

import org.junit.Assert;
import org.junit.Test;

import com.neotech.utils.APIConstants;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

// API Class 4, Part-3 (19:00)

public class POST_GenerateToken {
	
	@Test
	public void generateToken()
	{
		// set the Base URI
		RestAssured.baseURI = APIConstants.BASE_URI;
		
		// create a request
		RequestSpecification request = RestAssured.given();
		
		// since I am sending a JSON payload, I need to add that to the header
		request.header("Content-Type", "application/json; charset=utf-8");
		
		String payload = "{\n"
				+ "  \"userNameOrEmailAddress\": \"Tester\",\n"
				+ "  \"password\": \"Student@Neo\",\n"
				+ "  \"rememberClient\": true\n"
				+ "}";
		
		request.body(payload);
		
		// make the call
		Response response = request.when().post(APIConstants.GENERATE_TOKEN_ENDPOINT);
		
		// another way to send a request
		// Response response = request.when().request(Method.POST,"/api/TokenAuth/Authenticate");
		
		System.out.println("---------------------------");
		System.out.println("Status Code: " + response.statusCode()); //.getStatusCode()
		System.out.println("---------------------------");
		System.out.println(response.statusLine()); //.getStatusLine();
		
		response.prettyPrint();
		System.out.println("---------------------------");
		
		response.then().assertThat().statusCode(200);
		Assert.assertEquals(200, response.statusCode());	
		
	}
	
	public void generateTokenShortWay()
	{
		RestAssured.baseURI = APIConstants.BASE_URI;
		
		String payload = "{\n"
				+ "  \"userNameOrEmailAddress\": \"Tester\",\n"
				+ "  \"password\": \"Student@Neo\",\n"
				+ "  \"rememberClient\": true\n"
				+ "}";
		
		RestAssured.given()
		   .header("Content-Type","application/json; charset=utf-8")
		   .body(payload)
		   .when().post(APIConstants.GENERATE_TOKEN_ENDPOINT)
		   .prettyPeek()
		   .then().assertThat().statusCode(200);

	}
	
	

}
