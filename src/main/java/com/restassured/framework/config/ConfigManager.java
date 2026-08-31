package com.restassured.framework.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class ConfigManager  {

	private static final Properties PROPERTIES = new Properties();

	static {

		try (InputStream inputStream = ConfigManager.class.getClassLoader().getResourceAsStream("config.properties")) {

			if (inputStream == null) {
				throw new RuntimeException("config.properties file not found");
			}

			PROPERTIES.load(inputStream);

		} catch (IOException e) {
			throw new RuntimeException("Failed to load config.properties", e);
		}
	}

	private ConfigManager() {
		// Prevent object creation
	}

	public static String get(String key) {

		String value = PROPERTIES.getProperty(key);

		if (value == null || value.isBlank()) {
			throw new RuntimeException("Configuration property not found: " + key);
		}

		return value.trim();
	}
}