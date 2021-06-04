package com.api.Object.Account;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.api.Base.SingleTonClass;
import com.api.Object.BaseObject;
import com.api.resources.ApiResources;
import com.api.resources.TestdataBuilder;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class AddAccountObject extends BaseObject {

	private static AddAccountObject addAccount;
	
	SingleTonClass singleton = SingleTonClass.getInstance();
	TestdataBuilder data = new TestdataBuilder();

	private AddAccountObject() {
	}

	public static final AddAccountObject getInstance() {
		if (addAccount == null) {
			addAccount = new AddAccountObject();
		}
		return addAccount;
	}

	public RequestSpecification addAccountRequest(String auth, String baseURL, String name, String status, String type,
			String accountId, String phone, String country, String city, String street, String postalCode, String state,
			String fax, String accountExecutive, String externalSourceSystemId, String externalSourceSystemName,
			String description, String logName) throws IOException {

		Map<String, String> requestHeaders = new HashMap<>();
		requestHeaders.put(singleton.getProp("authorizationParam"), auth);
		requestHeaders.put(singleton.getProp("userIdParam"), singleton.getProp("userId"));
		requestHeaders.put(singleton.getProp("tenantIdParam"), singleton.getProp("tenantId"));

		return given().spec(requestSpecificationWithHeader(baseURL, requestHeaders, logName))
				.body(data.addAccountPayLoad(name, status, type, accountId, phone, country, city, street, postalCode,
						state, fax, accountExecutive, externalSourceSystemId, externalSourceSystemName, description));
	}

	public Response addAccountResponse(RequestSpecification request, String resource, String customResource) {
		ApiResources resourceAPI = ApiResources.valueOf(resource);
		return request.when().put(customResource + resourceAPI.getResource());
	}

	public int getStatusCode(Response response) {
		return response.getStatusCode();
	}

	public String getResponseValue(Response response, String responseKeyParameter) {
		return getJSONpathValue(response, responseKeyParameter);
	}

}
