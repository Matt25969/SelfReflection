package com.qa.rest;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.domain.Feedback;
import com.qa.repository.FeedbackRepository;
import com.qa.rest.FeedbackController;
import com.qa.service.FeedbackService;

@RunWith(SpringRunner.class)
@WebMvcTest(FeedbackController.class)
@AutoConfigureMockMvc
public class WebMockTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private FeedbackService service;
	
	@MockBean
	private RestTemplate restTemplate;

	private static final Feedback MOCK_FEEDBACK_1 = new Feedback(1L, "Matt", "SMART Response", "SMART Response",
			"SMART Response", "SMART Response");
	private static final Feedback MOCK_FEEDBACK_2 = new Feedback(2L, "Dev", "SMART Response", "SMART Response",
			"SMART Response", "SMART Response");

	@Test
	public void getAllTest() throws Exception {

		List<Feedback> MOCK_LIST = new ArrayList<>();
		MOCK_LIST.add(MOCK_FEEDBACK_1);
		MOCK_LIST.add(MOCK_FEEDBACK_2);

		when(service.findAll()).thenReturn(MOCK_LIST);

		mockMvc.perform(get("/getAllFeedback")).andExpect(content().string(containsString("Matty")));
	}

	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

	@Test
	public void createFeedbackTest() throws Exception {
		
		 String postValue = OBJECT_MAPPER.writeValueAsString(MOCK_FEEDBACK_1);
	 
		 doReturn(MOCK_FEEDBACK_1).when(service).createFeedback(MOCK_FEEDBACK_1);
		 
		mockMvc.perform(MockMvcRequestBuilders
                .post("/createFeedback")
                .contentType(MediaType.APPLICATION_JSON).content(postValue))
                .andExpect(status().isCreated())
                .andDo(print())
                .andReturn();
	
	}
}