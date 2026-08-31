package com.restassured.learning;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class GetUserResponseTest {

	@Test
	public void getUserResponse() {

		Response response = given()

				.when().get("https://reqres.in/api/users/2");

		System.out.println("Status Code: " + response.getStatusCode());
		System.out.println("Response Body: " + response.asPrettyString());
	}
}