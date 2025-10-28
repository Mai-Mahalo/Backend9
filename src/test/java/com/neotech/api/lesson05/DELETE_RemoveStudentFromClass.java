package com.neotech.api.lesson05;

import org.junit.Test;

import com.neotech.utils.APIConstants;
import com.neotech.utils.APIGlobalVariables;

import io.restassured.RestAssured;
import static org.hamcrest.Matchers.equalTo;

// Part-05, 16:00

public class DELETE_RemoveStudentFromClass {
	
	@Test
	public void removeStudentFromClass() {
		
		RestAssured.baseURI = APIConstants.BASE_URI;
		
		RestAssured.given()
		.auth().oauth2(APIGlobalVariables.token)
		.queryParam("StudentId", APIGlobalVariables.studentId)
		.queryParam("ClassId", APIGlobalVariables.classId)
		.when()
		.delete(APIConstants.REMOVE_STUDENT_FROM_CLASS_ENDPOINT)
		.prettyPeek()
		.then()
		.assertThat()
		.statusCode(200)
		.and().body("result.action", equalTo("Remove student"))
		.and().body("result.success", equalTo(true));
		
		
		
		
		
		
	}

}
