package com.restssured.basetest;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GetUserBaseTest extends BaseTest {

	@Test
	public void getUser() {

		given().spec(requestSpecification)

				.when().get("/users/2")

				.then().spec(responseSpecification(200));
	}
}