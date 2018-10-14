package com.travelport.hospitality.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RestApi {
	@JsonProperty("RestResponse")
	private RestResponse restResponse;

	public RestResponse getRestResponse() {
		return restResponse;
	}

	public void setRestResponse(RestResponse restResponse) {
		this.restResponse = restResponse;
	}

}
