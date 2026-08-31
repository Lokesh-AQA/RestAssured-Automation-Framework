package com.restassured.learning;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class GetUserWithHeaderTest {

	@Test
	public void getUser() {

		given().header("Accept", "application/json")

				.when().get("https://reqres.in/api/users/2")

				.then().statusCode(200)
				.header("Accept", notNullValue());
	}
}