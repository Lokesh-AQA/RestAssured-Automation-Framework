package com.restassured.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import com.restassured.framework.clients.UserClient;
import com.restassured.framework.models.UserRequest;
import com.restassured.framework.models.UserResponse;
import com.restassured.basetest.BaseTest;

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

		Response response = userClient.getUser("2");

		assertEquals(response.getStatusCode(), 200);

		System.out.println(response.asPrettyString());

		String firstName = response.jsonPath().getString("firstName");
		String email = response.jsonPath().getString("email");
		int id = response.jsonPath().getInt("id");

		System.out.println("First Name: " + firstName);
		System.out.println("Email: " + email);
		System.out.println("ID: " + id);

		assertEquals(firstName, "Terry");
		assertEquals(email, "terry@example.com");
		assertEquals(id, 2);
	}

	@Test
	public void validateUserResponseWithHamcrest() {

		Response response = userClient.getUser("2");

		response.then().statusCode(200).header("Content-Type", containsString("application/json"))
				.body("data.first_name", equalTo("Janet")).body("data.email", equalTo("janet.weaver@reqres.in"))
				.body("data.email", notNullValue()).body("data.email", containsString("@reqres.in"))
				.body("data.id", equalTo(2)).body("data.id", greaterThan(0));
	}

	@Test
	public void getUsers() {

		Response response = userClient.getUsers(10, 0);

		assertEquals(response.getStatusCode(), 200);

	}

	@Test
	public void createUser() {

		// POJO Setup
		UserRequest userRequest = new UserRequest();

		userRequest.setFirstName("Lokesh");
		userRequest.setLastName("QA");
		userRequest.setAge(33);

		// Execution: Serialize POJO and Send POST Request
		Response response = userClient.createUser(userRequest);

		System.out.println(response.asPrettyString());

		// Hamcrest Validation: Verify HTTP Status Code
		assertThat(response.getStatusCode(), equalTo(201));

		// JSONPath Extraction: Extract ID from Response
		int userId = response.jsonPath().getInt("id");

		System.out.println("Created User ID: " + userId);

		// Deserialization: Convert JSON Response to Java Object
		UserResponse userResponse = response.as(UserResponse.class);

		// Reading Response POJO Values using Getters
		System.out.println("ID: " + userResponse.getId());
		System.out.println("First Name: " + userResponse.getFirstName());
		System.out.println("Last Name: " + userResponse.getLastName());
		System.out.println("Age: " + userResponse.getAge());

		// Hamcrest Validation: Verify Response Data
		assertThat(userResponse.getId(), greaterThan(0));
		assertThat(userResponse.getFirstName(), equalTo("Lokesh"));
		assertThat(userResponse.getLastName(), equalTo("QA"));
		assertThat(userResponse.getAge(), equalTo(33));
	}

	@Test
	public void createUserAndGetUser() {

		// STEP 1: Create User

		UserRequest userRequest = new UserRequest();

		userRequest.setFirstName("Lokesh");
		userRequest.setLastName("QA");
		userRequest.setAge(33);

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