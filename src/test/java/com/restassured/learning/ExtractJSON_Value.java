package com.restassured.learning;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class ExtractJSON_Value {

	@Test
	public void getUserResponse() {

		// Send GET Request
		Response response = given()

				.when().get("https://dummyjson.com/users/2");

		// Print Status Code
		System.out.println("Status Code: " + response.getStatusCode());

		// Print Response Body
		System.out.println("Response Body:");
		System.out.println(response.asPrettyString());

		// JSONPath Extraction
		int userId = response.jsonPath().getInt("id");
		String email = response.jsonPath().getString("email");
		String firstName = response.jsonPath().getString("firstName");

		// Print Extracted Values
		System.out.println("User ID: " + userId);
		System.out.println("Email ID: " + email);
		System.out.println("First Name: " + firstName);
	}
}