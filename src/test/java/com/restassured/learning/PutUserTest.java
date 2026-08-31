package com.restassured.learning;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PutUserTest {

	@Test
	public void updateUser() {

		String requestBody = """
				{
				    "name": "Lokesh Updated",
				    "job": "Senior QA Automation Engineer"
				}
				""";

		given().header("Content-Type", "application/json").body(requestBody)

				.when().put("https://reqres.in/api/users/2")

				.then().statusCode(200).body("name", equalTo("Lokesh Updated"))
				.body("job", equalTo("Senior QA Automation Engineer"));
	}
}