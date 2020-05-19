package com.restassuredconcept;

import org.json.simple.JSONObject;
import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PutMethodConcept {

	@Test
	void TC_1() {
		RestAssured.baseURI = "https://reqres.in/api/users";
		RequestSpecification httprequest = RestAssured.given();
		
		JSONObject parameters = new JSONObject();
		parameters.put("name", "morpheus");
		parameters.put("job", "resident");
		
		httprequest.header("Content-Type","application/json");
		
		Response response = httprequest.request(Method.PUT, "");
		

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
		
		String responseheader = response.header("content-type");
		System.out.println(responseheader);
		Assert.assertEquals("application/json; charset=utf-8", responseheader);
		
		String server = response.header("server");
		System.out.println(server);
		Assert.assertEquals("cloudflare", server);
	}
}
