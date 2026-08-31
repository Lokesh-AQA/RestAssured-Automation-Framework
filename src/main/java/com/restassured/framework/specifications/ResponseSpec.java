package com.restassured.framework.specifications;

import org.hamcrest.Matchers;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

public class ResponseSpec {

	public static ResponseSpecification defaultResponseSpec(int expectedStatusCode) {

		return new ResponseSpecBuilder().expectStatusCode(expectedStatusCode)
				.expectHeader("Content-Type", Matchers.containsString("application/json")).build();
	}
}