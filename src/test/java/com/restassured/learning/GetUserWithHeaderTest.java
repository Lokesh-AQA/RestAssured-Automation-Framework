package com.restassured.learning;

import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class GetUserWithHeaderTest {

	@Test
	public void getUser() {

		// Request Header
		given().header("Accept", "application/json")

				// Send GET Request
				.when().get("https://dummyjson.com/users/2")

				// Response Validation
				.then().statusCode(200).header("Content-Type", containsString("application/json"));
	}
}