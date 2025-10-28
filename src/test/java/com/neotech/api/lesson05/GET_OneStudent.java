package com.neotech.api.lesson05;

import org.junit.Assert;
import org.junit.Test;

import com.neotech.utils.APIConstants;
import com.neotech.utils.APIGlobalVariables;

import io.restassured.RestAssured;
import io.restassured.response.Response;

// It seems no recorded this part between Part-1 and Part-2

public class GET_OneStudent {
	
	@Test
	public void getOneStudent() {
		
		RestAssured.baseURI = APIConstants.BASE_URI;
		
		Response response = RestAssured.given()
		    // .header("Authorization", "Bearer", + APIGlobalVariables.token)
		    // "Bearer" comes under "Authorization" in Postman.
		    .auth().oauth2(APIGlobalVariables.token)
		    .queryParam("Id", APIGlobalVariables.studentId)
		    .when().get(APIConstants.GET_ONE_STUDENT_ENDPOINT)
		    .prettyPeek();
		
		System.out.println("----------------------------------------");
		// System.out.println(response.toString()); <- this is not the one we want.
		
		// verify status code 200
		response.then().assertThat().statusCode(200);
		
		// print the content type
		System.out.println(response.header("Content-Type"));
		
		// get something from the body
		int id = response.body().jsonPath().getInt("result.id");
		System.out.println("id = " + id);
		
		// verify that the id is the same as the one we requested
		Assert.assertEquals(APIGlobalVariables.studentId, id);
		
		// response.then().assertThat().body("result.id", 
		// equalTo(APIGlobalVariables.studentId));
		
	}
	
}




