package com.qa.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.qa.domain.Feedback;
import com.qa.service.FeedbackService;

@RestController
public class FeedbackController {
	@Autowired
	public FeedbackController(FeedbackService service, RestTemplate restTemplate) {
		this.service = service;
		this.restTemplate = restTemplate;
	}

	public FeedbackController() {
		// TODO Auto-generated constructor stub
	}

	public FeedbackService service;

	private RestTemplate restTemplate;

	@RequestMapping("/testEndPoint")
	public String testEndPoint() {
		return "HelloWorld";
	}

	@RequestMapping("/getAllFeedback")
	public List<Feedback> getAllFeedback() {

		return service.findAll();
	}

	@PostMapping(value = "/createFeedback")
	public ResponseEntity<Feedback> createFeedback(@RequestBody Feedback feedback) {
		Feedback retVal = service.createFeedback(feedback);
		return new ResponseEntity<>(retVal, HttpStatus.CREATED);
	}

	@RequestMapping("/deleteFeedback/{id}")
	public String deleteFeedback(@PathVariable(value = "id") Long id) {
		System.out.println(id);
		return service.deleteFeedback(id);

	}

	@RequestMapping("/updateFeedback")
	public String updateFeedback(@RequestBody Feedback feedback) {
		return service.updateFeedback(feedback);

	}

}
