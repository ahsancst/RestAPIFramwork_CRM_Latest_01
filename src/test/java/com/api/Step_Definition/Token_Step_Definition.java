package com.api.Step_Definition;

import static org.testng.Assert.assertEquals;

import com.api.Object.Token.GetTokenObject;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Token_Step_Definition extends BaseSD {

	String baseURI, key, keyValue;
	static RequestSpecification request;
	static ResponseSpecification responseSpc;
	static Response response;

	GetTokenObject getToken = GetTokenObject.getInstance();

	@Given("^Get the token API payload with \"([^\"]*)\"$")
	public void get_the_token_api_payload_with_something(String baseURL) throws Throwable {

		this.baseURI = getProperty(baseURL);
		this.key = getProperty("expirationKey");
		this.keyValue = getProperty("expirationKeyValue");

		this.request = getToken.getRequest(baseURI, key, keyValue, "token");
	}

	@When("^user calls \"([^\"]*)\" with GET http token API request$")
	public void user_calls_something_with_get_http_token_api_request(String resource) throws Throwable {
		this.response = getToken.getResponse(request, resource);
	}

	@Then("^the token API call got success with status code \"([^\"]*)\"$")
	public void the_token_api_call_got_success_with_status_code_something(String statusCode) throws Throwable {
		String expectedStatusCode = getProperty(statusCode);
		String actualStatusCode = String.valueOf(getToken.getStatusCode(response));
		assertEquals(actualStatusCode, expectedStatusCode);
	}

	@And("^get the \"([^\"]*)\" and \"([^\"]*)\"$")
	public void get_the_something_and_something(String apiKey, String token) throws Throwable {
		updateProperty(apiKey, getToken.getResponseValue(response, "apiKey"));
		updateProperty(token, "Bearer " + getToken.getResponseValue(response, "token"));
	}

}
