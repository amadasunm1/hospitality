package com.travelport.hospitality.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import com.travelport.hospitality.Config;
import com.travelport.hospitality.exceptions.JsonParsingException;
import com.travelport.hospitality.exceptions.StateNotFoundException;
import com.travelport.hospitality.model.RestApi;
import com.travelport.hospitality.model.RestResponse;
import com.travelport.hospitality.model.State;

@Service
public class StateService {
	@Autowired
	Config config;

	@Autowired
	RestApi restApi;

	public RestApi getStates(String[] states) {
		if (states != null) {
			return buildResult(Arrays.asList(states));
		} else {
			return buildResult(null);
		}
	}

	public RestApi getState(String stateName) {
		return buildResult(Arrays.asList(stateName));
	}

	public RestApi buildResult(List<String> stateNames) {
		try {
			ObjectMapper om = new ObjectMapper();

			// Transform JSON object to JSON string and query the string using JSONPath.
			String json = om.writeValueAsString(restApi);
			RestResponse restResponse = queryState(json, stateNames);

			// Return RestApi object to validate our rest Integration Tests.
			RestApi restApi = new RestApi();
			restApi.setRestResponse(restResponse);
			return restApi;
		} catch (JsonProcessingException e) {
			throw new JsonParsingException("Unable to transform JSON");
		}
	}

	public RestResponse queryState(String json, List<String> stateNames) {
		RestResponse restResponse = new RestResponse();
		List<State> states = new ArrayList<State>();
		List<String> messages = new ArrayList<String>();

		if (stateNames != null && !stateNames.isEmpty()) {
			for (String stateName : stateNames) {
				stateName = stateName.substring(0, 1).toUpperCase() + stateName.substring(1);
				List<State> temp = JsonPath.read(json, "$..result[?(@.name == '" + stateName + "')]");

				if (temp != null && !temp.isEmpty()) {
					states.addAll(temp);
					messages.add("Found state " + stateName);
				} else {
					throw new StateNotFoundException(String.format("State(%s) is not a valid state", stateName));
				}
			}
		} else {
			// Return all states
			List<State> temp = JsonPath.read(json, "$..result[*]");

			if (temp != null && !temp.isEmpty()) {
				states.addAll(temp);
				messages.add("Retrieved all states!");
			}
		}

		restResponse.setMessages(messages);
		restResponse.setResult(states);
		return restResponse;
	}
}
