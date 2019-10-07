package com.qa.service;


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
import org.springframework.boot.test.web.client.TestRestTemplate;

import com.qa.domain.Feedback;
import com.qa.repository.FeedbackRepository;
import com.qa.rest.FeedbackController;
import com.qa.service.FeedbackService;

import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
public class MockitoTest {

	@InjectMocks
	FeedbackServiceImpl service;
	
	@Mock
	FeedbackRepository repo;
	
	private static final Feedback MOCK_FEEDBACK_1 = new Feedback(1L, "Matt", "SMART Response", "SMART Response",
			"SMART Response", "SMART Response");
	private static final Feedback MOCK_FEEDBACK_2 = new Feedback(2L, "Dev", "SMART Response", "SMART Response",
			"SMART Response", "SMART Response");
	
	
	@Test
	
	public void findAllTest() {
		List<Feedback> MOCK_LIST = new ArrayList<>();
		MOCK_LIST.add(MOCK_FEEDBACK_1);
		MOCK_LIST.add(MOCK_FEEDBACK_2);
		Mockito.when(repo.findAll()).thenReturn(MOCK_LIST);
		assertEquals(MOCK_LIST, service.findAll());
		Mockito.verify(repo).findAll();
	}

	@Test
	
	public void createFeedbackTest() {

		Mockito.when(repo.save(MOCK_FEEDBACK_1)).thenReturn(MOCK_FEEDBACK_1);

		assertEquals(MOCK_FEEDBACK_1, service.createFeedback(MOCK_FEEDBACK_1));
		Mockito.verify(repo).save(MOCK_FEEDBACK_1);
	}
	
}