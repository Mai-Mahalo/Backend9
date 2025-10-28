package com.neotech.api.lesson05;

import org.junit.Test;

import com.neotech.utils.APIConstants;
import com.neotech.utils.APIGlobalVariables;

import io.restassured.RestAssured;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

// Part-1 (24:00)

public class GET_AllStudents {
	
	@Test
	public void getAllStudents()
	{
		RestAssured.baseURI = APIConstants.BASE_URI;
		
		RestAssured.given()
		  // .header("Authorization", "Bearer " + APIGlobalVariables.token)
		     .auth().oauth2(APIGlobalVariables.token)
		       .when().get(APIConstants.GET_ALL_STUDENTS_ENDPOINT)
		       .prettyPeek() // this is to show on the Console from the server.
		       .then().assertThat().statusCode(200)
		       .and().assertThat().body("result.totalCount", equalTo(80)) // need to add "hamcrest import" manually.
		       .and().assertThat().body("result.items.size()", is(10)); // showing only 10 students
		
		       // is = equalTo is the same.
		       // "result.totalCount" is "totalCount" is under "result" when you see the console.
		       // So far we test THREE things . "assertThat().statusCode and Total count, how many students we want to show.
		
		
		    
	}


	}


