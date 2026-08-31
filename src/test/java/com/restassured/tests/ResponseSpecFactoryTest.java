package com.restassured.tests;

import org.testng.annotations.Test;

import com.restassured.framework.specifications.RequestSpecFactory;
import com.restassured.framework.specifications.ResponseSpecFactory;

import static io.restassured.RestAssured.*;

public class ResponseSpecFactoryTest {

	@Test
	public void verifyResponseSpecification() {

		given().spec(RequestSpecFactory.create())

				.when().get("/users/2")

				.then().spec(ResponseSpecFactory.create(200));
	}
}