package com.restassured.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import com.restassured.framework.clients.UserClient;
import com.restassured.framework.models.UserRequest;
import com.restassured.framework.models.UserResponse;
import com.restssured.basetest.BaseTest;

import io.restassured.response.Response;

import static org.testng.Assert.assertEquals;

public class UserClientTest extends BaseTest {

	private UserClient userClient;

	@BeforeMethod
	public void initializeClient() {

		userClient = new UserClient(requestSpecification);
	}

	@Test
	public void getUser() {
		// TestNG + JSONPath
		Response response = userClient.getUser("2");

		assertEquals(response.getStatusCode(), 200);

		System.out.println(response.asPrettyString());

		String firstName = response.jsonPath().getString("data.first_name");
		String email = response.jsonPath().getString("data.email");
		int id = response.jsonPath().getInt("data.id");

		System.out.println("First Name: " + firstName);
		System.out.println("email : " + email);
		System.out.println("ID: " + id);

		assertEquals(firstName, "Janet");
		assertEquals(email, "janet.weaver@reqres.in");
		assertEquals(id, 2);
	}

	@Test
	public void validateUserResponseWithHamcrest() {

	    Response response = userClient.getUser("2");

	    response.then()
	            .statusCode(200)
	            .header("Content-Type", containsString("application/json"))
	            .body("data.first_name", equalTo("Janet"))
	            .body("data.email", equalTo("janet.weaver@reqres.in"))
	            .body("data.email", notNullValue())
	            .body("data.email", containsString("@reqres.in"))
	            .body("data.id", equalTo(2))
	            .body("data.id", greaterThan(0));
	}

	@Test
	public void getUsers() {

		Response response = userClient.getUsers(2);

		assertEquals(response.getStatusCode(), 200);

	}

	@Test
	public void createUser() {

		// POJO Setup
		UserRequest userRequest = new UserRequest();

		userRequest.setName("Lokesh");
		userRequest.setJob("QA Automation Engineer");

		// Execution Happen and Complete
		Response response = userClient.createUser(userRequest);

		System.out.println(response.asPrettyString());

		// Hamcrest Validation
		assertThat(response.getStatusCode(), equalTo(201));

		// Printing Nested JSON Specific Value from JSON Response
		String PoweredBy = response.jsonPath().getString("_meta.powered_by");
		System.out.println("Power By: " + PoweredBy);

		// Converting JSON Response to Java Object using Deserialization Technique
		UserResponse userResponse = response.as(UserResponse.class);

		// Printing the specific value from Java Object Response (Java Beans Setter &
		// Getter)
		System.out.println("Name: " + userResponse.getName());
		System.out.println("Job: " + userResponse.getJob());
		System.out.println("ID: " + userResponse.getId());

		// Hamcrest Validation
		assertThat(userResponse.getName(), equalTo("Lokesh"));
		assertThat(userResponse.getJob(), equalTo("QA Automation Engineer"));
		assertThat(userResponse.getId(), notNullValue());

		System.out.println("Created At: " + userResponse.getCreatedAt());

		System.out.println("Powered By: " + userResponse.get_meta().getPowered_by());

		System.out.println("Message: " + userResponse.get_meta().getMessage());

		System.out.println("Context: " + userResponse.get_meta().getContext());

		System.out.println("CTA Label: " + userResponse.get_meta().getCta().getLabel());

		System.out.println("CTA URL: " + userResponse.get_meta().getCta().getUrl());

		assertEquals(response.getStatusCode(), 201);

		assertThat(response.getStatusCode(), equalTo(201));
	}

	@Test
	public void createUserAndGetUser() {

		// STEP 1: Create User

		UserRequest userRequest = new UserRequest();

		userRequest.setName("Lokesh");
		userRequest.setJob("QA Automation Engineer");

		Response createResponse = userClient.createUser(userRequest);

		assertEquals(createResponse.getStatusCode(), 201);

		// STEP 2: Extract ID from response

		String userId = createResponse.jsonPath().getString("id");

		System.out.println("Created User ID: " + userId);

		// STEP 3: Use the ID in another API

		Response getResponse = userClient.getUser(userId);

		System.out.println("GET Response:");
		System.out.println(getResponse.asPrettyString());

		assertEquals(getResponse.getStatusCode(), 200);
	}

	@Test
	public void updateUser() {

		String requestBody = """
				{
				    "name": "Lokesh Updated",
				    "job": "Senior QA Engineer"
				}
				""";

		Response response = userClient.updateUser(2, requestBody);

		assertEquals(response.getStatusCode(), 200);
	}

	@Test
	public void patchUser() {

		String requestBody = """
				{
				    "job": "Lead QA Engineer"
				}
				""";

		Response response = userClient.patchUser(2, requestBody);

		assertEquals(response.getStatusCode(), 200);
	}

	@Test
	public void deleteUser() {

		Response response = userClient.deleteUser(2);

		assertEquals(response.getStatusCode(), 204);
	}
}