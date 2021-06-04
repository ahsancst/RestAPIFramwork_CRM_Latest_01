package com.api.Object;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Map;

import com.api.Base.SingleTonClass;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class BaseObject {
	SingleTonClass singleton = SingleTonClass.getInstance();

	public BaseObject() {
		singleton.getSetUp();
	}

	public static RequestSpecification genralReq;
	public static ResponseSpecification genralRes;

	/*
	 * This is how we are logging the request and response
	 * 
	 * PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
	 * .addFilter(RequestLoggingFilter.logRequestTo(log))
	 * .addFilter(ResponseLoggingFilter.logResponseTo(log))
	 * 
	 */

	// 01. General request specification functionality
	public RequestSpecification requestSpecification(String baseURL, String logName) throws IOException {
		genralReq = null;
		if (genralReq == null) {
			PrintStream log = new PrintStream(new FileOutputStream("CRM_Logs/CRM" + logName + "_log.txt"));

			genralReq = new RequestSpecBuilder().setBaseUri(baseURL).setContentType(ContentType.JSON)
					.addFilter(RequestLoggingFilter.logRequestTo(log))
					.addFilter(ResponseLoggingFilter.logResponseTo(log)).build();
			return genralReq;
		}
		return genralReq;
	}
	
	// 02. General request specification functionality with header
	public RequestSpecification requestSpecificationWithHeader(String baseURL, Map<String, String> requestHeaders,
			String logName) throws IOException {
		genralReq = null;
		if (genralReq == null) {
			PrintStream log = new PrintStream(new FileOutputStream("CRM_Logs/CRM" + logName + "_log.txt"));

			genralReq = new RequestSpecBuilder().setBaseUri(baseURL).addHeaders(requestHeaders)
					.setContentType(ContentType.JSON).addFilter(RequestLoggingFilter.logRequestTo(log))
					.addFilter(ResponseLoggingFilter.logResponseTo(log)).build();
			return genralReq;
		}
		return genralReq;
	}
			
			
			
	// 03. General request specification functionality with single query parameter
	public RequestSpecification requestSpecificationWithQueryParam(String baseURL, String key, String keyValue,
			Map<String, String> requestHeaders, String logName) throws IOException {
		genralReq = null;
		if (genralReq == null) {
			PrintStream log = new PrintStream(new FileOutputStream("CRM_Logs/CRM" + logName + "_log.txt"));

			genralReq = new RequestSpecBuilder().setBaseUri(baseURL).addQueryParam(key, keyValue)
					.addHeaders(requestHeaders).setContentType(ContentType.JSON)
					.addFilter(RequestLoggingFilter.logRequestTo(log))
					.addFilter(ResponseLoggingFilter.logResponseTo(log)).build();
			return genralReq;
		}
		return genralReq;
	}
	
	
		
	// 04. General request specification functionality with single path parameter
	public RequestSpecification requestSpecificationWithPathParam(String baseURL, String key, String keyValue,
			Map<String, String> requestHeaders) throws IOException {
		genralReq = null;
		if (genralReq == null) {
			PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));

			genralReq = new RequestSpecBuilder().setBaseUri(baseURL).addPathParam(key, keyValue)
					.addHeaders(requestHeaders).setContentType(ContentType.JSON)
					.addFilter(RequestLoggingFilter.logRequestTo(log))
					.addFilter(ResponseLoggingFilter.logResponseTo(log)).build();

			return genralReq;
		}
		return genralReq;
	}

	// 05. General request specification functionality with multiple query parameter
	/*Need to add following map in step definition class
	 * Map<String, String> params = new HashMap<String, String>();
	 * params.put("param1", "value1");
	 *  params.put("param2", "value2");
	 */
	public RequestSpecification requestSpecificationMultipleQueryParam(String baseURL, Map<String, String> parameters)
			throws IOException {
		genralReq = null;
		if (genralReq == null) {
			PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));

			genralReq = new RequestSpecBuilder().setBaseUri(baseURL).addQueryParams(parameters)
					.setContentType(ContentType.JSON).addFilter(RequestLoggingFilter.logRequestTo(log))
					.addFilter(ResponseLoggingFilter.logResponseTo(log)).build();

			return genralReq;
		}
		return genralReq;
	}

	
	
	// General response specification functionality
	public ResponseSpecification responseSpecification() throws IOException {
		genralRes = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		return genralRes;
	}

	
	// Get JSON path values
	public String getJSONpathValue(Response response, String key) {
		String resp = response.asString();
		JsonPath js = new JsonPath(resp);
		return js.get(key).toString();
	}

	// Get JSON path values from array list
	public String getJSONpathFromArray(Response response, String key) {
		String paramValue = null;
		String resp = response.asString();
		JsonPath js = new JsonPath(resp);

		int resultCount = js.getInt("array.size()");
		for (int i = 0; i < resultCount; i++) {
			paramValue = js.get("" + key + "[" + i + "]").toString();
			break;
		}
		return paramValue;
	}

}
