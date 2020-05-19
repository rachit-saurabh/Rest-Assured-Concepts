package com.restassuredconcept;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetNodesConcept {

	
	@Test
	public void Getmethod() {
		
		RestAssured.baseURI = "https://reqres.in/api/users";
		RequestSpecification httprequest = RestAssured.given();
		Response response = httprequest.request(Method.GET, "?page=2");
		
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200);
		
		JsonPath jsonpath = response.jsonPath();
		System.out.println(jsonpath.getString("per_page"));
		System.out.println(jsonpath.getString("total"));
		System.out.println(jsonpath.getString("total_pages"));
		
		String body = response.getBody().asString();
		System.out.println(body);
	}
}
