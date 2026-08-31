package com.restassured.learning;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PostUserTest {

	@Test
	public void createUser() {

		String requestBody = """
				{
				    "name": "Lokesh",
				    "job": "QA Automation Engineer"
				}
				""";

		given().header("Content-Type", "application/json").body(requestBody)

				.when().post("https://reqres.in/api/users")

				.then().statusCode(201).body("name", equalTo("Lokesh")).body("job", equalTo("QA Automation Engineer"));
	}
}