package com.api.resources;

import com.api.POJO.Account.AccountBillingAddressPOJO;
import com.api.POJO.Account.AccountDeletePOJO;
import com.api.POJO.Account.AccountPOJO;
import com.api.POJO.Opportunity.OpportunityAttributesPOJO;
import com.api.POJO.Opportunity.OpportunityDeletePOJO;
import com.api.POJO.Opportunity.OpportunityLineItemAttributesPOJO;
import com.api.POJO.Opportunity.OpportunityLineItemsPOJO;
import com.api.POJO.Opportunity.OpportunityPOJO;
import com.api.POJO.Opportunity.OpportunityUpdatePOJO;

import java.util.ArrayList;
import java.util.List;

public class TestdataBuilder {

	public AccountPOJO addAccountPayLoad(String name, String status, String type, String accountId, String phone,
			String country, String city, String street, String postalCode, String state, String fax,
			String accountExecutive, String externalSourceSystemId, String externalSourceSystemName,
			String description) {

		AccountPOJO addAC = new AccountPOJO();
		addAC.setName(name);
		addAC.setStatus(status);
		addAC.setType(type);
		addAC.setAccountId(accountId);
		addAC.setPhone(phone);
		addAC.setFax(fax);
		addAC.setAccountExecutive(accountExecutive);
		addAC.setExternalSourceSystemId(externalSourceSystemId);
		addAC.setExternalSourceSystemName(externalSourceSystemName);
		addAC.setDescription(description);

		AccountBillingAddressPOJO billAD = new AccountBillingAddressPOJO();
		billAD.setCountry(country);
		billAD.setCity(city);
		billAD.setStreet(street);
		billAD.setPostalCode(postalCode);
		billAD.setState(state);
		addAC.setBillingAddress(billAD);

		return addAC;
	}

	public AccountDeletePOJO deleteAccountPayLoad(String type, String accountId, String externalSourceSystemId,
			String externalSourceSystemName) {
		AccountDeletePOJO deleteAC = new AccountDeletePOJO();
		deleteAC.setAccountId(accountId);
		deleteAC.setExternalSourceSystemId(externalSourceSystemId);
		deleteAC.setExternalSourceSystemName(externalSourceSystemName);
		deleteAC.setType(type);
		return deleteAC;
	}

	public OpportunityPOJO addOpportunityPayLoad(String accountExecutive, String advertiserId, int amount,
			String planClassId, String calendarId, String flightEndDate, String flightStartDate, String startPeriodId,
			String endPeriodId, String agencyId, String platform, String marketPlaceId, String channels,
			String dealYearId, boolean guaranteed, boolean equivalised, String primaryDemoId, String channelId,
			String startDate, String endDate, String lineItemId, String name, String opportunityId,
			String externalSourceSystemId, String externalSourceSystemName) {

		OpportunityPOJO addOpp = new OpportunityPOJO();
		addOpp.setAccountExecutive(accountExecutive);
		addOpp.setAdvertiserId(advertiserId);
		addOpp.setAmount(amount);
		addOpp.setName(name);
		addOpp.setOpportunityId(opportunityId);
		addOpp.setExternalSourceSystemId(externalSourceSystemId);
		addOpp.setExternalSourceSystemName(externalSourceSystemName);

		OpportunityAttributesPOJO addOppAtt = new OpportunityAttributesPOJO();
		addOppAtt.setPlanClassId(planClassId);
		addOppAtt.setCalendarId(calendarId);
		addOppAtt.setFlightEndDate(flightEndDate);
		addOppAtt.setFlightStartDate(flightStartDate);
		addOppAtt.setStartPeriodId(startPeriodId);
		addOppAtt.setEndPeriodId(endPeriodId);
		addOppAtt.setAgencyId(agencyId);
		addOppAtt.setPlatform(platform);
		addOppAtt.setMarketPlaceId(marketPlaceId);
		addOppAtt.setChannels(channels);
		addOppAtt.setDealYearId(dealYearId);
		addOppAtt.setGuaranteed(guaranteed);
		addOppAtt.setEquivalised(equivalised);
		addOppAtt.setPrimaryDemoId(primaryDemoId);
		addOpp.setAttributes(addOppAtt);

		List<OpportunityLineItemsPOJO> lineItem = new ArrayList<OpportunityLineItemsPOJO>();		
		OpportunityLineItemsPOJO addOppLI = new OpportunityLineItemsPOJO();
		addOppLI.setLineItemId(lineItemId);
		lineItem.add(addOppLI);
		addOpp.setLineItems(lineItem);

		OpportunityLineItemAttributesPOJO addOppLIAtt = new OpportunityLineItemAttributesPOJO();
		addOppLIAtt.setChannelId(channelId);
		addOppLIAtt.setStartDate(startDate);
		addOppLIAtt.setEndDate(endDate);
		addOppLI.setAttributes(addOppLIAtt);

		return addOpp;
	}

