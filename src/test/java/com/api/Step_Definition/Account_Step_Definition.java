package com.api.Step_Definition;

import static org.testng.Assert.assertEquals;

import java.util.Random;

import com.api.Object.Account.AddAccountObject;
import com.api.Object.Account.DeleteAccountObject;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Account_Step_Definition extends BaseSD {

	String name_partial;
	static String apiKeyValue;
	static String auth;
	static String baseURI;
	static String type;

	static int randomValue;
	static String accountExecutive;
	static String externalSourceSystemId;
	static String externalSourceSystemName;
	static RequestSpecification request;
	static Response response;

	Random rand = new Random();
	AddAccountObject addAccount = AddAccountObject.getInstance();
	DeleteAccountObject deleteAccount = DeleteAccountObject.getInstance();

	@Given("^Get the create account payload with \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void get_the_create_account_payload_with_something_and_something_and_something_and_something(
			String baseURL_CRM, String columnName, String testCase, String sheetName) throws Throwable {

		initExcelSheet(sheetName);

		// Getting class variables for header parameter
		this.baseURI = getProperty(baseURL_CRM);
		this.auth = getProperty("token");
		randomValue = rand.nextInt(9999999);

		// Getting instance variables for body parameters
		String name, accountId, status, phone, country, city, street, postalCode, state, fax, description;

		this.type = getExcelValue(columnName, testCase, 0);
		name = getExcelValue(columnName, testCase, 1) + String.valueOf(randomValue);
		accountId = getExcelValue(columnName, testCase, 2) + String.valueOf(randomValue);
		status = getExcelValue(columnName, testCase, 3);
		phone = getExcelValue(columnName, testCase, 4);
		country = getExcelValue(columnName, testCase, 5);
		city = getExcelValue(columnName, testCase, 6);
		street = getExcelValue(columnName, testCase, 7);
		postalCode = getExcelValue(columnName, testCase, 8);
		state = getExcelValue(columnName, testCase, 9);
		fax = getExcelValue(columnName, testCase, 10);
		this.accountExecutive = getExcelValue(columnName, testCase, 11);
		this.externalSourceSystemId = getExcelValue(columnName, testCase, 12);
		this.externalSourceSystemName = getExcelValue(columnName, testCase, 13);
		description = getExcelValue(columnName, testCase, 14);

		// Customize the log file name for create scenarios
		String logName = testCase + "_" + "createAccount";

		// Update the account Ids into property file
		if (testCase.equalsIgnoreCase("Advertiser")) {
			updateProperty("adAccountID", accountId);
		} else if (testCase.equalsIgnoreCase("Agency")) {
			updateProperty("agAccountID", accountId);
		} else if (testCase.equalsIgnoreCase("Brand")) {
			updateProperty("brAccountID", accountId);
		} else {
			System.out.println("Given account type is not available in create table...");
		}

		// Set up the request body
		this.request = addAccount.addAccountRequest(auth, baseURI, name, status, type, accountId, phone, country, city,
				street, postalCode, state, fax, accountExecutive, externalSourceSystemId, externalSourceSystemName,
				description, logName);
	}

	@Given("^Get the update account payload with \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void get_the_update_account_payload_with_something_and_something_and_something(String baseURL,
			String columnName, String testCase) throws Throwable {

		// Getting instance variables for body parameters
		String accountId = null;
		String name, status, phone, country, city, street, postalCode, state, fax, description;

		name = getExcelValue(columnName, testCase, 15) + String.valueOf(randomValue);
		status = getExcelValue(columnName, testCase, 3);
		phone = getExcelValue(columnName, testCase, 4);
		country = getExcelValue(columnName, testCase, 5);
		city = getExcelValue(columnName, testCase, 6);
		street = getExcelValue(columnName, testCase, 7);
		postalCode = getExcelValue(columnName, testCase, 8);
		state = getExcelValue(columnName, testCase, 9);
		fax = getExcelValue(columnName, testCase, 10);
		description = getExcelValue(columnName, testCase, 14);

		// Customize the log file name for update scenarios
		String logName = testCase + "_" + "updateAccount";

		// Update the account Ids into property file
		if (testCase.equalsIgnoreCase("Advertiser")) {
			accountId = getProperty("adAccountID");
		} else if (testCase.equalsIgnoreCase("Agency")) {
			accountId = getProperty("agAccountID");
		} else if (testCase.equalsIgnoreCase("Brand")) {
			accountId = getProperty("brAccountID");
		} else {
			System.out.println("Given account type is not available in update table...");
		}

		// Set up the request body
		this.request = addAccount.addAccountRequest(auth, baseURI, name, status, type, accountId, phone, country, city,
				street, postalCode, state, fax, accountExecutive, externalSourceSystemId, externalSourceSystemName,
				description, logName);
	}

	@Given("^Get the delete account payload with \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void get_the_delete_account_payload_with_something_and_something_and_something(String baseURL,
			String columnName, String testCase) throws Throwable {

		String accountId = null;

		// Customize the log file name for delete scenarios
		String logName = testCase + "_" + "deleteAccount";

		if (testCase.equalsIgnoreCase("Advertiser")) {
			accountId = getProperty("adAccountID");
		} else if (testCase.equalsIgnoreCase("Agency")) {
			accountId = getProperty("agAccountID");
		} else if (testCase.equalsIgnoreCase("Brand")) {
			accountId = getProperty("brAccountID");
		} else {
			System.out.println("Given account type is not available in delete table..");
		}

		// Set up the request body
		this.request = deleteAccount.deleteAccountRequest(auth, baseURI, type, accountId, externalSourceSystemId,
				externalSourceSystemName, logName);
	}

	@When("^user calls \"([^\"]*)\" with PUT http account API request$")
	public void user_calls_something_with_put_http_account_api_request(String resource) throws Throwable {
		this.apiKeyValue = getProperty("apiKey");
		this.response = addAccount.addAccountResponse(request, resource, apiKeyValue);
	}

	@When("^user calls \"([^\"]*)\" with DELETE http delete account API request$")
	public void user_calls_something_with_delete_http_delete_account_api_request(String resource) throws Throwable {
		this.response = deleteAccount.deleteAccountResponse(request, resource, apiKeyValue);
	}

	@Then("^account API call got success with status code \"([^\"]*)\"$")
	public void account_api_call_got_success_with_status_code_something(String statusCode) throws Throwable {
		String expectedStatusCode = getProperty(statusCode);
		String actualStatusCode = String.valueOf(addAccount.getStatusCode(response));
		assertEquals(actualStatusCode, expectedStatusCode);
	}

	@And("^get the \"([^\"]*)\" from the \"([^\"]*)\" account API response body$")
	public void get_the_something_from_the_something_account_api_response_body(String aosAccountId, String TestCase)
			throws Throwable {
		if (TestCase.equalsIgnoreCase("Advertiser")) {
			updateProperty("adAosID", addAccount.getResponseValue(response, aosAccountId));
		} else if (TestCase.equalsIgnoreCase("Agency")) {
			updateProperty("agAosID", addAccount.getResponseValue(response, aosAccountId));
		} else if (TestCase.equalsIgnoreCase("Brand")) {
			updateProperty("brAosID", addAccount.getResponseValue(response, aosAccountId));
		} else {
			System.out.println("Given account type is not available in table..");
		}

	}

	@And("^verify the \"([^\"]*)\" from the \"([^\"]*)\" account API response body with \"([^\"]*)\"$")
	public void verify_the_something_from_the_something_account_api_response_body_with_something(String deleteMsg,
			String testCase, String expectedDeleteStatus) throws Throwable {
		if (testCase.equalsIgnoreCase("Advertiser")) {
			assertEquals(addAccount.getResponseValue(response, getProperty(deleteMsg)),
					getProperty(expectedDeleteStatus) + " " + getProperty("adAosID"));
		} else if (testCase.equalsIgnoreCase("Agency")) {
			assertEquals(addAccount.getResponseValue(response, getProperty(deleteMsg)),
					getProperty(expectedDeleteStatus) + " " + getProperty("agAosID"));
		} else if (testCase.equalsIgnoreCase("Brand")) {
			assertEquals(addAccount.getResponseValue(response, getProperty(deleteMsg)),
					getProperty(expectedDeleteStatus) + " " + getProperty("brAosID"));
		} else {
			System.out.println("Given account type is not available in table..");
		}
	}

}
