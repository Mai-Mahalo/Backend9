package com.neotech.api.lesson05;

import org.junit.Assert;

// Lesson 05, Part-02 (20:00)

import org.junit.Test;

import com.neotech.utils.APIConstants;
import com.neotech.utils.APIGlobalVariables;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;



public class PUT_UpdateStudent {
	
	@Test
	public void updateStudent() {
		
		RestAssured.baseURI = APIConstants.BASE_URI;
		
		String payload = "{\n"
				+ "  \"id\": 1358,\n"
				+ "  \"firstName\": \"Joel\",\n"
				+ "  \"lastName\": \"Salvalai\",\n"
				+ "  \"email\": \"joel@neo.com\",\n"
				+ "  \"city\": \"NY City\",\n"
				+ "  \"state\": \"NY\",\n"
				+ "  \"studentNumber\": \"NEO12345\"\n"
				+ "}";
		

		Response response = RestAssured.given()
			    .auth().oauth2(APIGlobalVariables.token)
			    .body(payload).contentType(ContentType.JSON)
			    .when()
			    .put(APIConstants.UPDATE_STUDENT_ENDPOINT)
			    .prettyPeek();
		
		// verify status code 200
		response.then().assertThat().statusCode(200);
		
		// get the id from the body
		int id = response.body().jsonPath().getInt("result.id");
		
		// verify that the id is the same as the one we updated
		Assert.assertEquals(id, APIGlobalVariables.studentId);
		
		// negative test 
		// verify that the response does not include the old city
		Assert.assertFalse(response.body().jsonPath().getString("result").contains(APIGlobalVariables.city));
		
		
		
			    
			  
	}

}
