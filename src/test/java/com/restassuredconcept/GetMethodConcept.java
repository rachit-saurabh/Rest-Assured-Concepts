package com.restassuredconcept;

import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetMethodConcept {

	@Test
	void TC_1() {
		// Base URL
		RestAssured.baseURI = "https://reqres.in/api/users";

		// HTTP Request
		RequestSpecification httprequest = RestAssured.given();

		// Response
		Response response = httprequest.request(Method.GET, "?page=2");

		// Status Code Verification
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200);

		// Body of the response
		String body = response.getBody().asString();
		System.out.println(body);

		// Status Line Verification
		String statusLine = response.getStatusLine();
		System.out.println(statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");

		double time = response.getTime();
		System.out.println(time);
		if (time < 2000) {
			System.out.println("Response is in-time");
		} else {
			System.out.println("Response is out of time");
		}

	}
}
