package com.neotech.api.lesson05;

import org.json.JSONObject;
import org.junit.Test;

import com.neotech.utils.APIConstants;
import com.neotech.utils.APIGlobalVariables;

import io.restassured.RestAssured;
import io.restassured.response.Response;

// HW for Lesson 05

/*
 * Create the Java Classes by looking at the Swagger UI documentation for the following: 

Get a Class
    ENDPOINT -> /api/services/app/Class/Get/{Id}
    
Create a Class
    ENDPOINT -> /api/services/app/Class/Create

Update a Class
    ENDPOINT -> /api/services/app/Class/Update

Delete a Class
    ENDPOINT -> /api/services/app/Class/Delete
 */

public class HW_GET_OneClass {
	// need to fix the code with ChatGPT's idea
	
	@Test
	public void getOneClass() {
		
		RestAssured.baseURI = APIConstants.BASE_URI; //"baseURI" is provided by RestAssured
		
//		String payload = "{\n"
//				+ "  \"id\":" + APIGlobalVariables.classId + ",\n"
//				+ "  \"firstName\":" + APIGlobalVariables.firstName + ",\n"
//				+ "  \"lastName\":" + APIGlobalVariables.lastName + ",\n"
//				+ "  \"email\":" + APIGlobalVariables.email+ ",\n"
//				+ "  \"city\":" + APIGlobalVariables.city+ ",\n"
//				+ "  \"state\":" + APIGlobalVariables.state + ",\n"
//				+ "  \"studentNumber\":" + APIGlobalVariables.studentNumber + "\n"
//				+ "}";
//		
//		String payload2 = new JSONObject()
//				.put("id", APIGlobalVariables.classId)
//				.put("firstName", APIGlobalVariables.firstName)
//				.put("lastName", APIGlobalVariables.lastName)
//				.put("email", APIGlobalVariables.email)
//				.put("city", APIGlobalVariables.city)
//				.put("state", APIGlobalVariables.state)
//				.put("studentNumber", APIGlobalVariables.studentNumber)
//				.toString();
		
		Response response = RestAssured.given()
				.auth().oauth2(APIGlobalVariables.token)
				.queryParam("Id", APIGlobalVariables.classId)
				.when().get(APIConstants.GET_ONE_CLASS_ENDPOINT)
				.prettyPeek();
		
		System.out.println("----------------------------------------");
		
		// verify status code 200
		response.then().assertThat().statusCode(200);
		
		// print the content type
		System.out.println(response.header("Content-Type"));
	
	}

}
