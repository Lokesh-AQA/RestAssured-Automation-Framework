package com.restassured.learning;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;

public class ExtractJSON_TestNG {

	@Test
	public void getUserResponse() {

		Response response = given()

				.when().get("https://reqres.in/api/users/2");

		int statusCode = response.getStatusCode();

		int userId = response.jsonPath().getInt("data.id");

		String email = response.jsonPath().getString("data.email");

		System.out.println("Status Code: " + statusCode);
		System.out.println("User ID: " + userId);
		System.out.println("Email: " + email);

		assertEquals(statusCode, 200);
		assertEquals(userId, 2);
	}
}