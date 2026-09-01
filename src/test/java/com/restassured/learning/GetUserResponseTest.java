package com.restassured.learning;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class GetUserResponseTest {

	@Test
	public void getUserResponse() {

		// Send GET Request
		Response response = given()

				.when().get("https://dummyjson.com/users/2");

		// Print Complete Response
		System.out.println("Response Body:");
		System.out.println(response.asPrettyString());

		// Validate Status Code
		response.then().statusCode(200);

		// Extract Response Values using JSONPath
		int id = response.jsonPath().getInt("id");
		String firstName = response.jsonPath().getString("firstName");
		String lastName = response.jsonPath().getString("lastName");
		String email = response.jsonPath().getString("email");

		// Print Extracted Values
		System.out.println("ID: " + id);
		System.out.println("First Name: " + firstName);
		System.out.println("Last Name: " + lastName);
		System.out.println("Email: " + email);
	}
}