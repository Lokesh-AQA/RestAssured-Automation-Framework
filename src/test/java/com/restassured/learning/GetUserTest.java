package com.restassured.learning;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GetUserTest {

	@Test
	public void getUser() {

		given()

				.when().get("https://reqres.in/api/users/2")

				.then().statusCode(200);
	}
}