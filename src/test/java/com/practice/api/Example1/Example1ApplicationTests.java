package com.practice.api.Example1;

import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import io.restassured.response.Response;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.apache.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Example1ApplicationTests {
	 private ObjectMapper objectMapper;

	 
	    @Before
	    public void setUp() throws Exception {
	        objectMapper = new ObjectMapper();
	    }

	@Test
	public void contextLoads() throws JsonProcessingException {
	
		List<String> productList = new ArrayList<String>();
		productList.add("Modems");
		productList.add("Mouse");
		productList.add("Keyboards");


	
    // When
    Response actual = given()
            .header("Accept", "application/json").and()
            .header("Content-Type", "application/json").and()
            .header("CAMToken", "sampleToken").and()
            .header("jsessionid", "sessionId1").and()
            .when()
            .get("/services/greetings")
            .then().extract().response();

    assertThat(actual.statusCode()).isEqualTo(HttpStatus.SC_OK);
    assertThat(actual.body().asString()).isEqualTo(objectMapper.writeValueAsString(productList));
    
}
	
	
}
