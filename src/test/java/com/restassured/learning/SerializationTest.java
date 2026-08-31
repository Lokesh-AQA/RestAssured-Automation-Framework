package com.restassured.learning;

import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.restassured.framework.models.UserRequest;

public class SerializationTest {

	@Test
	public void serializeUserRequest() throws Exception {

		UserRequest userRequest = new UserRequest();

		userRequest.setName("Lokesh");
		userRequest.setJob("QA Automation Engineer");

		ObjectMapper objectMapper = new ObjectMapper();

		String json = objectMapper.writeValueAsString(userRequest);

		System.out.println("Serialized JSON:");
		System.out.println(json);
	}
}