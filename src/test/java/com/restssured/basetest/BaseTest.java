package com.restssured.basetest;

import org.testng.annotations.BeforeMethod;

import com.restassured.framework.specifications.RequestSpecFactory;
import com.restassured.framework.specifications.ResponseSpecFactory;

import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class BaseTest {

	protected RequestSpecification requestSpecification;

	@BeforeMethod
	public void setUp() {

		requestSpecification = RequestSpecFactory.create();
	}

	protected ResponseSpecification responseSpecification(int statusCode) {

		return ResponseSpecFactory.create(statusCode);
	}
}