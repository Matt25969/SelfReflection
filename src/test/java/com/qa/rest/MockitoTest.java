package com.qa.rest;

import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.qa.domain.Feedback;
import com.qa.service.FeedbackService;

@RunWith(SpringRunner.class)

public class MockitoTest {

	@InjectMocks
	FeedbackController controller;

	@Mock
	FeedbackService service;

	@Mock
	RestTemplate restTemp;

	private static final Feedback MOCK_FEEDBACK_1 = new Feedback(1L, "Matt", "SMART Response", "SMART Response",
			"SMART Response", "SMART Response");
	private static final Feedback MOCK_FEEDBACK_2 = new Feedback(2L, "Dev", "SMART Response", "SMART Response",
			"SMART Response", "SMART Response");
	private static final String MOCK_DELETE_RESPONSE = "Feedback Successfully deledted";

	@Test
	public void getFeedbackTest() {
		List<Feedback> MOCK_LIST = new ArrayList<>();
		MOCK_LIST.add(MOCK_FEEDBACK_1);
		MOCK_LIST.add(MOCK_FEEDBACK_2);
		Mockito.when(service.findAll()).thenReturn(MOCK_LIST);
		assertEquals(MOCK_LIST, controller.getAllFeedback());
		Mockito.verify(service).findAll();
	}

	@Test
	public void deleteFeedbackTest() {
		Mockito.when(service.deleteFeedback(1L)).thenReturn(MOCK_DELETE_RESPONSE);
		assertEquals(MOCK_DELETE_RESPONSE, controller.deleteFeedback(1L));
		Mockito.verify(service).deleteFeedback(1L);
	}

	@Test
	public void updateFeedbackTest() {
		Mockito.when(service.updateFeedback(MOCK_FEEDBACK_1)).thenReturn(MOCK_FEEDBACK_1.toString());

		assertEquals(MOCK_FEEDBACK_1.toString(), controller.updateFeedback(MOCK_FEEDBACK_1));
		Mockito.verify(service).updateFeedback(MOCK_FEEDBACK_1);
	}

	@Test
	public void createFeedbackTest() {

		Mockito.when(service.createFeedback(MOCK_FEEDBACK_1)).thenReturn(MOCK_FEEDBACK_1);

		assertEquals(MOCK_FEEDBACK_1, controller.createFeedback(MOCK_FEEDBACK_1).getBody());
		Mockito.verify(service).createFeedback(MOCK_FEEDBACK_1);
	}

}