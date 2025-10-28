package com.neotech.api.lesson04;

//API Class 4, Part-4

// we can import all static methods --- do we need them all?
// import static org.hamcrest.Matchers.*;

// or we can specifically import the methods we want to use

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.endsWith;

import org.junit.Test;

import com.neotech.utils.APIConstants;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GET_OneClass {
	
	@Test
	public void getOneClass()
	{
		
		// set the URI
		
		
		// given --> request ---> param, body, auth, headers... ---> 
		// ---> when ---> get, post, put/patch, delete --->
		// ---> then ---> assert status code, content etc.
		
		
		// set the URI
		RestAssured.baseURI = "https://neo-api.azurewebsites.net";
		
		RequestSpecification request = RestAssured.given();
		
		// setting a path parameter
		request.pathParams("id", 1091); // based on the Postman GetOneClass, SchoolAppTest
		
		// make the call
		Response response = request.when().get("/api/services/app/Class/Get/{id}");
		
		// can we write this simpler?? with directly adding the path parameter on the endpoint　
		// request.when().get("/api/services/app/Class/Get/1091") ???
		// YES!!!
		
		System.out.println("Status Line: " + response.getStatusLine());
		
		response.prettyPeek();
		System.out.println("----------------------------");
		
		// Assert using Hamcrest Matcher
		
		
		// assert the body has name Math101
		response.then().assertThat().body("result.name", equalTo("Math 101")); 
		// "result.name" from the console
		// To import, add "Matchers," before "equalTo", then you can import "hamcrest.Matchers", but you can add ".*"
		// end of the "import" line, and "static" after "import". It will be "import static org.hamcrest.Matchers.*;".
		// then you can delete "Matchers" you added before "equalTo" at first. 
		// = This way we import all methods but we do not need to import all of them so changed to
		// "import static org.hamcrest.Matchers.equalTo;"
		// We do this way because Matcher has many methods, and we do not want to use all of them. 
		
		// assert that the description contains Math
		response.then().assertThat().body("result.description", containsString("Math"));
		// added a new import line then added "containsString".
		
		// assert that the instructor email ends with neo.com
		response.then().assertThat().body("result.instructorEmail", endsWith("neo.com"));
		// added a new import line then added "endsWith".
		
		// all of the above, can be done in one long method chain.
		/*
		RestAssured.given()
		    .pathParam("Id", 1091)
		    .when().get("/api/services/app/Class/Get/{id}")
		    .prettyPeek()
		    .then().assertThat().body("result.name", equalTo("Math101"))
		    .and().assertThat().body("result.description", containsString("Math"))
		    .and().assertThat().body("result.instructorEmail", endsWith("neo.com"));
		    
		    */
		
	}
	
	@Test
	public void getOneClassShort()
	{
		RestAssured.baseURI = "https://neo-api.azurewebsites.net";
		
		RestAssured.given()
	    .pathParam("id", 1091)
	    .when().get("/api/services/app/Class/Get/{id}")
	    .prettyPeek()
	    .then().assertThat().body("result.name", equalTo("Math 101"))
	    .and().assertThat().body("result.description", containsString("Math"))
	    .and().assertThat().body("result.instructorEmail", endsWith("neo.com"));
		
		
	}

}
