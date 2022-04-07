package com.microservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.entity.ManagementEntity;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/microservice-api")
public class ManagementController {
	
	@Autowired
	RestTemplateBuilder restTemplateBuilder;
	
	@GetMapping("/get-all")
	public List<ManagementEntity> getAll() {
		List<ManagementEntity> responseEntity = new ArrayList<ManagementEntity>();
		responseEntity = (List<ManagementEntity>) restTemplateBuilder.build().getForObject("http://localhost:8088/employee/api/employees", List.class);

	
		//creating a new response bean and getting the response back and taking it into Bean
		return responseEntity;
	}

}
