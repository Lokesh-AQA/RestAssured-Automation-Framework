package com.restassured.learning;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GetUserWithPathParamTest {

	@Test
	public void getUser() {

		int userId = 2;

		given().pathParam("userId", userId)

				.when().get("https://reqres.in/api/users/{userId}")

				.then().statusCode(200);
	}
}