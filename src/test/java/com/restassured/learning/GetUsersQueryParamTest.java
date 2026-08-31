package com.restassured.learning;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GetUsersQueryParamTest {

	@Test
	public void getUsers() {

		given().queryParam("page", 2)

				.when().get("https://reqres.in/api/users")

				.then().statusCode(200);
	}
}