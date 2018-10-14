package com.travelport.hospitality;

import static io.restassured.RestAssured.get;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import io.restassured.RestAssured;


@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(classes = HospitalityApplication.class) 
@TestPropertySource(value={"classpath:application.properties"})
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class HospitalityRestControllerTest {

    @Value("${server.port}") 
    int port;
	
	@Test
	public void getAllStates() {
		get("/travelport/state").then().assertThat()
			.statusCode(200);
	}

	@Test
	public void getState() {
		get("/travelport/state/Alabama").then().assertThat().statusCode(200);
	}

	@Test
	public void getNStates() {
		get("/travelport/state?name=Alabama&name=Georgia").then().assertThat()
				.statusCode(200);
		get("/travelport/state?name=Alabama&name=Georgika").then().assertThat()
		.statusCode(404);
	}
	
    @Before
    public void setBaseUri () {
            RestAssured.port = port;
            RestAssured.baseURI = "http://localhost"; // replace as appropriate
    }

}
