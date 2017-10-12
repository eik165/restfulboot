package com.practice.api.Example1.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/services")
public class HelloWorldController {

	
	
	
	//@Produces({  MediaType.APPLICATION_JSON })
	@RequestMapping(value = "/greetings",  method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public ResponseEntity<?> getProducts() {
		
		System.out.println("greetings called ...");
		
		List<String> productList = new ArrayList<String>();
		productList.add("Modems");
		productList.add("Mouse");
		productList.add("Keyboards");
		//return productList;
		return new ResponseEntity<List<String>>(productList, HttpStatus.OK);
	}
	
	
	
	@RequestMapping(value = "/welcome", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<?> welcome() {
		
		//return "welcome";
		return new ResponseEntity<String>("welcome", HttpStatus.OK);	
		}
}
