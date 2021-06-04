package com.api.POJO.Opportunity;

import java.util.List;

public class OpportunityPOJO {

	private String accountExecutive;
	private String advertiserId;
	private int amount;

	private OpportunityAttributesPOJO attributes;

	private List<OpportunityLineItemsPOJO> lineItems;

	private String name;
	private String opportunityId;
	private String externalSourceSystemId;
	private String externalSourceSystemName;
	
	
	

	public String getAccountExecutive() {
		return accountExecutive;
	}

	public void setAccountExecutive(String accountExecutive) {
		this.accountExecutive = accountExecutive;
	}

	public String getAdvertiserId() {
		return advertiserId;
	}

	public void setAdvertiserId(String advertiserId) {
		this.advertiserId = advertiserId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public OpportunityAttributesPOJO getAttributes() {
		return attributes;
	}

	public void setAttributes(OpportunityAttributesPOJO attributes) {
		this.attributes = attributes;
	}

	public List<OpportunityLineItemsPOJO> getLineItems() {
		return lineItems;
	}

	public void setLineItems(List<OpportunityLineItemsPOJO> lineItems) {
		this.lineItems = lineItems;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOpportunityId() {
		return opportunityId;
	}

	public void setOpportunityId(String opportunityId) {
		this.opportunityId = opportunityId;
	}

	public String getExternalSourceSystemId() {
		return externalSourceSystemId;
	}

	public void setExternalSourceSystemId(String externalSourceSystemId) {
		this.externalSourceSystemId = externalSourceSystemId;
	}

	public String getExternalSourceSystemName() {
		return externalSourceSystemName;
	}

	public void setExternalSourceSystemName(String externalSourceSystemName) {
		this.externalSourceSystemName = externalSourceSystemName;
	}

}
