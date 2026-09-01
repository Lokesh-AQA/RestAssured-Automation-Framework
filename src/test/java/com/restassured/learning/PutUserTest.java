package com.restassured.learning;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PutUserTest {

	@Test
	public void updateUser() {

		// Request Body
		String requestBody = """
				{
				    "firstName": "Lokesh Updated",
				    "lastName": "QA Automation Engineer",
				    "age": 33
				}
				""";

		// Send PUT Request
		given().header("Content-Type", "application/json").body(requestBody)

				.when().put("https://dummyjson.com/users/2")

				// Response Validation
				.then().statusCode(200).body("firstName", equalTo("Lokesh Updated"))
				.body("lastName", equalTo("QA Automation Engineer")).body("age", equalTo(33));
	}
}