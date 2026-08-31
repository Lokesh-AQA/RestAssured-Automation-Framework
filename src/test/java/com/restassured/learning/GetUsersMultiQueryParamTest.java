package com.restassured.learning;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GetUsersMultiQueryParamTest {

	@Test
	public void getUsers() {

		given().queryParam("page", 2).queryParam("limit", 10)

				.when().get("https://reqres.in/api/users")

				.then().statusCode(200);
	}
}