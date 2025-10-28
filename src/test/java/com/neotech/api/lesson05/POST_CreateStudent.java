package com.neotech.api.lesson05;

// Lesson 05, Part-02 (20:00)

import org.junit.Test;

import com.neotech.utils.APIConstants;
import com.neotech.utils.APIGlobalVariables;

import static org.hamcrest.Matchers.equalTo;

import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class POST_CreateStudent {
	
	@Test
	public void createStudent()
	{
		
		RestAssured.baseURI = APIConstants.BASE_URI;
		
		String payload = "{\n"
				+ "  \"firstName\": \"" + APIGlobalVariables.firstName + "\",\n"
				+ "  \"lastName\": \"" + APIGlobalVariables.lastName + "\",\n"
				+ "  \"email\": \"" + APIGlobalVariables.email + "\",\n"
				+ "  \"city\": \"" + APIGlobalVariables.city + "\",\n"
				+ "  \"state\": \"" + APIGlobalVariables.state + "\",\n"
				+ "  \"studentNumber\": \"" + APIGlobalVariables.studentNumber + "\",\n"
				+ "}";
		/*
		 * 1. String payload = ""
		 * 2. Copy the whole parameters on the documentation
		Eg: {
		  "firstName": "string",
		  "lastName": "string",
		  "email": "string",
		  "city": "string",
		  "state": "string",
		  "studentNumber": "string"
		}
		3. Paste them between "" after "payload".
		4. Create variables in APIGlobalVariables
		5. Modify the code "String" part, and fixing several syntax as above.
		 */ 
		
		String payload2 = new JSONObject().put("firstName", APIGlobalVariables.firstName)
				.put("lastName", APIGlobalVariables.lastName)
				.put("email", APIGlobalVariables.email)
				.put("city", APIGlobalVariables.city)
				.put("state", APIGlobalVariables.state)
				.put("studentNumber", APIGlobalVariables.studentNumber)
				.toString();
		// We can use "payload2" instead of "payload" because the codes on "payload" seems
		// very complicated. We can use "payload2" after we copied "Maven Repository"
		// (https://mvnrepository.com/artifact/org.json/json/20250517), added into "pom.xml.
		
		RestAssured.given()
			    .auth().oauth2(APIGlobalVariables.token)
			    .body(payload2).contentType(ContentType.JSON)
			    .when().post(APIConstants.CREATE_STUDENT_ENDPOINT)
			    .prettyPeek()
			    .then().assertThat().statusCode(200)
			    .and().body("result.firstName", equalTo(APIGlobalVariables.firstName))
			    .and().body("result.email", equalTo(APIGlobalVariables.email));
	}

}
