package com.api.POJO.Account;

public class AccountPOJO {

	
	private String name;
	private String status;
	private String type;
	private String accountId;
	private String phone;
	
	private AccountAttributesPOJO attributes;
	private AccountBillingAddressPOJO billingAddress;
	
	private String fax;
	private String accountExecutive;
	private String externalSourceSystemId;
	private String externalSourceSystemName;
	private String description;
	
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public AccountAttributesPOJO getAttributes() {
		return attributes;
	}
	public void setAttributes(AccountAttributesPOJO attributes) {
		this.attributes = attributes;
	}
	public AccountBillingAddressPOJO getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(AccountBillingAddressPOJO billingAddress) {
		this.billingAddress = billingAddress;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getAccountExecutive() {
		return accountExecutive;
	}
	public void setAccountExecutive(String accountExecutive) {
		this.accountExecutive = accountExecutive;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
		
	
}
