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

public class UpdateOpportunityObject extends BaseObject {

	private static UpdateOpportunityObject updateOpportunity;

	SingleTonClass singleton = SingleTonClass.getInstance();
	TestdataBuilder data = new TestdataBuilder();

	private UpdateOpportunityObject() {
	}

	public static final UpdateOpportunityObject getInstance() {
		if (updateOpportunity == null) {
			updateOpportunity = new UpdateOpportunityObject();
		}
		return updateOpportunity;
	}

	public RequestSpecification updateOpportunityRequest(String auth, String baseURL, String accountExecutive,
			String advertiserId, int amount, String planClassId, String calendarId, String flightEndDate,
			String flightStartDate, String startPeriodId, String endPeriodId, String agencyId, String platform,
			String marketPlaceId, String channels, String dealYearId, boolean guaranteed, boolean equivalised,
			String primaryDemoId, String channelId, String startDate, String endDate, String lineItemId, String name,
			String opportunityId, String externalSourceSystemId, String externalSourceSystemName, String planId,
			String logName) throws IOException {

		Map<String, String> requestHeaders = new HashMap<>();
		requestHeaders.put(singleton.getProp("authorizationParam"), auth);
		requestHeaders.put(singleton.getProp("userIdParam"), singleton.getProp("userId"));
		requestHeaders.put(singleton.getProp("tenantIdParam"), singleton.getProp("tenantId"));

		return given().spec(requestSpecificationWithHeader(baseURL, requestHeaders, logName))
				.body(data.updateOpportunityPayLoad(accountExecutive, advertiserId, amount, planClassId, calendarId,
						flightEndDate, flightStartDate, startPeriodId, endPeriodId, agencyId, platform, marketPlaceId,
						channels, dealYearId, guaranteed, equivalised, primaryDemoId, channelId, startDate, endDate,
						lineItemId, name, opportunityId, externalSourceSystemId, externalSourceSystemName, planId));
	}

	public Response updateOpportunityResponse(RequestSpecification request, String resource, String customResource) {
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
