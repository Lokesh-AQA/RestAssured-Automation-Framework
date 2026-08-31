package com.restassured.framework.specifications;

import com.restassured.framework.config.ConfigManager;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public final class RequestSpecFactory {

	private RequestSpecFactory() {
		// Prevent object creation
	}

	public static RequestSpecification create() {

		return new RequestSpecBuilder().setBaseUri(ConfigManager.get("baseUrl"))
				.setBasePath(ConfigManager.get("basePath")).setContentType(ConfigManager.get("contentType"))
				.setAccept(ConfigManager.get("accept")).build();
	}
}