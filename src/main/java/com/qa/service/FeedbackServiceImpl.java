package com.qa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qa.domain.Feedback;
import com.qa.repository.FeedbackRepository;

@Component
public class FeedbackServiceImpl implements FeedbackService {

	private FeedbackRepository feedbackRepository;

	public FeedbackServiceImpl() {

	}

	@Autowired
	public FeedbackServiceImpl(FeedbackRepository feedbackRepository) {
		this.feedbackRepository = feedbackRepository;
	}

	@Override
	public List<Feedback> findAll() {
		return feedbackRepository.findAll();
	}

	@Override
	public Feedback createFeedback(Feedback feedback) {
		return feedbackRepository.save(feedback);

	}

	@Override
	public String updateFeedback(Feedback feedback) {

//		feedbackRepository.deleteById(feedback.getId());

		feedbackRepository.save(feedback);

		return feedback.toString();
	}

	public String deleteFeedback(Long id) {
		feedbackRepository.deleteById(id);
		return "Feedback Successfully deleted";
	}

}
