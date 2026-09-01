package com.restassured.tests;

import org.testng.annotations.Test;

import com.restassured.framework.models.UserRequest;

public class UserRequestTest {

	@Test
	public void createUserRequestObject() {

		// Create Request POJO
		UserRequest userRequest = new UserRequest();

		// Set Request Data
		userRequest.setFirstName("Lokesh");
		userRequest.setLastName("QA");
		userRequest.setAge(33);

		// Read Request Data using Getters
		System.out.println("First Name: " + userRequest.getFirstName());
		System.out.println("Last Name: " + userRequest.getLastName());
		System.out.println("Age: " + userRequest.getAge());
	}
}