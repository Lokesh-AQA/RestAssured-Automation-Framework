package com.restassured.framework.clients;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class UserClient {

	private final RequestSpecification requestSpecification;

	public UserClient(RequestSpecification requestSpecification) {
		this.requestSpecification = requestSpecification;
	}

	// GET single user
	public Response getUser(String userId) {

		return given().spec(requestSpecification)

				.when().get("/users/{userId}", userId);
	}

	// GET all users
	public Response getUsers(int limit, int skip) {

		return given().spec(requestSpecification).queryParam("limit", limit).queryParam("skip", skip).when()
				.get("/users");
	}

	// CREATE user
	public Response createUser(Object userRequest) {

		return given().spec(requestSpecification).body(userRequest).when().post("/users/add");
	}

	// UPDATE user - PUT
	public Response updateUser(int userId, String requestBody) {

		return given().spec(requestSpecification).body(requestBody).when().put("/users/{userId}", userId);
	}

	// PARTIAL UPDATE user - PATCH
	public Response patchUser(int userId, String requestBody) {

		return given().spec(requestSpecification).body(requestBody).when().patch("/users/{userId}", userId);
	}

	// DELETE user
	public Response deleteUser(int userId) {

		return given().spec(requestSpecification).when().delete("/users/{userId}", userId);
	}
}