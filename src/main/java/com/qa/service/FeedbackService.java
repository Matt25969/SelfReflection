package com.qa.service;

import java.util.List;
import java.util.Map;

import com.qa.domain.Feedback;

public interface FeedbackService {

	List<Feedback> findAll();

	Feedback createFeedback(Feedback feedback);

	String deleteFeedback(Long id);

	String updateFeedback(Feedback feedback);

}