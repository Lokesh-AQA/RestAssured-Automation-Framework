package com.restassured.learning;

import org.testng.annotations.Test;

import com.restassured.framework.config.ConfigManager;

public class ConfigManagerTest {

	@Test
	public void verifyConfiguration() {

		System.out.println("Base URL: " + ConfigManager.get("baseUrl"));

		System.out.println("Base Path: " + ConfigManager.get("basePath"));

		System.out.println("Content Type: " + ConfigManager.get("contentType"));

		System.out.println("Accept: " + ConfigManager.get("accept"));
	}
}