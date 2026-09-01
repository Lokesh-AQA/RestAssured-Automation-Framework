package com.restassured.learning;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;

public class ExtractJSON_TestNG {

	@Test
	public void getUserResponse() {

		// Send GET Request
		Response response = given().when().get("https://dummyjson.com/users/2");

		// Extract Status Code
		int statusCode = response.getStatusCode();

		// Extract Response Values using JSONPath
		int userId = response.jsonPath().getInt("id");
		String email = response.jsonPath().getString("email");

		// Print Extracted Values
		System.out.println("Status Code: " + statusCode);
		System.out.println("User ID: " + userId);
		System.out.println("Email: " + email);

		// TestNG Validation
		assertEquals(statusCode, 200);
		assertEquals(userId, 2);
	}
}