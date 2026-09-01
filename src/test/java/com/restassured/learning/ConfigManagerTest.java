package com.restassured.learning;

import org.testng.annotations.Test;

import com.restassured.framework.config.ConfigManager;

public class ConfigManagerTest {

	@Test
	public void verifyConfiguration() {

		// Read Base URL from Configuration
		System.out.println("Base URL: " + ConfigManager.get("baseUrl"));

		// Read Base Path from Configuration
		System.out.println("Base Path: " + ConfigManager.get("basePath"));

		// Read Content Type from Configuration
		System.out.println("Content Type: " + ConfigManager.get("contentType"));

		// Read Accept Header from Configuration
		System.out.println("Accept: " + ConfigManager.get("accept"));
	}
}