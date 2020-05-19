package com.restassuredconcept;

import org.json.simple.JSONObject;
import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetMethodConcept {

	@Test
	void TC_1() {
		RestAssured.baseURI = "https://reqres.in/api/users?page=2";
		RequestSpecification httprequest = RestAssured.given();
		Response response = httprequest.request(Method.GET, "");

		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200);

		String body = response.getBody().asString();
		System.out.println(body);

		String statusLine = response.getStatusLine();
		System.out.println(statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");

		double time = response.getTime();
		System.out.println(time);
		if(time < 2000) {
			System.out.println("Response is in-time");
		}
		else {
			System.out.println("Response is out of time");
		}

	}
}
