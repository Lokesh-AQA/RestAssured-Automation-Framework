package com.restassured.learning;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class ExtractJSON_Value {

    @Test
    public void getUserResponse() {

        Response response =
                given()

                .when()
                    .get("https://reqres.in/api/users/2");

        System.out.println("Status Code: " + response.getStatusCode());

        System.out.println("Response Body:");
        System.out.println(response.asPrettyString());

        int userId1 = response.jsonPath().getInt("data.id");
        String userId2 = response.jsonPath().getString("data.email");
        String userId3 = response.jsonPath().getString("data.first_name");

        System.out.println("User ID: " + userId1);
        System.out.println("Email ID: "+ userId2);
        System.out.println("First_Name "+ userId3);
    }
}