package com.restassured.learning;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GetUserTest {

	@Test
	public void getUser() {

		// GET single user
		given()

				.when().get("https://dummyjson.com/users/2")

				.then().statusCode(200);
	}
}