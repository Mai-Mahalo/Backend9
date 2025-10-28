package com.neotech.api.lesson05;

import org.json.JSONObject;
import org.junit.Test;

import com.neotech.utils.APIConstants;
import com.neotech.utils.APIGlobalVariables;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.*;

// Part-05

public class POST_AddStudentToClass {
	
	@Test
	public void addStudentToClass() {
		
		RestAssured.baseURI = APIConstants.BASE_URI;
		
		String payload = "{\n"
				+ "  \"studentId\":" + APIGlobalVariables.studentId + ",\n"
				+ "  \"classId\":" + APIGlobalVariables.classId + "\r\n"
				+ "}";
		
		String payload2 = new JSONObject()
				.put("studentId", APIGlobalVariables.studentId)
				.put("classId", APIGlobalVariables.classId)
				.toString();
		
		RestAssured.given()
		.auth().oauth2(APIGlobalVariables.token)
		.body(payload).contentType(ContentType.JSON)
		.when()
		.post(APIConstants.ADD_STUDENT_TO_CLASS_ENDPOINT)
		.prettyPeek()
		.then().assertThat().statusCode(200)
		.and().body("result.action", equalTo("Add student"))
		.and().body("result.success", equalTo(true));
	}

}
