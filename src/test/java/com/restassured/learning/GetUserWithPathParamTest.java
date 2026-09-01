package com.restassured.learning;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GetUserWithPathParamTest {

	@Test
	public void getUser() {

		// Path Parameter Value
		int userId = 2;

		// Send GET Request with Path Parameter
		given().pathParam("userId", userId)

				.when().get("https://dummyjson.com/users/{userId}")

				// Validate Status Code
				.then().statusCode(200);
	}
}