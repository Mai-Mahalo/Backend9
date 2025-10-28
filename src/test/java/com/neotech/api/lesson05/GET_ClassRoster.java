package com.neotech.api.lesson05;

import org.junit.Test;

import com.neotech.utils.APIConstants;
import com.neotech.utils.APIGlobalVariables;

import io.restassured.RestAssured;
import static org.hamcrest.Matchers.*;


// Part-05, 31:00

public class GET_ClassRoster {
	
	@Test
	public void getClassRoster() {
		
		RestAssured.baseURI = APIConstants.BASE_URI;
		
		RestAssured.given()
		.auth().oauth2(APIGlobalVariables.token)
		.queryParam("classId", APIGlobalVariables.classId)
		.when().get(APIConstants.GET_CLASS_ROSTER_ENDPOINT)
		.prettyPeek()
		.then().assertThat().statusCode(200)
		.and().body("result.students.size()",greaterThan(0))
		.and().body("result.studentCount", greaterThan(0));
		
		// "greaterThan" = if studentCount/size is 0, it would fail.

		
	}

}
