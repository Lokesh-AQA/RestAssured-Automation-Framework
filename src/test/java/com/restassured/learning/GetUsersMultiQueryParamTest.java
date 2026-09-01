package com.restassured.learning;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GetUsersMultiQueryParamTest {

	@Test
	public void getUsers() {

		// Multiple Query Parameters
		given().queryParam("limit", 10).queryParam("skip", 10)

				// Send GET Request
				.when().get("https://dummyjson.com/users")

				// Validate Status Code
				.then().statusCode(200);
	}
}