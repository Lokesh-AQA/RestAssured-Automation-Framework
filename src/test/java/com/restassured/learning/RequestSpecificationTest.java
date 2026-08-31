package com.restassured.learning;

import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class RequestSpecificationTest {

	@Test
	public void getUser() {

		RequestSpecification requestSpec = new RequestSpecBuilder().setBaseUri("https://reqres.in").setBasePath("/api")
				.addHeader("Accept", "application/json").build();

		given().spec(requestSpec)

				.when().get("/users/2")

				.then().statusCode(200).body("data.id", equalTo(2));
	}
}