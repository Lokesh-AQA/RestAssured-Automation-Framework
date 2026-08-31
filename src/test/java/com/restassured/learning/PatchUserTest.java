package com.restassured.learning;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PatchUserTest {

	@Test
	public void partiallyUpdateUser() {

		String requestBody = """
				{
				    "job": "Lead QA Engineer"
				}
				""";

		given().header("Content-Type", "application/json").body(requestBody)

				.when().patch("https://reqres.in/api/users/2")

				.then().statusCode(200).body("job", equalTo("Lead QA Engineer"));
	}
}