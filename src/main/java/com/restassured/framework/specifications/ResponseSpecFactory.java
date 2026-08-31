package com.restassured.framework.specifications;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

public final class ResponseSpecFactory {

	private ResponseSpecFactory() {
		// Prevent object creation
	}

	public static ResponseSpecification create(int expectedStatusCode) {

		return new ResponseSpecBuilder().expectStatusCode(expectedStatusCode).build();
	}
}