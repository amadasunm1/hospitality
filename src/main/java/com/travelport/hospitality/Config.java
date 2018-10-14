package com.travelport.hospitality;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("app")
public class Config {
	private String api;

	public String getApi() {
		return api;
	}

	public void setApi(String api) {
		this.api = api;
	}

	@Override
	public String toString() {
		return "Config [api=" + api + "]";
	}
	
}