	public OpportunityUpdatePOJO updateOpportunityPayLoad(String accountExecutive, String advertiserId, int amount,
			String planClassId, String calendarId, String flightEndDate, String flightStartDate, String startPeriodId,
			String endPeriodId, String agencyId, String platform, String marketPlaceId, String channels,
			String dealYearId, boolean guaranteed, boolean equivalised, String primaryDemoId, String channelId,
			String startDate, String endDate, String lineItemId, String name, String opportunityId,
			String externalSourceSystemId, String externalSourceSystemName, String planId) {

		OpportunityUpdatePOJO updateOpp = new OpportunityUpdatePOJO();
		updateOpp.setAccountExecutive(accountExecutive);
		updateOpp.setAdvertiserId(advertiserId);
		updateOpp.setAmount(amount);
		updateOpp.setName(name);
		updateOpp.setOpportunityId(opportunityId);
		updateOpp.setExternalSourceSystemId(externalSourceSystemId);
		updateOpp.setExternalSourceSystemName(externalSourceSystemName);
		updateOpp.setPlanId(planId);

		OpportunityAttributesPOJO updateOppAtt = new OpportunityAttributesPOJO();
		updateOppAtt.setPlanClassId(planClassId);
		updateOppAtt.setCalendarId(calendarId);
		updateOppAtt.setFlightEndDate(flightEndDate);
		updateOppAtt.setFlightStartDate(flightStartDate);
		updateOppAtt.setStartPeriodId(startPeriodId);
		updateOppAtt.setEndPeriodId(endPeriodId);
		updateOppAtt.setAgencyId(agencyId);
		updateOppAtt.setPlatform(platform);
		updateOppAtt.setMarketPlaceId(marketPlaceId);
		updateOppAtt.setChannels(channels);
		updateOppAtt.setDealYearId(dealYearId);
		updateOppAtt.setGuaranteed(guaranteed);
		updateOppAtt.setEquivalised(equivalised);
		updateOppAtt.setPrimaryDemoId(primaryDemoId);
		updateOpp.setAttributes(updateOppAtt);

		List<OpportunityLineItemsPOJO> lineItem = new ArrayList<OpportunityLineItemsPOJO>();
		OpportunityLineItemsPOJO updateOppLI = new OpportunityLineItemsPOJO();
		updateOppLI.setLineItemId(lineItemId);
		lineItem.add(updateOppLI);
		updateOpp.setLineItems(lineItem);

		OpportunityLineItemAttributesPOJO updateOppLIAtt = new OpportunityLineItemAttributesPOJO();
		updateOppLIAtt.setChannelId(channelId);
		updateOppLIAtt.setStartDate(startDate);
		updateOppLIAtt.setEndDate(endDate);
		updateOppLI.setAttributes(updateOppLIAtt);

		return updateOpp;
	}

	public OpportunityDeletePOJO deleteOpportunityPayLoad(String opportunityId, String externalSourceSystemId,
			String externalSourceSystemName) {
		OpportunityDeletePOJO deleteOP = new OpportunityDeletePOJO();
		deleteOP.setOpportunityId(opportunityId);
		deleteOP.setExternalSourceSystemId(externalSourceSystemId);
		deleteOP.setExternalSourceSystemName(externalSourceSystemName);

		return deleteOP;
	}

}
