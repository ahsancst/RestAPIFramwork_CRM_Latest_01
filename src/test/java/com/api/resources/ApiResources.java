package com.api.resources;

// enum is special class in java which has collection of constants or methods
public enum ApiResources {

	getTokenAPI("/mayiservice/tokens/user"),

	accountAPI("/accounts"),
	opportunityAPI("/opportunities");
	

	private String resource;

	private ApiResources(String resource) {
		this.resource = resource;
	}

	public String getResource() {
		return resource;
	}
}
