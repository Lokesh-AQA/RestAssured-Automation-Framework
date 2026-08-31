package com.restassured.tests;

import org.testng.annotations.Test;

import com.restassured.framework.specifications.RequestSpecFactory;

import static io.restassured.RestAssured.*;

public class RequestSpecFactoryTest {

	@Test
	public void verifyRequestSpecification() {

		given().spec(RequestSpecFactory.create())

				.when().get("/users/2")

				.then().statusCode(200);
	}
}