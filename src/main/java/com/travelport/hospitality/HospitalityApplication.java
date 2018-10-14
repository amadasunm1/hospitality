package com.travelport.hospitality;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

import com.travelport.hospitality.model.RestApi;

@SpringBootApplication
@ComponentScan("com.travelport.hospitality") 
public class HospitalityApplication {
	@Autowired
	Config config;

	public static void main(String[] args) {
		SpringApplication.run(HospitalityApplication.class, args);
	}
	
	@Bean
	public RestApi restApiTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		RestApi restApi = restTemplate.getForObject(config.getApi(), RestApi.class);
	    return restApi;
	}
}
