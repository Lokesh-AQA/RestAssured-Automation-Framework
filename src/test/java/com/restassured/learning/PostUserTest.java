package com.restassured.learning;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PostUserTest {

	@Test
	public void createUser() {

		// Request Body
		String requestBody = """
				{
				    "firstName": "Lokesh",
				    "lastName": "QA",
				    "age": 33
				}
				""";

		// Send POST Request
		given().header("Content-Type", "application/json").body(requestBody)

				.when().post("https://dummyjson.com/users/add")

				// Response Validation
				.then().statusCode(201).body("firstName", equalTo("Lokesh")).body("lastName", equalTo("QA"))
				.body("age", equalTo(33));
	}
}