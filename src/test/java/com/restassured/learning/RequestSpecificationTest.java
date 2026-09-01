package com.restassured.learning;

import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class RequestSpecificationTest {

	@Test
	public void getUser() {

		// Create Request Specification
		RequestSpecification requestSpec = new RequestSpecBuilder().setBaseUri("https://dummyjson.com")
				.addHeader("Accept", "application/json").build();

		// Send GET Request using Request Specification
		given().spec(requestSpec)

				.when().get("/users/2")

				// Response Validation
				.then().statusCode(200).body("id", equalTo(2));
	}
}