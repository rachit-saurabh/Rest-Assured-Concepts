package com.restassuredconcept;

import org.json.simple.JSONObject;
import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class POSTMethodConcept {

	@Test
	void TC_1() {
		RestAssured.baseURI = "https://reqres.in/api/users";
		RequestSpecification httprequest = RestAssured.given();
		
		JSONObject parameters = new JSONObject();
		parameters.put("name", "morpheus");
		parameters.put("job", "leader");
		
		httprequest.header("Content-Type","application/json");
		
		Response response = httprequest.request(Method.POST, "");
		

		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 201);

		String body = response.getBody().asString();
		System.out.println(body);

		String statusLine = response.getStatusLine();
		System.out.println(statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 201 Created");

		double time = response.getTime();
		System.out.println(time);

	}
}
