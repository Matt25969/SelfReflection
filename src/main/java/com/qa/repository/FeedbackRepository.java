package com.qa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.domain.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Long>  {


}