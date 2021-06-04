package com.api.Object.Opportunity;

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

public class AddOpportunityObject extends BaseObject {

	private static AddOpportunityObject addOpportunity;
	
	SingleTonClass singleton = SingleTonClass.getInstance();
	TestdataBuilder data = new TestdataBuilder();

	private AddOpportunityObject() {
	}

	public static final AddOpportunityObject getInstance() {
		if (addOpportunity == null) {
			addOpportunity = new AddOpportunityObject();
		}
		return addOpportunity;
	}

	public RequestSpecification addOpportunityRequest(String auth, String baseURL, String accountExecutive, String advertiserId, int amount,
			String planClassId, String calendarId, String flightEndDate, String flightStartDate, String startPeriodId,
			String endPeriodId, String agencyId, String platform, String marketPlaceId, String channels, String dealYearId,
			boolean guaranteed, boolean equivalised, String primaryDemoId, String channelId, String startDate,
			String endDate, String lineItemId, String name, String opportunityId, String externalSourceSystemId,
			String externalSourceSystemName, String logName) throws IOException {

		Map<String, String> requestHeaders = new HashMap<>();
		requestHeaders.put(singleton.getProp("authorizationParam"),auth); 
		requestHeaders.put(singleton.getProp("userIdParam"),singleton.getProp("userId"));
		requestHeaders.put(singleton.getProp("tenantIdParam"),singleton.getProp("tenantId"));

		return given().spec(requestSpecificationWithHeader(baseURL, requestHeaders, logName))
				.body(data.addOpportunityPayLoad(accountExecutive, advertiserId, amount, planClassId, calendarId,
						flightEndDate, flightStartDate, startPeriodId, endPeriodId, agencyId, platform, marketPlaceId,
						channels, dealYearId, guaranteed, equivalised, primaryDemoId, channelId, startDate, endDate,
						lineItemId, name, opportunityId, externalSourceSystemId, externalSourceSystemName));
	}

	public Response addOpportunityResponse(RequestSpecification request, String resource, String customResource) {
		ApiResources resourceAPI = ApiResources.valueOf(resource);
		return request.when().post(customResource+resourceAPI.getResource());
	}

	public int getStatusCode(Response response) {
		return response.getStatusCode();
	}

	public String getResponseValue(Response response, String responseKeyParameter) {
		return getJSONpathValue(response, responseKeyParameter);
	}

}
