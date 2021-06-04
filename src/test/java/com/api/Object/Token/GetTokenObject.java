package com.api.Object.Token;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.api.Base.SingleTonClass;
import com.api.Object.BaseObject;
import com.api.resources.ApiResources;
import com.api.resources.TestdataBuilder;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetTokenObject extends BaseObject {

	private static GetTokenObject getToken;
	
	SingleTonClass singleton = SingleTonClass.getInstance();
	TestdataBuilder data = new TestdataBuilder();

	private GetTokenObject() {
	}

	public static final GetTokenObject getInstance() {
		if (getToken == null) {
			getToken = new GetTokenObject();
		}
		return getToken;
	}

	
	
	
	
	public RequestSpecification getRequest(String baseURL, String key, String keyValue, String logName) throws IOException {
		Map<String,String> requestHeaders = new HashMap<>();
//		requestHeaders.put("Referer","https://aos-perf-gw.operativeone.com");
//		requestHeaders.put("Accept-Language","en-US,en;q=0.9");
//		requestHeaders.put("Accept","application/json, text/plain, */*");
//		requestHeaders.put("Accept-Encoding","gzip, deflate, br");
//		requestHeaders.put("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.87 Safari/537.36");
//		requestHeaders.put("Sec-Fetch-Mode","cors");
//		requestHeaders.put("Sec-Fetch-Site","same-origin");				
//		requestHeaders.put("Origin","https://aos-perf-gw.operativeone.com");
//		requestHeaders.put("Host","aos-perf-gw.operativeone.com");
		requestHeaders.put(singleton.getProp("authorizationParam"),""); 
		requestHeaders.put(singleton.getProp("userIdParam"),singleton.getProp("userId"));
		requestHeaders.put(singleton.getProp("tenantIdParam"),singleton.getProp("tenantId"));
		
		return given().spec(requestSpecificationWithQueryParam(baseURL, key, keyValue, requestHeaders, logName));
	}

	public Response getResponse(RequestSpecification request, String resource) {
		ApiResources resourceAPI = ApiResources.valueOf(resource);
		return request.when().get(resourceAPI.getResource());
	}

	public int getStatusCode(Response response) {
		return response.getStatusCode();
	}

	public String getResponseValue(Response response, String responseKeyParameter) {
		return getJSONpathValue(response, responseKeyParameter);
	}

}
