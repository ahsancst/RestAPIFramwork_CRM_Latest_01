package com.api.Object.Account;

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

public class DeleteAccountObject extends BaseObject {

	private static DeleteAccountObject deleteAccount;
	
	SingleTonClass singleton = SingleTonClass.getInstance();
	TestdataBuilder data = new TestdataBuilder();

	private DeleteAccountObject() {
	}

	public static final DeleteAccountObject getInstance() {
		if (deleteAccount == null) {
			deleteAccount = new DeleteAccountObject();
		}
		return deleteAccount;
	}

	public RequestSpecification deleteAccountRequest(String auth, String baseURL,
			String type, String accountId, String externalSourceSystemId, String externalSourceSystemName, String logName)
			throws IOException {

		Map<String, String> requestHeaders = new HashMap<>();
		requestHeaders.put(singleton.getProp("authorizationParam"),auth); 
		requestHeaders.put(singleton.getProp("userIdParam"),singleton.getProp("userId"));
		requestHeaders.put(singleton.getProp("tenantIdParam"),singleton.getProp("tenantId"));

		return given().spec(requestSpecificationWithHeader(baseURL, requestHeaders, logName))
				.body(data.deleteAccountPayLoad(type, accountId, externalSourceSystemId, externalSourceSystemName));
	}

	public Response deleteAccountResponse(RequestSpecification request, String resource, String customResource) {
		ApiResources resourceAPI = ApiResources.valueOf(resource);
		return request.when().delete(customResource+resourceAPI.getResource());
	}

	public int getStatusCode(Response response) {
		return response.getStatusCode();
	}

	public String getResponseValue(Response response, String responseKeyParameter) {
		return getJSONpathValue(response, responseKeyParameter);
	}

}
