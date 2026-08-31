package com.restassured.tests;

import org.testng.annotations.Test;

import com.restassured.framework.models.UserRequest;

public class UserRequestTest {

	@Test
	public void createUserRequestObject() {

		UserRequest userRequest = new UserRequest();

		userRequest.setName("Lokesh");
		userRequest.setJob("QA Automation Engineer");

		System.out.println("Name: " + userRequest.getName());
		System.out.println("Job: " + userRequest.getJob());
	}
}