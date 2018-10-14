package com.travelport.hospitality.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.travelport.hospitality.model.RestApi;
import com.travelport.hospitality.service.StateService;

@RestController
@RequestMapping("travelport")
public class HospitalityController {

	@Autowired
	private StateService stateService;

	@GetMapping("/state")
	public RestApi getStates(@RequestParam(value = "name", required = false) String[] stateNames) {
		return stateService.getStates(stateNames);
	}

	@GetMapping("/state/{stateName}")
	public RestApi getState(@PathVariable("stateName") String stateName){
		return stateService.getState(stateName);
	}

}
