package com.restassured.learning;

import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.restassured.framework.models.UserRequest;

public class SerializationTest {

	@Test
	public void serializeUserRequest() throws Exception {

		// Create Request POJO
		UserRequest userRequest = new UserRequest();

		// Set Request Data
		userRequest.setFirstName("Lokesh");
		userRequest.setLastName("QA");
		userRequest.setAge(33);

		// Create Jackson ObjectMapper
		ObjectMapper objectMapper = new ObjectMapper();

		// Serialization: Java Object → JSON
		String json = objectMapper.writeValueAsString(userRequest);

		// Print Serialized JSON
		System.out.println("Serialized JSON:");
		System.out.println(json);
	}
}