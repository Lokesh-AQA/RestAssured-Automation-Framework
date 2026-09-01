package com.restassured.learning;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GetUsersQueryParamTest {

	@Test
	public void getUsers() {

		// Query Parameter
		given().queryParam("limit", 10)

				// Send GET Request
				.when().get("https://dummyjson.com/users")

				// Validate Status Code
				.then().statusCode(200);
	}
}