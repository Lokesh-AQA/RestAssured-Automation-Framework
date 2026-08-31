package com.restassured.learning;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DeleteUserTest {

	@Test
	public void deleteUser() {

		given()

				.when().delete("https://reqres.in/api/users/2")

				.then().statusCode(204);
	}
}