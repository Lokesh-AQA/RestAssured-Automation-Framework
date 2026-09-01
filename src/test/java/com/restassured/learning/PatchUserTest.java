package com.restassured.learning;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PatchUserTest {

	@Test
	public void partiallyUpdateUser() {

		// Request Body
		String requestBody = """
				{
				    "firstName": "Lokesh Updated"
				}
				""";

		// Send PATCH Request
		given().header("Content-Type", "application/json").body(requestBody)

				.when().patch("https://dummyjson.com/users/2")

				// Response Validation
				.then().statusCode(200).body("firstName", equalTo("Lokesh Updated"));
	}
}