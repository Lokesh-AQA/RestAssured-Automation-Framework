package com.restassured.learning;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DeleteUserTest {

	@Test
	public void deleteUser() {

		// Send DELETE Request
		given()

				.when().delete("https://dummyjson.com/users/2")

				// Response Validation
				.then().statusCode(200);
	}
}