package com.api.Step_Definition;

import static org.testng.Assert.assertEquals;

import java.util.Random;

import com.api.Object.Opportunity.AddOpportunityObject;
import com.api.Object.Opportunity.DeleteOpportunityObject;
import com.api.Object.Opportunity.UpdateOpportunityObject;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Opportunity_Step_Definition extends BaseSD {

	static String apiKeyValue;
	static String auth;
	static String baseURI;

	static int randomValue;
	static String opportunityId;
	static String externalSourceSystemId;
	static String externalSourceSystemName;
	static RequestSpecification request;
	static Response response;

	Random rand = new Random();
	AddOpportunityObject addOpportunity = AddOpportunityObject.getInstance();
	UpdateOpportunityObject updateOpportunity = UpdateOpportunityObject.getInstance();
	DeleteOpportunityObject deleteOpportunity = DeleteOpportunityObject.getInstance();

	@Given("^Get the create opportunity payload with \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void get_the_create_opportunity_payload_with_something_and_something_and_something_and_something(String baseURL_CRM,
			String columnName, String testCase, String sheetName) throws Throwable {

		initExcelSheet(sheetName);
		
		// Getting class variables for header parameter
		this.baseURI = getProperty(baseURL_CRM);
		this.auth = getProperty("token");
		this.randomValue = rand.nextInt(9999999);

		// Getting instance variables for body parameters
		String accountExecutive, advertiserId, planClassId, calendarId, flightEndDate, flightStartDate, startPeriodId,
				endPeriodId, agencyId, platform, marketPlaceId, channels, dealYearId, primaryDemoId, channelId,
				startDate, endDate, lineItemId, name;
		int amount;
		boolean guaranteed, equivalised;

		accountExecutive = getExcelValue(columnName, testCase, 1);
		advertiserId = getExcelValue(columnName, testCase, 2);
		amount = Integer.parseInt(getExcelValue(columnName, testCase, 3));
		planClassId = getExcelValue(columnName, testCase, 4);
		calendarId = getExcelValue(columnName, testCase, 5);
		flightEndDate = getExcelValue(columnName, testCase, 6);
		flightStartDate = getExcelValue(columnName, testCase, 7);
		startPeriodId = getExcelValue(columnName, testCase, 8);
		endPeriodId = getExcelValue(columnName, testCase, 9);
		agencyId = getExcelValue(columnName, testCase, 10);
		platform = getExcelValue(columnName, testCase, 11);
		marketPlaceId = getExcelValue(columnName, testCase, 12);
		channels = getExcelValue(columnName, testCase, 13);
		dealYearId = getExcelValue(columnName, testCase, 14);
		guaranteed = Boolean.parseBoolean(getExcelValue(columnName, testCase, 15));
		equivalised = Boolean.parseBoolean(getExcelValue(columnName, testCase, 16));
		primaryDemoId = getExcelValue(columnName, testCase, 17);
		channelId = getExcelValue(columnName, testCase, 18);
		startDate = getExcelValue(columnName, testCase, 19);
		endDate = getExcelValue(columnName, testCase, 20);
		lineItemId = getExcelValue(columnName, testCase, 21);
		name = getExcelValue(columnName, testCase, 22) + String.valueOf(randomValue);
		this.opportunityId = getExcelValue(columnName, testCase, 23) + String.valueOf(randomValue);
		this.externalSourceSystemId = getExcelValue(columnName, testCase, 24);
		this.externalSourceSystemName = getExcelValue(columnName, testCase, 25);

		// Customize the log file name for create scenarios
		String logName = testCase + "_" + "Opportunity";

		// Update the opportunity Id into property file
		updateProperty("opportunityID", opportunityId);

		// Set up the request body
		this.request = addOpportunity.addOpportunityRequest(auth, baseURI, accountExecutive, advertiserId, amount,
				planClassId, calendarId, flightEndDate, flightStartDate, startPeriodId, endPeriodId, agencyId, platform,
				marketPlaceId, channels, dealYearId, guaranteed, equivalised, primaryDemoId, channelId, startDate,
				endDate, lineItemId, name, opportunityId, externalSourceSystemId, externalSourceSystemName, logName);
	}

	@Given("^Get the update opportunity payload with \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void get_the_update_opportunity_payload_with_something_and_something_and_something(String baseURL_CRM,
			String columnName, String testCase) throws Throwable {

		// Getting instance variables for body parameters
		String accountExecutive, advertiserId, planClassId, calendarId, flightEndDate, flightStartDate, startPeriodId,
				endPeriodId, agencyId, platform, marketPlaceId, channels, dealYearId, primaryDemoId, channelId,
				startDate, endDate, lineItemId, name, planId;
		int amount;
		boolean guaranteed, equivalised;

		accountExecutive = getExcelValue(columnName, testCase, 1);
		advertiserId = getExcelValue(columnName, testCase, 2);
		amount = Integer.parseInt(getExcelValue(columnName, testCase, 3));
		planClassId = getExcelValue(columnName, testCase, 4);
		calendarId = getExcelValue(columnName, testCase, 5);
		flightEndDate = getExcelValue(columnName, testCase, 6);
		flightStartDate = getExcelValue(columnName, testCase, 7);
		startPeriodId = getExcelValue(columnName, testCase, 8);
		endPeriodId = getExcelValue(columnName, testCase, 9);
		agencyId = getExcelValue(columnName, testCase, 10);
		platform = getExcelValue(columnName, testCase, 11);
		marketPlaceId = getExcelValue(columnName, testCase, 12);
		channels = getExcelValue(columnName, testCase, 13);
		dealYearId = getExcelValue(columnName, testCase, 14);
		guaranteed = Boolean.parseBoolean(getExcelValue(columnName, testCase, 15));
		equivalised = Boolean.parseBoolean(getExcelValue(columnName, testCase, 16));
		primaryDemoId = getExcelValue(columnName, testCase, 17);
		channelId = getExcelValue(columnName, testCase, 18);
		startDate = getExcelValue(columnName, testCase, 19);
		endDate = getExcelValue(columnName, testCase, 20);
		lineItemId = getExcelValue(columnName, testCase, 21);
		name = getExcelValue(columnName, testCase, 22) + String.valueOf(randomValue);
		planId = getProperty("planID");

		// Customize the log file name for create scenarios
		String logName = testCase + "_" + "Opportunity";

		// Set up the request body
		this.request = updateOpportunity.updateOpportunityRequest(auth, baseURI, accountExecutive, advertiserId, amount,
				planClassId, calendarId, flightEndDate, flightStartDate, startPeriodId, endPeriodId, agencyId, platform,
				marketPlaceId, channels, dealYearId, guaranteed, equivalised, primaryDemoId, channelId, startDate,
				endDate, lineItemId, name, opportunityId, externalSourceSystemId, externalSourceSystemName, planId,
				logName);
	}

	@Given("^Get the delete opportunity payload with \"([^\"]*)\" and \"([^\"]*)\"$")
	public void get_the_delete_opportunity_payload_with_something_and_something(String baseURL_CRM, String testCase)
			throws Throwable {

		// Customize the log file name for create scenarios
		String logName = testCase + "_" + "Opportunity";

		// Set up the request body
		this.request = deleteOpportunity.deleteOpportunityRequest(auth, baseURI, opportunityId, externalSourceSystemId,
				externalSourceSystemName, logName);
	}

	
	
	@When("^user calls \"([^\"]*)\" with POST http opportunity API request$")
	public void user_calls_something_with_post_http_opportunity_api_request(String resource) throws Throwable {
		this.apiKeyValue = getProperty("apiKey");
		this.response = addOpportunity.addOpportunityResponse(request, resource, apiKeyValue);
	}

	@When("^user calls \"([^\"]*)\" with PUT http opportunity API request$")
	public void user_calls_something_with_put_http_opportunity_api_request(String resource) throws Throwable {
		this.response = updateOpportunity.updateOpportunityResponse(request, resource, apiKeyValue);
	}

	@When("^user calls \"([^\"]*)\" with DELETE http opportunity API request$")
	public void user_calls_something_with_delete_http_opportunity_api_request(String resource) throws Throwable {
		this.response = deleteOpportunity.deleteOpportunityResponse(request, resource, apiKeyValue);
	}

	
	
	
	@Then("^opportunity API call got success with status code \"([^\"]*)\"$")
	public void opportunity_api_call_got_success_with_status_code_something(String statusCode) throws Throwable {
		String expectedStatusCode = getProperty(statusCode);
		String actualStatusCode = String.valueOf(addOpportunity.getStatusCode(response));
		assertEquals(actualStatusCode, expectedStatusCode);
	}

	
	
	
	@And("^get the \"([^\"]*)\" from the opportunity API response body$")
	public void get_the_something_from_the_opportunity_api_response_body(String planId) throws Throwable {
		updateProperty("planID", addOpportunity.getResponseValue(response, planId));
	}
	
	@And("^verify the \"([^\"]*)\" as \"([^\"]*)\" from the update opportunity API response body$")
	public void verify_the_something_as_something_from_the_update_opportunity_api_response_body(
			String opportunityUpdateParam, String opportunityUpdateStatus) throws Throwable {
		String expectedStatus = getProperty(opportunityUpdateStatus);
		String actualStatus = String
				.valueOf(updateOpportunity.getResponseValue(response, getProperty(opportunityUpdateParam)));
		assertEquals(actualStatus, expectedStatus);
	}
	
	@And("^verify the \"([^\"]*)\" as \"([^\"]*)\" from the delete opportunity API response body$")
	public void verify_the_something_as_something_from_the_delete_opportunity_api_response_body(
			String opportunityDeleteParam, String opportunityDeleteStatus) throws Throwable {
		String expectedStatus = getProperty(opportunityDeleteStatus)+" "+getProperty("opportunityID");
		String actualStatus = String
				.valueOf(updateOpportunity.getResponseValue(response, getProperty(opportunityDeleteParam)));
		assertEquals(actualStatus, expectedStatus);
	}

}
